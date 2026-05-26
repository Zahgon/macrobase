package edu.stanford.futuredata.macrobase.analysis.classify;

import edu.stanford.futuredata.macrobase.analysis.classify.stats.LinearInterpolator;
import edu.stanford.futuredata.macrobase.analysis.classify.stats.WeightedPercentile;
import edu.stanford.futuredata.macrobase.datamodel.DataFrame;
import java.util.*;

/**
 * Classify rows by high / low values based on provided quantiles of the group.
 * Returns a new dataframe with a column representation of the estimated number of outliers
 * for each group, which can be non-integer.
 */
public class QuantileClassifier extends CubeClassifier implements ThresholdClassifier {

    // Parameters
    private List<String> quantileColumnNames;

    private double[] quantiles;

    private double percentile = 1.0;

    private boolean includeHigh = true;

    private boolean includeLow = true;

    // Calculated values
    private double lowCutoff;

    private double highCutoff;

    private DataFrame output;

    public QuantileClassifier(String countColumnName, LinkedHashMap<String, Double> quantileColumns) {
        super(countColumnName);
        this.quantileColumnNames = new ArrayList<String>();
        this.quantiles = new double[quantileColumns.size()];
        int i = 0;
        for (Map.Entry<String, Double> entry : quantileColumns.entrySet()) {
            this.quantileColumnNames.add(entry.getKey());
            this.quantiles[i++] = entry.getValue();
        }
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
    public QuantileClassifier setPercentile(double percentile) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<String> getQuantileColumnNames() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param quantileColumnNames Which columns contain the quantiles
     * @return this
     */
    public QuantileClassifier setQuantileColumnNames(List<String> quantileColumnNames) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double[] getQuantiles() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param quantiles The quantiles that are contained in the columns specified in
     *                  quantileColumnNames. The values should be between 0 and 1,
     *                  in increasing order, and ideally contain 0 and 1 (the min
     *                  and the max).
     * @return this
     */
    public QuantileClassifier setQuantiles(double[] quantiles) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isIncludeHigh() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param includeHigh Whether to count high points as outliers.
     * @return this
     */
    public QuantileClassifier setIncludeHigh(boolean includeHigh) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isIncludeLow() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param includeLow Whether to count low points as outliers
     * @return this
     */
    public QuantileClassifier setIncludeLow(boolean includeLow) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double getLowCutoff() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double getHighCutoff() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
