package edu.stanford.futuredata.macrobase.sql.tree;

import static com.google.common.base.MoreObjects.toStringHelper;
import static java.util.Objects.requireNonNull;
import com.google.common.collect.ImmutableList;
import edu.stanford.futuredata.macrobase.datamodel.Schema.ColType;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class ImportCsv extends Statement {

    private final String filename;

    private final QualifiedName tableName;

    private final Map<String, ColType> schema;

    public ImportCsv(String filename, QualifiedName tableName, List<ColumnDefinition> columns) {
        this(Optional.empty(), filename, tableName, columns);
    }

    public ImportCsv(NodeLocation location, String filename, QualifiedName tableName, List<ColumnDefinition> columns) {
        this(Optional.of(location), filename, tableName, columns);
    }

    private ImportCsv(Optional<NodeLocation> location, String filename, QualifiedName tableName, List<ColumnDefinition> columns) {
        super(location);
        this.filename = requireNonNull(filename, "table is null");
        this.tableName = requireNonNull(tableName, "where is null");
        requireNonNull(columns, "columns is null");
        this.schema = columns.stream().collect(Collectors.toMap(x -> x.getName().getValue(), this::getColType));
    }

    private ColType getColType(final ColumnDefinition colDef) {
        switch(colDef.getType()) {
            case "string":
                return ColType.STRING;
            case "double":
                return ColType.DOUBLE;
        }
        //
        return ColType.STRING;
    }

    public String getFilename() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public QualifiedName getTableName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Map<String, ColType> getSchema() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<Node> getChildren() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean equals(Object obj) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
