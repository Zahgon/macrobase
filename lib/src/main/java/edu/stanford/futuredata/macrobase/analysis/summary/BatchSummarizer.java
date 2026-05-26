package edu.stanford.futuredata.macrobase.analysis.summary;

import edu.stanford.futuredata.macrobase.datamodel.DataFrame;
import edu.stanford.futuredata.macrobase.operator.Operator;
import edu.stanford.futuredata.macrobase.util.MacroBaseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Takes a dataframe with binary classification and searches for explanations (subgroup discovery /
 * contrast set mining / feature selection) that capture differences between the two groups.
 *
 * outlierColumn should either be 0.0 or 1.0 to signify outlying points or a count of the number of
 * outliers represented by a row
 */
public abstract class BatchSummarizer implements Operator<DataFrame, Explanation> {

    // Parameters
    protected String outlierColumn = "_OUTLIER";

    protected double minOutlierSupport = 0.1;

    protected double minRatioMetric = 3;

    protected List<String> attributes = new ArrayList<>();

    protected int numThreads = Runtime.getRuntime().availableProcessors();

    protected String ratioMetric = "global_ratio";

    protected int maxOrder = 3;

    protected boolean useFDs = false;

    protected int[] functionalDependencies;

    /**
     * Adjust this to tune the significance (e.g. number of rows affected) of the results returned.
     *
     * @param minSupport lowest outlier support of the results returned.
     */
    public BatchSummarizer setMinSupport(double minSupport) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public BatchSummarizer setAttributes(List<String> attributes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Set the column which indicates outlier status. "_OUTLIER" by default.
     *
     * @param outlierColumn new outlier indicator column.
     */
    public BatchSummarizer setOutlierColumn(String outlierColumn) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Adjust this to tune the severity (e.g. strength of correlation) of the results returned.
     *
     * @param minRatioMetric lowest risk ratio to consider for meaningful explanations.
     */
    public BatchSummarizer setMinRatioMetric(double minRatioMetric) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * The number of threads used in parallel summarizers.
     *
     * @param numThreads Number of threads to use.
     */
    public BatchSummarizer setNumThreads(int numThreads) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public BatchSummarizer setRatioMetric(final String ratioMetric) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public BatchSummarizer setMaxOrder(final int maxOrder) throws MacroBaseException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public BatchSummarizer setFDUsage(final boolean useFDs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public BatchSummarizer setFDValues(final int[] functionalDependencies) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
