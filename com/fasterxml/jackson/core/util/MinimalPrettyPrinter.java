package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fossil.afb;
import java.io.IOException;
import java.io.Serializable;

public class MinimalPrettyPrinter implements afb, Serializable {
    public static final String DEFAULT_ROOT_VALUE_SEPARATOR = " ";
    private static final long serialVersionUID = 1;
    protected String _rootValueSeparator;

    public MinimalPrettyPrinter() {
        this(DEFAULT_ROOT_VALUE_SEPARATOR);
    }

    public MinimalPrettyPrinter(String str) {
        this._rootValueSeparator = DEFAULT_ROOT_VALUE_SEPARATOR;
        this._rootValueSeparator = str;
    }

    public void setRootValueSeparator(String str) {
        this._rootValueSeparator = str;
    }

    public void writeRootValueSeparator(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        if (this._rootValueSeparator != null) {
            jsonGenerator.aR(this._rootValueSeparator);
        }
    }

    public void writeStartObject(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        jsonGenerator.mo935a('{');
    }

    public void beforeObjectEntries(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
    }

    public void writeObjectFieldValueSeparator(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        jsonGenerator.mo935a(':');
    }

    public void writeObjectEntrySeparator(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        jsonGenerator.mo935a(',');
    }

    public void writeEndObject(JsonGenerator jsonGenerator, int i) throws IOException, JsonGenerationException {
        jsonGenerator.mo935a('}');
    }

    public void writeStartArray(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        jsonGenerator.mo935a('[');
    }

    public void beforeArrayValues(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
    }

    public void writeArrayValueSeparator(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        jsonGenerator.mo935a(',');
    }

    public void writeEndArray(JsonGenerator jsonGenerator, int i) throws IOException, JsonGenerationException {
        jsonGenerator.mo935a(']');
    }
}
