package edu.stanford.futuredata.macrobase.analysis.classify;

import edu.stanford.futuredata.macrobase.analysis.classify.stats.NormalDist;
import edu.stanford.futuredata.macrobase.analysis.classify.stats.WeightedPercentile;
import edu.stanford.futuredata.macrobase.datamodel.DataFrame;
import java.lang.Double;

/**
 * Classify rows by high / low values based on the group mean and standard deviation.
 * Returns a new dataframe with a column representation of the estimated number of outliers
 * for each group, which can be non-integer.
 */
public class ArithmeticClassifier extends CubeClassifier implements ThresholdClassifier {

    // Parameters
    private String meanColumnName = "mean";

    private String stdColumnName = "std";

    private double percentile = 1.0;

    private boolean includeHigh = true;

    private boolean includeLow = true;

    // Calculated values
    private double lowCutoff;

    private double highCutoff;

    private DataFrame output;

    public ArithmeticClassifier(String countColumnName, String meanColumnName, String stdColumnName) {
        super(countColumnName);
        this.meanColumnName = meanColumnName;
        this.stdColumnName = stdColumnName;
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
    public ArithmeticClassifier setPercentile(double percentile) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getMeanColumnName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param meanColumnName Which column contains the mean of each row's attribute
     *                       combination.
     * @return this
     */
    public ArithmeticClassifier setMeanColumnName(String meanColumnName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getStdColumnName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param stdColumnName Which column contains the standard deviation of metrics for events
     *                      corresponding to each row's attribute combination.
     * @return this
     */
    public ArithmeticClassifier setStdColumnName(String stdColumnName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isIncludeHigh() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param includeHigh Whether to count high points as outliers.
     * @return this
     */
    public ArithmeticClassifier setIncludeHigh(boolean includeHigh) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isIncludeLow() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param includeLow Whether to count low points as outliers
     * @return this
     */
    public ArithmeticClassifier setIncludeLow(boolean includeLow) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double getLowCutoff() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double getHighCutoff() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
