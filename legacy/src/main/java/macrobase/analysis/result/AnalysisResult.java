package macrobase.analysis.result;

import macrobase.analysis.summary.itemset.result.ItemsetResult;
import java.util.List;
import java.util.StringJoiner;

public class AnalysisResult {

    private double numOutliers;

    private double numInliers;

    private long executionTime;

    private long loadTime;

    private long summarizationTime;

    private List<ItemsetResult> itemSets;

    public AnalysisResult(double numOutliers, double numInliers, long loadTime, long executionTime, long summarizationTime, List<ItemsetResult> itemSets) {
        this.numOutliers = numOutliers;
        this.numInliers = numInliers;
        this.executionTime = executionTime;
        this.loadTime = loadTime;
        this.summarizationTime = summarizationTime;
        this.itemSets = itemSets;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double getNumOutliers() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double getNumInliers() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long getExecutionTime() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long getSummarizationTime() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long getLoadTime() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setItemSets(List<ItemsetResult> itemsets) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<ItemsetResult> getItemSets() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AnalysisResult() {
        // JACKSON
    }
}
