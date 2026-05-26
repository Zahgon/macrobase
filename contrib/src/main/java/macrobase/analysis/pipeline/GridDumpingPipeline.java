package macrobase.analysis.pipeline;

import macrobase.analysis.classify.BatchingPercentileClassifier;
import macrobase.analysis.classify.DumpClassifier;
import macrobase.analysis.classify.OutlierClassifier;
import macrobase.analysis.result.AnalysisResult;
import macrobase.analysis.summary.BatchSummarizer;
import macrobase.analysis.summary.Summary;
import macrobase.analysis.transform.BatchScoreFeatureTransform;
import macrobase.analysis.transform.BeforeAfterDumpingBatchScoreFeatureTransform;
import macrobase.analysis.transform.FeatureTransform;
import macrobase.analysis.transform.GridDumpingBatchScoreTransform;
import macrobase.conf.MacroBaseConf;
import macrobase.datamodel.Datum;
import macrobase.ingest.DataIngester;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;
import java.util.List;

public class GridDumpingPipeline extends BasePipeline {

    public static final String CLASSIFIER_DUMP = "macrobase.diagnostic.dumpClassifier";

    private static final Logger log = LoggerFactory.getLogger(GridDumpingPipeline.class);

    public Pipeline initialize(MacroBaseConf conf) throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<AnalysisResult> run() throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
