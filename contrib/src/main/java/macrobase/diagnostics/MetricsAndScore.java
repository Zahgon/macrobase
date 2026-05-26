package macrobase.diagnostics;

import org.apache.commons.math3.linear.RealVector;

public class MetricsAndScore {

    private RealVector metrics;

    private double score;

    public MetricsAndScore(RealVector metrics, double score) {
        this.metrics = metrics;
        this.score = score;
    }

    public RealVector getMetrics() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double getScore() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
