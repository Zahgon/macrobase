package edu.stanford.futuredata.macrobase.analysis.classify;

import edu.stanford.futuredata.macrobase.datamodel.DataFrame;

public class RawClassifier extends CubeClassifier {

    protected DataFrame input;

    public RawClassifier(String totalCountColumn, String outlierCountColumn) {
        super(totalCountColumn);
        this.outputColumnName = outlierCountColumn;
    }

    @Override
    public void process(DataFrame input) throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public DataFrame getResults() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
