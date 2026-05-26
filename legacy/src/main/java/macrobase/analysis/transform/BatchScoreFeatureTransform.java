package macrobase.analysis.transform;

import macrobase.analysis.pipeline.stream.MBStream;
import macrobase.analysis.stats.BatchTrainScore;
import macrobase.conf.ConfigurationException;
import macrobase.conf.MacroBaseConf;
import macrobase.datamodel.Datum;
import java.util.ArrayList;
import java.util.List;

public class BatchScoreFeatureTransform extends FeatureTransform {

    protected BatchTrainScore batchTrainScore;

    protected MacroBaseConf conf;

    private boolean requiresTraining = true;

    protected final MBStream<Datum> output = new MBStream<>();

    public BatchScoreFeatureTransform(MacroBaseConf conf) throws ConfigurationException {
        this.batchTrainScore = conf.constructTransform();
        this.conf = conf;
    }

    public BatchScoreFeatureTransform(MacroBaseConf conf, BatchTrainScore bts) throws ConfigurationException {
        this.batchTrainScore = bts;
        this.conf = conf;
    }

    public BatchScoreFeatureTransform(BatchTrainScore batchTrainScore, boolean requiresTraining) {
        this.batchTrainScore = batchTrainScore;
        this.requiresTraining = requiresTraining;
    }

    @Override
    public void initialize() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void consume(List<Datum> records) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void shutdown() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public BatchTrainScore getBatchTrainScore() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MBStream<Datum> getStream() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
