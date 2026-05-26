package edu.stanford.futuredata.macrobase.sql.tree;

import static java.util.Objects.requireNonNull;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.Optional;

public class MinRatioExpression extends Node {

    private final DecimalLiteral minRatio;

    public MinRatioExpression(DecimalLiteral minRatio) {
        this(Optional.empty(), minRatio);
    }

    public MinRatioExpression(NodeLocation location, DecimalLiteral minRatio) {
        this(Optional.of(location), minRatio);
    }

    private MinRatioExpression(Optional<NodeLocation> location, DecimalLiteral minRatio) {
        super(location);
        requireNonNull(minRatio, "minRatio is null");
        this.minRatio = minRatio;
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

    public double getMinRatio() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
