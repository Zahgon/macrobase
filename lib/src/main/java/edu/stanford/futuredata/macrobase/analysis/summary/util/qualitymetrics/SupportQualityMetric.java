package edu.stanford.futuredata.macrobase.analysis.summary.util.qualitymetrics;

/**
 * Measures how large a subgroup is relative to a global count
 */
public class SupportQualityMetric implements QualityMetric {

    private int countIdx;

    private double globalCount;

    public SupportQualityMetric(int countIdx) {
        this.countIdx = countIdx;
    }

    @Override
    public String name() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public QualityMetric initialize(double[] globalAggregates) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public double value(double[] aggregates) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isMonotonic() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
