package macrobase.analysis.stats;

import macrobase.analysis.pipeline.stream.MBStream;
import macrobase.analysis.transform.FeatureTransform;
import macrobase.conf.MacroBaseConf;
import macrobase.conf.MacroBaseDefaults;
import macrobase.datamodel.Datum;
import org.apache.commons.math3.distribution.MultivariateNormalDistribution;
import org.apache.commons.math3.linear.*;
import java.util.List;

public class RandomProjection extends FeatureTransform {

    private boolean hasConsumed;

    private long randomSeed;

    private RealVector metricVector;

    private RealVector transformedVector;

    private int n;

    private int k;

    private RealVector mean;

    private RealVector covV;

    private DiagonalMatrix covM;

    private MultivariateNormalDistribution mnd;

    private RealMatrix randomProjectionMatrix;

    private final MBStream<Datum> output = new MBStream<>();

    public RandomProjection(MacroBaseConf conf) {
        this.k = conf.getInt(MacroBaseConf.RANDOM_PROJECTION_K, MacroBaseDefaults.RANDOM_PROJECTION_K);
        // set MacroBaseConf.RANDOM_SEED to seed rng for the seed...
        this.randomSeed = conf.getRandom().nextLong();
        this.hasConsumed = false;
    }

    @Override
    public void consume(List<Datum> records) throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MBStream<Datum> getStream() throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void initialize() throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void shutdown() throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
