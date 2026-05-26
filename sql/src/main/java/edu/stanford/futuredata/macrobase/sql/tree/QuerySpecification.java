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

public class QuerySpecification extends QueryBody {

    private final Select select;

    private final Optional<Relation> from;

    private final Optional<Expression> where;

    private final Optional<OrderBy> orderBy;

    private final Optional<String> limit;

    private final Optional<ExportClause> exportExpr;

    public QuerySpecification(Select select, Optional<Relation> from, Optional<Expression> where, Optional<OrderBy> orderBy, Optional<String> limit, Optional<ExportClause> exportExpr) {
        this(Optional.empty(), select, from, where, orderBy, limit, exportExpr);
    }

    public QuerySpecification(NodeLocation location, Select select, Optional<Relation> from, Optional<Expression> where, Optional<OrderBy> orderBy, Optional<String> limit, Optional<ExportClause> exportExpr) {
        this(Optional.of(location), select, from, where, orderBy, limit, exportExpr);
    }

    private QuerySpecification(Optional<NodeLocation> location, Select select, Optional<Relation> from, Optional<Expression> where, Optional<OrderBy> orderBy, Optional<String> limit, Optional<ExportClause> exportExpr) {
        super(location);
        requireNonNull(select, "select is null");
        requireNonNull(from, "from is null");
        requireNonNull(where, "where is null");
        requireNonNull(orderBy, "orderBy is null");
        requireNonNull(limit, "limit is null");
        requireNonNull(exportExpr, "exportExpr is null");
        this.select = select;
        this.from = from;
        this.where = where;
        this.orderBy = orderBy;
        this.limit = limit;
        this.exportExpr = exportExpr;
    }

    public Select getSelect() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Optional<Relation> getFrom() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Optional<Expression> getWhere() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Optional<OrderBy> getOrderBy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Optional<String> getLimit() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Optional<ExportClause> getExportExpr() {
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
    public boolean equals(Object obj) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
