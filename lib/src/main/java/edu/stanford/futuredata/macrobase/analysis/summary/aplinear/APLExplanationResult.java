package edu.stanford.futuredata.macrobase.analysis.summary.aplinear;

import edu.stanford.futuredata.macrobase.analysis.summary.util.AttributeEncoder;
import edu.stanford.futuredata.macrobase.analysis.summary.util.IntSet;
import edu.stanford.futuredata.macrobase.analysis.summary.util.qualitymetrics.QualityMetric;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Subgroup which meets the quality threshold metrics.
 */
public class APLExplanationResult {

    private QualityMetric[] metricTypes;

    public final IntSet matcher;

    private double[] aggregates;

    private double[] metrics;

    public APLExplanationResult(QualityMetric[] metricTypes, IntSet matcher, double[] aggregates, double[] metrics) {
        this.metricTypes = metricTypes;
        this.matcher = matcher;
        this.aggregates = aggregates;
        this.metrics = metrics;
    }

    /**
     * @return A Map with each metric value associated with the corresponding name of the metric
     */
    public Map<String, Double> getMetricsAsMap() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param aggregateNames which aggregates to include in the Map
     * @return A Map with each aggregate value associated with the corresponding name of the
     * aggregate.
     */
    public Map<String, Double> getAggregatesAsMap(final List<String> aggregateNames) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Map<String, String> prettyPrintMatch(AttributeEncoder encoder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private Map<String, String> prettyPrintMetric() {
        Map<String, String> metric = new HashMap<>();
        for (int i = 0; i < metricTypes.length; i++) {
            metric.put(metricTypes[i].name(), String.format("%.3f", metrics[i]));
        }
        return metric;
    }

    private Map<String, String> prettyPrintAggregate(List<String> aggregateNames) {
        Map<String, String> aggregate = new HashMap<>();
        for (int i = 0; i < aggregates.length; i++) {
            aggregate.put(aggregateNames.get(i), String.format("%.3f", aggregates[i]));
        }
        return aggregate;
    }

    public Map<String, Map<String, String>> jsonPrint(AttributeEncoder encoder, List<String> aggregateNames) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private String removeBrackets(String str) {
        int l = str.length();
        return str.substring(1, l - 1);
    }

    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String prettyPrint(AttributeEncoder encoder, List<String> aggregateNames) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
