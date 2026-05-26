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
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class SortItem extends Node {

    public enum Ordering {

        ASCENDING, DESCENDING
    }

    public enum NullOrdering {

        FIRST, LAST, UNDEFINED
    }

    private final Expression sortKey;

    private final Ordering ordering;

    private final NullOrdering nullOrdering;

    public SortItem(Expression sortKey, Ordering ordering, NullOrdering nullOrdering) {
        this(Optional.empty(), sortKey, ordering, nullOrdering);
    }

    public SortItem(NodeLocation location, Expression sortKey, Ordering ordering, NullOrdering nullOrdering) {
        this(Optional.of(location), sortKey, ordering, nullOrdering);
    }

    private SortItem(Optional<NodeLocation> location, Expression sortKey, Ordering ordering, NullOrdering nullOrdering) {
        super(location);
        this.ordering = ordering;
        this.sortKey = sortKey;
        this.nullOrdering = nullOrdering;
    }

    public Expression getSortKey() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Ordering getOrdering() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public NullOrdering getNullOrdering() {
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
