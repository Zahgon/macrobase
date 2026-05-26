package macrobase.analysis.stats;

import macrobase.analysis.pipeline.stream.MBStream;
import macrobase.analysis.transform.FeatureTransform;
import macrobase.conf.MacroBaseConf;
import macrobase.conf.MacroBaseDefaults;
import macrobase.datamodel.Datum;
import org.apache.commons.math3.linear.RealVector;
import java.util.List;

/**
 * The Truncate transform truncates each metric vector to be of length k.
 * It preserves just the top k components, and drops the last n - k.
 */
public class Truncate extends FeatureTransform {

    private RealVector metricVector;

    private RealVector transformedVector;

    private int k;

    private final MBStream<Datum> output = new MBStream<>();

    public Truncate(MacroBaseConf conf) {
        this.k = conf.getInt(MacroBaseConf.TRUNCATE_K, MacroBaseDefaults.TRUNCATE_K);
    }

    @Override
    public void consume(List<Datum> records) throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MBStream<Datum> getStream() throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void initialize() throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void shutdown() throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
