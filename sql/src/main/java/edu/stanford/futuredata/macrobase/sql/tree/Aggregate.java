package edu.stanford.futuredata.macrobase.sql.tree;

import static java.util.Objects.requireNonNull;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.Optional;

public class Aggregate extends Node {

    public enum AggEnum {

        COUNT, MIN, MAX, SUM
    }

    private final AggEnum value;

    public Aggregate(String value) {
        this(Optional.empty(), value);
    }

    public Aggregate(NodeLocation location, String value) {
        this(Optional.of(location), value);
    }

    private Aggregate(Optional<NodeLocation> location, String value) {
        super(location);
        requireNonNull(value, "value is null");
        this.value = AggEnum.valueOf(value);
    }

    public AggEnum getValue() {
        throw new UnsupportedOperationException("STUB: not implemented");
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
}
