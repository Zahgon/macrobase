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

import static java.util.Objects.requireNonNull;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class SingleColumn extends SelectItem {

    private final Optional<Identifier> alias;

    private final Expression expression;

    public SingleColumn(Expression expression) {
        this(Optional.empty(), expression, Optional.empty());
    }

    public SingleColumn(Expression expression, Optional<Identifier> alias) {
        this(Optional.empty(), expression, alias);
    }

    public SingleColumn(Expression expression, Identifier alias) {
        this(Optional.empty(), expression, Optional.of(alias));
    }

    public SingleColumn(NodeLocation location, Expression expression, Optional<Identifier> alias) {
        this(Optional.of(location), expression, alias);
    }

    private SingleColumn(Optional<NodeLocation> location, Expression expression, Optional<Identifier> alias) {
        super(location);
        requireNonNull(expression, "expression is null");
        requireNonNull(alias, "alias is null");
        this.expression = expression;
        this.alias = alias;
    }

    public Optional<Identifier> getAlias() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Expression getExpression() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isUDF() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean equals(Object obj) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return If the Expression is a Function Call (e.g., a UDF), rewrite as "fn_name(arg1, arg2,…
     * argn)". (By default, {@link FunctionCall#toString()} will include quotes around the function
     * name.) Otherwise, return the output of toString()
     */
    private String formatForColName(final Expression expr) {
        if (expr instanceof FunctionCall) {
            return expr.toString().replaceAll("\"", "");
        }
        return expr.toString();
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<Node> getChildren() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
