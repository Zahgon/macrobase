package edu.stanford.futuredata.macrobase.datamodel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * Provides column names, types, and order
 */
public class Schema {

    public enum ColType {

        STRING, DOUBLE
    }

    private ArrayList<String> columnNames;

    private ArrayList<ColType> columnTypes;

    private HashMap<String, Integer> columnIndices;

    public Schema() {
        this.columnNames = new ArrayList<>();
        this.columnTypes = new ArrayList<>();
        this.columnIndices = new HashMap<>();
    }

    public Schema copy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String toString() {
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
    boolean renameColumn(String oldColumnName, String newColumnName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean hasColumn(String columnName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean hasColumns(Collection<String> columnNames) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public int getNumColumns() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public int getColumnIndex(String s) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ArrayList<Integer> getColumnIndices(List<String> columns) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getColumnName(int i) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<String> getColumnNames() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<String> getColumnNamesByType(ColType type) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ColType getColumnType(int i) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ColType getColumnTypeByName(String s) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Schema addColumn(ColType t, String colName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean equals(Object obj) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
