package macrobase.analysis.summary;

import com.google.common.base.Stopwatch;
import macrobase.analysis.pipeline.stream.MBStream;
import macrobase.analysis.result.OutlierClassificationResult;
import macrobase.analysis.summary.itemset.FPGrowthEmerging;
import macrobase.analysis.summary.itemset.result.ItemsetResult;
import macrobase.conf.MacroBaseConf;
import macrobase.conf.MacroBaseDefaults;
import macrobase.datamodel.Datum;
import macrobase.ingest.DatumEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BatchSummarizer extends Summarizer {

    private FPGrowthEmerging fpg;

    protected final Double minSupport;

    protected final Double minOIRatio;

    private MBStream<Summary> output = new MBStream<>();

    private final DatumEncoder encoder;

    public BatchSummarizer(MacroBaseConf conf) {
        fpg = new FPGrowthEmerging(conf.getBoolean(MacroBaseConf.ATTRIBUTE_COMBINATIONS, MacroBaseDefaults.ATTRIBUTE_COMBINATIONS));
        minOIRatio = conf.getDouble(MacroBaseConf.MIN_OI_RATIO, MacroBaseDefaults.MIN_OI_RATIO);
        minSupport = conf.getDouble(MacroBaseConf.MIN_SUPPORT, MacroBaseDefaults.MIN_SUPPORT);
        encoder = conf.getEncoder();
    }

    @Override
    public MBStream<Summary> getStream() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void initialize() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private Summary summary = null;

    @Override
    public void consume(List<OutlierClassificationResult> records) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void shutdown() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Summarizer summarize() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
