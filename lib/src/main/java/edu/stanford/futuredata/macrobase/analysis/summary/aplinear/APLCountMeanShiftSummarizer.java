package edu.stanford.futuredata.macrobase.analysis.summary.aplinear;

import edu.stanford.futuredata.macrobase.analysis.classify.CountMeanShiftCubedClassifier;
import edu.stanford.futuredata.macrobase.analysis.summary.util.qualitymetrics.AggregationOp;
import edu.stanford.futuredata.macrobase.analysis.summary.util.qualitymetrics.MeanShiftQualityMetric;
import edu.stanford.futuredata.macrobase.analysis.summary.util.qualitymetrics.QualityMetric;
import edu.stanford.futuredata.macrobase.analysis.summary.util.qualitymetrics.SupportQualityMetric;
import edu.stanford.futuredata.macrobase.datamodel.DataFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Summarizer that measures the shift of the mean of some value from the inlier
 * population to the outlier population.  Explanations return all sets of attributes with min
 * support among both inlier and outlier population where the shift of the mean of a value
 * from the inliers to the outliers passes some threshold.
 */
public class APLCountMeanShiftSummarizer extends APLSummarizer {

    private Logger log = LoggerFactory.getLogger("APLMeanSummarizer");

    private double minMeanShift = 1.0;

    @Override
    public List<String> getAggregateNames() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public AggregationOp[] getAggregationOps() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int[][] getEncoded(List<String[]> columns, DataFrame input) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public double[][] getAggregateColumns(DataFrame input) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<QualityMetric> getQualityMetricList() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<Double> getThresholds() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public double getNumberOutliers(double[][] aggregates) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setMinMeanShift(double minMeanShift) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
