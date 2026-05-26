package macrobase.analysis.stats;

import macrobase.analysis.stats.kernel.EpanchnikovMulticativeKernel;
import macrobase.conf.ConfigurationException;
import macrobase.conf.MacroBaseConf;
import macrobase.datamodel.Datum;
import org.apache.commons.math3.linear.EigenDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.stat.descriptive.rank.Percentile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class KDE extends BatchTrainScore {

    // KDE defaults
    public static final Double KDE_BANDWIDTH_MULTIPLIER_DEFAULT = 1.0;

    public static final BandwidthAlgorithm KDE_BANDWIDTH_ALGORITHM_DEFAULT = KDE.BandwidthAlgorithm.OVERSMOOTHED;

    public static final KernelType KDE_KERNEL_TYPE_DEFAULT = KDE.KernelType.EPANECHNIKOV_MULTIPLICATIVE;

    // Algorithm to use when choosing the bandwidth for the given data.
    public static final String KDE_BANDWIDTH_ALGORITHM = "macrobase.analysis.kde.bandwidthAlgorithm";

    public static final String KDE_PROPORTION_OF_DATA_TO_USE = "macrobase.analysis.kde.proportionOfDataToUse";

    // Multiplies the bandwidth that was gotten algorithmically by this given constant (double).
    public static final String KDE_BANDWIDTH_MULTIPLIER = "macrobase.analysis.kde.bandwidthMultiplier";

    public static final String KDE_KERNEL_TYPE = "macrobase.analysis.kde.kernelType";

    public KDE.BandwidthAlgorithm getKDEBandwidth(MacroBaseConf conf) throws ConfigurationException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public KDE.KernelType getKDEKernelType(MacroBaseConf conf) throws ConfigurationException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static final Logger log = LoggerFactory.getLogger(KDE.class);

    protected double bandwidthDeterminantSqrt;

    protected KernelType kernelType;

    protected macrobase.analysis.stats.kernel.Kernel kernel;

    private List<Datum> densityPopulation;

    // symmetric and positive definite
    protected RealMatrix bandwidth;

    protected RealMatrix bandwidthToNegativeHalf;

    protected double scoreScalingFactor;

    private double[] allScores;

    private BandwidthAlgorithm bandwidthAlgorithm;

    protected double proportionOfDataToUse;

    protected double algorithmicBandwidthMultiplier = 1.0;

    private final Random random;

    protected int metricsDimensions;

    public enum BandwidthAlgorithm {

        NORMAL_SCALE, OVERSMOOTHED, MANUAL
    }

    public enum KernelType {

        EPANECHNIKOV_MULTIPLICATIVE;

        public macrobase.analysis.stats.kernel.Kernel constructKernel(int dimensions) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public KDE(MacroBaseConf conf) throws ConfigurationException {
        super(conf);
        this.random = conf.getRandom();
        this.kernelType = getKDEKernelType(conf);
        this.bandwidthAlgorithm = getKDEBandwidth(conf);
        log.debug("using {} bandwidth selection algorithm", this.bandwidthAlgorithm);
        this.algorithmicBandwidthMultiplier = conf.getDouble(KDE_BANDWIDTH_MULTIPLIER, KDE_BANDWIDTH_MULTIPLIER_DEFAULT);
        this.kernel = this.kernelType.constructKernel(this.metricsDimensions);
        // Pick 1 % of the data, randomly
        this.proportionOfDataToUse = 0.01;
    }

    public void setProportionOfDataToUse(double ratio) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Scaled version of the kernel (K_H in the literature)
     * @param vector
     * @return
     */
    protected double scaledKernelDensity(RealVector vector) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Manually set bandwidth of KDE
     *
     * @param bandwidth
     */
    public void setBandwidth(RealMatrix bandwidth) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Calculates bandwidth matrix based on the data that KDE should run on
     *
     * @param data
     */
    protected void setBandwidth(List<Datum> data) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void calculateBandwidthAncillaries() {
        RealMatrix inverseBandwidth;
        if (bandwidth.getColumnDimension() > 1) {
            inverseBandwidth = MatrixUtils.blockInverse(bandwidth, (bandwidth.getColumnDimension() - 1) / 2);
        } else {
            // Manually invert size 1 x 1 matrix, because block Inverse requires dimensions > 1
            inverseBandwidth = bandwidth.copy();
            inverseBandwidth.setEntry(0, 0, 1.0 / inverseBandwidth.getEntry(0, 0));
        }
        this.bandwidthToNegativeHalf = (new EigenDecomposition(inverseBandwidth)).getSquareRoot();
        this.bandwidthDeterminantSqrt = Math.sqrt((new EigenDecomposition(bandwidth)).getDeterminant());
    }

    @Override
    public void train(List<Datum> data) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public double score(Datum datum) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
