package edu.stanford.futuredata.macrobase.analysis.summary.util.qualitymetrics;

/**
 * Measures the relative shift of the mean of a value from the inlier to
 * the outlier population.
 */
public class MeanShiftQualityMetric implements QualityMetric {

    private int oCountIdx, iCountIdx, oMeanCountIdx, iMeanCountIdx;

    public MeanShiftQualityMetric(int oCountIdx, int iCountIdx, int oMeanCountIdx, int iMeanCountIdx) {
        this.oCountIdx = oCountIdx;
        this.iCountIdx = iCountIdx;
        this.oMeanCountIdx = oMeanCountIdx;
        this.iMeanCountIdx = iMeanCountIdx;
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
