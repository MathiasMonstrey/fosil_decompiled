package com.fossil;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.ser.std.MapSerializer;
import java.util.Map;

public class alb {
    protected final agv _property;
    protected ahb<Object> _serializer;
    protected final AnnotatedMember aUd;
    protected MapSerializer aUe;

    public alb(agv com_fossil_agv, AnnotatedMember annotatedMember, ahb<?> com_fossil_ahb_) {
        this.aUd = annotatedMember;
        this._property = com_fossil_agv;
        this._serializer = com_fossil_ahb_;
        if (com_fossil_ahb_ instanceof MapSerializer) {
            this.aUe = (MapSerializer) com_fossil_ahb_;
        }
    }

    public void m3684a(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws Exception {
        Object value = this.aUd.getValue(obj);
        if (value != null) {
            if (!(value instanceof Map)) {
                throw new JsonMappingException("Value returned by 'any-getter' (" + this.aUd.getName() + "()) not java.util.Map but " + value.getClass().getName());
            } else if (this.aUe != null) {
                this.aUe.serializeFields((Map) value, jsonGenerator, com_fossil_ahg);
            } else {
                this._serializer.serialize(value, jsonGenerator, com_fossil_ahg);
            }
        }
    }

    public void m3685a(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg, alj com_fossil_alj) throws Exception {
        Object value = this.aUd.getValue(obj);
        if (value != null) {
            if (!(value instanceof Map)) {
                throw new JsonMappingException("Value returned by 'any-getter' (" + this.aUd.getName() + "()) not java.util.Map but " + value.getClass().getName());
            } else if (this.aUe != null) {
                this.aUe.serializeFilteredFields((Map) value, jsonGenerator, com_fossil_ahg, com_fossil_alj, null);
            } else {
                this._serializer.serialize(value, jsonGenerator, com_fossil_ahg);
            }
        }
    }

    public void resolve(ahg com_fossil_ahg) throws JsonMappingException {
        if (this._serializer instanceof alg) {
            ahb handlePrimaryContextualization = com_fossil_ahg.handlePrimaryContextualization(this._serializer, this._property);
            this._serializer = handlePrimaryContextualization;
            if (handlePrimaryContextualization instanceof MapSerializer) {
                this.aUe = (MapSerializer) handlePrimaryContextualization;
            }
        }
    }
}
