package edu.stanford.futuredata.macrobase.analysis.classify;

import edu.stanford.futuredata.macrobase.operator.Transformer;

public abstract class Classifier implements Transformer {

    protected String columnName;

    protected String outputColumnName = "_OUTLIER";

    public Classifier(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Classifier setColumnName(String columnName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getOutputColumnName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param outputColumnName Which column to write the classification results.
     * @return this
     */
    public Classifier setOutputColumnName(String outputColumnName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
