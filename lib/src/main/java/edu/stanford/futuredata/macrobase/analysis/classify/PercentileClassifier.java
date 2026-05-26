package edu.stanford.futuredata.macrobase.analysis.classify;

import edu.stanford.futuredata.macrobase.datamodel.DataFrame;
import org.apache.commons.math3.stat.descriptive.rank.Percentile;

/**
 * Classify rows based on high / low values for a single column. Returns a new DataFrame with a
 * column representation the classification status for each row: 1.0 if outlier, 0.0 otherwise.
 */
public class PercentileClassifier extends Classifier implements ThresholdClassifier {

    // Parameters
    private double percentile = 0.5;

    private boolean includeHigh = true;

    private boolean includeLow = true;

    // Calculated values
    private double lowCutoff;

    private double highCutoff;

    private DataFrame output;

    public PercentileClassifier(String columnName) {
        super(columnName);
    }

    @Override
    public void process(DataFrame input) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public DataFrame getResults() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // Parameter Getters and Setters
    public double getPercentile() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param percentile Cutoff point for high or low values
     * @return this
     */
    public PercentileClassifier setPercentile(double percentile) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isIncludeHigh() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param includeHigh Whether to count high points as outliers.
     * @return this
     */
    public PercentileClassifier setIncludeHigh(boolean includeHigh) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isIncludeLow() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param includeLow Whether to count low points as outliers
     * @return this
     */
    public PercentileClassifier setIncludeLow(boolean includeLow) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double getLowCutoff() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double getHighCutoff() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
