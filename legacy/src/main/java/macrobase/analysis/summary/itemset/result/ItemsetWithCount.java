package macrobase.analysis.summary.itemset.result;

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
}
