package edu.stanford.futuredata.macrobase.analysis.summary.aplinear;

import edu.stanford.futuredata.macrobase.analysis.summary.BatchSummarizer;
import edu.stanford.futuredata.macrobase.analysis.summary.util.qualitymetrics.AggregationOp;
import edu.stanford.futuredata.macrobase.analysis.summary.util.qualitymetrics.QualityMetric;
import edu.stanford.futuredata.macrobase.analysis.summary.util.AttributeEncoder;
import edu.stanford.futuredata.macrobase.datamodel.DataFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

/**
 * Generic summarizer superclass that can be customized with
 * different quality metrics and input sources. Subclasses are responsible
 * for converting from user-provided columns to the internal linear aggregates.
 */
public abstract class APLSummarizer extends BatchSummarizer {

    Logger log = LoggerFactory.getLogger("APLSummarizer");

    AttributeEncoder encoder;

    APLExplanation explanation;

    APrioriLinear aplKernel;

    List<QualityMetric> qualityMetricList;

    List<Double> thresholds;

    private double[][] globalAggregateCols = null;

    protected long numEvents = 0;

    protected long numOutliers = 0;

    protected int bitmapRatioThreshold = 256;

    public abstract List<String> getAggregateNames();

    public abstract AggregationOp[] getAggregationOps();

    public abstract double[][] getAggregateColumns(DataFrame input);

    public abstract List<QualityMetric> getQualityMetricList();

    public abstract List<Double> getThresholds();

    public abstract int[][] getEncoded(List<String[]> columns, DataFrame input);

    public abstract double getNumberOutliers(double[][] aggregates);

    protected double[] processCountCol(DataFrame input, String countColumn, int numRows) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void process(DataFrame input) throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public APLExplanation getResults() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setBitmapRatioThreshold(int bitmapRatioThreshold) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setGlobalAggregateCols(double[][] globalAggregateCols) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
