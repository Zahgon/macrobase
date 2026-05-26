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
package edu.stanford.futuredata.macrobase.sql.tree;

import javax.annotation.Nullable;

/**
 * Portions of this copied from Facebook's presto-parser (https://github.com/prestodb/presto/tree/master/presto-parser);
 * any new AST type defined in the tree subpackage should be added to this file as follows:
 * <code>
 *     protected R visitNewAstType(NewAstType node, C context) {
 *         return visitNode(node, context);
 *     }
 * </code>
 */
public abstract class AstVisitor<R, C> {

    public R process(Node node) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public R process(Node node, @Nullable C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected R visitNode(Node node, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected R visitExpression(Expression node, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected R visitArithmeticBinary(ArithmeticBinaryExpression node, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected R visitComparisonExpression(ComparisonExpression node, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected R visitLiteral(Literal node, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected R visitDoubleLiteral(DoubleLiteral node, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected R visitDecimalLiteral(DecimalLiteral node, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected R visitStatement(Statement node, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected R visitQuery(Query node, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected R visitGenericLiteral(GenericLiteral node, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected R visitSelect(Select node, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected R visitRelation(Relation node, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected R visitQueryBody(QueryBody node, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected R visitOrderBy(OrderBy node, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected R visitQuerySpecification(QuerySpecification node, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public R visitDiffQuerySpecification(DiffQuerySpecification node, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected R visitWhenClause(WhenClause node, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected R visitFunctionCall(FunctionCall node, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected R visitStringLiteral(StringLiteral node, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected R visitCharLiteral(CharLiteral node, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected R visitBinaryLiteral(BinaryLiteral node, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected R visitBooleanLiteral(BooleanLiteral node, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected R visitInListExpression(InListExpression node, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected R visitIdentifier(Identifier node, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected R visitDereferenceExpression(DereferenceExpression node, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected R visitNullLiteral(NullLiteral node, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected R visitArithmeticUnary(ArithmeticUnaryExpression node, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected R visitNotExpression(NotExpression node, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected R visitSelectItem(SelectItem node, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected R visitSingleColumn(SingleColumn node, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected R visitAllColumns(AllColumns node, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected R visitLikePredicate(LikePredicate node, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected R visitIsNotNullPredicate(IsNotNullPredicate node, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected R visitIsNullPredicate(IsNullPredicate node, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected R visitLongLiteral(IntLiteral node, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected R visitLogicalBinaryExpression(LogicalBinaryExpression node, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected R visitSubqueryExpression(SubqueryExpression node, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected R visitSortItem(SortItem node, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected R visitTable(Table node, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected R visitTableSubquery(TableSubquery node, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected R visitAliasedRelation(AliasedRelation node, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected R visitJoin(Join node, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected R visitExists(ExistsPredicate node, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected R visitFieldReference(FieldReference node, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected R visitColumnDefinition(ColumnDefinition node, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected R visitQuantifiedComparisonExpression(QuantifiedComparisonExpression node, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public R visitRatioMetricExpression(RatioMetricExpression node, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public R visitImportCsv(ImportCsv node, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
