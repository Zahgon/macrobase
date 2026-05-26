package edu.stanford.futuredata.macrobase.sql.tree;

import static com.google.common.base.MoreObjects.toStringHelper;
import static java.util.Objects.requireNonNull;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class SplitQuery extends Node {

    private final Expression whereClause;

    private final Optional<Relation> relation;

    private final Optional<TableSubquery> subquery;

    public SplitQuery(Expression whereClause, Optional<Relation> relation, Optional<TableSubquery> subquery) {
        this(Optional.empty(), whereClause, relation, subquery);
    }

    public SplitQuery(NodeLocation location, Expression whereClause, Optional<Relation> relation, Optional<TableSubquery> subquery) {
        this(Optional.of(location), whereClause, relation, subquery);
    }

    private SplitQuery(Optional<NodeLocation> location, Expression whereClause, Optional<Relation> relation, Optional<TableSubquery> subquery) {
        super(location);
        requireNonNull(whereClause, "whereClause is null");
        requireNonNull(relation, "relation is null");
        requireNonNull(subquery, "subquery is null");
        this.whereClause = whereClause;
        this.relation = relation;
        this.subquery = subquery;
    }

    public Expression getWhereClause() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Relation getInputRelation() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<Node> getChildren() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean equals(Object obj) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
