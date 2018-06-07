package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fossil.afb;
import com.fossil.afc;
import com.fossil.ago;
import java.io.IOException;
import java.io.Serializable;

public class DefaultPrettyPrinter implements afb, ago<DefaultPrettyPrinter>, Serializable {
    public static final SerializedString DEFAULT_ROOT_VALUE_SEPARATOR = new SerializedString(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
    private static final long serialVersionUID = 1;
    protected C1504a _arrayIndenter;
    protected transient int _nesting;
    protected C1504a _objectIndenter;
    protected final afc _rootSeparator;
    protected boolean _spacesInObjectEntries;

    public interface C1504a {
        boolean isInline();

        void writeIndentation(JsonGenerator jsonGenerator, int i) throws IOException;
    }

    public static class NopIndenter implements C1504a, Serializable {
        public static final NopIndenter instance = new NopIndenter();

        public void writeIndentation(JsonGenerator jsonGenerator, int i) throws IOException {
        }

        public boolean isInline() {
            return true;
        }
    }

    public static class FixedSpaceIndenter extends NopIndenter {
        public static final FixedSpaceIndenter instance = new FixedSpaceIndenter();

        public void writeIndentation(JsonGenerator jsonGenerator, int i) throws IOException {
            jsonGenerator.mo935a(' ');
        }

        public boolean isInline() {
            return true;
        }
    }

    public DefaultPrettyPrinter() {
        this(DEFAULT_ROOT_VALUE_SEPARATOR);
    }

    public DefaultPrettyPrinter(String str) {
        this(str == null ? null : new SerializedString(str));
    }

    public DefaultPrettyPrinter(afc com_fossil_afc) {
        this._arrayIndenter = FixedSpaceIndenter.instance;
        this._objectIndenter = DefaultIndenter.SYSTEM_LINEFEED_INSTANCE;
        this._spacesInObjectEntries = true;
        this._nesting = 0;
        this._rootSeparator = com_fossil_afc;
    }

    public DefaultPrettyPrinter(DefaultPrettyPrinter defaultPrettyPrinter) {
        this(defaultPrettyPrinter, defaultPrettyPrinter._rootSeparator);
    }

    public DefaultPrettyPrinter(DefaultPrettyPrinter defaultPrettyPrinter, afc com_fossil_afc) {
        this._arrayIndenter = FixedSpaceIndenter.instance;
        this._objectIndenter = DefaultIndenter.SYSTEM_LINEFEED_INSTANCE;
        this._spacesInObjectEntries = true;
        this._nesting = 0;
        this._arrayIndenter = defaultPrettyPrinter._arrayIndenter;
        this._objectIndenter = defaultPrettyPrinter._objectIndenter;
        this._spacesInObjectEntries = defaultPrettyPrinter._spacesInObjectEntries;
        this._nesting = defaultPrettyPrinter._nesting;
        this._rootSeparator = com_fossil_afc;
    }

    public DefaultPrettyPrinter withRootSeparator(afc com_fossil_afc) {
        if (this._rootSeparator != com_fossil_afc) {
            return (com_fossil_afc == null || !com_fossil_afc.equals(this._rootSeparator)) ? new DefaultPrettyPrinter(this, com_fossil_afc) : this;
        } else {
            return this;
        }
    }

    public DefaultPrettyPrinter withRootSeparator(String str) {
        return withRootSeparator(str == null ? null : new SerializedString(str));
    }

    public void indentArraysWith(C1504a c1504a) {
        if (c1504a == null) {
            c1504a = NopIndenter.instance;
        }
        this._arrayIndenter = c1504a;
    }

    public void indentObjectsWith(C1504a c1504a) {
        if (c1504a == null) {
            c1504a = NopIndenter.instance;
        }
        this._objectIndenter = c1504a;
    }

    @Deprecated
    public void spacesInObjectEntries(boolean z) {
        this._spacesInObjectEntries = z;
    }

    public DefaultPrettyPrinter withArrayIndenter(C1504a c1504a) {
        if (c1504a == null) {
            c1504a = NopIndenter.instance;
        }
        if (this._arrayIndenter == c1504a) {
            return this;
        }
        DefaultPrettyPrinter defaultPrettyPrinter = new DefaultPrettyPrinter(this);
        defaultPrettyPrinter._arrayIndenter = c1504a;
        return defaultPrettyPrinter;
    }

    public DefaultPrettyPrinter withObjectIndenter(C1504a c1504a) {
        if (c1504a == null) {
            c1504a = NopIndenter.instance;
        }
        if (this._objectIndenter == c1504a) {
            return this;
        }
        DefaultPrettyPrinter defaultPrettyPrinter = new DefaultPrettyPrinter(this);
        defaultPrettyPrinter._objectIndenter = c1504a;
        return defaultPrettyPrinter;
    }

    public DefaultPrettyPrinter withSpacesInObjectEntries() {
        return _withSpaces(true);
    }

    public DefaultPrettyPrinter withoutSpacesInObjectEntries() {
        return _withSpaces(false);
    }

    protected DefaultPrettyPrinter _withSpaces(boolean z) {
        if (this._spacesInObjectEntries == z) {
            return this;
        }
        DefaultPrettyPrinter defaultPrettyPrinter = new DefaultPrettyPrinter(this);
        defaultPrettyPrinter._spacesInObjectEntries = z;
        return defaultPrettyPrinter;
    }

    public DefaultPrettyPrinter createInstance() {
        return new DefaultPrettyPrinter(this);
    }

    public void writeRootValueSeparator(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        if (this._rootSeparator != null) {
            jsonGenerator.mo946d(this._rootSeparator);
        }
    }

    public void writeStartObject(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        jsonGenerator.mo935a('{');
        if (!this._objectIndenter.isInline()) {
            this._nesting++;
        }
    }

    public void beforeObjectEntries(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        this._objectIndenter.writeIndentation(jsonGenerator, this._nesting);
    }

    public void writeObjectFieldValueSeparator(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        if (this._spacesInObjectEntries) {
            jsonGenerator.aR(" : ");
        } else {
            jsonGenerator.mo935a(':');
        }
    }

    public void writeObjectEntrySeparator(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        jsonGenerator.mo935a(',');
        this._objectIndenter.writeIndentation(jsonGenerator, this._nesting);
    }

    public void writeEndObject(JsonGenerator jsonGenerator, int i) throws IOException, JsonGenerationException {
        if (!this._objectIndenter.isInline()) {
            this._nesting--;
        }
        if (i > 0) {
            this._objectIndenter.writeIndentation(jsonGenerator, this._nesting);
        } else {
            jsonGenerator.mo935a(' ');
        }
        jsonGenerator.mo935a('}');
    }

    public void writeStartArray(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        if (!this._arrayIndenter.isInline()) {
            this._nesting++;
        }
        jsonGenerator.mo935a('[');
    }

    public void beforeArrayValues(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        this._arrayIndenter.writeIndentation(jsonGenerator, this._nesting);
    }

    public void writeArrayValueSeparator(JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.mo935a(',');
        this._arrayIndenter.writeIndentation(jsonGenerator, this._nesting);
    }

    public void writeEndArray(JsonGenerator jsonGenerator, int i) throws IOException {
        if (!this._arrayIndenter.isInline()) {
            this._nesting--;
        }
        if (i > 0) {
            this._arrayIndenter.writeIndentation(jsonGenerator, this._nesting);
        } else {
            jsonGenerator.mo935a(' ');
        }
        jsonGenerator.mo935a(']');
    }
}
