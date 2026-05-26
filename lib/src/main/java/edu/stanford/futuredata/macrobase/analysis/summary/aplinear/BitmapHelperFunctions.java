package edu.stanford.futuredata.macrobase.analysis.summary.aplinear;

import edu.stanford.futuredata.macrobase.analysis.summary.util.*;
import edu.stanford.futuredata.macrobase.analysis.summary.util.qualitymetrics.AggregationOp;
import java.util.*;
import edu.stanford.futuredata.macrobase.analysis.summary.util.ModBitSet;

public class BitmapHelperFunctions {

    /**
     * Update aggregates during Apriori.
     * @param thisThreadSetAggregates A map from itemsets of attributes to arrays of aggregates.
     * @param curCandidate An itemset of attributes.
     * @param aggregationOps Aggregation functions used to perform updates.
     * @param aggregateVal The array of aggregates to be aggregated onto the entry for curCandidate
     * @param numAggregates The length of aggregateVal.
     */
    public static void updateAggregates(FastFixedHashTable thisThreadSetAggregates, IntSet curCandidate, AggregationOp[] aggregationOps, double[] aggregateVal, int numAggregates) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * ******************** All Order-2 helper methods **********************
     */
    /**
     * Iterate through two columns and update the map from attributes to aggregates
     * with all pairs of attributes found during iteration.  Process columns
     * without using bitmap representations.
     * @param thisThreadSetAggregates A map from itemsets of attributes to arrays of aggregates.
     * @param curColumnOneAttributes The first column of attributes.
     * @param curColumnTwoAttributes The second column of attributes.
     * @param aggregationOps Aggregation functions used to perform updates.
     * @param singleNextArray A list of supported singleton attributes.
     * @param startIndex Where to begin iteration in the columns.
     * @param endIndex Where to end iteration in the columns.  Only values between
     *                 startIndex and endIndex are considered.
     * @param useIntSetAsArray Whether candidates are to be stored in packed longs
     *                         or arrays of integers.
     * @param curCandidate A dummy IntSet used as a single-entry pool to speed up computation
     *                     by avoiding IntSet allocation.
     * @param aRows An array of aggregate values.
     * @param numAggregates The length of a row in aRows.
     */
    public static void allTwoNormal(FastFixedHashTable thisThreadSetAggregates, int[] curColumnOneAttributes, int[] curColumnTwoAttributes, AggregationOp[] aggregationOps, boolean[] singleNextArray, int startIndex, int endIndex, boolean useIntSetAsArray, IntSet curCandidate, double[][] aRows, int numAggregates) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Process two columns and update the map from attributes to aggregates
     * with all pairs of attributes found during iteration.  Process columns
     * using bitmap representations.
     * @param thisThreadSetAggregates A map from itemsets of attributes to arrays of aggregates.
     * @param outlierList A list whose entries are arrays of all attributes in
     *                    each column.
     * @param aggregationOps Aggregation functions used to perform updates.
     * @param singleNextArray A list of supported singleton attributes.
     * @param byThreadBitmap Bitmap representation of attributes.  Stored as array indexed
     *                       by column and then by outlier/inlier.  Each entry in array
     *                       is a map from encoded attribute value to the bitmap
     *                       for that attribute among outliers or inliers.
     * @param colNumOne The first column to process.
     * @param colNumTwo The second column to process.
     * @param useIntSetAsArray Whether candidates are to be stored in packed longs
     *                         or arrays of integers.
     * @param curCandidate A dummy IntSet used as a single-entry pool to speed up computation
     *                     by avoiding IntSet allocation.
     * @param numAggregates The length of a row in aRows.
     */
    public static void allTwoBitmap(FastFixedHashTable thisThreadSetAggregates, ArrayList<Integer>[] outlierList, AggregationOp[] aggregationOps, boolean[] singleNextArray, HashMap<Integer, ModBitSet>[][] byThreadBitmap, int colNumOne, int colNumTwo, boolean useIntSetAsArray, IntSet curCandidate, int numAggregates) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * ******************** All Order-3 helper methods **********************
     */
    /**
     * Iterate through three columns and update the map from attributes to aggregates
     * with all pairs of attributes found during iteration.  Process columns
     * without using bitmap representations.
     * @param thisThreadSetAggregates A map from itemsets of attributes to arrays of aggregates.
     * @param curColumnOneAttributes The first column of attributes.
     * @param curColumnTwoAttributes The second column of attributes.
     * @param curColumnThreeAttributes The third column of attributes.
     * @param aggregationOps Aggregation functions used to perform updates.
     * @param singleNextArray A list of supported singleton attributes.
     * @param startIndex Where to begin iteration in the columns.
     * @param endIndex Where to end iteration in the columns.  Only values between
     *                 startIndex and endIndex are considered.
     * @param useIntSetAsArray Whether candidates are to be stored in packed longs
     *                         or arrays of integers.
     * @param curCandidate A dummy IntSet used as a single-entry pool to speed up computation
     *                     by avoiding IntSet allocation.
     * @param aRows An array of aggregate values.
     * @param numAggregates The length of a row in aRows.
     */
    // All Three Normal or All Three Bitmap
    public static void allThreeNormal(FastFixedHashTable thisThreadSetAggregates, int[] curColumnOneAttributes, int[] curColumnTwoAttributes, int[] curColumnThreeAttributes, AggregationOp[] aggregationOps, boolean[] singleNextArray, int startIndex, int endIndex, boolean useIntSetAsArray, IntSet curCandidate, double[][] aRows, int numAggregates) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Process three columns and update the map from attributes to aggregates
     * with all pairs of attributes found during iteration.  Process columns
     * using bitmap representations.
     * @param thisThreadSetAggregates A map from itemsets of attributes to arrays of aggregates.
     * @param outlierList A list whose entries are arrays of all attributes in
     *                    each column.
     * @param aggregationOps Aggregation functions used to perform updates.
     * @param singleNextArray A list of supported singleton attributes.
     * @param byThreadBitmap Bitmap representation of attributes.  Stored as array indexed
     *                       by column and then by outlier/inlier.  Each entry in array
     *                       is a map from encoded attribute value to the bitmap
     *                       for that attribute among outliers or inliers.
     * @param colNumOne The first column to process.
     * @param colNumTwo The second column to process.
     * @param colNumThree The third column to process.
     * @param useIntSetAsArray Whether candidates are to be stored in packed longs
     *                         or arrays of integers.
     * @param curCandidate A dummy IntSet used as a single-entry pool to speed up computation
     *                     by avoiding IntSet allocation.
     * @param numAggregates The length of a row in aRows.
     */
    public static void allThreeBitmap(FastFixedHashTable thisThreadSetAggregates, ArrayList<Integer>[] outlierList, AggregationOp[] aggregationOps, boolean[] singleNextArray, HashMap<Integer, ModBitSet>[][] byThreadBitmap, int colNumOne, int colNumTwo, int colNumThree, boolean useIntSetAsArray, IntSet curCandidate, int numAggregates) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
