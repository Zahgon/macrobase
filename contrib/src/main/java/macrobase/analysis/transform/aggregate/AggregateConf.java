package macrobase.analysis.transform.aggregate;

import macrobase.conf.ConfigurationException;
import macrobase.conf.MacroBaseConf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AggregateConf {

    public static final String AGGREGATE_TYPE = "macrobase.analysis.aggregateType";

    public static final AggregateType AGGREGATE_TYPE_DEFAULT = AggregateConf.AggregateType.COUNT;

    private static final Logger log = LoggerFactory.getLogger(AggregateConf.class);

    public enum AggregateType {

        COUNT, SUM, MAX, AVG
    }

    public static AggregateType getAggregateType(MacroBaseConf conf) throws ConfigurationException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static BatchWindowAggregate constructBatchAggregate(MacroBaseConf conf, AggregateType aggregateType) throws ConfigurationException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static IncrementalWindowAggregate constructIncrementalAggregate(MacroBaseConf conf, AggregateType aggregateType) throws ConfigurationException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
