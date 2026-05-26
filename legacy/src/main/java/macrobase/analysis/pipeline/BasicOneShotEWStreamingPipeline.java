package macrobase.analysis.pipeline;

import com.google.common.base.Stopwatch;
import macrobase.MacroBase;
import macrobase.analysis.classify.EWAppxPercentileOutlierClassifier;
import macrobase.analysis.pipeline.operator.MBOperator;
import macrobase.analysis.pipeline.stream.MBStream;
import macrobase.analysis.result.AnalysisResult;
import macrobase.analysis.result.OutlierClassificationResult;
import macrobase.analysis.summary.EWStreamingSummarizer;
import macrobase.analysis.summary.Summarizer;
import macrobase.analysis.summary.Summary;
import macrobase.analysis.transform.LowMetricTransform;
import macrobase.conf.MacroBaseConf;
import macrobase.conf.MacroBaseDefaults;
import macrobase.datamodel.Datum;
import macrobase.ingest.DataIngester;
import macrobase.analysis.transform.EWFeatureTransform;
import org.apache.commons.math3.stat.descriptive.summary.Sum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasicOneShotEWStreamingPipeline extends BasePipeline {

    private static final Logger log = LoggerFactory.getLogger(BasicOneShotEWStreamingPipeline.class);

    @Override
    public Pipeline initialize(MacroBaseConf conf) throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<AnalysisResult> run() throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
