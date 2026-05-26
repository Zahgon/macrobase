package macrobase.analysis.pipeline.stream;

import macrobase.datamodel.Datum;
import java.util.List;

public class TimeDatumStream extends MBStream<Datum> {

    private int timeColumn;

    public TimeDatumStream(int timeColumn) {
        super();
        this.timeColumn = timeColumn;
    }

    public TimeDatumStream(List<Datum> data, int timeColumn) {
        super(data);
        this.timeColumn = timeColumn;
    }

    private long getDatumTime(int i) {
        return output.get(i).getTime(timeColumn);
    }

    public List<Datum> drainDuration(long duration) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Datum peek() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
