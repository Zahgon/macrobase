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

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ArithmeticBinaryExpression extends Expression {

    public enum Type {

        ADD("+"), SUBTRACT("-"), MULTIPLY("*"), DIVIDE("/"), MODULUS("%");

        private final String value;

        Type(String value) {
            this.value = value;
        }

        public String getValue() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private final Type type;

    private final Expression left;

    private final Expression right;

    public ArithmeticBinaryExpression(Type type, Expression left, Expression right) {
        this(Optional.empty(), type, left, right);
    }

    public ArithmeticBinaryExpression(NodeLocation location, Type type, Expression left, Expression right) {
        this(Optional.of(location), type, left, right);
    }

    private ArithmeticBinaryExpression(Optional<NodeLocation> location, Type type, Expression left, Expression right) {
        super(location);
        this.type = type;
        this.left = left;
        this.right = right;
    }

    public Type getType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Expression getLeft() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Expression getRight() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<Node> getChildren() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean equals(Object o) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
