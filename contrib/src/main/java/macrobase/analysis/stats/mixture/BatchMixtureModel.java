package macrobase.analysis.stats.mixture;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import macrobase.analysis.stats.BatchTrainScore;
import macrobase.conf.MacroBaseConf;
import macrobase.datamodel.Datum;
import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public abstract class BatchMixtureModel extends BatchTrainScore {

    private static final Logger log = LoggerFactory.getLogger(BatchMixtureModel.class);

    protected final double progressCutoff;

    protected final int maxIterationsToConverge;

    protected MacroBaseConf conf;

    protected double trainTestSplit;

    protected final String initialClusterCentersFile;

    public BatchMixtureModel(MacroBaseConf conf) {
        super(conf);
        this.conf = conf;
        progressCutoff = conf.getDouble(GMMConf.ITERATIVE_PROGRESS_CUTOFF_RATIO, GMMConf.ITERATIVE_PROGRESS_CUTOFF_RATIO_DEFAULT);
        maxIterationsToConverge = conf.getInt(GMMConf.MAX_ITERATIONS_TO_CONVERGE, GMMConf.MAX_ITERATIONS_TO_CONVERGE_DEFAULT);
        trainTestSplit = conf.getDouble(GMMConf.TRAIN_TEST_SPLIT, GMMConf.TRAIN_TEST_SPLIT_DEFAULT);
        log.debug("max iter = {}", maxIterationsToConverge);
        this.initialClusterCentersFile = conf.getString(GMMConf.MIXTURE_CENTERS_FILE, null);
    }

    public static List<RealVector> initializeClustersFromFile(String filename, int K) throws FileNotFoundException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected static List<RealVector> gonzalezInitializeMixtureCenters(List<RealVector> pickedVectors, List<Datum> data, int K, Random rand) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected static List<RealVector> gonzalezInitializeMixtureCenters(List<Datum> data, int K, Random rand) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return centers of mixtures
     */
    public abstract List<RealVector> getClusterCenters();

    /**
     * @return weights of each cluster
     */
    public abstract double[] getClusterProportions();

    /**
     * @return covariances of mixture components
     */
    public abstract List<RealMatrix> getClusterCovariances();

    public abstract double[] getClusterProbabilities(Datum d);

    public boolean checkTermination(double logLikelihood, double oldLogLikelihood, int iteration) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
