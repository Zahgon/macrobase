package macrobase.analysis.summary;

import macrobase.analysis.summary.itemset.result.ItemsetResult;
import java.util.List;

/**
 * Represents a summarization result, which contains a List of ItemsetResults
 * and other statistics about the underlying process, e.g. num of tuples observed
 * so far.
 */
public class Summary {

    private final double numOutliers;

    private final double numInliers;

    private List<ItemsetResult> itemsets;

    private final long creationTimeMs;

    public Summary(List<ItemsetResult> resultList, double numInliers, double numOutliers, long creationTimeMs) {
        itemsets = resultList;
        this.numInliers = numInliers;
        this.numOutliers = numOutliers;
        this.creationTimeMs = creationTimeMs;
    }

    public List<ItemsetResult> getItemsets() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double getNumOutliers() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double getNumInliers() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long getCreationTimeMs() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
