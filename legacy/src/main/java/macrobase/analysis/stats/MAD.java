package macrobase.analysis.stats;

import com.codahale.metrics.Counter;
import com.codahale.metrics.Timer;
import macrobase.MacroBase;
import macrobase.conf.MacroBaseConf;
import macrobase.datamodel.Datum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;
import java.util.List;
import static com.codahale.metrics.MetricRegistry.name;

public class MAD extends BatchTrainScore {

    private static final Logger log = LoggerFactory.getLogger(MAD.class);

    private double median;

    private double MAD;

    private final Timer medianComputation = MacroBase.metrics.timer(name(MAD.class, "medianComputation"));

    private final Timer residualComputation = MacroBase.metrics.timer(name(MAD.class, "residualComputation"));

    private final Timer residualMedianComputation = MacroBase.metrics.timer(name(MAD.class, "residualMedianComputation"));

    private final Counter zeroMADs = MacroBase.metrics.counter(name(MAD.class, "zeroMADs"));

    private final double trimmedMeanFallback = 0.05;

    // https://en.wikipedia.org/wiki/Median_absolute_deviation#Relation_to_standard_deviation
    private final double MAD_TO_ZSCORE_COEFFICIENT = 1.4826;

    public MAD(MacroBaseConf conf) {
        super(conf);
    }

    @Override
    public void train(List<Datum> data) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public double score(Datum datum) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double getZScoreEquivalent(double zscore) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
