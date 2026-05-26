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

import static com.google.common.base.MoreObjects.toStringHelper;
import static java.util.Objects.requireNonNull;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class AliasedRelation extends Relation {

    private final Relation relation;

    private final Identifier alias;

    private final List<Identifier> columnNames;

    public AliasedRelation(Relation relation, Identifier alias, List<Identifier> columnNames) {
        this(Optional.empty(), relation, alias, columnNames);
    }

    public AliasedRelation(NodeLocation location, Relation relation, Identifier alias, List<Identifier> columnNames) {
        this(Optional.of(location), relation, alias, columnNames);
    }

    private AliasedRelation(Optional<NodeLocation> location, Relation relation, Identifier alias, List<Identifier> columnNames) {
        super(location);
        requireNonNull(relation, "relation is null");
        requireNonNull(alias, " is null");
        this.relation = relation;
        this.alias = alias;
        this.columnNames = columnNames;
    }

    public Relation getRelation() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Identifier getAlias() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<Identifier> getColumnNames() {
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
    public String toString() {
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
