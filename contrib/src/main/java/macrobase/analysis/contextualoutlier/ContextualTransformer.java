package macrobase.analysis.contextualoutlier;

import macrobase.MacroBase;
import macrobase.analysis.pipeline.operator.MBOperator;
import macrobase.analysis.pipeline.operator.MBProducer;
import macrobase.analysis.pipeline.stream.MBStream;
import macrobase.conf.MacroBaseConf;
import macrobase.datamodel.Datum;
import java.util.ArrayList;
import java.util.List;

public class ContextualTransformer extends MBOperator<Datum, ContextualDatum> {

    private final MacroBaseConf conf;

    private final MBStream<ContextualDatum> output = new MBStream<>();

    public ContextualTransformer(MacroBaseConf conf) {
        this.conf = conf;
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
    public MBStream<ContextualDatum> getStream() throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
