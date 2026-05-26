package macrobase.analysis.stats.kalmanfilter;

import macrobase.util.AlgebraUtils;
import org.apache.commons.math3.linear.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Kalman Filter for a vector without user input at every step (u = 0) https://en.wikipedia.org/wiki/Kalman_filter#Details
 * Currently user has to specify measurement and noise estimates using qScale (process noise) and rScale (measurement noise)
 */
public class KalmanVectorFilter {

    private static final Logger log = LoggerFactory.getLogger(KalmanVectorFilter.class);

    protected double qScale;

    protected double rScale;

    // measurement operator
    private final RealMatrix H;

    protected RealMatrix state;

    protected RealMatrix cov;

    public KalmanVectorFilter(RealVector startLoc, double qScale) {
        this(startLoc, qScale, 1);
    }

    /**
     * @param startLoc location at time 0
     * @param qScale process noise variance per unit time
     * @param rScale measurement noise variance
     */
    public KalmanVectorFilter(RealVector startLoc, double qScale, double rScale) {
        this.qScale = qScale;
        this.rScale = rScale;
        double[][] tmp = { { 1, 0 } };
        H = new BlockRealMatrix(tmp);
        reset(startLoc);
    }

    public void reset(RealVector startLoc) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected RealVector measure(RealMatrix state) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Implement a filtering step, for more information see:
     * https://en.wikipedia.org/wiki/Kalman_filter#Example_application.2C_technical
     * @param observation observed value for the vector
     * @param time time interval from previous observation
     * @return filtered vector
     */
    public RealVector step(RealVector observation, int time) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
