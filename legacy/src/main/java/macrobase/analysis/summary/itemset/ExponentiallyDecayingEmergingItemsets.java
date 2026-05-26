package macrobase.analysis.summary.itemset;

import static com.codahale.metrics.MetricRegistry.name;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import macrobase.MacroBase;
import macrobase.analysis.summary.count.ApproximateCount;
import macrobase.analysis.summary.count.AmortizedMaintenanceCounter;
import macrobase.analysis.summary.itemset.result.ItemsetResult;
import macrobase.analysis.summary.itemset.result.ItemsetWithCount;
import macrobase.datamodel.Datum;
import macrobase.ingest.DatumEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.codahale.metrics.Timer;
import com.google.common.collect.Sets;

public class ExponentiallyDecayingEmergingItemsets {

    private static final Logger log = LoggerFactory.getLogger(ExponentiallyDecayingEmergingItemsets.class);

    private static final Timer inlierDecayTime = MacroBase.metrics.timer(name(ExponentiallyDecayingEmergingItemsets.class, "inlierDecayTime"));

    private static final Timer outlierDecayTime = MacroBase.metrics.timer(name(ExponentiallyDecayingEmergingItemsets.class, "outlierDecayTime"));

    private double numInliers;

    private double numOutliers;

    private final double minSupportOutlier;

    private final double minRatio;

    private final double exponentialDecayRate;

    private final ApproximateCount outlierCountSummary;

    private final ApproximateCount inlierCountSummary;

    private final StreamingFPGrowth outlierPatternSummary;

    private final StreamingFPGrowth inlierPatternSummary = new StreamingFPGrowth(0);

    private final int attributeDimension;

    private final boolean combinationsEnabled;

    public ExponentiallyDecayingEmergingItemsets(int inlierSummarySize, int outlierSummarySize, double minSupportOutlier, double minRatio, double exponentialDecayRate, int attributeDimension, boolean combinationsEnabled) {
        this.minSupportOutlier = minSupportOutlier;
        this.minRatio = minRatio;
        this.exponentialDecayRate = exponentialDecayRate;
        this.attributeDimension = attributeDimension;
        this.combinationsEnabled = combinationsEnabled;
        outlierCountSummary = new AmortizedMaintenanceCounter(outlierSummarySize);
        inlierCountSummary = new AmortizedMaintenanceCounter(inlierSummarySize);
        outlierPatternSummary = new StreamingFPGrowth(minSupportOutlier);
    }

    Map<Integer, Double> interestingItems;

    public Double getInlierCount() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Double getOutlierCount() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void updateModelsNoDecay() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void updateModelsAndDecay() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void updateModels(boolean doDecay) {
        if (!combinationsEnabled || attributeDimension == 1) {
            return;
        }
        Map<Integer, Double> outlierCounts = this.outlierCountSummary.getCounts();
        Map<Integer, Double> inlierCounts = this.inlierCountSummary.getCounts();
        int supportCountRequired = (int) (this.outlierCountSummary.getTotalCount() * minSupportOutlier);
        interestingItems = new HashMap<>();
        for (Map.Entry<Integer, Double> outlierCount : outlierCounts.entrySet()) {
            if (outlierCount.getValue() < supportCountRequired) {
                continue;
            }
            Double inlierCount = inlierCounts.get(outlierCount.getKey());
            if (inlierCount != null && RiskRatio.compute(inlierCount, outlierCount.getValue(), inlierCountSummary.getTotalCount(), outlierCountSummary.getTotalCount()).get() < minRatio) {
                continue;
            }
            interestingItems.put(outlierCount.getKey(), outlierCount.getValue());
        }
        log.trace("found {} interesting items", interestingItems.size());
        Timer.Context ot = outlierDecayTime.time();
        outlierPatternSummary.decayAndResetFrequentItems(interestingItems, doDecay ? exponentialDecayRate : 0);
        ot.stop();
        Timer.Context it = inlierDecayTime.time();
        inlierPatternSummary.decayAndResetFrequentItems(interestingItems, doDecay ? exponentialDecayRate : 0);
        it.stop();
    }

    public void markPeriod() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void markOutlier(Datum outlier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // TODO: don't track *all* inliers
    public void markInlier(Datum inlier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private List<ItemsetResult> getSingleItemItemsets(DatumEncoder encoder) {
        double supportCountRequired = outlierCountSummary.getTotalCount() * minSupportOutlier;
        log.debug("REQUIRED SUPPORT: {} {}", supportCountRequired, minSupportOutlier);
        List<ItemsetResult> ret = new ArrayList<>();
        Map<Integer, Double> inlierCounts = inlierCountSummary.getCounts();
        Map<Integer, Double> outlierCounts = outlierCountSummary.getCounts();
        for (Map.Entry<Integer, Double> outlierCount : outlierCounts.entrySet()) {
            if (outlierCount.getValue() < supportCountRequired) {
                continue;
            }
            double ratio = RiskRatio.compute(inlierCounts.get(outlierCount.getKey()), outlierCount.getValue(), inlierCountSummary.getTotalCount(), outlierCountSummary.getTotalCount()).getCorrectedRiskRatio();
            if (ratio > minRatio) {
                ret.add(new ItemsetResult(outlierCount.getValue() / outlierCountSummary.getTotalCount(), outlierCount.getValue(), ratio, encoder.getColsFromAttr(outlierCount.getKey())));
            }
        }
        return ret;
    }

    public List<ItemsetResult> getItemsets(DatumEncoder encoder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
