package edu.stanford.futuredata.macrobase.analysis.summary.util.qualitymetrics;

/**
 * Measures how many standard deviations a subgroup is away from the global mean
 */
public class MeanDevQualityMetric implements QualityMetric {

    private double globalMean;

    private double globalStdDev;

    private int countIdx, m1Idx, m2Idx;

    public MeanDevQualityMetric(int countIdx, int m1Idx, int m2Idx) {
        this.countIdx = countIdx;
        this.m1Idx = m1Idx;
        this.m2Idx = m2Idx;
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
