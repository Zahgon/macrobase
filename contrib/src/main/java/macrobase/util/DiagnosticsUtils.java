package macrobase.util;

import macrobase.datamodel.Datum;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;
import java.util.ArrayList;
import java.util.List;

public class DiagnosticsUtils {

    public static List<Datum> createGridFixedIncrement(double[][] boundaries, double delta) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static List<Datum> convertToGrid(List<RealVector> anchors) {
        // TODO: Currently only supports 1D and 2D grids.
        int size = 1;
        for (RealVector v : anchors) {
            size *= v.getDimension();
        }
        int dimension = anchors.size();
        List<Datum> grid = new ArrayList<>(size);
        double[] array = new double[dimension];
        if (dimension == 1) {
            for (double x : anchors.get(0).toArray()) {
                array[0] = x;
                grid.add(new Datum(new ArrayList<Integer>(), new ArrayRealVector(array)));
            }
        } else if (dimension == 2) {
            for (double x : anchors.get(0).toArray()) {
                array[0] = x;
                for (double y : anchors.get(1).toArray()) {
                    array[1] = y;
                    grid.add(new Datum(new ArrayList<Integer>(), new ArrayRealVector(array)));
                }
            }
        }
        return grid;
    }

    public static List<Datum> createGridFixedSize(double[][] boundaries, int pointsPerDimension) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
