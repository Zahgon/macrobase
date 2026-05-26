package macrobase.analysis.stats;

import macrobase.analysis.stats.distribution.MultivariateTDistribution;
import macrobase.conf.MacroBaseConf;
import macrobase.datamodel.Datum;
import org.apache.commons.math3.linear.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

/**
 * BayesianNormalDensity fits a Gaussian distribution to a
 * multidimensional dataset, using Bayesian Inference and starting
 * with a simple Prior.
 * The predictive distribution for the density is a multivariate Student T distribution.
 */
public class BayesianNormalDensity extends BatchTrainScore {

    private static final Logger log = LoggerFactory.getLogger(BayesianNormalDensity.class);

    // prior covariance parameters for a Wishart distribution.
    private int priorDegreesOfFreedom;

    private RealMatrix priorCovariance;

    // prior mean parameters for Normal distribution. N(u, s * W(v, C))
    private RealVector priorMean;

    private double priorVarianceScale;

    // posterior covariance parameters for a Wishart distribution.
    private int posteriorDegreesOfFreedom;

    private RealMatrix posteriorCovariance;

    // posterior mean parameters for Normal distribution. N(u, s * W(v, C))
    private RealVector posteriorMean;

    private double posteriorVarianceScale;

    private MultivariateTDistribution distribution;

    public BayesianNormalDensity(MacroBaseConf conf) {
        super(conf);
    }

    @Override
    public void train(List<Datum> data) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public RealVector getMean() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public double score(Datum datum) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double getDensity(Datum datum) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
