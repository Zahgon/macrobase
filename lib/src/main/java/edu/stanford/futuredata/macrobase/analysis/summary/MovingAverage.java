package edu.stanford.futuredata.macrobase.analysis.summary;

import edu.stanford.futuredata.macrobase.datamodel.DataFrame;
import edu.stanford.futuredata.macrobase.operator.IncrementalOperator;
import java.util.ArrayDeque;
import java.util.Deque;

public class MovingAverage implements IncrementalOperator<Double> {

    private String columnName;

    private int windowSize = 0;

    private Deque<Double> paneSums;

    private Deque<Integer> paneCounts;

    public MovingAverage(String columnName, int windowSize) {
        this.columnName = columnName;
        this.windowSize = windowSize;
        paneSums = new ArrayDeque<>(windowSize + 1);
        paneCounts = new ArrayDeque<>(windowSize + 1);
    }

    @Override
    public void process(DataFrame input) throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Double getResults() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void setWindowSize(int numPanes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int getWindowSize() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
