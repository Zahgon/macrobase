package macrobase.analysis.sample;

import java.util.Random;

/**
 * Keeps an exponentially weighted sample with specified bias parameter
 * N.B. The current period is advanced explicitly.
 */
public class FlexibleDampedReservoir<T> extends AChao<T> {

    private final double bias;

    public FlexibleDampedReservoir(int capacity, double bias, Random random) {
        super(capacity, random);
        assert (bias >= 0 && bias < 1);
        this.bias = bias;
    }

    public FlexibleDampedReservoir(int capacity, double bias) {
        super(capacity);
        assert (bias >= 0 && bias < 1);
        this.bias = bias;
    }

    public void advancePeriod() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void advancePeriod(int numPeriods) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void insert(T ele) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
