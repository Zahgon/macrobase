package edu.stanford.futuredata.macrobase.datamodel;

import static java.util.stream.Collectors.toList;
import com.google.common.base.Joiner;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;

/**
 * Format for import / export small batches
 */
public class Row {

    // Formatter for printing out doubles; print at least 1 and no more than 6 decimal places
    static final DecimalFormat DOUBLE_FORMAT = new DecimalFormat("#.0#####", DecimalFormatSymbols.getInstance(Locale.US));

    // not set by user
    private final Schema schema;

    private final List<Object> vals;

    public Row(final Schema schema, final List<Object> vals) {
        this.schema = schema;
        this.vals = vals;
    }

    public Row(final List<Object> vals) {
        this.schema = null;
        this.vals = vals;
    }

    public List<Object> getVals() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    public <T> T getAs(int i) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    public <T> T getAs(String colName) {
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

    /**
     * pretty print Row object to STDOUT or file (default: STDOUT), using a default width of 15
     * characters per value. Example output: |    val_1   |   val_2   | .... |   val_n   |
     */
    public void prettyPrint() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * pretty print Row object to <tt>out</tt> using a default width of 15 characters per value.
     * Example output: |    val_1   |   val_2   | .... |   val_n   |
     */
    public void prettyPrint(final PrintStream out) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Pretty print Row object to STDOUT
     * Example output:
     * |    val_1   |   val_2   | .... |   val_n  |
     *
     * @param width number of characters to or each value, with <tt>(width - length of value) /
     * 2</tt> of whitespace on either side
     */
    public void prettyPrint(final int width) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Pretty print Row object to the console.
     * Example output:
     * |    val_1   |   val_2   | .... | val_n   |
     *
     * @param out PrintStream to print Row to STDOUT or file (default: STDOUT)
     * @param width the number of characters to use for centering a single value. Increasing
     * <tt>width</tt> will increase the whitespace padding around each value.
     */
    public void prettyPrint(final PrintStream out, final int width) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Pretty print row in vertical, column-wise format. Example output:
     *
     * col_1    |  val_1
     * col_2    |  val_2
     * ...
     * col_n    |  val_n
     * -----------------------
     *
     * @param out PrintStream to print Row to STDOUT or file (default: STDOUT)
     */
    void prettyPrintColumnWise(final PrintStream out) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return If x is a double, return back a formatted String that prints at least 1 and up to 6
     * decimal places of the double. If x is null, return "-". Otherwise, return x unchanged (i.e.
     * toString will be used), but truncate it to @param width, if greater than 0
     */
    private String formatVal(Object x, final int width) {
        if (x == null) {
            return "-";
        } else if (x instanceof Double) {
            if (Double.isNaN((Double) x)) {
                return "NaN";
            }
            return DOUBLE_FORMAT.format(x);
        } else {
            final String str = String.valueOf(x);
            if (width > 0 && str.length() > width) {
                return str.substring(0, width - 3) + "...";
            } else {
                return str;
            }
        }
    }

    /**
     * @return format value for pretty-printing using default width of 15
     */
    private String formatVal(Object x) {
        return formatVal(x, 15);
    }
}
