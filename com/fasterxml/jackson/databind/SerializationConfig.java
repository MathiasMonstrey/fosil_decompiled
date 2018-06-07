package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.cfg.BaseSettings;
import com.fasterxml.jackson.databind.cfg.ContextAttributes;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.cfg.MapperConfigBase;
import com.fasterxml.jackson.databind.introspect.SimpleMixInResolver;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.RootNameLookup;
import com.fossil.afb;
import com.fossil.ago;
import com.fossil.agu;
import com.fossil.ahr;
import com.fossil.aiw;
import com.fossil.ajr;
import com.fossil.aju;
import com.fossil.alh;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Locale;
import java.util.TimeZone;

public final class SerializationConfig extends MapperConfigBase<SerializationFeature, SerializationConfig> implements Serializable {
    protected static final afb DEFAULT_PRETTY_PRINTER = new DefaultPrettyPrinter();
    private static final long serialVersionUID = 1;
    protected final afb _defaultPrettyPrinter;
    protected final alh _filterProvider;
    protected final int _generatorFeatures;
    protected final int _generatorFeaturesToChange;
    protected final int _serFeatures;
    protected Include _serializationInclusion;

    public SerializationConfig(BaseSettings baseSettings, ajr com_fossil_ajr, SimpleMixInResolver simpleMixInResolver, RootNameLookup rootNameLookup) {
        super(baseSettings, com_fossil_ajr, simpleMixInResolver, rootNameLookup);
        this._serializationInclusion = null;
        this._serFeatures = MapperConfig.collectFeatureDefaults(SerializationFeature.class);
        this._filterProvider = null;
        this._defaultPrettyPrinter = DEFAULT_PRETTY_PRINTER;
        this._generatorFeatures = 0;
        this._generatorFeaturesToChange = 0;
    }

    private SerializationConfig(SerializationConfig serializationConfig, ajr com_fossil_ajr) {
        super((MapperConfigBase) serializationConfig, com_fossil_ajr);
        this._serializationInclusion = null;
        this._serFeatures = serializationConfig._serFeatures;
        this._serializationInclusion = serializationConfig._serializationInclusion;
        this._filterProvider = serializationConfig._filterProvider;
        this._defaultPrettyPrinter = serializationConfig._defaultPrettyPrinter;
        this._generatorFeatures = serializationConfig._generatorFeatures;
        this._generatorFeaturesToChange = serializationConfig._generatorFeaturesToChange;
    }

    private SerializationConfig(SerializationConfig serializationConfig, int i, int i2, int i3, int i4) {
        super((MapperConfigBase) serializationConfig, i);
        this._serializationInclusion = null;
        this._serFeatures = i2;
        this._serializationInclusion = serializationConfig._serializationInclusion;
        this._filterProvider = serializationConfig._filterProvider;
        this._defaultPrettyPrinter = serializationConfig._defaultPrettyPrinter;
        this._generatorFeatures = i3;
        this._generatorFeaturesToChange = i4;
    }

    private SerializationConfig(SerializationConfig serializationConfig, BaseSettings baseSettings) {
        super((MapperConfigBase) serializationConfig, baseSettings);
        this._serializationInclusion = null;
        this._serFeatures = serializationConfig._serFeatures;
        this._serializationInclusion = serializationConfig._serializationInclusion;
        this._filterProvider = serializationConfig._filterProvider;
        this._defaultPrettyPrinter = serializationConfig._defaultPrettyPrinter;
        this._generatorFeatures = serializationConfig._generatorFeatures;
        this._generatorFeaturesToChange = serializationConfig._generatorFeaturesToChange;
    }

    private SerializationConfig(SerializationConfig serializationConfig, alh com_fossil_alh) {
        super(serializationConfig);
        this._serializationInclusion = null;
        this._serFeatures = serializationConfig._serFeatures;
        this._serializationInclusion = serializationConfig._serializationInclusion;
        this._filterProvider = com_fossil_alh;
        this._defaultPrettyPrinter = serializationConfig._defaultPrettyPrinter;
        this._generatorFeatures = serializationConfig._generatorFeatures;
        this._generatorFeaturesToChange = serializationConfig._generatorFeaturesToChange;
    }

    private SerializationConfig(SerializationConfig serializationConfig, Class<?> cls) {
        super((MapperConfigBase) serializationConfig, (Class) cls);
        this._serializationInclusion = null;
        this._serFeatures = serializationConfig._serFeatures;
        this._serializationInclusion = serializationConfig._serializationInclusion;
        this._filterProvider = serializationConfig._filterProvider;
        this._defaultPrettyPrinter = serializationConfig._defaultPrettyPrinter;
        this._generatorFeatures = serializationConfig._generatorFeatures;
        this._generatorFeaturesToChange = serializationConfig._generatorFeaturesToChange;
    }

    private SerializationConfig(SerializationConfig serializationConfig, Include include) {
        super(serializationConfig);
        this._serializationInclusion = null;
        this._serFeatures = serializationConfig._serFeatures;
        this._serializationInclusion = include;
        this._filterProvider = serializationConfig._filterProvider;
        this._defaultPrettyPrinter = serializationConfig._defaultPrettyPrinter;
        this._generatorFeatures = serializationConfig._generatorFeatures;
        this._generatorFeaturesToChange = serializationConfig._generatorFeaturesToChange;
    }

    private SerializationConfig(SerializationConfig serializationConfig, PropertyName propertyName) {
        super((MapperConfigBase) serializationConfig, propertyName);
        this._serializationInclusion = null;
        this._serFeatures = serializationConfig._serFeatures;
        this._serializationInclusion = serializationConfig._serializationInclusion;
        this._filterProvider = serializationConfig._filterProvider;
        this._defaultPrettyPrinter = serializationConfig._defaultPrettyPrinter;
        this._generatorFeatures = serializationConfig._generatorFeatures;
        this._generatorFeaturesToChange = serializationConfig._generatorFeaturesToChange;
    }

    protected SerializationConfig(SerializationConfig serializationConfig, ContextAttributes contextAttributes) {
        super((MapperConfigBase) serializationConfig, contextAttributes);
        this._serializationInclusion = null;
        this._serFeatures = serializationConfig._serFeatures;
        this._serializationInclusion = serializationConfig._serializationInclusion;
        this._filterProvider = serializationConfig._filterProvider;
        this._defaultPrettyPrinter = serializationConfig._defaultPrettyPrinter;
        this._generatorFeatures = serializationConfig._generatorFeatures;
        this._generatorFeaturesToChange = serializationConfig._generatorFeaturesToChange;
    }

    protected SerializationConfig(SerializationConfig serializationConfig, SimpleMixInResolver simpleMixInResolver) {
        super((MapperConfigBase) serializationConfig, simpleMixInResolver);
        this._serializationInclusion = null;
        this._serFeatures = serializationConfig._serFeatures;
        this._serializationInclusion = serializationConfig._serializationInclusion;
        this._filterProvider = serializationConfig._filterProvider;
        this._defaultPrettyPrinter = serializationConfig._defaultPrettyPrinter;
        this._generatorFeatures = serializationConfig._generatorFeatures;
        this._generatorFeaturesToChange = serializationConfig._generatorFeaturesToChange;
    }

    protected SerializationConfig(SerializationConfig serializationConfig, afb com_fossil_afb) {
        super(serializationConfig);
        this._serializationInclusion = null;
        this._serFeatures = serializationConfig._serFeatures;
        this._serializationInclusion = serializationConfig._serializationInclusion;
        this._filterProvider = serializationConfig._filterProvider;
        this._defaultPrettyPrinter = com_fossil_afb;
        this._generatorFeatures = serializationConfig._generatorFeatures;
        this._generatorFeaturesToChange = serializationConfig._generatorFeaturesToChange;
    }

    protected SerializationConfig(SerializationConfig serializationConfig, SimpleMixInResolver simpleMixInResolver, RootNameLookup rootNameLookup) {
        super(serializationConfig, simpleMixInResolver, rootNameLookup);
        this._serializationInclusion = null;
        this._serFeatures = serializationConfig._serFeatures;
        this._serializationInclusion = serializationConfig._serializationInclusion;
        this._filterProvider = serializationConfig._filterProvider;
        this._defaultPrettyPrinter = serializationConfig._defaultPrettyPrinter;
        this._generatorFeatures = serializationConfig._generatorFeatures;
        this._generatorFeaturesToChange = serializationConfig._generatorFeaturesToChange;
    }

    public SerializationConfig with(MapperFeature... mapperFeatureArr) {
        int i = this._mapperFeatures;
        for (MapperFeature mask : mapperFeatureArr) {
            i |= mask.getMask();
        }
        return i == this._mapperFeatures ? this : new SerializationConfig(this, i, this._serFeatures, this._generatorFeatures, this._generatorFeaturesToChange);
    }

    public SerializationConfig without(MapperFeature... mapperFeatureArr) {
        int i = this._mapperFeatures;
        for (MapperFeature mask : mapperFeatureArr) {
            i &= mask.getMask() ^ -1;
        }
        return i == this._mapperFeatures ? this : new SerializationConfig(this, i, this._serFeatures, this._generatorFeatures, this._generatorFeaturesToChange);
    }

    public SerializationConfig with(MapperFeature mapperFeature, boolean z) {
        int mask;
        if (z) {
            mask = this._mapperFeatures | mapperFeature.getMask();
        } else {
            mask = this._mapperFeatures & (mapperFeature.getMask() ^ -1);
        }
        return mask == this._mapperFeatures ? this : new SerializationConfig(this, mask, this._serFeatures, this._generatorFeatures, this._generatorFeaturesToChange);
    }

    public SerializationConfig with(AnnotationIntrospector annotationIntrospector) {
        return m2693b(this._base.withAnnotationIntrospector(annotationIntrospector));
    }

    public SerializationConfig withAppendedAnnotationIntrospector(AnnotationIntrospector annotationIntrospector) {
        return m2693b(this._base.withAppendedAnnotationIntrospector(annotationIntrospector));
    }

    public SerializationConfig withInsertedAnnotationIntrospector(AnnotationIntrospector annotationIntrospector) {
        return m2693b(this._base.withInsertedAnnotationIntrospector(annotationIntrospector));
    }

    public SerializationConfig with(aiw com_fossil_aiw) {
        return m2693b(this._base.withClassIntrospector(com_fossil_aiw));
    }

    public SerializationConfig with(DateFormat dateFormat) {
        SerializationConfig serializationConfig = new SerializationConfig(this, this._base.withDateFormat(dateFormat));
        if (dateFormat == null) {
            return serializationConfig.with(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        }
        return serializationConfig.without(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    public SerializationConfig with(ahr com_fossil_ahr) {
        return m2693b(this._base.withHandlerInstantiator(com_fossil_ahr));
    }

    public SerializationConfig with(PropertyNamingStrategy propertyNamingStrategy) {
        return m2693b(this._base.withPropertyNamingStrategy(propertyNamingStrategy));
    }

    public SerializationConfig withRootName(PropertyName propertyName) {
        if (propertyName == null) {
            if (this._rootName == null) {
                return this;
            }
        } else if (propertyName.equals(this._rootName)) {
            return this;
        }
        return new SerializationConfig(this, propertyName);
    }

    public SerializationConfig with(ajr com_fossil_ajr) {
        return com_fossil_ajr == this._subtypeResolver ? this : new SerializationConfig(this, com_fossil_ajr);
    }

    public SerializationConfig with(TypeFactory typeFactory) {
        return m2693b(this._base.withTypeFactory(typeFactory));
    }

    public SerializationConfig with(aju<?> com_fossil_aju_) {
        return m2693b(this._base.withTypeResolverBuilder(com_fossil_aju_));
    }

    public SerializationConfig withView(Class<?> cls) {
        return this._view == cls ? this : new SerializationConfig(this, (Class) cls);
    }

    public SerializationConfig with(VisibilityChecker<?> visibilityChecker) {
        return m2693b(this._base.withVisibilityChecker(visibilityChecker));
    }

    public SerializationConfig withVisibility(PropertyAccessor propertyAccessor, Visibility visibility) {
        return m2693b(this._base.withVisibility(propertyAccessor, visibility));
    }

    public SerializationConfig with(Locale locale) {
        return m2693b(this._base.with(locale));
    }

    public SerializationConfig with(TimeZone timeZone) {
        return m2693b(this._base.with(timeZone));
    }

    public SerializationConfig with(Base64Variant base64Variant) {
        return m2693b(this._base.with(base64Variant));
    }

    public SerializationConfig with(ContextAttributes contextAttributes) {
        return contextAttributes == this._attributes ? this : new SerializationConfig(this, contextAttributes);
    }

    private final SerializationConfig m2693b(BaseSettings baseSettings) {
        return this._base == baseSettings ? this : new SerializationConfig(this, baseSettings);
    }

    public SerializationConfig with(SerializationFeature serializationFeature) {
        int mask = this._serFeatures | serializationFeature.getMask();
        return mask == this._serFeatures ? this : new SerializationConfig(this, this._mapperFeatures, mask, this._generatorFeatures, this._generatorFeaturesToChange);
    }

    public SerializationConfig with(SerializationFeature serializationFeature, SerializationFeature... serializationFeatureArr) {
        int mask = this._serFeatures | serializationFeature.getMask();
        for (SerializationFeature mask2 : serializationFeatureArr) {
            mask |= mask2.getMask();
        }
        return mask == this._serFeatures ? this : new SerializationConfig(this, this._mapperFeatures, mask, this._generatorFeatures, this._generatorFeaturesToChange);
    }

    public SerializationConfig withFeatures(SerializationFeature... serializationFeatureArr) {
        int i = this._serFeatures;
        for (SerializationFeature mask : serializationFeatureArr) {
            i |= mask.getMask();
        }
        return i == this._serFeatures ? this : new SerializationConfig(this, this._mapperFeatures, i, this._generatorFeatures, this._generatorFeaturesToChange);
    }

    public SerializationConfig without(SerializationFeature serializationFeature) {
        int mask = this._serFeatures & (serializationFeature.getMask() ^ -1);
        return mask == this._serFeatures ? this : new SerializationConfig(this, this._mapperFeatures, mask, this._generatorFeatures, this._generatorFeaturesToChange);
    }

    public SerializationConfig without(SerializationFeature serializationFeature, SerializationFeature... serializationFeatureArr) {
        int mask = this._serFeatures & (serializationFeature.getMask() ^ -1);
        for (SerializationFeature mask2 : serializationFeatureArr) {
            mask &= mask2.getMask() ^ -1;
        }
        return mask == this._serFeatures ? this : new SerializationConfig(this, this._mapperFeatures, mask, this._generatorFeatures, this._generatorFeaturesToChange);
    }

    public SerializationConfig withoutFeatures(SerializationFeature... serializationFeatureArr) {
        int i = this._serFeatures;
        for (SerializationFeature mask : serializationFeatureArr) {
            i &= mask.getMask() ^ -1;
        }
        return i == this._serFeatures ? this : new SerializationConfig(this, this._mapperFeatures, i, this._generatorFeatures, this._generatorFeaturesToChange);
    }

    public SerializationConfig with(Feature feature) {
        int mask = this._generatorFeatures | feature.getMask();
        int mask2 = this._generatorFeaturesToChange | feature.getMask();
        return (this._generatorFeatures == mask && this._generatorFeaturesToChange == mask2) ? this : new SerializationConfig(this, this._mapperFeatures, this._serFeatures, mask, mask2);
    }

    public SerializationConfig withFeatures(Feature... featureArr) {
        int i = this._generatorFeatures;
        int i2 = this._generatorFeaturesToChange;
        for (Feature mask : featureArr) {
            int mask2 = mask.getMask();
            i |= mask2;
            i2 |= mask2;
        }
        return (this._generatorFeatures == i && this._generatorFeaturesToChange == i2) ? this : new SerializationConfig(this, this._mapperFeatures, this._serFeatures, i, i2);
    }

    public SerializationConfig without(Feature feature) {
        int mask = this._generatorFeatures & (feature.getMask() ^ -1);
        int mask2 = this._generatorFeaturesToChange | feature.getMask();
        return (this._generatorFeatures == mask && this._generatorFeaturesToChange == mask2) ? this : new SerializationConfig(this, this._mapperFeatures, this._serFeatures, mask, mask2);
    }

    public SerializationConfig withoutFeatures(Feature... featureArr) {
        int i = this._generatorFeatures;
        int i2 = this._generatorFeaturesToChange;
        for (Feature mask : featureArr) {
            int mask2 = mask.getMask();
            i &= mask2 ^ -1;
            i2 |= mask2;
        }
        return (this._generatorFeatures == i && this._generatorFeaturesToChange == i2) ? this : new SerializationConfig(this, this._mapperFeatures, this._serFeatures, i, i2);
    }

    public SerializationConfig withFilters(alh com_fossil_alh) {
        return com_fossil_alh == this._filterProvider ? this : new SerializationConfig(this, com_fossil_alh);
    }

    public SerializationConfig withSerializationInclusion(Include include) {
        return this._serializationInclusion == include ? this : new SerializationConfig(this, include);
    }

    public SerializationConfig withDefaultPrettyPrinter(afb com_fossil_afb) {
        return this._defaultPrettyPrinter == com_fossil_afb ? this : new SerializationConfig(this, com_fossil_afb);
    }

    public afb constructDefaultPrettyPrinter() {
        afb com_fossil_afb = this._defaultPrettyPrinter;
        if (com_fossil_afb instanceof ago) {
            return (afb) ((ago) com_fossil_afb).createInstance();
        }
        return com_fossil_afb;
    }

    public void initialize(JsonGenerator jsonGenerator) {
        if (SerializationFeature.INDENT_OUTPUT.enabledIn(this._serFeatures) && jsonGenerator.zC() == null) {
            afb constructDefaultPrettyPrinter = constructDefaultPrettyPrinter();
            if (constructDefaultPrettyPrinter != null) {
                jsonGenerator.m2664a(constructDefaultPrettyPrinter);
            }
        }
        boolean enabledIn = SerializationFeature.WRITE_BIGDECIMAL_AS_PLAIN.enabledIn(this._serFeatures);
        if (this._generatorFeaturesToChange != 0 || enabledIn) {
            int zB = jsonGenerator.zB();
            int i = ((this._generatorFeaturesToChange ^ -1) & zB) | this._generatorFeatures;
            if (enabledIn) {
                i |= Feature.WRITE_BIGDECIMAL_AS_PLAIN.getMask();
            }
            if (zB != i) {
                jsonGenerator.fi(i);
            }
        }
    }

    public boolean useRootWrapping() {
        if (this._rootName != null) {
            return !this._rootName.isEmpty();
        } else {
            return isEnabled(SerializationFeature.WRAP_ROOT_VALUE);
        }
    }

    public AnnotationIntrospector getAnnotationIntrospector() {
        if (isEnabled(MapperFeature.USE_ANNOTATIONS)) {
            return super.getAnnotationIntrospector();
        }
        return AnnotationIntrospector.nopInstance();
    }

    public agu introspectClassAnnotations(JavaType javaType) {
        return getClassIntrospector().forClassAnnotations(this, javaType, this);
    }

    public agu introspectDirectClassAnnotations(JavaType javaType) {
        return getClassIntrospector().forDirectClassAnnotations(this, javaType, this);
    }

    public VisibilityChecker<?> getDefaultVisibilityChecker() {
        VisibilityChecker<?> defaultVisibilityChecker = super.getDefaultVisibilityChecker();
        if (!isEnabled(MapperFeature.AUTO_DETECT_GETTERS)) {
            defaultVisibilityChecker = defaultVisibilityChecker.withGetterVisibility(Visibility.NONE);
        }
        if (!isEnabled(MapperFeature.AUTO_DETECT_IS_GETTERS)) {
            defaultVisibilityChecker = defaultVisibilityChecker.withIsGetterVisibility(Visibility.NONE);
        }
        if (isEnabled(MapperFeature.AUTO_DETECT_FIELDS)) {
            return defaultVisibilityChecker;
        }
        return defaultVisibilityChecker.withFieldVisibility(Visibility.NONE);
    }

    public final boolean isEnabled(SerializationFeature serializationFeature) {
        return (this._serFeatures & serializationFeature.getMask()) != 0;
    }

    public final boolean isEnabled(Feature feature, JsonFactory jsonFactory) {
        if ((feature.getMask() & this._generatorFeaturesToChange) != 0) {
            return (this._generatorFeatures & feature.getMask()) != 0;
        } else {
            return jsonFactory.isEnabled(feature);
        }
    }

    public final boolean hasSerializationFeatures(int i) {
        return (this._serFeatures & i) == i;
    }

    public final int getSerializationFeatures() {
        return this._serFeatures;
    }

    public Include getSerializationInclusion() {
        if (this._serializationInclusion != null) {
            return this._serializationInclusion;
        }
        return Include.ALWAYS;
    }

    public alh getFilterProvider() {
        return this._filterProvider;
    }

    public afb getDefaultPrettyPrinter() {
        return this._defaultPrettyPrinter;
    }

    public <T extends agu> T introspect(JavaType javaType) {
        return getClassIntrospector().forSerialization(this, javaType, this);
    }

    public String toString() {
        return "[SerializationConfig: flags=0x" + Integer.toHexString(this._serFeatures) + "]";
    }
}
