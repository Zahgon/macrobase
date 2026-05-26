package macrobase.analysis.pipeline.operator;

import macrobase.analysis.pipeline.stream.MBStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public abstract class MBOperator<S, T> implements MBConsumer<S>, MBProducer<T> {

    private static final Logger log = LoggerFactory.getLogger(MBOperator.class);

    public <Y> MBOperator<S, Y> then(MBOperator<T, Y> o2, int batchSize) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public <Y> MBOperator<S, Y> then(MBOperator<T, Y> o2) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
