package macrobase.analysis.pipeline.stream;

import java.util.ArrayList;
import java.util.List;

public class MBMultiInputStream<T> extends MBStream<T> {

    private final List<MBStream<T>> inputs;

    private int idx = 0;

    public MBMultiInputStream(List<MBStream<T>> inputs) {
        this.inputs = inputs;
    }

    public MBMultiInputStream() {
        this(new ArrayList<>());
    }

    public void addStream(MBStream<T> input) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<T> drain(int maxElements) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
