package edu.stanford.futuredata.macrobase.analysis.transform;

import edu.stanford.futuredata.macrobase.datamodel.DataFrame;
import edu.stanford.futuredata.macrobase.operator.Transformer;
import org.apache.commons.math3.stat.descriptive.rank.Percentile;
import java.util.*;

/**
 * Transform real valued columns into categorical string columns.
 * Transformed columns are added to a copy of the dataframe and appended with
 * a suffix to distinguish them from the original column.
 * Useful for using correlated metrics as explanatory values.
 * By default transforms columns by bucketing them into low-med-high values
 * based on percentile.
 */
public class MetricBucketTransformer implements Transformer {

    // Transformed columns are added to the dataframe under a suffix.
    private String columnSuffix = "_a";

    // Boundaries of the buckets used for classification. n boundaries -> n+1 buckets
    private double[] boundaryPercentiles = { 10.0, 90.0 };

    // The strings used to encode which bucket a value falls in can be either a simple index
    // or an encoding of the range of the bucket.
    private boolean simpleBucketValues = false;

    private List<String> metricColumns;

    private List<String> transformedColumnNames;

    private DataFrame transformedDF;

    /**
     * @param columns set of columns to transform
     */
    public MetricBucketTransformer(List<String> columns) {
        this.metricColumns = columns;
        int d = columns.size();
        transformedColumnNames = new ArrayList<>(d);
        for (String colName : metricColumns) {
            transformedColumnNames.add(colName + columnSuffix);
        }
    }

    public MetricBucketTransformer(String column) {
        this(Collections.singletonList(column));
    }

    @Override
    public void process(DataFrame input) throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public DataFrame getResults() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getColumnSuffix() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setColumnSuffix(String columnSuffix) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double[] getBoundaryPercentiles() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setBoundaryPercentiles(double[] boundaryPercentiles) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isSimpleBucketValues() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setSimpleBucketValues(boolean simpleBucketValues) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<String> getTransformedColumnNames() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
