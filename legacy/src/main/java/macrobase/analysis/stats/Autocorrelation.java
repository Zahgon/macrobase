package macrobase.analysis.stats;

import macrobase.datamodel.Datum;
import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.transform.DftNormalization;
import org.apache.commons.math3.transform.FastFourierTransformer;
import org.apache.commons.math3.transform.TransformType;
import java.util.ArrayList;
import java.util.List;

/* Autocorrelation via FFT
 *    F_R(f) = FFT(X)
 *    S(f) = F_R(f)F_R*(f)
 *    R(t) = IFFT(S(f))
 * */
public class Autocorrelation {

    // Autocorrelation
    public double[] correlations;

    // Max autocorrelation peak
    public double maxACF = 0;

    private FastFourierTransformer fftTran = new FastFourierTransformer(DftNormalization.STANDARD);

    // Minimum correlation threshold
    private double ACF_THRESH = 0.2;

    private int metricIdx = 1;

    // Maximum length of autocorrelation to calculate
    private int maxLag;

    public Autocorrelation(int maxLag, int metricIdx) {
        this.maxLag = maxLag;
        this.metricIdx = metricIdx;
    }

    public void setMaxLag(int lag) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setCorrelationThreshold(double thresh) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private double mean(double[] metrics) {
        int n = metrics.length;
        double m = 0;
        for (int i = 0; i < n; i++) {
            m += metrics[i];
        }
        return m / n;
    }

    private double[] stripDatum(List<Datum> datum) {
        double[] values = new double[datum.size()];
        for (int i = 0; i < datum.size(); i++) {
            values[i] = datum.get(i).metrics().getEntry(metricIdx);
        }
        return values;
    }

    private double[] formatData(List<Datum> data) {
        double[] metrics = stripDatum(data);
        int n = metrics.length;
        double m = mean(metrics);
        // Pad with 0
        Double padding = Math.pow(2, 32 - Integer.numberOfLeadingZeros(2 * n - 1));
        double[] values = new double[padding.intValue()];
        // zero mean data
        for (int i = 0; i < n; i++) {
            values[i] = metrics[i] - m;
        }
        return values;
    }

    /* Calculate autocorrelation for the given list of Datum */
    public void evaluate(List<Datum> data) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /* Find autocorrelation peaks */
    public List<Integer> findPeaks() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
