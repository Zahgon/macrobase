package macrobase.runtime.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import macrobase.conf.MacroBaseConf;
import macrobase.ingest.SQLIngester;
import macrobase.ingest.result.RowSet;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;

@Path("/rows/fmt")
@Produces(MediaType.APPLICATION_JSON)
public class FormattedRowSetResource extends BaseResource {

    private static final Logger log = LoggerFactory.getLogger(SchemaResource.class);

    public enum RETURNTYPE {

        JSON, CSV, SQL
    }

    public static class RowSetRequest {

        public String pgUrl;

        public String baseQuery;

        public List<RowRequestPair> columnValues;

        public int limit;

        public int offset;

        public RETURNTYPE returnType;

        public static class RowRequestPair {

            public String column;

            public String value;
        }
    }

    public static class FormattedRowSetResponse {

        public String response;

        public String errorMessage;
    }

    public FormattedRowSetResource(MacroBaseConf conf) {
        super(conf);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public FormattedRowSetResponse getRowsFormatted(RowSetRequest request) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
