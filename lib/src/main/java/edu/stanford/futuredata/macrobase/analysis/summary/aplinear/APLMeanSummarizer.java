package edu.stanford.futuredata.macrobase.analysis.summary.aplinear;

import edu.stanford.futuredata.macrobase.analysis.summary.util.qualitymetrics.AggregationOp;
import edu.stanford.futuredata.macrobase.analysis.summary.util.qualitymetrics.MeanDevQualityMetric;
import edu.stanford.futuredata.macrobase.analysis.summary.util.qualitymetrics.QualityMetric;
import edu.stanford.futuredata.macrobase.analysis.summary.util.qualitymetrics.SupportQualityMetric;
import edu.stanford.futuredata.macrobase.datamodel.DataFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Summarizer that works over cube-based summarization based on mean shift.
 */
public class APLMeanSummarizer extends APLSummarizer {

    private Logger log = LoggerFactory.getLogger("APLMeanSummarizer");

    private String countColumn = null;

    private String meanColumn = "mean";

    private String stdColumn = "std";

    private double minStdDev = 3.0;

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

    public String getCountColumn() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setCountColumn(String countColumn) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setMeanColumn(String meanColumn) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setStdColumn(String stdColumn) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setMinStdDev(double minStdDev) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
