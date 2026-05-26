package macrobase.analysis.transform;

import macrobase.analysis.pipeline.stream.MBStream;
import macrobase.datamodel.Datum;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;
import java.util.List;

public class LinearMetricNormalizer extends FeatureTransform {

    private MBStream<Datum> output = new MBStream<>();

    @Override
    public void consume(List<Datum> data) {
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

    @Override
    public MBStream<Datum> getStream() throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
