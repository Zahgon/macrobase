package macrobase.ingest.result;

import java.util.List;

public class RowSet {

    public static class Row {

        private List<ColumnValue> columnValues;

        public Row(List<ColumnValue> columnValues) {
            this.columnValues = columnValues;
        }

        public List<ColumnValue> getColumnValues() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Row() {
            // JACKSON
        }
    }

    private List<Row> rows;

    public RowSet(List<Row> rows) {
        this.rows = rows;
    }

    public List<Row> getRows() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public RowSet() {
        // JACKSON
    }
}
