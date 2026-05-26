package edu.stanford.futuredata.macrobase.sql.tree;

import static com.google.common.base.Preconditions.checkArgument;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;

public class DereferenceExpression extends Expression {

    private final Expression base;

    private final Identifier field;

    public DereferenceExpression(Expression base, Identifier field) {
        this(Optional.empty(), base, field);
    }

    public DereferenceExpression(NodeLocation location, Expression base, Identifier field) {
        this(Optional.of(location), base, field);
    }

    private DereferenceExpression(Optional<NodeLocation> location, Expression base, Identifier field) {
        super(location);
        checkArgument(base != null, "base is null");
        checkArgument(field != null, "fieldName is null");
        this.base = base;
        this.field = field;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<Node> getChildren() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Expression getBase() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Identifier getField() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * If this DereferenceExpression looks like a QualifiedName, return QualifiedName. Otherwise
     * return null
     */
    public static QualifiedName getQualifiedName(DereferenceExpression expression) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Expression from(QualifiedName name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static List<String> tryParseParts(Expression base, String fieldName) {
        if (base instanceof Identifier) {
            return ImmutableList.of(((Identifier) base).getValue(), fieldName);
        } else if (base instanceof DereferenceExpression) {
            QualifiedName baseQualifiedName = getQualifiedName((DereferenceExpression) base);
            if (baseQualifiedName != null) {
                List<String> newList = new ArrayList<>(baseQualifiedName.getParts());
                newList.add(fieldName);
                return newList;
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
