package edu.stanford.futuredata.macrobase.analysis.summary.aplinear;

import edu.stanford.futuredata.macrobase.analysis.summary.util.*;
import edu.stanford.futuredata.macrobase.analysis.summary.util.qualitymetrics.AggregationOp;
import edu.stanford.futuredata.macrobase.analysis.summary.util.qualitymetrics.QualityMetric;
import edu.stanford.futuredata.macrobase.util.MacroBaseInternalError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.roaringbitmap.RoaringBitmap;
import org.w3c.dom.Attr;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import static edu.stanford.futuredata.macrobase.analysis.summary.aplinear.BitmapHelperFunctions.*;

/**
 * Class for handling the generic, algorithmic aspects of apriori explanation.
 * This class assumes that subgroups posses "aggregates" such as count and outlier_count
 * which can be combined additively. Then, we use APriori to find the subgroups which
 * are the most interesting as defined by "quality metrics" on these aggregates.
 */
public class APrioriLinear {

    private Logger log = LoggerFactory.getLogger("APrioriLinear");

    // **Parameters**
    private QualityMetric[] qualityMetrics;

    private double[] thresholds;

    // **Cached values**
    // Sets that have high enough support but not high qualityMetrics, need to be explored
    private HashMap<Integer, HashSet<IntSet>> setNext;

    // Aggregate values for all of the sets we saved
    private HashMap<Integer, Map<IntSet, double[]>> savedAggregates;

    /**
     * @param qualityMetrics A list of all quality metrics for this DIFF
     *                       operation.
     * @param thresholds A list of the thresholds for each quality metric.
     */
    public APrioriLinear(List<QualityMetric> qualityMetrics, List<Double> thresholds) {
        this.qualityMetrics = qualityMetrics.toArray(new QualityMetric[0]);
        this.thresholds = new double[thresholds.size()];
        for (int i = 0; i < thresholds.size(); i++) {
            this.thresholds[i] = thresholds.get(i);
        }
        this.setNext = new HashMap<>(3);
        this.savedAggregates = new HashMap<>(3);
    }

    /**
     * Use Aprori to compute explanations for a DIFF.
     * @param attributes Encoded columns to DIFF over.
     * @param aggregateColumns Calculated aggregates for the quality metrics.
     * @param aggregationOps Operations used to aggregate the aggregates.
     * @param cardinality The total number of encoded attributes.
     * @param maxOrder Maximum order of explanations to calculate.
     * @param numThreads Number of threads to use.
     * @param bitmap Bitmap representation of attributes.  Stored as array indexed
     *               by column and then by outlier/inlier.  Each entry in array
     *               is a map from encoded attribute value to the bitmap
     *               for that attribute among outliers or inliers.
     * @param outlierList A list whose entries are arrays of all attributes in
     *                    each column.
     * @param colCardinalities  An array containing the number of unique encoded
     *                          attributes in each column.
     * @param useFDs A boolean flag indicating whether or not to use functional
     *               dependency information.
     * @param functionalDependencies An array whose entries are masks indicating
     *                               which other columns a column is functionally
     *                               determined by, if any.
     * @param bitmapRatioThreshold The maximum product of column cardinalities for which
     *                             a bitmap representation of the columns will be used.
     * @return All explanations for the DIFF query.
     */
    public List<APLExplanationResult> explain(final int[][] attributes, double[][] aggregateColumns, double[][] globalAggregateCols, AggregationOp[] aggregationOps, int cardinality, final int maxOrder, int numThreads, HashMap<Integer, ModBitSet>[][] bitmap, ArrayList<Integer>[] outlierList, int[] colCardinalities, boolean useFDs, int[] functionalDependencies, int bitmapRatioThreshold) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Check if all order-2 subsets of an order-3 candidate are valid candidates.
     * @param o2Candidates All candidates of order 2 with minimum support.
     * @param curCandidate An order-3 candidate
     * @return Boolean
     */
    private boolean allPairsValid(IntSet curCandidate, HashSet<IntSet> o2Candidates) {
        IntSet subPair;
        subPair = new IntSetAsArray(curCandidate.getFirst(), curCandidate.getSecond());
        if (o2Candidates.contains(subPair)) {
            subPair = new IntSetAsArray(curCandidate.getSecond(), curCandidate.getThird());
            if (o2Candidates.contains(subPair)) {
                subPair = new IntSetAsArray(curCandidate.getFirst(), curCandidate.getThird());
                return o2Candidates.contains(subPair);
            }
        }
        return false;
    }
}
