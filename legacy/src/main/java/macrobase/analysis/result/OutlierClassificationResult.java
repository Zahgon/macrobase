package macrobase.analysis.result;

import macrobase.datamodel.Datum;

public class OutlierClassificationResult {

    private Boolean isClassifiedAsOutlier;

    private Datum datum;

    public OutlierClassificationResult(Datum datum, Boolean outlier) {
        this.isClassifiedAsOutlier = outlier;
        this.datum = datum;
    }

    public Boolean isOutlier() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Datum getDatum() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
