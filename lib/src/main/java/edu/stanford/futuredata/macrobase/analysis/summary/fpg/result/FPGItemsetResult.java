package edu.stanford.futuredata.macrobase.analysis.summary.fpg.result;

import java.util.Set;

public class FPGItemsetResult {

    private double support;

    private double numRecords;

    private double ratioToInliers;

    private Set<Integer> items;

    public FPGItemsetResult(double support, double numRecords, double ratioToInliers, Set<Integer> items) {
        this.support = support;
        this.numRecords = numRecords;
        this.ratioToInliers = ratioToInliers;
        this.items = items;
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

    public Set<Integer> getItems() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
