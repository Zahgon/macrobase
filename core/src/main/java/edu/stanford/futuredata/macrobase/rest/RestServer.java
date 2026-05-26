package edu.stanford.futuredata.macrobase.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.stanford.futuredata.macrobase.analysis.summary.Explanation;
import edu.stanford.futuredata.macrobase.pipeline.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;
import static spark.Spark.*;

public class RestServer {

    private static Logger log = LoggerFactory.getLogger(RestServer.class);

    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Explanation processBasicBatchQuery(Request req, Response res) throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static String toJsonString(Object o) throws JsonProcessingException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
