package edu.stanford.futuredata.macrobase.analysis.summary.util.qualitymetrics;

import edu.stanford.futuredata.macrobase.analysis.summary.fpg.RiskRatio;

/**
 * Calculates the risk ratio of a particular attribute.  This is the ratio of
 * the probability of being an outlier given the attribute to the probability
 * of being an outlier when without the attribute.
 */
public class RiskRatioQualityMetric implements QualityMetric {

    private int outlierCountIdx;

    private int totalCountIdx;

    private double totalOutliers;

    private double totalInliers;

    public RiskRatioQualityMetric(int outlierCountIdx, int totalCountIdx) {
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
