package macrobase.analysis.contextualoutlier;

import macrobase.ingest.DatumEncoder;

public abstract class Interval {

    protected int dimension;

    protected String columnName;

    public String getColumnName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setColumnName(String columnName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public int getDimension() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setDimension(int dimension) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public abstract boolean contains(Object d);

    /**
     * Create a interval
     *
     * @param dimension
     * @param columnName
     */
    public Interval(int dimension, String columnName) {
        this.setDimension(dimension);
        this.setColumnName(columnName);
    }

    /**
     * Provide a human-readable print of the Interval
     *
     * @param encoder
     * @return
     */
    public abstract String print(DatumEncoder encoder);
}
