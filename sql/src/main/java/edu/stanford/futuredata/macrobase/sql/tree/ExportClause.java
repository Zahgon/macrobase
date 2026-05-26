package edu.stanford.futuredata.macrobase.sql.tree;

import static com.google.common.base.MoreObjects.toStringHelper;
import static java.util.Objects.requireNonNull;
import com.google.common.collect.ImmutableList;
import edu.stanford.futuredata.macrobase.sql.parser.ParsingException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ExportClause extends Node {

    private final String fieldDelimiter;

    private final String lineDelimiter;

    private final String filename;

    public ExportClause(Optional<DelimiterClause> fieldDelimiter, Optional<DelimiterClause> lineDelimiter, String filename) {
        this(Optional.empty(), fieldDelimiter, lineDelimiter, filename);
    }

    public ExportClause(NodeLocation location, Optional<DelimiterClause> fieldDelimiter, Optional<DelimiterClause> lineDelimiter, String filename) {
        this(Optional.of(location), fieldDelimiter, lineDelimiter, filename);
    }

    private ExportClause(Optional<NodeLocation> location, Optional<DelimiterClause> fieldDelimiter, Optional<DelimiterClause> lineDelimiter, String filename) {
        super(location);
        requireNonNull(fieldDelimiter, "fieldDelimiter is null");
        requireNonNull(lineDelimiter, "lineDelimiter is null");
        requireNonNull(filename, "filename is null");
        this.fieldDelimiter = fieldDelimiter.orElse(new DelimiterClause(",")).toString();
        if (this.fieldDelimiter.length() != 1) {
            throw new ParsingException("FIELDS TERMINATED BY argument has length not equal to 1");
        }
        this.lineDelimiter = lineDelimiter.orElse(new DelimiterClause("\n")).toString();
        this.filename = filename;
    }

    public String getFilename() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getFieldDelimiter() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getLineDelimiter() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<? extends Node> getChildren() {
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
