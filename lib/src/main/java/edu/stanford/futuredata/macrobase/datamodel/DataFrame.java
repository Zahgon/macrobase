package edu.stanford.futuredata.macrobase.datamodel;

import static java.util.Comparator.comparing;
import static java.util.Comparator.naturalOrder;
import static java.util.Comparator.nullsLast;
import static java.util.stream.Collectors.toList;
import com.google.common.base.Joiner;
import edu.stanford.futuredata.macrobase.analysis.summary.util.ModBitSet;
import edu.stanford.futuredata.macrobase.datamodel.Schema.ColType;
import edu.stanford.futuredata.macrobase.util.MacroBaseInternalError;
import java.io.PrintStream;
import java.util.*;
import java.util.function.DoublePredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import org.apache.commons.lang3.StringUtils;

/**
 * Column-based DataFrame object.
 * DataFrames are primarily meant for data transfer across operators while
 * preserving column names and types. Complex processing should be done by
 * extracting columns as arrays and operating on arrays directly.
 *
 * The addColumn methods are the primary means of mutating a DataFrame and are
 * especially useful during DataFrame construction. DataFrames can also be
 * initialized from a schema and a set of rows.
 */
public class DataFrame {

    private static final int MAX_COLS_FOR_TABULAR_PRINT = 10;

    private Schema schema;

    private ArrayList<String[]> stringCols;

    private ArrayList<double[]> doubleCols;

    // external indices define a global ordering on columns, but internally each
    // column is stored with other columns of its type. Thus external indices must be
    // converted into internal type-specific indices.
    private ArrayList<Integer> indexToTypeIndex;

    private int numRows;

    public DataFrame() {
        this.schema = new Schema();
        this.stringCols = new ArrayList<>();
        this.doubleCols = new ArrayList<>();
        this.indexToTypeIndex = new ArrayList<>();
        this.numRows = 0;
    }

    /**
     * Creates a DataFrame from a list of rows
     * Slower than creating a DataFrame column by column using {@link #addColumn(String, double[])}
     * or {@link #addColumn(String, String[])}
     * @param schema Schema to use
     * @param rows Data to load
     */
    public DataFrame(Schema schema, List<Row> rows) {
        this();
        this.schema = schema;
        this.numRows = rows.size();
        final int numColumns = schema.getNumColumns();
        for (int c = 0; c < numColumns; c++) {
            Schema.ColType t = schema.getColumnType(c);
            if (t == Schema.ColType.STRING) {
                String[] colValues = new String[numRows];
                for (int i = 0; i < numRows; i++) {
                    colValues[i] = rows.get(i).<String>getAs(c);
                }
                addStringColumnInternal(colValues);
            } else if (t == Schema.ColType.DOUBLE) {
                double[] colValues = new double[numRows];
                for (int i = 0; i < numRows; i++) {
                    colValues[i] = rows.get(i).<Double>getAs(c);
                }
                addDoubleColumnInternal(colValues);
            } else {
                throw new MacroBaseInternalError("Invalid ColType");
            }
        }
    }

    public DataFrame(Schema schema, ArrayList<String>[] stringColumns, ArrayList<Double>[] doubleColumns) {
        this();
        this.schema = schema;
        if (stringColumns.length > 0)
            numRows = stringColumns[0].size();
        else
            numRows = doubleColumns[0].size();
        int numColumns = schema.getNumColumns();
        for (int c = 0, stringColNum = 0, doubleColNum = 0; c < numColumns; c++) {
            Schema.ColType t = schema.getColumnType(c);
            if (t == Schema.ColType.STRING) {
                String[] colValues = stringColumns[stringColNum].toArray(new String[numRows]);
                addStringColumnInternal(colValues);
                stringColNum++;
            } else if (t == Schema.ColType.DOUBLE) {
                double[] colValues = new double[numRows];
                for (int i = 0; i < numRows; i++) {
                    colValues[i] = doubleColumns[doubleColNum].get(i).doubleValue();
                }
                addDoubleColumnInternal(colValues);
                doubleColNum++;
            } else {
                throw new MacroBaseInternalError("Invalid ColType");
            }
        }
    }

    /**
     * Shallow copy of the DataFrame: the schema is recreated but the arrays backing the
     * columns are reused.
     * @return shallow DataFrame copy
     */
    public DataFrame copy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean equals(Object obj) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return true if each String array in the first List contains the exact same values in the
     * same order as the second List
     */
    private boolean compareStringCols(final List<String[]> first, final List<String[]> second) {
        for (int i = 0; i < first.size(); ++i) {
            final String[] arr1 = first.get(i);
            final String[] arr2 = second.get(i);
            for (int j = 0; j < arr1.length; ++j) {
                if (!Objects.equals(arr1[j], arr2[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * @return true if each double array in the first List contains the exact same values in the
     * same order as the second List
     */
    private boolean compareDoubleCols(final List<double[]> first, final List<double[]> second) {
        for (int i = 0; i < first.size(); ++i) {
            final double[] arr1 = first.get(i);
            final double[] arr2 = second.get(i);
            for (int j = 0; j < arr1.length; ++j) {
                if (arr1[j] != arr2[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public Schema getSchema() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public int getNumRows() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ArrayList<double[]> getDoubleCols() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ArrayList<String[]> getStringCols() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Pretty print contents of the DataFrame to STDOUT. Example outputs:
     * m rows
     *
     * ------------------------------------------
     * |   col_1  |   col_2  |  ...  |   col_n  |
     * ------------------------------------------
     * |  val_11  |  val_12  |  ...  |  val_1n  |
     * ...
     * |  val_m1  |  val_m2  |  ...  |  val_mn  |
     * ------------------------------------------
     *
     * or
     *
     * m rows
     *
     * col_1    |  val_11
     * col_2    |  val_12
     * ...
     * col_n    |  val_1n
     * -----------------------
     * ...
     * -----------------------
     * col_1    |  val_m1
     * col_2    |  val_m2
     * ...
     * col_n    |  val_mn
     * -----------------------
     *
     * @param out PrintStream to write to STDOUT or file (default: STDOUT)
     * @param maxNumToPrint maximum number of rows from the DataFrame to print (default: 20;
     * -1 prints out all rows)
     */
    public void prettyPrint(final PrintStream out, final int maxNumToPrint) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@link #prettyPrint(PrintStream, int)} with default <tt>out</tt> set to <tt>System.out</tt>
     * and <tt>maxNumToPrint</tt> set to 20
     */
    public void prettyPrint() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@link #prettyPrint(PrintStream, int)} with default <tt>maxNumToPrint</tt> set to 20
     */
    public void prettyPrint(final PrintStream out) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@link #prettyPrint(PrintStream, int)} with default <tt>out</tt> set to <tt>System.out</tt>
     */
    public void prettyPrint(final int maxNumToPrint) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // Fast Column-based methods
    public DataFrame addColumn(String colName, String[] colValues) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public DataFrame addColumn(String colName, double[] colValues) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void addStringColumnInternal(String[] colValues) {
        stringCols.add(colValues);
        indexToTypeIndex.add(stringCols.size() - 1);
    }

    private void addDoubleColumnInternal(double[] colValues) {
        doubleCols.add(colValues);
        indexToTypeIndex.add(doubleCols.size() - 1);
    }

    protected int[] getSubIndices(List<Integer> columns) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Rename column in schema.
     *
     * @param oldColumnName The name of the column to be renamed. If it doesn't exist, nothing is
     * changed
     * @param newColumnName The new name for the column
     * @return true if rename was successful, false otherwise
     */
    public boolean renameColumn(final String oldColumnName, final String newColumnName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean hasColumn(String columnName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double[] getDoubleColumn(int columnIdx) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double[] getDoubleColumnByName(String columnName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ArrayList<double[]> getDoubleCols(List<Integer> columns) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ArrayList<double[]> getDoubleColsByName(List<String> columns) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String[] getStringColumn(int columnIdx) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String[] getStringColumnByName(String columnName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ArrayList<String[]> getStringCols(List<Integer> columns) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ArrayList<String[]> getStringColsByName(List<String> columns) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param others Dataframes to combine
     * @return new DataFrame with copied rows
     */
    public static DataFrame unionAll(List<DataFrame> others) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param projectionCols The columns that should be included in the returned DataFrame. Projections
     * that aren't in the columns of the current DataFrame will be ignored
     * @return return a new DataFrame that includes only the columns specified by @projectionCols.
     */
    // TODO: write test for this method
    public DataFrame project(List<String> projectionCols) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param projectionCol A single column that should be included in the returned DataFrame.
     * @return return a new DataFrame that only includes the column specified by @projectionCol.
     * If the column doesn't exist in the current DataFrame, return an empty DataFrame
     */
    // TODO: write test for this method
    public DataFrame project(String projectionCol) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param mask rows to select
     * @return new DataFrame with subset of rows
     */
    public DataFrame filter(ModBitSet mask) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public DataFrame filter(int columnIdx, Predicate<Object> filter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public DataFrame filter(String columnName, Predicate<Object> filter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param columnIdx column index to filter by
     * @param filter predicate to test each column value
     * @return new DataFrame with subset of rows
     */
    public DataFrame filter(int columnIdx, DoublePredicate filter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param columnIdx column index to filter by
     * @param filter Predicate<Object> to test each column value
     * @return a ModBitSet that encodes the true/false value generated by the filter
     * on each row in the DataFrame
     */
    public ModBitSet getMaskForFilter(int columnIdx, Predicate<String> filter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param columnIdx column index to filter by
     * @param filter DoublePredicate to test each column value
     * @return a ModBitSet that encodes the true/false value generated by the filter
     * on each row in the DataFrame
     */
    public ModBitSet getMaskForFilter(int columnIdx, DoublePredicate filter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param columnName column name to filter by
     * @param filter predicate to test each column value
     * @return new DataFrame with subset of rows
     */
    public DataFrame filter(String columnName, DoublePredicate filter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@link #limit(int)} with default <tt>numRows</tt> set to -1 (i.e., LIMIT ALL)
     * @return this DataFrame, unchanged
     */
    public DataFrame limit() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Execute the LIMIT clause of a SQL query, i.e., take the first n rows of the DataFrame
     * @param numRows Number of rows to include the new DataFrame. If -1, return the original
     * DataFrame
     * @return the new DataFrame with only the first <tt>numRows</tt> rows.
     */
    public DataFrame limit(final int numRows) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Row getRow(int rowIdx) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<Row> getRows() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private List<Row> getRows(final int startIndex, int numRowsToGet) {
        if (numRowsToGet > numRows) {
            numRowsToGet = numRows;
        }
        List<Row> rows = new ArrayList<>();
        for (int rowIdx = startIndex; rowIdx < numRowsToGet; rowIdx++) {
            rows.add(getRow(rowIdx));
        }
        return rows;
    }

    public ArrayList<double[]> getDoubleRows(List<Integer> columns) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ArrayList<String[]> getStringRows(List<Integer> columns) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ArrayList<double[]> getDoubleRowsByName(List<String> columns) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ArrayList<String[]> getStringRowsByName(List<String> columns) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sort DataFrame rows by a single column.
     * // TODO: write test for OrderBy
     * @param sortCol The column to sort by
     * @param sortAsc True => sort ascending, False => sort descending
     * @return A new DataFrame with the correct sorted order. If <tt>col</tt> is
     * not in the DataFrame's schema, return the same DataFrame, unchanged
     */
    public DataFrame orderBy(final String sortCol, final boolean sortAsc) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // TODO: this code duplication is awful, gotta think of a better way of doing this
    private void sortColumns(final DataFrame sortedDf, final int numColumns, final double[] sortColumn, final boolean sortAsc) {
        Comparator<Integer> comparator = comparing(i -> sortColumn[i], nullsLast(naturalOrder()));
        if (!sortAsc) {
            comparator = comparator.reversed();
        }
        for (int c = 0; c < numColumns; ++c) {
            if (this.schema.getColumnType(c) == ColType.DOUBLE) {
                final double[] origCol = this.getDoubleColumn(c);
                final double[] newCol = IntStream.range(0, origCol.length).boxed().sorted(comparator).mapToDouble(i -> origCol[i]).toArray();
                sortedDf.addColumn(this.schema.getColumnName(c), newCol);
            } else {
                // ColType.STRING
                final String[] origCol = this.getStringColumn(c);
                final String[] newCol = IntStream.range(0, origCol.length).boxed().sorted(comparator).map(i -> origCol[i]).toArray(String[]::new);
                sortedDf.addColumn(this.schema.getColumnName(c), newCol);
            }
        }
    }

    private void sortColumns(final DataFrame sortedDf, final int numColumns, final String[] sortColumn, final boolean sortAsc) {
        Comparator<Integer> comparator = comparing(i -> sortColumn[i], nullsLast(naturalOrder()));
        if (!sortAsc) {
            comparator = comparator.reversed();
        }
        for (int c = 0; c < numColumns; ++c) {
            if (this.schema.getColumnType(c) == ColType.DOUBLE) {
                final double[] origCol = this.getDoubleColumn(c);
                final double[] newCol = IntStream.range(0, origCol.length).boxed().sorted(comparator).mapToDouble(i -> origCol[i]).toArray();
                sortedDf.addColumn(this.schema.getColumnName(c), newCol);
            } else {
                // ColType.STRING
                final String[] origCol = this.getStringColumn(c);
                final String[] newCol = IntStream.range(0, origCol.length).boxed().sorted(comparator).map(i -> origCol[i]).toArray(String[]::new);
                sortedDf.addColumn(this.schema.getColumnName(c), newCol);
            }
        }
    }

    /**
     * TODO
     * @return
     */
    public Iterable<Row> getRowIterator() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Iterable<Row> getRowIterator(final int start, final int finish) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private class RowIterator implements Iterator<Row> {

        int start;

        int finish;

        RowIterator(final int start, final int finish) {
            this.start = start;
            this.finish = finish;
        }

        @Override
        public boolean hasNext() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Row next() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private class RowIterable implements Iterable<Row> {

        int start;

        int finish;

        RowIterable(final int start, final int finish) {
            this.start = start;
            this.finish = finish;
        }

        @Override
        public Iterator<Row> iterator() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
