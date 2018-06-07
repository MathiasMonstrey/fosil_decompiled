package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.fasterxml.jackson.databind.cfg.ContextAttributes;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fossil.aex;
import com.fossil.afb;
import com.fossil.afc;
import com.fossil.aft;
import com.fossil.agl;
import com.fossil.agn;
import com.fossil.ago;
import com.fossil.ahb;
import com.fossil.ahf;
import com.fossil.ahs;
import com.fossil.ajg;
import com.fossil.ajv;
import com.fossil.alh;
import com.fossil.aln;
import com.fossil.alv;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.Writer;
import java.text.DateFormat;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

public class ObjectWriter implements Serializable {
    protected static final afb NULL_PRETTY_PRINTER = new MinimalPrettyPrinter();
    private static final long serialVersionUID = 1;
    protected final SerializationConfig _config;
    protected final JsonFactory _generatorFactory;
    protected final GeneratorSettings _generatorSettings;
    protected final Prefetch _prefetch;
    protected final aln _serializerFactory;
    protected final DefaultSerializerProvider _serializerProvider;

    public static final class GeneratorSettings implements Serializable {
        public static final GeneratorSettings empty = new GeneratorSettings(null, null, null, null);
        private static final long serialVersionUID = 1;
        public final CharacterEscapes characterEscapes;
        public final afb prettyPrinter;
        public final afc rootValueSeparator;
        public final aex schema;

        public GeneratorSettings(afb com_fossil_afb, aex com_fossil_aex, CharacterEscapes characterEscapes, afc com_fossil_afc) {
            this.prettyPrinter = com_fossil_afb;
            this.schema = com_fossil_aex;
            this.characterEscapes = characterEscapes;
            this.rootValueSeparator = com_fossil_afc;
        }

        public GeneratorSettings with(afb com_fossil_afb) {
            if (com_fossil_afb == null) {
                com_fossil_afb = ObjectWriter.NULL_PRETTY_PRINTER;
            }
            return com_fossil_afb == this.prettyPrinter ? this : new GeneratorSettings(com_fossil_afb, this.schema, this.characterEscapes, this.rootValueSeparator);
        }

        public GeneratorSettings with(aex com_fossil_aex) {
            return this.schema == com_fossil_aex ? this : new GeneratorSettings(this.prettyPrinter, com_fossil_aex, this.characterEscapes, this.rootValueSeparator);
        }

        public GeneratorSettings with(CharacterEscapes characterEscapes) {
            return this.characterEscapes == characterEscapes ? this : new GeneratorSettings(this.prettyPrinter, this.schema, characterEscapes, this.rootValueSeparator);
        }

        public GeneratorSettings withRootValueSeparator(String str) {
            if (str == null) {
                if (this.rootValueSeparator == null) {
                    return this;
                }
            } else if (str.equals(this.rootValueSeparator)) {
                return this;
            }
            return new GeneratorSettings(this.prettyPrinter, this.schema, this.characterEscapes, str == null ? null : new SerializedString(str));
        }

        public GeneratorSettings withRootValueSeparator(afc com_fossil_afc) {
            if (com_fossil_afc == null) {
                if (this.rootValueSeparator == null) {
                    return this;
                }
            } else if (this.rootValueSeparator != null && com_fossil_afc.getValue().equals(this.rootValueSeparator.getValue())) {
                return this;
            }
            return new GeneratorSettings(this.prettyPrinter, this.schema, this.characterEscapes, com_fossil_afc);
        }

        public void initialize(JsonGenerator jsonGenerator) {
            afb com_fossil_afb = this.prettyPrinter;
            if (this.prettyPrinter != null) {
                if (com_fossil_afb == ObjectWriter.NULL_PRETTY_PRINTER) {
                    jsonGenerator.m2664a(null);
                } else {
                    if (com_fossil_afb instanceof ago) {
                        com_fossil_afb = (afb) ((ago) com_fossil_afb).createInstance();
                    }
                    jsonGenerator.m2664a(com_fossil_afb);
                }
            }
            if (this.characterEscapes != null) {
                jsonGenerator.mo921a(this.characterEscapes);
            }
            if (this.schema != null) {
                jsonGenerator.m2669a(this.schema);
            }
            if (this.rootValueSeparator != null) {
                jsonGenerator.mo922a(this.rootValueSeparator);
            }
        }
    }

    public static final class Prefetch implements Serializable {
        public static final Prefetch empty = new Prefetch(null, null, null);
        private static final long serialVersionUID = 1;
        private final JavaType rootType;
        private final ajv typeSerializer;
        private final ahb<Object> valueSerializer;

        private Prefetch(JavaType javaType, ahb<Object> com_fossil_ahb_java_lang_Object, ajv com_fossil_ajv) {
            this.rootType = javaType;
            this.valueSerializer = com_fossil_ahb_java_lang_Object;
            this.typeSerializer = com_fossil_ajv;
        }

        public Prefetch forRootType(ObjectWriter objectWriter, JavaType javaType) {
            Object obj = 1;
            if (!(javaType == null || javaType.isJavaLangObject())) {
                obj = null;
            }
            if (obj != null) {
                if (this.rootType == null || this.valueSerializer == null) {
                    return this;
                }
                return new Prefetch(null, null, this.typeSerializer);
            } else if (javaType.equals(this.rootType)) {
                return this;
            } else {
                if (objectWriter.isEnabled(SerializationFeature.EAGER_SERIALIZER_FETCH)) {
                    try {
                        ahb findTypedValueSerializer = objectWriter._serializerProvider().findTypedValueSerializer(javaType, true, null);
                        if (findTypedValueSerializer instanceof alv) {
                            return new Prefetch(javaType, null, ((alv) findTypedValueSerializer).GO());
                        }
                        return new Prefetch(javaType, findTypedValueSerializer, null);
                    } catch (JsonProcessingException e) {
                    }
                }
                return new Prefetch(null, null, this.typeSerializer);
            }
        }

        public final ahb<Object> getValueSerializer() {
            return this.valueSerializer;
        }

        public final ajv getTypeSerializer() {
            return this.typeSerializer;
        }

        public boolean hasSerializer() {
            return (this.valueSerializer == null && this.typeSerializer == null) ? false : true;
        }

        public void serialize(JsonGenerator jsonGenerator, Object obj, DefaultSerializerProvider defaultSerializerProvider) throws IOException {
            if (this.typeSerializer != null) {
                defaultSerializerProvider.serializePolymorphic(jsonGenerator, obj, this.rootType, this.valueSerializer, this.typeSerializer);
            } else if (this.valueSerializer != null) {
                defaultSerializerProvider.serializeValue(jsonGenerator, obj, this.rootType, this.valueSerializer);
            } else {
                defaultSerializerProvider.serializeValue(jsonGenerator, obj);
            }
        }
    }

    protected ObjectWriter(ObjectMapper objectMapper, SerializationConfig serializationConfig, JavaType javaType, afb com_fossil_afb) {
        this._config = serializationConfig;
        this._serializerProvider = objectMapper._serializerProvider;
        this._serializerFactory = objectMapper._serializerFactory;
        this._generatorFactory = objectMapper._jsonFactory;
        this._generatorSettings = com_fossil_afb == null ? GeneratorSettings.empty : new GeneratorSettings(com_fossil_afb, null, null, null);
        if (javaType == null || javaType.hasRawClass(Object.class)) {
            this._prefetch = Prefetch.empty;
        } else {
            this._prefetch = Prefetch.empty.forRootType(this, javaType.withStaticTyping());
        }
    }

    protected ObjectWriter(ObjectMapper objectMapper, SerializationConfig serializationConfig) {
        this._config = serializationConfig;
        this._serializerProvider = objectMapper._serializerProvider;
        this._serializerFactory = objectMapper._serializerFactory;
        this._generatorFactory = objectMapper._jsonFactory;
        this._generatorSettings = GeneratorSettings.empty;
        this._prefetch = Prefetch.empty;
    }

    protected ObjectWriter(ObjectMapper objectMapper, SerializationConfig serializationConfig, aex com_fossil_aex) {
        this._config = serializationConfig;
        this._serializerProvider = objectMapper._serializerProvider;
        this._serializerFactory = objectMapper._serializerFactory;
        this._generatorFactory = objectMapper._jsonFactory;
        this._generatorSettings = com_fossil_aex == null ? GeneratorSettings.empty : new GeneratorSettings(null, com_fossil_aex, null, null);
        this._prefetch = Prefetch.empty;
    }

    protected ObjectWriter(ObjectWriter objectWriter, SerializationConfig serializationConfig, GeneratorSettings generatorSettings, Prefetch prefetch) {
        this._config = serializationConfig;
        this._serializerProvider = objectWriter._serializerProvider;
        this._serializerFactory = objectWriter._serializerFactory;
        this._generatorFactory = objectWriter._generatorFactory;
        this._generatorSettings = generatorSettings;
        this._prefetch = prefetch;
    }

    protected ObjectWriter(ObjectWriter objectWriter, SerializationConfig serializationConfig) {
        this._config = serializationConfig;
        this._serializerProvider = objectWriter._serializerProvider;
        this._serializerFactory = objectWriter._serializerFactory;
        this._generatorFactory = objectWriter._generatorFactory;
        this._generatorSettings = objectWriter._generatorSettings;
        this._prefetch = objectWriter._prefetch;
    }

    protected ObjectWriter(ObjectWriter objectWriter, JsonFactory jsonFactory) {
        this._config = objectWriter._config.with(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, jsonFactory.requiresPropertyOrdering());
        this._serializerProvider = objectWriter._serializerProvider;
        this._serializerFactory = objectWriter._serializerFactory;
        this._generatorFactory = objectWriter._generatorFactory;
        this._generatorSettings = objectWriter._generatorSettings;
        this._prefetch = objectWriter._prefetch;
    }

    public Version version() {
        return ahs.aOo;
    }

    protected ObjectWriter _new(ObjectWriter objectWriter, JsonFactory jsonFactory) {
        return new ObjectWriter(objectWriter, jsonFactory);
    }

    protected ObjectWriter _new(ObjectWriter objectWriter, SerializationConfig serializationConfig) {
        return new ObjectWriter(objectWriter, serializationConfig);
    }

    protected ObjectWriter _new(GeneratorSettings generatorSettings, Prefetch prefetch) {
        return new ObjectWriter(this, this._config, generatorSettings, prefetch);
    }

    protected ahf _newSequenceWriter(boolean z, JsonGenerator jsonGenerator, boolean z2) throws IOException {
        _configureGenerator(jsonGenerator);
        return new ahf(_serializerProvider(), jsonGenerator, z2, this._prefetch).aJ(z);
    }

    public ObjectWriter with(SerializationFeature serializationFeature) {
        SerializationConfig with = this._config.with(serializationFeature);
        return with == this._config ? this : _new(this, with);
    }

    public ObjectWriter with(SerializationFeature serializationFeature, SerializationFeature... serializationFeatureArr) {
        SerializationConfig with = this._config.with(serializationFeature, serializationFeatureArr);
        return with == this._config ? this : _new(this, with);
    }

    public ObjectWriter withFeatures(SerializationFeature... serializationFeatureArr) {
        SerializationConfig withFeatures = this._config.withFeatures(serializationFeatureArr);
        return withFeatures == this._config ? this : _new(this, withFeatures);
    }

    public ObjectWriter without(SerializationFeature serializationFeature) {
        SerializationConfig without = this._config.without(serializationFeature);
        return without == this._config ? this : _new(this, without);
    }

    public ObjectWriter without(SerializationFeature serializationFeature, SerializationFeature... serializationFeatureArr) {
        SerializationConfig without = this._config.without(serializationFeature, serializationFeatureArr);
        return without == this._config ? this : _new(this, without);
    }

    public ObjectWriter withoutFeatures(SerializationFeature... serializationFeatureArr) {
        SerializationConfig withoutFeatures = this._config.withoutFeatures(serializationFeatureArr);
        return withoutFeatures == this._config ? this : _new(this, withoutFeatures);
    }

    public ObjectWriter with(Feature feature) {
        SerializationConfig with = this._config.with(feature);
        return with == this._config ? this : _new(this, with);
    }

    public ObjectWriter withFeatures(Feature... featureArr) {
        SerializationConfig withFeatures = this._config.withFeatures(featureArr);
        return withFeatures == this._config ? this : _new(this, withFeatures);
    }

    public ObjectWriter without(Feature feature) {
        SerializationConfig without = this._config.without(feature);
        return without == this._config ? this : _new(this, without);
    }

    public ObjectWriter withoutFeatures(Feature... featureArr) {
        SerializationConfig withoutFeatures = this._config.withoutFeatures(featureArr);
        return withoutFeatures == this._config ? this : _new(this, withoutFeatures);
    }

    public ObjectWriter forType(JavaType javaType) {
        Prefetch forRootType = this._prefetch.forRootType(this, javaType);
        return forRootType == this._prefetch ? this : _new(this._generatorSettings, forRootType);
    }

    public ObjectWriter forType(Class<?> cls) {
        if (cls == Object.class) {
            return forType((JavaType) null);
        }
        return forType(this._config.constructType((Class) cls));
    }

    public ObjectWriter forType(agl<?> com_fossil_agl_) {
        return forType(this._config.getTypeFactory().constructType(com_fossil_agl_.getType()));
    }

    @Deprecated
    public ObjectWriter withType(JavaType javaType) {
        return forType(javaType);
    }

    @Deprecated
    public ObjectWriter withType(Class<?> cls) {
        return forType((Class) cls);
    }

    @Deprecated
    public ObjectWriter withType(agl<?> com_fossil_agl_) {
        return forType((agl) com_fossil_agl_);
    }

    public ObjectWriter with(DateFormat dateFormat) {
        SerializationConfig with = this._config.with(dateFormat);
        return with == this._config ? this : _new(this, with);
    }

    public ObjectWriter withDefaultPrettyPrinter() {
        return with(this._config.getDefaultPrettyPrinter());
    }

    public ObjectWriter with(alh com_fossil_alh) {
        return com_fossil_alh == this._config.getFilterProvider() ? this : _new(this, this._config.withFilters(com_fossil_alh));
    }

    public ObjectWriter with(afb com_fossil_afb) {
        GeneratorSettings with = this._generatorSettings.with(com_fossil_afb);
        return with == this._generatorSettings ? this : _new(with, this._prefetch);
    }

    public ObjectWriter withRootName(String str) {
        SerializationConfig serializationConfig = (SerializationConfig) this._config.withRootName(str);
        return serializationConfig == this._config ? this : _new(this, serializationConfig);
    }

    public ObjectWriter withRootName(PropertyName propertyName) {
        SerializationConfig withRootName = this._config.withRootName(propertyName);
        return withRootName == this._config ? this : _new(this, withRootName);
    }

    public ObjectWriter withoutRootName() {
        SerializationConfig withRootName = this._config.withRootName(PropertyName.NO_NAME);
        return withRootName == this._config ? this : _new(this, withRootName);
    }

    public ObjectWriter with(aex com_fossil_aex) {
        GeneratorSettings with = this._generatorSettings.with(com_fossil_aex);
        if (with == this._generatorSettings) {
            return this;
        }
        _verifySchemaType(com_fossil_aex);
        return _new(with, this._prefetch);
    }

    @Deprecated
    public ObjectWriter withSchema(aex com_fossil_aex) {
        return with(com_fossil_aex);
    }

    public ObjectWriter withView(Class<?> cls) {
        SerializationConfig withView = this._config.withView((Class) cls);
        return withView == this._config ? this : _new(this, withView);
    }

    public ObjectWriter with(Locale locale) {
        SerializationConfig with = this._config.with(locale);
        return with == this._config ? this : _new(this, with);
    }

    public ObjectWriter with(TimeZone timeZone) {
        SerializationConfig with = this._config.with(timeZone);
        return with == this._config ? this : _new(this, with);
    }

    public ObjectWriter with(Base64Variant base64Variant) {
        SerializationConfig with = this._config.with(base64Variant);
        return with == this._config ? this : _new(this, with);
    }

    public ObjectWriter with(CharacterEscapes characterEscapes) {
        GeneratorSettings with = this._generatorSettings.with(characterEscapes);
        return with == this._generatorSettings ? this : _new(with, this._prefetch);
    }

    public ObjectWriter with(JsonFactory jsonFactory) {
        return jsonFactory == this._generatorFactory ? this : _new(this, jsonFactory);
    }

    public ObjectWriter with(ContextAttributes contextAttributes) {
        SerializationConfig with = this._config.with(contextAttributes);
        return with == this._config ? this : _new(this, with);
    }

    public ObjectWriter withAttributes(Map<Object, Object> map) {
        SerializationConfig serializationConfig = (SerializationConfig) this._config.withAttributes(map);
        return serializationConfig == this._config ? this : _new(this, serializationConfig);
    }

    public ObjectWriter withAttribute(Object obj, Object obj2) {
        SerializationConfig serializationConfig = (SerializationConfig) this._config.withAttribute(obj, obj2);
        return serializationConfig == this._config ? this : _new(this, serializationConfig);
    }

    public ObjectWriter withoutAttribute(Object obj) {
        SerializationConfig serializationConfig = (SerializationConfig) this._config.withoutAttribute(obj);
        return serializationConfig == this._config ? this : _new(this, serializationConfig);
    }

    public ObjectWriter withRootValueSeparator(String str) {
        GeneratorSettings withRootValueSeparator = this._generatorSettings.withRootValueSeparator(str);
        return withRootValueSeparator == this._generatorSettings ? this : _new(withRootValueSeparator, this._prefetch);
    }

    public ObjectWriter withRootValueSeparator(afc com_fossil_afc) {
        GeneratorSettings withRootValueSeparator = this._generatorSettings.withRootValueSeparator(com_fossil_afc);
        return withRootValueSeparator == this._generatorSettings ? this : _new(withRootValueSeparator, this._prefetch);
    }

    public ahf writeValues(File file) throws IOException {
        return _newSequenceWriter(false, this._generatorFactory.createGenerator(file, JsonEncoding.UTF8), true);
    }

    public ahf writeValues(JsonGenerator jsonGenerator) throws IOException {
        _configureGenerator(jsonGenerator);
        return _newSequenceWriter(false, jsonGenerator, false);
    }

    public ahf writeValues(Writer writer) throws IOException {
        return _newSequenceWriter(false, this._generatorFactory.createGenerator(writer), true);
    }

    public ahf writeValues(OutputStream outputStream) throws IOException {
        return _newSequenceWriter(false, this._generatorFactory.createGenerator(outputStream, JsonEncoding.UTF8), true);
    }

    public ahf writeValuesAsArray(File file) throws IOException {
        return _newSequenceWriter(true, this._generatorFactory.createGenerator(file, JsonEncoding.UTF8), true);
    }

    public ahf writeValuesAsArray(JsonGenerator jsonGenerator) throws IOException {
        return _newSequenceWriter(true, jsonGenerator, false);
    }

    public ahf writeValuesAsArray(Writer writer) throws IOException {
        return _newSequenceWriter(true, this._generatorFactory.createGenerator(writer), true);
    }

    public ahf writeValuesAsArray(OutputStream outputStream) throws IOException {
        return _newSequenceWriter(true, this._generatorFactory.createGenerator(outputStream, JsonEncoding.UTF8), true);
    }

    public boolean isEnabled(SerializationFeature serializationFeature) {
        return this._config.isEnabled(serializationFeature);
    }

    public boolean isEnabled(MapperFeature mapperFeature) {
        return this._config.isEnabled(mapperFeature);
    }

    public boolean isEnabled(JsonParser.Feature feature) {
        return this._generatorFactory.isEnabled(feature);
    }

    public SerializationConfig getConfig() {
        return this._config;
    }

    public JsonFactory getFactory() {
        return this._generatorFactory;
    }

    public TypeFactory getTypeFactory() {
        return this._config.getTypeFactory();
    }

    public boolean hasPrefetchedSerializer() {
        return this._prefetch.hasSerializer();
    }

    public ContextAttributes getAttributes() {
        return this._config.getAttributes();
    }

    public void writeValue(JsonGenerator jsonGenerator, Object obj) throws IOException, JsonGenerationException, JsonMappingException {
        Throwable th;
        _configureGenerator(jsonGenerator);
        if (this._config.isEnabled(SerializationFeature.CLOSE_CLOSEABLE) && (obj instanceof Closeable)) {
            Closeable closeable = (Closeable) obj;
            Closeable closeable2;
            try {
                this._prefetch.serialize(jsonGenerator, obj, _serializerProvider());
                if (this._config.isEnabled(SerializationFeature.FLUSH_AFTER_WRITE_VALUE)) {
                    jsonGenerator.flush();
                }
                closeable2 = null;
                try {
                    closeable.close();
                    if (closeable2 != null) {
                        try {
                            closeable2.close();
                            return;
                        } catch (IOException e) {
                            return;
                        }
                    }
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    if (closeable2 != null) {
                        try {
                            closeable2.close();
                        } catch (IOException e2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                closeable2 = closeable;
                th = th4;
                if (closeable2 != null) {
                    closeable2.close();
                }
                throw th;
            }
        }
        this._prefetch.serialize(jsonGenerator, obj, _serializerProvider());
        if (this._config.isEnabled(SerializationFeature.FLUSH_AFTER_WRITE_VALUE)) {
            jsonGenerator.flush();
        }
    }

    public void writeValue(File file, Object obj) throws IOException, JsonGenerationException, JsonMappingException {
        _configAndWriteValue(this._generatorFactory.createGenerator(file, JsonEncoding.UTF8), obj);
    }

    public void writeValue(OutputStream outputStream, Object obj) throws IOException, JsonGenerationException, JsonMappingException {
        _configAndWriteValue(this._generatorFactory.createGenerator(outputStream, JsonEncoding.UTF8), obj);
    }

    public void writeValue(Writer writer, Object obj) throws IOException, JsonGenerationException, JsonMappingException {
        _configAndWriteValue(this._generatorFactory.createGenerator(writer), obj);
    }

    public String writeValueAsString(Object obj) throws JsonProcessingException {
        Writer com_fossil_aft = new aft(this._generatorFactory._getBufferRecycler());
        try {
            _configAndWriteValue(this._generatorFactory.createGenerator(com_fossil_aft), obj);
            return com_fossil_aft.BJ();
        } catch (JsonProcessingException e) {
            throw e;
        } catch (IOException e2) {
            throw JsonMappingException.fromUnexpectedIOE(e2);
        }
    }

    public byte[] writeValueAsBytes(Object obj) throws JsonProcessingException {
        OutputStream com_fossil_agn = new agn(this._generatorFactory._getBufferRecycler());
        try {
            _configAndWriteValue(this._generatorFactory.createGenerator(com_fossil_agn, JsonEncoding.UTF8), obj);
            byte[] toByteArray = com_fossil_agn.toByteArray();
            com_fossil_agn.release();
            return toByteArray;
        } catch (JsonProcessingException e) {
            throw e;
        } catch (IOException e2) {
            throw JsonMappingException.fromUnexpectedIOE(e2);
        }
    }

    public void acceptJsonFormatVisitor(JavaType javaType, ajg com_fossil_ajg) throws JsonMappingException {
        if (javaType == null) {
            throw new IllegalArgumentException("type must be provided");
        }
        _serializerProvider().acceptJsonFormatVisitor(javaType, com_fossil_ajg);
    }

    public void acceptJsonFormatVisitor(Class<?> cls, ajg com_fossil_ajg) throws JsonMappingException {
        acceptJsonFormatVisitor(this._config.constructType((Class) cls), com_fossil_ajg);
    }

    public boolean canSerialize(Class<?> cls) {
        return _serializerProvider().hasSerializerFor(cls, null);
    }

    public boolean canSerialize(Class<?> cls, AtomicReference<Throwable> atomicReference) {
        return _serializerProvider().hasSerializerFor(cls, atomicReference);
    }

    protected DefaultSerializerProvider _serializerProvider() {
        return this._serializerProvider.createInstance(this._config, this._serializerFactory);
    }

    protected void _verifySchemaType(aex com_fossil_aex) {
        if (com_fossil_aex != null && !this._generatorFactory.canUseSchema(com_fossil_aex)) {
            throw new IllegalArgumentException("Can not use FormatSchema of type " + com_fossil_aex.getClass().getName() + " for format " + this._generatorFactory.getFormatName());
        }
    }

    protected final void _configAndWriteValue(JsonGenerator jsonGenerator, Object obj) throws IOException {
        _configureGenerator(jsonGenerator);
        if (this._config.isEnabled(SerializationFeature.CLOSE_CLOSEABLE) && (obj instanceof Closeable)) {
            m2692a(jsonGenerator, obj);
            return;
        }
        Object obj2 = null;
        try {
            this._prefetch.serialize(jsonGenerator, obj, _serializerProvider());
            obj2 = 1;
            jsonGenerator.close();
        } catch (Throwable th) {
            if (obj2 == null) {
                jsonGenerator.mo848a(Feature.AUTO_CLOSE_JSON_CONTENT);
                try {
                    jsonGenerator.close();
                } catch (IOException e) {
                }
            }
        }
    }

    private final void m2692a(JsonGenerator jsonGenerator, Object obj) throws IOException {
        Throwable th;
        Closeable closeable;
        JsonGenerator jsonGenerator2 = null;
        Closeable closeable2 = (Closeable) obj;
        try {
            Closeable closeable3;
            this._prefetch.serialize(jsonGenerator, obj, _serializerProvider());
            JsonGenerator jsonGenerator3 = null;
            try {
                jsonGenerator.close();
                closeable3 = null;
            } catch (Throwable th2) {
                jsonGenerator = jsonGenerator2;
                Closeable closeable4 = closeable2;
                th = th2;
                closeable = closeable4;
                if (jsonGenerator != null) {
                    jsonGenerator.mo848a(Feature.AUTO_CLOSE_JSON_CONTENT);
                    try {
                        jsonGenerator.close();
                    } catch (IOException e) {
                    }
                }
                if (closeable != null) {
                    try {
                        closeable.close();
                    } catch (IOException e2) {
                    }
                }
                throw th;
            }
            try {
                closeable2.close();
                if (jsonGenerator2 != null) {
                    jsonGenerator2.mo848a(Feature.AUTO_CLOSE_JSON_CONTENT);
                    try {
                        jsonGenerator3.close();
                    } catch (IOException e3) {
                    }
                }
                if (jsonGenerator2 != null) {
                    try {
                        closeable3.close();
                    } catch (IOException e4) {
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                Object obj2 = jsonGenerator2;
                jsonGenerator = jsonGenerator2;
                if (jsonGenerator != null) {
                    jsonGenerator.mo848a(Feature.AUTO_CLOSE_JSON_CONTENT);
                    jsonGenerator.close();
                }
                if (closeable != null) {
                    closeable.close();
                }
                throw th;
            }
        } catch (Throwable th22) {
            Throwable th4 = th22;
            closeable = closeable2;
            th = th4;
            if (jsonGenerator != null) {
                jsonGenerator.mo848a(Feature.AUTO_CLOSE_JSON_CONTENT);
                jsonGenerator.close();
            }
            if (closeable != null) {
                closeable.close();
            }
            throw th;
        }
    }

    protected final void _configureGenerator(JsonGenerator jsonGenerator) {
        this._config.initialize(jsonGenerator);
        this._generatorSettings.initialize(jsonGenerator);
    }
}
