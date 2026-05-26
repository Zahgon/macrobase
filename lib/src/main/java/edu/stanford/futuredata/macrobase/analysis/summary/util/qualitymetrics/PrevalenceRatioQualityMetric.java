package edu.stanford.futuredata.macrobase.analysis.summary.util.qualitymetrics;

public class PrevalenceRatioQualityMetric implements QualityMetric {

    private int outlierCountIdx;

    private int totalCountIdx;

    private double baseRate;

    public PrevalenceRatioQualityMetric(int outlierCountIdx, int totalCountIdx) {
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
