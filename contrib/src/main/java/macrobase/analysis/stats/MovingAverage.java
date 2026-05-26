package macrobase.analysis.stats;

import java.util.Deque;
import java.util.ArrayDeque;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;
import macrobase.conf.MacroBaseConf;
import macrobase.datamodel.Datum;

/*
 * Simple moving average.
 */
public class MovingAverage extends TimeSeriesScore {

    Deque<DatumWithInfo> window = new ArrayDeque<DatumWithInfo>();

    int weightTotal;

    private RealVector windowSum;

    private static class DatumWithInfo {

        private Datum datum;

        private long weight;

        public DatumWithInfo(Datum datum, long weight) {
            this.datum = datum;
            this.weight = weight;
        }

        public Datum getDatum() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public long getWeight() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public MovingAverage(MacroBaseConf conf) {
        super(conf);
    }

    @Override
    public void addToWindow(Datum newDatum) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void addDatumWithWeight(Datum d, long weight) {
        windowSum = windowSum.add(d.metrics().mapMultiply(weight));
        weightTotal += weight;
        window.add(new DatumWithInfo(d, weight));
    }

    private Datum getLatestDatum() {
        return window.peekLast().getDatum();
    }

    @Override
    public void removeLastFromWindow() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public double scoreWindow() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
