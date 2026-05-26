package edu.stanford.futuredata.macrobase.analysis.summary.fpg;

import edu.stanford.futuredata.macrobase.analysis.summary.BatchSummarizer;
import edu.stanford.futuredata.macrobase.analysis.summary.fpg.result.FPGAttributeSet;
import edu.stanford.futuredata.macrobase.analysis.summary.util.AttributeEncoder;
import edu.stanford.futuredata.macrobase.analysis.summary.fpg.result.FPGItemsetResult;
import edu.stanford.futuredata.macrobase.datamodel.DataFrame;
import edu.stanford.futuredata.macrobase.datamodel.Schema;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Given a batch of rows with an outlier class column, explain the outliers using
 * string attribute columns. Each batch is considered as an independent unit.
 */
public class FPGrowthSummarizer extends BatchSummarizer {

    protected double minRiskRatio = 3;

    // Encoder
    protected AttributeEncoder encoder = new AttributeEncoder();

    private boolean useAttributeCombinations = true;

    // Output
    private FPGExplanation explanation = null;

    private List<Set<Integer>> inlierItemsets, outlierItemsets;

    private FPGrowthEmerging fpg = new FPGrowthEmerging();

    public FPGrowthSummarizer() {
    }

    /**
     * Whether or not to use combinations of attributes in explanation, or only
     * use simple single attribute explanations
     * @param useAttributeCombinations flag
     * @return this
     */
    public FPGrowthSummarizer setUseAttributeCombinations(boolean useAttributeCombinations) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void process(DataFrame df) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FPGExplanation getResults() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Adjust this to tune the severity (e.g. strength of correlation) of the results returned.
     * @param minRiskRatio lowest risk ratio to consider for meaningful explanations.
     * @return this
     */
    public BatchSummarizer setMinRiskRatio(double minRiskRatio) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
