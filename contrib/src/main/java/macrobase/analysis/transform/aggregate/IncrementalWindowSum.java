package macrobase.analysis.transform.aggregate;

import macrobase.conf.ConfigurationException;
import macrobase.conf.MacroBaseConf;
import macrobase.datamodel.Datum;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;
import java.util.ArrayList;
import java.util.List;

public class IncrementalWindowSum extends IncrementalWindowAggregate {

    public IncrementalWindowSum(MacroBaseConf conf) throws ConfigurationException {
        super(conf);
    }

    public Datum updateWindow(List<Datum> new_data, List<Datum> old_data) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
