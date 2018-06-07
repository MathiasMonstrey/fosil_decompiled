package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fossil.agv;
import com.fossil.agz;
import com.fossil.ahb;
import com.fossil.ahg;
import com.fossil.ahh;
import com.fossil.ajc;
import com.fossil.ajg;
import com.fossil.ajv;
import com.fossil.akv;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;

public class StdArraySerializers {
    protected static final HashMap<String, ahb<?>> aVc = new HashMap();

    @ahh
    public static class BooleanArraySerializer extends ArraySerializerBase<boolean[]> {
        private static final JavaType aUT = TypeFactory.defaultInstance().uncheckedSimpleType(Boolean.class);

        public BooleanArraySerializer() {
            super(boolean[].class);
        }

        protected BooleanArraySerializer(BooleanArraySerializer booleanArraySerializer, agv com_fossil_agv, Boolean bool) {
            super(booleanArraySerializer, com_fossil_agv, bool);
        }

        public ahb<?> _withResolved(agv com_fossil_agv, Boolean bool) {
            return new BooleanArraySerializer(this, com_fossil_agv, bool);
        }

        public ContainerSerializer<?> _withValueTypeSerializer(ajv com_fossil_ajv) {
            return this;
        }

        public JavaType getContentType() {
            return aUT;
        }

        public ahb<?> getContentSerializer() {
            return null;
        }

        public boolean isEmpty(ahg com_fossil_ahg, boolean[] zArr) {
            return zArr == null || zArr.length == 0;
        }

        public boolean hasSingleElement(boolean[] zArr) {
            return zArr.length == 1;
        }

        public final void serialize(boolean[] zArr, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
            int length = zArr.length;
            if (length == 1 && ((this._unwrapSingle == null && com_fossil_ahg.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
                serializeContents(zArr, jsonGenerator, com_fossil_ahg);
                return;
            }
            jsonGenerator.fk(length);
            serializeContents(zArr, jsonGenerator, com_fossil_ahg);
            jsonGenerator.zI();
        }

        public void serializeContents(boolean[] zArr, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException, JsonGenerationException {
            for (boolean writeBoolean : zArr) {
                jsonGenerator.writeBoolean(writeBoolean);
            }
        }

        public agz getSchema(ahg com_fossil_ahg, Type type) {
            agz createSchemaNode = createSchemaNode("array", true);
            createSchemaNode.m3669a("items", createSchemaNode("boolean"));
            return createSchemaNode;
        }

        public void acceptJsonFormatVisitor(ajg com_fossil_ajg, JavaType javaType) throws JsonMappingException {
            if (com_fossil_ajg != null) {
                ajc e = com_fossil_ajg.mo1017e(javaType);
                if (e != null) {
                    e.m3533a(JsonFormatTypes.BOOLEAN);
                }
            }
        }
    }

    @ahh
    @Deprecated
    public static class ByteArraySerializer extends ByteArraySerializer {
    }

    @ahh
    public static class CharArraySerializer extends StdSerializer<char[]> {
        public CharArraySerializer() {
            super(char[].class);
        }

        public boolean isEmpty(ahg com_fossil_ahg, char[] cArr) {
            return cArr == null || cArr.length == 0;
        }

        public void serialize(char[] cArr, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException, JsonGenerationException {
            if (com_fossil_ahg.isEnabled(SerializationFeature.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS)) {
                jsonGenerator.fk(cArr.length);
                m2757a(jsonGenerator, cArr);
                jsonGenerator.zI();
                return;
            }
            jsonGenerator.mo939a(cArr, 0, cArr.length);
        }

        public void serializeWithType(char[] cArr, JsonGenerator jsonGenerator, ahg com_fossil_ahg, ajv com_fossil_ajv) throws IOException, JsonGenerationException {
            if (com_fossil_ahg.isEnabled(SerializationFeature.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS)) {
                com_fossil_ajv.mo1032c(cArr, jsonGenerator);
                m2757a(jsonGenerator, cArr);
                com_fossil_ajv.mo1037f(cArr, jsonGenerator);
                return;
            }
            com_fossil_ajv.mo1026a(cArr, jsonGenerator);
            jsonGenerator.mo939a(cArr, 0, cArr.length);
            com_fossil_ajv.mo1034d(cArr, jsonGenerator);
        }

        private final void m2757a(JsonGenerator jsonGenerator, char[] cArr) throws IOException, JsonGenerationException {
            int length = cArr.length;
            for (int i = 0; i < length; i++) {
                jsonGenerator.mo939a(cArr, i, 1);
            }
        }

        public agz getSchema(ahg com_fossil_ahg, Type type) {
            akv createSchemaNode = createSchemaNode("array", true);
            agz createSchemaNode2 = createSchemaNode("string");
            createSchemaNode2.m3675t("type", "string");
            return createSchemaNode.m3669a("items", createSchemaNode2);
        }

        public void acceptJsonFormatVisitor(ajg com_fossil_ajg, JavaType javaType) throws JsonMappingException {
            if (com_fossil_ajg != null) {
                ajc e = com_fossil_ajg.mo1017e(javaType);
                if (e != null) {
                    e.m3533a(JsonFormatTypes.STRING);
                }
            }
        }
    }

    @ahh
    public static class DoubleArraySerializer extends ArraySerializerBase<double[]> {
        private static final JavaType aUT = TypeFactory.defaultInstance().uncheckedSimpleType(Double.TYPE);

        public DoubleArraySerializer() {
            super(double[].class);
        }

        protected DoubleArraySerializer(DoubleArraySerializer doubleArraySerializer, agv com_fossil_agv, Boolean bool) {
            super(doubleArraySerializer, com_fossil_agv, bool);
        }

        public ahb<?> _withResolved(agv com_fossil_agv, Boolean bool) {
            return new DoubleArraySerializer(this, com_fossil_agv, bool);
        }

        public ContainerSerializer<?> _withValueTypeSerializer(ajv com_fossil_ajv) {
            return this;
        }

        public JavaType getContentType() {
            return aUT;
        }

        public ahb<?> getContentSerializer() {
            return null;
        }

        public boolean isEmpty(ahg com_fossil_ahg, double[] dArr) {
            return dArr == null || dArr.length == 0;
        }

        public boolean hasSingleElement(double[] dArr) {
            return dArr.length == 1;
        }

        public final void serialize(double[] dArr, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
            int length = dArr.length;
            if (length == 1 && ((this._unwrapSingle == null && com_fossil_ahg.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
                serializeContents(dArr, jsonGenerator, com_fossil_ahg);
                return;
            }
            jsonGenerator.fk(length);
            serializeContents(dArr, jsonGenerator, com_fossil_ahg);
            jsonGenerator.zI();
        }

        public void serializeContents(double[] dArr, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
            for (double d : dArr) {
                jsonGenerator.mo945d(d);
            }
        }

        public agz getSchema(ahg com_fossil_ahg, Type type) {
            return createSchemaNode("array", true).m3669a("items", createSchemaNode("number"));
        }

        public void acceptJsonFormatVisitor(ajg com_fossil_ajg, JavaType javaType) throws JsonMappingException {
            if (com_fossil_ajg != null) {
                ajc e = com_fossil_ajg.mo1017e(javaType);
                if (e != null) {
                    e.m3533a(JsonFormatTypes.NUMBER);
                }
            }
        }
    }

    public static abstract class TypedPrimitiveArraySerializer<T> extends ArraySerializerBase<T> {
        protected final ajv _valueTypeSerializer;

        protected TypedPrimitiveArraySerializer(Class<T> cls) {
            super((Class) cls);
            this._valueTypeSerializer = null;
        }

        protected TypedPrimitiveArraySerializer(TypedPrimitiveArraySerializer<T> typedPrimitiveArraySerializer, agv com_fossil_agv, ajv com_fossil_ajv, Boolean bool) {
            super(typedPrimitiveArraySerializer, com_fossil_agv, bool);
            this._valueTypeSerializer = com_fossil_ajv;
        }
    }

    @ahh
    public static class FloatArraySerializer extends TypedPrimitiveArraySerializer<float[]> {
        private static final JavaType aUT = TypeFactory.defaultInstance().uncheckedSimpleType(Float.TYPE);

        public FloatArraySerializer() {
            super(float[].class);
        }

        public FloatArraySerializer(FloatArraySerializer floatArraySerializer, agv com_fossil_agv, ajv com_fossil_ajv, Boolean bool) {
            super(floatArraySerializer, com_fossil_agv, com_fossil_ajv, bool);
        }

        public ContainerSerializer<?> _withValueTypeSerializer(ajv com_fossil_ajv) {
            return new FloatArraySerializer(this, this._property, com_fossil_ajv, this._unwrapSingle);
        }

        public ahb<?> _withResolved(agv com_fossil_agv, Boolean bool) {
            return new FloatArraySerializer(this, com_fossil_agv, this._valueTypeSerializer, bool);
        }

        public JavaType getContentType() {
            return aUT;
        }

        public ahb<?> getContentSerializer() {
            return null;
        }

        public boolean isEmpty(ahg com_fossil_ahg, float[] fArr) {
            return fArr == null || fArr.length == 0;
        }

        public boolean hasSingleElement(float[] fArr) {
            return fArr.length == 1;
        }

        public final void serialize(float[] fArr, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
            int length = fArr.length;
            if (length == 1 && ((this._unwrapSingle == null && com_fossil_ahg.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
                serializeContents(fArr, jsonGenerator, com_fossil_ahg);
                return;
            }
            jsonGenerator.fk(length);
            serializeContents(fArr, jsonGenerator, com_fossil_ahg);
            jsonGenerator.zI();
        }

        public void serializeContents(float[] fArr, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException, JsonGenerationException {
            int i = 0;
            int length;
            if (this._valueTypeSerializer != null) {
                length = fArr.length;
                while (i < length) {
                    this._valueTypeSerializer.mo1027a(null, jsonGenerator, Float.TYPE);
                    jsonGenerator.mo934T(fArr[i]);
                    this._valueTypeSerializer.mo1034d(null, jsonGenerator);
                    i++;
                }
                return;
            }
            length = fArr.length;
            while (i < length) {
                jsonGenerator.mo934T(fArr[i]);
                i++;
            }
        }

        public agz getSchema(ahg com_fossil_ahg, Type type) {
            return createSchemaNode("array", true).m3669a("items", createSchemaNode("number"));
        }

        public void acceptJsonFormatVisitor(ajg com_fossil_ajg, JavaType javaType) throws JsonMappingException {
            if (com_fossil_ajg != null) {
                ajc e = com_fossil_ajg.mo1017e(javaType);
                if (e != null) {
                    e.m3533a(JsonFormatTypes.NUMBER);
                }
            }
        }
    }

    @ahh
    public static class IntArraySerializer extends ArraySerializerBase<int[]> {
        private static final JavaType aUT = TypeFactory.defaultInstance().uncheckedSimpleType(Integer.TYPE);

        public IntArraySerializer() {
            super(int[].class);
        }

        protected IntArraySerializer(IntArraySerializer intArraySerializer, agv com_fossil_agv, Boolean bool) {
            super(intArraySerializer, com_fossil_agv, bool);
        }

        public ahb<?> _withResolved(agv com_fossil_agv, Boolean bool) {
            return new IntArraySerializer(this, com_fossil_agv, bool);
        }

        public ContainerSerializer<?> _withValueTypeSerializer(ajv com_fossil_ajv) {
            return this;
        }

        public JavaType getContentType() {
            return aUT;
        }

        public ahb<?> getContentSerializer() {
            return null;
        }

        public boolean isEmpty(ahg com_fossil_ahg, int[] iArr) {
            return iArr == null || iArr.length == 0;
        }

        public boolean hasSingleElement(int[] iArr) {
            return iArr.length == 1;
        }

        public final void serialize(int[] iArr, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
            int length = iArr.length;
            if (length == 1 && ((this._unwrapSingle == null && com_fossil_ahg.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
                serializeContents(iArr, jsonGenerator, com_fossil_ahg);
                return;
            }
            jsonGenerator.fk(length);
            serializeContents(iArr, jsonGenerator, com_fossil_ahg);
            jsonGenerator.zI();
        }

        public void serializeContents(int[] iArr, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
            for (int fl : iArr) {
                jsonGenerator.fl(fl);
            }
        }

        public agz getSchema(ahg com_fossil_ahg, Type type) {
            return createSchemaNode("array", true).m3669a("items", createSchemaNode("integer"));
        }

        public void acceptJsonFormatVisitor(ajg com_fossil_ajg, JavaType javaType) throws JsonMappingException {
            if (com_fossil_ajg != null) {
                ajc e = com_fossil_ajg.mo1017e(javaType);
                if (e != null) {
                    e.m3533a(JsonFormatTypes.INTEGER);
                }
            }
        }
    }

    @ahh
    public static class LongArraySerializer extends TypedPrimitiveArraySerializer<long[]> {
        private static final JavaType aUT = TypeFactory.defaultInstance().uncheckedSimpleType(Long.TYPE);

        public LongArraySerializer() {
            super(long[].class);
        }

        public LongArraySerializer(LongArraySerializer longArraySerializer, agv com_fossil_agv, ajv com_fossil_ajv, Boolean bool) {
            super(longArraySerializer, com_fossil_agv, com_fossil_ajv, bool);
        }

        public ahb<?> _withResolved(agv com_fossil_agv, Boolean bool) {
            return new LongArraySerializer(this, com_fossil_agv, this._valueTypeSerializer, bool);
        }

        public ContainerSerializer<?> _withValueTypeSerializer(ajv com_fossil_ajv) {
            return new LongArraySerializer(this, this._property, com_fossil_ajv, this._unwrapSingle);
        }

        public JavaType getContentType() {
            return aUT;
        }

        public ahb<?> getContentSerializer() {
            return null;
        }

        public boolean isEmpty(ahg com_fossil_ahg, long[] jArr) {
            return jArr == null || jArr.length == 0;
        }

        public boolean hasSingleElement(long[] jArr) {
            return jArr.length == 1;
        }

        public final void serialize(long[] jArr, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
            int length = jArr.length;
            if (length == 1 && ((this._unwrapSingle == null && com_fossil_ahg.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
                serializeContents(jArr, jsonGenerator, com_fossil_ahg);
                return;
            }
            jsonGenerator.fk(length);
            serializeContents(jArr, jsonGenerator, com_fossil_ahg);
            jsonGenerator.zI();
        }

        public void serializeContents(long[] jArr, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
            int i = 0;
            int length;
            if (this._valueTypeSerializer != null) {
                length = jArr.length;
                while (i < length) {
                    this._valueTypeSerializer.mo1027a(null, jsonGenerator, Long.TYPE);
                    jsonGenerator.mo933J(jArr[i]);
                    this._valueTypeSerializer.mo1034d(null, jsonGenerator);
                    i++;
                }
                return;
            }
            length = jArr.length;
            while (i < length) {
                jsonGenerator.mo933J(jArr[i]);
                i++;
            }
        }

        public agz getSchema(ahg com_fossil_ahg, Type type) {
            return createSchemaNode("array", true).m3669a("items", createSchemaNode("number", true));
        }

        public void acceptJsonFormatVisitor(ajg com_fossil_ajg, JavaType javaType) throws JsonMappingException {
            if (com_fossil_ajg != null) {
                ajc e = com_fossil_ajg.mo1017e(javaType);
                if (e != null) {
                    e.m3533a(JsonFormatTypes.NUMBER);
                }
            }
        }
    }

    @ahh
    public static class ShortArraySerializer extends TypedPrimitiveArraySerializer<short[]> {
        private static final JavaType aUT = TypeFactory.defaultInstance().uncheckedSimpleType(Short.TYPE);

        public ShortArraySerializer() {
            super(short[].class);
        }

        public ShortArraySerializer(ShortArraySerializer shortArraySerializer, agv com_fossil_agv, ajv com_fossil_ajv, Boolean bool) {
            super(shortArraySerializer, com_fossil_agv, com_fossil_ajv, bool);
        }

        public ahb<?> _withResolved(agv com_fossil_agv, Boolean bool) {
            return new ShortArraySerializer(this, com_fossil_agv, this._valueTypeSerializer, bool);
        }

        public ContainerSerializer<?> _withValueTypeSerializer(ajv com_fossil_ajv) {
            return new ShortArraySerializer(this, this._property, com_fossil_ajv, this._unwrapSingle);
        }

        public JavaType getContentType() {
            return aUT;
        }

        public ahb<?> getContentSerializer() {
            return null;
        }

        public boolean isEmpty(ahg com_fossil_ahg, short[] sArr) {
            return sArr == null || sArr.length == 0;
        }

        public boolean hasSingleElement(short[] sArr) {
            return sArr.length == 1;
        }

        public final void serialize(short[] sArr, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
            int length = sArr.length;
            if (length == 1 && ((this._unwrapSingle == null && com_fossil_ahg.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
                serializeContents(sArr, jsonGenerator, com_fossil_ahg);
                return;
            }
            jsonGenerator.fk(length);
            serializeContents(sArr, jsonGenerator, com_fossil_ahg);
            jsonGenerator.zI();
        }

        public void serializeContents(short[] sArr, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException, JsonGenerationException {
            int i = 0;
            int length;
            if (this._valueTypeSerializer != null) {
                length = sArr.length;
                while (i < length) {
                    this._valueTypeSerializer.mo1027a(null, jsonGenerator, Short.TYPE);
                    jsonGenerator.mo947f(sArr[i]);
                    this._valueTypeSerializer.mo1034d(null, jsonGenerator);
                    i++;
                }
                return;
            }
            length = sArr.length;
            while (i < length) {
                jsonGenerator.fl(sArr[i]);
                i++;
            }
        }

        public agz getSchema(ahg com_fossil_ahg, Type type) {
            return createSchemaNode("array", true).m3669a("items", createSchemaNode("integer"));
        }

        public void acceptJsonFormatVisitor(ajg com_fossil_ajg, JavaType javaType) throws JsonMappingException {
            if (com_fossil_ajg != null) {
                ajc e = com_fossil_ajg.mo1017e(javaType);
                if (e != null) {
                    e.m3533a(JsonFormatTypes.INTEGER);
                }
            }
        }
    }

    static {
        aVc.put(boolean[].class.getName(), new BooleanArraySerializer());
        aVc.put(byte[].class.getName(), new ByteArraySerializer());
        aVc.put(char[].class.getName(), new CharArraySerializer());
        aVc.put(short[].class.getName(), new ShortArraySerializer());
        aVc.put(int[].class.getName(), new IntArraySerializer());
        aVc.put(long[].class.getName(), new LongArraySerializer());
        aVc.put(float[].class.getName(), new FloatArraySerializer());
        aVc.put(double[].class.getName(), new DoubleArraySerializer());
    }

    public static ahb<?> m2758s(Class<?> cls) {
        return (ahb) aVc.get(cls.getName());
    }
}
