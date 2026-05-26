package macrobase.datamodel;

import java.util.Comparator;

public class DatumComparator implements Comparator {

    private int dimension;

    /**
     * Create a Comparator subclass that compares Datums based on
     * dimension-th dimension in the metrics of datum object.
     * @param dimension  dimension to use for comparison
     */
    public DatumComparator(int dimension) {
        this.dimension = dimension;
    }

    @Override
    public int compare(Object o1, Object o2) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
