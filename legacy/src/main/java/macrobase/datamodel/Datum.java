package macrobase.datamodel;

import com.google.common.collect.Lists;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Datum {

    private static AtomicLong idGen = new AtomicLong();

    private final Long id;

    private List<Integer> attributes;

    private RealVector metrics;

    //the parent datum this datum is created from
    private final Long parentDatumID;

    public Datum() {
        id = idGen.incrementAndGet();
        parentDatumID = null;
    }

    public Datum(Datum oldDatum) {
        this();
        this.attributes = Lists.newArrayList(oldDatum.attributes);
        this.metrics = oldDatum.metrics().copy();
    }

    public Datum(Datum oldDatum, double... doubleMetrics) {
        this(oldDatum, new ArrayRealVector(doubleMetrics));
    }

    public Datum(Datum oldDatum, RealVector metrics) {
        this.id = idGen.incrementAndGet();
        this.parentDatumID = oldDatum.getID();
        this.metrics = metrics;
        this.attributes = oldDatum.attributes();
    }

    public Datum(List<Integer> attributes, double... doubleMetrics) {
        this(attributes, new ArrayRealVector(doubleMetrics));
    }

    public Datum(List<Integer> attributes, RealVector metrics) {
        this();
        this.attributes = attributes;
        this.metrics = metrics;
    }

    public long getTime(Integer timeColumn) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<Integer> attributes() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public RealVector metrics() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Long getID() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Long getParentID() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double norm() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
