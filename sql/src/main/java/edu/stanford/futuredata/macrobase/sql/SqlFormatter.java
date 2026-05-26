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
import static com.google.common.collect.Iterables.getOnlyElement;
import static edu.stanford.futuredata.macrobase.sql.ExpressionFormatter.formatExpression;
import static edu.stanford.futuredata.macrobase.sql.ExpressionFormatter.formatOrderBy;
import static java.util.stream.Collectors.joining;
import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import edu.stanford.futuredata.macrobase.sql.tree.AliasedRelation;
import edu.stanford.futuredata.macrobase.sql.tree.AllColumns;
import edu.stanford.futuredata.macrobase.sql.tree.AstVisitor;
import edu.stanford.futuredata.macrobase.sql.tree.Expression;
import edu.stanford.futuredata.macrobase.sql.tree.Identifier;
import edu.stanford.futuredata.macrobase.sql.tree.Join;
import edu.stanford.futuredata.macrobase.sql.tree.JoinCriteria;
import edu.stanford.futuredata.macrobase.sql.tree.JoinOn;
import edu.stanford.futuredata.macrobase.sql.tree.JoinUsing;
import edu.stanford.futuredata.macrobase.sql.tree.NaturalJoin;
import edu.stanford.futuredata.macrobase.sql.tree.Node;
import edu.stanford.futuredata.macrobase.sql.tree.OrderBy;
import edu.stanford.futuredata.macrobase.sql.tree.QualifiedName;
import edu.stanford.futuredata.macrobase.sql.tree.Query;
import edu.stanford.futuredata.macrobase.sql.tree.QuerySpecification;
import edu.stanford.futuredata.macrobase.sql.tree.Relation;
import edu.stanford.futuredata.macrobase.sql.tree.Select;
import edu.stanford.futuredata.macrobase.sql.tree.SelectItem;
import edu.stanford.futuredata.macrobase.sql.tree.SingleColumn;
import edu.stanford.futuredata.macrobase.sql.tree.Table;
import edu.stanford.futuredata.macrobase.sql.tree.TableSubquery;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

final class SqlFormatter {

    private static final String INDENT = "   ";

    private static final Pattern NAME_PATTERN = Pattern.compile("[a-z_][a-z0-9_]*");

    private SqlFormatter() {
    }

    static String formatSql(Node root, Optional<List<Expression>> parameters) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static class Formatter extends AstVisitor<Void, Integer> {

        private final StringBuilder builder;

        private final Optional<List<Expression>> parameters;

        Formatter(StringBuilder builder, Optional<List<Expression>> parameters) {
            this.builder = builder;
            this.parameters = parameters;
        }

        @Override
        protected Void visitNode(Node node, Integer indent) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected Void visitExpression(Expression node, Integer indent) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected Void visitQuery(Query node, Integer indent) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected Void visitQuerySpecification(QuerySpecification node, Integer indent) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected Void visitOrderBy(OrderBy node, Integer indent) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected Void visitSelect(Select node, Integer indent) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected Void visitSingleColumn(SingleColumn node, Integer indent) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected Void visitAllColumns(AllColumns node, Integer context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected Void visitTable(Table node, Integer indent) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected Void visitJoin(Join node, Integer indent) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected Void visitAliasedRelation(AliasedRelation node, Integer indent) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected Void visitTableSubquery(TableSubquery node, Integer indent) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private static String formatName(String name) {
            if (NAME_PATTERN.matcher(name).matches()) {
                return name;
            }
            return "\"" + name.replace("\"", "\"\"") + "\"";
        }

        private static String formatName(QualifiedName name) {
            return name.getOriginalParts().stream().map(Formatter::formatName).collect(joining("."));
        }

        private void processRelation(Relation relation, Integer indent) {
            // TODO: handle this properly
            if (relation instanceof Table) {
                builder.append("TABLE ").append(((Table) relation).getName()).append('\n');
            } else {
                process(relation, indent);
            }
        }

        private StringBuilder append(int indent, String value) {
            return builder.append(indentString(indent)).append(value);
        }

        private static String indentString(int indent) {
            return Strings.repeat(INDENT, indent);
        }
    }

    private static void appendAliasColumns(StringBuilder builder, List<Identifier> columns) {
        if ((columns != null) && (!columns.isEmpty())) {
            String formattedColumns = columns.stream().map(name -> formatExpression(name, Optional.empty())).collect(Collectors.joining(", "));
            builder.append(" (").append(formattedColumns).append(')');
        }
    }
}
