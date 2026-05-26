package edu.stanford.futuredata.macrobase.sql.tree;

import static java.util.Objects.requireNonNull;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.Optional;
import org.apache.commons.lang3.StringEscapeUtils;

public class DelimiterClause extends Node {

    private final String delimiter;

    public DelimiterClause(String delimiter) {
        this(Optional.empty(), delimiter);
    }

    public DelimiterClause(NodeLocation location, String delimiter) {
        this(Optional.of(location), delimiter);
    }

    private DelimiterClause(Optional<NodeLocation> location, String delimiter) {
        super(location);
        requireNonNull(delimiter, "delimiter is null");
        this.delimiter = StringEscapeUtils.unescapeJava(delimiter);
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
