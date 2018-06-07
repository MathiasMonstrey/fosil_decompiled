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
import com.fossil.ajs;
import com.fossil.amp;
import java.io.IOException;

@ahh
public final class StringArrayDeserializer extends StdDeserializer<String[]> implements ahv {
    public static final StringArrayDeserializer instance = new StringArrayDeserializer();
    private static final long serialVersionUID = 1;
    protected agy<String> _elementDeserializer;

    public StringArrayDeserializer() {
        super(String[].class);
        this._elementDeserializer = null;
    }

    protected StringArrayDeserializer(agy<?> com_fossil_agy_) {
        super(String[].class);
        this._elementDeserializer = com_fossil_agy_;
    }

    public String[] deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (!jsonParser.Aa()) {
            return m2737i(jsonParser, deserializationContext);
        }
        if (this._elementDeserializer != null) {
            return _deserializeCustom(jsonParser, deserializationContext);
        }
        amp leaseObjectBuffer = deserializationContext.leaseObjectBuffer();
        Object Ho = leaseObjectBuffer.Ho();
        int i = 0;
        while (true) {
            String _parseString;
            int i2;
            String zS = jsonParser.zS();
            if (zS == null) {
                JsonToken zU = jsonParser.zU();
                if (zU == JsonToken.END_ARRAY) {
                    String[] strArr = (String[]) leaseObjectBuffer.m3888a((Object[]) Ho, i, String.class);
                    deserializationContext.returnObjectBuffer(leaseObjectBuffer);
                    return strArr;
                }
                try {
                    if (zU != JsonToken.VALUE_NULL) {
                        _parseString = _parseString(jsonParser, deserializationContext);
                        if (i < Ho.length) {
                            Ho = leaseObjectBuffer.m3889c(Ho);
                            i2 = 0;
                        } else {
                            i2 = i;
                        }
                        i = i2 + 1;
                        Ho[i2] = _parseString;
                    }
                } catch (Throwable e) {
                    throw JsonMappingException.wrapWithPath(e, Ho, i + leaseObjectBuffer.Hq());
                }
            }
            _parseString = zS;
            if (i < Ho.length) {
                i2 = i;
            } else {
                Ho = leaseObjectBuffer.m3889c(Ho);
                i2 = 0;
            }
            i = i2 + 1;
            Ho[i2] = _parseString;
        }
    }

    protected final String[] _deserializeCustom(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        amp leaseObjectBuffer = deserializationContext.leaseObjectBuffer();
        Object[] Ho = leaseObjectBuffer.Ho();
        agy com_fossil_agy = this._elementDeserializer;
        int i = 0;
        while (true) {
            String str;
            int i2;
            if (jsonParser.zS() == null) {
                JsonToken zU = jsonParser.zU();
                if (zU == JsonToken.END_ARRAY) {
                    String[] strArr = (String[]) leaseObjectBuffer.m3888a(Ho, i, String.class);
                    deserializationContext.returnObjectBuffer(leaseObjectBuffer);
                    return strArr;
                }
                try {
                    str = zU == JsonToken.VALUE_NULL ? (String) com_fossil_agy.getNullValue(deserializationContext) : (String) com_fossil_agy.deserialize(jsonParser, deserializationContext);
                } catch (Throwable e) {
                    throw JsonMappingException.wrapWithPath(e, (Object) String.class, i);
                }
            }
            str = (String) com_fossil_agy.deserialize(jsonParser, deserializationContext);
            if (i >= Ho.length) {
                Ho = leaseObjectBuffer.m3889c(Ho);
                i2 = 0;
            } else {
                i2 = i;
            }
            i = i2 + 1;
            Ho[i2] = str;
        }
    }

    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, ajs com_fossil_ajs) throws IOException {
        return com_fossil_ajs.deserializeTypedFromArray(jsonParser, deserializationContext);
    }

    private final String[] m2737i(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String[] strArr = null;
        if (deserializationContext.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
            String[] strArr2 = new String[1];
            if (jsonParser.zU() != JsonToken.VALUE_NULL) {
                strArr = _parseString(jsonParser, deserializationContext);
            }
            strArr2[0] = strArr;
            return strArr2;
        } else if (jsonParser.zU() == JsonToken.VALUE_STRING && deserializationContext.isEnabled(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT) && jsonParser.getText().length() == 0) {
            return null;
        } else {
            throw deserializationContext.mappingException(this._valueClass);
        }
    }

    public agy<?> createContextual(DeserializationContext deserializationContext, agv com_fossil_agv) throws JsonMappingException {
        agy findConvertingContentDeserializer = findConvertingContentDeserializer(deserializationContext, com_fossil_agv, this._elementDeserializer);
        JavaType constructType = deserializationContext.constructType(String.class);
        if (findConvertingContentDeserializer == null) {
            findConvertingContentDeserializer = deserializationContext.findContextualValueDeserializer(constructType, com_fossil_agv);
        } else {
            findConvertingContentDeserializer = deserializationContext.handleSecondaryContextualization(findConvertingContentDeserializer, com_fossil_agv, constructType);
        }
        if (findConvertingContentDeserializer != null && isDefaultDeserializer(findConvertingContentDeserializer)) {
            findConvertingContentDeserializer = null;
        }
        if (this._elementDeserializer != findConvertingContentDeserializer) {
            return new StringArrayDeserializer(findConvertingContentDeserializer);
        }
        return this;
    }
}
