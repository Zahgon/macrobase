package macrobase.analysis.stats.kernel;

import org.apache.commons.math3.linear.RealVector;

public class EpanchnikovMulticativeKernel extends Kernel {

    private int dimensions;

    private double norm;

    private double secondMoment;

    private final double secondMoment1D = 0.2;

    private final double norm1D = 0.6;

    public EpanchnikovMulticativeKernel(int dimensions) {
        this.dimensions = dimensions;
        this.norm = Math.pow(this.norm1D(), this.dimensions);
        this.secondMoment = Math.pow(this.secondMoment1D(), this.dimensions);
    }

    @Override
    public double density(RealVector u) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public double norm() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public double norm1D() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public double secondMoment() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public double secondMoment1D() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public double effectiveSupportWidth1D() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
