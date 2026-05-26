package macrobase.analysis.pipeline.stream;

import com.google.common.collect.Lists;
import macrobase.datamodel.Datum;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MBStream<T> {

    protected List<T> output;

    public void add(T record) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void add(List<T> records) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void close() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public MBStream() {
        output = new ArrayList<>();
    }

    public MBStream(List<T> data) {
        output = data;
    }

    public List<T> drain() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<T> drain(int maxElements) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Integer remaining() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
