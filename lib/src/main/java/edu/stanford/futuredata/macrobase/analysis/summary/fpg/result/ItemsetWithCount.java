package edu.stanford.futuredata.macrobase.analysis.summary.fpg.result;

import java.util.Set;

public class ItemsetWithCount {

    private Set<Integer> items;

    private double count;

    public ItemsetWithCount(Set<Integer> items, double count) {
        this.items = items;
        this.count = count;
    }

    public Set<Integer> getItems() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double getCount() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean equals(Object o) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
