package edu.stanford.futuredata.macrobase.pipeline;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.stanford.futuredata.macrobase.datamodel.DataFrame;
import edu.stanford.futuredata.macrobase.datamodel.Schema;
import edu.stanford.futuredata.macrobase.ingest.CSVDataFrameParser;
import edu.stanford.futuredata.macrobase.ingest.RESTDataFrameLoader;
import edu.stanford.futuredata.macrobase.util.MacroBaseException;
import java.util.Map;
import java.util.List;

public class PipelineUtils {

    public static DataFrame loadDataFrame(String inputURI, Map<String, Schema.ColType> colTypes, List<String> requiredColumns) throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static DataFrame loadDataFrame(String inputURI, Map<String, Schema.ColType> colTypes, Map<String, String> restHeader, Map<String, Object> jsonBody, boolean usePost, List<String> requiredColumns) throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Pipeline createPipeline(PipelineConfig conf) throws MacroBaseException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
