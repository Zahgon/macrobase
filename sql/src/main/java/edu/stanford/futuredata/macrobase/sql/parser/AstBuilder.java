/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.stanford.futuredata.macrobase.sql.parser;

import static java.lang.String.format;
import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toList;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import edu.stanford.futuredata.macrobase.SqlBaseBaseVisitor;
import edu.stanford.futuredata.macrobase.SqlBaseLexer;
import edu.stanford.futuredata.macrobase.SqlBaseParser;
import edu.stanford.futuredata.macrobase.sql.tree.Aggregate;
import edu.stanford.futuredata.macrobase.sql.tree.AggregateExpression;
import edu.stanford.futuredata.macrobase.sql.tree.AliasedRelation;
import edu.stanford.futuredata.macrobase.sql.tree.AllColumns;
import edu.stanford.futuredata.macrobase.sql.tree.ArithmeticBinaryExpression;
import edu.stanford.futuredata.macrobase.sql.tree.ArithmeticUnaryExpression;
import edu.stanford.futuredata.macrobase.sql.tree.BinaryLiteral;
import edu.stanford.futuredata.macrobase.sql.tree.BooleanLiteral;
import edu.stanford.futuredata.macrobase.sql.tree.CharLiteral;
import edu.stanford.futuredata.macrobase.sql.tree.ColumnDefinition;
import edu.stanford.futuredata.macrobase.sql.tree.ComparisonExpression;
import edu.stanford.futuredata.macrobase.sql.tree.ComparisonExpressionType;
import edu.stanford.futuredata.macrobase.sql.tree.DecimalLiteral;
import edu.stanford.futuredata.macrobase.sql.tree.DelimiterClause;
import edu.stanford.futuredata.macrobase.sql.tree.DereferenceExpression;
import edu.stanford.futuredata.macrobase.sql.tree.DiffQuerySpecification;
import edu.stanford.futuredata.macrobase.sql.tree.DoubleLiteral;
import edu.stanford.futuredata.macrobase.sql.tree.ExistsPredicate;
import edu.stanford.futuredata.macrobase.sql.tree.ExportClause;
import edu.stanford.futuredata.macrobase.sql.tree.Expression;
import edu.stanford.futuredata.macrobase.sql.tree.FunctionCall;
import edu.stanford.futuredata.macrobase.sql.tree.GenericLiteral;
import edu.stanford.futuredata.macrobase.sql.tree.Identifier;
import edu.stanford.futuredata.macrobase.sql.tree.ImportCsv;
import edu.stanford.futuredata.macrobase.sql.tree.IntLiteral;
import edu.stanford.futuredata.macrobase.sql.tree.IsNotNullPredicate;
import edu.stanford.futuredata.macrobase.sql.tree.IsNullPredicate;
import edu.stanford.futuredata.macrobase.sql.tree.Join;
import edu.stanford.futuredata.macrobase.sql.tree.JoinCriteria;
import edu.stanford.futuredata.macrobase.sql.tree.JoinOn;
import edu.stanford.futuredata.macrobase.sql.tree.JoinUsing;
import edu.stanford.futuredata.macrobase.sql.tree.LikePredicate;
import edu.stanford.futuredata.macrobase.sql.tree.LogicalBinaryExpression;
import edu.stanford.futuredata.macrobase.sql.tree.MinRatioExpression;
import edu.stanford.futuredata.macrobase.sql.tree.MinSupportExpression;
import edu.stanford.futuredata.macrobase.sql.tree.NaturalJoin;
import edu.stanford.futuredata.macrobase.sql.tree.Node;
import edu.stanford.futuredata.macrobase.sql.tree.NodeLocation;
import edu.stanford.futuredata.macrobase.sql.tree.NotExpression;
import edu.stanford.futuredata.macrobase.sql.tree.NullLiteral;
import edu.stanford.futuredata.macrobase.sql.tree.OrderBy;
import edu.stanford.futuredata.macrobase.sql.tree.QualifiedName;
import edu.stanford.futuredata.macrobase.sql.tree.QuantifiedComparisonExpression;
import edu.stanford.futuredata.macrobase.sql.tree.Query;
import edu.stanford.futuredata.macrobase.sql.tree.QueryBody;
import edu.stanford.futuredata.macrobase.sql.tree.QuerySpecification;
import edu.stanford.futuredata.macrobase.sql.tree.RatioMetricExpression;
import edu.stanford.futuredata.macrobase.sql.tree.Relation;
import edu.stanford.futuredata.macrobase.sql.tree.Select;
import edu.stanford.futuredata.macrobase.sql.tree.SelectItem;
import edu.stanford.futuredata.macrobase.sql.tree.SingleColumn;
import edu.stanford.futuredata.macrobase.sql.tree.SortItem;
import edu.stanford.futuredata.macrobase.sql.tree.SplitQuery;
import edu.stanford.futuredata.macrobase.sql.tree.StringLiteral;
import edu.stanford.futuredata.macrobase.sql.tree.SubqueryExpression;
import edu.stanford.futuredata.macrobase.sql.tree.Table;
import edu.stanford.futuredata.macrobase.sql.tree.TableSubquery;
import edu.stanford.futuredata.macrobase.sql.tree.WhenClause;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Portions of this copied from Facebook's presto-parser (https://github.com/prestodb/presto/tree/master/presto-parser);
 * any new AST type defined in the SqlBase.g4 ANTLR file should be added to this file as follows:
 * <code>
 *     @Override
 *     public Node visitNewAstType(SqlBaseParser.NewAstTypeContext context) {
 *          return new NewAstType(node, context);
 *     }
 * </code>
 * Parts of this file that were modified from the original file are marked below
 * by "Modified from original" comment; new code is marked by "New".
 * Otherwise, the code has simply been copy-pasted.
 */
class AstBuilder extends SqlBaseBaseVisitor<Node> {

    @Override
    public Node visitSingleStatement(SqlBaseParser.SingleStatementContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Node visitSingleExpression(SqlBaseParser.SingleExpressionContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // ********************** query expressions ********************
    // Modified from original
    @Override
    public Node visitQuery(SqlBaseParser.QueryContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // New
    // Import CSVs into SQL
    @Override
    public Node visitImportCsv(SqlBaseParser.ImportCsvContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // New
    // Exporting queries to CSVs
    @Override
    public Node visitExportClause(SqlBaseParser.ExportClauseContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // New
    @Override
    public Node visitDelimiterClause(SqlBaseParser.DelimiterClauseContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * ** Begin DIFF query *****
     */
    // New
    @Override
    public Node visitAggregate(SqlBaseParser.AggregateContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // New
    @Override
    public Node visitAggregateExpression(SqlBaseParser.AggregateExpressionContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // New
    @Override
    public Node visitMinRatioExpression(SqlBaseParser.MinRatioExpressionContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // New
    @Override
    public Node visitMinSupportExpression(SqlBaseParser.MinSupportExpressionContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // New
    @Override
    public Node visitRatioMetricExpression(SqlBaseParser.RatioMetricExpressionContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // New
    @Override
    public Node visitSplitQuery(SqlBaseParser.SplitQueryContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // New
    @Override
    public Node visitDiffQuerySpecification(SqlBaseParser.DiffQuerySpecificationContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * ** End DIFF query *****
     */
    // Modified from original
    @Override
    public Node visitQuerySpecification(SqlBaseParser.QuerySpecificationContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Node visitSelectAll(SqlBaseParser.SelectAllContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Node visitSelectSingle(SqlBaseParser.SelectSingleContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Node visitTable(SqlBaseParser.TableContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Node visitSubquery(SqlBaseParser.SubqueryContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // ***************** boolean expressions ******************
    @Override
    public Node visitLogicalNot(SqlBaseParser.LogicalNotContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Node visitLogicalBinary(SqlBaseParser.LogicalBinaryContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // *************** from clause *****************
    @Override
    public Node visitJoinRelation(SqlBaseParser.JoinRelationContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Node visitAliasedRelation(SqlBaseParser.AliasedRelationContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Node visitTableName(SqlBaseParser.TableNameContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Node visitSubqueryRelation(SqlBaseParser.SubqueryRelationContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Node visitParenthesizedRelation(SqlBaseParser.ParenthesizedRelationContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // ********************* predicates *******************
    @Override
    public Node visitPredicated(SqlBaseParser.PredicatedContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Node visitComparison(SqlBaseParser.ComparisonContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Node visitDistinctFrom(SqlBaseParser.DistinctFromContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Node visitNullPredicate(SqlBaseParser.NullPredicateContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Node visitLike(SqlBaseParser.LikeContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Node visitExists(SqlBaseParser.ExistsContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Node visitQuantifiedComparison(SqlBaseParser.QuantifiedComparisonContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // ************** value expressions **************
    @Override
    public Node visitArithmeticUnary(SqlBaseParser.ArithmeticUnaryContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Node visitArithmeticBinary(SqlBaseParser.ArithmeticBinaryContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Node visitConcatenation(SqlBaseParser.ConcatenationContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // ********************* primary expressions **********************
    @Override
    public Node visitParenthesizedExpression(SqlBaseParser.ParenthesizedExpressionContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Node visitSubqueryExpression(SqlBaseParser.SubqueryExpressionContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Node visitDereference(SqlBaseParser.DereferenceContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Node visitColumnReference(SqlBaseParser.ColumnReferenceContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Node visitWhenClause(SqlBaseParser.WhenClauseContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // Modified from original
    @Override
    public Node visitFunctionCall(SqlBaseParser.FunctionCallContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Node visitFilter(SqlBaseParser.FilterContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Node visitColumnDefinition(SqlBaseParser.ColumnDefinitionContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Node visitSortItem(SqlBaseParser.SortItemContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Node visitUnquotedIdentifier(SqlBaseParser.UnquotedIdentifierContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // ************** literals **************
    @Override
    public Node visitNullLiteral(SqlBaseParser.NullLiteralContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Node visitBasicStringLiteral(SqlBaseParser.BasicStringLiteralContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Node visitUnicodeStringLiteral(SqlBaseParser.UnicodeStringLiteralContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Node visitBinaryLiteral(SqlBaseParser.BinaryLiteralContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Node visitTypeConstructor(SqlBaseParser.TypeConstructorContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Node visitIntegerLiteral(SqlBaseParser.IntegerLiteralContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Node visitDecimalLiteral(SqlBaseParser.DecimalLiteralContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Node visitBooleanValue(SqlBaseParser.BooleanValueContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // ***************** helpers *****************
    @Override
    protected Node defaultResult() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected Node aggregateResult(Node aggregate, Node nextResult) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private enum UnicodeDecodeState {

        EMPTY, ESCAPED, UNICODE_SEQUENCE
    }

    private static String decodeUnicodeLiteral(SqlBaseParser.UnicodeStringLiteralContext context) {
        char escape;
        if (context.UESCAPE() != null) {
            String escapeString = unquote(context.STRING().getText());
            check(!escapeString.isEmpty(), "Empty Unicode escape character", context);
            check(escapeString.length() == 1, "Invalid Unicode escape character: " + escapeString, context);
            escape = escapeString.charAt(0);
            check(isValidUnicodeEscape(escape), "Invalid Unicode escape character: " + escapeString, context);
        } else {
            escape = '\\';
        }
        String rawContent = unquote(context.UNICODE_STRING().getText().substring(2));
        StringBuilder unicodeStringBuilder = new StringBuilder();
        StringBuilder escapedCharacterBuilder = new StringBuilder();
        int charactersNeeded = 0;
        UnicodeDecodeState state = UnicodeDecodeState.EMPTY;
        for (int i = 0; i < rawContent.length(); i++) {
            char ch = rawContent.charAt(i);
            switch(state) {
                case EMPTY:
                    if (ch == escape) {
                        state = UnicodeDecodeState.ESCAPED;
                    } else {
                        unicodeStringBuilder.append(ch);
                    }
                    break;
                case ESCAPED:
                    if (ch == escape) {
                        unicodeStringBuilder.append(escape);
                        state = UnicodeDecodeState.EMPTY;
                    } else if (ch == '+') {
                        state = UnicodeDecodeState.UNICODE_SEQUENCE;
                        charactersNeeded = 6;
                    } else if (isHexDigit(ch)) {
                        state = UnicodeDecodeState.UNICODE_SEQUENCE;
                        charactersNeeded = 4;
                        escapedCharacterBuilder.append(ch);
                    } else {
                        throw parseError("Invalid hexadecimal digit: " + ch, context);
                    }
                    break;
                case UNICODE_SEQUENCE:
                    check(isHexDigit(ch), "Incomplete escape sequence: " + escapedCharacterBuilder.toString(), context);
                    escapedCharacterBuilder.append(ch);
                    if (charactersNeeded == escapedCharacterBuilder.length()) {
                        String currentEscapedCode = escapedCharacterBuilder.toString();
                        escapedCharacterBuilder.setLength(0);
                        int codePoint = Integer.parseInt(currentEscapedCode, 16);
                        check(Character.isValidCodePoint(codePoint), "Invalid escaped character: " + currentEscapedCode, context);
                        if (Character.isSupplementaryCodePoint(codePoint)) {
                            unicodeStringBuilder.appendCodePoint(codePoint);
                        } else {
                            char currentCodePoint = (char) codePoint;
                            check(!Character.isSurrogate(currentCodePoint), format("Invalid escaped character: %s. Escaped character is a surrogate. Use '\\+123456' instead.", currentEscapedCode), context);
                            unicodeStringBuilder.append(currentCodePoint);
                        }
                        state = UnicodeDecodeState.EMPTY;
                        charactersNeeded = -1;
                    } else {
                        check(charactersNeeded > escapedCharacterBuilder.length(), "Unexpected escape sequence length: " + escapedCharacterBuilder.length(), context);
                    }
                    break;
                default:
                    throw new UnsupportedOperationException();
            }
        }
        check(state == UnicodeDecodeState.EMPTY, "Incomplete escape sequence: " + escapedCharacterBuilder.toString(), context);
        return unicodeStringBuilder.toString();
    }

    private <T> Optional<T> visitIfPresent(ParserRuleContext context, Class<T> clazz) {
        return Optional.ofNullable(context).map(this::visit).map(clazz::cast);
    }

    private <T> List<T> visit(List<? extends ParserRuleContext> contexts, Class<T> clazz) {
        return contexts.stream().map(this::visit).map(clazz::cast).collect(toList());
    }

    private static String unquote(String value) {
        return value.substring(1, value.length() - 1).replace("''", "'").replace("\"\"", "\"");
    }

    private QualifiedName getQualifiedName(SqlBaseParser.QualifiedNameContext context) {
        List<String> parts = visit(context.identifier(), Identifier.class).stream().map(// TODO: preserve quotedness
        Identifier::getValue).collect(Collectors.toList());
        return QualifiedName.of(parts);
    }

    private static boolean isDistinct(SqlBaseParser.SetQuantifierContext setQuantifier) {
        return setQuantifier != null && setQuantifier.DISTINCT() != null;
    }

    private static boolean isHexDigit(char c) {
        return ((c >= '0') && (c <= '9')) || ((c >= 'A') && (c <= 'F')) || ((c >= 'a') && (c <= 'f'));
    }

    private static boolean isValidUnicodeEscape(char c) {
        return c < 0x7F && c > 0x20 && !isHexDigit(c) && c != '"' && c != '+' && c != '\'';
    }

    private static Optional<String> getTextIfPresent(Token token) {
        return Optional.ofNullable(token).map(Token::getText);
    }

    private static ArithmeticBinaryExpression.Type getArithmeticBinaryOperator(Token operator) {
        switch(operator.getType()) {
            case SqlBaseLexer.PLUS:
                return ArithmeticBinaryExpression.Type.ADD;
            case SqlBaseLexer.MINUS:
                return ArithmeticBinaryExpression.Type.SUBTRACT;
            case SqlBaseLexer.ASTERISK:
                return ArithmeticBinaryExpression.Type.MULTIPLY;
            case SqlBaseLexer.SLASH:
                return ArithmeticBinaryExpression.Type.DIVIDE;
            case SqlBaseLexer.PERCENT:
                return ArithmeticBinaryExpression.Type.MODULUS;
        }
        throw new UnsupportedOperationException("Unsupported operator: " + operator.getText());
    }

    private static ComparisonExpressionType getComparisonOperator(Token symbol) {
        switch(symbol.getType()) {
            case SqlBaseLexer.EQ:
                return ComparisonExpressionType.EQUAL;
            case SqlBaseLexer.NEQ:
                return ComparisonExpressionType.NOT_EQUAL;
            case SqlBaseLexer.LT:
                return ComparisonExpressionType.LESS_THAN;
            case SqlBaseLexer.LTE:
                return ComparisonExpressionType.LESS_THAN_OR_EQUAL;
            case SqlBaseLexer.GT:
                return ComparisonExpressionType.GREATER_THAN;
            case SqlBaseLexer.GTE:
                return ComparisonExpressionType.GREATER_THAN_OR_EQUAL;
        }
        throw new IllegalArgumentException("Unsupported operator: " + symbol.getText());
    }

    private static LogicalBinaryExpression.Type getLogicalBinaryOperator(Token token) {
        switch(token.getType()) {
            case SqlBaseLexer.AND:
                return LogicalBinaryExpression.Type.AND;
            case SqlBaseLexer.OR:
                return LogicalBinaryExpression.Type.OR;
        }
        throw new IllegalArgumentException("Unsupported operator: " + token.getText());
    }

    private static SortItem.NullOrdering getNullOrderingType(Token token) {
        switch(token.getType()) {
            case SqlBaseLexer.FIRST:
                return SortItem.NullOrdering.FIRST;
            case SqlBaseLexer.LAST:
                return SortItem.NullOrdering.LAST;
        }
        throw new IllegalArgumentException("Unsupported ordering: " + token.getText());
    }

    private static SortItem.Ordering getOrderingType(Token token) {
        switch(token.getType()) {
            case SqlBaseLexer.ASC:
                return SortItem.Ordering.ASCENDING;
            case SqlBaseLexer.DESC:
                return SortItem.Ordering.DESCENDING;
        }
        throw new IllegalArgumentException("Unsupported ordering: " + token.getText());
    }

    private static QuantifiedComparisonExpression.Quantifier getComparisonQuantifier(Token symbol) {
        switch(symbol.getType()) {
            case SqlBaseLexer.ALL:
                return QuantifiedComparisonExpression.Quantifier.ALL;
            case SqlBaseLexer.ANY:
                return QuantifiedComparisonExpression.Quantifier.ANY;
            case SqlBaseLexer.SOME:
                return QuantifiedComparisonExpression.Quantifier.SOME;
        }
        throw new IllegalArgumentException("Unsupported quantifier: " + symbol.getText());
    }

    private String getType(SqlBaseParser.TypeContext type) {
        if (type.baseType() != null) {
            String signature = type.baseType().getText();
            if (type.baseType().DOUBLE_PRECISION() != null) {
                // TODO: Temporary hack that should be removed with new planner.
                signature = "DOUBLE";
            }
            if (!type.typeParameter().isEmpty()) {
                String typeParameterSignature = type.typeParameter().stream().map(this::typeParameterToString).collect(Collectors.joining(","));
                signature += "(" + typeParameterSignature + ")";
            }
            return signature;
        }
        if (type.ARRAY() != null) {
            return "ARRAY(" + getType(type.type(0)) + ")";
        }
        if (type.MAP() != null) {
            return "MAP(" + getType(type.type(0)) + "," + getType(type.type(1)) + ")";
        }
        if (type.ROW() != null) {
            StringBuilder builder = new StringBuilder("(");
            for (int i = 0; i < type.identifier().size(); i++) {
                if (i != 0) {
                    builder.append(",");
                }
                builder.append(visit(type.identifier(i))).append(" ").append(getType(type.type(i)));
            }
            builder.append(")");
            return "ROW" + builder.toString();
        }
        throw new IllegalArgumentException("Unsupported type specification: " + type.getText());
    }

    private String typeParameterToString(SqlBaseParser.TypeParameterContext typeParameter) {
        if (typeParameter.INTEGER_VALUE() != null) {
            return typeParameter.INTEGER_VALUE().toString();
        }
        if (typeParameter.type() != null) {
            return getType(typeParameter.type());
        }
        throw new IllegalArgumentException("Unsupported typeParameter: " + typeParameter.getText());
    }

    private static void check(boolean condition, String message, ParserRuleContext context) {
        if (!condition) {
            throw parseError(message, context);
        }
    }

    private static NodeLocation getLocation(TerminalNode terminalNode) {
        requireNonNull(terminalNode, "terminalNode is null");
        return getLocation(terminalNode.getSymbol());
    }

    private static NodeLocation getLocation(ParserRuleContext parserRuleContext) {
        requireNonNull(parserRuleContext, "parserRuleContext is null");
        return getLocation(parserRuleContext.getStart());
    }

    private static NodeLocation getLocation(Token token) {
        requireNonNull(token, "token is null");
        return new NodeLocation(token.getLine(), token.getCharPositionInLine());
    }

    private static ParsingException parseError(String message, ParserRuleContext context) {
        return new ParsingException(message, null, context.getStart().getLine(), context.getStart().getCharPositionInLine());
    }
}
