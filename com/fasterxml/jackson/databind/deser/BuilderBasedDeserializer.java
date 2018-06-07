package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.impl.BeanAsArrayBuilderDeserializer;
import com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fossil.agu;
import com.fossil.agy;
import com.fossil.aht;
import com.fossil.aig;
import com.fossil.aii;
import com.fossil.aik;
import com.fossil.amo;
import com.fossil.amt;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;

public class BuilderBasedDeserializer extends BeanDeserializerBase {
    private static final long serialVersionUID = 1;
    protected final AnnotatedMethod _buildMethod;

    public BuilderBasedDeserializer(aht com_fossil_aht, agu com_fossil_agu, BeanPropertyMap beanPropertyMap, Map<String, SettableBeanProperty> map, HashSet<String> hashSet, boolean z, boolean z2) {
        super(com_fossil_aht, com_fossil_agu, beanPropertyMap, map, hashSet, z, z2);
        this._buildMethod = com_fossil_aht.Er();
        if (this._objectIdReader != null) {
            throw new IllegalArgumentException("Can not use Object Id with Builder-based deserialization (type " + com_fossil_agu.getType() + ")");
        }
    }

    protected BuilderBasedDeserializer(BuilderBasedDeserializer builderBasedDeserializer) {
        this(builderBasedDeserializer, builderBasedDeserializer._ignoreAllUnknown);
    }

    protected BuilderBasedDeserializer(BuilderBasedDeserializer builderBasedDeserializer, boolean z) {
        super((BeanDeserializerBase) builderBasedDeserializer, z);
        this._buildMethod = builderBasedDeserializer._buildMethod;
    }

    protected BuilderBasedDeserializer(BuilderBasedDeserializer builderBasedDeserializer, amo com_fossil_amo) {
        super((BeanDeserializerBase) builderBasedDeserializer, com_fossil_amo);
        this._buildMethod = builderBasedDeserializer._buildMethod;
    }

    public BuilderBasedDeserializer(BuilderBasedDeserializer builderBasedDeserializer, ObjectIdReader objectIdReader) {
        super((BeanDeserializerBase) builderBasedDeserializer, objectIdReader);
        this._buildMethod = builderBasedDeserializer._buildMethod;
    }

    public BuilderBasedDeserializer(BuilderBasedDeserializer builderBasedDeserializer, HashSet<String> hashSet) {
        super((BeanDeserializerBase) builderBasedDeserializer, (HashSet) hashSet);
        this._buildMethod = builderBasedDeserializer._buildMethod;
    }

    public agy<Object> unwrappingDeserializer(amo com_fossil_amo) {
        return new BuilderBasedDeserializer(this, com_fossil_amo);
    }

    public BuilderBasedDeserializer withObjectIdReader(ObjectIdReader objectIdReader) {
        return new BuilderBasedDeserializer(this, objectIdReader);
    }

    public BuilderBasedDeserializer withIgnorableProperties(HashSet<String> hashSet) {
        return new BuilderBasedDeserializer(this, (HashSet) hashSet);
    }

    protected BeanAsArrayBuilderDeserializer asArrayDeserializer() {
        return new BeanAsArrayBuilderDeserializer(this, this._beanProperties.getPropertiesInInsertionOrder(), this._buildMethod);
    }

    protected final Object finishBuild(DeserializationContext deserializationContext, Object obj) throws IOException {
        if (this._buildMethod == null) {
            return obj;
        }
        try {
            return this._buildMethod.getMember().invoke(obj, new Object[0]);
        } catch (Throwable e) {
            wrapInstantiationProblem(e, deserializationContext);
            return null;
        }
    }

    public final Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonToken zU = jsonParser.zU();
        if (zU == JsonToken.START_OBJECT) {
            zU = jsonParser.zP();
            if (this._vanillaProcessing) {
                return finishBuild(deserializationContext, m2700a(jsonParser, deserializationContext, zU));
            }
            return finishBuild(deserializationContext, deserializeFromObject(jsonParser, deserializationContext));
        }
        switch (zU) {
            case VALUE_STRING:
                return finishBuild(deserializationContext, deserializeFromString(jsonParser, deserializationContext));
            case VALUE_NUMBER_INT:
                return finishBuild(deserializationContext, deserializeFromNumber(jsonParser, deserializationContext));
            case VALUE_NUMBER_FLOAT:
                return finishBuild(deserializationContext, deserializeFromDouble(jsonParser, deserializationContext));
            case VALUE_EMBEDDED_OBJECT:
                return jsonParser.Aq();
            case VALUE_TRUE:
            case VALUE_FALSE:
                return finishBuild(deserializationContext, deserializeFromBoolean(jsonParser, deserializationContext));
            case START_ARRAY:
                return finishBuild(deserializationContext, deserializeFromArray(jsonParser, deserializationContext));
            case FIELD_NAME:
            case END_OBJECT:
                return finishBuild(deserializationContext, deserializeFromObject(jsonParser, deserializationContext));
            default:
                throw deserializationContext.mappingException(handledType());
        }
    }

    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException, JsonProcessingException {
        return finishBuild(deserializationContext, _deserialize(jsonParser, deserializationContext, obj));
    }

    protected final Object _deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException, JsonProcessingException {
        if (this._injectables != null) {
            injectValues(deserializationContext, obj);
        }
        if (this._unwrappedPropertyHandler != null) {
            return deserializeWithUnwrapped(jsonParser, deserializationContext, obj);
        }
        if (this._externalTypeIdHandler != null) {
            return deserializeWithExternalTypeId(jsonParser, deserializationContext, obj);
        }
        if (this._needViewProcesing) {
            Class activeView = deserializationContext.getActiveView();
            if (activeView != null) {
                return deserializeWithView(jsonParser, deserializationContext, obj, activeView);
            }
        }
        JsonToken zU = jsonParser.zU();
        if (zU == JsonToken.START_OBJECT) {
            zU = jsonParser.zP();
        }
        while (zU == JsonToken.FIELD_NAME) {
            String zW = jsonParser.zW();
            jsonParser.zP();
            SettableBeanProperty find = this._beanProperties.find(zW);
            if (find != null) {
                try {
                    obj = find.deserializeSetAndReturn(jsonParser, deserializationContext, obj);
                } catch (Throwable e) {
                    wrapAndThrow(e, obj, zW, deserializationContext);
                }
            } else {
                handleUnknownVanilla(jsonParser, deserializationContext, handledType(), zW);
            }
            zU = jsonParser.zP();
        }
        return obj;
    }

    private final Object m2700a(JsonParser jsonParser, DeserializationContext deserializationContext, JsonToken jsonToken) throws IOException, JsonProcessingException {
        Object createUsingDefault = this._valueInstantiator.createUsingDefault(deserializationContext);
        while (jsonParser.zU() != JsonToken.END_OBJECT) {
            String zW = jsonParser.zW();
            jsonParser.zP();
            SettableBeanProperty find = this._beanProperties.find(zW);
            if (find != null) {
                try {
                    createUsingDefault = find.deserializeSetAndReturn(jsonParser, deserializationContext, createUsingDefault);
                } catch (Throwable e) {
                    wrapAndThrow(e, createUsingDefault, zW, deserializationContext);
                }
            } else {
                handleUnknownVanilla(jsonParser, deserializationContext, createUsingDefault, zW);
            }
            jsonParser.zP();
        }
        return createUsingDefault;
    }

    public Object deserializeFromObject(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        if (!this._nonStandardCreation) {
            Object createUsingDefault = this._valueInstantiator.createUsingDefault(deserializationContext);
            if (this._injectables != null) {
                injectValues(deserializationContext, createUsingDefault);
            }
            if (this._needViewProcesing) {
                Class activeView = deserializationContext.getActiveView();
                if (activeView != null) {
                    return deserializeWithView(jsonParser, deserializationContext, createUsingDefault, activeView);
                }
            }
            while (jsonParser.zU() != JsonToken.END_OBJECT) {
                String zW = jsonParser.zW();
                jsonParser.zP();
                SettableBeanProperty find = this._beanProperties.find(zW);
                if (find != null) {
                    try {
                        createUsingDefault = find.deserializeSetAndReturn(jsonParser, deserializationContext, createUsingDefault);
                    } catch (Throwable e) {
                        wrapAndThrow(e, createUsingDefault, zW, deserializationContext);
                    }
                } else {
                    handleUnknownVanilla(jsonParser, deserializationContext, createUsingDefault, zW);
                }
                jsonParser.zP();
            }
            return createUsingDefault;
        } else if (this._unwrappedPropertyHandler != null) {
            return deserializeWithUnwrapped(jsonParser, deserializationContext);
        } else {
            if (this._externalTypeIdHandler != null) {
                return deserializeWithExternalTypeId(jsonParser, deserializationContext);
            }
            return deserializeFromObjectUsingNonDefault(jsonParser, deserializationContext);
        }
    }

    protected final Object _deserializeUsingPropertyBased(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        aii com_fossil_aii = this._propertyBasedCreator;
        aik a = com_fossil_aii.m3396a(jsonParser, deserializationContext, this._objectIdReader);
        JsonToken zU = jsonParser.zU();
        amt com_fossil_amt = null;
        while (zU == JsonToken.FIELD_NAME) {
            Object a2;
            String zW = jsonParser.zW();
            jsonParser.zP();
            SettableBeanProperty bJ = com_fossil_aii.bJ(zW);
            if (bJ != null) {
                if (a.m3400a(bJ, bJ.deserialize(jsonParser, deserializationContext))) {
                    jsonParser.zP();
                    try {
                        a2 = com_fossil_aii.m3397a(deserializationContext, a);
                        if (a2.getClass() != this._beanType.getRawClass()) {
                            return handlePolymorphic(jsonParser, deserializationContext, a2, com_fossil_amt);
                        }
                        Object handleUnknownProperties;
                        if (com_fossil_amt != null) {
                            handleUnknownProperties = handleUnknownProperties(deserializationContext, a2, com_fossil_amt);
                        } else {
                            handleUnknownProperties = a2;
                        }
                        return _deserialize(jsonParser, deserializationContext, handleUnknownProperties);
                    } catch (Throwable e) {
                        wrapAndThrow(e, (Object) this._beanType.getRawClass(), zW, deserializationContext);
                    }
                } else {
                    continue;
                }
            } else if (!a.bK(zW)) {
                bJ = this._beanProperties.find(zW);
                if (bJ != null) {
                    a.m3402b(bJ, bJ.deserialize(jsonParser, deserializationContext));
                } else if (this._ignorableProps != null && this._ignorableProps.contains(zW)) {
                    handleIgnoredProperty(jsonParser, deserializationContext, handledType(), zW);
                } else if (this._anySetter != null) {
                    a.m3399a(this._anySetter, zW, this._anySetter.deserialize(jsonParser, deserializationContext));
                } else {
                    if (com_fossil_amt == null) {
                        com_fossil_amt = new amt(jsonParser);
                    }
                    com_fossil_amt.aQ(zW);
                    com_fossil_amt.mo1097b(jsonParser);
                }
            }
            zU = jsonParser.zP();
        }
        try {
            a2 = com_fossil_aii.m3397a(deserializationContext, a);
            if (com_fossil_amt == null) {
                return a2;
            }
            if (a2.getClass() != this._beanType.getRawClass()) {
                return handlePolymorphic(null, deserializationContext, a2, com_fossil_amt);
            }
            return handleUnknownProperties(deserializationContext, a2, com_fossil_amt);
        } catch (Throwable e2) {
            wrapInstantiationProblem(e2, deserializationContext);
            return null;
        }
    }

    protected final Object deserializeWithView(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, Class<?> cls) throws IOException, JsonProcessingException {
        JsonToken zU = jsonParser.zU();
        while (zU == JsonToken.FIELD_NAME) {
            String zW = jsonParser.zW();
            jsonParser.zP();
            SettableBeanProperty find = this._beanProperties.find(zW);
            if (find == null) {
                handleUnknownVanilla(jsonParser, deserializationContext, obj, zW);
            } else if (find.visibleInView(cls)) {
                try {
                    obj = find.deserializeSetAndReturn(jsonParser, deserializationContext, obj);
                } catch (Throwable e) {
                    wrapAndThrow(e, obj, zW, deserializationContext);
                }
            } else {
                jsonParser.zT();
            }
            zU = jsonParser.zP();
        }
        return obj;
    }

    protected Object deserializeWithUnwrapped(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        if (this._delegateDeserializer != null) {
            return this._valueInstantiator.createUsingDelegate(deserializationContext, this._delegateDeserializer.deserialize(jsonParser, deserializationContext));
        }
        if (this._propertyBasedCreator != null) {
            return deserializeUsingPropertyBasedWithUnwrapped(jsonParser, deserializationContext);
        }
        amt com_fossil_amt = new amt(jsonParser);
        com_fossil_amt.zJ();
        Object createUsingDefault = this._valueInstantiator.createUsingDefault(deserializationContext);
        if (this._injectables != null) {
            injectValues(deserializationContext, createUsingDefault);
        }
        Class activeView = this._needViewProcesing ? deserializationContext.getActiveView() : null;
        while (jsonParser.zU() != JsonToken.END_OBJECT) {
            String zW = jsonParser.zW();
            jsonParser.zP();
            SettableBeanProperty find = this._beanProperties.find(zW);
            if (find != null) {
                if (activeView == null || find.visibleInView(activeView)) {
                    try {
                        createUsingDefault = find.deserializeSetAndReturn(jsonParser, deserializationContext, createUsingDefault);
                    } catch (Throwable e) {
                        wrapAndThrow(e, createUsingDefault, zW, deserializationContext);
                    }
                } else {
                    jsonParser.zT();
                }
            } else if (this._ignorableProps == null || !this._ignorableProps.contains(zW)) {
                com_fossil_amt.aQ(zW);
                com_fossil_amt.mo1097b(jsonParser);
                if (this._anySetter != null) {
                    try {
                        this._anySetter.deserializeAndSet(jsonParser, deserializationContext, createUsingDefault, zW);
                    } catch (Throwable e2) {
                        wrapAndThrow(e2, createUsingDefault, zW, deserializationContext);
                    }
                }
            } else {
                handleIgnoredProperty(jsonParser, deserializationContext, createUsingDefault, zW);
            }
            jsonParser.zP();
        }
        com_fossil_amt.zK();
        this._unwrappedPropertyHandler.m3409a(jsonParser, deserializationContext, createUsingDefault, com_fossil_amt);
        return createUsingDefault;
    }

    protected Object deserializeWithUnwrapped(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException, JsonProcessingException {
        JsonToken zU = jsonParser.zU();
        if (zU == JsonToken.START_OBJECT) {
            zU = jsonParser.zP();
        }
        amt com_fossil_amt = new amt(jsonParser);
        com_fossil_amt.zJ();
        Class activeView = this._needViewProcesing ? deserializationContext.getActiveView() : null;
        while (zU == JsonToken.FIELD_NAME) {
            String zW = jsonParser.zW();
            SettableBeanProperty find = this._beanProperties.find(zW);
            jsonParser.zP();
            if (find != null) {
                if (activeView == null || find.visibleInView(activeView)) {
                    try {
                        obj = find.deserializeSetAndReturn(jsonParser, deserializationContext, obj);
                    } catch (Throwable e) {
                        wrapAndThrow(e, obj, zW, deserializationContext);
                    }
                } else {
                    jsonParser.zT();
                }
            } else if (this._ignorableProps == null || !this._ignorableProps.contains(zW)) {
                com_fossil_amt.aQ(zW);
                com_fossil_amt.mo1097b(jsonParser);
                if (this._anySetter != null) {
                    this._anySetter.deserializeAndSet(jsonParser, deserializationContext, obj, zW);
                }
            } else {
                handleIgnoredProperty(jsonParser, deserializationContext, obj, zW);
            }
            zU = jsonParser.zP();
        }
        com_fossil_amt.zK();
        this._unwrappedPropertyHandler.m3409a(jsonParser, deserializationContext, obj, com_fossil_amt);
        return obj;
    }

    protected Object deserializeUsingPropertyBasedWithUnwrapped(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        aii com_fossil_aii = this._propertyBasedCreator;
        aik a = com_fossil_aii.m3396a(jsonParser, deserializationContext, this._objectIdReader);
        amt com_fossil_amt = new amt(jsonParser);
        com_fossil_amt.zJ();
        JsonToken zU = jsonParser.zU();
        while (zU == JsonToken.FIELD_NAME) {
            String zW = jsonParser.zW();
            jsonParser.zP();
            SettableBeanProperty bJ = com_fossil_aii.bJ(zW);
            if (bJ != null) {
                if (a.m3400a(bJ, bJ.deserialize(jsonParser, deserializationContext))) {
                    zU = jsonParser.zP();
                    try {
                        Object a2 = com_fossil_aii.m3397a(deserializationContext, a);
                        while (zU == JsonToken.FIELD_NAME) {
                            jsonParser.zP();
                            com_fossil_amt.mo1097b(jsonParser);
                            zU = jsonParser.zP();
                        }
                        com_fossil_amt.zK();
                        if (a2.getClass() == this._beanType.getRawClass()) {
                            return this._unwrappedPropertyHandler.m3409a(jsonParser, deserializationContext, a2, com_fossil_amt);
                        }
                        throw deserializationContext.mappingException("Can not create polymorphic instances with unwrapped values");
                    } catch (Throwable e) {
                        wrapAndThrow(e, (Object) this._beanType.getRawClass(), zW, deserializationContext);
                    }
                } else {
                    continue;
                }
            } else if (!a.bK(zW)) {
                bJ = this._beanProperties.find(zW);
                if (bJ != null) {
                    a.m3402b(bJ, bJ.deserialize(jsonParser, deserializationContext));
                } else if (this._ignorableProps == null || !this._ignorableProps.contains(zW)) {
                    com_fossil_amt.aQ(zW);
                    com_fossil_amt.mo1097b(jsonParser);
                    if (this._anySetter != null) {
                        a.m3399a(this._anySetter, zW, this._anySetter.deserialize(jsonParser, deserializationContext));
                    }
                } else {
                    handleIgnoredProperty(jsonParser, deserializationContext, handledType(), zW);
                }
            }
            zU = jsonParser.zP();
        }
        try {
            return this._unwrappedPropertyHandler.m3409a(jsonParser, deserializationContext, com_fossil_aii.m3397a(deserializationContext, a), com_fossil_amt);
        } catch (Throwable e2) {
            wrapInstantiationProblem(e2, deserializationContext);
            return null;
        }
    }

    protected Object deserializeWithExternalTypeId(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        if (this._propertyBasedCreator != null) {
            return deserializeUsingPropertyBasedWithExternalTypeId(jsonParser, deserializationContext);
        }
        return deserializeWithExternalTypeId(jsonParser, deserializationContext, this._valueInstantiator.createUsingDefault(deserializationContext));
    }

    protected Object deserializeWithExternalTypeId(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException, JsonProcessingException {
        Class activeView = this._needViewProcesing ? deserializationContext.getActiveView() : null;
        aig EC = this._externalTypeIdHandler.EC();
        while (jsonParser.zU() != JsonToken.END_OBJECT) {
            String zW = jsonParser.zW();
            jsonParser.zP();
            SettableBeanProperty find = this._beanProperties.find(zW);
            if (find != null) {
                if (activeView == null || find.visibleInView(activeView)) {
                    try {
                        obj = find.deserializeSetAndReturn(jsonParser, deserializationContext, obj);
                    } catch (Throwable e) {
                        wrapAndThrow(e, obj, zW, deserializationContext);
                    }
                } else {
                    jsonParser.zT();
                }
            } else if (this._ignorableProps != null && this._ignorableProps.contains(zW)) {
                handleIgnoredProperty(jsonParser, deserializationContext, obj, zW);
            } else if (!EC.m3394b(jsonParser, deserializationContext, zW, obj)) {
                if (this._anySetter != null) {
                    try {
                        this._anySetter.deserializeAndSet(jsonParser, deserializationContext, obj, zW);
                    } catch (Throwable e2) {
                        wrapAndThrow(e2, obj, zW, deserializationContext);
                    }
                } else {
                    handleUnknownProperty(jsonParser, deserializationContext, obj, zW);
                }
            }
            jsonParser.zP();
        }
        return EC.m3391a(jsonParser, deserializationContext, obj);
    }

    protected Object deserializeUsingPropertyBasedWithExternalTypeId(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        throw new IllegalStateException("Deserialization with Builder, External type id, @JsonCreator not yet implemented");
    }
}
