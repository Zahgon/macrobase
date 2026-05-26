package macrobase.analysis.transform;

import macrobase.analysis.stats.mixture.BatchMixtureModel;
import macrobase.conf.ConfigurationException;
import macrobase.conf.MacroBaseConf;
import macrobase.datamodel.Datum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

/**
 * Similar to BatchScoreFeatureTransform, but instead of using the
 * score, operates on mixture models and returns probabilities of
 * data belonging to different clusters.
 */
public class BatchMixtureCoeffTransform extends BatchScoreFeatureTransform {

    private static final Logger log = LoggerFactory.getLogger(BatchMixtureCoeffTransform.class);

    protected BatchMixtureModel mixtureModel;

    public BatchMixtureCoeffTransform(MacroBaseConf conf) throws ConfigurationException {
        super(conf);
        this.mixtureModel = (BatchMixtureModel) this.batchTrainScore;
    }

    @Override
    public void consume(List<Datum> records) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public BatchMixtureModel getMixtureModel() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
