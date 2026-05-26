package edu.stanford.futuredata.macrobase.sql.tree;

import static java.util.Objects.requireNonNull;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.Optional;

public class MinSupportExpression extends Node {

    private final DecimalLiteral minSupport;

    public MinSupportExpression(DecimalLiteral minSupport) {
        this(Optional.empty(), minSupport);
    }

    public MinSupportExpression(NodeLocation location, DecimalLiteral minSupport) {
        this(Optional.of(location), minSupport);
    }

    private MinSupportExpression(Optional<NodeLocation> location, DecimalLiteral minSupport) {
        super(location);
        requireNonNull(minSupport, "minSupport is null");
        this.minSupport = minSupport;
    }

    @Override
    public List<? extends Node> getChildren() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
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

    public double getMinSupport() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
