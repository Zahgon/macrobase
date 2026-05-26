package edu.stanford.futuredata.macrobase.analysis.summary.util;

import java.util.*;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Encode every combination of attribute names and values into a distinct integer.
 * This class assumes that attributes are stored in String columns in dataframes
 * and is used inside of the explanation operators to search for explanatory
 * column values.
 */
public class AttributeEncoder {

    private Logger log = LoggerFactory.getLogger("AttributeEncoder");

    // An encoding for values which do not satisfy the minimum support threshold in encodeAttributesWithSupport.
    public static int noSupport = Integer.MAX_VALUE;

    public static int cardinalityThreshold = 128;

    private HashMap<Integer, Map<String, Integer>> encoder;

    private int nextKey;

    private HashMap<Integer, String> valueDecoder;

    private HashMap<Integer, Integer> columnDecoder;

    private List<String> colNames;

    private HashMap<Integer, ModBitSet>[][] bitmap;

    private int[] colCardinalities;

    private ArrayList<Integer>[] outlierList;

    public AttributeEncoder() {
        encoder = new HashMap<>();
        // Keys must start at 1 because IntSetAsLong does not accept zero values.
        nextKey = 1;
        valueDecoder = new HashMap<>();
        columnDecoder = new HashMap<>();
    }

    public void setColumnNames(List<String> colNames) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public int decodeColumn(int i) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String decodeColumnName(int i) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String decodeValue(int i) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public HashMap<Integer, Integer> getColumnDecoder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public HashMap<Integer, ModBitSet>[][] getBitmap() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ArrayList<Integer>[] getOutlierList() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public int[] getColCardinalities() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Encode as integers all attributes satisfying a minimum support threshold.  Also
     * encode columns of attributes as bitmaps if their cardinalities are sufficiently
     * low.
     * @param columns A list of columns of attributes.
     * @param minSupport The minimal support an attribute must have to be encoded.
     * @param outlierColumn A column indicating whether a row of attributes is an inlier
     *                      our outlier.
     * @param useBitmaps Whether to encode any columns as bitmaps.
     * @return The encoded matrix of attributes, stored as an array of arrays.
     */
    public int[][] encodeAttributesWithSupport(List<String[]> columns, double minSupport, double[] outlierColumn, boolean useBitmaps) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Encode as integers all attribute strings.
     * @param columns A list of attribute strings from each column of the original
     *                dataset.
     * @return A matrix of encoded attributes, stored as an array of arrays.
     */
    public int[][] encodeAttributesAsArray(List<String[]> columns) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Encode as integers all attribute strings.
     * @param columns A list of attribute strings from each column of the original
     *                dataset.
     * @return A matrix of encoded attributes, stored as a list of arrays.
     */
    public List<int[]> encodeAttributes(List<String[]> columns) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<Set<Integer>> encodeAttributesAsSets(List<String[]> columns) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public int getNextKey() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Map<String, String> decodeSet(Set<Integer> set) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
