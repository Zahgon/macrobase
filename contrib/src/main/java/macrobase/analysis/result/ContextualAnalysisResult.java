package macrobase.analysis.result;

import java.util.List;
import macrobase.analysis.contextualoutlier.Context;
import macrobase.analysis.summary.itemset.result.ItemsetResult;

public class ContextualAnalysisResult extends AnalysisResult {

    private Context context;

    public ContextualAnalysisResult(Context context, double numOutliers, double numInliers, long loadTime, long executionTime, long summarizationTime, List<ItemsetResult> itemSets) {
        super(numOutliers, numInliers, loadTime, executionTime, summarizationTime, itemSets);
        this.context = context;
    }

    public Context getContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
