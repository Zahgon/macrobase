package macrobase.analysis.stats;

import static com.codahale.metrics.MetricRegistry.name;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import com.codahale.metrics.Counter;
import macrobase.MacroBase;
import macrobase.conf.ConfigurationException;
import macrobase.conf.MacroBaseConf;
import macrobase.conf.MacroBaseDefaults;
import macrobase.datamodel.Datum;
import org.apache.commons.math3.distribution.ChiSquaredDistribution;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.linear.SingularMatrixException;
import org.apache.commons.math3.linear.SingularValueDecomposition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.codahale.metrics.Timer;

public class MinCovDet extends BatchTrainScore {

    private static final Logger log = LoggerFactory.getLogger(MinCovDet.class);

    private final Timer chooseKRandom = MacroBase.metrics.timer(name(MinCovDet.class, "chooseKRandom"));

    private final Timer meanComputation = MacroBase.metrics.timer(name(MinCovDet.class, "meanComputation"));

    private final Timer covarianceComputation = MacroBase.metrics.timer(name(MinCovDet.class, "covarianceComputation"));

    private final Timer determinantComputation = MacroBase.metrics.timer(name(MinCovDet.class, "determinantComputation"));

    private final Timer findKClosest = MacroBase.metrics.timer(name(MinCovDet.class, "findKClosest"));

    private final Counter singularCovariances = MacroBase.metrics.counter(name(MinCovDet.class, "singularCovariances"));

    // p == dataset dimension
    private final int p;

    // H = alpha*(n+p+1)
    private double alpha;

    private final Random random;

    private double stoppingDelta;

    private RealMatrix cov;

    private RealMatrix inverseCov;

    private RealVector mean;

    // efficient only when k << allData.size()
    private List<Datum> chooseKRandom(List<Datum> allData, final int k) {
        assert (k < allData.size());
        List<Datum> ret = new ArrayList<>();
        Set<Integer> alreadyChosen = new HashSet<>();
        while (ret.size() < k) {
            int idx = random.nextInt(allData.size());
            if (!alreadyChosen.contains(idx)) {
                alreadyChosen.add(idx);
                ret.add(allData.get(idx));
            }
        }
        assert (ret.size() == k);
        return ret;
    }

    public MinCovDet(MacroBaseConf conf) {
        super(conf);
        try {
            this.p = conf.getStringList(MacroBaseConf.METRICS).size();
        } catch (ConfigurationException e) {
            // Should never happen, but to avoid having to add throws
            // declaration, we re-throw as RuntimeException.
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        this.alpha = conf.getDouble(MacroBaseConf.MCD_ALPHA, MacroBaseDefaults.MCD_ALPHA);
        this.stoppingDelta = conf.getDouble(MacroBaseConf.MCD_STOPPING_DELTA, MacroBaseDefaults.MCD_STOPPING_DELTA);
        this.random = conf.getRandom();
    }

    public static Double getMahalanobis(RealVector mean, RealMatrix inverseCov, RealVector vec) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private RealVector getMean(List<Datum> data) {
        RealVector vec = null;
        for (Datum d : data) {
            RealVector dvec = d.metrics();
            if (vec == null) {
                vec = dvec;
            } else {
                vec = vec.add(dvec);
            }
        }
        return vec.mapDivide(data.size());
    }

    private List<Datum> findKClosest(int k, List<Datum> data) {
        if (data.size() < k) {
            return data;
        }
        Map<Datum, Double> scoreMap = new HashMap<>(data.size());
        for (Datum d : data) {
            scoreMap.put(d, getMahalanobis(mean, inverseCov, d.metrics()));
        }
        data.sort((a, b) -> scoreMap.get(a).compareTo(scoreMap.get(b)));
        return data.subList(0, k);
    }

    // helper method
    public static double getDeterminant(RealMatrix cov) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void updateInverseCovariance() {
        try {
            inverseCov = new LUDecomposition(cov).getSolver().getInverse();
        } catch (SingularMatrixException e) {
            singularCovariances.inc();
            inverseCov = new SingularValueDecomposition(cov).getSolver().getInverse();
        }
    }

    @Override
    public void train(List<Datum> input) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public double score(Datum datum) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public RealMatrix getCovariance() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public RealMatrix getInverseCovariance() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public RealVector getMean() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double getZScoreEquivalent(double zscore) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
