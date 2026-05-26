package edu.stanford.futuredata.macrobase.ingest;

import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import edu.stanford.futuredata.macrobase.datamodel.DataFrame;
import edu.stanford.futuredata.macrobase.datamodel.Schema;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CSVDataFrameParser implements DataFrameLoader {

    private Logger log = LoggerFactory.getLogger(CSVDataFrameParser.class);

    private CsvParser parser;

    private final List<String> requiredColumns;

    private Map<String, Schema.ColType> columnTypes;

    // when reading file, convert nulls to String "NULL" (default should be true)
    private final boolean convertNulls;

    private void init(String filename) {
        CsvParserSettings settings = new CsvParserSettings();
        settings.getFormat().setLineSeparator("\n");
        settings.setMaxCharsPerColumn(16384);
        CsvParser csvParser = new CsvParser(settings);
        csvParser.beginParsing(getReader(filename));
        this.parser = csvParser;
    }

    public CSVDataFrameParser(CsvParser parser, List<String> requiredColumns) {
        this.requiredColumns = requiredColumns;
        this.parser = parser;
        this.convertNulls = true;
    }

    public CSVDataFrameParser(String filename, List<String> requiredColumns) throws IOException {
        this.requiredColumns = requiredColumns;
        init(filename);
        this.convertNulls = true;
    }

    public CSVDataFrameParser(String filename, Map<String, Schema.ColType> types) throws IOException {
        this.requiredColumns = new ArrayList<>(types.keySet());
        this.columnTypes = types;
        init(filename);
        this.convertNulls = true;
    }

    public CSVDataFrameParser(String filename, Map<String, Schema.ColType> types, boolean convertNulls) throws IOException {
        this.requiredColumns = new ArrayList<>(types.keySet());
        this.columnTypes = types;
        init(filename);
        this.convertNulls = convertNulls;
    }

    @Override
    public DataFrameLoader setColumnTypes(Map<String, Schema.ColType> types) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public DataFrame load() throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static Reader getReader(String path) {
        try {
            InputStream targetStream = new FileInputStream(path.replaceFirst("^~", System.getProperty("user.home")));
            return new InputStreamReader(targetStream, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("File " + path + "is not encoded using UTF-8", e);
        } catch (FileNotFoundException e) {
            throw new IllegalStateException("File " + path + " cannot be found", e);
        }
    }
}
