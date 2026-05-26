package macrobase.analysis.summary.itemset;

import com.codahale.metrics.Timer;
import com.codahale.metrics.Timer.Context;
import com.google.common.collect.Sets;
import macrobase.MacroBase;
import macrobase.analysis.summary.count.ExactCount;
import macrobase.analysis.summary.itemset.result.ItemsetResult;
import macrobase.analysis.summary.itemset.result.ItemsetWithCount;
import macrobase.datamodel.Datum;
import macrobase.ingest.DatumEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;
import static com.codahale.metrics.MetricRegistry.name;

public class FPGrowthEmerging {

    private final Timer singleItemCounts = MacroBase.metrics.timer(name(FPGrowthEmerging.class, "singleItemCounts"));

    private final Timer outlierFPGrowth = MacroBase.metrics.timer(name(FPGrowthEmerging.class, "outlierFPGrowth"));

    private final Timer inlierRatio = MacroBase.metrics.timer(name(FPGrowthEmerging.class, "inlierRatio"));

    private final boolean combinationsEnabled;

    @SuppressWarnings("unused")
    private static final Logger log = LoggerFactory.getLogger(FPGrowthEmerging.class);

    public FPGrowthEmerging(boolean combinationsEnabled) {
        this.combinationsEnabled = combinationsEnabled;
    }

    private List<ItemsetResult> getSingletonItemsets(List<Datum> inliers, List<Datum> outliers, double minSupport, double minRatio, DatumEncoder encoder) {
        int supportCountRequired = (int) (outliers.size() * minSupport);
        List<ItemsetResult> ret = new ArrayList<>();
        Map<Integer, Double> inlierCounts = new ExactCount().count(inliers).getCounts();
        Map<Integer, Double> outlierCounts = new ExactCount().count(outliers).getCounts();
        for (Map.Entry<Integer, Double> attrOutlierCountEntry : outlierCounts.entrySet()) {
            if (attrOutlierCountEntry.getValue() < supportCountRequired) {
                continue;
            }
            Double attrInlierCount = inlierCounts.get(attrOutlierCountEntry.getKey());
            double ratio = RiskRatio.compute(attrInlierCount, attrOutlierCountEntry.getValue(), inliers.size(), outliers.size()).getCorrectedRiskRatio();
            if (ratio > minRatio) {
                ret.add(new ItemsetResult(attrOutlierCountEntry.getValue() / outliers.size(), attrOutlierCountEntry.getValue(), ratio, encoder.getColsFromAttr(attrOutlierCountEntry.getKey())));
            }
        }
        return ret;
    }

    public List<ItemsetResult> getEmergingItemsetsWithMinSupport(List<Datum> inliers, List<Datum> outliers, double minSupport, double minRatio, // would prefer not to pass this in, but easier for now...
    DatumEncoder encoder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
