package macrobase.util;

import macrobase.datamodel.Datum;
import macrobase.datamodel.DatumComparator;
import org.apache.commons.math3.linear.BlockRealMatrix;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Collections;
import java.util.List;

public class AlgebraUtils {

    private static final Logger log = LoggerFactory.getLogger(AlgebraUtils.class);

    public static RealMatrix invertMatrix(RealMatrix matrix) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static RealVector flattenMatrixByColumns(RealMatrix matrix) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static RealMatrix reshapeMatrixByColumns(RealVector vector, RealMatrix shapeMatrix) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static RealMatrix reshapeMatrixByColumns(RealVector vector, int width, int height) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns coordinates of a bounding for surrounding data metrics.
     *
     * @param data
     * @return
     */
    public static double[][] getBoundingBox(List<Datum> data) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
