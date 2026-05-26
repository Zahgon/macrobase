package edu.stanford.futuredata.macrobase.analysis.summary.util.qualitymetrics;

/**
 * Measures the relative outlier rate w.r.t. the global outlier rate
 */
public class GlobalRatioQualityMetric implements QualityMetric {

    private int outlierCountIdx;

    private int totalCountIdx;

    private double baseRate = 0.0;

    public GlobalRatioQualityMetric(int outlierCountIdx, int totalCountIdx) {
        this.outlierCountIdx = outlierCountIdx;
        this.totalCountIdx = totalCountIdx;
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
