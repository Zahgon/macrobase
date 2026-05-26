package macrobase.analysis.contextualoutlier;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import macrobase.analysis.contextualoutlier.conf.ContextualConf;
import macrobase.analysis.pipeline.BasePipeline;
import macrobase.analysis.pipeline.Pipeline;
import macrobase.analysis.result.OutlierClassificationResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import macrobase.analysis.result.AnalysisResult;
import macrobase.analysis.result.ContextualAnalysisResult;
import macrobase.analysis.summary.BatchSummarizer;
import macrobase.analysis.summary.Summary;
import macrobase.conf.MacroBaseConf;
import macrobase.analysis.contextualoutlier.conf.ContextualConf.ContextualAPI;
import macrobase.datamodel.Datum;
import macrobase.ingest.DataIngester;

public class BasicContextualBatchedPipeline extends BasePipeline {

    private static final Logger log = LoggerFactory.getLogger(BasicContextualBatchedPipeline.class);

    @Override
    public Pipeline initialize(MacroBaseConf conf) throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<AnalysisResult> run() throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
