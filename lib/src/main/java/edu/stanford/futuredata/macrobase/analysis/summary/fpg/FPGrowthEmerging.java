package edu.stanford.futuredata.macrobase.analysis.summary.fpg;

import com.google.common.collect.Sets;
import edu.stanford.futuredata.macrobase.analysis.summary.fpg.result.FPGItemsetResult;
import edu.stanford.futuredata.macrobase.analysis.summary.fpg.result.ItemsetWithCount;
import java.util.*;

public class FPGrowthEmerging {

    private boolean combinationsEnabled = true;

    public FPGrowthEmerging() {
    }

    public FPGrowthEmerging setCombinationsEnabled(boolean flag) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private List<FPGItemsetResult> getSingletonItemsets(List<Set<Integer>> inliers, List<Set<Integer>> outliers, double minSupport, double minRatio) {
        int supportCountRequired = (int) (outliers.size() * minSupport);
        List<FPGItemsetResult> ret = new ArrayList<>();
        Map<Integer, Double> inlierCounts = new ExactCount().count(inliers).getCounts();
        Map<Integer, Double> outlierCounts = new ExactCount().count(outliers).getCounts();
        for (Map.Entry<Integer, Double> attrOutlierCountEntry : outlierCounts.entrySet()) {
            if (attrOutlierCountEntry.getValue() < supportCountRequired) {
                continue;
            }
            int item = attrOutlierCountEntry.getKey();
            Double attrInlierCount = inlierCounts.get(item);
            double ratio = RiskRatio.compute(attrInlierCount, attrOutlierCountEntry.getValue(), inliers.size(), outliers.size());
            if (ratio > minRatio) {
                ret.add(new FPGItemsetResult(attrOutlierCountEntry.getValue() / outliers.size(), attrOutlierCountEntry.getValue(), ratio, Collections.singleton(item)));
            }
        }
        return ret;
    }

    public List<FPGItemsetResult> getEmergingItemsetsWithMinSupport(List<Set<Integer>> inliers, List<Set<Integer>> outliers, double minSupport, double minRatio) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
