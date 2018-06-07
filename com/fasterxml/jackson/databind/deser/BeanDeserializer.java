package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.impl.BeanAsArrayDeserializer;
import com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fossil.agu;
import com.fossil.agy;
import com.fossil.aht;
import com.fossil.aig;
import com.fossil.aii;
import com.fossil.aik;
import com.fossil.amo;
import com.fossil.amt;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;

public class BeanDeserializer extends BeanDeserializerBase implements Serializable {
    private static final long serialVersionUID = 1;

    public BeanDeserializer(aht com_fossil_aht, agu com_fossil_agu, BeanPropertyMap beanPropertyMap, Map<String, SettableBeanProperty> map, HashSet<String> hashSet, boolean z, boolean z2) {
        super(com_fossil_aht, com_fossil_agu, beanPropertyMap, map, hashSet, z, z2);
    }

    protected BeanDeserializer(BeanDeserializerBase beanDeserializerBase) {
        super(beanDeserializerBase, beanDeserializerBase._ignoreAllUnknown);
    }

    protected BeanDeserializer(BeanDeserializerBase beanDeserializerBase, boolean z) {
        super(beanDeserializerBase, z);
    }

    protected BeanDeserializer(BeanDeserializerBase beanDeserializerBase, amo com_fossil_amo) {
        super(beanDeserializerBase, com_fossil_amo);
    }

    public BeanDeserializer(BeanDeserializerBase beanDeserializerBase, ObjectIdReader objectIdReader) {
        super(beanDeserializerBase, objectIdReader);
    }

    public BeanDeserializer(BeanDeserializerBase beanDeserializerBase, HashSet<String> hashSet) {
        super(beanDeserializerBase, (HashSet) hashSet);
    }

    public agy<Object> unwrappingDeserializer(amo com_fossil_amo) {
        return getClass() != BeanDeserializer.class ? this : new BeanDeserializer((BeanDeserializerBase) this, com_fossil_amo);
    }

    public BeanDeserializer withObjectIdReader(ObjectIdReader objectIdReader) {
        return new BeanDeserializer((BeanDeserializerBase) this, objectIdReader);
    }

    public BeanDeserializer withIgnorableProperties(HashSet<String> hashSet) {
        return new BeanDeserializer((BeanDeserializerBase) this, (HashSet) hashSet);
    }

    protected BeanDeserializerBase asArrayDeserializer() {
        return new BeanAsArrayDeserializer(this, this._beanProperties.getPropertiesInInsertionOrder());
    }

    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (!jsonParser.Ab()) {
            return _deserializeOther(jsonParser, deserializationContext, jsonParser.zU());
        }
        if (this._vanillaProcessing) {
            return m2699a(jsonParser, deserializationContext, jsonParser.zP());
        }
        jsonParser.zP();
        if (this._objectIdReader != null) {
            return deserializeWithObjectId(jsonParser, deserializationContext);
        }
        return deserializeFromObject(jsonParser, deserializationContext);
    }

    protected final Object _deserializeOther(JsonParser jsonParser, DeserializationContext deserializationContext, JsonToken jsonToken) throws IOException {
        switch (jsonToken) {
            case VALUE_STRING:
                return deserializeFromString(jsonParser, deserializationContext);
            case VALUE_NUMBER_INT:
                return deserializeFromNumber(jsonParser, deserializationContext);
            case VALUE_NUMBER_FLOAT:
                return deserializeFromDouble(jsonParser, deserializationContext);
            case VALUE_EMBEDDED_OBJECT:
                return deserializeFromEmbedded(jsonParser, deserializationContext);
            case VALUE_TRUE:
            case VALUE_FALSE:
                return deserializeFromBoolean(jsonParser, deserializationContext);
            case START_ARRAY:
                return deserializeFromArray(jsonParser, deserializationContext);
            case FIELD_NAME:
            case END_OBJECT:
                if (this._vanillaProcessing) {
                    return m2699a(jsonParser, deserializationContext, jsonToken);
                }
                if (this._objectIdReader != null) {
                    return deserializeWithObjectId(jsonParser, deserializationContext);
                }
                return deserializeFromObject(jsonParser, deserializationContext);
            default:
                throw deserializationContext.mappingException(handledType());
        }
    }

    protected Object _missingToken(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        throw deserializationContext.endOfInputException(handledType());
    }

    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException {
        jsonParser.bm(obj);
        if (this._injectables != null) {
            injectValues(deserializationContext, obj);
        }
        if (this._unwrappedPropertyHandler != null) {
            return deserializeWithUnwrapped(jsonParser, deserializationContext, obj);
        }
        if (this._externalTypeIdHandler != null) {
            return deserializeWithExternalTypeId(jsonParser, deserializationContext, obj);
        }
        String zR;
        if (jsonParser.Ab()) {
            zR = jsonParser.zR();
            if (zR == null) {
                return obj;
            }
        } else if (!jsonParser.fn(5)) {
            return obj;
        } else {
            zR = jsonParser.zW();
        }
        if (this._needViewProcesing) {
            Class activeView = deserializationContext.getActiveView();
            if (activeView != null) {
                return deserializeWithView(jsonParser, deserializationContext, obj, activeView);
            }
        }
        do {
            jsonParser.zP();
            SettableBeanProperty find = this._beanProperties.find(zR);
            if (find != null) {
                try {
                    find.deserializeAndSet(jsonParser, deserializationContext, obj);
                } catch (Throwable e) {
                    wrapAndThrow(e, obj, zR, deserializationContext);
                }
            } else {
                handleUnknownVanilla(jsonParser, deserializationContext, obj, zR);
            }
            zR = jsonParser.zR();
        } while (zR != null);
        return obj;
    }

    private final Object m2699a(JsonParser jsonParser, DeserializationContext deserializationContext, JsonToken jsonToken) throws IOException {
        Object createUsingDefault = this._valueInstantiator.createUsingDefault(deserializationContext);
        jsonParser.bm(createUsingDefault);
        if (jsonParser.fn(5)) {
            String zW = jsonParser.zW();
            do {
                jsonParser.zP();
                SettableBeanProperty find = this._beanProperties.find(zW);
                if (find != null) {
                    try {
                        find.deserializeAndSet(jsonParser, deserializationContext, createUsingDefault);
                    } catch (Throwable e) {
                        wrapAndThrow(e, createUsingDefault, zW, deserializationContext);
                    }
                } else {
                    handleUnknownVanilla(jsonParser, deserializationContext, createUsingDefault, zW);
                }
                zW = jsonParser.zR();
            } while (zW != null);
        }
        return createUsingDefault;
    }

    public Object deserializeFromObject(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (this._objectIdReader != null && this._objectIdReader.maySerializeAsObject() && jsonParser.fn(5) && this._objectIdReader.isValidReferencePropertyName(jsonParser.zW(), jsonParser)) {
            return deserializeFromObjectId(jsonParser, deserializationContext);
        }
        Object Ax;
        if (!this._nonStandardCreation) {
            Object createUsingDefault = this._valueInstantiator.createUsingDefault(deserializationContext);
            jsonParser.bm(createUsingDefault);
            if (jsonParser.Av()) {
                Ax = jsonParser.Ax();
                if (Ax != null) {
                    _handleTypedObjectId(jsonParser, deserializationContext, createUsingDefault, Ax);
                }
            }
            if (this._injectables != null) {
                injectValues(deserializationContext, createUsingDefault);
            }
            if (this._needViewProcesing) {
                Class activeView = deserializationContext.getActiveView();
                if (activeView != null) {
                    return deserializeWithView(jsonParser, deserializationContext, createUsingDefault, activeView);
                }
            }
            if (jsonParser.fn(5)) {
                String zW = jsonParser.zW();
                do {
                    jsonParser.zP();
                    SettableBeanProperty find = this._beanProperties.find(zW);
                    if (find != null) {
                        try {
                            find.deserializeAndSet(jsonParser, deserializationContext, createUsingDefault);
                        } catch (Throwable e) {
                            wrapAndThrow(e, createUsingDefault, zW, deserializationContext);
                        }
                    } else {
                        handleUnknownVanilla(jsonParser, deserializationContext, createUsingDefault, zW);
                    }
                    zW = jsonParser.zR();
                } while (zW != null);
            }
            return createUsingDefault;
        } else if (this._unwrappedPropertyHandler != null) {
            return deserializeWithUnwrapped(jsonParser, deserializationContext);
        } else {
            if (this._externalTypeIdHandler != null) {
                return deserializeWithExternalTypeId(jsonParser, deserializationContext);
            }
            Ax = deserializeFromObjectUsingNonDefault(jsonParser, deserializationContext);
            if (this._injectables == null) {
                return Ax;
            }
            injectValues(deserializationContext, Ax);
            return Ax;
        }
    }

    protected Object _deserializeUsingPropertyBased(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
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
                if (a.m3400a(bJ, _deserializeWithErrorWrapping(jsonParser, deserializationContext, bJ))) {
                    jsonParser.zP();
                    try {
                        a2 = com_fossil_aii.m3397a(deserializationContext, a);
                    } catch (Throwable e) {
                        wrapInstantiationProblem(e, deserializationContext);
                        a2 = null;
                    }
                    if (a2 == null) {
                        throw deserializationContext.instantiationException(this._beanType.getRawClass(), "JSON Creator returned null");
                    }
                    jsonParser.bm(a2);
                    if (a2.getClass() != this._beanType.getRawClass()) {
                        return handlePolymorphic(jsonParser, deserializationContext, a2, com_fossil_amt);
                    }
                    Object handleUnknownProperties;
                    if (com_fossil_amt != null) {
                        handleUnknownProperties = handleUnknownProperties(deserializationContext, a2, com_fossil_amt);
                    } else {
                        handleUnknownProperties = a2;
                    }
                    return deserialize(jsonParser, deserializationContext, handleUnknownProperties);
                }
            } else if (!a.bK(zW)) {
                bJ = this._beanProperties.find(zW);
                if (bJ != null) {
                    a.m3402b(bJ, _deserializeWithErrorWrapping(jsonParser, deserializationContext, bJ));
                } else if (this._ignorableProps != null && this._ignorableProps.contains(zW)) {
                    handleIgnoredProperty(jsonParser, deserializationContext, handledType(), zW);
                } else if (this._anySetter != null) {
                    try {
                        a.m3399a(this._anySetter, zW, this._anySetter.deserialize(jsonParser, deserializationContext));
                    } catch (Throwable e2) {
                        wrapAndThrow(e2, (Object) this._beanType.getRawClass(), zW, deserializationContext);
                    }
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
        } catch (Throwable e22) {
            wrapInstantiationProblem(e22, deserializationContext);
            a2 = null;
        }
        if (com_fossil_amt == null) {
            return a2;
        }
        if (a2.getClass() != this._beanType.getRawClass()) {
            return handlePolymorphic(null, deserializationContext, a2, com_fossil_amt);
        }
        return handleUnknownProperties(deserializationContext, a2, com_fossil_amt);
    }

    protected final Object _deserializeWithErrorWrapping(JsonParser jsonParser, DeserializationContext deserializationContext, SettableBeanProperty settableBeanProperty) throws IOException {
        try {
            return settableBeanProperty.deserialize(jsonParser, deserializationContext);
        } catch (Throwable e) {
            wrapAndThrow(e, (Object) this._beanType.getRawClass(), settableBeanProperty.getName(), deserializationContext);
            return null;
        }
    }

    protected final Object deserializeWithView(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, Class<?> cls) throws IOException {
        if (jsonParser.fn(5)) {
            String zW = jsonParser.zW();
            do {
                jsonParser.zP();
                SettableBeanProperty find = this._beanProperties.find(zW);
                if (find == null) {
                    handleUnknownVanilla(jsonParser, deserializationContext, obj, zW);
                } else if (find.visibleInView(cls)) {
                    try {
                        find.deserializeAndSet(jsonParser, deserializationContext, obj);
                    } catch (Throwable e) {
                        wrapAndThrow(e, obj, zW, deserializationContext);
                    }
                } else {
                    jsonParser.zT();
                }
                zW = jsonParser.zR();
            } while (zW != null);
        }
        return obj;
    }

    protected Object deserializeWithUnwrapped(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String str = null;
        if (this._delegateDeserializer != null) {
            return this._valueInstantiator.createUsingDelegate(deserializationContext, this._delegateDeserializer.deserialize(jsonParser, deserializationContext));
        }
        if (this._propertyBasedCreator != null) {
            return deserializeUsingPropertyBasedWithUnwrapped(jsonParser, deserializationContext);
        }
        Class activeView;
        amt com_fossil_amt = new amt(jsonParser);
        com_fossil_amt.zJ();
        Object createUsingDefault = this._valueInstantiator.createUsingDefault(deserializationContext);
        jsonParser.bm(createUsingDefault);
        if (this._injectables != null) {
            injectValues(deserializationContext, createUsingDefault);
        }
        if (this._needViewProcesing) {
            activeView = deserializationContext.getActiveView();
        } else {
            activeView = null;
        }
        if (jsonParser.fn(5)) {
            str = jsonParser.zW();
        }
        String str2 = str;
        while (str2 != null) {
            jsonParser.zP();
            SettableBeanProperty find = this._beanProperties.find(str2);
            if (find != null) {
                if (activeView == null || find.visibleInView(activeView)) {
                    try {
                        find.deserializeAndSet(jsonParser, deserializationContext, createUsingDefault);
                    } catch (Throwable e) {
                        wrapAndThrow(e, createUsingDefault, str2, deserializationContext);
                    }
                } else {
                    jsonParser.zT();
                }
            } else if (this._ignorableProps == null || !this._ignorableProps.contains(str2)) {
                com_fossil_amt.aQ(str2);
                com_fossil_amt.mo1097b(jsonParser);
                if (this._anySetter != null) {
                    try {
                        this._anySetter.deserializeAndSet(jsonParser, deserializationContext, createUsingDefault, str2);
                    } catch (Throwable e2) {
                        wrapAndThrow(e2, createUsingDefault, str2, deserializationContext);
                    }
                }
            } else {
                handleIgnoredProperty(jsonParser, deserializationContext, createUsingDefault, str2);
            }
            str2 = jsonParser.zR();
        }
        com_fossil_amt.zK();
        this._unwrappedPropertyHandler.m3409a(jsonParser, deserializationContext, createUsingDefault, com_fossil_amt);
        return createUsingDefault;
    }

    protected Object deserializeWithUnwrapped(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException {
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
                        find.deserializeAndSet(jsonParser, deserializationContext, obj);
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

    protected Object deserializeUsingPropertyBasedWithUnwrapped(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
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
                if (a.m3400a(bJ, _deserializeWithErrorWrapping(jsonParser, deserializationContext, bJ))) {
                    zU = jsonParser.zP();
                    try {
                        Object a2 = com_fossil_aii.m3397a(deserializationContext, a);
                        jsonParser.bm(a2);
                        while (zU == JsonToken.FIELD_NAME) {
                            jsonParser.zP();
                            com_fossil_amt.mo1097b(jsonParser);
                            zU = jsonParser.zP();
                        }
                        com_fossil_amt.zK();
                        if (a2.getClass() == this._beanType.getRawClass()) {
                            return this._unwrappedPropertyHandler.m3409a(jsonParser, deserializationContext, a2, com_fossil_amt);
                        }
                        com_fossil_amt.close();
                        throw deserializationContext.mappingException("Can not create polymorphic instances with unwrapped values");
                    } catch (Throwable e) {
                        wrapInstantiationProblem(e, deserializationContext);
                    }
                } else {
                    continue;
                }
            } else if (!a.bK(zW)) {
                bJ = this._beanProperties.find(zW);
                if (bJ != null) {
                    a.m3402b(bJ, _deserializeWithErrorWrapping(jsonParser, deserializationContext, bJ));
                } else if (this._ignorableProps == null || !this._ignorableProps.contains(zW)) {
                    com_fossil_amt.aQ(zW);
                    com_fossil_amt.mo1097b(jsonParser);
                    if (this._anySetter != null) {
                        try {
                            a.m3399a(this._anySetter, zW, this._anySetter.deserialize(jsonParser, deserializationContext));
                        } catch (Throwable e2) {
                            wrapAndThrow(e2, (Object) this._beanType.getRawClass(), zW, deserializationContext);
                        }
                    }
                } else {
                    handleIgnoredProperty(jsonParser, deserializationContext, handledType(), zW);
                }
            }
            zU = jsonParser.zP();
        }
        try {
            return this._unwrappedPropertyHandler.m3409a(jsonParser, deserializationContext, com_fossil_aii.m3397a(deserializationContext, a), com_fossil_amt);
        } catch (Throwable e22) {
            wrapInstantiationProblem(e22, deserializationContext);
            return null;
        }
    }

    protected Object deserializeWithExternalTypeId(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (this._propertyBasedCreator != null) {
            return deserializeUsingPropertyBasedWithExternalTypeId(jsonParser, deserializationContext);
        }
        return deserializeWithExternalTypeId(jsonParser, deserializationContext, this._valueInstantiator.createUsingDefault(deserializationContext));
    }

    protected Object deserializeWithExternalTypeId(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException {
        Class activeView = this._needViewProcesing ? deserializationContext.getActiveView() : null;
        aig EC = this._externalTypeIdHandler.EC();
        JsonToken zU = jsonParser.zU();
        while (zU == JsonToken.FIELD_NAME) {
            String zW = jsonParser.zW();
            zU = jsonParser.zP();
            SettableBeanProperty find = this._beanProperties.find(zW);
            if (find != null) {
                if (zU.isScalarValue()) {
                    EC.m3393a(jsonParser, deserializationContext, zW, obj);
                }
                if (activeView == null || find.visibleInView(activeView)) {
                    try {
                        find.deserializeAndSet(jsonParser, deserializationContext, obj);
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
            zU = jsonParser.zP();
        }
        return EC.m3391a(jsonParser, deserializationContext, obj);
    }

    protected Object deserializeUsingPropertyBasedWithExternalTypeId(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Object obj = null;
        aig EC = this._externalTypeIdHandler.EC();
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
                if (!EC.m3394b(jsonParser, deserializationContext, zW, a) && a.m3400a(bJ, _deserializeWithErrorWrapping(jsonParser, deserializationContext, bJ))) {
                    zU = jsonParser.zP();
                    try {
                        obj = com_fossil_aii.m3397a(deserializationContext, a);
                        while (zU == JsonToken.FIELD_NAME) {
                            jsonParser.zP();
                            com_fossil_amt.mo1097b(jsonParser);
                            zU = jsonParser.zP();
                        }
                        if (obj.getClass() == this._beanType.getRawClass()) {
                            return EC.m3391a(jsonParser, deserializationContext, obj);
                        }
                        throw deserializationContext.mappingException("Can not create polymorphic instances with unwrapped values");
                    } catch (Throwable e) {
                        wrapAndThrow(e, (Object) this._beanType.getRawClass(), zW, deserializationContext);
                    }
                }
            } else if (!a.bK(zW)) {
                bJ = this._beanProperties.find(zW);
                if (bJ != null) {
                    a.m3402b(bJ, bJ.deserialize(jsonParser, deserializationContext));
                } else if (!EC.m3394b(jsonParser, deserializationContext, zW, obj)) {
                    if (this._ignorableProps != null && this._ignorableProps.contains(zW)) {
                        handleIgnoredProperty(jsonParser, deserializationContext, handledType(), zW);
                    } else if (this._anySetter != null) {
                        a.m3399a(this._anySetter, zW, this._anySetter.deserialize(jsonParser, deserializationContext));
                    }
                }
            }
            zU = jsonParser.zP();
        }
        try {
            return EC.m3390a(jsonParser, deserializationContext, a, com_fossil_aii);
        } catch (Throwable e2) {
            wrapInstantiationProblem(e2, deserializationContext);
            return obj;
        }
    }
}
