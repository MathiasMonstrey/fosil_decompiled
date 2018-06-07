package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fossil.agv;
import com.fossil.agz;
import com.fossil.ahb;
import com.fossil.ahg;
import com.fossil.aje;
import com.fossil.ajg;
import com.fossil.ajq;
import com.fossil.ajv;
import com.fossil.alg;
import com.fossil.all;
import com.fossil.amk;
import java.io.IOException;
import java.lang.reflect.Type;

public class StdDelegatingSerializer extends StdSerializer<Object> implements aje, ajq, alg, all {
    protected final amk<Object, ?> _converter;
    protected final ahb<Object> _delegateSerializer;
    protected final JavaType _delegateType;

    public StdDelegatingSerializer(amk<?, ?> com_fossil_amk___) {
        super(Object.class);
        this._converter = com_fossil_amk___;
        this._delegateType = null;
        this._delegateSerializer = null;
    }

    public <T> StdDelegatingSerializer(Class<T> cls, amk<T, ?> com_fossil_amk_T__) {
        super(cls, false);
        this._converter = com_fossil_amk_T__;
        this._delegateType = null;
        this._delegateSerializer = null;
    }

    public StdDelegatingSerializer(amk<Object, ?> com_fossil_amk_java_lang_Object__, JavaType javaType, ahb<?> com_fossil_ahb_) {
        super(javaType);
        this._converter = com_fossil_amk_java_lang_Object__;
        this._delegateType = javaType;
        this._delegateSerializer = com_fossil_ahb_;
    }

    protected StdDelegatingSerializer withDelegate(amk<Object, ?> com_fossil_amk_java_lang_Object__, JavaType javaType, ahb<?> com_fossil_ahb_) {
        if (getClass() == StdDelegatingSerializer.class) {
            return new StdDelegatingSerializer(com_fossil_amk_java_lang_Object__, javaType, com_fossil_ahb_);
        }
        throw new IllegalStateException("Sub-class " + getClass().getName() + " must override 'withDelegate'");
    }

    public void resolve(ahg com_fossil_ahg) throws JsonMappingException {
        if (this._delegateSerializer != null && (this._delegateSerializer instanceof all)) {
            ((all) this._delegateSerializer).resolve(com_fossil_ahg);
        }
    }

    public ahb<?> createContextual(ahg com_fossil_ahg, agv com_fossil_agv) throws JsonMappingException {
        ahb com_fossil_ahb = this._delegateSerializer;
        JavaType javaType = this._delegateType;
        if (com_fossil_ahb == null) {
            if (javaType == null) {
                javaType = this._converter.m3879b(com_fossil_ahg.getTypeFactory());
            }
            if (!javaType.isJavaLangObject()) {
                com_fossil_ahb = com_fossil_ahg.findValueSerializer(javaType);
            }
        }
        if (com_fossil_ahb instanceof alg) {
            com_fossil_ahb = com_fossil_ahg.handleSecondaryContextualization(com_fossil_ahb, com_fossil_agv);
        }
        return (com_fossil_ahb == this._delegateSerializer && javaType == this._delegateType) ? this : withDelegate(this._converter, javaType, com_fossil_ahb);
    }

    protected amk<Object, ?> getConverter() {
        return this._converter;
    }

    public ahb<?> getDelegatee() {
        return this._delegateSerializer;
    }

    public void serialize(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        Object convertValue = convertValue(obj);
        if (convertValue == null) {
            com_fossil_ahg.defaultSerializeNull(jsonGenerator);
            return;
        }
        ahb com_fossil_ahb = this._delegateSerializer;
        if (com_fossil_ahb == null) {
            com_fossil_ahb = _findSerializer(convertValue, com_fossil_ahg);
        }
        com_fossil_ahb.serialize(convertValue, jsonGenerator, com_fossil_ahg);
    }

    public void serializeWithType(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg, ajv com_fossil_ajv) throws IOException {
        Object convertValue = convertValue(obj);
        ahb com_fossil_ahb = this._delegateSerializer;
        if (com_fossil_ahb == null) {
            com_fossil_ahb = _findSerializer(obj, com_fossil_ahg);
        }
        com_fossil_ahb.serializeWithType(convertValue, jsonGenerator, com_fossil_ahg, com_fossil_ajv);
    }

    @Deprecated
    public boolean isEmpty(Object obj) {
        return isEmpty(null, obj);
    }

    public boolean isEmpty(ahg com_fossil_ahg, Object obj) {
        Object convertValue = convertValue(obj);
        if (this._delegateSerializer == null) {
            return obj == null;
        } else {
            return this._delegateSerializer.isEmpty(com_fossil_ahg, convertValue);
        }
    }

    public agz getSchema(ahg com_fossil_ahg, Type type) throws JsonMappingException {
        if (this._delegateSerializer instanceof ajq) {
            return ((ajq) this._delegateSerializer).getSchema(com_fossil_ahg, type);
        }
        return super.getSchema(com_fossil_ahg, type);
    }

    public agz getSchema(ahg com_fossil_ahg, Type type, boolean z) throws JsonMappingException {
        if (this._delegateSerializer instanceof ajq) {
            return ((ajq) this._delegateSerializer).getSchema(com_fossil_ahg, type, z);
        }
        return super.getSchema(com_fossil_ahg, type);
    }

    public void acceptJsonFormatVisitor(ajg com_fossil_ajg, JavaType javaType) throws JsonMappingException {
        if (this._delegateSerializer != null) {
            this._delegateSerializer.acceptJsonFormatVisitor(com_fossil_ajg, javaType);
        }
    }

    protected Object convertValue(Object obj) {
        return this._converter.convert(obj);
    }

    protected ahb<Object> _findSerializer(Object obj, ahg com_fossil_ahg) throws JsonMappingException {
        return com_fossil_ahg.findValueSerializer(obj.getClass());
    }
}
