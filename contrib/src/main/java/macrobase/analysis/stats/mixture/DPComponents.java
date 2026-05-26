package macrobase.analysis.stats.mixture;

import org.apache.commons.math3.special.Gamma;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * DPComponents represents mixing components that are mixing components of a DP distribution.
 * This class implements methods used for running variational inference
 */
public class DPComponents implements MixingComponents {

    private static final Logger log = LoggerFactory.getLogger(DPComponents.class);

    // Number of truncated clusters.
    private int T;

    // Concentration parameter for the Dirichlet distribution.
    private double concentrationParameter;

    // Parameters describing stick lengths, i.e. shape parameters of Beta distributions.
    private double[][] shapeParams;

    public DPComponents(double concentrationParameter, int T) {
        this.T = T;
        this.concentrationParameter = concentrationParameter;
        shapeParams = new double[T][2];
        for (int i = 0; i < T; i++) {
            shapeParams[i][0] = 1;
            shapeParams[i][1] = concentrationParameter;
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

    @Override
    public void moveNatural(double[][] r, double pace, double repeat) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double[] getNormalizedClusterProportions() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
