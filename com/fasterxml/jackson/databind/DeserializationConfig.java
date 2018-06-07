package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.cfg.BaseSettings;
import com.fasterxml.jackson.databind.cfg.ContextAttributes;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.cfg.MapperConfigBase;
import com.fasterxml.jackson.databind.introspect.NopAnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.SimpleMixInResolver;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.RootNameLookup;
import com.fossil.agu;
import com.fossil.ahr;
import com.fossil.ahy;
import com.fossil.air;
import com.fossil.aiw;
import com.fossil.ajr;
import com.fossil.ajs;
import com.fossil.aju;
import com.fossil.amn;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Collection;
import java.util.Locale;
import java.util.TimeZone;

public final class DeserializationConfig extends MapperConfigBase<DeserializationFeature, DeserializationConfig> implements Serializable {
    private static final long serialVersionUID = 1;
    protected final int _deserFeatures;
    protected final JsonNodeFactory _nodeFactory;
    protected final int _parserFeatures;
    protected final int _parserFeaturesToChange;
    protected final amn<ahy> _problemHandlers;

    public DeserializationConfig(BaseSettings baseSettings, ajr com_fossil_ajr, SimpleMixInResolver simpleMixInResolver, RootNameLookup rootNameLookup) {
        super(baseSettings, com_fossil_ajr, simpleMixInResolver, rootNameLookup);
        this._deserFeatures = MapperConfig.collectFeatureDefaults(DeserializationFeature.class);
        this._nodeFactory = JsonNodeFactory.instance;
        this._problemHandlers = null;
        this._parserFeatures = 0;
        this._parserFeaturesToChange = 0;
    }

    private DeserializationConfig(DeserializationConfig deserializationConfig, int i, int i2, int i3, int i4) {
        super((MapperConfigBase) deserializationConfig, i);
        this._deserFeatures = i2;
        this._nodeFactory = deserializationConfig._nodeFactory;
        this._problemHandlers = deserializationConfig._problemHandlers;
        this._parserFeatures = i3;
        this._parserFeaturesToChange = i4;
    }

    private DeserializationConfig(DeserializationConfig deserializationConfig, ajr com_fossil_ajr) {
        super((MapperConfigBase) deserializationConfig, com_fossil_ajr);
        this._deserFeatures = deserializationConfig._deserFeatures;
        this._nodeFactory = deserializationConfig._nodeFactory;
        this._problemHandlers = deserializationConfig._problemHandlers;
        this._parserFeatures = deserializationConfig._parserFeatures;
        this._parserFeaturesToChange = deserializationConfig._parserFeaturesToChange;
    }

    private DeserializationConfig(DeserializationConfig deserializationConfig, BaseSettings baseSettings) {
        super((MapperConfigBase) deserializationConfig, baseSettings);
        this._deserFeatures = deserializationConfig._deserFeatures;
        this._nodeFactory = deserializationConfig._nodeFactory;
        this._problemHandlers = deserializationConfig._problemHandlers;
        this._parserFeatures = deserializationConfig._parserFeatures;
        this._parserFeaturesToChange = deserializationConfig._parserFeaturesToChange;
    }

    private DeserializationConfig(DeserializationConfig deserializationConfig, JsonNodeFactory jsonNodeFactory) {
        super(deserializationConfig);
        this._deserFeatures = deserializationConfig._deserFeatures;
        this._problemHandlers = deserializationConfig._problemHandlers;
        this._nodeFactory = jsonNodeFactory;
        this._parserFeatures = deserializationConfig._parserFeatures;
        this._parserFeaturesToChange = deserializationConfig._parserFeaturesToChange;
    }

    private DeserializationConfig(DeserializationConfig deserializationConfig, amn<ahy> com_fossil_amn_com_fossil_ahy) {
        super(deserializationConfig);
        this._deserFeatures = deserializationConfig._deserFeatures;
        this._problemHandlers = com_fossil_amn_com_fossil_ahy;
        this._nodeFactory = deserializationConfig._nodeFactory;
        this._parserFeatures = deserializationConfig._parserFeatures;
        this._parserFeaturesToChange = deserializationConfig._parserFeaturesToChange;
    }

    private DeserializationConfig(DeserializationConfig deserializationConfig, PropertyName propertyName) {
        super((MapperConfigBase) deserializationConfig, propertyName);
        this._deserFeatures = deserializationConfig._deserFeatures;
        this._problemHandlers = deserializationConfig._problemHandlers;
        this._nodeFactory = deserializationConfig._nodeFactory;
        this._parserFeatures = deserializationConfig._parserFeatures;
        this._parserFeaturesToChange = deserializationConfig._parserFeaturesToChange;
    }

    private DeserializationConfig(DeserializationConfig deserializationConfig, Class<?> cls) {
        super((MapperConfigBase) deserializationConfig, (Class) cls);
        this._deserFeatures = deserializationConfig._deserFeatures;
        this._problemHandlers = deserializationConfig._problemHandlers;
        this._nodeFactory = deserializationConfig._nodeFactory;
        this._parserFeatures = deserializationConfig._parserFeatures;
        this._parserFeaturesToChange = deserializationConfig._parserFeaturesToChange;
    }

    protected DeserializationConfig(DeserializationConfig deserializationConfig, ContextAttributes contextAttributes) {
        super((MapperConfigBase) deserializationConfig, contextAttributes);
        this._deserFeatures = deserializationConfig._deserFeatures;
        this._problemHandlers = deserializationConfig._problemHandlers;
        this._nodeFactory = deserializationConfig._nodeFactory;
        this._parserFeatures = deserializationConfig._parserFeatures;
        this._parserFeaturesToChange = deserializationConfig._parserFeaturesToChange;
    }

    protected DeserializationConfig(DeserializationConfig deserializationConfig, SimpleMixInResolver simpleMixInResolver) {
        super((MapperConfigBase) deserializationConfig, simpleMixInResolver);
        this._deserFeatures = deserializationConfig._deserFeatures;
        this._problemHandlers = deserializationConfig._problemHandlers;
        this._nodeFactory = deserializationConfig._nodeFactory;
        this._parserFeatures = deserializationConfig._parserFeatures;
        this._parserFeaturesToChange = deserializationConfig._parserFeaturesToChange;
    }

    protected DeserializationConfig(DeserializationConfig deserializationConfig, SimpleMixInResolver simpleMixInResolver, RootNameLookup rootNameLookup) {
        super(deserializationConfig, simpleMixInResolver, rootNameLookup);
        this._deserFeatures = deserializationConfig._deserFeatures;
        this._problemHandlers = deserializationConfig._problemHandlers;
        this._nodeFactory = deserializationConfig._nodeFactory;
        this._parserFeatures = deserializationConfig._parserFeatures;
        this._parserFeaturesToChange = deserializationConfig._parserFeaturesToChange;
    }

    protected BaseSettings getBaseSettings() {
        return this._base;
    }

    public DeserializationConfig with(MapperFeature... mapperFeatureArr) {
        int i = this._mapperFeatures;
        for (MapperFeature mask : mapperFeatureArr) {
            i |= mask.getMask();
        }
        return i == this._mapperFeatures ? this : new DeserializationConfig(this, i, this._deserFeatures, this._parserFeatures, this._parserFeaturesToChange);
    }

    public DeserializationConfig without(MapperFeature... mapperFeatureArr) {
        int i = this._mapperFeatures;
        for (MapperFeature mask : mapperFeatureArr) {
            i &= mask.getMask() ^ -1;
        }
        return i == this._mapperFeatures ? this : new DeserializationConfig(this, i, this._deserFeatures, this._parserFeatures, this._parserFeaturesToChange);
    }

    public DeserializationConfig with(MapperFeature mapperFeature, boolean z) {
        int mask;
        if (z) {
            mask = this._mapperFeatures | mapperFeature.getMask();
        } else {
            mask = this._mapperFeatures & (mapperFeature.getMask() ^ -1);
        }
        return mask == this._mapperFeatures ? this : new DeserializationConfig(this, mask, this._deserFeatures, this._parserFeatures, this._parserFeaturesToChange);
    }

    public DeserializationConfig with(aiw com_fossil_aiw) {
        return m2689a(this._base.withClassIntrospector(com_fossil_aiw));
    }

    public DeserializationConfig with(AnnotationIntrospector annotationIntrospector) {
        return m2689a(this._base.withAnnotationIntrospector(annotationIntrospector));
    }

    public DeserializationConfig with(VisibilityChecker<?> visibilityChecker) {
        return m2689a(this._base.withVisibilityChecker(visibilityChecker));
    }

    public DeserializationConfig withVisibility(PropertyAccessor propertyAccessor, Visibility visibility) {
        return m2689a(this._base.withVisibility(propertyAccessor, visibility));
    }

    public DeserializationConfig with(aju<?> com_fossil_aju_) {
        return m2689a(this._base.withTypeResolverBuilder(com_fossil_aju_));
    }

    public DeserializationConfig with(ajr com_fossil_ajr) {
        return this._subtypeResolver == com_fossil_ajr ? this : new DeserializationConfig(this, com_fossil_ajr);
    }

    public DeserializationConfig with(PropertyNamingStrategy propertyNamingStrategy) {
        return m2689a(this._base.withPropertyNamingStrategy(propertyNamingStrategy));
    }

    public DeserializationConfig withRootName(PropertyName propertyName) {
        if (propertyName == null) {
            if (this._rootName == null) {
                return this;
            }
        } else if (propertyName.equals(this._rootName)) {
            return this;
        }
        return new DeserializationConfig(this, propertyName);
    }

    public DeserializationConfig with(TypeFactory typeFactory) {
        return m2689a(this._base.withTypeFactory(typeFactory));
    }

    public DeserializationConfig with(DateFormat dateFormat) {
        return m2689a(this._base.withDateFormat(dateFormat));
    }

    public DeserializationConfig with(ahr com_fossil_ahr) {
        return m2689a(this._base.withHandlerInstantiator(com_fossil_ahr));
    }

    public DeserializationConfig withInsertedAnnotationIntrospector(AnnotationIntrospector annotationIntrospector) {
        return m2689a(this._base.withInsertedAnnotationIntrospector(annotationIntrospector));
    }

    public DeserializationConfig withAppendedAnnotationIntrospector(AnnotationIntrospector annotationIntrospector) {
        return m2689a(this._base.withAppendedAnnotationIntrospector(annotationIntrospector));
    }

    public DeserializationConfig withView(Class<?> cls) {
        return this._view == cls ? this : new DeserializationConfig(this, (Class) cls);
    }

    public DeserializationConfig with(Locale locale) {
        return m2689a(this._base.with(locale));
    }

    public DeserializationConfig with(TimeZone timeZone) {
        return m2689a(this._base.with(timeZone));
    }

    public DeserializationConfig with(Base64Variant base64Variant) {
        return m2689a(this._base.with(base64Variant));
    }

    public DeserializationConfig with(ContextAttributes contextAttributes) {
        return contextAttributes == this._attributes ? this : new DeserializationConfig(this, contextAttributes);
    }

    private final DeserializationConfig m2689a(BaseSettings baseSettings) {
        return this._base == baseSettings ? this : new DeserializationConfig(this, baseSettings);
    }

    public DeserializationConfig with(DeserializationFeature deserializationFeature) {
        int mask = this._deserFeatures | deserializationFeature.getMask();
        return mask == this._deserFeatures ? this : new DeserializationConfig(this, this._mapperFeatures, mask, this._parserFeatures, this._parserFeaturesToChange);
    }

    public DeserializationConfig with(DeserializationFeature deserializationFeature, DeserializationFeature... deserializationFeatureArr) {
        int mask = this._deserFeatures | deserializationFeature.getMask();
        for (DeserializationFeature mask2 : deserializationFeatureArr) {
            mask |= mask2.getMask();
        }
        return mask == this._deserFeatures ? this : new DeserializationConfig(this, this._mapperFeatures, mask, this._parserFeatures, this._parserFeaturesToChange);
    }

    public DeserializationConfig withFeatures(DeserializationFeature... deserializationFeatureArr) {
        int i = this._deserFeatures;
        for (DeserializationFeature mask : deserializationFeatureArr) {
            i |= mask.getMask();
        }
        return i == this._deserFeatures ? this : new DeserializationConfig(this, this._mapperFeatures, i, this._parserFeatures, this._parserFeaturesToChange);
    }

    public DeserializationConfig without(DeserializationFeature deserializationFeature) {
        int mask = this._deserFeatures & (deserializationFeature.getMask() ^ -1);
        return mask == this._deserFeatures ? this : new DeserializationConfig(this, this._mapperFeatures, mask, this._parserFeatures, this._parserFeaturesToChange);
    }

    public DeserializationConfig without(DeserializationFeature deserializationFeature, DeserializationFeature... deserializationFeatureArr) {
        int mask = this._deserFeatures & (deserializationFeature.getMask() ^ -1);
        for (DeserializationFeature mask2 : deserializationFeatureArr) {
            mask &= mask2.getMask() ^ -1;
        }
        return mask == this._deserFeatures ? this : new DeserializationConfig(this, this._mapperFeatures, mask, this._parserFeatures, this._parserFeaturesToChange);
    }

    public DeserializationConfig withoutFeatures(DeserializationFeature... deserializationFeatureArr) {
        int i = this._deserFeatures;
        for (DeserializationFeature mask : deserializationFeatureArr) {
            i &= mask.getMask() ^ -1;
        }
        return i == this._deserFeatures ? this : new DeserializationConfig(this, this._mapperFeatures, i, this._parserFeatures, this._parserFeaturesToChange);
    }

    public DeserializationConfig with(Feature feature) {
        int mask = this._parserFeatures | feature.getMask();
        int mask2 = this._parserFeaturesToChange | feature.getMask();
        return (this._parserFeatures == mask && this._parserFeaturesToChange == mask2) ? this : new DeserializationConfig(this, this._mapperFeatures, this._deserFeatures, mask, mask2);
    }

    public DeserializationConfig withFeatures(Feature... featureArr) {
        int i = this._parserFeatures;
        int i2 = this._parserFeaturesToChange;
        for (Feature mask : featureArr) {
            int mask2 = mask.getMask();
            i |= mask2;
            i2 |= mask2;
        }
        return (this._parserFeatures == i && this._parserFeaturesToChange == i2) ? this : new DeserializationConfig(this, this._mapperFeatures, this._deserFeatures, i, i2);
    }

    public DeserializationConfig without(Feature feature) {
        int mask = this._parserFeatures & (feature.getMask() ^ -1);
        int mask2 = this._parserFeaturesToChange | feature.getMask();
        return (this._parserFeatures == mask && this._parserFeaturesToChange == mask2) ? this : new DeserializationConfig(this, this._mapperFeatures, this._deserFeatures, mask, mask2);
    }

    public DeserializationConfig withoutFeatures(Feature... featureArr) {
        int i = this._parserFeatures;
        int i2 = this._parserFeaturesToChange;
        for (Feature mask : featureArr) {
            int mask2 = mask.getMask();
            i &= mask2 ^ -1;
            i2 |= mask2;
        }
        return (this._parserFeatures == i && this._parserFeaturesToChange == i2) ? this : new DeserializationConfig(this, this._mapperFeatures, this._deserFeatures, i, i2);
    }

    public DeserializationConfig with(JsonNodeFactory jsonNodeFactory) {
        return this._nodeFactory == jsonNodeFactory ? this : new DeserializationConfig(this, jsonNodeFactory);
    }

    public DeserializationConfig withHandler(ahy com_fossil_ahy) {
        return amn.m3882a(this._problemHandlers, com_fossil_ahy) ? this : new DeserializationConfig(this, new amn(com_fossil_ahy, this._problemHandlers));
    }

    public DeserializationConfig withNoProblemHandlers() {
        return this._problemHandlers == null ? this : new DeserializationConfig(this, (amn) null);
    }

    public void initialize(JsonParser jsonParser) {
        if (this._parserFeaturesToChange != 0) {
            int zB = jsonParser.zB();
            int i = ((this._parserFeaturesToChange ^ -1) & zB) | this._parserFeatures;
            if (zB != i) {
                jsonParser.fm(i);
            }
        }
    }

    public AnnotationIntrospector getAnnotationIntrospector() {
        if (isEnabled(MapperFeature.USE_ANNOTATIONS)) {
            return super.getAnnotationIntrospector();
        }
        return NopAnnotationIntrospector.instance;
    }

    public boolean useRootWrapping() {
        if (this._rootName != null) {
            return !this._rootName.isEmpty();
        } else {
            return isEnabled(DeserializationFeature.UNWRAP_ROOT_VALUE);
        }
    }

    public agu introspectClassAnnotations(JavaType javaType) {
        return getClassIntrospector().forClassAnnotations(this, javaType, this);
    }

    public agu introspectDirectClassAnnotations(JavaType javaType) {
        return getClassIntrospector().forDirectClassAnnotations(this, javaType, this);
    }

    public VisibilityChecker<?> getDefaultVisibilityChecker() {
        VisibilityChecker<?> defaultVisibilityChecker = super.getDefaultVisibilityChecker();
        if (!isEnabled(MapperFeature.AUTO_DETECT_SETTERS)) {
            defaultVisibilityChecker = defaultVisibilityChecker.withSetterVisibility(Visibility.NONE);
        }
        if (!isEnabled(MapperFeature.AUTO_DETECT_CREATORS)) {
            defaultVisibilityChecker = defaultVisibilityChecker.withCreatorVisibility(Visibility.NONE);
        }
        if (isEnabled(MapperFeature.AUTO_DETECT_FIELDS)) {
            return defaultVisibilityChecker;
        }
        return defaultVisibilityChecker.withFieldVisibility(Visibility.NONE);
    }

    public final boolean isEnabled(DeserializationFeature deserializationFeature) {
        return (this._deserFeatures & deserializationFeature.getMask()) != 0;
    }

    public final boolean isEnabled(Feature feature, JsonFactory jsonFactory) {
        if ((feature.getMask() & this._parserFeaturesToChange) != 0) {
            return (this._parserFeatures & feature.getMask()) != 0;
        } else {
            return jsonFactory.isEnabled(feature);
        }
    }

    public final boolean hasDeserializationFeatures(int i) {
        return (this._deserFeatures & i) == i;
    }

    public final boolean hasSomeOfFeatures(int i) {
        return (this._deserFeatures & i) != 0;
    }

    public final int getDeserializationFeatures() {
        return this._deserFeatures;
    }

    public amn<ahy> getProblemHandlers() {
        return this._problemHandlers;
    }

    public final JsonNodeFactory getNodeFactory() {
        return this._nodeFactory;
    }

    public <T extends agu> T introspect(JavaType javaType) {
        return getClassIntrospector().forDeserialization(this, javaType, this);
    }

    public <T extends agu> T introspectForCreation(JavaType javaType) {
        return getClassIntrospector().forCreation(this, javaType, this);
    }

    public <T extends agu> T introspectForBuilder(JavaType javaType) {
        return getClassIntrospector().forDeserializationWithBuilder(this, javaType, this);
    }

    public ajs findTypeDeserializer(JavaType javaType) throws JsonMappingException {
        Collection collection = null;
        air Dn = introspectClassAnnotations(javaType.getRawClass()).Dn();
        aju findTypeResolver = getAnnotationIntrospector().findTypeResolver(this, Dn, javaType);
        if (findTypeResolver == null) {
            findTypeResolver = getDefaultTyper(javaType);
            if (findTypeResolver == null) {
                return null;
            }
        }
        collection = getSubtypeResolver().collectAndResolveSubtypesByTypeId(this, Dn);
        return findTypeResolver.buildTypeDeserializer(this, javaType, collection);
    }
}
