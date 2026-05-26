package macrobase.analysis.contextualoutlier;

import macrobase.ingest.DatumEncoder;

public class IntervalDiscrete extends Interval {

    //the integer used to encode the value
    int value;

    public IntervalDiscrete(int dimension, String columnName, int value) {
        super(dimension, columnName);
        this.value = value;
    }

    @Override
    public boolean contains(Object d) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public int getValue() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String print(DatumEncoder encoder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
