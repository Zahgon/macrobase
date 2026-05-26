package edu.stanford.futuredata.macrobase.analysis.summary.fpg.result;

import edu.stanford.futuredata.macrobase.analysis.summary.util.AttributeEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class FPGAttributeSet implements Comparable<FPGAttributeSet> {

    private double support;

    private long numRecords;

    private double ratioToInliers;

    private Map<String, String> items = new HashMap<>();

    public FPGAttributeSet(FPGItemsetResult its, AttributeEncoder encoder) {
        this.support = its.getSupport();
        this.numRecords = (long) its.getNumRecords();
        this.ratioToInliers = its.getRatioToInliers();
        its.getItems().forEach(i -> items.put(encoder.decodeColumnName(i), encoder.decodeValue(i)));
    }

    public FPGAttributeSet(double support, double numRecords, double ratioToInliers, Map<String, String> items) {
        this.support = support;
        this.numRecords = (long) numRecords;
        this.ratioToInliers = ratioToInliers;
        this.items = items;
    }

    public boolean contains(FPGAttributeSet other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String prettyPrint() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double getSupport() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double getNumRecords() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double getRatioToInliers() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setRatioToInliers(double ratio) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Map<String, String> getItems() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int compareTo(FPGAttributeSet o) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
