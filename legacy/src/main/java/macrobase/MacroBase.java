package macrobase;

import java.util.concurrent.TimeUnit;
import macrobase.runtime.MacroBaseApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;

/**
 * Hello world!
 */
public class MacroBase {

    public static final MetricRegistry metrics = new MetricRegistry();

    public static final ConsoleReporter reporter = ConsoleReporter.forRegistry(metrics).convertRatesTo(TimeUnit.SECONDS).convertDurationsTo(TimeUnit.MILLISECONDS).build();

    @SuppressWarnings("unused")
    private static final Logger log = LoggerFactory.getLogger(MacroBase.class);

    public static void main(String[] args) throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
