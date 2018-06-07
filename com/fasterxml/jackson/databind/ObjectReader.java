package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.cfg.ContextAttributes;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fossil.aex;
import com.fossil.aey;
import com.fossil.afa;
import com.fossil.afe;
import com.fossil.afi;
import com.fossil.afj;
import com.fossil.afk;
import com.fossil.agk;
import com.fossil.agl;
import com.fossil.agx;
import com.fossil.agy;
import com.fossil.agz;
import com.fossil.ahd;
import com.fossil.ahs;
import com.fossil.ahx;
import com.fossil.ahx.C1644b;
import com.fossil.ahy;
import com.fossil.akt;
import com.fossil.akz;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

public class ObjectReader extends afa implements Serializable {
    private static final JavaType aQp = SimpleType.constructUnsafe(agz.class);
    private static final long serialVersionUID = 1;
    protected final DeserializationConfig _config;
    protected final DefaultDeserializationContext _context;
    protected final ahx _dataFormatReaders;
    private final afk _filter;
    protected final agx _injectableValues;
    protected final JsonFactory _parserFactory;
    protected final agy<Object> _rootDeserializer;
    protected final ConcurrentHashMap<JavaType, agy<Object>> _rootDeserializers;
    protected final aex _schema;
    protected final boolean _unwrapRoot;
    protected final Object _valueToUpdate;
    protected final JavaType _valueType;

    protected ObjectReader(ObjectMapper objectMapper, DeserializationConfig deserializationConfig) {
        this(objectMapper, deserializationConfig, null, null, null, null);
    }

    protected ObjectReader(ObjectMapper objectMapper, DeserializationConfig deserializationConfig, JavaType javaType, Object obj, aex com_fossil_aex, agx com_fossil_agx) {
        this._config = deserializationConfig;
        this._context = objectMapper._deserializationContext;
        this._rootDeserializers = objectMapper._rootDeserializers;
        this._parserFactory = objectMapper._jsonFactory;
        this._valueType = javaType;
        this._valueToUpdate = obj;
        if (obj == null || !javaType.isArrayType()) {
            this._schema = com_fossil_aex;
            this._injectableValues = com_fossil_agx;
            this._unwrapRoot = deserializationConfig.useRootWrapping();
            this._rootDeserializer = _prefetchRootDeserializer(javaType);
            this._dataFormatReaders = null;
            this._filter = null;
            return;
        }
        throw new IllegalArgumentException("Can not update an array value");
    }

    protected ObjectReader(ObjectReader objectReader, DeserializationConfig deserializationConfig, JavaType javaType, agy<Object> com_fossil_agy_java_lang_Object, Object obj, aex com_fossil_aex, agx com_fossil_agx, ahx com_fossil_ahx) {
        this._config = deserializationConfig;
        this._context = objectReader._context;
        this._rootDeserializers = objectReader._rootDeserializers;
        this._parserFactory = objectReader._parserFactory;
        this._valueType = javaType;
        this._rootDeserializer = com_fossil_agy_java_lang_Object;
        this._valueToUpdate = obj;
        if (obj == null || !javaType.isArrayType()) {
            this._schema = com_fossil_aex;
            this._injectableValues = com_fossil_agx;
            this._unwrapRoot = deserializationConfig.useRootWrapping();
            this._dataFormatReaders = com_fossil_ahx;
            this._filter = objectReader._filter;
            return;
        }
        throw new IllegalArgumentException("Can not update an array value");
    }

    protected ObjectReader(ObjectReader objectReader, DeserializationConfig deserializationConfig) {
        this._config = deserializationConfig;
        this._context = objectReader._context;
        this._rootDeserializers = objectReader._rootDeserializers;
        this._parserFactory = objectReader._parserFactory;
        this._valueType = objectReader._valueType;
        this._rootDeserializer = objectReader._rootDeserializer;
        this._valueToUpdate = objectReader._valueToUpdate;
        this._schema = objectReader._schema;
        this._injectableValues = objectReader._injectableValues;
        this._unwrapRoot = deserializationConfig.useRootWrapping();
        this._dataFormatReaders = objectReader._dataFormatReaders;
        this._filter = objectReader._filter;
    }

    protected ObjectReader(ObjectReader objectReader, JsonFactory jsonFactory) {
        this._config = objectReader._config.with(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, jsonFactory.requiresPropertyOrdering());
        this._context = objectReader._context;
        this._rootDeserializers = objectReader._rootDeserializers;
        this._parserFactory = jsonFactory;
        this._valueType = objectReader._valueType;
        this._rootDeserializer = objectReader._rootDeserializer;
        this._valueToUpdate = objectReader._valueToUpdate;
        this._schema = objectReader._schema;
        this._injectableValues = objectReader._injectableValues;
        this._unwrapRoot = objectReader._unwrapRoot;
        this._dataFormatReaders = objectReader._dataFormatReaders;
        this._filter = objectReader._filter;
    }

    protected ObjectReader(ObjectReader objectReader, afk com_fossil_afk) {
        this._config = objectReader._config;
        this._context = objectReader._context;
        this._rootDeserializers = objectReader._rootDeserializers;
        this._parserFactory = objectReader._parserFactory;
        this._valueType = objectReader._valueType;
        this._rootDeserializer = objectReader._rootDeserializer;
        this._valueToUpdate = objectReader._valueToUpdate;
        this._schema = objectReader._schema;
        this._injectableValues = objectReader._injectableValues;
        this._unwrapRoot = objectReader._unwrapRoot;
        this._dataFormatReaders = objectReader._dataFormatReaders;
        this._filter = com_fossil_afk;
    }

    public Version version() {
        return ahs.aOo;
    }

    protected ObjectReader _new(ObjectReader objectReader, JsonFactory jsonFactory) {
        return new ObjectReader(objectReader, jsonFactory);
    }

    protected ObjectReader _new(ObjectReader objectReader, DeserializationConfig deserializationConfig) {
        return new ObjectReader(objectReader, deserializationConfig);
    }

    protected ObjectReader _new(ObjectReader objectReader, DeserializationConfig deserializationConfig, JavaType javaType, agy<Object> com_fossil_agy_java_lang_Object, Object obj, aex com_fossil_aex, agx com_fossil_agx, ahx com_fossil_ahx) {
        return new ObjectReader(objectReader, deserializationConfig, javaType, com_fossil_agy_java_lang_Object, obj, com_fossil_aex, com_fossil_agx, com_fossil_ahx);
    }

    protected <T> ahd<T> _newIterator(JsonParser jsonParser, DeserializationContext deserializationContext, agy<?> com_fossil_agy_, boolean z) {
        return new ahd(this._valueType, jsonParser, deserializationContext, com_fossil_agy_, z, this._valueToUpdate);
    }

    protected JsonToken _initForReading(JsonParser jsonParser) throws IOException {
        if (this._schema != null) {
            jsonParser.mo905a(this._schema);
        }
        this._config.initialize(jsonParser);
        JsonToken zU = jsonParser.zU();
        if (zU == null) {
            zU = jsonParser.zP();
            if (zU == null) {
                throw JsonMappingException.from(jsonParser, "No content to map due to end-of-input");
            }
        }
        return zU;
    }

    protected void _initForMultiRead(JsonParser jsonParser) throws IOException {
        if (this._schema != null) {
            jsonParser.mo905a(this._schema);
        }
        this._config.initialize(jsonParser);
    }

    public ObjectReader with(DeserializationFeature deserializationFeature) {
        return _with(this._config.with(deserializationFeature));
    }

    public ObjectReader with(DeserializationFeature deserializationFeature, DeserializationFeature... deserializationFeatureArr) {
        return _with(this._config.with(deserializationFeature, deserializationFeatureArr));
    }

    public ObjectReader withFeatures(DeserializationFeature... deserializationFeatureArr) {
        return _with(this._config.withFeatures(deserializationFeatureArr));
    }

    public ObjectReader without(DeserializationFeature deserializationFeature) {
        return _with(this._config.without(deserializationFeature));
    }

    public ObjectReader without(DeserializationFeature deserializationFeature, DeserializationFeature... deserializationFeatureArr) {
        return _with(this._config.without(deserializationFeature, deserializationFeatureArr));
    }

    public ObjectReader withoutFeatures(DeserializationFeature... deserializationFeatureArr) {
        return _with(this._config.withoutFeatures(deserializationFeatureArr));
    }

    public ObjectReader with(Feature feature) {
        return _with(this._config.with(feature));
    }

    public ObjectReader withFeatures(Feature... featureArr) {
        return _with(this._config.withFeatures(featureArr));
    }

    public ObjectReader without(Feature feature) {
        return _with(this._config.without(feature));
    }

    public ObjectReader withoutFeatures(Feature... featureArr) {
        return _with(this._config.withoutFeatures(featureArr));
    }

    public ObjectReader with(DeserializationConfig deserializationConfig) {
        return _with(deserializationConfig);
    }

    public ObjectReader with(agx com_fossil_agx) {
        if (this._injectableValues == com_fossil_agx) {
            return this;
        }
        return _new(this, this._config, this._valueType, this._rootDeserializer, this._valueToUpdate, this._schema, com_fossil_agx, this._dataFormatReaders);
    }

    public ObjectReader with(JsonNodeFactory jsonNodeFactory) {
        return _with(this._config.with(jsonNodeFactory));
    }

    public ObjectReader with(JsonFactory jsonFactory) {
        if (jsonFactory != this._parserFactory) {
            this = _new(this, jsonFactory);
            if (jsonFactory.getCodec() == null) {
                jsonFactory.setCodec(this);
            }
        }
        return this;
    }

    public ObjectReader withRootName(String str) {
        return _with((DeserializationConfig) this._config.withRootName(str));
    }

    public ObjectReader withRootName(PropertyName propertyName) {
        return _with(this._config.withRootName(propertyName));
    }

    public ObjectReader withoutRootName() {
        return _with(this._config.withRootName(PropertyName.NO_NAME));
    }

    public ObjectReader with(aex com_fossil_aex) {
        if (this._schema == com_fossil_aex) {
            return this;
        }
        _verifySchemaType(com_fossil_aex);
        return _new(this, this._config, this._valueType, this._rootDeserializer, this._valueToUpdate, com_fossil_aex, this._injectableValues, this._dataFormatReaders);
    }

    public ObjectReader forType(JavaType javaType) {
        if (javaType != null && javaType.equals(this._valueType)) {
            return this;
        }
        agy _prefetchRootDeserializer = _prefetchRootDeserializer(javaType);
        ahx com_fossil_ahx = this._dataFormatReaders;
        if (com_fossil_ahx != null) {
            com_fossil_ahx = com_fossil_ahx.m3375b(javaType);
        }
        return _new(this, this._config, javaType, _prefetchRootDeserializer, this._valueToUpdate, this._schema, this._injectableValues, com_fossil_ahx);
    }

    public ObjectReader forType(Class<?> cls) {
        return forType(this._config.constructType((Class) cls));
    }

    public ObjectReader forType(agl<?> com_fossil_agl_) {
        return forType(this._config.getTypeFactory().constructType(com_fossil_agl_.getType()));
    }

    @Deprecated
    public ObjectReader withType(JavaType javaType) {
        return forType(javaType);
    }

    @Deprecated
    public ObjectReader withType(Class<?> cls) {
        return forType(this._config.constructType((Class) cls));
    }

    @Deprecated
    public ObjectReader withType(Type type) {
        return forType(this._config.getTypeFactory().constructType(type));
    }

    @Deprecated
    public ObjectReader withType(agl<?> com_fossil_agl_) {
        return forType(this._config.getTypeFactory().constructType(com_fossil_agl_.getType()));
    }

    public ObjectReader withValueToUpdate(Object obj) {
        if (obj == this._valueToUpdate) {
            return this;
        }
        if (obj == null) {
            throw new IllegalArgumentException("cat not update null value");
        }
        JavaType constructType;
        if (this._valueType == null) {
            constructType = this._config.constructType(obj.getClass());
        } else {
            constructType = this._valueType;
        }
        return _new(this, this._config, constructType, this._rootDeserializer, obj, this._schema, this._injectableValues, this._dataFormatReaders);
    }

    public ObjectReader withView(Class<?> cls) {
        return _with(this._config.withView((Class) cls));
    }

    public ObjectReader with(Locale locale) {
        return _with(this._config.with(locale));
    }

    public ObjectReader with(TimeZone timeZone) {
        return _with(this._config.with(timeZone));
    }

    public ObjectReader withHandler(ahy com_fossil_ahy) {
        return _with(this._config.withHandler(com_fossil_ahy));
    }

    public ObjectReader with(Base64Variant base64Variant) {
        return _with(this._config.with(base64Variant));
    }

    public ObjectReader withFormatDetection(ObjectReader... objectReaderArr) {
        return withFormatDetection(new ahx(objectReaderArr));
    }

    public ObjectReader withFormatDetection(ahx com_fossil_ahx) {
        return _new(this, this._config, this._valueType, this._rootDeserializer, this._valueToUpdate, this._schema, this._injectableValues, com_fossil_ahx);
    }

    public ObjectReader with(ContextAttributes contextAttributes) {
        return _with(this._config.with(contextAttributes));
    }

    public ObjectReader withAttributes(Map<Object, Object> map) {
        return _with((DeserializationConfig) this._config.withAttributes(map));
    }

    public ObjectReader withAttribute(Object obj, Object obj2) {
        return _with((DeserializationConfig) this._config.withAttribute(obj, obj2));
    }

    public ObjectReader withoutAttribute(Object obj) {
        return _with((DeserializationConfig) this._config.withoutAttribute(obj));
    }

    protected ObjectReader _with(DeserializationConfig deserializationConfig) {
        if (deserializationConfig == this._config) {
            return this;
        }
        ObjectReader _new = _new(this, deserializationConfig);
        if (this._dataFormatReaders != null) {
            _new = _new.withFormatDetection(this._dataFormatReaders.m3374a(deserializationConfig));
        }
        return _new;
    }

    public boolean isEnabled(DeserializationFeature deserializationFeature) {
        return this._config.isEnabled(deserializationFeature);
    }

    public boolean isEnabled(MapperFeature mapperFeature) {
        return this._config.isEnabled(mapperFeature);
    }

    public boolean isEnabled(Feature feature) {
        return this._parserFactory.isEnabled(feature);
    }

    public DeserializationConfig getConfig() {
        return this._config;
    }

    public JsonFactory getFactory() {
        return this._parserFactory;
    }

    public TypeFactory getTypeFactory() {
        return this._config.getTypeFactory();
    }

    public ContextAttributes getAttributes() {
        return this._config.getAttributes();
    }

    public agx getInjectableValues() {
        return this._injectableValues;
    }

    public <T> T readValue(JsonParser jsonParser) throws IOException, JsonProcessingException {
        return _bind(jsonParser, this._valueToUpdate);
    }

    public <T> T readValue(JsonParser jsonParser, Class<T> cls) throws IOException, JsonProcessingException {
        return forType((Class) cls).readValue(jsonParser);
    }

    public <T> T readValue(JsonParser jsonParser, agl<?> com_fossil_agl_) throws IOException, JsonProcessingException {
        return forType((agl) com_fossil_agl_).readValue(jsonParser);
    }

    public <T> T readValue(JsonParser jsonParser, agk com_fossil_agk) throws IOException, JsonProcessingException {
        return forType((JavaType) com_fossil_agk).readValue(jsonParser);
    }

    public <T> T readValue(JsonParser jsonParser, JavaType javaType) throws IOException, JsonProcessingException {
        return forType(javaType).readValue(jsonParser);
    }

    public <T> Iterator<T> readValues(JsonParser jsonParser, Class<T> cls) throws IOException, JsonProcessingException {
        return forType((Class) cls).readValues(jsonParser);
    }

    public <T> Iterator<T> readValues(JsonParser jsonParser, agl<?> com_fossil_agl_) throws IOException, JsonProcessingException {
        return forType((agl) com_fossil_agl_).readValues(jsonParser);
    }

    public <T> Iterator<T> readValues(JsonParser jsonParser, agk com_fossil_agk) throws IOException, JsonProcessingException {
        return readValues(jsonParser, (JavaType) com_fossil_agk);
    }

    public <T> Iterator<T> readValues(JsonParser jsonParser, JavaType javaType) throws IOException, JsonProcessingException {
        return forType(javaType).readValues(jsonParser);
    }

    public agz createArrayNode() {
        return this._config.getNodeFactory().arrayNode();
    }

    public agz createObjectNode() {
        return this._config.getNodeFactory().objectNode();
    }

    public JsonParser treeAsTokens(afe com_fossil_afe) {
        return new akz((agz) com_fossil_afe, this);
    }

    public <T extends afe> T readTree(JsonParser jsonParser) throws IOException, JsonProcessingException {
        return _bindAsTree(jsonParser);
    }

    public void writeTree(JsonGenerator jsonGenerator, afe com_fossil_afe) {
        throw new UnsupportedOperationException();
    }

    public <T> T readValue(InputStream inputStream) throws IOException, JsonProcessingException {
        if (this._dataFormatReaders != null) {
            return _detectBindAndClose(this._dataFormatReaders.m3377i(inputStream), false);
        }
        return _bindAndClose(_considerFilter(this._parserFactory.createParser(inputStream)));
    }

    public <T> T readValue(Reader reader) throws IOException, JsonProcessingException {
        if (this._dataFormatReaders != null) {
            _reportUndetectableSource(reader);
        }
        return _bindAndClose(_considerFilter(this._parserFactory.createParser(reader)));
    }

    public <T> T readValue(String str) throws IOException, JsonProcessingException {
        if (this._dataFormatReaders != null) {
            _reportUndetectableSource(str);
        }
        return _bindAndClose(_considerFilter(this._parserFactory.createParser(str)));
    }

    public <T> T readValue(byte[] bArr) throws IOException, JsonProcessingException {
        if (this._dataFormatReaders != null) {
            return _detectBindAndClose(bArr, 0, bArr.length);
        }
        return _bindAndClose(_considerFilter(this._parserFactory.createParser(bArr)));
    }

    public <T> T readValue(byte[] bArr, int i, int i2) throws IOException, JsonProcessingException {
        if (this._dataFormatReaders != null) {
            return _detectBindAndClose(bArr, i, i2);
        }
        return _bindAndClose(_considerFilter(this._parserFactory.createParser(bArr, i, i2)));
    }

    public <T> T readValue(File file) throws IOException, JsonProcessingException {
        if (this._dataFormatReaders != null) {
            return _detectBindAndClose(this._dataFormatReaders.m3377i(_inputStream(file)), true);
        }
        return _bindAndClose(_considerFilter(this._parserFactory.createParser(file)));
    }

    public <T> T readValue(URL url) throws IOException, JsonProcessingException {
        if (this._dataFormatReaders != null) {
            return _detectBindAndClose(this._dataFormatReaders.m3377i(_inputStream(url)), true);
        }
        return _bindAndClose(_considerFilter(this._parserFactory.createParser(url)));
    }

    public <T> T readValue(agz com_fossil_agz) throws IOException, JsonProcessingException {
        if (this._dataFormatReaders != null) {
            _reportUndetectableSource(com_fossil_agz);
        }
        return _bindAndClose(_considerFilter(treeAsTokens(com_fossil_agz)));
    }

    public agz readTree(InputStream inputStream) throws IOException, JsonProcessingException {
        if (this._dataFormatReaders != null) {
            return _detectBindAndCloseAsTree(inputStream);
        }
        return _bindAndCloseAsTree(_considerFilter(this._parserFactory.createParser(inputStream)));
    }

    public agz readTree(Reader reader) throws IOException, JsonProcessingException {
        if (this._dataFormatReaders != null) {
            _reportUndetectableSource(reader);
        }
        return _bindAndCloseAsTree(_considerFilter(this._parserFactory.createParser(reader)));
    }

    public agz readTree(String str) throws IOException, JsonProcessingException {
        if (this._dataFormatReaders != null) {
            _reportUndetectableSource(str);
        }
        return _bindAndCloseAsTree(_considerFilter(this._parserFactory.createParser(str)));
    }

    public <T> ahd<T> readValues(JsonParser jsonParser) throws IOException, JsonProcessingException {
        DeserializationContext createDeserializationContext = createDeserializationContext(jsonParser);
        return _newIterator(jsonParser, createDeserializationContext, _findRootDeserializer(createDeserializationContext), false);
    }

    public <T> ahd<T> readValues(InputStream inputStream) throws IOException, JsonProcessingException {
        if (this._dataFormatReaders != null) {
            return _detectBindAndReadValues(this._dataFormatReaders.m3377i(inputStream), false);
        }
        return _bindAndReadValues(_considerFilter(this._parserFactory.createParser(inputStream)));
    }

    public <T> ahd<T> readValues(Reader reader) throws IOException, JsonProcessingException {
        if (this._dataFormatReaders != null) {
            _reportUndetectableSource(reader);
        }
        JsonParser _considerFilter = _considerFilter(this._parserFactory.createParser(reader));
        _initForMultiRead(_considerFilter);
        _considerFilter.zP();
        DeserializationContext createDeserializationContext = createDeserializationContext(_considerFilter);
        return _newIterator(_considerFilter, createDeserializationContext, _findRootDeserializer(createDeserializationContext), true);
    }

    public <T> ahd<T> readValues(String str) throws IOException, JsonProcessingException {
        if (this._dataFormatReaders != null) {
            _reportUndetectableSource(str);
        }
        JsonParser _considerFilter = _considerFilter(this._parserFactory.createParser(str));
        _initForMultiRead(_considerFilter);
        _considerFilter.zP();
        DeserializationContext createDeserializationContext = createDeserializationContext(_considerFilter);
        return _newIterator(_considerFilter, createDeserializationContext, _findRootDeserializer(createDeserializationContext), true);
    }

    public <T> ahd<T> readValues(byte[] bArr, int i, int i2) throws IOException, JsonProcessingException {
        if (this._dataFormatReaders != null) {
            return _detectBindAndReadValues(this._dataFormatReaders.m3376e(bArr, i, i2), false);
        }
        return _bindAndReadValues(_considerFilter(this._parserFactory.createParser(bArr)));
    }

    public final <T> ahd<T> readValues(byte[] bArr) throws IOException, JsonProcessingException {
        return readValues(bArr, 0, bArr.length);
    }

    public <T> ahd<T> readValues(File file) throws IOException, JsonProcessingException {
        if (this._dataFormatReaders != null) {
            return _detectBindAndReadValues(this._dataFormatReaders.m3377i(_inputStream(file)), false);
        }
        return _bindAndReadValues(_considerFilter(this._parserFactory.createParser(file)));
    }

    public <T> ahd<T> readValues(URL url) throws IOException, JsonProcessingException {
        if (this._dataFormatReaders != null) {
            return _detectBindAndReadValues(this._dataFormatReaders.m3377i(_inputStream(url)), true);
        }
        return _bindAndReadValues(_considerFilter(this._parserFactory.createParser(url)));
    }

    public <T> T treeToValue(afe com_fossil_afe, Class<T> cls) throws JsonProcessingException {
        try {
            return readValue(treeAsTokens(com_fossil_afe), (Class) cls);
        } catch (JsonProcessingException e) {
            throw e;
        } catch (Throwable e2) {
            throw new IllegalArgumentException(e2.getMessage(), e2);
        }
    }

    public void writeValue(JsonGenerator jsonGenerator, Object obj) throws IOException, JsonProcessingException {
        throw new UnsupportedOperationException("Not implemented for ObjectReader");
    }

    protected Object _bind(JsonParser jsonParser, Object obj) throws IOException {
        JsonToken _initForReading = _initForReading(jsonParser);
        DeserializationContext createDeserializationContext;
        if (_initForReading == JsonToken.VALUE_NULL) {
            if (obj == null) {
                createDeserializationContext = createDeserializationContext(jsonParser);
                obj = _findRootDeserializer(createDeserializationContext).getNullValue(createDeserializationContext);
            }
        } else if (!(_initForReading == JsonToken.END_ARRAY || _initForReading == JsonToken.END_OBJECT)) {
            createDeserializationContext = createDeserializationContext(jsonParser);
            agy _findRootDeserializer = _findRootDeserializer(createDeserializationContext);
            if (this._unwrapRoot) {
                obj = _unwrapAndDeserialize(jsonParser, createDeserializationContext, this._valueType, _findRootDeserializer);
            } else if (obj == null) {
                obj = _findRootDeserializer.deserialize(jsonParser, createDeserializationContext);
            } else {
                _findRootDeserializer.deserialize(jsonParser, createDeserializationContext, obj);
            }
        }
        jsonParser.Ac();
        return obj;
    }

    protected JsonParser _considerFilter(JsonParser jsonParser) {
        return (this._filter == null || afi.class.isInstance(jsonParser)) ? jsonParser : new afi(jsonParser, this._filter, false, false);
    }

    protected Object _bindAndClose(JsonParser jsonParser) throws IOException {
        try {
            Object nullValue;
            JsonToken _initForReading = _initForReading(jsonParser);
            DeserializationContext createDeserializationContext;
            if (_initForReading == JsonToken.VALUE_NULL) {
                if (this._valueToUpdate == null) {
                    createDeserializationContext = createDeserializationContext(jsonParser);
                    nullValue = _findRootDeserializer(createDeserializationContext).getNullValue(createDeserializationContext);
                } else {
                    nullValue = this._valueToUpdate;
                }
            } else if (_initForReading == JsonToken.END_ARRAY || _initForReading == JsonToken.END_OBJECT) {
                nullValue = this._valueToUpdate;
            } else {
                createDeserializationContext = createDeserializationContext(jsonParser);
                agy _findRootDeserializer = _findRootDeserializer(createDeserializationContext);
                if (this._unwrapRoot) {
                    nullValue = _unwrapAndDeserialize(jsonParser, createDeserializationContext, this._valueType, _findRootDeserializer);
                } else if (this._valueToUpdate == null) {
                    nullValue = _findRootDeserializer.deserialize(jsonParser, createDeserializationContext);
                } else {
                    _findRootDeserializer.deserialize(jsonParser, createDeserializationContext, this._valueToUpdate);
                    nullValue = this._valueToUpdate;
                }
            }
            return nullValue;
        } finally {
            try {
                jsonParser.close();
            } catch (IOException e) {
            }
        }
    }

    protected agz _bindAndCloseAsTree(JsonParser jsonParser) throws IOException {
        try {
            agz _bindAsTree = _bindAsTree(jsonParser);
            return _bindAsTree;
        } finally {
            try {
                jsonParser.close();
            } catch (IOException e) {
            }
        }
    }

    protected agz _bindAsTree(JsonParser jsonParser) throws IOException {
        agz com_fossil_agz;
        JsonToken _initForReading = _initForReading(jsonParser);
        if (_initForReading == JsonToken.VALUE_NULL || _initForReading == JsonToken.END_ARRAY || _initForReading == JsonToken.END_OBJECT) {
            com_fossil_agz = akt.aTX;
        } else {
            DeserializationContext createDeserializationContext = createDeserializationContext(jsonParser);
            agy _findTreeDeserializer = _findTreeDeserializer(createDeserializationContext);
            if (this._unwrapRoot) {
                com_fossil_agz = (agz) _unwrapAndDeserialize(jsonParser, createDeserializationContext, aQp, _findTreeDeserializer);
            } else {
                com_fossil_agz = (agz) _findTreeDeserializer.deserialize(jsonParser, createDeserializationContext);
            }
        }
        jsonParser.Ac();
        return com_fossil_agz;
    }

    protected <T> ahd<T> _bindAndReadValues(JsonParser jsonParser) throws IOException {
        _initForMultiRead(jsonParser);
        jsonParser.zP();
        DeserializationContext createDeserializationContext = createDeserializationContext(jsonParser);
        return _newIterator(jsonParser, createDeserializationContext, _findRootDeserializer(createDeserializationContext), true);
    }

    protected Object _unwrapAndDeserialize(JsonParser jsonParser, DeserializationContext deserializationContext, JavaType javaType, agy<Object> com_fossil_agy_java_lang_Object) throws IOException {
        String simpleName = this._config.findRootName(javaType).getSimpleName();
        if (jsonParser.zU() != JsonToken.START_OBJECT) {
            throw JsonMappingException.from(jsonParser, "Current token not START_OBJECT (needed to unwrap root name '" + simpleName + "'), but " + jsonParser.zU());
        } else if (jsonParser.zP() != JsonToken.FIELD_NAME) {
            throw JsonMappingException.from(jsonParser, "Current token not FIELD_NAME (to contain expected root name '" + simpleName + "'), but " + jsonParser.zU());
        } else {
            String zW = jsonParser.zW();
            if (simpleName.equals(zW)) {
                Object deserialize;
                jsonParser.zP();
                if (this._valueToUpdate == null) {
                    deserialize = com_fossil_agy_java_lang_Object.deserialize(jsonParser, deserializationContext);
                } else {
                    com_fossil_agy_java_lang_Object.deserialize(jsonParser, deserializationContext, this._valueToUpdate);
                    deserialize = this._valueToUpdate;
                }
                if (jsonParser.zP() == JsonToken.END_OBJECT) {
                    return deserialize;
                }
                throw JsonMappingException.from(jsonParser, "Current token not END_OBJECT (to match wrapper object with root name '" + simpleName + "'), but " + jsonParser.zU());
            }
            throw JsonMappingException.from(jsonParser, "Root name '" + zW + "' does not match expected ('" + simpleName + "') for type " + javaType);
        }
    }

    protected Object _detectBindAndClose(byte[] bArr, int i, int i2) throws IOException {
        C1644b e = this._dataFormatReaders.m3376e(bArr, i, i2);
        if (!e.Eu()) {
            _reportUnkownFormat(this._dataFormatReaders, e);
        }
        return e.Ev()._bindAndClose(e.Ew());
    }

    protected Object _detectBindAndClose(C1644b c1644b, boolean z) throws IOException {
        if (!c1644b.Eu()) {
            _reportUnkownFormat(this._dataFormatReaders, c1644b);
        }
        JsonParser Ew = c1644b.Ew();
        if (z) {
            Ew.mo887a(Feature.AUTO_CLOSE_SOURCE);
        }
        return c1644b.Ev()._bindAndClose(Ew);
    }

    protected <T> ahd<T> _detectBindAndReadValues(C1644b c1644b, boolean z) throws IOException, JsonProcessingException {
        if (!c1644b.Eu()) {
            _reportUnkownFormat(this._dataFormatReaders, c1644b);
        }
        JsonParser Ew = c1644b.Ew();
        if (z) {
            Ew.mo887a(Feature.AUTO_CLOSE_SOURCE);
        }
        return c1644b.Ev()._bindAndReadValues(Ew);
    }

    protected agz _detectBindAndCloseAsTree(InputStream inputStream) throws IOException {
        C1644b i = this._dataFormatReaders.m3377i(inputStream);
        if (!i.Eu()) {
            _reportUnkownFormat(this._dataFormatReaders, i);
        }
        JsonParser Ew = i.Ew();
        Ew.mo887a(Feature.AUTO_CLOSE_SOURCE);
        return i.Ev()._bindAndCloseAsTree(Ew);
    }

    protected void _reportUnkownFormat(ahx com_fossil_ahx, C1644b c1644b) throws JsonProcessingException {
        throw new JsonParseException("Can not detect format from input, does not look like any of detectable formats " + com_fossil_ahx.toString(), JsonLocation.NA);
    }

    protected void _verifySchemaType(aex com_fossil_aex) {
        if (com_fossil_aex != null && !this._parserFactory.canUseSchema(com_fossil_aex)) {
            throw new IllegalArgumentException("Can not use FormatSchema of type " + com_fossil_aex.getClass().getName() + " for format " + this._parserFactory.getFormatName());
        }
    }

    protected DefaultDeserializationContext createDeserializationContext(JsonParser jsonParser) {
        return this._context.createInstance(this._config, jsonParser, this._injectableValues);
    }

    protected void _reportUndetectableSource(Object obj) throws JsonProcessingException {
        throw new JsonParseException("Can not use source of type " + obj.getClass().getName() + " with format auto-detection: must be byte- not char-based", JsonLocation.NA);
    }

    protected InputStream _inputStream(URL url) throws IOException {
        return url.openStream();
    }

    protected InputStream _inputStream(File file) throws IOException {
        return new FileInputStream(file);
    }

    protected agy<Object> _findRootDeserializer(DeserializationContext deserializationContext) throws JsonMappingException {
        if (this._rootDeserializer != null) {
            return this._rootDeserializer;
        }
        JavaType javaType = this._valueType;
        if (javaType == null) {
            throw new JsonMappingException("No value type configured for ObjectReader");
        }
        agy<Object> com_fossil_agy_java_lang_Object = (agy) this._rootDeserializers.get(javaType);
        if (com_fossil_agy_java_lang_Object != null) {
            return com_fossil_agy_java_lang_Object;
        }
        com_fossil_agy_java_lang_Object = deserializationContext.findRootValueDeserializer(javaType);
        if (com_fossil_agy_java_lang_Object == null) {
            throw new JsonMappingException("Can not find a deserializer for type " + javaType);
        }
        this._rootDeserializers.put(javaType, com_fossil_agy_java_lang_Object);
        return com_fossil_agy_java_lang_Object;
    }

    protected agy<Object> _findTreeDeserializer(DeserializationContext deserializationContext) throws JsonMappingException {
        agy<Object> com_fossil_agy_java_lang_Object = (agy) this._rootDeserializers.get(aQp);
        if (com_fossil_agy_java_lang_Object == null) {
            com_fossil_agy_java_lang_Object = deserializationContext.findRootValueDeserializer(aQp);
            if (com_fossil_agy_java_lang_Object == null) {
                throw new JsonMappingException("Can not find a deserializer for type " + aQp);
            }
            this._rootDeserializers.put(aQp, com_fossil_agy_java_lang_Object);
        }
        return com_fossil_agy_java_lang_Object;
    }

    protected agy<Object> _prefetchRootDeserializer(JavaType javaType) {
        agy<Object> com_fossil_agy_java_lang_Object = null;
        if (javaType != null && this._config.isEnabled(DeserializationFeature.EAGER_DESERIALIZER_FETCH)) {
            com_fossil_agy_java_lang_Object = (agy) this._rootDeserializers.get(javaType);
            if (com_fossil_agy_java_lang_Object == null) {
                try {
                    com_fossil_agy_java_lang_Object = createDeserializationContext(null).findRootValueDeserializer(javaType);
                    if (com_fossil_agy_java_lang_Object != null) {
                        this._rootDeserializers.put(javaType, com_fossil_agy_java_lang_Object);
                    }
                } catch (JsonProcessingException e) {
                }
            }
        }
        return com_fossil_agy_java_lang_Object;
    }

    public ObjectReader at(String str) {
        return new ObjectReader(this, new afj(str));
    }

    public ObjectReader at(aey com_fossil_aey) {
        return new ObjectReader(this, new afj(com_fossil_aey));
    }
}
