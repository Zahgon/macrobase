package edu.stanford.futuredata.macrobase.analysis.summary.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Small sets of integers. Fast to construct and compare equality, but does not
 * support checking for membership.
 */
public class IntSetAsArray implements IntSet {

    private int[] values;

    public IntSetAsArray(int a) {
        values = new int[1];
        values[0] = a;
    }

    public IntSetAsArray(IntSetAsLong newLong) {
        int a = newLong.getFirst();
        int b = newLong.getSecond();
        int c = newLong.getThird();
        if (b == 0) {
            values = new int[1];
            values[0] = a;
        } else if (c == 0) {
            values = new int[2];
            values[0] = b;
            values[1] = a;
        } else {
            values = new int[3];
            values[0] = c;
            values[1] = b;
            values[2] = a;
        }
    }

    public IntSetAsArray(int a, int b) {
        values = new int[2];
        if (a <= b) {
            values[0] = a;
            values[1] = b;
        } else {
            values[0] = b;
            values[1] = a;
        }
    }

    public IntSetAsArray(int a, int b, int c) {
        values = new int[3];
        values[0] = a;
        values[1] = b;
        values[2] = c;
    }

    /*
     * Hand-rolled three-integer sort.  Extremely performant and saves a lot of time in the
     * apriori/aplinear implementation versus just calling sort.
     */
    public IntSetAsArray(int a, int b, int c, HashMap<Integer, Integer> sortValues) {
        Integer keyA = sortValues.get(a);
        Integer keyB = sortValues.get(b);
        Integer keyC = sortValues.get(c);
        values = new int[3];
        if (keyA <= keyB) {
            if (keyA <= keyC) {
                values[0] = a;
                if (keyB <= keyC) {
                    values[1] = b;
                    values[2] = c;
                } else {
                    values[1] = c;
                    values[2] = b;
                }
            } else {
                values[0] = c;
                values[1] = a;
                values[2] = b;
            }
        } else {
            if (keyB <= keyC) {
                values[0] = b;
                if (keyA <= keyC) {
                    values[1] = a;
                    values[2] = c;
                } else {
                    values[1] = c;
                    values[2] = a;
                }
            } else {
                values[0] = c;
                values[1] = b;
                values[2] = a;
            }
        }
    }

    public int getFirst() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public int getSecond() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public int getThird() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Set<Integer> getSet() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean contains(int i) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean equals(Object o) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
