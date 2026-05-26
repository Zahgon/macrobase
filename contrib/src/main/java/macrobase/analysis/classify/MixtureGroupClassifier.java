package macrobase.analysis.classify;

import macrobase.analysis.pipeline.stream.MBStream;
import macrobase.analysis.result.OutlierClassificationResult;
import macrobase.analysis.stats.mixture.BatchMixtureModel;
import macrobase.analysis.stats.mixture.GMMConf;
import macrobase.conf.ConfigurationException;
import macrobase.conf.MacroBaseConf;
import macrobase.datamodel.Datum;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

/**
 * Tags points of the group which has it's center closest to TARGET_GROUP location as outliers.
 * Assumes that the input data already has probabilities corresponding to each of the groups as their metrics.
 */
public class MixtureGroupClassifier extends OutlierClassifier {

    private static final Logger log = LoggerFactory.getLogger(MixtureGroupClassifier.class);

    private RealVector targetLocation;

    private final BatchMixtureModel mixtureModel;

    MBStream<OutlierClassificationResult> results = new MBStream<>();

    private int targetClusterIndex = -1;

    public MixtureGroupClassifier(MacroBaseConf conf, BatchMixtureModel mixtureModel) throws ConfigurationException {
        List<Double> list = conf.getDoubleList(GMMConf.TARGET_GROUP, null);
        Double[] array = new Double[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        this.targetLocation = new ArrayRealVector(array);
        this.mixtureModel = mixtureModel;
    }

    public MixtureGroupClassifier(MacroBaseConf conf, BatchMixtureModel mixtureModel, int targetClusterIndex) throws ConfigurationException {
        this.mixtureModel = mixtureModel;
        this.targetClusterIndex = targetClusterIndex;
    }

    @Override
    public void initialize() throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void consume(List<Datum> records) throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void shutdown() throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MBStream<OutlierClassificationResult> getStream() throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setTargetClusterIndex(List<Datum> records) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
