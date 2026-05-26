package macrobase.runtime.resources;

import macrobase.conf.MacroBaseConf;
import macrobase.ingest.SQLIngester;
import macrobase.ingest.result.Schema;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;

@Path("/schema")
@Produces(MediaType.APPLICATION_JSON)
public class SchemaResource extends BaseResource {

    private static final Logger log = LoggerFactory.getLogger(SchemaResource.class);

    static class SchemaRequest {

        public String pgUrl;

        public String baseQuery;
    }

    static class SchemaResponse {

        public Schema schema;

        public String errorMessage;
    }

    public SchemaResource(MacroBaseConf conf) {
        super(conf);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public SchemaResponse getSchema(SchemaRequest request) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
