package macrobase.analysis.stats.mixture;

import macrobase.analysis.stats.distribution.MultivariateTDistribution;
import macrobase.conf.MacroBaseConf;
import macrobase.datamodel.Datum;
import macrobase.util.TrainTestSpliter;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

/**
 * A class that combines methods for all variational inference
 * # subclasses that use a type of Gaussian Mixture Model
 */
public abstract class VarGMM extends BatchMixtureModel {

    private static final Logger log = LoggerFactory.getLogger(VarGMM.class);

    public static final double ZERO_LOG_SCORE = -10000;

    protected NormalWishartClusters clusters;

    protected List<MultivariateTDistribution> predictiveDistributions;

    protected abstract double[] getNormClusterContrib();

    public VarGMM(MacroBaseConf conf) {
        super(conf);
    }

    @Override
    public void train(List<Datum> data) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public abstract void trainTest(List<Datum> trainData, List<Datum> testData);

    @Override
    public List<RealMatrix> getClusterCovariances() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<RealVector> getClusterCenters() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double calculateLogLikelihood(List<Datum> data, MixingComponents mixingComonents, NormalWishartClusters clusters) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param datum
     * @return log probability density of the given datum (or -10000 if probability density is 0)
     */
    @Override
    public double score(Datum datum) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public double[] getClusterProbabilities(Datum d) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
