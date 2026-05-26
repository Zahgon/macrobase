package edu.stanford.futuredata.macrobase.analysis.summary.aplinear;

import edu.stanford.futuredata.macrobase.analysis.summary.util.qualitymetrics.*;
import edu.stanford.futuredata.macrobase.datamodel.DataFrame;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Summarizer that works over both cube and row-based labeled ratio-based outlier summarization.
 */
public class APLOutlierSummarizer extends APLSummarizer {

    private Logger log = LoggerFactory.getLogger("APLOutlierSummarizer");

    private String countColumn = null;

    private boolean useBitmaps;

    public APLOutlierSummarizer(boolean useBitmaps) {
        this.useBitmaps = useBitmaps;
    }

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

    public double getMinRatioMetric() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
