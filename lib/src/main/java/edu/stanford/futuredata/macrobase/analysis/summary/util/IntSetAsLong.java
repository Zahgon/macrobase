package edu.stanford.futuredata.macrobase.analysis.summary.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Sets of two or three integers of at most 31 or 21 bits each, stored as a long.
 * Extremely fast, but the integer size is capped and the integer must be nonzero.
 */
public class IntSetAsLong implements IntSet {

    public long value;

    public IntSetAsLong(long a) {
        this.value = a;
    }

    /**
     * Pack two 31-bit nonzero integers into a long in sorted order.
     * @param a  First integer.
     * @param b  Second integer.
     * @return  A long containing both integers in the lowest 62 bits.
     */
    public IntSetAsLong(long a, long b) {
        if (a < b)
            this.value = ((long) 1 << 62) + (a << 31) + b;
        else
            this.value = ((long) 1 << 62) + (b << 31) + a;
    }

    public static long twoIntToLong(long a, long b) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Pack three 21-bit nonzero integers into a long in sorted order.
     * @param a  First integer.
     * @param b  Second integer.
     * @param c  Third integer.
     * @param sortValues Values by which to sort.
     * @return  A long containing all integers in the lowest 63 bits.
     */
    public IntSetAsLong(long a, long b, long c, HashMap<Integer, Integer> sortValues) {
        Integer keyA = sortValues.get(Math.toIntExact(a));
        Integer keyB = sortValues.get(Math.toIntExact(b));
        Integer keyC = sortValues.get(Math.toIntExact(c));
        long result = 0;
        // Fast three-integer sort
        if (keyA <= keyB) {
            if (keyA <= keyC) {
                result += a << 42;
                if (keyB <= keyC) {
                    result += (b << 21) + c;
                } else {
                    result += (c << 21) + b;
                }
            } else {
                result = (c << 42) + (a << 21) + b;
            }
        } else {
            if (keyB <= keyC) {
                result += b << 42;
                if (keyA <= keyC) {
                    result += (a << 21) + c;
                } else {
                    result += (c << 21) + a;
                }
            } else {
                result = (c << 42) + (b << 21) + a;
            }
        }
        this.value = result;
    }

    /**
     * Pack three 21-bit nonzero integers into a long.
     * @param a  First integer.
     * @param b  Second integer.
     * @param c  Third integer.
     * @return  A long containing all integers in the lowest  63 bits.
     */
    public IntSetAsLong(long a, long b, long c) {
        this.value = (a << (42)) + (b << 21) + c;
    }

    public static long threeIntToLong(long a, long b, long c) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Return the integer stored in the lowest bits of newLong.
     * @return The integer stored in newLong's least-significant bits.
     */
    public int getFirst() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Return the integer stored in the next-lowest bits of newLong.
     * @return The integer stored in newLong's next least-significant bits.
     */
    public int getSecond() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Return the integer stored in the next-lowest bits of newLong.
     * @return The integer stored in newLong's most significant bits, 0 if none.
     */
    public int getThird() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Check if setLong contains queryLong.
     * @param query An integer.
     * @return Does setLong contain querylong?
     */
    public boolean contains(int query) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Return the nonzero integers stored in newLong.
     * @return A set of at most three integers stored in setLong.
     */
    public Set<Integer> getSet() {
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
