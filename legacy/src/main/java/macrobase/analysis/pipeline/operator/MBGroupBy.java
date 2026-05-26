package macrobase.analysis.pipeline.operator;

import macrobase.analysis.pipeline.stream.MBMultiInputStream;
import macrobase.analysis.pipeline.stream.MBStream;
import macrobase.analysis.transform.FeatureTransform;
import macrobase.datamodel.Datum;
import macrobase.util.CheckedSupplier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MBGroupBy extends MBOperator<Datum, Datum> {

    private final List<Integer> groupByColumn;

    private final CheckedSupplier<FeatureTransform> aggregator;

    Map<List<Integer>, FeatureTransform> transformMap = new HashMap<>();

    private final MBMultiInputStream<Datum> outputStream = new MBMultiInputStream<>();

    public MBGroupBy(List<Integer> groupByColumn, CheckedSupplier<FeatureTransform> aggregator) {
        this.groupByColumn = groupByColumn;
        this.aggregator = aggregator;
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
