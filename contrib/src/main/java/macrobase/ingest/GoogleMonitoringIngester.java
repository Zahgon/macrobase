package macrobase.ingest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.Lists;
import com.google.api.services.monitoring.v3.Monitoring;
import com.google.api.services.monitoring.v3.Monitoring.Projects;
import com.google.api.services.monitoring.v3.MonitoringScopes;
import com.google.api.services.monitoring.v3.model.ListTimeSeriesResponse;
import com.google.api.services.monitoring.v3.model.Point;
import com.google.api.services.monitoring.v3.model.TimeSeries;
import io.dropwizard.jackson.Jackson;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import macrobase.analysis.pipeline.stream.MBStream;
import macrobase.conf.ConfigurationException;
import macrobase.conf.MacroBaseConf;
import macrobase.datamodel.Datum;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.util.List;

/**
 * An ingester that fetches data from the Google Monitoring API.
 *
 * The ingester
 *
 * @see "https://cloud.google.com/monitoring/api/v3/"
 */
public class GoogleMonitoringIngester extends DataIngester {

    private static final Logger log = LoggerFactory.getLogger(GoogleMonitoringIngester.class);

    // Queries given as a JSON string. Example:
    // {
    //   "queries": [
    //     {
    //       "project": "my-project",
    //       "filter": "metric.type=\"custom.googleapis.com/test\"",
    //       "alignmentPeriod": "300s",
    //       "perSeriesAligner": "ALIGN_MEAN",
    //       "crossSeriesReducer": "REDUCE_NONE",
    //       "groupByFields": []
    //     }
    //   ]
    // }
    public static final String GOOGLE_MONITORING_QUERIES = "macrobase.loader.googlemonitoring.queries";

    // Start and end times given in RFC3339 format. Example: "2016-08-08T12:00:00.0000Z"
    public static final String GOOGLE_MONITORING_START_TIME = "macrobase.loader.googlemonitoring.startTime";

    public static final String GOOGLE_MONITORING_END_TIME = "macrobase.loader.googlemonitoring.endTime";

    private MBStream<Datum> dataStream;

    private boolean loaded = false;

    private int pointsAdded = 0;

    private int skippedTimeSeries = 0;

    private int skippedPoints = 0;

    public GoogleMonitoringIngester(MacroBaseConf conf) throws ConfigurationException, IOException {
        super(conf);
    }

    @Override
    public MBStream<Datum> getStream() throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // Package scope to allow testing.
    QueryConf getQueries(String queryJson) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // Package scope to allow testing.
    void processResponse(ListTimeSeriesResponse response, List<String> allMetrics, Map<String, Map<String, Record>> byTime) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // Package scope to allow testing.
    Datum processRecord(Record rec) throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // Package scope to allow testing.
    MBStream<Datum> convertToStream(Map<String, Map<String, Record>> byTime) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Establishes an authenticated client using Application Default Credentials.
     *
     * @see "https://cloud.google.com/monitoring/demos/run_samples#before_you_begin"
     */
    private Monitoring buildClient() throws GeneralSecurityException, IOException {
        // Grab the Application Default Credentials from the environment.
        GoogleCredential credential = GoogleCredential.getApplicationDefault().createScoped(MonitoringScopes.all());
        // Create and return the CloudMonitoring service object
        HttpTransport httpTransport = new NetHttpTransport();
        JsonFactory jsonFactory = new JacksonFactory();
        return new Monitoring.Builder(httpTransport, jsonFactory, credential).setApplicationName("MacroBase Ingester").build();
    }

    // Package scope to allow testing.
    static class Record {

        public Map<String, String> attributes;

        // {metric_type, value}
        public Map<String, Double> values;
    }

    // A POJO that that holds configuration information about the API queries to run. The
    // object is deserialized from JSON.
    // Package scope to allow testing.
    static class QueryConf {

        static class Query {

            private String project = "";

            private String filter = "";

            private String alignmentPeriod = "";

            private String perSeriesAligner = "ALIGN_NONE";

            private String crossSeriesReducer = "REDUCE_NONE";

            private List<String> groupByFields = Lists.newArrayList();

            public String getProject() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            public void setProject(String project) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            public String getFilter() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            public void setFilter(String filter) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            public String getAlignmentPeriod() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            public void setAlignmentPeriod(String alignmentPeriod) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            public String getPerSeriesAligner() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            public void setPerSeriesAligner(String perSeriesAligner) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            public String getCrossSeriesReducer() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            public void setCrossSeriesReducer(String crossSeriesReducer) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            public List<String> getGroupByFields() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            public void setGroupByFields(List<String> groupByFields) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        }

        private List<Query> queries = Lists.newArrayList();

        public List<Query> getQueries() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void setQueries(List<Query> queries) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
