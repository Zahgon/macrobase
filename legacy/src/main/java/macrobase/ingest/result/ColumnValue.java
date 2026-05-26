package macrobase.ingest.result;

public class ColumnValue {

    private String column;

    private String value;

    public ColumnValue(String column, String value) {
        this.column = column;
        this.value = value;
    }

    public String getColumn() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getValue() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ColumnValue() {
        // JACKSON
    }
}
