package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.cfg.ContextAttributes;
import com.fasterxml.jackson.databind.deser.DeserializerCache;
import com.fasterxml.jackson.databind.deser.UnresolvedForwardReference;
import com.fasterxml.jackson.databind.deser.impl.TypeWrappedDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fossil.aeu;
import com.fossil.agv;
import com.fossil.agw;
import com.fossil.agx;
import com.fossil.agy;
import com.fossil.ahc;
import com.fossil.ahv;
import com.fossil.ahw;
import com.fossil.ahy;
import com.fossil.ahz;
import com.fossil.ail;
import com.fossil.aiq;
import com.fossil.ajs;
import com.fossil.amd;
import com.fossil.ami;
import com.fossil.amn;
import com.fossil.amp;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

public abstract class DeserializationContext extends agw implements Serializable {
    private static final long serialVersionUID = 1;
    protected transient amd _arrayBuilders;
    protected transient ContextAttributes _attributes;
    protected final DeserializerCache _cache;
    protected final DeserializationConfig _config;
    protected amn<JavaType> _currentType;
    protected transient DateFormat _dateFormat;
    protected final ahz _factory;
    protected final int _featureFlags;
    protected final agx _injectableValues;
    protected transient amp _objectBuffer;
    protected transient JsonParser _parser;
    protected final Class<?> _view;

    public abstract void checkUnresolvedObjectId() throws UnresolvedForwardReference;

    public abstract agy<Object> deserializerInstance(aiq com_fossil_aiq, Object obj) throws JsonMappingException;

    @Deprecated
    public abstract ail findObjectId(Object obj, ObjectIdGenerator<?> objectIdGenerator);

    public abstract ail findObjectId(Object obj, ObjectIdGenerator<?> objectIdGenerator, aeu com_fossil_aeu);

    public abstract ahc keyDeserializerInstance(aiq com_fossil_aiq, Object obj) throws JsonMappingException;

    protected DeserializationContext(ahz com_fossil_ahz) {
        this(com_fossil_ahz, null);
    }

    protected DeserializationContext(ahz com_fossil_ahz, DeserializerCache deserializerCache) {
        if (com_fossil_ahz == null) {
            throw new IllegalArgumentException("Can not pass null DeserializerFactory");
        }
        this._factory = com_fossil_ahz;
        if (deserializerCache == null) {
            deserializerCache = new DeserializerCache();
        }
        this._cache = deserializerCache;
        this._featureFlags = 0;
        this._config = null;
        this._injectableValues = null;
        this._view = null;
        this._attributes = null;
    }

    protected DeserializationContext(DeserializationContext deserializationContext, ahz com_fossil_ahz) {
        this._cache = deserializationContext._cache;
        this._factory = com_fossil_ahz;
        this._config = deserializationContext._config;
        this._featureFlags = deserializationContext._featureFlags;
        this._view = deserializationContext._view;
        this._parser = deserializationContext._parser;
        this._injectableValues = deserializationContext._injectableValues;
        this._attributes = deserializationContext._attributes;
    }

    protected DeserializationContext(DeserializationContext deserializationContext, DeserializationConfig deserializationConfig, JsonParser jsonParser, agx com_fossil_agx) {
        this._cache = deserializationContext._cache;
        this._factory = deserializationContext._factory;
        this._config = deserializationConfig;
        this._featureFlags = deserializationConfig.getDeserializationFeatures();
        this._view = deserializationConfig.getActiveView();
        this._parser = jsonParser;
        this._injectableValues = com_fossil_agx;
        this._attributes = deserializationConfig.getAttributes();
    }

    protected DeserializationContext(DeserializationContext deserializationContext) {
        this._cache = new DeserializerCache();
        this._factory = deserializationContext._factory;
        this._config = deserializationContext._config;
        this._featureFlags = deserializationContext._featureFlags;
        this._view = deserializationContext._view;
        this._injectableValues = null;
    }

    public DeserializationConfig getConfig() {
        return this._config;
    }

    public final Class<?> getActiveView() {
        return this._view;
    }

    public final AnnotationIntrospector getAnnotationIntrospector() {
        return this._config.getAnnotationIntrospector();
    }

    public final TypeFactory getTypeFactory() {
        return this._config.getTypeFactory();
    }

    public Locale getLocale() {
        return this._config.getLocale();
    }

    public TimeZone getTimeZone() {
        return this._config.getTimeZone();
    }

    public Object getAttribute(Object obj) {
        return this._attributes.getAttribute(obj);
    }

    public DeserializationContext setAttribute(Object obj, Object obj2) {
        this._attributes = this._attributes.withPerCallAttribute(obj, obj2);
        return this;
    }

    public JavaType getContextualType() {
        return this._currentType == null ? null : (JavaType) this._currentType.Hn();
    }

    public ahz getFactory() {
        return this._factory;
    }

    public final boolean isEnabled(DeserializationFeature deserializationFeature) {
        return (this._featureFlags & deserializationFeature.getMask()) != 0;
    }

    public final int getDeserializationFeatures() {
        return this._featureFlags;
    }

    public final boolean hasDeserializationFeatures(int i) {
        return (this._featureFlags & i) == i;
    }

    public final boolean hasSomeOfFeatures(int i) {
        return (this._featureFlags & i) != 0;
    }

    public final JsonParser getParser() {
        return this._parser;
    }

    public final Object findInjectableValue(Object obj, agv com_fossil_agv, Object obj2) {
        if (this._injectableValues != null) {
            return this._injectableValues.m3335a(obj, this, com_fossil_agv, obj2);
        }
        throw new IllegalStateException("No 'injectableValues' configured, can not inject value with id [" + obj + "]");
    }

    public final Base64Variant getBase64Variant() {
        return this._config.getBase64Variant();
    }

    public final JsonNodeFactory getNodeFactory() {
        return this._config.getNodeFactory();
    }

    @Deprecated
    public boolean hasValueDeserializerFor(JavaType javaType) {
        return hasValueDeserializerFor(javaType, null);
    }

    public boolean hasValueDeserializerFor(JavaType javaType, AtomicReference<Throwable> atomicReference) {
        try {
            return this._cache.hasValueDeserializerFor(this, this._factory, javaType);
        } catch (JsonMappingException e) {
            if (atomicReference != null) {
                atomicReference.set(e);
            }
            return false;
        } catch (RuntimeException e2) {
            if (atomicReference == null) {
                throw e2;
            }
            atomicReference.set(e2);
            return false;
        }
    }

    public final agy<Object> findContextualValueDeserializer(JavaType javaType, agv com_fossil_agv) throws JsonMappingException {
        agy<Object> findValueDeserializer = this._cache.findValueDeserializer(this, this._factory, javaType);
        if (findValueDeserializer != null) {
            return handleSecondaryContextualization(findValueDeserializer, com_fossil_agv, javaType);
        }
        return findValueDeserializer;
    }

    public final agy<Object> findNonContextualValueDeserializer(JavaType javaType) throws JsonMappingException {
        return this._cache.findValueDeserializer(this, this._factory, javaType);
    }

    public final agy<Object> findRootValueDeserializer(JavaType javaType) throws JsonMappingException {
        agy findValueDeserializer = this._cache.findValueDeserializer(this, this._factory, javaType);
        if (findValueDeserializer == null) {
            return null;
        }
        agy<Object> handleSecondaryContextualization = handleSecondaryContextualization(findValueDeserializer, null, javaType);
        ajs findTypeDeserializer = this._factory.findTypeDeserializer(this._config, javaType);
        return findTypeDeserializer != null ? new TypeWrappedDeserializer(findTypeDeserializer.forProperty(null), handleSecondaryContextualization) : handleSecondaryContextualization;
    }

    public final ahc findKeyDeserializer(JavaType javaType, agv com_fossil_agv) throws JsonMappingException {
        ahc findKeyDeserializer = this._cache.findKeyDeserializer(this, this._factory, javaType);
        if (findKeyDeserializer instanceof ahw) {
            return ((ahw) findKeyDeserializer).m3371a(this, com_fossil_agv);
        }
        return findKeyDeserializer;
    }

    public final JavaType constructType(Class<?> cls) {
        return this._config.constructType((Class) cls);
    }

    public Class<?> findClass(String str) throws ClassNotFoundException {
        return getTypeFactory().findClass(str);
    }

    public final amp leaseObjectBuffer() {
        amp com_fossil_amp = this._objectBuffer;
        if (com_fossil_amp == null) {
            return new amp();
        }
        this._objectBuffer = null;
        return com_fossil_amp;
    }

    public final void returnObjectBuffer(amp com_fossil_amp) {
        if (this._objectBuffer == null || com_fossil_amp.Hp() >= this._objectBuffer.Hp()) {
            this._objectBuffer = com_fossil_amp;
        }
    }

    public final amd getArrayBuilders() {
        if (this._arrayBuilders == null) {
            this._arrayBuilders = new amd();
        }
        return this._arrayBuilders;
    }

    public agy<?> handlePrimaryContextualization(agy<?> com_fossil_agy_, agv com_fossil_agv, JavaType javaType) throws JsonMappingException {
        if (com_fossil_agy_ instanceof ahv) {
            this._currentType = new amn(javaType, this._currentType);
            try {
                com_fossil_agy_ = ((ahv) com_fossil_agy_).createContextual(this, com_fossil_agv);
            } finally {
                this._currentType = this._currentType.Hm();
            }
        }
        return com_fossil_agy_;
    }

    public agy<?> handleSecondaryContextualization(agy<?> com_fossil_agy_, agv com_fossil_agv, JavaType javaType) throws JsonMappingException {
        if (com_fossil_agy_ instanceof ahv) {
            this._currentType = new amn(javaType, this._currentType);
            try {
                com_fossil_agy_ = ((ahv) com_fossil_agy_).createContextual(this, com_fossil_agv);
            } finally {
                this._currentType = this._currentType.Hm();
            }
        }
        return com_fossil_agy_;
    }

    @Deprecated
    public agy<?> handlePrimaryContextualization(agy<?> com_fossil_agy_, agv com_fossil_agv) throws JsonMappingException {
        return handlePrimaryContextualization(com_fossil_agy_, com_fossil_agv, TypeFactory.unknownType());
    }

    @Deprecated
    public agy<?> handleSecondaryContextualization(agy<?> com_fossil_agy_, agv com_fossil_agv) throws JsonMappingException {
        if (com_fossil_agy_ instanceof ahv) {
            return ((ahv) com_fossil_agy_).createContextual(this, com_fossil_agv);
        }
        return com_fossil_agy_;
    }

    public Date parseDate(String str) throws IllegalArgumentException {
        try {
            return getDateFormat().parse(str);
        } catch (ParseException e) {
            throw new IllegalArgumentException(String.format("Failed to parse Date value '%s': %s", new Object[]{str, e.getMessage()}));
        }
    }

    public Calendar constructCalendar(Date date) {
        Calendar instance = Calendar.getInstance(getTimeZone());
        instance.setTime(date);
        return instance;
    }

    public <T> T readValue(JsonParser jsonParser, Class<T> cls) throws IOException {
        return readValue(jsonParser, getTypeFactory().constructType((Type) cls));
    }

    public <T> T readValue(JsonParser jsonParser, JavaType javaType) throws IOException {
        agy findRootValueDeserializer = findRootValueDeserializer(javaType);
        if (findRootValueDeserializer == null) {
        }
        return findRootValueDeserializer.deserialize(jsonParser, this);
    }

    public <T> T readPropertyValue(JsonParser jsonParser, agv com_fossil_agv, Class<T> cls) throws IOException {
        return readPropertyValue(jsonParser, com_fossil_agv, getTypeFactory().constructType((Type) cls));
    }

    public <T> T readPropertyValue(JsonParser jsonParser, agv com_fossil_agv, JavaType javaType) throws IOException {
        agy findContextualValueDeserializer = findContextualValueDeserializer(javaType, com_fossil_agv);
        if (findContextualValueDeserializer == null) {
        }
        return findContextualValueDeserializer.deserialize(jsonParser, this);
    }

    public boolean handleUnknownProperty(JsonParser jsonParser, agy<?> com_fossil_agy_, Object obj, String str) throws IOException, JsonProcessingException {
        amn problemHandlers = this._config.getProblemHandlers();
        if (problemHandlers != null) {
            for (amn com_fossil_amn = problemHandlers; com_fossil_amn != null; com_fossil_amn = com_fossil_amn.Hm()) {
                if (((ahy) com_fossil_amn.Hn()).m3378a(this, jsonParser, com_fossil_agy_, obj, str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void reportUnknownProperty(Object obj, String str, agy<?> com_fossil_agy_) throws JsonMappingException {
        if (isEnabled(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)) {
            throw UnrecognizedPropertyException.from(this._parser, obj, str, com_fossil_agy_ == null ? null : com_fossil_agy_.getKnownPropertyNames());
        }
    }

    public JsonMappingException mappingException(Class<?> cls) {
        return mappingException((Class) cls, this._parser.zU());
    }

    public JsonMappingException mappingException(Class<?> cls, JsonToken jsonToken) {
        return JsonMappingException.from(this._parser, String.format("Can not deserialize instance of %s out of %s token", new Object[]{_calcName(cls), jsonToken}));
    }

    public JsonMappingException mappingException(String str) {
        return JsonMappingException.from(getParser(), str);
    }

    public JsonMappingException mappingException(String str, Object... objArr) {
        return JsonMappingException.from(getParser(), String.format(str, objArr));
    }

    public JsonMappingException instantiationException(Class<?> cls, Throwable th) {
        return JsonMappingException.from(this._parser, String.format("Can not construct instance of %s, problem: %s", new Object[]{cls.getName(), th.getMessage()}), th);
    }

    public JsonMappingException instantiationException(Class<?> cls, String str) {
        return JsonMappingException.from(this._parser, String.format("Can not construct instance of %s, problem: %s", new Object[]{cls.getName(), str}));
    }

    public JsonMappingException weirdStringException(String str, Class<?> cls, String str2) {
        return InvalidFormatException.from(this._parser, String.format("Can not construct instance of %s from String value '%s': %s", new Object[]{cls.getName(), _valueDesc(), str2}), str, cls);
    }

    public JsonMappingException weirdNumberException(Number number, Class<?> cls, String str) {
        return InvalidFormatException.from(this._parser, String.format("Can not construct instance of %s from number value (%s): %s", new Object[]{cls.getName(), _valueDesc(), str}), null, cls);
    }

    public JsonMappingException weirdKeyException(Class<?> cls, String str, String str2) {
        return InvalidFormatException.from(this._parser, String.format("Can not construct Map key of type %s from String \"%s\": ", new Object[]{cls.getName(), _desc(str), str2}), str, cls);
    }

    public JsonMappingException wrongTokenException(JsonParser jsonParser, JsonToken jsonToken, String str) {
        String format = String.format("Unexpected token (%s), expected %s", new Object[]{jsonParser.zU(), jsonToken});
        if (str != null) {
            format = format + ": " + str;
        }
        return JsonMappingException.from(jsonParser, format);
    }

    @Deprecated
    public JsonMappingException unknownTypeException(JavaType javaType, String str) {
        return JsonMappingException.from(this._parser, "Could not resolve type id '" + str + "' into a subtype of " + javaType);
    }

    public JsonMappingException unknownTypeException(JavaType javaType, String str, String str2) {
        String str3 = "Could not resolve type id '" + str + "' into a subtype of " + javaType;
        if (str2 != null) {
            str3 = str3 + ": " + str2;
        }
        return JsonMappingException.from(this._parser, str3);
    }

    public JsonMappingException endOfInputException(Class<?> cls) {
        return JsonMappingException.from(this._parser, "Unexpected end-of-input when trying to deserialize a " + cls.getName());
    }

    protected DateFormat getDateFormat() {
        if (this._dateFormat != null) {
            return this._dateFormat;
        }
        DateFormat dateFormat = (DateFormat) this._config.getDateFormat().clone();
        this._dateFormat = dateFormat;
        return dateFormat;
    }

    protected String determineClassName(Object obj) {
        return ami.bF(obj);
    }

    protected String _calcName(Class<?> cls) {
        if (cls.isArray()) {
            return _calcName(cls.getComponentType()) + "[]";
        }
        return cls.getName();
    }

    protected String _valueDesc() {
        try {
            return _desc(this._parser.getText());
        } catch (Exception e) {
            return "[N/A]";
        }
    }

    protected String _desc(String str) {
        if (str.length() > MFNetworkReturnCode.INTERNAL_SERVER_ERROR) {
            return str.substring(0, MFNetworkReturnCode.INTERNAL_SERVER_ERROR) + "]...[" + str.substring(str.length() - 500);
        }
        return str;
    }
}
