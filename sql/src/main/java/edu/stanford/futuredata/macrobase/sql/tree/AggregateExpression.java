package edu.stanford.futuredata.macrobase.sql.tree;

import static java.util.Objects.requireNonNull;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class AggregateExpression extends Node {

    private final Aggregate agg;

    public AggregateExpression(Aggregate agg) {
        this(Optional.empty(), agg);
    }

    public AggregateExpression(NodeLocation location, Aggregate agg) {
        this(Optional.of(location), agg);
    }

    private AggregateExpression(Optional<NodeLocation> location, Aggregate agg) {
        super(location);
        requireNonNull(agg, "agg is null");
        this.agg = agg;
    }

    public Aggregate getAgg() {
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
