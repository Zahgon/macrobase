package edu.stanford.futuredata.macrobase.analysis.summary.fpg;

public class RiskRatio {

    private static double computeDouble(double exposedInlierCount, double exposedOutlierCount, double totalInliers, double totalOutliers) {
        double totalExposedCount = exposedInlierCount + exposedOutlierCount;
        double unexposedOutlierCount = (totalOutliers - exposedOutlierCount);
        double totalMinusExposedCount = totalInliers + totalOutliers - totalExposedCount;
        // no exposure occurred
        if (totalExposedCount == 0) {
            return 0;
        }
        // we only exposed this ratio, everything matched!
        if (totalMinusExposedCount == 0) {
            return 0;
        }
        // all outliers had this pattern
        if (unexposedOutlierCount == 0) {
            return Double.POSITIVE_INFINITY;
        }
        return (exposedOutlierCount / totalExposedCount) / (unexposedOutlierCount / totalMinusExposedCount);
    }

    public static double compute(Number exposedInlierCount, Number exposedOutlierCount, Number totalInliers, Number totalOutliers) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
