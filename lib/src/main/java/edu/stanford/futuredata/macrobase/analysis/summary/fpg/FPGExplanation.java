package edu.stanford.futuredata.macrobase.analysis.summary.fpg;

import edu.stanford.futuredata.macrobase.analysis.summary.Explanation;
import edu.stanford.futuredata.macrobase.analysis.summary.fpg.result.FPGAttributeSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a summarization result, which contains a list of attribute values
 * and other statistics about the underlying process, e.g. num of tuples observed
 * so far.
 */
public class FPGExplanation implements Explanation {

    private final long numOutliers;

    private final long numInliers;

    private List<FPGAttributeSet> itemsets;

    private final long creationTimeMs;

    public FPGExplanation(List<FPGAttributeSet> resultList, long numInliers, long numOutliers, long creationTimeMs) {
        itemsets = new ArrayList<>(resultList);
        this.numInliers = numInliers;
        this.numOutliers = numOutliers;
        this.creationTimeMs = creationTimeMs;
    }

    /**
     * Removes redundant explanations
     * @return New explanation with redundant itemsets removed.
     */
    public FPGExplanation prune() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void sortByRiskRatio() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void sortBySupport() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<FPGAttributeSet> getItemsets() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double numOutliers() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double numTotal() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long getNumOutliers() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long getNumInliers() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long getCreationTimeMs() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String prettyPrint() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
