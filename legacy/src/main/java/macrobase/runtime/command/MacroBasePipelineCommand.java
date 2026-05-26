package macrobase.runtime.command;

import io.dropwizard.cli.ConfiguredCommand;
import io.dropwizard.setup.Bootstrap;
import macrobase.MacroBase;
import macrobase.analysis.pipeline.Pipeline;
import macrobase.analysis.result.AnalysisResult;
import macrobase.conf.MacroBaseConf;
import net.sourceforge.argparse4j.inf.Namespace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class MacroBasePipelineCommand extends ConfiguredCommand<MacroBaseConf> {

    private static final Logger log = LoggerFactory.getLogger(MacroBasePipelineCommand.class);

    public MacroBasePipelineCommand() {
        super("pipeline", "Run pipeline without starting server.");
    }

    @Override
    protected void run(Bootstrap<MacroBaseConf> bootstrap, Namespace namespace, MacroBaseConf configuration) throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
