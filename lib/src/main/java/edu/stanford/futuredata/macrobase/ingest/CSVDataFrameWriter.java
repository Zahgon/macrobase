package edu.stanford.futuredata.macrobase.ingest;

import com.univocity.parsers.csv.CsvFormat;
import com.univocity.parsers.csv.CsvWriter;
import com.univocity.parsers.csv.CsvWriterSettings;
import edu.stanford.futuredata.macrobase.datamodel.DataFrame;
import edu.stanford.futuredata.macrobase.datamodel.Row;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class CSVDataFrameWriter {

    private final CsvFormat format;

    public CSVDataFrameWriter() {
        this.format = new CsvFormat();
    }

    public CSVDataFrameWriter(String fieldDelimiter, String lineDelimiter) {
        this();
        this.format.setDelimiter(fieldDelimiter.charAt(0));
        this.format.setLineSeparator(lineDelimiter);
    }

    public void writeToStream(DataFrame df, Writer out) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
