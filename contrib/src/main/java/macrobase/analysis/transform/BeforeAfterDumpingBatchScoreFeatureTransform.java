package macrobase.analysis.transform;

import macrobase.analysis.pipeline.stream.MBStream;
import macrobase.conf.ConfigurationException;
import macrobase.conf.MacroBaseConf;
import macrobase.datamodel.Datum;
import macrobase.diagnostics.JsonUtils;
import macrobase.diagnostics.MetricsAndMetrics;
import macrobase.diagnostics.ScoreDumper;
import java.util.ArrayList;
import java.util.List;

public class BeforeAfterDumpingBatchScoreFeatureTransform extends FeatureTransform {

    public static final String SCORED_DATA_FILE = null;

    private final String dumpFilename;

    private FeatureTransform underlyingTransform;

    private final MBStream<Datum> output = new MBStream<>();

    public BeforeAfterDumpingBatchScoreFeatureTransform(MacroBaseConf conf, FeatureTransform transform) throws ConfigurationException {
        this.dumpFilename = conf.getString(ScoreDumper.SCORED_DATA_FILE, SCORED_DATA_FILE);
        this.underlyingTransform = transform;
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
    public MBStream<Datum> getStream() throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
