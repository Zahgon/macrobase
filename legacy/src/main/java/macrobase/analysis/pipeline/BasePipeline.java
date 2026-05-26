package macrobase.analysis.pipeline;

import macrobase.conf.MacroBaseConf;
import macrobase.conf.MacroBaseDefaults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public abstract class BasePipeline implements Pipeline {

    private static Logger log = LoggerFactory.getLogger(BasePipeline.class);

    protected MacroBaseConf conf;

    @Override
    public Pipeline initialize(MacroBaseConf conf) throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
