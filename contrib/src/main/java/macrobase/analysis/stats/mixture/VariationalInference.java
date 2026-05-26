package macrobase.analysis.stats.mixture;

import macrobase.datamodel.Datum;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

public class VariationalInference {

    private static final Logger log = LoggerFactory.getLogger(VariationalInference.class);

    public static double[][] normalizeLogProbabilities(double[] lnMixing, double[] lnPrecision, double[][] dataLogLike) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void trainTestStochastic(VarGMM model, List<Datum> trainData, List<Datum> testData, MixingComponents mixingComponents, NormalWishartClusters clusters, int desiredMinibatchSize, double delay, double forgettingRate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void trainTestMeanField(VarGMM model, List<Datum> trainData, List<Datum> testData, MixingComponents mixingComponents, NormalWishartClusters clusters) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static double step(double value, double newValue, double pace) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static RealVector step(RealVector start, RealVector end, double pace) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static RealMatrix step(RealMatrix start, RealMatrix end, double pace) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected static double[] calculateClusterWeights(double[][] r) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
