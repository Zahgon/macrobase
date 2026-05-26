package macrobase.conf;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import io.dropwizard.Configuration;
import macrobase.analysis.stats.*;
import macrobase.ingest.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public class MacroBaseConf extends Configuration {

    private static final Logger log = LoggerFactory.getLogger(MacroBaseConf.class);

    public static final String QUERY_NAME = "macrobase.query.name";

    public static final String PIPELINE_NAME = "macrobase.pipeline.class";

    public static final String TARGET_PERCENTILE = "macrobase.analysis.targetPercentile";

    public static final String MIN_SUPPORT = "macrobase.analysis.minSupport";

    public static final String MIN_OI_RATIO = "macrobase.analysis.minOIRatio";

    public static final String ATTRIBUTE_COMBINATIONS = "macrobase.analysis.summary.findAttributeCombinations";

    public static final String RANDOM_SEED = "macrobase.analysis.randomSeed";

    public static final String USE_PERCENTILE = "macrobase.analysis.usePercentile";

    public static final String TRANSFORM_TYPE = "macrobase.analysis.transformType";

    public static final String WARMUP_COUNT = "macrobase.analysis.streaming.warmupCount";

    public static final String TUPLE_BATCH_SIZE = "macrobase.analysis.streaming.tupleBatchSize";

    public static final String INPUT_RESERVOIR_SIZE = "macrobase.analysis.streaming.inputReservoirSize";

    public static final String SCORE_RESERVOIR_SIZE = "macrobase.analysis.streaming.scoreReservoirSize";

    public static final String SUMMARY_UPDATE_PERIOD = "macrobase.analysis.streaming.summaryUpdatePeriod";

    public static final String DECAY_TYPE = "macrobase.analysis.streaming.decayType";

    public static final String DECAY_RATE = "macrobase.analysis.streaming.decayRate";

    public static final String MODEL_UPDATE_PERIOD = "macrobase.analysis.streaming.modelUpdatePeriod";

    public static final String OUTLIER_ITEM_SUMMARY_SIZE = "macrobase.analysis.streaming.outlierSummarySize";

    public static final String INLIER_ITEM_SUMMARY_SIZE = "macrobase.analysis.streaming.inlierItemSummarySize";

    public static final String TUPLE_WINDOW = "macrobase.analysis.timeseries.tupleWindow";

    public static final String TIME_WINDOW = "macrobase.analysis.timeseries.timeWindow";

    public static final String MCD_ALPHA = "macrobase.analysis.mcd.alpha";

    public static final String MCD_STOPPING_DELTA = "macrobase.analysis.mcd.stoppingDelta";

    public static final String RANDOM_PROJECTION_K = "macrobase.analysis.randomProjection.k";

    public static final String TRUNCATE_K = "macrobase.analysis.truncate.k";

    public static final String DATA_LOADER_TYPE = "macrobase.loader.loaderType";

    public static final String TIME_COLUMN = "macrobase.loader.timeColumn";

    public static final String ATTRIBUTES = "macrobase.loader.attributes";

    public static final String METRICS = "macrobase.loader.metrics";

    public static final String LOW_METRIC_TRANSFORM = "macrobase.analysis.metrics.lowTransform";

    public static final String JDBC_PROPERTIES = "macrobase.loader.jdbc.properties";

    public static final String BASE_QUERY = "macrobase.loader.db.baseQuery";

    public static final String DB_USER = "macrobase.loader.db.user";

    public static final String DB_PASSWORD = "macrobase.loader.db.password";

    public static final String DB_NAME = "macrobase.loader.db.database";

    public static final String DB_URL = "macrobase.loader.db.url";

    public static final String DB_CACHE_DIR = "macrobase.loader.db.cacheDirectory";

    public static final String DB_CACHE_CHUNK_SIZE = "macrobase.loader.db.cacheChunkSizeTuples";

    public static final String CSV_INPUT_FILE = "macrobase.loader.csv.file";

    public static final String CSV_COMPRESSION = "macrobase.loader.csv.compression";

    public static final String OUTLIER_STATIC_THRESHOLD = "macrobase.analysis.classify.outlierStaticThreshold";

    private final DatumEncoder datumEncoder;

    public MacroBaseConf() {
        datumEncoder = new DatumEncoder();
        _conf = new HashMap<>();
    }

    public DataIngester constructIngester() throws ConfigurationException, SQLException, IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public DatumEncoder getEncoder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public enum PeriodType {

        TUPLE_BASED, TIME_BASED
    }

    public enum TransformType {

        MAD_OR_MCD,
        MAD,
        MCD,
        RCOV,
        ZSCORE,
        MOVING_AVERAGE
    }

    public Random getRandom() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public BatchTrainScore constructTransform() throws ConfigurationException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public enum DataIngesterType {

        CSV_LOADER, POSTGRES_LOADER, CACHING_POSTGRES_LOADER, MYSQL_LOADER, CACHING_MYSQL_LOADER
    }

    private Map<String, String> _conf;

    @JsonAnySetter
    public MacroBaseConf set(String key, Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Boolean isSet(String key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getString(String key) throws ConfigurationException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getString(String key, String defaultValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<String> getStringList(String key) throws ConfigurationException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<String> getStringList(String key, List<String> defaultValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Double getDouble(String key) throws ConfigurationException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Double getDouble(String key, Double defaultValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Map<String, String> getMap(String key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<Double> getDoubleList(String key) throws ConfigurationException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<Double> getDoubleList(String key, List<Double> defaultValue) throws ConfigurationException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Integer getInt(String key) throws ConfigurationException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Integer getInt(String key, Integer defaultValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Long getLong(String key) throws ConfigurationException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Long getLong(String key, Long defaultValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Boolean getBoolean(String key) throws ConfigurationException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Boolean getBoolean(String key, Boolean defaultValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public CSVIngester.Compression getCsvCompression() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public PeriodType getDecayType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void loadSystemProperties() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
