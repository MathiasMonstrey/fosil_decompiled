package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fossil.agv;
import com.fossil.agy;
import com.fossil.ahh;
import com.fossil.ahv;
import com.fossil.ajs;
import com.fossil.amp;
import java.io.IOException;
import java.lang.reflect.Array;

@ahh
public class ObjectArrayDeserializer extends ContainerDeserializerBase<Object[]> implements ahv {
    private static final long serialVersionUID = 1;
    protected final ArrayType _arrayType;
    protected final Class<?> _elementClass;
    protected agy<Object> _elementDeserializer;
    protected final ajs _elementTypeDeserializer;
    protected final boolean _untyped;

    public ObjectArrayDeserializer(ArrayType arrayType, agy<Object> com_fossil_agy_java_lang_Object, ajs com_fossil_ajs) {
        super((JavaType) arrayType);
        this._arrayType = arrayType;
        this._elementClass = arrayType.getContentType().getRawClass();
        this._untyped = this._elementClass == Object.class;
        this._elementDeserializer = com_fossil_agy_java_lang_Object;
        this._elementTypeDeserializer = com_fossil_ajs;
    }

    public ObjectArrayDeserializer withDeserializer(ajs com_fossil_ajs, agy<?> com_fossil_agy_) {
        return (com_fossil_agy_ == this._elementDeserializer && com_fossil_ajs == this._elementTypeDeserializer) ? this : new ObjectArrayDeserializer(this._arrayType, com_fossil_agy_, com_fossil_ajs);
    }

    public agy<?> createContextual(DeserializationContext deserializationContext, agv com_fossil_agv) throws JsonMappingException {
        agy findConvertingContentDeserializer = findConvertingContentDeserializer(deserializationContext, com_fossil_agv, this._elementDeserializer);
        JavaType contentType = this._arrayType.getContentType();
        if (findConvertingContentDeserializer == null) {
            findConvertingContentDeserializer = deserializationContext.findContextualValueDeserializer(contentType, com_fossil_agv);
        } else {
            findConvertingContentDeserializer = deserializationContext.handleSecondaryContextualization(findConvertingContentDeserializer, com_fossil_agv, contentType);
        }
        ajs com_fossil_ajs = this._elementTypeDeserializer;
        if (com_fossil_ajs != null) {
            com_fossil_ajs = com_fossil_ajs.forProperty(com_fossil_agv);
        }
        return withDeserializer(com_fossil_ajs, findConvertingContentDeserializer);
    }

    public boolean isCachable() {
        return this._elementDeserializer == null && this._elementTypeDeserializer == null;
    }

    public JavaType getContentType() {
        return this._arrayType.getContentType();
    }

    public agy<Object> getContentDeserializer() {
        return this._elementDeserializer;
    }

    public Object[] deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        if (!jsonParser.Aa()) {
            return m2729a(jsonParser, deserializationContext);
        }
        Object[] c;
        amp leaseObjectBuffer = deserializationContext.leaseObjectBuffer();
        Object[] Ho = leaseObjectBuffer.Ho();
        ajs com_fossil_ajs = this._elementTypeDeserializer;
        int i = 0;
        while (true) {
            JsonToken zP = jsonParser.zP();
            if (zP == JsonToken.END_ARRAY) {
                break;
            }
            Object nullValue;
            int i2;
            if (zP == JsonToken.VALUE_NULL) {
                nullValue = this._elementDeserializer.getNullValue(deserializationContext);
            } else if (com_fossil_ajs == null) {
                try {
                    nullValue = this._elementDeserializer.deserialize(jsonParser, deserializationContext);
                } catch (Throwable e) {
                    throw JsonMappingException.wrapWithPath(e, (Object) Ho, i + leaseObjectBuffer.Hq());
                }
            } else {
                nullValue = this._elementDeserializer.deserializeWithType(jsonParser, deserializationContext, com_fossil_ajs);
            }
            if (i >= Ho.length) {
                Ho = leaseObjectBuffer.m3889c(Ho);
                i2 = 0;
            } else {
                i2 = i;
            }
            i = i2 + 1;
            Ho[i2] = nullValue;
        }
        if (this._untyped) {
            c = leaseObjectBuffer.m3890c(Ho, i);
        } else {
            c = leaseObjectBuffer.m3888a(Ho, i, this._elementClass);
        }
        deserializationContext.returnObjectBuffer(leaseObjectBuffer);
        return c;
    }

    public Object[] deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, ajs com_fossil_ajs) throws IOException, JsonProcessingException {
        return (Object[]) com_fossil_ajs.deserializeTypedFromArray(jsonParser, deserializationContext);
    }

    protected Byte[] deserializeFromBase64(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        byte[] a = jsonParser.mo906a(deserializationContext.getBase64Variant());
        Byte[] bArr = new Byte[a.length];
        int length = a.length;
        for (int i = 0; i < length; i++) {
            bArr[i] = Byte.valueOf(a[i]);
        }
        return bArr;
    }

    private final Object[] m2729a(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        if (jsonParser.zU() == JsonToken.VALUE_STRING && deserializationContext.isEnabled(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT) && jsonParser.getText().length() == 0) {
            return null;
        }
        if (deserializationContext.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
            Object nullValue;
            Object[] objArr;
            if (jsonParser.zU() == JsonToken.VALUE_NULL) {
                nullValue = this._elementDeserializer.getNullValue(deserializationContext);
            } else if (this._elementTypeDeserializer == null) {
                nullValue = this._elementDeserializer.deserialize(jsonParser, deserializationContext);
            } else {
                nullValue = this._elementDeserializer.deserializeWithType(jsonParser, deserializationContext, this._elementTypeDeserializer);
            }
            if (this._untyped) {
                objArr = new Object[1];
            } else {
                objArr = (Object[]) Array.newInstance(this._elementClass, 1);
            }
            objArr[0] = nullValue;
            return objArr;
        } else if (jsonParser.zU() == JsonToken.VALUE_STRING && this._elementClass == Byte.class) {
            return deserializeFromBase64(jsonParser, deserializationContext);
        } else {
            throw deserializationContext.mappingException(this._arrayType.getRawClass());
        }
    }
}
