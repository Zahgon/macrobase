package macrobase.analysis.contextualoutlier;

import macrobase.ingest.DatumEncoder;

public class IntervalDouble extends Interval {

    double min;

    double max;

    public IntervalDouble(int dimension, String columnName, double min, double max) {
        super(dimension, columnName);
        this.min = min;
        this.max = max;
    }

    public double getMin() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double getMax() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String print(DatumEncoder encoder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean contains(Object d) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
