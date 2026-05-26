package macrobase.analysis.stats.mixture;

import macrobase.conf.MacroBaseConf;
import macrobase.datamodel.Datum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

/**
 * Fit Gaussian Mixture models using Variational Bayes
 */
public class FiniteGMM extends VarGMM {

    private static final Logger log = LoggerFactory.getLogger(FiniteGMM.class);

    // Number of mixture components
    protected int K;

    // Components.
    protected MultiComponents mixingComponents;

    public FiniteGMM(MacroBaseConf conf) {
        super(conf);
        this.K = conf.getInt(GMMConf.NUM_MIXTURES, GMMConf.NUM_MIXTURES_DEFAULT);
        log.debug("created Gaussian MM with {} mixtures", this.K);
    }

    @Override
    public void trainTest(List<Datum> trainData, List<Datum> testData) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public double[] getClusterProportions() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected double[] getNormClusterContrib() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double[] getPriorAdjustedClusterProportions() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public double[] getClusterProbabilities(Datum d) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
