package macrobase.analysis.summary.itemset.result;

public class RiskRatioResult {

    private double rr = 0;

    private double correction = 0;

    public RiskRatioResult(double rr, double correction) {
        this.rr = rr;
        this.correction = correction;
    }

    public RiskRatioResult(double rr) {
        this.rr = rr;
    }

    public double get() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double getCorrected() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double getCorrectedRiskRatio() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
