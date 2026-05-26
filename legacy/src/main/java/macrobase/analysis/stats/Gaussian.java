package macrobase.analysis.stats;

import org.apache.commons.math3.linear.*;
import org.apache.commons.math3.stat.descriptive.moment.VectorialCovariance;
import java.util.Arrays;
import java.util.List;

public class Gaussian {

    public int k = 0;

    public double[] mean;

    public RealMatrix cov;

    public double[][] inverseCov;

    public boolean singular = false;

    public Gaussian() {
    }

    public Gaussian(double[] mean, RealMatrix cov) {
        this.k = mean.length;
        this.mean = Arrays.copyOf(mean, mean.length);
        this.cov = cov;
        initialize();
    }

    public Gaussian fit(List<double[]> data) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void initialize() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double mahalanobis(double[] query) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double[] getMean() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public RealMatrix getCovariance() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
