package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.BeanDeserializerBase;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fossil.agy;
import com.fossil.aii;
import com.fossil.aik;
import com.fossil.amo;
import java.io.IOException;
import java.util.HashSet;

public class BeanAsArrayBuilderDeserializer extends BeanDeserializerBase {
    private static final long serialVersionUID = 1;
    protected final AnnotatedMethod _buildMethod;
    protected final BeanDeserializerBase _delegate;
    protected final SettableBeanProperty[] _orderedProperties;

    public BeanAsArrayBuilderDeserializer(BeanDeserializerBase beanDeserializerBase, SettableBeanProperty[] settableBeanPropertyArr, AnnotatedMethod annotatedMethod) {
        super(beanDeserializerBase);
        this._delegate = beanDeserializerBase;
        this._orderedProperties = settableBeanPropertyArr;
        this._buildMethod = annotatedMethod;
    }

    public agy<Object> unwrappingDeserializer(amo com_fossil_amo) {
        return this._delegate.unwrappingDeserializer(com_fossil_amo);
    }

    public BeanAsArrayBuilderDeserializer withObjectIdReader(ObjectIdReader objectIdReader) {
        return new BeanAsArrayBuilderDeserializer(this._delegate.withObjectIdReader(objectIdReader), this._orderedProperties, this._buildMethod);
    }

    public BeanAsArrayBuilderDeserializer withIgnorableProperties(HashSet<String> hashSet) {
        return new BeanAsArrayBuilderDeserializer(this._delegate.withIgnorableProperties(hashSet), this._orderedProperties, this._buildMethod);
    }

    protected BeanAsArrayBuilderDeserializer asArrayDeserializer() {
        return this;
    }

    protected final Object finishBuild(DeserializationContext deserializationContext, Object obj) throws IOException {
        try {
            return this._buildMethod.getMember().invoke(obj, new Object[0]);
        } catch (Throwable e) {
            wrapInstantiationProblem(e, deserializationContext);
            return null;
        }
    }

    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (!jsonParser.Aa()) {
            return finishBuild(deserializationContext, _deserializeFromNonArray(jsonParser, deserializationContext));
        }
        if (!this._vanillaProcessing) {
            return finishBuild(deserializationContext, _deserializeNonVanilla(jsonParser, deserializationContext));
        }
        Object createUsingDefault = this._valueInstantiator.createUsingDefault(deserializationContext);
        SettableBeanProperty[] settableBeanPropertyArr = this._orderedProperties;
        int length = settableBeanPropertyArr.length;
        Object obj = createUsingDefault;
        int i = 0;
        while (jsonParser.zP() != JsonToken.END_ARRAY) {
            if (i != length) {
                SettableBeanProperty settableBeanProperty = settableBeanPropertyArr[i];
                if (settableBeanProperty != null) {
                    try {
                        obj = settableBeanProperty.deserializeSetAndReturn(jsonParser, deserializationContext, obj);
                    } catch (Throwable e) {
                        wrapAndThrow(e, obj, settableBeanProperty.getName(), deserializationContext);
                    }
                } else {
                    jsonParser.zT();
                }
                i++;
            } else if (this._ignoreAllUnknown) {
                while (jsonParser.zP() != JsonToken.END_ARRAY) {
                    jsonParser.zT();
                }
                return finishBuild(deserializationContext, obj);
            } else {
                throw deserializationContext.mappingException("Unexpected JSON values; expected at most %d properties (in JSON Array)", Integer.valueOf(length));
            }
        }
        return finishBuild(deserializationContext, obj);
    }

    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException {
        if (this._injectables != null) {
            injectValues(deserializationContext, obj);
        }
        SettableBeanProperty[] settableBeanPropertyArr = this._orderedProperties;
        int length = settableBeanPropertyArr.length;
        int i = 0;
        while (jsonParser.zP() != JsonToken.END_ARRAY) {
            if (i != length) {
                SettableBeanProperty settableBeanProperty = settableBeanPropertyArr[i];
                if (settableBeanProperty != null) {
                    try {
                        obj = settableBeanProperty.deserializeSetAndReturn(jsonParser, deserializationContext, obj);
                    } catch (Throwable e) {
                        wrapAndThrow(e, obj, settableBeanProperty.getName(), deserializationContext);
                    }
                } else {
                    jsonParser.zT();
                }
                i++;
            } else if (this._ignoreAllUnknown) {
                while (jsonParser.zP() != JsonToken.END_ARRAY) {
                    jsonParser.zT();
                }
                return finishBuild(deserializationContext, obj);
            } else {
                throw deserializationContext.mappingException("Unexpected JSON values; expected at most %d properties (in JSON Array)", Integer.valueOf(length));
            }
        }
        return finishBuild(deserializationContext, obj);
    }

    public Object deserializeFromObject(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return _deserializeFromNonArray(jsonParser, deserializationContext);
    }

    protected Object _deserializeNonVanilla(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (this._nonStandardCreation) {
            return _deserializeWithCreator(jsonParser, deserializationContext);
        }
        Object createUsingDefault = this._valueInstantiator.createUsingDefault(deserializationContext);
        if (this._injectables != null) {
            injectValues(deserializationContext, createUsingDefault);
        }
        Class activeView = this._needViewProcesing ? deserializationContext.getActiveView() : null;
        SettableBeanProperty[] settableBeanPropertyArr = this._orderedProperties;
        int length = settableBeanPropertyArr.length;
        int i = 0;
        while (jsonParser.zP() != JsonToken.END_ARRAY) {
            if (i != length) {
                SettableBeanProperty settableBeanProperty = settableBeanPropertyArr[i];
                i++;
                if (settableBeanProperty == null || !(activeView == null || settableBeanProperty.visibleInView(activeView))) {
                    jsonParser.zT();
                } else {
                    try {
                        settableBeanProperty.deserializeSetAndReturn(jsonParser, deserializationContext, createUsingDefault);
                    } catch (Throwable e) {
                        wrapAndThrow(e, createUsingDefault, settableBeanProperty.getName(), deserializationContext);
                    }
                }
            } else if (this._ignoreAllUnknown) {
                while (jsonParser.zP() != JsonToken.END_ARRAY) {
                    jsonParser.zT();
                }
                return createUsingDefault;
            } else {
                throw deserializationContext.mappingException("Unexpected JSON values; expected at most %d properties (in JSON Array)", Integer.valueOf(length));
            }
        }
        return createUsingDefault;
    }

    protected Object _deserializeWithCreator(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (this._delegateDeserializer != null) {
            return this._valueInstantiator.createUsingDelegate(deserializationContext, this._delegateDeserializer.deserialize(jsonParser, deserializationContext));
        }
        if (this._propertyBasedCreator != null) {
            return _deserializeUsingPropertyBased(jsonParser, deserializationContext);
        }
        if (this._beanType.isAbstract()) {
            throw JsonMappingException.from(jsonParser, "Can not instantiate abstract type " + this._beanType + " (need to add/enable type information?)");
        }
        throw JsonMappingException.from(jsonParser, "No suitable constructor found for type " + this._beanType + ": can not instantiate from JSON object (need to add/enable type information?)");
    }

    protected final Object _deserializeUsingPropertyBased(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        aii com_fossil_aii = this._propertyBasedCreator;
        aik a = com_fossil_aii.m3396a(jsonParser, deserializationContext, this._objectIdReader);
        SettableBeanProperty[] settableBeanPropertyArr = this._orderedProperties;
        int length = settableBeanPropertyArr.length;
        Object obj = null;
        int i = 0;
        while (jsonParser.zP() != JsonToken.END_ARRAY) {
            SettableBeanProperty settableBeanProperty;
            if (i < length) {
                settableBeanProperty = settableBeanPropertyArr[i];
            } else {
                settableBeanProperty = null;
            }
            if (settableBeanProperty == null) {
                jsonParser.zT();
            } else if (obj != null) {
                try {
                    obj = settableBeanProperty.deserializeSetAndReturn(jsonParser, deserializationContext, obj);
                } catch (Throwable e) {
                    wrapAndThrow(e, obj, settableBeanProperty.getName(), deserializationContext);
                }
            } else {
                String name = settableBeanProperty.getName();
                SettableBeanProperty bJ = com_fossil_aii.bJ(name);
                if (bJ != null) {
                    if (a.m3400a(bJ, bJ.deserialize(jsonParser, deserializationContext))) {
                        try {
                            obj = com_fossil_aii.m3397a(deserializationContext, a);
                            if (obj.getClass() != this._beanType.getRawClass()) {
                                throw deserializationContext.mappingException("Can not support implicit polymorphic deserialization for POJOs-as-Arrays style: nominal type %s, actual type %s", this._beanType.getRawClass().getName(), obj.getClass().getName());
                            }
                        } catch (Throwable e2) {
                            wrapAndThrow(e2, (Object) this._beanType.getRawClass(), name, deserializationContext);
                        }
                    } else {
                        continue;
                    }
                } else if (!a.bK(name)) {
                    a.m3402b(settableBeanProperty, settableBeanProperty.deserialize(jsonParser, deserializationContext));
                }
            }
            i++;
        }
        if (obj == null) {
            try {
                obj = com_fossil_aii.m3397a(deserializationContext, a);
            } catch (Throwable e3) {
                wrapInstantiationProblem(e3, deserializationContext);
                return null;
            }
        }
        return obj;
    }

    protected Object _deserializeFromNonArray(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        throw deserializationContext.mappingException("Can not deserialize a POJO (of type %s) from non-Array representation (token: %s): type/property designed to be serialized as JSON Array", this._beanType.getRawClass().getName(), jsonParser.zU());
    }
}
