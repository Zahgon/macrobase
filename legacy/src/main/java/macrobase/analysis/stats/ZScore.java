package macrobase.analysis.stats;

import com.codahale.metrics.Timer;
import macrobase.MacroBase;
import macrobase.conf.MacroBaseConf;
import macrobase.datamodel.Datum;
import java.util.List;
import static com.codahale.metrics.MetricRegistry.name;

public class ZScore extends BatchTrainScore {

    private double mean;

    private double std;

    private final Timer meanComputation = MacroBase.metrics.timer(name(ZScore.class, "meanComputation"));

    private final Timer stddevComputation = MacroBase.metrics.timer(name(ZScore.class, "stddevComputation"));

    public ZScore(MacroBaseConf conf) {
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
}
