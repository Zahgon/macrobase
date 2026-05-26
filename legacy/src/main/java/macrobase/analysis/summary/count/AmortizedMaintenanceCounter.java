package macrobase.analysis.summary.count;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*
 Maintains probabilistic heavy-hitters:
    - Item counts are overreported.
    - Once we have seen 1/threshold items, size is >= 1/threshold items.

 This is similar to SpaceSaving but with:
   - O(1) update and O(items*log(k)) maintenance
     (normally O(log(k)) update)
   - unlimited space overhead within an epoch (normally O(k))

 Basic idea:
    Store min count from previous epoch
    Item in table? Increment
    Item not in table? Min + count

    End of epoch:
     1.) decay counts
     2.) record new min
     3.) compute 1/thresh highest counts
     4.) discard lower items, updating min if necessary

 */
public class AmortizedMaintenanceCounter extends ApproximateCount {

    private static final Logger log = LoggerFactory.getLogger(AmortizedMaintenanceCounter.class);

    private double decayFactor = 1;

    private static final double DECAY_RESET_THRESHOLD = Double.MAX_VALUE * .5;

    private HashMap<Integer, Double> counts = new HashMap<>();

    private double totalCount = 0;

    private final int maxStableSize;

    private double prevEpochMaxEvicted = 0;

    public AmortizedMaintenanceCounter(int maxStableSize) {
        this.maxStableSize = maxStableSize;
    }

    @Override
    public void multiplyAllCounts(Double by) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public HashMap<Integer, Double> getCounts() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void resetDecayFactor() {
        log.trace("Decaying; {} items stored", counts.size());
        for (Map.Entry<Integer, Double> entry : counts.entrySet()) {
            double newValue = entry.getValue() / decayFactor;
            counts.put(entry.getKey(), newValue);
        }
        totalCount /= decayFactor;
        decayFactor = 1;
    }

    @Override
    public void observe(Integer item, double count) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public double getTotalCount() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public double getCount(int item) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
