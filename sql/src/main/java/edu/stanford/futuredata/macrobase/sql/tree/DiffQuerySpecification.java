package edu.stanford.futuredata.macrobase.sql.tree;

import static com.google.common.base.MoreObjects.toStringHelper;
import static java.util.Objects.requireNonNull;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class DiffQuerySpecification extends QueryBody {

    private final Select select;

    // Either first and second are present, or splitQuery is
    private final Optional<TableSubquery> first;

    private final Optional<TableSubquery> second;

    private final Optional<SplitQuery> splitQuery;

    // Required
    private final List<Identifier> attributeCols;

    // Optional, with defaults
    private final MinRatioExpression minRatioExpr;

    private final MinSupportExpression minSupportExpr;

    private final RatioMetricExpression ratioMetricExpr;

    private final IntLiteral maxCombo;

    // Optional
    private final Optional<Expression> where;

    private final Optional<OrderBy> orderBy;

    private final Optional<String> limit;

    private final Optional<ExportClause> exportExpr;

    private static final IntLiteral DEFAULT_MAX_COMBO = new IntLiteral("3");

    private static final MinRatioExpression DEFAULT_MIN_RATIO_EXPRESSION = new MinRatioExpression(new DecimalLiteral("1.5"));

    private static final MinSupportExpression DEFAULT_MIN_SUPPORT_EXPRESSION = new MinSupportExpression(new DecimalLiteral("0.2"));

    private static final RatioMetricExpression DEFAULT_RATIO_METRIC_EXPRESSION = new RatioMetricExpression(new Identifier("global_ratio"), new AggregateExpression(new Aggregate("COUNT")));

    public DiffQuerySpecification(Select select, Optional<TableSubquery> first, Optional<TableSubquery> second, Optional<SplitQuery> splitQuery, List<Identifier> attributeCols, Optional<MinRatioExpression> minRatioExpr, Optional<MinSupportExpression> minSupportExpr, Optional<RatioMetricExpression> ratioMetricExpr, Optional<IntLiteral> maxCombo, Optional<Expression> where, Optional<OrderBy> orderBy, Optional<String> limit, Optional<ExportClause> exportExpr) {
        this(Optional.empty(), select, first, second, splitQuery, attributeCols, minRatioExpr, minSupportExpr, ratioMetricExpr, maxCombo, where, orderBy, limit, exportExpr);
    }

    public DiffQuerySpecification(NodeLocation location, Select select, Optional<TableSubquery> first, Optional<TableSubquery> second, Optional<SplitQuery> splitQuery, List<Identifier> attributeCols, Optional<MinRatioExpression> minRatioExpr, Optional<MinSupportExpression> minSupportExpr, Optional<RatioMetricExpression> ratioMetricExpr, Optional<IntLiteral> maxCombo, Optional<Expression> where, Optional<OrderBy> orderBy, Optional<String> limit, Optional<ExportClause> exportExpr) {
        this(Optional.of(location), select, first, second, splitQuery, attributeCols, minRatioExpr, minSupportExpr, ratioMetricExpr, maxCombo, where, orderBy, limit, exportExpr);
    }

    private DiffQuerySpecification(Optional<NodeLocation> location, Select select, Optional<TableSubquery> first, Optional<TableSubquery> second, Optional<SplitQuery> splitQuery, List<Identifier> attributeCols, Optional<MinRatioExpression> minRatioExpr, Optional<MinSupportExpression> minSupportExpr, Optional<RatioMetricExpression> ratioMetricExpr, Optional<IntLiteral> maxCombo, Optional<Expression> where, Optional<OrderBy> orderBy, Optional<String> limit, Optional<ExportClause> exportExpr) {
        super(location);
        requireNonNull(select, "select is null");
        requireNonNull(first, "first is null");
        requireNonNull(second, "second is null");
        requireNonNull(splitQuery, "splitQuery is null");
        requireNonNull(attributeCols, "attributeCols is null");
        requireNonNull(minRatioExpr, "minRatioExpr is null");
        requireNonNull(minSupportExpr, "minSupportExpr is null");
        requireNonNull(ratioMetricExpr, "ratioMetricExpr is null");
        requireNonNull(maxCombo, "maxCombo is null");
        requireNonNull(where, "where is null");
        requireNonNull(orderBy, "orderBy is null");
        requireNonNull(limit, "limit is null");
        requireNonNull(exportExpr, "exportExpr is null");
        this.select = select;
        this.first = first;
        this.second = second;
        this.splitQuery = splitQuery;
        this.attributeCols = attributeCols;
        this.minRatioExpr = minRatioExpr.orElse(DEFAULT_MIN_RATIO_EXPRESSION);
        this.minSupportExpr = minSupportExpr.orElse(DEFAULT_MIN_SUPPORT_EXPRESSION);
        this.ratioMetricExpr = ratioMetricExpr.orElse(DEFAULT_RATIO_METRIC_EXPRESSION);
        this.maxCombo = maxCombo.orElse(DEFAULT_MAX_COMBO);
        this.where = where;
        this.orderBy = orderBy;
        this.limit = limit;
        this.exportExpr = exportExpr;
    }

    public Select getSelect() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Optional<TableSubquery> getFirst() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Optional<TableSubquery> getSecond() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean hasTwoArgs() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Optional<SplitQuery> getSplitQuery() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<Identifier> getAttributeCols() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public MinRatioExpression getMinRatioExpression() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public MinSupportExpression getMinSupportExpression() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public RatioMetricExpression getRatioMetricExpr() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public IntLiteral getMaxCombo() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Optional<Expression> getWhere() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Optional<OrderBy> getOrderBy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Optional<String> getLimit() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Optional<ExportClause> getExportExpr() {
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
    public String toString() {
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
