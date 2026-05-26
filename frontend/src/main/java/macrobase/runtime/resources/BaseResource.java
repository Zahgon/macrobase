package macrobase.runtime.resources;

import macrobase.conf.ConfigurationException;
import macrobase.conf.MacroBaseConf;
import macrobase.conf.MacroBaseDefaults;
import macrobase.ingest.DataIngester;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

abstract public class BaseResource {

    protected final MacroBaseConf conf;

    protected String configuredIngester;

    public BaseResource(MacroBaseConf conf) {
        this.conf = conf;
        configuredIngester = conf.getString(MacroBaseConf.DATA_LOADER_TYPE, MacroBaseDefaults.DATA_LOADER_TYPE.toString());
    }

    protected DataIngester getLoader() throws ConfigurationException, SQLException, IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
