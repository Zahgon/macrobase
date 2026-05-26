package macrobase.runtime.resources;

import macrobase.MacroBase;
import macrobase.analysis.pipeline.BasicBatchedPipeline;
import macrobase.analysis.pipeline.Pipeline;
import macrobase.analysis.result.AnalysisResult;
import macrobase.conf.MacroBaseConf;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/analyze")
@Produces(MediaType.APPLICATION_JSON)
public class AnalyzeResource extends BaseResource {

    private static final Logger log = LoggerFactory.getLogger(SchemaResource.class);

    static class AnalysisRequest {

        public String pgUrl;

        public String baseQuery;

        public List<String> attributes;

        public List<String> highMetrics;

        public List<String> lowMetrics;
    }

    static class AnalysisResponse {

        public List<AnalysisResult> results;

        public String errorMessage;
    }

    public AnalyzeResource(MacroBaseConf conf) {
        super(conf);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public AnalysisResponse getAnalysis(AnalysisRequest request) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
