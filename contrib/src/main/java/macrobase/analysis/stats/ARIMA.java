package macrobase.analysis.stats;

import macrobase.conf.MacroBaseConf;
import macrobase.datamodel.Datum;
import org.rosuda.JRI.Rengine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.DoubleStream;

/**
 * ARIMA time series predictions. Note that this implementation doesn't support
 * points that are not evenly distributed, and thus the time for each datum is
 * simply ignored and we assume that they are evenly distributed.
 *
 * We use R to make these predictions, so you need to have R and rJava
 * installed. In addition, you need to install the R package 'forecast' (using
 * `install.packages('forecast', dependencies = TRUE)`), and set the R_HOME
 * environment variable appropriately (you can get its value by running
 * `R.home()` inside R).
 */
public class ARIMA extends TimeSeriesScore {

    public static final String R_LOG_FILE_DEFAULT = null;

    public static final String R_LOG_FILE = "macrobase.analysis.r.logfile";

    private static final Logger log = LoggerFactory.getLogger(ARIMA.class);

    private Queue<Double> window = new LinkedList<Double>();

    private Double latestScore;

    private Queue<Double> predictions;

    private int datumCounter;

    private static Rengine re;

    public ARIMA(MacroBaseConf conf) {
        super(conf);
        if (re == null) {
            re = new Rengine(new String[] { "--vanilla" }, false, null);
        }
        if (!re.waitForR()) {
            throw new RuntimeException("Unable to load R");
        }
        re.eval("library(forecast)");
        String logFile = conf.getString(R_LOG_FILE, R_LOG_FILE_DEFAULT);
        if (logFile != null) {
            re.eval("log <- file('" + logFile + "')");
            re.eval("sink(log, append=TRUE)");
            re.eval("sink(log, append=TRUE, type='message')");
        }
    }

    @Override
    public void train(List<Datum> data) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void addToWindow(Datum datum) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void removeLastFromWindow() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void trainWindow() {
        log.debug("Running ARIMA trainWindow");
        if (predictions == null) {
            predictions = new LinkedList<Double>();
        }
        double[] windowArray = window.stream().mapToDouble(Double::doubleValue).toArray();
        re.assign("data", windowArray);
        // TODO reuse old models
        re.eval("fit <- auto.arima(data)");
        // TODO add config option for how far we should predict before
        // retraining - allow configuring how often we update parameters, and
        // also how often we update model order.
        double[] result = re.eval("forecast(fit, h=" + tupleWindowSize + ")$mean").asDoubleArray();
        Double[] boxedResult = DoubleStream.of(result).boxed().toArray(size -> new Double[size]);
        Collections.addAll(predictions, boxedResult);
    }

    @Override
    public double scoreWindow() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
