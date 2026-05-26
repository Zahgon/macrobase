package macrobase.analysis.stats.mixture;

import macrobase.analysis.stats.distribution.MultivariateTDistribution;
import macrobase.analysis.stats.distribution.Wishart;
import macrobase.datamodel.Datum;
import macrobase.util.AlgebraUtils;
import org.apache.commons.math3.linear.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * NormalWishartClusters is a class that represents K components (atoms) that
 * are Normal-Wishart distributed and have Normal-Wishart distribution each.
 * It also has methods for initializing these components (atoms) and
 * running Mean-Field Variational Inference and Stochastic Variation Inference.
 */
public class NormalWishartClusters {

    private static final Logger log = LoggerFactory.getLogger(NormalWishartClusters.class);

    // Omega and dof for Wishart distribution for the precision matrix of the clusters.
    private double[] dof;

    private List<RealMatrix> omega;

    // Parameters for Normal distribution for atom position, N(loc, (beta * lambda))
    // where Lambda is Wishart distributed given parameters above.
    protected double[] beta;

    protected List<RealVector> loc;

    // Base distribution, also needs to be Normal-Wishart
    private double baseNu;

    private RealMatrix baseOmega;

    private RealMatrix baseOmegaInverse;

    private double baseBeta;

    private RealVector baseLoc;

    private int K;

    private int D;

    private double halfDimensionLn2Pi;

    public NormalWishartClusters(int K, int dimension) {
        this.K = K;
        this.D = dimension;
        halfDimensionLn2Pi = 0.5 * D * Math.log(2 * Math.PI);
    }

    protected static List<RealMatrix> calculateQuadraticForms(List<Datum> data, List<RealVector> clusterMean, double[][] r) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected static List<RealVector> calculateWeightedSums(List<Datum> data, double[][] r) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Initializes base distribution. This method works great with DP mixture model.
     * @param data
     */
    public void initializeBaseForDP(List<Datum> data) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Initializes atom (component) distributions. This method works great with DP mixture model.
     * @param data
     */
    public void initializeAtomsForDP(List<Datum> data, String filename, Random random) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Initializes atom (component) distributions. This method works great with finite mixture model.
     * @param data
     */
    public void initializeAtomsForFinite(List<Datum> data, String filename, Random random) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void initializeBaseForFinite(List<Datum> data) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double[] calculateExLogPrecision() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double[][] calcLogLikelyFixedPrec(List<Datum> data) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void update(List<Datum> data, double[][] r) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void moveNatural(List<Datum> data, double[][] r, double pace, double repeat) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<MultivariateTDistribution> constructPredictiveDistributions() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<RealMatrix> getMAPCovariances() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<RealVector> getMAPLocations() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
