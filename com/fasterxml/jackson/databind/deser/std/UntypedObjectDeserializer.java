package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fossil.agv;
import com.fossil.agy;
import com.fossil.ahh;
import com.fossil.ahv;
import com.fossil.aic;
import com.fossil.ajs;
import com.fossil.ami;
import com.fossil.amp;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@ahh
public class UntypedObjectDeserializer extends StdDeserializer<Object> implements ahv, aic {
    protected static final Object[] NO_OBJECTS = new Object[0];
    @Deprecated
    public static final UntypedObjectDeserializer instance = new UntypedObjectDeserializer(null, null);
    private static final long serialVersionUID = 1;
    protected agy<Object> _listDeserializer;
    protected JavaType _listType;
    protected agy<Object> _mapDeserializer;
    protected JavaType _mapType;
    protected agy<Object> _numberDeserializer;
    protected agy<Object> _stringDeserializer;

    @ahh
    public static class Vanilla extends StdDeserializer<Object> {
        private static final long serialVersionUID = 1;
        public static final Vanilla std = new Vanilla();

        public Vanilla() {
            super(Object.class);
        }

        public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            switch (jsonParser.zV()) {
                case 1:
                    if (jsonParser.zP() == JsonToken.END_OBJECT) {
                        return new LinkedHashMap(2);
                    }
                    break;
                case 3:
                    if (jsonParser.zP() == JsonToken.END_ARRAY) {
                        if (deserializationContext.isEnabled(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY)) {
                            return UntypedObjectDeserializer.NO_OBJECTS;
                        }
                        return new ArrayList(2);
                    } else if (deserializationContext.isEnabled(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY)) {
                        return mapArrayToArray(jsonParser, deserializationContext);
                    } else {
                        return mapArray(jsonParser, deserializationContext);
                    }
                case 5:
                    break;
                case 6:
                    return jsonParser.getText();
                case 7:
                    if (deserializationContext.hasSomeOfFeatures(F_MASK_INT_COERCIONS)) {
                        return _coerceIntegral(jsonParser, deserializationContext);
                    }
                    return jsonParser.Ah();
                case 8:
                    if (deserializationContext.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) {
                        return jsonParser.Ap();
                    }
                    return Double.valueOf(jsonParser.Ao());
                case 9:
                    return Boolean.TRUE;
                case 10:
                    return Boolean.FALSE;
                case 11:
                    return null;
                case 12:
                    return jsonParser.Aq();
                default:
                    throw deserializationContext.mappingException(Object.class);
            }
            return mapObject(jsonParser, deserializationContext);
        }

        public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, ajs com_fossil_ajs) throws IOException {
            switch (jsonParser.zV()) {
                case 1:
                case 3:
                case 5:
                    return com_fossil_ajs.deserializeTypedFromAny(jsonParser, deserializationContext);
                case 6:
                    return jsonParser.getText();
                case 7:
                    if (deserializationContext.isEnabled(DeserializationFeature.USE_BIG_INTEGER_FOR_INTS)) {
                        return jsonParser.Am();
                    }
                    return jsonParser.Ah();
                case 8:
                    if (deserializationContext.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) {
                        return jsonParser.Ap();
                    }
                    return Double.valueOf(jsonParser.Ao());
                case 9:
                    return Boolean.TRUE;
                case 10:
                    return Boolean.FALSE;
                case 11:
                    return null;
                case 12:
                    return jsonParser.Aq();
                default:
                    throw deserializationContext.mappingException(Object.class);
            }
        }

        protected Object mapArray(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            int i = 2;
            Object deserialize = deserialize(jsonParser, deserializationContext);
            if (jsonParser.zP() == JsonToken.END_ARRAY) {
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(deserialize);
                return arrayList;
            }
            Object deserialize2 = deserialize(jsonParser, deserializationContext);
            if (jsonParser.zP() == JsonToken.END_ARRAY) {
                arrayList = new ArrayList(2);
                arrayList.add(deserialize);
                arrayList.add(deserialize2);
                return arrayList;
            }
            amp leaseObjectBuffer = deserializationContext.leaseObjectBuffer();
            Object[] Ho = leaseObjectBuffer.Ho();
            Ho[0] = deserialize;
            Ho[1] = deserialize2;
            Object[] objArr = Ho;
            int i2 = 2;
            do {
                int i3;
                Object deserialize3 = deserialize(jsonParser, deserializationContext);
                i++;
                if (i2 >= objArr.length) {
                    objArr = leaseObjectBuffer.m3889c(objArr);
                    i3 = 0;
                } else {
                    i3 = i2;
                }
                i2 = i3 + 1;
                objArr[i3] = deserialize3;
            } while (jsonParser.zP() != JsonToken.END_ARRAY);
            List arrayList2 = new ArrayList(i);
            leaseObjectBuffer.m3887a(objArr, i2, arrayList2);
            return arrayList2;
        }

        protected Object mapObject(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            String text = jsonParser.getText();
            jsonParser.zP();
            Object deserialize = deserialize(jsonParser, deserializationContext);
            String zR = jsonParser.zR();
            if (zR == null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap(2);
                linkedHashMap.put(text, deserialize);
                return linkedHashMap;
            }
            jsonParser.zP();
            Object deserialize2 = deserialize(jsonParser, deserializationContext);
            Object zR2 = jsonParser.zR();
            if (zR2 == null) {
                zR2 = new LinkedHashMap(4);
                zR2.put(text, deserialize);
                zR2.put(zR, deserialize2);
                return zR2;
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            linkedHashMap2.put(text, deserialize);
            linkedHashMap2.put(zR, deserialize2);
            do {
                jsonParser.zP();
                linkedHashMap2.put(zR2, deserialize(jsonParser, deserializationContext));
                zR2 = jsonParser.zR();
            } while (zR2 != null);
            return linkedHashMap2;
        }

        protected Object[] mapArrayToArray(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            amp leaseObjectBuffer = deserializationContext.leaseObjectBuffer();
            Object[] Ho = leaseObjectBuffer.Ho();
            int i = 0;
            do {
                int i2;
                Object deserialize = deserialize(jsonParser, deserializationContext);
                if (i >= Ho.length) {
                    Ho = leaseObjectBuffer.m3889c(Ho);
                    i2 = 0;
                } else {
                    i2 = i;
                }
                i = i2 + 1;
                Ho[i2] = deserialize;
            } while (jsonParser.zP() != JsonToken.END_ARRAY);
            return leaseObjectBuffer.m3890c(Ho, i);
        }
    }

    @Deprecated
    public UntypedObjectDeserializer() {
        this(null, null);
    }

    public UntypedObjectDeserializer(JavaType javaType, JavaType javaType2) {
        super(Object.class);
        this._listType = javaType;
        this._mapType = javaType2;
    }

    public UntypedObjectDeserializer(UntypedObjectDeserializer untypedObjectDeserializer, agy<?> com_fossil_agy_, agy<?> com_fossil_agy_2, agy<?> com_fossil_agy_3, agy<?> com_fossil_agy_4) {
        super(Object.class);
        this._mapDeserializer = com_fossil_agy_;
        this._listDeserializer = com_fossil_agy_2;
        this._stringDeserializer = com_fossil_agy_3;
        this._numberDeserializer = com_fossil_agy_4;
        this._listType = untypedObjectDeserializer._listType;
        this._mapType = untypedObjectDeserializer._mapType;
    }

    public void resolve(DeserializationContext deserializationContext) throws JsonMappingException {
        JavaType constructType = deserializationContext.constructType(Object.class);
        JavaType constructType2 = deserializationContext.constructType(String.class);
        TypeFactory typeFactory = deserializationContext.getTypeFactory();
        if (this._listType == null) {
            this._listDeserializer = _clearIfStdImpl(_findCustomDeser(deserializationContext, typeFactory.constructCollectionType(List.class, constructType)));
        } else {
            this._listDeserializer = _findCustomDeser(deserializationContext, this._listType);
        }
        if (this._mapType == null) {
            this._mapDeserializer = _clearIfStdImpl(_findCustomDeser(deserializationContext, typeFactory.constructMapType(Map.class, constructType2, constructType)));
        } else {
            this._mapDeserializer = _findCustomDeser(deserializationContext, this._mapType);
        }
        this._stringDeserializer = _clearIfStdImpl(_findCustomDeser(deserializationContext, constructType2));
        this._numberDeserializer = _clearIfStdImpl(_findCustomDeser(deserializationContext, typeFactory.constructType((Type) Number.class)));
        constructType = TypeFactory.unknownType();
        this._mapDeserializer = deserializationContext.handleSecondaryContextualization(this._mapDeserializer, null, constructType);
        this._listDeserializer = deserializationContext.handleSecondaryContextualization(this._listDeserializer, null, constructType);
        this._stringDeserializer = deserializationContext.handleSecondaryContextualization(this._stringDeserializer, null, constructType);
        this._numberDeserializer = deserializationContext.handleSecondaryContextualization(this._numberDeserializer, null, constructType);
    }

    protected agy<Object> _findCustomDeser(DeserializationContext deserializationContext, JavaType javaType) throws JsonMappingException {
        return deserializationContext.findNonContextualValueDeserializer(javaType);
    }

    protected agy<Object> _clearIfStdImpl(agy<Object> com_fossil_agy_java_lang_Object) {
        return ami.bG(com_fossil_agy_java_lang_Object) ? null : com_fossil_agy_java_lang_Object;
    }

    public agy<?> createContextual(DeserializationContext deserializationContext, agv com_fossil_agv) throws JsonMappingException {
        if (this._stringDeserializer == null && this._numberDeserializer == null && this._mapDeserializer == null && this._listDeserializer == null && getClass() == UntypedObjectDeserializer.class) {
            return Vanilla.std;
        }
        return this;
    }

    protected agy<?> _withResolved(agy<?> com_fossil_agy_, agy<?> com_fossil_agy_2, agy<?> com_fossil_agy_3, agy<?> com_fossil_agy_4) {
        return new UntypedObjectDeserializer(this, com_fossil_agy_, com_fossil_agy_2, com_fossil_agy_3, com_fossil_agy_4);
    }

    public boolean isCachable() {
        return true;
    }

    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        switch (jsonParser.zV()) {
            case 1:
            case 5:
                if (this._mapDeserializer != null) {
                    return this._mapDeserializer.deserialize(jsonParser, deserializationContext);
                }
                return mapObject(jsonParser, deserializationContext);
            case 3:
                if (deserializationContext.isEnabled(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY)) {
                    return mapArrayToArray(jsonParser, deserializationContext);
                }
                if (this._listDeserializer != null) {
                    return this._listDeserializer.deserialize(jsonParser, deserializationContext);
                }
                return mapArray(jsonParser, deserializationContext);
            case 6:
                if (this._stringDeserializer != null) {
                    return this._stringDeserializer.deserialize(jsonParser, deserializationContext);
                }
                return jsonParser.getText();
            case 7:
                if (this._numberDeserializer != null) {
                    return this._numberDeserializer.deserialize(jsonParser, deserializationContext);
                }
                if (deserializationContext.hasSomeOfFeatures(F_MASK_INT_COERCIONS)) {
                    return _coerceIntegral(jsonParser, deserializationContext);
                }
                return jsonParser.Ah();
            case 8:
                if (this._numberDeserializer != null) {
                    return this._numberDeserializer.deserialize(jsonParser, deserializationContext);
                }
                if (deserializationContext.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) {
                    return jsonParser.Ap();
                }
                return Double.valueOf(jsonParser.Ao());
            case 9:
                return Boolean.TRUE;
            case 10:
                return Boolean.FALSE;
            case 11:
                return null;
            case 12:
                return jsonParser.Aq();
            default:
                throw deserializationContext.mappingException(Object.class);
        }
    }

    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, ajs com_fossil_ajs) throws IOException {
        switch (jsonParser.zV()) {
            case 1:
            case 3:
            case 5:
                return com_fossil_ajs.deserializeTypedFromAny(jsonParser, deserializationContext);
            case 6:
                if (this._stringDeserializer != null) {
                    return this._stringDeserializer.deserialize(jsonParser, deserializationContext);
                }
                return jsonParser.getText();
            case 7:
                if (this._numberDeserializer != null) {
                    return this._numberDeserializer.deserialize(jsonParser, deserializationContext);
                }
                if (deserializationContext.hasSomeOfFeatures(F_MASK_INT_COERCIONS)) {
                    return _coerceIntegral(jsonParser, deserializationContext);
                }
                return jsonParser.Ah();
            case 8:
                if (this._numberDeserializer != null) {
                    return this._numberDeserializer.deserialize(jsonParser, deserializationContext);
                }
                if (deserializationContext.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) {
                    return jsonParser.Ap();
                }
                return Double.valueOf(jsonParser.Ao());
            case 9:
                return Boolean.TRUE;
            case 10:
                return Boolean.FALSE;
            case 11:
                return null;
            case 12:
                return jsonParser.Aq();
            default:
                throw deserializationContext.mappingException(Object.class);
        }
    }

    protected Object mapArray(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        int i = 2;
        if (jsonParser.zP() == JsonToken.END_ARRAY) {
            return new ArrayList(2);
        }
        Object deserialize = deserialize(jsonParser, deserializationContext);
        if (jsonParser.zP() == JsonToken.END_ARRAY) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(deserialize);
            return arrayList;
        }
        Object deserialize2 = deserialize(jsonParser, deserializationContext);
        if (jsonParser.zP() == JsonToken.END_ARRAY) {
            arrayList = new ArrayList(2);
            arrayList.add(deserialize);
            arrayList.add(deserialize2);
            return arrayList;
        }
        amp leaseObjectBuffer = deserializationContext.leaseObjectBuffer();
        Object[] Ho = leaseObjectBuffer.Ho();
        Ho[0] = deserialize;
        Ho[1] = deserialize2;
        Object[] objArr = Ho;
        int i2 = 2;
        do {
            int i3;
            Object deserialize3 = deserialize(jsonParser, deserializationContext);
            i++;
            if (i2 >= objArr.length) {
                objArr = leaseObjectBuffer.m3889c(objArr);
                i3 = 0;
            } else {
                i3 = i2;
            }
            i2 = i3 + 1;
            objArr[i3] = deserialize3;
        } while (jsonParser.zP() != JsonToken.END_ARRAY);
        List arrayList2 = new ArrayList(i);
        leaseObjectBuffer.m3887a(objArr, i2, arrayList2);
        return arrayList2;
    }

    protected Object mapObject(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Object zR;
        JsonToken zU = jsonParser.zU();
        if (zU == JsonToken.START_OBJECT) {
            zR = jsonParser.zR();
        } else if (zU == JsonToken.FIELD_NAME) {
            String zW = jsonParser.zW();
        } else if (zU != JsonToken.END_OBJECT) {
            throw deserializationContext.mappingException(handledType(), jsonParser.zU());
        } else {
            zR = null;
        }
        if (zR == null) {
            return new LinkedHashMap(2);
        }
        jsonParser.zP();
        Object deserialize = deserialize(jsonParser, deserializationContext);
        String zR2 = jsonParser.zR();
        if (zR2 == null) {
            Object linkedHashMap = new LinkedHashMap(2);
            linkedHashMap.put(zR, deserialize);
            return linkedHashMap;
        }
        jsonParser.zP();
        Object deserialize2 = deserialize(jsonParser, deserializationContext);
        linkedHashMap = jsonParser.zR();
        if (linkedHashMap == null) {
            linkedHashMap = new LinkedHashMap(4);
            linkedHashMap.put(zR, deserialize);
            linkedHashMap.put(zR2, deserialize2);
            return linkedHashMap;
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put(zR, deserialize);
        linkedHashMap2.put(zR2, deserialize2);
        do {
            jsonParser.zP();
            linkedHashMap2.put(linkedHashMap, deserialize(jsonParser, deserializationContext));
            linkedHashMap = jsonParser.zR();
        } while (linkedHashMap != null);
        return linkedHashMap2;
    }

    protected Object[] mapArrayToArray(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (jsonParser.zP() == JsonToken.END_ARRAY) {
            return NO_OBJECTS;
        }
        amp leaseObjectBuffer = deserializationContext.leaseObjectBuffer();
        Object[] Ho = leaseObjectBuffer.Ho();
        int i = 0;
        do {
            int i2;
            Object deserialize = deserialize(jsonParser, deserializationContext);
            if (i >= Ho.length) {
                Ho = leaseObjectBuffer.m3889c(Ho);
                i2 = 0;
            } else {
                i2 = i;
            }
            i = i2 + 1;
            Ho[i2] = deserialize;
        } while (jsonParser.zP() != JsonToken.END_ARRAY);
        return leaseObjectBuffer.m3890c(Ho, i);
    }
}
