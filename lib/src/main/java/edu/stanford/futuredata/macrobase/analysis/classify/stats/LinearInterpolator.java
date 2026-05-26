package edu.stanford.futuredata.macrobase.analysis.classify.stats;

import edu.stanford.futuredata.macrobase.util.MacroBaseInternalError;

/**
 * Performs linear interpolation in a lazy manner: interpolation does not actually
 * occur until an evaluation is requested.
 */
public class LinearInterpolator {

    private double[] x;

    private double[] y;

    /**
     * @param x Should be sorted in non-descending order. Assumed to not be very large.
     */
    public LinearInterpolator(double[] x, double[] y) throws IllegalArgumentException {
        if (x.length != y.length) {
            throw new IllegalArgumentException("X and Y must be the same length");
        }
        if (x.length == 1) {
            throw new IllegalArgumentException("X must contain more than one value");
        }
        this.x = x;
        this.y = y;
    }

    public double evaluate(double value) throws MacroBaseInternalError {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
