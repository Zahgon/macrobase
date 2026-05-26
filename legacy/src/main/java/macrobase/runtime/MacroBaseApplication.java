package macrobase.runtime;

import com.codahale.metrics.health.HealthCheck;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import macrobase.conf.MacroBaseConf;
import macrobase.runtime.command.MacroBasePipelineCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MacroBaseApplication extends Application<MacroBaseConf> {

    private static final Logger log = LoggerFactory.getLogger(MacroBaseApplication.class);

    public static void main(String[] args) throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void initialize(Bootstrap<MacroBaseConf> bootstrap) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void run(MacroBaseConf configuration, Environment environment) throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
