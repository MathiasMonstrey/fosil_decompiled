package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fossil.agy;
import com.fossil.aie;
import com.fossil.ajs;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueDeserializer extends CollectionDeserializer {
    private static final long serialVersionUID = 1;

    public ArrayBlockingQueueDeserializer(JavaType javaType, agy<Object> com_fossil_agy_java_lang_Object, ajs com_fossil_ajs, aie com_fossil_aie, agy<Object> com_fossil_agy_java_lang_Object2) {
        super(javaType, com_fossil_agy_java_lang_Object, com_fossil_ajs, com_fossil_aie, com_fossil_agy_java_lang_Object2);
    }

    protected ArrayBlockingQueueDeserializer(ArrayBlockingQueueDeserializer arrayBlockingQueueDeserializer) {
        super(arrayBlockingQueueDeserializer);
    }

    protected ArrayBlockingQueueDeserializer withResolved(agy<?> com_fossil_agy_, agy<?> com_fossil_agy_2, ajs com_fossil_ajs) {
        if (com_fossil_agy_ == this._delegateDeserializer && com_fossil_agy_2 == this._valueDeserializer && com_fossil_ajs == this._valueTypeDeserializer) {
            return this;
        }
        return new ArrayBlockingQueueDeserializer(this._collectionType, com_fossil_agy_2, com_fossil_ajs, this._valueInstantiator, com_fossil_agy_);
    }

    public Collection<Object> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (this._delegateDeserializer != null) {
            return (Collection) this._valueInstantiator.createUsingDelegate(deserializationContext, this._delegateDeserializer.deserialize(jsonParser, deserializationContext));
        }
        if (jsonParser.zU() == JsonToken.VALUE_STRING) {
            String text = jsonParser.getText();
            if (text.length() == 0) {
                return (Collection) this._valueInstantiator.createFromString(deserializationContext, text);
            }
        }
        return deserialize(jsonParser, deserializationContext, null);
    }

    public Collection<Object> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, Collection<Object> collection) throws IOException {
        if (!jsonParser.Aa()) {
            return handleNonArray(jsonParser, deserializationContext, new ArrayBlockingQueue(1));
        }
        Object arrayList = new ArrayList();
        agy com_fossil_agy = this._valueDeserializer;
        ajs com_fossil_ajs = this._valueTypeDeserializer;
        while (true) {
            try {
                JsonToken zP = jsonParser.zP();
                if (zP == JsonToken.END_ARRAY) {
                    break;
                }
                Object nullValue;
                if (zP == JsonToken.VALUE_NULL) {
                    nullValue = com_fossil_agy.getNullValue(deserializationContext);
                } else if (com_fossil_ajs == null) {
                    nullValue = com_fossil_agy.deserialize(jsonParser, deserializationContext);
                } else {
                    nullValue = com_fossil_agy.deserializeWithType(jsonParser, deserializationContext, com_fossil_ajs);
                }
                arrayList.add(nullValue);
            } catch (Throwable e) {
                throw JsonMappingException.wrapWithPath(e, arrayList, arrayList.size());
            }
        }
        if (collection == null) {
            return new ArrayBlockingQueue(arrayList.size(), false, arrayList);
        }
        collection.addAll(arrayList);
        return collection;
    }

    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, ajs com_fossil_ajs) throws IOException {
        return com_fossil_ajs.deserializeTypedFromArray(jsonParser, deserializationContext);
    }
}
