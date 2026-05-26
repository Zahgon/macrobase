package edu.stanford.futuredata.macrobase.analysis.summary.util;

import java.util.ArrayList;
import java.util.List;

/**
 * A HashTable from IntSets to arrays of doubles.  Requires that all keys
 * be nonzero.
 */
public class FastFixedHashTable {

    private double[][] hashTable;

    private IntSet[] existsTable;

    private long[] existsLongTable;

    private int numAggregates;

    private int mask;

    private int capacity;

    private boolean useIntArraySets;

    private int size = 0;

    private final int ratio = 10;

    public FastFixedHashTable(int size, int numAggregates, boolean useIntArraySets) {
        int realSize = 1;
        while (realSize < size) {
            realSize *= 2;
        }
        this.capacity = realSize;
        this.mask = realSize - 1;
        this.numAggregates = numAggregates;
        hashTable = new double[realSize][numAggregates];
        if (useIntArraySets)
            existsTable = new IntSet[realSize];
        else
            existsLongTable = new long[realSize];
        this.useIntArraySets = useIntArraySets;
    }

    private void growAndRehash() {
        this.size = 1;
        int oldCapacity = capacity;
        this.capacity = capacity * 2;
        this.mask = capacity - 1;
        double[][] oldHashTable = this.hashTable;
        this.hashTable = new double[capacity][numAggregates];
        if (useIntArraySets) {
            IntSet[] oldExistsTable = this.existsTable;
            this.existsTable = new IntSet[capacity];
            for (int i = 0; i < oldCapacity; i++) {
                if (oldExistsTable[i] != null) {
                    put(oldExistsTable[i], oldHashTable[i]);
                }
            }
        } else {
            long[] oldExistsLongTable = this.existsLongTable;
            this.existsLongTable = new long[capacity];
            for (int i = 0; i < oldCapacity; i++) {
                if (oldExistsLongTable[i] != 0) {
                    put(oldExistsLongTable[i], oldHashTable[i]);
                }
            }
        }
    }

    public void put(IntSet entry, double[] aggregates) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void put(long entry, double[] aggregates) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double[] get(IntSet entry) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<IntSet> keySet() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<Long> keySetLong() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public int getCapacity() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
