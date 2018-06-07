package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.cfg.BaseSettings;
import com.fasterxml.jackson.databind.cfg.ContextAttributes;
import com.fasterxml.jackson.databind.deser.BeanDeserializerFactory;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.fasterxml.jackson.databind.introspect.BasicClassIntrospector;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.SimpleMixInResolver;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker.Std;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.Impl;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.RootNameLookup;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fossil.aew;
import com.fossil.aex;
import com.fossil.afa;
import com.fossil.afb;
import com.fossil.afe;
import com.fossil.aft;
import com.fossil.agk;
import com.fossil.agl;
import com.fossil.agn;
import com.fossil.agx;
import com.fossil.agy;
import com.fossil.agz;
import com.fossil.ahd;
import com.fossil.ahe;
import com.fossil.ahg;
import com.fossil.ahr;
import com.fossil.ahs;
import com.fossil.ahy;
import com.fossil.aiw;
import com.fossil.aiw.C1505a;
import com.fossil.ajg;
import com.fossil.ajo;
import com.fossil.ajr;
import com.fossil.ajs;
import com.fossil.aju;
import com.fossil.ajv;
import com.fossil.akd;
import com.fossil.akh;
import com.fossil.akt;
import com.fossil.akv;
import com.fossil.akz;
import com.fossil.alh;
import com.fossil.aln;
import com.fossil.amt;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.lang.reflect.Type;
import java.net.URL;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

public class ObjectMapper extends afa implements Serializable {
    protected static final AnnotationIntrospector DEFAULT_ANNOTATION_INTROSPECTOR = new JacksonAnnotationIntrospector();
    protected static final BaseSettings DEFAULT_BASE = new BaseSettings(null, DEFAULT_ANNOTATION_INTROSPECTOR, STD_VISIBILITY_CHECKER, null, TypeFactory.defaultInstance(), null, StdDateFormat.instance, null, Locale.getDefault(), TimeZone.getTimeZone("GMT"), aew.zz());
    protected static final VisibilityChecker<?> STD_VISIBILITY_CHECKER = Std.defaultInstance();
    @Deprecated
    protected static final afb _defaultPrettyPrinter = new DefaultPrettyPrinter();
    private static final JavaType aQp = SimpleType.constructUnsafe(agz.class);
    private static final long serialVersionUID = 1;
    protected DeserializationConfig _deserializationConfig;
    protected DefaultDeserializationContext _deserializationContext;
    protected agx _injectableValues;
    protected final JsonFactory _jsonFactory;
    protected SimpleMixInResolver _mixIns;
    protected Set<Object> _registeredModuleTypes;
    protected final ConcurrentHashMap<JavaType, agy<Object>> _rootDeserializers;
    protected SerializationConfig _serializationConfig;
    protected aln _serializerFactory;
    protected DefaultSerializerProvider _serializerProvider;
    protected ajr _subtypeResolver;
    protected TypeFactory _typeFactory;

    public static class DefaultTypeResolverBuilder extends akd implements Serializable {
        private static final long serialVersionUID = 1;
        protected final DefaultTyping _appliesFor;

        public DefaultTypeResolverBuilder(DefaultTyping defaultTyping) {
            this._appliesFor = defaultTyping;
        }

        public ajs buildTypeDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, Collection<NamedType> collection) {
            return useForType(javaType) ? super.buildTypeDeserializer(deserializationConfig, javaType, collection) : null;
        }

        public ajv buildTypeSerializer(SerializationConfig serializationConfig, JavaType javaType, Collection<NamedType> collection) {
            return useForType(javaType) ? super.buildTypeSerializer(serializationConfig, javaType, collection) : null;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean useForType(com.fasterxml.jackson.databind.JavaType r5) {
            /*
            r4 = this;
            r1 = 1;
            r0 = 0;
            r2 = com.fasterxml.jackson.databind.ObjectMapper.C15082.aQs;
            r3 = r4._appliesFor;
            r3 = r3.ordinal();
            r2 = r2[r3];
            switch(r2) {
                case 1: goto L_0x0014;
                case 2: goto L_0x001f;
                case 3: goto L_0x0039;
                default: goto L_0x000f;
            };
        L_0x000f:
            r0 = r5.isJavaLangObject();
        L_0x0013:
            return r0;
        L_0x0014:
            r2 = r5.isArrayType();
            if (r2 == 0) goto L_0x001f;
        L_0x001a:
            r5 = r5.getContentType();
            goto L_0x0014;
        L_0x001f:
            r2 = r5.isJavaLangObject();
            if (r2 != 0) goto L_0x0037;
        L_0x0025:
            r2 = r5.isConcrete();
            if (r2 != 0) goto L_0x0013;
        L_0x002b:
            r2 = com.fossil.afe.class;
            r3 = r5.getRawClass();
            r2 = r2.isAssignableFrom(r3);
            if (r2 != 0) goto L_0x0013;
        L_0x0037:
            r0 = r1;
            goto L_0x0013;
        L_0x0039:
            r2 = r5.isArrayType();
            if (r2 == 0) goto L_0x0044;
        L_0x003f:
            r5 = r5.getContentType();
            goto L_0x0039;
        L_0x0044:
            r2 = r5.isFinal();
            if (r2 != 0) goto L_0x0058;
        L_0x004a:
            r2 = com.fossil.afe.class;
            r3 = r5.getRawClass();
            r2 = r2.isAssignableFrom(r3);
            if (r2 != 0) goto L_0x0058;
        L_0x0056:
            r0 = r1;
            goto L_0x0013;
        L_0x0058:
            r1 = r0;
            goto L_0x0056;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ObjectMapper.DefaultTypeResolverBuilder.useForType(com.fasterxml.jackson.databind.JavaType):boolean");
        }
    }

    public enum DefaultTyping {
        JAVA_LANG_OBJECT,
        OBJECT_AND_NON_CONCRETE,
        NON_CONCRETE_AND_ARRAYS,
        NON_FINAL
    }

    public ObjectMapper() {
        this(null, null, null);
    }

    public ObjectMapper(JsonFactory jsonFactory) {
        this(jsonFactory, null, null);
    }

    protected ObjectMapper(ObjectMapper objectMapper) {
        this._rootDeserializers = new ConcurrentHashMap(64, 0.6f, 2);
        this._jsonFactory = objectMapper._jsonFactory.copy();
        this._jsonFactory.setCodec(this);
        this._subtypeResolver = objectMapper._subtypeResolver;
        this._typeFactory = objectMapper._typeFactory;
        this._injectableValues = objectMapper._injectableValues;
        SimpleMixInResolver copy = objectMapper._mixIns.copy();
        this._mixIns = copy;
        RootNameLookup rootNameLookup = new RootNameLookup();
        this._serializationConfig = new SerializationConfig(objectMapper._serializationConfig, copy, rootNameLookup);
        this._deserializationConfig = new DeserializationConfig(objectMapper._deserializationConfig, copy, rootNameLookup);
        this._serializerProvider = objectMapper._serializerProvider.copy();
        this._deserializationContext = objectMapper._deserializationContext.copy();
        this._serializerFactory = objectMapper._serializerFactory;
    }

    public ObjectMapper(JsonFactory jsonFactory, DefaultSerializerProvider defaultSerializerProvider, DefaultDeserializationContext defaultDeserializationContext) {
        this._rootDeserializers = new ConcurrentHashMap(64, 0.6f, 2);
        if (jsonFactory == null) {
            this._jsonFactory = new MappingJsonFactory(this);
        } else {
            this._jsonFactory = jsonFactory;
            if (jsonFactory.getCodec() == null) {
                this._jsonFactory.setCodec(this);
            }
        }
        this._subtypeResolver = new StdSubtypeResolver();
        RootNameLookup rootNameLookup = new RootNameLookup();
        this._typeFactory = TypeFactory.defaultInstance();
        SimpleMixInResolver simpleMixInResolver = new SimpleMixInResolver(null);
        this._mixIns = simpleMixInResolver;
        BaseSettings withClassIntrospector = DEFAULT_BASE.withClassIntrospector(defaultClassIntrospector());
        this._serializationConfig = new SerializationConfig(withClassIntrospector, this._subtypeResolver, simpleMixInResolver, rootNameLookup);
        this._deserializationConfig = new DeserializationConfig(withClassIntrospector, this._subtypeResolver, simpleMixInResolver, rootNameLookup);
        boolean requiresPropertyOrdering = this._jsonFactory.requiresPropertyOrdering();
        if ((this._serializationConfig.isEnabled(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY) ^ requiresPropertyOrdering) != 0) {
            configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, requiresPropertyOrdering);
        }
        if (defaultSerializerProvider == null) {
            defaultSerializerProvider = new Impl();
        }
        this._serializerProvider = defaultSerializerProvider;
        if (defaultDeserializationContext == null) {
            defaultDeserializationContext = new DefaultDeserializationContext.Impl(BeanDeserializerFactory.instance);
        }
        this._deserializationContext = defaultDeserializationContext;
        this._serializerFactory = BeanSerializerFactory.instance;
    }

    protected aiw defaultClassIntrospector() {
        return new BasicClassIntrospector();
    }

    public ObjectMapper copy() {
        _checkInvalidCopy(ObjectMapper.class);
        return new ObjectMapper(this);
    }

    protected void _checkInvalidCopy(Class<?> cls) {
        if (getClass() != cls) {
            throw new IllegalStateException("Failed copy(): " + getClass().getName() + " (version: " + version() + ") does not override copy(); it has to");
        }
    }

    protected ObjectReader _newReader(DeserializationConfig deserializationConfig) {
        return new ObjectReader(this, deserializationConfig);
    }

    protected ObjectReader _newReader(DeserializationConfig deserializationConfig, JavaType javaType, Object obj, aex com_fossil_aex, agx com_fossil_agx) {
        return new ObjectReader(this, deserializationConfig, javaType, obj, com_fossil_aex, com_fossil_agx);
    }

    protected ObjectWriter _newWriter(SerializationConfig serializationConfig) {
        return new ObjectWriter(this, serializationConfig);
    }

    protected ObjectWriter _newWriter(SerializationConfig serializationConfig, aex com_fossil_aex) {
        return new ObjectWriter(this, serializationConfig, com_fossil_aex);
    }

    protected ObjectWriter _newWriter(SerializationConfig serializationConfig, JavaType javaType, afb com_fossil_afb) {
        return new ObjectWriter(this, serializationConfig, javaType, com_fossil_afb);
    }

    public Version version() {
        return ahs.aOo;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fasterxml.jackson.databind.ObjectMapper registerModule(com.fossil.ahe r3) {
        /*
        r2 = this;
        r0 = com.fasterxml.jackson.databind.MapperFeature.IGNORE_DUPLICATE_MODULE_REGISTRATIONS;
        r0 = r2.isEnabled(r0);
        if (r0 == 0) goto L_0x0022;
    L_0x0008:
        r0 = r3.Ay();
        if (r0 == 0) goto L_0x0022;
    L_0x000e:
        r1 = r2._registeredModuleTypes;
        if (r1 != 0) goto L_0x0019;
    L_0x0012:
        r1 = new java.util.HashSet;
        r1.<init>();
        r2._registeredModuleTypes = r1;
    L_0x0019:
        r1 = r2._registeredModuleTypes;
        r0 = r1.add(r0);
        if (r0 != 0) goto L_0x0022;
    L_0x0021:
        return r2;
    L_0x0022:
        r0 = r3.DV();
        if (r0 != 0) goto L_0x0030;
    L_0x0028:
        r0 = new java.lang.IllegalArgumentException;
        r1 = "Module without defined name";
        r0.<init>(r1);
        throw r0;
    L_0x0030:
        r0 = r3.version();
        if (r0 != 0) goto L_0x003e;
    L_0x0036:
        r0 = new java.lang.IllegalArgumentException;
        r1 = "Module without defined version";
        r0.<init>(r1);
        throw r0;
    L_0x003e:
        r0 = new com.fasterxml.jackson.databind.ObjectMapper$1;
        r0.<init>(r2, r2);
        r3.m3339a(r0);
        goto L_0x0021;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ObjectMapper.registerModule(com.fossil.ahe):com.fasterxml.jackson.databind.ObjectMapper");
    }

    public ObjectMapper registerModules(ahe... com_fossil_aheArr) {
        for (ahe registerModule : com_fossil_aheArr) {
            registerModule(registerModule);
        }
        return this;
    }

    public ObjectMapper registerModules(Iterable<ahe> iterable) {
        for (ahe registerModule : iterable) {
            registerModule(registerModule);
        }
        return this;
    }

    public static List<ahe> findModules() {
        return findModules(null);
    }

    public static List<ahe> findModules(ClassLoader classLoader) {
        List arrayList = new ArrayList();
        Iterator it = (classLoader == null ? ServiceLoader.load(ahe.class) : ServiceLoader.load(ahe.class, classLoader)).iterator();
        while (it.hasNext()) {
            arrayList.add((ahe) it.next());
        }
        return arrayList;
    }

    public ObjectMapper findAndRegisterModules() {
        return registerModules(findModules());
    }

    public SerializationConfig getSerializationConfig() {
        return this._serializationConfig;
    }

    public DeserializationConfig getDeserializationConfig() {
        return this._deserializationConfig;
    }

    public DeserializationContext getDeserializationContext() {
        return this._deserializationContext;
    }

    public ObjectMapper setSerializerFactory(aln com_fossil_aln) {
        this._serializerFactory = com_fossil_aln;
        return this;
    }

    public aln getSerializerFactory() {
        return this._serializerFactory;
    }

    public ObjectMapper setSerializerProvider(DefaultSerializerProvider defaultSerializerProvider) {
        this._serializerProvider = defaultSerializerProvider;
        return this;
    }

    public ahg getSerializerProvider() {
        return this._serializerProvider;
    }

    public ObjectMapper setMixIns(Map<Class<?>, Class<?>> map) {
        this._mixIns.setLocalDefinitions(map);
        return this;
    }

    public ObjectMapper addMixIn(Class<?> cls, Class<?> cls2) {
        this._mixIns.addLocalDefinition(cls, cls2);
        return this;
    }

    public ObjectMapper setMixInResolver(C1505a c1505a) {
        SimpleMixInResolver withOverrides = this._mixIns.withOverrides(c1505a);
        if (withOverrides != this._mixIns) {
            this._mixIns = withOverrides;
            this._deserializationConfig = new DeserializationConfig(this._deserializationConfig, withOverrides);
            this._serializationConfig = new SerializationConfig(this._serializationConfig, withOverrides);
        }
        return this;
    }

    public Class<?> findMixInClassFor(Class<?> cls) {
        return this._mixIns.findMixInClassFor(cls);
    }

    public int mixInCount() {
        return this._mixIns.localSize();
    }

    @Deprecated
    public void setMixInAnnotations(Map<Class<?>, Class<?>> map) {
        setMixIns(map);
    }

    @Deprecated
    public final void addMixInAnnotations(Class<?> cls, Class<?> cls2) {
        addMixIn(cls, cls2);
    }

    public VisibilityChecker<?> getVisibilityChecker() {
        return this._serializationConfig.getDefaultVisibilityChecker();
    }

    @Deprecated
    public void setVisibilityChecker(VisibilityChecker<?> visibilityChecker) {
        setVisibility(visibilityChecker);
    }

    public ObjectMapper setVisibility(VisibilityChecker<?> visibilityChecker) {
        this._deserializationConfig = this._deserializationConfig.with((VisibilityChecker) visibilityChecker);
        this._serializationConfig = this._serializationConfig.with((VisibilityChecker) visibilityChecker);
        return this;
    }

    public ObjectMapper setVisibility(PropertyAccessor propertyAccessor, Visibility visibility) {
        this._deserializationConfig = this._deserializationConfig.withVisibility(propertyAccessor, visibility);
        this._serializationConfig = this._serializationConfig.withVisibility(propertyAccessor, visibility);
        return this;
    }

    public ajr getSubtypeResolver() {
        return this._subtypeResolver;
    }

    public ObjectMapper setSubtypeResolver(ajr com_fossil_ajr) {
        this._subtypeResolver = com_fossil_ajr;
        this._deserializationConfig = this._deserializationConfig.with(com_fossil_ajr);
        this._serializationConfig = this._serializationConfig.with(com_fossil_ajr);
        return this;
    }

    public ObjectMapper setAnnotationIntrospector(AnnotationIntrospector annotationIntrospector) {
        this._serializationConfig = this._serializationConfig.with(annotationIntrospector);
        this._deserializationConfig = this._deserializationConfig.with(annotationIntrospector);
        return this;
    }

    public ObjectMapper setAnnotationIntrospectors(AnnotationIntrospector annotationIntrospector, AnnotationIntrospector annotationIntrospector2) {
        this._serializationConfig = this._serializationConfig.with(annotationIntrospector);
        this._deserializationConfig = this._deserializationConfig.with(annotationIntrospector2);
        return this;
    }

    public ObjectMapper setPropertyNamingStrategy(PropertyNamingStrategy propertyNamingStrategy) {
        this._serializationConfig = this._serializationConfig.with(propertyNamingStrategy);
        this._deserializationConfig = this._deserializationConfig.with(propertyNamingStrategy);
        return this;
    }

    public PropertyNamingStrategy getPropertyNamingStrategy() {
        return this._serializationConfig.getPropertyNamingStrategy();
    }

    public ObjectMapper setSerializationInclusion(Include include) {
        this._serializationConfig = this._serializationConfig.withSerializationInclusion(include);
        return this;
    }

    public ObjectMapper setDefaultPrettyPrinter(afb com_fossil_afb) {
        this._serializationConfig = this._serializationConfig.withDefaultPrettyPrinter(com_fossil_afb);
        return this;
    }

    public ObjectMapper enableDefaultTyping() {
        return enableDefaultTyping(DefaultTyping.OBJECT_AND_NON_CONCRETE);
    }

    public ObjectMapper enableDefaultTyping(DefaultTyping defaultTyping) {
        return enableDefaultTyping(defaultTyping, As.WRAPPER_ARRAY);
    }

    public ObjectMapper enableDefaultTyping(DefaultTyping defaultTyping, As as) {
        if (as != As.EXTERNAL_PROPERTY) {
            return setDefaultTyping(new DefaultTypeResolverBuilder(defaultTyping).init(Id.CLASS, null).inclusion(as));
        }
        throw new IllegalArgumentException("Can not use includeAs of " + as);
    }

    public ObjectMapper enableDefaultTypingAsProperty(DefaultTyping defaultTyping, String str) {
        return setDefaultTyping(new DefaultTypeResolverBuilder(defaultTyping).init(Id.CLASS, null).inclusion(As.PROPERTY).typeProperty(str));
    }

    public ObjectMapper disableDefaultTyping() {
        return setDefaultTyping(null);
    }

    public ObjectMapper setDefaultTyping(aju<?> com_fossil_aju_) {
        this._deserializationConfig = this._deserializationConfig.with((aju) com_fossil_aju_);
        this._serializationConfig = this._serializationConfig.with((aju) com_fossil_aju_);
        return this;
    }

    public void registerSubtypes(Class<?>... clsArr) {
        getSubtypeResolver().registerSubtypes((Class[]) clsArr);
    }

    public void registerSubtypes(NamedType... namedTypeArr) {
        getSubtypeResolver().registerSubtypes(namedTypeArr);
    }

    public TypeFactory getTypeFactory() {
        return this._typeFactory;
    }

    public ObjectMapper setTypeFactory(TypeFactory typeFactory) {
        this._typeFactory = typeFactory;
        this._deserializationConfig = this._deserializationConfig.with(typeFactory);
        this._serializationConfig = this._serializationConfig.with(typeFactory);
        return this;
    }

    public JavaType constructType(Type type) {
        return this._typeFactory.constructType(type);
    }

    public JsonNodeFactory getNodeFactory() {
        return this._deserializationConfig.getNodeFactory();
    }

    public ObjectMapper setNodeFactory(JsonNodeFactory jsonNodeFactory) {
        this._deserializationConfig = this._deserializationConfig.with(jsonNodeFactory);
        return this;
    }

    public ObjectMapper addHandler(ahy com_fossil_ahy) {
        this._deserializationConfig = this._deserializationConfig.withHandler(com_fossil_ahy);
        return this;
    }

    public ObjectMapper clearProblemHandlers() {
        this._deserializationConfig = this._deserializationConfig.withNoProblemHandlers();
        return this;
    }

    public ObjectMapper setConfig(DeserializationConfig deserializationConfig) {
        this._deserializationConfig = deserializationConfig;
        return this;
    }

    @Deprecated
    public void setFilters(alh com_fossil_alh) {
        this._serializationConfig = this._serializationConfig.withFilters(com_fossil_alh);
    }

    public ObjectMapper setFilterProvider(alh com_fossil_alh) {
        this._serializationConfig = this._serializationConfig.withFilters(com_fossil_alh);
        return this;
    }

    public ObjectMapper setBase64Variant(Base64Variant base64Variant) {
        this._serializationConfig = this._serializationConfig.with(base64Variant);
        this._deserializationConfig = this._deserializationConfig.with(base64Variant);
        return this;
    }

    public ObjectMapper setConfig(SerializationConfig serializationConfig) {
        this._serializationConfig = serializationConfig;
        return this;
    }

    public JsonFactory getFactory() {
        return this._jsonFactory;
    }

    @Deprecated
    public JsonFactory getJsonFactory() {
        return getFactory();
    }

    public ObjectMapper setDateFormat(DateFormat dateFormat) {
        this._deserializationConfig = this._deserializationConfig.with(dateFormat);
        this._serializationConfig = this._serializationConfig.with(dateFormat);
        return this;
    }

    public DateFormat getDateFormat() {
        return this._serializationConfig.getDateFormat();
    }

    public Object setHandlerInstantiator(ahr com_fossil_ahr) {
        this._deserializationConfig = this._deserializationConfig.with(com_fossil_ahr);
        this._serializationConfig = this._serializationConfig.with(com_fossil_ahr);
        return this;
    }

    public ObjectMapper setInjectableValues(agx com_fossil_agx) {
        this._injectableValues = com_fossil_agx;
        return this;
    }

    public agx getInjectableValues() {
        return this._injectableValues;
    }

    public ObjectMapper setLocale(Locale locale) {
        this._deserializationConfig = this._deserializationConfig.with(locale);
        this._serializationConfig = this._serializationConfig.with(locale);
        return this;
    }

    public ObjectMapper setTimeZone(TimeZone timeZone) {
        this._deserializationConfig = this._deserializationConfig.with(timeZone);
        this._serializationConfig = this._serializationConfig.with(timeZone);
        return this;
    }

    public boolean isEnabled(MapperFeature mapperFeature) {
        return this._serializationConfig.isEnabled(mapperFeature);
    }

    public ObjectMapper configure(MapperFeature mapperFeature, boolean z) {
        SerializationConfig with;
        DeserializationConfig with2;
        if (z) {
            with = this._serializationConfig.with(mapperFeature);
        } else {
            with = this._serializationConfig.without(mapperFeature);
        }
        this._serializationConfig = with;
        if (z) {
            with2 = this._deserializationConfig.with(mapperFeature);
        } else {
            with2 = this._deserializationConfig.without(mapperFeature);
        }
        this._deserializationConfig = with2;
        return this;
    }

    public ObjectMapper enable(MapperFeature... mapperFeatureArr) {
        this._deserializationConfig = this._deserializationConfig.with(mapperFeatureArr);
        this._serializationConfig = this._serializationConfig.with(mapperFeatureArr);
        return this;
    }

    public ObjectMapper disable(MapperFeature... mapperFeatureArr) {
        this._deserializationConfig = this._deserializationConfig.without(mapperFeatureArr);
        this._serializationConfig = this._serializationConfig.without(mapperFeatureArr);
        return this;
    }

    public boolean isEnabled(SerializationFeature serializationFeature) {
        return this._serializationConfig.isEnabled(serializationFeature);
    }

    public ObjectMapper configure(SerializationFeature serializationFeature, boolean z) {
        this._serializationConfig = z ? this._serializationConfig.with(serializationFeature) : this._serializationConfig.without(serializationFeature);
        return this;
    }

    public ObjectMapper enable(SerializationFeature serializationFeature) {
        this._serializationConfig = this._serializationConfig.with(serializationFeature);
        return this;
    }

    public ObjectMapper enable(SerializationFeature serializationFeature, SerializationFeature... serializationFeatureArr) {
        this._serializationConfig = this._serializationConfig.with(serializationFeature, serializationFeatureArr);
        return this;
    }

    public ObjectMapper disable(SerializationFeature serializationFeature) {
        this._serializationConfig = this._serializationConfig.without(serializationFeature);
        return this;
    }

    public ObjectMapper disable(SerializationFeature serializationFeature, SerializationFeature... serializationFeatureArr) {
        this._serializationConfig = this._serializationConfig.without(serializationFeature, serializationFeatureArr);
        return this;
    }

    public boolean isEnabled(DeserializationFeature deserializationFeature) {
        return this._deserializationConfig.isEnabled(deserializationFeature);
    }

    public ObjectMapper configure(DeserializationFeature deserializationFeature, boolean z) {
        this._deserializationConfig = z ? this._deserializationConfig.with(deserializationFeature) : this._deserializationConfig.without(deserializationFeature);
        return this;
    }

    public ObjectMapper enable(DeserializationFeature deserializationFeature) {
        this._deserializationConfig = this._deserializationConfig.with(deserializationFeature);
        return this;
    }

    public ObjectMapper enable(DeserializationFeature deserializationFeature, DeserializationFeature... deserializationFeatureArr) {
        this._deserializationConfig = this._deserializationConfig.with(deserializationFeature, deserializationFeatureArr);
        return this;
    }

    public ObjectMapper disable(DeserializationFeature deserializationFeature) {
        this._deserializationConfig = this._deserializationConfig.without(deserializationFeature);
        return this;
    }

    public ObjectMapper disable(DeserializationFeature deserializationFeature, DeserializationFeature... deserializationFeatureArr) {
        this._deserializationConfig = this._deserializationConfig.without(deserializationFeature, deserializationFeatureArr);
        return this;
    }

    public boolean isEnabled(Feature feature) {
        return this._deserializationConfig.isEnabled(feature, this._jsonFactory);
    }

    public ObjectMapper configure(Feature feature, boolean z) {
        this._jsonFactory.configure(feature, z);
        return this;
    }

    public ObjectMapper enable(Feature... featureArr) {
        for (Feature enable : featureArr) {
            this._jsonFactory.enable(enable);
        }
        return this;
    }

    public ObjectMapper disable(Feature... featureArr) {
        for (Feature disable : featureArr) {
            this._jsonFactory.disable(disable);
        }
        return this;
    }

    public boolean isEnabled(JsonGenerator.Feature feature) {
        return this._serializationConfig.isEnabled(feature, this._jsonFactory);
    }

    public ObjectMapper configure(JsonGenerator.Feature feature, boolean z) {
        this._jsonFactory.configure(feature, z);
        return this;
    }

    public ObjectMapper enable(JsonGenerator.Feature... featureArr) {
        for (JsonGenerator.Feature enable : featureArr) {
            this._jsonFactory.enable(enable);
        }
        return this;
    }

    public ObjectMapper disable(JsonGenerator.Feature... featureArr) {
        for (JsonGenerator.Feature disable : featureArr) {
            this._jsonFactory.disable(disable);
        }
        return this;
    }

    public boolean isEnabled(JsonFactory.Feature feature) {
        return this._jsonFactory.isEnabled(feature);
    }

    public <T> T readValue(JsonParser jsonParser, Class<T> cls) throws IOException, JsonParseException, JsonMappingException {
        return _readValue(getDeserializationConfig(), jsonParser, this._typeFactory.constructType((Type) cls));
    }

    public <T> T readValue(JsonParser jsonParser, agl<?> com_fossil_agl_) throws IOException, JsonParseException, JsonMappingException {
        return _readValue(getDeserializationConfig(), jsonParser, this._typeFactory.constructType((agl) com_fossil_agl_));
    }

    public final <T> T readValue(JsonParser jsonParser, agk com_fossil_agk) throws IOException, JsonParseException, JsonMappingException {
        return _readValue(getDeserializationConfig(), jsonParser, (JavaType) com_fossil_agk);
    }

    public <T> T readValue(JsonParser jsonParser, JavaType javaType) throws IOException, JsonParseException, JsonMappingException {
        return _readValue(getDeserializationConfig(), jsonParser, javaType);
    }

    public <T extends afe> T readTree(JsonParser jsonParser) throws IOException, JsonProcessingException {
        DeserializationConfig deserializationConfig = getDeserializationConfig();
        if (jsonParser.zU() == null && jsonParser.zP() == null) {
            return null;
        }
        agz com_fossil_agz = (agz) _readValue(deserializationConfig, jsonParser, aQp);
        if (com_fossil_agz == null) {
            return getNodeFactory().nullNode();
        }
        return com_fossil_agz;
    }

    public <T> ahd<T> readValues(JsonParser jsonParser, agk com_fossil_agk) throws IOException, JsonProcessingException {
        return readValues(jsonParser, (JavaType) com_fossil_agk);
    }

    public <T> ahd<T> readValues(JsonParser jsonParser, JavaType javaType) throws IOException, JsonProcessingException {
        DeserializationContext createDeserializationContext = createDeserializationContext(jsonParser, getDeserializationConfig());
        return new ahd(javaType, jsonParser, createDeserializationContext, _findRootDeserializer(createDeserializationContext, javaType), false, null);
    }

    public <T> ahd<T> readValues(JsonParser jsonParser, Class<T> cls) throws IOException, JsonProcessingException {
        return readValues(jsonParser, this._typeFactory.constructType((Type) cls));
    }

    public <T> ahd<T> readValues(JsonParser jsonParser, agl<?> com_fossil_agl_) throws IOException, JsonProcessingException {
        return readValues(jsonParser, this._typeFactory.constructType((agl) com_fossil_agl_));
    }

    public agz readTree(InputStream inputStream) throws IOException, JsonProcessingException {
        agz com_fossil_agz = (agz) _readMapAndClose(this._jsonFactory.createParser(inputStream), aQp);
        return com_fossil_agz == null ? akt.aTX : com_fossil_agz;
    }

    public agz readTree(Reader reader) throws IOException, JsonProcessingException {
        agz com_fossil_agz = (agz) _readMapAndClose(this._jsonFactory.createParser(reader), aQp);
        return com_fossil_agz == null ? akt.aTX : com_fossil_agz;
    }

    public agz readTree(String str) throws IOException, JsonProcessingException {
        agz com_fossil_agz = (agz) _readMapAndClose(this._jsonFactory.createParser(str), aQp);
        return com_fossil_agz == null ? akt.aTX : com_fossil_agz;
    }

    public agz readTree(byte[] bArr) throws IOException, JsonProcessingException {
        agz com_fossil_agz = (agz) _readMapAndClose(this._jsonFactory.createParser(bArr), aQp);
        return com_fossil_agz == null ? akt.aTX : com_fossil_agz;
    }

    public agz readTree(File file) throws IOException, JsonProcessingException {
        agz com_fossil_agz = (agz) _readMapAndClose(this._jsonFactory.createParser(file), aQp);
        return com_fossil_agz == null ? akt.aTX : com_fossil_agz;
    }

    public agz readTree(URL url) throws IOException, JsonProcessingException {
        agz com_fossil_agz = (agz) _readMapAndClose(this._jsonFactory.createParser(url), aQp);
        return com_fossil_agz == null ? akt.aTX : com_fossil_agz;
    }

    public void writeValue(JsonGenerator jsonGenerator, Object obj) throws IOException, JsonGenerationException, JsonMappingException {
        SerializationConfig serializationConfig = getSerializationConfig();
        if (serializationConfig.isEnabled(SerializationFeature.INDENT_OUTPUT) && jsonGenerator.zC() == null) {
            jsonGenerator.m2664a(serializationConfig.constructDefaultPrettyPrinter());
        }
        if (serializationConfig.isEnabled(SerializationFeature.CLOSE_CLOSEABLE) && (obj instanceof Closeable)) {
            m2691b(jsonGenerator, obj, serializationConfig);
            return;
        }
        _serializerProvider(serializationConfig).serializeValue(jsonGenerator, obj);
        if (serializationConfig.isEnabled(SerializationFeature.FLUSH_AFTER_WRITE_VALUE)) {
            jsonGenerator.flush();
        }
    }

    public void writeTree(JsonGenerator jsonGenerator, afe com_fossil_afe) throws IOException, JsonProcessingException {
        SerializationConfig serializationConfig = getSerializationConfig();
        _serializerProvider(serializationConfig).serializeValue(jsonGenerator, com_fossil_afe);
        if (serializationConfig.isEnabled(SerializationFeature.FLUSH_AFTER_WRITE_VALUE)) {
            jsonGenerator.flush();
        }
    }

    public void writeTree(JsonGenerator jsonGenerator, agz com_fossil_agz) throws IOException, JsonProcessingException {
        SerializationConfig serializationConfig = getSerializationConfig();
        _serializerProvider(serializationConfig).serializeValue(jsonGenerator, com_fossil_agz);
        if (serializationConfig.isEnabled(SerializationFeature.FLUSH_AFTER_WRITE_VALUE)) {
            jsonGenerator.flush();
        }
    }

    public akv createObjectNode() {
        return this._deserializationConfig.getNodeFactory().objectNode();
    }

    public akh createArrayNode() {
        return this._deserializationConfig.getNodeFactory().arrayNode();
    }

    public JsonParser treeAsTokens(afe com_fossil_afe) {
        return new akz((agz) com_fossil_afe, this);
    }

    public <T> T treeToValue(afe com_fossil_afe, Class<T> cls) throws JsonProcessingException {
        try {
            if (cls == Object.class || !cls.isAssignableFrom(com_fossil_afe.getClass())) {
                com_fossil_afe = readValue(treeAsTokens(com_fossil_afe), (Class) cls);
            }
            return com_fossil_afe;
        } catch (JsonProcessingException e) {
            throw e;
        } catch (Throwable e2) {
            throw new IllegalArgumentException(e2.getMessage(), e2);
        }
    }

    public <T extends agz> T valueToTree(Object obj) throws IllegalArgumentException {
        if (obj == null) {
            return null;
        }
        JsonGenerator com_fossil_amt = new amt(this, false);
        try {
            writeValue(com_fossil_amt, obj);
            JsonParser Hu = com_fossil_amt.Hu();
            agz com_fossil_agz = (agz) readTree(Hu);
            Hu.close();
            return com_fossil_agz;
        } catch (Throwable e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    public boolean canSerialize(Class<?> cls) {
        return _serializerProvider(getSerializationConfig()).hasSerializerFor(cls, null);
    }

    public boolean canSerialize(Class<?> cls, AtomicReference<Throwable> atomicReference) {
        return _serializerProvider(getSerializationConfig()).hasSerializerFor(cls, atomicReference);
    }

    public boolean canDeserialize(JavaType javaType) {
        return createDeserializationContext(null, getDeserializationConfig()).hasValueDeserializerFor(javaType, null);
    }

    public boolean canDeserialize(JavaType javaType, AtomicReference<Throwable> atomicReference) {
        return createDeserializationContext(null, getDeserializationConfig()).hasValueDeserializerFor(javaType, atomicReference);
    }

    public <T> T readValue(File file, Class<T> cls) throws IOException, JsonParseException, JsonMappingException {
        return _readMapAndClose(this._jsonFactory.createParser(file), this._typeFactory.constructType((Type) cls));
    }

    public <T> T readValue(File file, agl com_fossil_agl) throws IOException, JsonParseException, JsonMappingException {
        return _readMapAndClose(this._jsonFactory.createParser(file), this._typeFactory.constructType(com_fossil_agl));
    }

    public <T> T readValue(File file, JavaType javaType) throws IOException, JsonParseException, JsonMappingException {
        return _readMapAndClose(this._jsonFactory.createParser(file), javaType);
    }

    public <T> T readValue(URL url, Class<T> cls) throws IOException, JsonParseException, JsonMappingException {
        return _readMapAndClose(this._jsonFactory.createParser(url), this._typeFactory.constructType((Type) cls));
    }

    public <T> T readValue(URL url, agl com_fossil_agl) throws IOException, JsonParseException, JsonMappingException {
        return _readMapAndClose(this._jsonFactory.createParser(url), this._typeFactory.constructType(com_fossil_agl));
    }

    public <T> T readValue(URL url, JavaType javaType) throws IOException, JsonParseException, JsonMappingException {
        return _readMapAndClose(this._jsonFactory.createParser(url), javaType);
    }

    public <T> T readValue(String str, Class<T> cls) throws IOException, JsonParseException, JsonMappingException {
        return _readMapAndClose(this._jsonFactory.createParser(str), this._typeFactory.constructType((Type) cls));
    }

    public <T> T readValue(String str, agl com_fossil_agl) throws IOException, JsonParseException, JsonMappingException {
        return _readMapAndClose(this._jsonFactory.createParser(str), this._typeFactory.constructType(com_fossil_agl));
    }

    public <T> T readValue(String str, JavaType javaType) throws IOException, JsonParseException, JsonMappingException {
        return _readMapAndClose(this._jsonFactory.createParser(str), javaType);
    }

    public <T> T readValue(Reader reader, Class<T> cls) throws IOException, JsonParseException, JsonMappingException {
        return _readMapAndClose(this._jsonFactory.createParser(reader), this._typeFactory.constructType((Type) cls));
    }

    public <T> T readValue(Reader reader, agl com_fossil_agl) throws IOException, JsonParseException, JsonMappingException {
        return _readMapAndClose(this._jsonFactory.createParser(reader), this._typeFactory.constructType(com_fossil_agl));
    }

    public <T> T readValue(Reader reader, JavaType javaType) throws IOException, JsonParseException, JsonMappingException {
        return _readMapAndClose(this._jsonFactory.createParser(reader), javaType);
    }

    public <T> T readValue(InputStream inputStream, Class<T> cls) throws IOException, JsonParseException, JsonMappingException {
        return _readMapAndClose(this._jsonFactory.createParser(inputStream), this._typeFactory.constructType((Type) cls));
    }

    public <T> T readValue(InputStream inputStream, agl com_fossil_agl) throws IOException, JsonParseException, JsonMappingException {
        return _readMapAndClose(this._jsonFactory.createParser(inputStream), this._typeFactory.constructType(com_fossil_agl));
    }

    public <T> T readValue(InputStream inputStream, JavaType javaType) throws IOException, JsonParseException, JsonMappingException {
        return _readMapAndClose(this._jsonFactory.createParser(inputStream), javaType);
    }

    public <T> T readValue(byte[] bArr, Class<T> cls) throws IOException, JsonParseException, JsonMappingException {
        return _readMapAndClose(this._jsonFactory.createParser(bArr), this._typeFactory.constructType((Type) cls));
    }

    public <T> T readValue(byte[] bArr, int i, int i2, Class<T> cls) throws IOException, JsonParseException, JsonMappingException {
        return _readMapAndClose(this._jsonFactory.createParser(bArr, i, i2), this._typeFactory.constructType((Type) cls));
    }

    public <T> T readValue(byte[] bArr, agl com_fossil_agl) throws IOException, JsonParseException, JsonMappingException {
        return _readMapAndClose(this._jsonFactory.createParser(bArr), this._typeFactory.constructType(com_fossil_agl));
    }

    public <T> T readValue(byte[] bArr, int i, int i2, agl com_fossil_agl) throws IOException, JsonParseException, JsonMappingException {
        return _readMapAndClose(this._jsonFactory.createParser(bArr, i, i2), this._typeFactory.constructType(com_fossil_agl));
    }

    public <T> T readValue(byte[] bArr, JavaType javaType) throws IOException, JsonParseException, JsonMappingException {
        return _readMapAndClose(this._jsonFactory.createParser(bArr), javaType);
    }

    public <T> T readValue(byte[] bArr, int i, int i2, JavaType javaType) throws IOException, JsonParseException, JsonMappingException {
        return _readMapAndClose(this._jsonFactory.createParser(bArr, i, i2), javaType);
    }

    public void writeValue(File file, Object obj) throws IOException, JsonGenerationException, JsonMappingException {
        _configAndWriteValue(this._jsonFactory.createGenerator(file, JsonEncoding.UTF8), obj);
    }

    public void writeValue(OutputStream outputStream, Object obj) throws IOException, JsonGenerationException, JsonMappingException {
        _configAndWriteValue(this._jsonFactory.createGenerator(outputStream, JsonEncoding.UTF8), obj);
    }

    public void writeValue(Writer writer, Object obj) throws IOException, JsonGenerationException, JsonMappingException {
        _configAndWriteValue(this._jsonFactory.createGenerator(writer), obj);
    }

    public String writeValueAsString(Object obj) throws JsonProcessingException {
        Writer com_fossil_aft = new aft(this._jsonFactory._getBufferRecycler());
        try {
            _configAndWriteValue(this._jsonFactory.createGenerator(com_fossil_aft), obj);
            return com_fossil_aft.BJ();
        } catch (JsonProcessingException e) {
            throw e;
        } catch (IOException e2) {
            throw JsonMappingException.fromUnexpectedIOE(e2);
        }
    }

    public byte[] writeValueAsBytes(Object obj) throws JsonProcessingException {
        OutputStream com_fossil_agn = new agn(this._jsonFactory._getBufferRecycler());
        try {
            _configAndWriteValue(this._jsonFactory.createGenerator(com_fossil_agn, JsonEncoding.UTF8), obj);
            byte[] toByteArray = com_fossil_agn.toByteArray();
            com_fossil_agn.release();
            return toByteArray;
        } catch (JsonProcessingException e) {
            throw e;
        } catch (IOException e2) {
            throw JsonMappingException.fromUnexpectedIOE(e2);
        }
    }

    public ObjectWriter writer() {
        return _newWriter(getSerializationConfig());
    }

    public ObjectWriter writer(SerializationFeature serializationFeature) {
        return _newWriter(getSerializationConfig().with(serializationFeature));
    }

    public ObjectWriter writer(SerializationFeature serializationFeature, SerializationFeature... serializationFeatureArr) {
        return _newWriter(getSerializationConfig().with(serializationFeature, serializationFeatureArr));
    }

    public ObjectWriter writer(DateFormat dateFormat) {
        return _newWriter(getSerializationConfig().with(dateFormat));
    }

    public ObjectWriter writerWithView(Class<?> cls) {
        return _newWriter(getSerializationConfig().withView((Class) cls));
    }

    public ObjectWriter writerFor(Class<?> cls) {
        return _newWriter(getSerializationConfig(), cls == null ? null : this._typeFactory.constructType((Type) cls), null);
    }

    public ObjectWriter writerFor(agl<?> com_fossil_agl_) {
        return _newWriter(getSerializationConfig(), com_fossil_agl_ == null ? null : this._typeFactory.constructType((agl) com_fossil_agl_), null);
    }

    public ObjectWriter writerFor(JavaType javaType) {
        return _newWriter(getSerializationConfig(), javaType, null);
    }

    public ObjectWriter writer(afb com_fossil_afb) {
        if (com_fossil_afb == null) {
            com_fossil_afb = ObjectWriter.NULL_PRETTY_PRINTER;
        }
        return _newWriter(getSerializationConfig(), null, com_fossil_afb);
    }

    public ObjectWriter writerWithDefaultPrettyPrinter() {
        SerializationConfig serializationConfig = getSerializationConfig();
        return _newWriter(serializationConfig, null, serializationConfig.getDefaultPrettyPrinter());
    }

    public ObjectWriter writer(alh com_fossil_alh) {
        return _newWriter(getSerializationConfig().withFilters(com_fossil_alh));
    }

    public ObjectWriter writer(aex com_fossil_aex) {
        _verifySchemaType(com_fossil_aex);
        return _newWriter(getSerializationConfig(), com_fossil_aex);
    }

    public ObjectWriter writer(Base64Variant base64Variant) {
        return _newWriter(getSerializationConfig().with(base64Variant));
    }

    public ObjectWriter writer(CharacterEscapes characterEscapes) {
        return _newWriter(getSerializationConfig()).with(characterEscapes);
    }

    public ObjectWriter writer(ContextAttributes contextAttributes) {
        return _newWriter(getSerializationConfig().with(contextAttributes));
    }

    @Deprecated
    public ObjectWriter writerWithType(Class<?> cls) {
        return _newWriter(getSerializationConfig(), cls == null ? null : this._typeFactory.constructType((Type) cls), null);
    }

    @Deprecated
    public ObjectWriter writerWithType(agl<?> com_fossil_agl_) {
        return _newWriter(getSerializationConfig(), com_fossil_agl_ == null ? null : this._typeFactory.constructType((agl) com_fossil_agl_), null);
    }

    @Deprecated
    public ObjectWriter writerWithType(JavaType javaType) {
        return _newWriter(getSerializationConfig(), javaType, null);
    }

    public ObjectReader reader() {
        return _newReader(getDeserializationConfig()).with(this._injectableValues);
    }

    public ObjectReader reader(DeserializationFeature deserializationFeature) {
        return _newReader(getDeserializationConfig().with(deserializationFeature));
    }

    public ObjectReader reader(DeserializationFeature deserializationFeature, DeserializationFeature... deserializationFeatureArr) {
        return _newReader(getDeserializationConfig().with(deserializationFeature, deserializationFeatureArr));
    }

    public ObjectReader readerForUpdating(Object obj) {
        return _newReader(getDeserializationConfig(), this._typeFactory.constructType(obj.getClass()), obj, null, this._injectableValues);
    }

    public ObjectReader readerFor(JavaType javaType) {
        return _newReader(getDeserializationConfig(), javaType, null, null, this._injectableValues);
    }

    public ObjectReader readerFor(Class<?> cls) {
        return _newReader(getDeserializationConfig(), this._typeFactory.constructType((Type) cls), null, null, this._injectableValues);
    }

    public ObjectReader readerFor(agl<?> com_fossil_agl_) {
        return _newReader(getDeserializationConfig(), this._typeFactory.constructType((agl) com_fossil_agl_), null, null, this._injectableValues);
    }

    public ObjectReader reader(JsonNodeFactory jsonNodeFactory) {
        return _newReader(getDeserializationConfig()).with(jsonNodeFactory);
    }

    public ObjectReader reader(aex com_fossil_aex) {
        _verifySchemaType(com_fossil_aex);
        return _newReader(getDeserializationConfig(), null, null, com_fossil_aex, this._injectableValues);
    }

    public ObjectReader reader(agx com_fossil_agx) {
        return _newReader(getDeserializationConfig(), null, null, null, com_fossil_agx);
    }

    public ObjectReader readerWithView(Class<?> cls) {
        return _newReader(getDeserializationConfig().withView((Class) cls));
    }

    public ObjectReader reader(Base64Variant base64Variant) {
        return _newReader(getDeserializationConfig().with(base64Variant));
    }

    public ObjectReader reader(ContextAttributes contextAttributes) {
        return _newReader(getDeserializationConfig().with(contextAttributes));
    }

    @Deprecated
    public ObjectReader reader(JavaType javaType) {
        return _newReader(getDeserializationConfig(), javaType, null, null, this._injectableValues);
    }

    @Deprecated
    public ObjectReader reader(Class<?> cls) {
        return _newReader(getDeserializationConfig(), this._typeFactory.constructType((Type) cls), null, null, this._injectableValues);
    }

    @Deprecated
    public ObjectReader reader(agl<?> com_fossil_agl_) {
        return _newReader(getDeserializationConfig(), this._typeFactory.constructType((agl) com_fossil_agl_), null, null, this._injectableValues);
    }

    public <T> T convertValue(Object obj, Class<T> cls) throws IllegalArgumentException {
        if (obj == null) {
            return null;
        }
        return _convert(obj, this._typeFactory.constructType((Type) cls));
    }

    public <T> T convertValue(Object obj, agl<?> com_fossil_agl_) throws IllegalArgumentException {
        return convertValue(obj, this._typeFactory.constructType((agl) com_fossil_agl_));
    }

    public <T> T convertValue(Object obj, JavaType javaType) throws IllegalArgumentException {
        if (obj == null) {
            return null;
        }
        return _convert(obj, javaType);
    }

    protected Object _convert(Object obj, JavaType javaType) throws IllegalArgumentException {
        Class rawClass = javaType.getRawClass();
        if (rawClass == Object.class || javaType.hasGenericTypes() || !rawClass.isAssignableFrom(obj.getClass())) {
            JsonGenerator com_fossil_amt = new amt(this, false);
            try {
                _serializerProvider(getSerializationConfig().without(SerializationFeature.WRAP_ROOT_VALUE)).serializeValue(com_fossil_amt, obj);
                JsonParser Hu = com_fossil_amt.Hu();
                DeserializationConfig deserializationConfig = getDeserializationConfig();
                JsonToken _initForReading = _initForReading(Hu);
                DeserializationContext createDeserializationContext;
                if (_initForReading == JsonToken.VALUE_NULL) {
                    createDeserializationContext = createDeserializationContext(Hu, deserializationConfig);
                    obj = _findRootDeserializer(createDeserializationContext, javaType).getNullValue(createDeserializationContext);
                } else if (_initForReading == JsonToken.END_ARRAY || _initForReading == JsonToken.END_OBJECT) {
                    obj = null;
                } else {
                    createDeserializationContext = createDeserializationContext(Hu, deserializationConfig);
                    obj = _findRootDeserializer(createDeserializationContext, javaType).deserialize(Hu, createDeserializationContext);
                }
                Hu.close();
            } catch (Throwable e) {
                throw new IllegalArgumentException(e.getMessage(), e);
            }
        }
        return obj;
    }

    @Deprecated
    public ajo generateJsonSchema(Class<?> cls) throws JsonMappingException {
        return _serializerProvider(getSerializationConfig()).generateJsonSchema(cls);
    }

    public void acceptJsonFormatVisitor(Class<?> cls, ajg com_fossil_ajg) throws JsonMappingException {
        acceptJsonFormatVisitor(this._typeFactory.constructType((Type) cls), com_fossil_ajg);
    }

    public void acceptJsonFormatVisitor(JavaType javaType, ajg com_fossil_ajg) throws JsonMappingException {
        if (javaType == null) {
            throw new IllegalArgumentException("type must be provided");
        }
        _serializerProvider(getSerializationConfig()).acceptJsonFormatVisitor(javaType, com_fossil_ajg);
    }

    protected DefaultSerializerProvider _serializerProvider(SerializationConfig serializationConfig) {
        return this._serializerProvider.createInstance(serializationConfig, this._serializerFactory);
    }

    @Deprecated
    protected afb _defaultPrettyPrinter() {
        return this._serializationConfig.constructDefaultPrettyPrinter();
    }

    protected final void _configAndWriteValue(JsonGenerator jsonGenerator, Object obj) throws IOException {
        SerializationConfig serializationConfig = getSerializationConfig();
        serializationConfig.initialize(jsonGenerator);
        if (serializationConfig.isEnabled(SerializationFeature.CLOSE_CLOSEABLE) && (obj instanceof Closeable)) {
            m2690a(jsonGenerator, obj, serializationConfig);
            return;
        }
        Object obj2 = null;
        try {
            _serializerProvider(serializationConfig).serializeValue(jsonGenerator, obj);
            obj2 = 1;
            jsonGenerator.close();
        } catch (Throwable th) {
            if (obj2 == null) {
                jsonGenerator.mo848a(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT);
                try {
                    jsonGenerator.close();
                } catch (IOException e) {
                }
            }
        }
    }

    protected final void _configAndWriteValue(JsonGenerator jsonGenerator, Object obj, Class<?> cls) throws IOException {
        SerializationConfig withView = getSerializationConfig().withView((Class) cls);
        withView.initialize(jsonGenerator);
        if (withView.isEnabled(SerializationFeature.CLOSE_CLOSEABLE) && (obj instanceof Closeable)) {
            m2690a(jsonGenerator, obj, withView);
            return;
        }
        Object obj2 = null;
        try {
            _serializerProvider(withView).serializeValue(jsonGenerator, obj);
            obj2 = 1;
            jsonGenerator.close();
        } catch (Throwable th) {
            if (obj2 == null) {
                jsonGenerator.mo848a(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT);
                try {
                    jsonGenerator.close();
                } catch (IOException e) {
                }
            }
        }
    }

    private final void m2690a(JsonGenerator jsonGenerator, Object obj, SerializationConfig serializationConfig) throws IOException, JsonGenerationException, JsonMappingException {
        Closeable closeable;
        Throwable th;
        JsonGenerator jsonGenerator2 = null;
        Closeable closeable2 = (Closeable) obj;
        try {
            Closeable closeable3;
            _serializerProvider(serializationConfig).serializeValue(jsonGenerator, obj);
            JsonGenerator jsonGenerator3 = null;
            try {
                jsonGenerator.close();
                closeable3 = null;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                closeable = closeable2;
                th = th3;
                if (jsonGenerator2 != null) {
                    jsonGenerator2.mo848a(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT);
                    try {
                        jsonGenerator2.close();
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
                    jsonGenerator2.mo848a(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT);
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
            } catch (Throwable th4) {
                th = th4;
                Object obj2 = jsonGenerator2;
                if (jsonGenerator2 != null) {
                    jsonGenerator2.mo848a(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT);
                    jsonGenerator2.close();
                }
                if (closeable != null) {
                    closeable.close();
                }
                throw th;
            }
        } catch (Throwable th22) {
            jsonGenerator2 = jsonGenerator;
            Closeable closeable4 = closeable2;
            th = th22;
            closeable = closeable4;
            if (jsonGenerator2 != null) {
                jsonGenerator2.mo848a(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT);
                jsonGenerator2.close();
            }
            if (closeable != null) {
                closeable.close();
            }
            throw th;
        }
    }

    private final void m2691b(JsonGenerator jsonGenerator, Object obj, SerializationConfig serializationConfig) throws IOException, JsonGenerationException, JsonMappingException {
        Closeable closeable;
        Throwable th;
        Closeable closeable2 = (Closeable) obj;
        try {
            _serializerProvider(serializationConfig).serializeValue(jsonGenerator, obj);
            if (serializationConfig.isEnabled(SerializationFeature.FLUSH_AFTER_WRITE_VALUE)) {
                jsonGenerator.flush();
            }
            closeable = null;
            try {
                closeable2.close();
                if (closeable != null) {
                    try {
                        closeable.close();
                    } catch (IOException e) {
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (closeable != null) {
                    try {
                        closeable.close();
                    } catch (IOException e2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            closeable = closeable2;
            th = th4;
            if (closeable != null) {
                closeable.close();
            }
            throw th;
        }
    }

    protected DefaultDeserializationContext createDeserializationContext(JsonParser jsonParser, DeserializationConfig deserializationConfig) {
        return this._deserializationContext.createInstance(deserializationConfig, jsonParser, this._injectableValues);
    }

    protected Object _readValue(DeserializationConfig deserializationConfig, JsonParser jsonParser, JavaType javaType) throws IOException, JsonParseException, JsonMappingException {
        Object nullValue;
        JsonToken _initForReading = _initForReading(jsonParser);
        if (_initForReading == JsonToken.VALUE_NULL) {
            DeserializationContext createDeserializationContext = createDeserializationContext(jsonParser, deserializationConfig);
            nullValue = _findRootDeserializer(createDeserializationContext, javaType).getNullValue(createDeserializationContext);
        } else if (_initForReading == JsonToken.END_ARRAY || _initForReading == JsonToken.END_OBJECT) {
            nullValue = null;
        } else {
            DeserializationContext createDeserializationContext2 = createDeserializationContext(jsonParser, deserializationConfig);
            agy _findRootDeserializer = _findRootDeserializer(createDeserializationContext2, javaType);
            if (deserializationConfig.useRootWrapping()) {
                nullValue = _unwrapAndDeserialize(jsonParser, createDeserializationContext2, deserializationConfig, javaType, _findRootDeserializer);
            } else {
                nullValue = _findRootDeserializer.deserialize(jsonParser, createDeserializationContext2);
            }
        }
        jsonParser.Ac();
        return nullValue;
    }

    protected Object _readMapAndClose(JsonParser jsonParser, JavaType javaType) throws IOException, JsonParseException, JsonMappingException {
        try {
            Object nullValue;
            JsonToken _initForReading = _initForReading(jsonParser);
            if (_initForReading == JsonToken.VALUE_NULL) {
                DeserializationContext createDeserializationContext = createDeserializationContext(jsonParser, getDeserializationConfig());
                nullValue = _findRootDeserializer(createDeserializationContext, javaType).getNullValue(createDeserializationContext);
            } else if (_initForReading == JsonToken.END_ARRAY || _initForReading == JsonToken.END_OBJECT) {
                nullValue = null;
            } else {
                DeserializationConfig deserializationConfig = getDeserializationConfig();
                DeserializationContext createDeserializationContext2 = createDeserializationContext(jsonParser, deserializationConfig);
                agy _findRootDeserializer = _findRootDeserializer(createDeserializationContext2, javaType);
                if (deserializationConfig.useRootWrapping()) {
                    nullValue = _unwrapAndDeserialize(jsonParser, createDeserializationContext2, deserializationConfig, javaType, _findRootDeserializer);
                } else {
                    nullValue = _findRootDeserializer.deserialize(jsonParser, createDeserializationContext2);
                }
                createDeserializationContext2.checkUnresolvedObjectId();
            }
            jsonParser.Ac();
            return nullValue;
        } finally {
            try {
                jsonParser.close();
            } catch (IOException e) {
            }
        }
    }

    protected JsonToken _initForReading(JsonParser jsonParser) throws IOException {
        this._deserializationConfig.initialize(jsonParser);
        JsonToken zU = jsonParser.zU();
        if (zU == null) {
            zU = jsonParser.zP();
            if (zU == null) {
                throw JsonMappingException.from(jsonParser, "No content to map due to end-of-input");
            }
        }
        return zU;
    }

    protected Object _unwrapAndDeserialize(JsonParser jsonParser, DeserializationContext deserializationContext, DeserializationConfig deserializationConfig, JavaType javaType, agy<Object> com_fossil_agy_java_lang_Object) throws IOException {
        String simpleName = deserializationConfig.findRootName(javaType).getSimpleName();
        if (jsonParser.zU() != JsonToken.START_OBJECT) {
            throw JsonMappingException.from(jsonParser, "Current token not START_OBJECT (needed to unwrap root name '" + simpleName + "'), but " + jsonParser.zU());
        } else if (jsonParser.zP() != JsonToken.FIELD_NAME) {
            throw JsonMappingException.from(jsonParser, "Current token not FIELD_NAME (to contain expected root name '" + simpleName + "'), but " + jsonParser.zU());
        } else {
            String zW = jsonParser.zW();
            if (simpleName.equals(zW)) {
                jsonParser.zP();
                Object deserialize = com_fossil_agy_java_lang_Object.deserialize(jsonParser, deserializationContext);
                if (jsonParser.zP() == JsonToken.END_OBJECT) {
                    return deserialize;
                }
                throw JsonMappingException.from(jsonParser, "Current token not END_OBJECT (to match wrapper object with root name '" + simpleName + "'), but " + jsonParser.zU());
            }
            throw JsonMappingException.from(jsonParser, "Root name '" + zW + "' does not match expected ('" + simpleName + "') for type " + javaType);
        }
    }

    protected agy<Object> _findRootDeserializer(DeserializationContext deserializationContext, JavaType javaType) throws JsonMappingException {
        agy<Object> com_fossil_agy_java_lang_Object = (agy) this._rootDeserializers.get(javaType);
        if (com_fossil_agy_java_lang_Object == null) {
            com_fossil_agy_java_lang_Object = deserializationContext.findRootValueDeserializer(javaType);
            if (com_fossil_agy_java_lang_Object == null) {
                throw new JsonMappingException("Can not find a deserializer for type " + javaType);
            }
            this._rootDeserializers.put(javaType, com_fossil_agy_java_lang_Object);
        }
        return com_fossil_agy_java_lang_Object;
    }

    protected void _verifySchemaType(aex com_fossil_aex) {
        if (com_fossil_aex != null && !this._jsonFactory.canUseSchema(com_fossil_aex)) {
            throw new IllegalArgumentException("Can not use FormatSchema of type " + com_fossil_aex.getClass().getName() + " for format " + this._jsonFactory.getFormatName());
        }
    }
}
