package macrobase.analysis.index;

import macrobase.datamodel.Datum;
import macrobase.datamodel.DatumComparator;
import macrobase.util.AlgebraUtils;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import java.util.Collections;
import java.util.List;

public class KDTree {

    private int leafCapacity;

    protected KDTree loChild;

    protected KDTree hiChild;

    protected int k;

    protected List<Datum> items;

    // Statistics
    protected int nBelow;

    protected RealVector mean;

    private int splitDimension;

    private double splitValue;

    // Array of (k,2) dimensions, of (min, max) pairs in all k dimensions
    private double[][] boundaries;

    /**
     * Build a KD-Tree that makes the splits based on the midpoint of the widest dimension.
     * This is the approach described in [Gray, Moore 2003] based on [Deng, Moore 1995].
     * @param data
     * @param leafCapacity
     */
    public KDTree(List<Datum> data, int leafCapacity) {
        this.leafCapacity = leafCapacity;
        this.k = data.get(0).metrics().getDimension();
        this.boundaries = new double[k][2];
        boundaries = AlgebraUtils.getBoundingBox(data);
        if (data.size() > this.leafCapacity) {
            double[] differences = new double[this.k];
            for (int i = 0; i < k; i++) {
                differences[i] = this.boundaries[i][1] - this.boundaries[i][0];
            }
            int widestDimension = 0;
            double maxDidth = -1;
            for (int i = 0; i < k; i++) {
                if (differences[i] > maxDidth) {
                    maxDidth = differences[i];
                    widestDimension = i;
                }
            }
            this.splitDimension = widestDimension;
            // XXX: This is the slow part!!!
            Collections.sort(data, new DatumComparator(splitDimension));
            int splitIndex = data.size() / 2;
            Datum belowSplit = data.get(splitIndex - 1);
            Datum aboveSplit = data.get(splitIndex);
            this.splitValue = 0.5 * (aboveSplit.metrics().getEntry(splitDimension) + belowSplit.metrics().getEntry(splitDimension));
            this.loChild = new KDTree(data.subList(0, splitIndex), leafCapacity);
            this.hiChild = new KDTree(data.subList(splitIndex, data.size()), leafCapacity);
            this.nBelow = data.size();
            this.mean = (loChild.mean.mapMultiply(loChild.nBelow).add(hiChild.mean.mapMultiply(hiChild.nBelow)).mapDivide(loChild.nBelow + hiChild.nBelow));
        } else {
            this.items = data;
            this.nBelow = data.size();
            RealMatrix ret = new Array2DRowRealMatrix(data.size(), this.k);
            RealVector sum = new ArrayRealVector(this.k);
            int index = 0;
            for (Datum d : data) {
                ret.setRow(index, d.metrics().toArray());
                sum = sum.add(d.metrics());
                index += 1;
            }
            this.mean = sum.mapDivide(this.nBelow);
        }
    }

    /**
     * Estimates min and max difference absolute vectors from point to region
     * @param queryDatum target point
     * @return minVec, maxVec
     */
    // TODO: Make this method faster.
    public RealVector[] getMinMaxDistanceVectors(Datum queryDatum) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Estimates bounds on the distance to a region
     * @param queryDatum target point
     * @return array with min, max distances squared
     */
    public double[] estimateL2DistanceSquared(Datum queryDatum) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isInsideBoundaries(Datum queryDatum) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<Datum> getItems() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public RealVector getMean() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double[][] getBoundaries() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public KDTree getLoChild() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public KDTree getHiChild() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isLeaf() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public int getnBelow() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public int getSplitDimension() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String toString(int indent) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
