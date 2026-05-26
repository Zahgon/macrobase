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
package edu.stanford.futuredata.macrobase.sql;

import static com.google.common.base.Preconditions.checkArgument;
import static edu.stanford.futuredata.macrobase.sql.SqlFormatter.formatSql;
import static java.lang.String.format;
import com.google.common.base.Joiner;
import edu.stanford.futuredata.macrobase.sql.tree.AllColumns;
import edu.stanford.futuredata.macrobase.sql.tree.ArithmeticBinaryExpression;
import edu.stanford.futuredata.macrobase.sql.tree.ArithmeticUnaryExpression;
import edu.stanford.futuredata.macrobase.sql.tree.AstVisitor;
import edu.stanford.futuredata.macrobase.sql.tree.BinaryLiteral;
import edu.stanford.futuredata.macrobase.sql.tree.BooleanLiteral;
import edu.stanford.futuredata.macrobase.sql.tree.CharLiteral;
import edu.stanford.futuredata.macrobase.sql.tree.ComparisonExpression;
import edu.stanford.futuredata.macrobase.sql.tree.DecimalLiteral;
import edu.stanford.futuredata.macrobase.sql.tree.DereferenceExpression;
import edu.stanford.futuredata.macrobase.sql.tree.DoubleLiteral;
import edu.stanford.futuredata.macrobase.sql.tree.ExistsPredicate;
import edu.stanford.futuredata.macrobase.sql.tree.Expression;
import edu.stanford.futuredata.macrobase.sql.tree.FieldReference;
import edu.stanford.futuredata.macrobase.sql.tree.FunctionCall;
import edu.stanford.futuredata.macrobase.sql.tree.GenericLiteral;
import edu.stanford.futuredata.macrobase.sql.tree.Identifier;
import edu.stanford.futuredata.macrobase.sql.tree.InListExpression;
import edu.stanford.futuredata.macrobase.sql.tree.IntLiteral;
import edu.stanford.futuredata.macrobase.sql.tree.IsNotNullPredicate;
import edu.stanford.futuredata.macrobase.sql.tree.IsNullPredicate;
import edu.stanford.futuredata.macrobase.sql.tree.LikePredicate;
import edu.stanford.futuredata.macrobase.sql.tree.LogicalBinaryExpression;
import edu.stanford.futuredata.macrobase.sql.tree.Node;
import edu.stanford.futuredata.macrobase.sql.tree.NotExpression;
import edu.stanford.futuredata.macrobase.sql.tree.NullLiteral;
import edu.stanford.futuredata.macrobase.sql.tree.OrderBy;
import edu.stanford.futuredata.macrobase.sql.tree.QualifiedName;
import edu.stanford.futuredata.macrobase.sql.tree.QuantifiedComparisonExpression;
import edu.stanford.futuredata.macrobase.sql.tree.RatioMetricExpression;
import edu.stanford.futuredata.macrobase.sql.tree.SortItem;
import edu.stanford.futuredata.macrobase.sql.tree.StringLiteral;
import edu.stanford.futuredata.macrobase.sql.tree.SubqueryExpression;
import edu.stanford.futuredata.macrobase.sql.tree.WhenClause;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.PrimitiveIterator;
import java.util.function.Function;

public final class ExpressionFormatter {

    private ExpressionFormatter() {
    }

    public static String formatExpression(Expression expression, Optional<List<Expression>> parameters) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class Formatter extends AstVisitor<String, Void> {

        private final Optional<List<Expression>> parameters;

        public Formatter(Optional<List<Expression>> parameters) {
            this.parameters = parameters;
        }

        @Override
        protected String visitNode(Node node, Void context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected String visitExpression(Expression node, Void context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected String visitBooleanLiteral(BooleanLiteral node, Void context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected String visitStringLiteral(StringLiteral node, Void context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected String visitCharLiteral(CharLiteral node, Void context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected String visitBinaryLiteral(BinaryLiteral node, Void context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected String visitLongLiteral(IntLiteral node, Void context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected String visitDoubleLiteral(DoubleLiteral node, Void context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected String visitDecimalLiteral(DecimalLiteral node, Void context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected String visitGenericLiteral(GenericLiteral node, Void context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected String visitNullLiteral(NullLiteral node, Void context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected String visitSubqueryExpression(SubqueryExpression node, Void context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected String visitExists(ExistsPredicate node, Void context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected String visitIdentifier(Identifier node, Void context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected String visitDereferenceExpression(DereferenceExpression node, Void context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private static String formatQualifiedName(QualifiedName name) {
            List<String> parts = new ArrayList<>();
            for (String part : name.getParts()) {
                parts.add(formatIdentifier(part));
            }
            return Joiner.on('.').join(parts);
        }

        @Override
        public String visitFieldReference(FieldReference node, Void context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected String visitFunctionCall(FunctionCall node, Void context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected String visitLogicalBinaryExpression(LogicalBinaryExpression node, Void context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected String visitNotExpression(NotExpression node, Void context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected String visitComparisonExpression(ComparisonExpression node, Void context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected String visitIsNullPredicate(IsNullPredicate node, Void context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected String visitIsNotNullPredicate(IsNotNullPredicate node, Void context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected String visitArithmeticUnary(ArithmeticUnaryExpression node, Void context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected String visitArithmeticBinary(ArithmeticBinaryExpression node, Void context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected String visitLikePredicate(LikePredicate node, Void context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected String visitAllColumns(AllColumns node, Void context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected String visitWhenClause(WhenClause node, Void context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected String visitInListExpression(InListExpression node, Void context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private String visitFilter(Expression node, Void context) {
            return "(WHERE " + process(node, context) + ')';
        }

        @Override
        protected String visitQuantifiedComparisonExpression(QuantifiedComparisonExpression node, Void context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public String visitRatioMetricExpression(RatioMetricExpression node, Void context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private String formatBinaryExpression(String operator, Expression left, Expression right) {
            return '(' + process(left, null) + ' ' + operator + ' ' + process(right, null) + ')';
        }

        private String joinExpressions(List<Expression> expressions) {
            return Joiner.on(", ").join(expressions.stream().map((e) -> process(e, null)).iterator());
        }

        private static String formatIdentifier(String s) {
            // TODO: handle escaping properly
            return '"' + s + '"';
        }
    }

    static String formatStringLiteral(String s) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static String formatOrderBy(OrderBy orderBy, Optional<List<Expression>> parameters) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static String formatSortItems(List<SortItem> sortItems, Optional<List<Expression>> parameters) {
        return Joiner.on(", ").join((Iterable<?>) sortItems.stream().map(sortItemFormatterFunction(parameters)).iterator());
    }

    private static boolean isAsciiPrintable(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!isAsciiPrintable(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isAsciiPrintable(int codePoint) {
        return codePoint < 0x7F && codePoint >= 0x20;
    }

    private static Function<SortItem, String> sortItemFormatterFunction(Optional<List<Expression>> parameters) {
        return input -> {
            StringBuilder builder = new StringBuilder();
            builder.append(formatExpression(input.getSortKey(), parameters));
            switch(input.getOrdering()) {
                case ASCENDING:
                    builder.append(" ASC");
                    break;
                case DESCENDING:
                    builder.append(" DESC");
                    break;
                default:
                    throw new UnsupportedOperationException("unknown ordering: " + input.getOrdering());
            }
            switch(input.getNullOrdering()) {
                case FIRST:
                    builder.append(" NULLS FIRST");
                    break;
                case LAST:
                    builder.append(" NULLS LAST");
                    break;
                case UNDEFINED:
                    // no op
                    break;
                default:
                    throw new UnsupportedOperationException("unknown null ordering: " + input.getNullOrdering());
            }
            return builder.toString();
        };
    }
}
