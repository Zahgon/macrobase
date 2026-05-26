package macrobase.analysis.transform;

import macrobase.analysis.pipeline.stream.MBStream;
import macrobase.conf.ConfigurationException;
import macrobase.conf.MacroBaseConf;
import macrobase.datamodel.Datum;
import java.util.ArrayList;
import java.util.List;

/*
 Takes the reciprocal of the specified metrics
 */
public class LowMetricTransform extends FeatureTransform {

    MBStream<Datum> output = new MBStream<>();

    final List<Integer> toTransform;

    public LowMetricTransform(MacroBaseConf conf) throws ConfigurationException {
        toTransform = new ArrayList<>();
        List<String> transformNames = conf.getStringList(MacroBaseConf.LOW_METRIC_TRANSFORM);
        List<String> metrics = conf.getStringList(MacroBaseConf.METRICS);
        for (String name : transformNames) {
            toTransform.add(metrics.indexOf(name));
        }
    }

    public LowMetricTransform(List<Integer> indexesToTransform) {
        toTransform = indexesToTransform;
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
