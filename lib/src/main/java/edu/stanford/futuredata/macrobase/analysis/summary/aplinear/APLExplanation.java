package edu.stanford.futuredata.macrobase.analysis.summary.aplinear;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.stanford.futuredata.macrobase.analysis.summary.Explanation;
import edu.stanford.futuredata.macrobase.analysis.summary.util.AttributeEncoder;
import edu.stanford.futuredata.macrobase.analysis.summary.util.qualitymetrics.QualityMetric;
import edu.stanford.futuredata.macrobase.datamodel.DataFrame;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class APLExplanation implements Explanation {

    private AttributeEncoder encoder;

    private List<String> aggregateNames;

    private long numTotal;

    private long numOutliers;

    private ArrayList<QualityMetric> metrics;

    private ArrayList<APLExplanationResult> results;

    public APLExplanation(AttributeEncoder encoder, long numTotal, long numOutliers, List<String> aggregateNames, List<QualityMetric> metrics, List<APLExplanationResult> results) {
        this.encoder = encoder;
        this.numTotal = numTotal;
        this.numOutliers = numOutliers;
        this.aggregateNames = aggregateNames;
        this.metrics = new ArrayList<>(metrics);
        this.results = new ArrayList<>(results);
    }

    public List<APLExplanationResult> getResults() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @JsonProperty("results")
    public List<Map<String, Map<String, String>>> results() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @JsonProperty("numTotal")
    public double numTotal() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @JsonProperty("outliers")
    public double numOutliers() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String prettyPrint() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Convert List of {@link APLExplanationResult} to normalized DataFrame that includes all
     * metrics contained in each results.
     *
     * @param attrsToInclude the attributes (String columns) to be included in the DataFrame
     * @return New DataFrame with <tt>attrsToInclude</tt> columns and ratio metric, support, and
     * outlier count columns
     */
    public DataFrame toDataFrame(final List<String> attrsToInclude) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
