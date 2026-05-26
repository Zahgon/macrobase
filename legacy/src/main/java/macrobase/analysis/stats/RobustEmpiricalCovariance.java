package macrobase.analysis.stats;

import macrobase.conf.MacroBaseConf;
import macrobase.conf.MacroBaseDefaults;
import macrobase.datamodel.Datum;
import java.util.ArrayList;
import java.util.List;

public class RobustEmpiricalCovariance extends BatchTrainScore {

    public Winsorizer trimmer;

    public Gaussian gModel;

    public static final String CONF_TRIM_PCT = "macrobase.analysis.rcov.trimPercent";

    public static final double CONF_TRIM_PCT_DEFAULT = 5.0;

    public RobustEmpiricalCovariance(MacroBaseConf conf) {
        super(conf);
        double trimPct = conf.getDouble(CONF_TRIM_PCT, CONF_TRIM_PCT_DEFAULT);
        trimmer = new Winsorizer(trimPct);
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
