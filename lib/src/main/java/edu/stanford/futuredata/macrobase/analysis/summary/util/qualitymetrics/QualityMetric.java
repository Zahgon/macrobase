package edu.stanford.futuredata.macrobase.analysis.summary.util.qualitymetrics;

/**
 * Measures how interesting a subgroup is as a function of its linear aggregates.
 * Risk ratio, support, and deviation from mean are examples.
 */
public interface QualityMetric {

    String name();

    QualityMetric initialize(double[] globalAggregates);

    double value(double[] aggregates);

    boolean isMonotonic();

    enum Action {

        KEEP(2), NEXT(1), PRUNE(0);

        private int val;

        Action(int val) {
            this.val = val;
        }

        public static Action combine(Action a, Action b) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    // can override for more fancy tight quality metric bounds
    default double maxSubgroupValue(double[] aggregates) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default Action getAction(double[] aggregates, double threshold) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default boolean isPastThreshold(double[] aggregates, double threshold) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default boolean canPassThreshold(double[] aggregates, double threshold) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
