package macrobase.analysis.contextualoutlier;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import macrobase.datamodel.Datum;

public class LatticeNode {

    // A list of ordered contextual dimensions this node represents;
    List<Integer> dimensions;

    //A list of dense contexts this node contains
    List<Context> denseContexts;

    public LatticeNode(int dimension) {
        dimensions = new ArrayList<Integer>();
        dimensions.add(dimension);
        denseContexts = new ArrayList<Context>();
    }

    public LatticeNode(List<Integer> dimensions) {
        this.dimensions = dimensions;
        denseContexts = new ArrayList<Context>();
    }

    public List<Context> getDenseContexts() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void addDenseContext(Context c) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public LatticeNode join(LatticeNode other, List<ContextualDatum> data, double tau) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<Integer> getDimensions() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Joins this subspace with the specified subspace. The join is only
     * successful if both subspaces have the first k-1 dimensions in common (where
     * k is the number of dimensions).
     * <p>
     * Return null is not successful
     *
     * @param other
     * @return
     */
    public List<Integer> joinedDimensions(LatticeNode other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Compare the subspace based on the dimensions
     *
     * @author xuchu
     */
    public static class DimensionComparator implements Comparator<LatticeNode> {

        @Override
        public int compare(LatticeNode s1, LatticeNode s2) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public void clear() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
