package edu.stanford.futuredata.macrobase.sql.tree;

import static java.util.Objects.requireNonNull;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class RatioMetricExpression extends Expression {

    private final Identifier funcName;

    private final AggregateExpression aggExpr;

    public RatioMetricExpression(Identifier funcName, AggregateExpression aggExpr) {
        this(Optional.empty(), funcName, aggExpr);
    }

    public RatioMetricExpression(NodeLocation location, Identifier funcName, AggregateExpression aggExpr) {
        this(Optional.of(location), funcName, aggExpr);
    }

    private RatioMetricExpression(Optional<NodeLocation> location, Identifier funcName, AggregateExpression aggExpr) {
        super(location);
        requireNonNull(funcName, "funcName is null");
        requireNonNull(aggExpr, "aggExpr is null");
        this.funcName = funcName;
        this.aggExpr = aggExpr;
    }

    public Identifier getFuncName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AggregateExpression getAggExpr() {
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
    public boolean equals(Object obj) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
