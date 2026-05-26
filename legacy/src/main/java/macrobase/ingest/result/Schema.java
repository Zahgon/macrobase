package macrobase.ingest.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Schema {

    public static class SchemaColumn {

        private String name;

        private String type;

        public SchemaColumn(String name, String type) {
            this.name = name;
            this.type = type;
        }

        @JsonProperty
        public String getName() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @JsonProperty
        public String getType() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public SchemaColumn() {
            // Jackson
        }
    }

    private List<SchemaColumn> columns;

    @JsonProperty
    public List<SchemaColumn> getColumns() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Schema(List<SchemaColumn> _columns) {
        columns = _columns;
    }

    public Schema() {
        // Jackson
    }
}
