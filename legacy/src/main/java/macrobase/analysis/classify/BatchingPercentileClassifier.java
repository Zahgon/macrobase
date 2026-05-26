package macrobase.analysis.classify;

import macrobase.analysis.pipeline.stream.MBStream;
import macrobase.analysis.result.OutlierClassificationResult;
import macrobase.conf.MacroBaseConf;
import macrobase.conf.MacroBaseDefaults;
import macrobase.datamodel.Datum;
import org.apache.commons.math3.stat.descriptive.rank.Percentile;
import org.apache.commons.math3.stat.ranking.NaNStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

public class BatchingPercentileClassifier extends OutlierClassifier {

    private static final Logger log = LoggerFactory.getLogger(BatchingPercentileClassifier.class);

    MBStream<OutlierClassificationResult> results = new MBStream<>();

    // Between 0 - 1
    final double targetPercentile;

    public BatchingPercentileClassifier(MacroBaseConf conf) {
        this(conf.getDouble(MacroBaseConf.TARGET_PERCENTILE, MacroBaseDefaults.TARGET_PERCENTILE));
    }

    public BatchingPercentileClassifier(double percentile) {
        this.targetPercentile = percentile;
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
