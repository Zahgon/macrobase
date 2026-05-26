package macrobase.analysis.summary.itemset.result;

import macrobase.ingest.result.ColumnValue;
import java.util.List;
import java.util.StringJoiner;

public class ItemsetResult {

    private double support;

    private double numRecords;

    private double ratioToInliers;

    private List<ColumnValue> items;

    public ItemsetResult(double support, double numRecords, double ratioToInliers, List<ColumnValue> items) {
        this.support = support;
        this.numRecords = numRecords;
        this.ratioToInliers = ratioToInliers;
        this.items = items;
    }

    public String prettyPrint() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double getSupport() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double getNumRecords() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double getRatioToInliers() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setRatioToInliers(double ratio) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<ColumnValue> getItems() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ItemsetResult() {
        // JACKSON
    }
}
