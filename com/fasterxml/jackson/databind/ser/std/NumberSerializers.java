package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonFormat.C1501b;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fossil.agv;
import com.fossil.agz;
import com.fossil.ahb;
import com.fossil.ahg;
import com.fossil.ahh;
import com.fossil.aiq;
import com.fossil.ajg;
import com.fossil.ajh;
import com.fossil.ajk;
import com.fossil.ajv;
import com.fossil.alg;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

public class NumberSerializers {

    public static abstract class Base<T> extends StdScalarSerializer<T> implements alg {
        protected static final Integer EMPTY_INTEGER = Integer.valueOf(0);
        protected final boolean _isInt;
        protected final NumberType _numberType;
        protected final String _schemaType;

        protected Base(Class<?> cls, NumberType numberType, String str) {
            boolean z = false;
            super(cls, false);
            this._numberType = numberType;
            this._schemaType = str;
            if (numberType == NumberType.INT || numberType == NumberType.LONG || numberType == NumberType.BIG_INTEGER) {
                z = true;
            }
            this._isInt = z;
        }

        public agz getSchema(ahg com_fossil_ahg, Type type) {
            return createSchemaNode(this._schemaType, true);
        }

        public void acceptJsonFormatVisitor(ajg com_fossil_ajg, JavaType javaType) throws JsonMappingException {
            if (this._isInt) {
                ajh h = com_fossil_ajg.mo1020h(javaType);
                if (h != null) {
                    h.m3556a(this._numberType);
                    return;
                }
                return;
            }
            ajk g = com_fossil_ajg.mo1019g(javaType);
            if (g != null) {
                g.m3559a(this._numberType);
            }
        }

        public ahb<?> createContextual(ahg com_fossil_ahg, agv com_fossil_agv) throws JsonMappingException {
            if (com_fossil_agv == null) {
                return this;
            }
            aiq member = com_fossil_agv.getMember();
            if (member == null) {
                return this;
            }
            C1501b findFormat = com_fossil_ahg.getAnnotationIntrospector().findFormat(member);
            if (findFormat == null) {
                return this;
            }
            switch (findFormat.yZ()) {
                case STRING:
                    return ToStringSerializer.instance;
                default:
                    return this;
            }
        }
    }

    @ahh
    public static final class DoubleSerializer extends Base<Object> {
        private static final Double aUX = Double.valueOf(0.0d);
        static final DoubleSerializer instance = new DoubleSerializer();

        public /* bridge */ /* synthetic */ void acceptJsonFormatVisitor(ajg com_fossil_ajg, JavaType javaType) throws JsonMappingException {
            super.acceptJsonFormatVisitor(com_fossil_ajg, javaType);
        }

        public /* bridge */ /* synthetic */ ahb createContextual(ahg com_fossil_ahg, agv com_fossil_agv) throws JsonMappingException {
            return super.createContextual(com_fossil_ahg, com_fossil_agv);
        }

        public /* bridge */ /* synthetic */ agz getSchema(ahg com_fossil_ahg, Type type) {
            return super.getSchema(com_fossil_ahg, type);
        }

        public DoubleSerializer() {
            super(Double.class, NumberType.DOUBLE, "number");
        }

        public boolean isEmpty(ahg com_fossil_ahg, Object obj) {
            return aUX.equals(obj);
        }

        public void serialize(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
            jsonGenerator.mo945d(((Double) obj).doubleValue());
        }

        public void serializeWithType(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg, ajv com_fossil_ajv) throws IOException {
            serialize(obj, jsonGenerator, com_fossil_ahg);
        }
    }

    @ahh
    public static final class FloatSerializer extends Base<Object> {
        private static final Float aUY = Float.valueOf(0.0f);
        static final FloatSerializer instance = new FloatSerializer();

        public /* bridge */ /* synthetic */ void acceptJsonFormatVisitor(ajg com_fossil_ajg, JavaType javaType) throws JsonMappingException {
            super.acceptJsonFormatVisitor(com_fossil_ajg, javaType);
        }

        public /* bridge */ /* synthetic */ ahb createContextual(ahg com_fossil_ahg, agv com_fossil_agv) throws JsonMappingException {
            return super.createContextual(com_fossil_ahg, com_fossil_agv);
        }

        public /* bridge */ /* synthetic */ agz getSchema(ahg com_fossil_ahg, Type type) {
            return super.getSchema(com_fossil_ahg, type);
        }

        public FloatSerializer() {
            super(Float.class, NumberType.FLOAT, "number");
        }

        public boolean isEmpty(ahg com_fossil_ahg, Object obj) {
            return aUY.equals(obj);
        }

        public void serialize(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
            jsonGenerator.mo934T(((Float) obj).floatValue());
        }
    }

    @ahh
    public static final class IntLikeSerializer extends Base<Number> {
        static final IntLikeSerializer instance = new IntLikeSerializer();

        public /* bridge */ /* synthetic */ void acceptJsonFormatVisitor(ajg com_fossil_ajg, JavaType javaType) throws JsonMappingException {
            super.acceptJsonFormatVisitor(com_fossil_ajg, javaType);
        }

        public /* bridge */ /* synthetic */ ahb createContextual(ahg com_fossil_ahg, agv com_fossil_agv) throws JsonMappingException {
            return super.createContextual(com_fossil_ahg, com_fossil_agv);
        }

        public /* bridge */ /* synthetic */ agz getSchema(ahg com_fossil_ahg, Type type) {
            return super.getSchema(com_fossil_ahg, type);
        }

        public IntLikeSerializer() {
            super(Number.class, NumberType.INT, "integer");
        }

        public boolean isEmpty(ahg com_fossil_ahg, Number number) {
            return number.intValue() == 0;
        }

        public void serialize(Number number, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
            jsonGenerator.fl(number.intValue());
        }
    }

    @ahh
    public static final class IntegerSerializer extends Base<Object> {
        public /* bridge */ /* synthetic */ void acceptJsonFormatVisitor(ajg com_fossil_ajg, JavaType javaType) throws JsonMappingException {
            super.acceptJsonFormatVisitor(com_fossil_ajg, javaType);
        }

        public /* bridge */ /* synthetic */ ahb createContextual(ahg com_fossil_ahg, agv com_fossil_agv) throws JsonMappingException {
            return super.createContextual(com_fossil_ahg, com_fossil_agv);
        }

        public /* bridge */ /* synthetic */ agz getSchema(ahg com_fossil_ahg, Type type) {
            return super.getSchema(com_fossil_ahg, type);
        }

        public IntegerSerializer() {
            super(Integer.class, NumberType.INT, "integer");
        }

        public void serialize(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
            jsonGenerator.fl(((Integer) obj).intValue());
        }

        public void serializeWithType(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg, ajv com_fossil_ajv) throws IOException {
            serialize(obj, jsonGenerator, com_fossil_ahg);
        }

        public boolean isEmpty(ahg com_fossil_ahg, Object obj) {
            return EMPTY_INTEGER.equals(obj);
        }
    }

    @ahh
    public static final class LongSerializer extends Base<Object> {
        private static final Long aUZ = Long.valueOf(0);
        static final LongSerializer instance = new LongSerializer();

        public /* bridge */ /* synthetic */ void acceptJsonFormatVisitor(ajg com_fossil_ajg, JavaType javaType) throws JsonMappingException {
            super.acceptJsonFormatVisitor(com_fossil_ajg, javaType);
        }

        public /* bridge */ /* synthetic */ ahb createContextual(ahg com_fossil_ahg, agv com_fossil_agv) throws JsonMappingException {
            return super.createContextual(com_fossil_ahg, com_fossil_agv);
        }

        public /* bridge */ /* synthetic */ agz getSchema(ahg com_fossil_ahg, Type type) {
            return super.getSchema(com_fossil_ahg, type);
        }

        public LongSerializer() {
            super(Long.class, NumberType.LONG, "number");
        }

        public boolean isEmpty(ahg com_fossil_ahg, Object obj) {
            return aUZ.equals(obj);
        }

        public void serialize(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
            jsonGenerator.mo933J(((Long) obj).longValue());
        }
    }

    @ahh
    public static final class ShortSerializer extends Base<Short> {
        private static final Short aVa = Short.valueOf((short) 0);
        static final ShortSerializer instance = new ShortSerializer();

        public /* bridge */ /* synthetic */ void acceptJsonFormatVisitor(ajg com_fossil_ajg, JavaType javaType) throws JsonMappingException {
            super.acceptJsonFormatVisitor(com_fossil_ajg, javaType);
        }

        public /* bridge */ /* synthetic */ ahb createContextual(ahg com_fossil_ahg, agv com_fossil_agv) throws JsonMappingException {
            return super.createContextual(com_fossil_ahg, com_fossil_agv);
        }

        public /* bridge */ /* synthetic */ agz getSchema(ahg com_fossil_ahg, Type type) {
            return super.getSchema(com_fossil_ahg, type);
        }

        public ShortSerializer() {
            super(Short.class, NumberType.INT, "number");
        }

        public boolean isEmpty(ahg com_fossil_ahg, Short sh) {
            return aVa.equals(sh);
        }

        public void serialize(Short sh, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
            jsonGenerator.mo947f(sh.shortValue());
        }
    }

    public static void m2756m(Map<String, ahb<?>> map) {
        IntegerSerializer integerSerializer = new IntegerSerializer();
        map.put(Integer.class.getName(), integerSerializer);
        map.put(Integer.TYPE.getName(), integerSerializer);
        map.put(Long.class.getName(), LongSerializer.instance);
        map.put(Long.TYPE.getName(), LongSerializer.instance);
        map.put(Byte.class.getName(), IntLikeSerializer.instance);
        map.put(Byte.TYPE.getName(), IntLikeSerializer.instance);
        map.put(Short.class.getName(), ShortSerializer.instance);
        map.put(Short.TYPE.getName(), ShortSerializer.instance);
        map.put(Float.class.getName(), FloatSerializer.instance);
        map.put(Float.TYPE.getName(), FloatSerializer.instance);
        map.put(Double.class.getName(), DoubleSerializer.instance);
        map.put(Double.TYPE.getName(), DoubleSerializer.instance);
    }
}
