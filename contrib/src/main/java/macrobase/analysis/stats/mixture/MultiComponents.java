package macrobase.analysis.stats.mixture;

import org.apache.commons.math3.special.Gamma;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MultiComponents implements MixingComponents {

    private static final Logger log = LoggerFactory.getLogger(MultiComponents.class);

    private double priorAlpha;

    private double[] coeffs;

    private int K;

    // Auxiliaries.
    private double sumCoeffs;

    public MultiComponents(double prior, int clusters) {
        K = clusters;
        priorAlpha = prior;
        coeffs = new double[clusters];
        sumCoeffs = 0;
        for (int i = 0; i < K; i++) {
            coeffs[i] = 1. / K;
            sumCoeffs += coeffs[i];
        }
    }

    @Override
    public double[] calcExpectationLog() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void update(double[][] r) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void moveNatural(double[][] r, double pace, double portion) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public double[] getNormalizedClusterProportions() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double[] getCoeffs() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double getPrior() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
