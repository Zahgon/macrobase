package macrobase.ingest;

import macrobase.datamodel.Datum;
import macrobase.ingest.result.ColumnValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DatumEncoder {

    private static final Logger log = LoggerFactory.getLogger(DatumEncoder.class);

    private HashMap<Integer, String> attributeDimensionNameMap = new HashMap<>();

    private HashMap<Integer, Map<String, Integer>> integerEncoding = new HashMap<>();

    private HashMap<Integer, Integer> integerToColumn = new HashMap<>();

    private Integer nextKey = 0;

    // kryo
    public DatumEncoder() {
    }

    // kind of a hack...
    public void copy(DatumEncoder other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void recordAttributeName(int dimension, String attribute) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getAttributeName(Integer dimension) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ColumnValue getAttribute(int encodedAttr) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<ColumnValue> getColsFromAttrSet(Set<Integer> attrs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<ColumnValue> getColsFromAttr(Integer item) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public int getIntegerEncoding(int dimension, String attr) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public int getNextKey() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
