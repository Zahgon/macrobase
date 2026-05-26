package macrobase.analysis.classify;

import macrobase.analysis.pipeline.stream.MBStream;
import macrobase.analysis.result.OutlierClassificationResult;
import macrobase.conf.MacroBaseConf;
import macrobase.conf.MacroBaseDefaults;
import macrobase.datamodel.Datum;
import java.util.List;

public class StaticThresholdClassifier extends OutlierClassifier {

    MBStream<OutlierClassificationResult> results = new MBStream<>();

    private final double threshold;

    public StaticThresholdClassifier(MacroBaseConf conf) {
        threshold = conf.getDouble(MacroBaseConf.OUTLIER_STATIC_THRESHOLD, MacroBaseDefaults.OUTLIER_STATIC_THRESHOLD);
    }

    @Override
    public MBStream<OutlierClassificationResult> getStream() {
        throw new UnsupportedOperationException("STUB: not implemented");
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
}
