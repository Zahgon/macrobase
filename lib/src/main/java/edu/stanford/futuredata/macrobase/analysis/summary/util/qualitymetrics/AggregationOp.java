package edu.stanford.futuredata.macrobase.analysis.summary.util.qualitymetrics;

import edu.stanford.futuredata.macrobase.util.MacroBaseInternalError;

public enum AggregationOp {

    SUM, MIN, MAX;

    public double combine(double a, double b) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double initValue() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
