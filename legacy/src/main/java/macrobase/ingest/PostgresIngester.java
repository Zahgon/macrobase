package macrobase.ingest;

import macrobase.conf.ConfigurationException;
import macrobase.conf.MacroBaseConf;
import java.sql.SQLException;

public class PostgresIngester extends SQLIngester {

    public PostgresIngester(MacroBaseConf conf) throws ConfigurationException, SQLException {
        super(conf);
    }

    @Override
    public String getDriverClass() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String getJDBCUrlPrefix() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
