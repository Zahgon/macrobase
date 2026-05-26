package edu.stanford.futuredata.macrobase.pipeline;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.yaml.snakeyaml.Yaml;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;

/**
 * Generic class for loading configs from a variety of sources (right now yaml).
 * Used for setting parameters to pipelines.
 */
public class PipelineConfig {

    private Map<String, Object> values;

    public PipelineConfig(Map<String, Object> values) {
        this.values = values;
    }

    public static PipelineConfig fromYamlFile(String fileName) throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static PipelineConfig fromJsonString(String json) throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String key, T defaultValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Map<String, Object> getValues() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
