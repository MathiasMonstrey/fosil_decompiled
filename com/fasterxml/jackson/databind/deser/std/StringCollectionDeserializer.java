package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fossil.agv;
import com.fossil.agy;
import com.fossil.ahh;
import com.fossil.ahv;
import com.fossil.aie;
import com.fossil.ajs;
import java.io.IOException;
import java.util.Collection;

@ahh
public final class StringCollectionDeserializer extends ContainerDeserializerBase<Collection<String>> implements ahv {
    private static final long serialVersionUID = 1;
    protected final JavaType _collectionType;
    protected final agy<Object> _delegateDeserializer;
    protected final agy<String> _valueDeserializer;
    protected final aie _valueInstantiator;

    public StringCollectionDeserializer(JavaType javaType, agy<?> com_fossil_agy_, aie com_fossil_aie) {
        this(javaType, com_fossil_aie, null, com_fossil_agy_);
    }

    protected StringCollectionDeserializer(JavaType javaType, aie com_fossil_aie, agy<?> com_fossil_agy_, agy<?> com_fossil_agy_2) {
        super(javaType);
        this._collectionType = javaType;
        this._valueDeserializer = com_fossil_agy_2;
        this._valueInstantiator = com_fossil_aie;
        this._delegateDeserializer = com_fossil_agy_;
    }

    protected StringCollectionDeserializer withResolved(agy<?> com_fossil_agy_, agy<?> com_fossil_agy_2) {
        return (this._valueDeserializer == com_fossil_agy_2 && this._delegateDeserializer == com_fossil_agy_) ? this : new StringCollectionDeserializer(this._collectionType, this._valueInstantiator, com_fossil_agy_, com_fossil_agy_2);
    }

    public boolean isCachable() {
        return this._valueDeserializer == null && this._delegateDeserializer == null;
    }

    public agy<?> createContextual(DeserializationContext deserializationContext, agv com_fossil_agv) throws JsonMappingException {
        agy com_fossil_agy;
        agy com_fossil_agy2 = null;
        if (this._valueInstantiator == null || this._valueInstantiator.getDelegateCreator() == null) {
            com_fossil_agy = null;
        } else {
            com_fossil_agy = findDeserializer(deserializationContext, this._valueInstantiator.getDelegateType(deserializationContext.getConfig()), com_fossil_agv);
        }
        agy com_fossil_agy3 = this._valueDeserializer;
        JavaType contentType = this._collectionType.getContentType();
        if (com_fossil_agy3 == null) {
            com_fossil_agy3 = findConvertingContentDeserializer(deserializationContext, com_fossil_agv, com_fossil_agy3);
            if (com_fossil_agy3 == null) {
                com_fossil_agy3 = deserializationContext.findContextualValueDeserializer(contentType, com_fossil_agv);
            }
        } else {
            com_fossil_agy3 = deserializationContext.handleSecondaryContextualization(com_fossil_agy3, com_fossil_agv, contentType);
        }
        if (!isDefaultDeserializer(com_fossil_agy3)) {
            com_fossil_agy2 = com_fossil_agy3;
        }
        return withResolved(com_fossil_agy, com_fossil_agy2);
    }

    public JavaType getContentType() {
        return this._collectionType.getContentType();
    }

    public agy<Object> getContentDeserializer() {
        return this._valueDeserializer;
    }

    public Collection<String> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (this._delegateDeserializer != null) {
            return (Collection) this._valueInstantiator.createUsingDelegate(deserializationContext, this._delegateDeserializer.deserialize(jsonParser, deserializationContext));
        }
        return deserialize(jsonParser, deserializationContext, (Collection) this._valueInstantiator.createUsingDefault(deserializationContext));
    }

    public Collection<String> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, Collection<String> collection) throws IOException {
        if (!jsonParser.Aa()) {
            return handleNonArray(jsonParser, deserializationContext, collection);
        }
        if (this._valueDeserializer != null) {
            return m2738a(jsonParser, deserializationContext, collection, this._valueDeserializer);
        }
        while (true) {
            try {
                Object zS = jsonParser.zS();
                if (zS != null) {
                    collection.add(zS);
                } else {
                    JsonToken zU = jsonParser.zU();
                    if (zU == JsonToken.END_ARRAY) {
                        return collection;
                    }
                    if (zU != JsonToken.VALUE_NULL) {
                        zS = _parseString(jsonParser, deserializationContext);
                    }
                    collection.add(zS);
                }
            } catch (Throwable e) {
                throw JsonMappingException.wrapWithPath(e, (Object) collection, collection.size());
            }
        }
    }

    private Collection<String> m2738a(JsonParser jsonParser, DeserializationContext deserializationContext, Collection<String> collection, agy<String> com_fossil_agy_java_lang_String) throws IOException {
        while (true) {
            Object obj;
            String str;
            if (jsonParser.zS() == null) {
                JsonToken zU = jsonParser.zU();
                if (zU == JsonToken.END_ARRAY) {
                    return collection;
                }
                if (zU == JsonToken.VALUE_NULL) {
                    obj = (String) com_fossil_agy_java_lang_String.getNullValue(deserializationContext);
                } else {
                    str = (String) com_fossil_agy_java_lang_String.deserialize(jsonParser, deserializationContext);
                }
            } else {
                str = (String) com_fossil_agy_java_lang_String.deserialize(jsonParser, deserializationContext);
            }
            collection.add(obj);
        }
    }

    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, ajs com_fossil_ajs) throws IOException {
        return com_fossil_ajs.deserializeTypedFromArray(jsonParser, deserializationContext);
    }

    private final Collection<String> handleNonArray(JsonParser jsonParser, DeserializationContext deserializationContext, Collection<String> collection) throws IOException {
        if (deserializationContext.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
            Object obj;
            agy com_fossil_agy = this._valueDeserializer;
            String str;
            if (jsonParser.zU() == JsonToken.VALUE_NULL) {
                if (com_fossil_agy == null) {
                    obj = null;
                } else {
                    str = (String) com_fossil_agy.getNullValue(deserializationContext);
                }
            } else if (com_fossil_agy == null) {
                obj = _parseString(jsonParser, deserializationContext);
            } else {
                str = (String) com_fossil_agy.deserialize(jsonParser, deserializationContext);
            }
            collection.add(obj);
            return collection;
        }
        throw deserializationContext.mappingException(this._collectionType.getRawClass());
    }
}
