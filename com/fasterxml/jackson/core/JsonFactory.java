package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.format.MatchStrength;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.InputDecorator;
import com.fasterxml.jackson.core.io.OutputDecorator;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fossil.aex;
import com.fossil.afa;
import com.fossil.afc;
import com.fossil.afm;
import com.fossil.afo;
import com.fossil.afv;
import com.fossil.afw;
import com.fossil.agb;
import com.fossil.agc;
import com.fossil.agd;
import com.fossil.agf;
import com.fossil.agg;
import com.fossil.agh;
import com.fossil.agi;
import com.fossil.agm;
import java.io.CharArrayReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringReader;
import java.io.Writer;
import java.lang.ref.SoftReference;
import java.net.URL;

public class JsonFactory implements Serializable {
    protected static final int DEFAULT_FACTORY_FEATURE_FLAGS = Feature.collectDefaults();
    protected static final int DEFAULT_GENERATOR_FEATURE_FLAGS = com.fasterxml.jackson.core.JsonGenerator.Feature.collectDefaults();
    protected static final int DEFAULT_PARSER_FEATURE_FLAGS = com.fasterxml.jackson.core.JsonParser.Feature.collectDefaults();
    public static final String FORMAT_NAME_JSON = "JSON";
    protected static final ThreadLocal<SoftReference<agm>> _recyclerRef = new ThreadLocal();
    private static final afc aLu = DefaultPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
    private static final long serialVersionUID = 1;
    protected final transient agg _byteSymbolCanonicalizer;
    protected CharacterEscapes _characterEscapes;
    protected int _factoryFeatures;
    protected int _generatorFeatures;
    protected InputDecorator _inputDecorator;
    protected afa _objectCodec;
    protected OutputDecorator _outputDecorator;
    protected int _parserFeatures;
    @Deprecated
    protected final transient agh _rootByteSymbols;
    protected final transient agi _rootCharSymbols;
    protected afc _rootValueSeparator;

    public enum Feature {
        INTERN_FIELD_NAMES(true),
        CANONICALIZE_FIELD_NAMES(true),
        FAIL_ON_SYMBOL_HASH_OVERFLOW(true),
        USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING(true);
        
        private final boolean _defaultState;

        public static int collectDefaults() {
            int i = 0;
            for (Feature feature : values()) {
                if (feature.enabledByDefault()) {
                    i |= feature.getMask();
                }
            }
            return i;
        }

        private Feature(boolean z) {
            this._defaultState = z;
        }

        public boolean enabledByDefault() {
            return this._defaultState;
        }

        public boolean enabledIn(int i) {
            return (getMask() & i) != 0;
        }

        public int getMask() {
            return 1 << ordinal();
        }
    }

    public JsonFactory() {
        this(null);
    }

    public JsonFactory(afa com_fossil_afa) {
        this._rootCharSymbols = agi.CN();
        this._byteSymbolCanonicalizer = agg.CB();
        this._rootByteSymbols = agh.CM();
        this._factoryFeatures = DEFAULT_FACTORY_FEATURE_FLAGS;
        this._parserFeatures = DEFAULT_PARSER_FEATURE_FLAGS;
        this._generatorFeatures = DEFAULT_GENERATOR_FEATURE_FLAGS;
        this._rootValueSeparator = aLu;
        this._objectCodec = com_fossil_afa;
    }

    protected JsonFactory(JsonFactory jsonFactory, afa com_fossil_afa) {
        this._rootCharSymbols = agi.CN();
        this._byteSymbolCanonicalizer = agg.CB();
        this._rootByteSymbols = agh.CM();
        this._factoryFeatures = DEFAULT_FACTORY_FEATURE_FLAGS;
        this._parserFeatures = DEFAULT_PARSER_FEATURE_FLAGS;
        this._generatorFeatures = DEFAULT_GENERATOR_FEATURE_FLAGS;
        this._rootValueSeparator = aLu;
        this._objectCodec = null;
        this._factoryFeatures = jsonFactory._factoryFeatures;
        this._parserFeatures = jsonFactory._parserFeatures;
        this._generatorFeatures = jsonFactory._generatorFeatures;
        this._characterEscapes = jsonFactory._characterEscapes;
        this._inputDecorator = jsonFactory._inputDecorator;
        this._outputDecorator = jsonFactory._outputDecorator;
        this._rootValueSeparator = jsonFactory._rootValueSeparator;
    }

    public JsonFactory copy() {
        _checkInvalidCopy(JsonFactory.class);
        return new JsonFactory(this, null);
    }

    protected void _checkInvalidCopy(Class<?> cls) {
        if (getClass() != cls) {
            throw new IllegalStateException("Failed copy(): " + getClass().getName() + " (version: " + version() + ") does not override copy(); it has to");
        }
    }

    protected Object readResolve() {
        return new JsonFactory(this, this._objectCodec);
    }

    public boolean requiresPropertyOrdering() {
        return false;
    }

    public boolean canHandleBinaryNatively() {
        return false;
    }

    public boolean canUseCharArrays() {
        return true;
    }

    public Class<? extends Object> getFormatReadFeatureType() {
        return null;
    }

    public Class<? extends Object> getFormatWriteFeatureType() {
        return null;
    }

    public boolean canUseSchema(aex com_fossil_aex) {
        String formatName = getFormatName();
        return formatName != null && formatName.equals(com_fossil_aex.zA());
    }

    public String getFormatName() {
        if (getClass() == JsonFactory.class) {
            return FORMAT_NAME_JSON;
        }
        return null;
    }

    public MatchStrength hasFormat(afm com_fossil_afm) throws IOException {
        if (getClass() == JsonFactory.class) {
            return hasJSONFormat(com_fossil_afm);
        }
        return null;
    }

    public boolean requiresCustomCodec() {
        return false;
    }

    protected MatchStrength hasJSONFormat(afm com_fossil_afm) throws IOException {
        return afw.hasJSONFormat(com_fossil_afm);
    }

    public Version version() {
        return agb.aOo;
    }

    public final JsonFactory configure(Feature feature, boolean z) {
        return z ? enable(feature) : disable(feature);
    }

    public JsonFactory enable(Feature feature) {
        this._factoryFeatures |= feature.getMask();
        return this;
    }

    public JsonFactory disable(Feature feature) {
        this._factoryFeatures &= feature.getMask() ^ -1;
        return this;
    }

    public final boolean isEnabled(Feature feature) {
        return (this._factoryFeatures & feature.getMask()) != 0;
    }

    public final JsonFactory configure(com.fasterxml.jackson.core.JsonParser.Feature feature, boolean z) {
        return z ? enable(feature) : disable(feature);
    }

    public JsonFactory enable(com.fasterxml.jackson.core.JsonParser.Feature feature) {
        this._parserFeatures |= feature.getMask();
        return this;
    }

    public JsonFactory disable(com.fasterxml.jackson.core.JsonParser.Feature feature) {
        this._parserFeatures &= feature.getMask() ^ -1;
        return this;
    }

    public final boolean isEnabled(com.fasterxml.jackson.core.JsonParser.Feature feature) {
        return (this._parserFeatures & feature.getMask()) != 0;
    }

    public InputDecorator getInputDecorator() {
        return this._inputDecorator;
    }

    public JsonFactory setInputDecorator(InputDecorator inputDecorator) {
        this._inputDecorator = inputDecorator;
        return this;
    }

    public final JsonFactory configure(com.fasterxml.jackson.core.JsonGenerator.Feature feature, boolean z) {
        return z ? enable(feature) : disable(feature);
    }

    public JsonFactory enable(com.fasterxml.jackson.core.JsonGenerator.Feature feature) {
        this._generatorFeatures |= feature.getMask();
        return this;
    }

    public JsonFactory disable(com.fasterxml.jackson.core.JsonGenerator.Feature feature) {
        this._generatorFeatures &= feature.getMask() ^ -1;
        return this;
    }

    public final boolean isEnabled(com.fasterxml.jackson.core.JsonGenerator.Feature feature) {
        return (this._generatorFeatures & feature.getMask()) != 0;
    }

    public CharacterEscapes getCharacterEscapes() {
        return this._characterEscapes;
    }

    public JsonFactory setCharacterEscapes(CharacterEscapes characterEscapes) {
        this._characterEscapes = characterEscapes;
        return this;
    }

    public OutputDecorator getOutputDecorator() {
        return this._outputDecorator;
    }

    public JsonFactory setOutputDecorator(OutputDecorator outputDecorator) {
        this._outputDecorator = outputDecorator;
        return this;
    }

    public JsonFactory setRootValueSeparator(String str) {
        this._rootValueSeparator = str == null ? null : new SerializedString(str);
        return this;
    }

    public String getRootValueSeparator() {
        return this._rootValueSeparator == null ? null : this._rootValueSeparator.getValue();
    }

    public JsonFactory setCodec(afa com_fossil_afa) {
        this._objectCodec = com_fossil_afa;
        return this;
    }

    public afa getCodec() {
        return this._objectCodec;
    }

    public JsonParser createParser(File file) throws IOException, JsonParseException {
        afo _createContext = _createContext(file, true);
        return _createParser(_decorate(new FileInputStream(file), _createContext), _createContext);
    }

    public JsonParser createParser(URL url) throws IOException, JsonParseException {
        afo _createContext = _createContext(url, true);
        return _createParser(_decorate(_optimizedStreamFromURL(url), _createContext), _createContext);
    }

    public JsonParser createParser(InputStream inputStream) throws IOException, JsonParseException {
        afo _createContext = _createContext(inputStream, false);
        return _createParser(_decorate(inputStream, _createContext), _createContext);
    }

    public JsonParser createParser(Reader reader) throws IOException, JsonParseException {
        afo _createContext = _createContext(reader, false);
        return _createParser(_decorate(reader, _createContext), _createContext);
    }

    public JsonParser createParser(byte[] bArr) throws IOException, JsonParseException {
        afo _createContext = _createContext(bArr, true);
        if (this._inputDecorator != null) {
            InputStream decorate = this._inputDecorator.decorate(_createContext, bArr, 0, bArr.length);
            if (decorate != null) {
                return _createParser(decorate, _createContext);
            }
        }
        return _createParser(bArr, 0, bArr.length, _createContext);
    }

    public JsonParser createParser(byte[] bArr, int i, int i2) throws IOException, JsonParseException {
        afo _createContext = _createContext(bArr, true);
        if (this._inputDecorator != null) {
            InputStream decorate = this._inputDecorator.decorate(_createContext, bArr, i, i2);
            if (decorate != null) {
                return _createParser(decorate, _createContext);
            }
        }
        return _createParser(bArr, i, i2, _createContext);
    }

    public JsonParser createParser(String str) throws IOException, JsonParseException {
        int length = str.length();
        if (this._inputDecorator != null || length > 32768 || !canUseCharArrays()) {
            return createParser(new StringReader(str));
        }
        afo _createContext = _createContext(str, true);
        char[] fy = _createContext.fy(length);
        str.getChars(0, length, fy, 0);
        return _createParser(fy, 0, length, _createContext, true);
    }

    public JsonParser createParser(char[] cArr) throws IOException {
        return createParser(cArr, 0, cArr.length);
    }

    public JsonParser createParser(char[] cArr, int i, int i2) throws IOException {
        if (this._inputDecorator != null) {
            return createParser(new CharArrayReader(cArr, i, i2));
        }
        return _createParser(cArr, i, i2, _createContext(cArr, true), false);
    }

    @Deprecated
    public JsonParser createJsonParser(File file) throws IOException, JsonParseException {
        return createParser(file);
    }

    @Deprecated
    public JsonParser createJsonParser(URL url) throws IOException, JsonParseException {
        return createParser(url);
    }

    @Deprecated
    public JsonParser createJsonParser(InputStream inputStream) throws IOException, JsonParseException {
        return createParser(inputStream);
    }

    @Deprecated
    public JsonParser createJsonParser(Reader reader) throws IOException, JsonParseException {
        return createParser(reader);
    }

    @Deprecated
    public JsonParser createJsonParser(byte[] bArr) throws IOException, JsonParseException {
        return createParser(bArr);
    }

    @Deprecated
    public JsonParser createJsonParser(byte[] bArr, int i, int i2) throws IOException, JsonParseException {
        return createParser(bArr, i, i2);
    }

    @Deprecated
    public JsonParser createJsonParser(String str) throws IOException, JsonParseException {
        return createParser(str);
    }

    public JsonGenerator createGenerator(OutputStream outputStream, JsonEncoding jsonEncoding) throws IOException {
        afo _createContext = _createContext(outputStream, false);
        _createContext.m3148a(jsonEncoding);
        if (jsonEncoding == JsonEncoding.UTF8) {
            return _createUTF8Generator(_decorate(outputStream, _createContext), _createContext);
        }
        return _createGenerator(_decorate(_createWriter(outputStream, jsonEncoding, _createContext), _createContext), _createContext);
    }

    public JsonGenerator createGenerator(OutputStream outputStream) throws IOException {
        return createGenerator(outputStream, JsonEncoding.UTF8);
    }

    public JsonGenerator createGenerator(Writer writer) throws IOException {
        afo _createContext = _createContext(writer, false);
        return _createGenerator(_decorate(writer, _createContext), _createContext);
    }

    public JsonGenerator createGenerator(File file, JsonEncoding jsonEncoding) throws IOException {
        OutputStream fileOutputStream = new FileOutputStream(file);
        afo _createContext = _createContext(fileOutputStream, true);
        _createContext.m3148a(jsonEncoding);
        if (jsonEncoding == JsonEncoding.UTF8) {
            return _createUTF8Generator(_decorate(fileOutputStream, _createContext), _createContext);
        }
        return _createGenerator(_decorate(_createWriter(fileOutputStream, jsonEncoding, _createContext), _createContext), _createContext);
    }

    @Deprecated
    public JsonGenerator createJsonGenerator(OutputStream outputStream, JsonEncoding jsonEncoding) throws IOException {
        return createGenerator(outputStream, jsonEncoding);
    }

    @Deprecated
    public JsonGenerator createJsonGenerator(Writer writer) throws IOException {
        return createGenerator(writer);
    }

    @Deprecated
    public JsonGenerator createJsonGenerator(OutputStream outputStream) throws IOException {
        return createGenerator(outputStream, JsonEncoding.UTF8);
    }

    @Deprecated
    public JsonGenerator createJsonGenerator(File file, JsonEncoding jsonEncoding) throws IOException {
        return createGenerator(file, jsonEncoding);
    }

    protected JsonParser _createParser(InputStream inputStream, afo com_fossil_afo) throws IOException {
        return new afw(com_fossil_afo, inputStream).m3179a(this._parserFeatures, this._objectCodec, this._byteSymbolCanonicalizer, this._rootCharSymbols, this._factoryFeatures);
    }

    protected JsonParser _createParser(Reader reader, afo com_fossil_afo) throws IOException {
        return new agc(com_fossil_afo, this._parserFeatures, reader, this._objectCodec, this._rootCharSymbols.gw(this._factoryFeatures));
    }

    protected JsonParser _createParser(char[] cArr, int i, int i2, afo com_fossil_afo, boolean z) throws IOException {
        return new agc(com_fossil_afo, this._parserFeatures, null, this._objectCodec, this._rootCharSymbols.gw(this._factoryFeatures), cArr, i, i + i2, z);
    }

    protected JsonParser _createParser(byte[] bArr, int i, int i2, afo com_fossil_afo) throws IOException {
        return new afw(com_fossil_afo, bArr, i, i2).m3179a(this._parserFeatures, this._objectCodec, this._byteSymbolCanonicalizer, this._rootCharSymbols, this._factoryFeatures);
    }

    protected JsonGenerator _createGenerator(Writer writer, afo com_fossil_afo) throws IOException {
        JsonGenerator com_fossil_agf = new agf(com_fossil_afo, this._generatorFeatures, this._objectCodec, writer);
        if (this._characterEscapes != null) {
            com_fossil_agf.mo921a(this._characterEscapes);
        }
        afc com_fossil_afc = this._rootValueSeparator;
        if (com_fossil_afc != aLu) {
            com_fossil_agf.mo922a(com_fossil_afc);
        }
        return com_fossil_agf;
    }

    protected JsonGenerator _createUTF8Generator(OutputStream outputStream, afo com_fossil_afo) throws IOException {
        JsonGenerator com_fossil_agd = new agd(com_fossil_afo, this._generatorFeatures, this._objectCodec, outputStream);
        if (this._characterEscapes != null) {
            com_fossil_agd.mo921a(this._characterEscapes);
        }
        afc com_fossil_afc = this._rootValueSeparator;
        if (com_fossil_afc != aLu) {
            com_fossil_agd.mo922a(com_fossil_afc);
        }
        return com_fossil_agd;
    }

    protected Writer _createWriter(OutputStream outputStream, JsonEncoding jsonEncoding, afo com_fossil_afo) throws IOException {
        if (jsonEncoding == JsonEncoding.UTF8) {
            return new afv(com_fossil_afo, outputStream);
        }
        return new OutputStreamWriter(outputStream, jsonEncoding.getJavaName());
    }

    protected final InputStream _decorate(InputStream inputStream, afo com_fossil_afo) throws IOException {
        if (this._inputDecorator == null) {
            return inputStream;
        }
        InputStream decorate = this._inputDecorator.decorate(com_fossil_afo, inputStream);
        if (decorate != null) {
            return decorate;
        }
        return inputStream;
    }

    protected final Reader _decorate(Reader reader, afo com_fossil_afo) throws IOException {
        if (this._inputDecorator == null) {
            return reader;
        }
        Reader decorate = this._inputDecorator.decorate(com_fossil_afo, reader);
        if (decorate != null) {
            return decorate;
        }
        return reader;
    }

    protected final OutputStream _decorate(OutputStream outputStream, afo com_fossil_afo) throws IOException {
        if (this._outputDecorator == null) {
            return outputStream;
        }
        OutputStream decorate = this._outputDecorator.decorate(com_fossil_afo, outputStream);
        if (decorate != null) {
            return decorate;
        }
        return outputStream;
    }

    protected final Writer _decorate(Writer writer, afo com_fossil_afo) throws IOException {
        if (this._outputDecorator == null) {
            return writer;
        }
        Writer decorate = this._outputDecorator.decorate(com_fossil_afo, writer);
        if (decorate != null) {
            return decorate;
        }
        return writer;
    }

    public agm _getBufferRecycler() {
        if (!isEnabled(Feature.USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING)) {
            return new agm();
        }
        SoftReference softReference = (SoftReference) _recyclerRef.get();
        agm com_fossil_agm = softReference == null ? null : (agm) softReference.get();
        if (com_fossil_agm != null) {
            return com_fossil_agm;
        }
        com_fossil_agm = new agm();
        _recyclerRef.set(new SoftReference(com_fossil_agm));
        return com_fossil_agm;
    }

    protected afo _createContext(Object obj, boolean z) {
        return new afo(_getBufferRecycler(), obj, z);
    }

    protected InputStream _optimizedStreamFromURL(URL url) throws IOException {
        if ("file".equals(url.getProtocol())) {
            String host = url.getHost();
            if ((host == null || host.length() == 0) && url.getPath().indexOf(37) < 0) {
                return new FileInputStream(url.getPath());
            }
        }
        return url.openStream();
    }
}
