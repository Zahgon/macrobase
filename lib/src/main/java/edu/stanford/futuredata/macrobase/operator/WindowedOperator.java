package edu.stanford.futuredata.macrobase.operator;

import edu.stanford.futuredata.macrobase.datamodel.DataFrame;
import edu.stanford.futuredata.macrobase.util.ArrayUtils;
import java.util.*;

/**
 * Wraps an incremental operator to work over rolling windows.
 * Inputs are batched into panes of [start, start+slideLength).
 * slideLength is assumed to be a divisor of the window length so that
 * a window divides neatly into panes: if not the window length is
 * effectively rounded up.
 * @param <O> output type of the operator
 */
public class WindowedOperator<O> implements Operator<DataFrame, O> {

    private String timeColumn = "time";

    private double windowLength = 60.0;

    private double slideLength = 10.0;

    private double maxWindowTime;

    private IncrementalOperator<O> op;

    private ArrayList<DataFrame> batchBuffer;

    public WindowedOperator(IncrementalOperator op) {
        this.op = op;
    }

    public WindowedOperator<O> initialize() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Process a small batch of data. Data is buffered until a pane (or multiple)
     * is filled, then the internal operator state is updated with these panes.
     * Minibatches are split to fit into panes of fixed time length.
     * @param input minibatch of data to process
     * @throws Exception
     */
    @Override
    public void process(DataFrame input) throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Build a pane from what is already in the buffer, call when no more events will arrive before
     * the next pane interval.
     * @return new effective window end time
     */
    public double flushBuffer() throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Split buffer + input into panes, keeping any leftover rows in the buffer
     * @param input current minibatch to aprocess
     * @return completed panes derived from the buffer and current input
     */
    protected List<DataFrame> addToBuffer(DataFrame input) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public O getResults() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getTimeColumn() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setTimeColumn(String timeColumn) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double getWindowLength() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setWindowLength(double windowLength) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double getSlideLength() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setSlideLength(double slideLength) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double getMaxWindowTime() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public int getBufferSize() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public int getNumBufferedRows() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
