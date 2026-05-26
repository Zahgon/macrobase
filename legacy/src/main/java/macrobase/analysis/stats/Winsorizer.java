package macrobase.analysis.stats;

import org.apache.commons.math3.stat.descriptive.rank.Percentile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Winsorizer {

    public double trimPct;

    public double[][] bounds;

    public Winsorizer(double trimPct) {
        this.trimPct = trimPct;
    }

    public List<double[]> process(List<double[]> metrics) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
