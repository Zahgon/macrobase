package macrobase.diagnostics;

import macrobase.analysis.stats.BatchTrainScore;
import macrobase.conf.MacroBaseConf;
import macrobase.datamodel.Datum;
import macrobase.util.DiagnosticsUtils;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ScoreDumper {

    public static final String SCORED_DATA_FILE = "macrobase.diagnostic.scoreDataFile";

    private final MacroBaseConf conf;

    private final String scoreFile;

    public ScoreDumper(MacroBaseConf conf) {
        this.conf = conf;
        this.scoreFile = conf.getString(SCORED_DATA_FILE, "");
    }

    public void dumpScores(BatchTrainScore batchTrainScore, List<Datum> data) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void dumpScores(BatchTrainScore batchTrainScore, double[][] boundaries, double delta) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void tryToDumpScoredGrid(BatchTrainScore batchTrainScore, double[][] boundingBox, int pointsPerDimension, String filename) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
