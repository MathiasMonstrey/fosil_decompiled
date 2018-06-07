package com.fossil;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;

public class aly extends alk {
    protected ahb<Object> _keySerializer;
    protected final agv _property;
    protected ahb<Object> _valueSerializer;
    protected final ajv aQx;
    protected Object aRI;

    public aly(ajv com_fossil_ajv, agv com_fossil_agv) {
        this.aQx = com_fossil_ajv;
        this._property = com_fossil_agv;
    }

    public void m3801a(Object obj, ahb<Object> com_fossil_ahb_java_lang_Object, ahb<Object> com_fossil_ahb_java_lang_Object2) {
        this.aRI = obj;
        this._keySerializer = com_fossil_ahb_java_lang_Object;
        this._valueSerializer = com_fossil_ahb_java_lang_Object2;
    }

    public String getName() {
        if (this.aRI instanceof String) {
            return (String) this.aRI;
        }
        return String.valueOf(this.aRI);
    }

    public void mo1072b(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        this._keySerializer.serialize(this.aRI, jsonGenerator, com_fossil_ahg);
        if (this.aQx == null) {
            this._valueSerializer.serialize(obj, jsonGenerator, com_fossil_ahg);
        } else {
            this._valueSerializer.serializeWithType(obj, jsonGenerator, com_fossil_ahg, this.aQx);
        }
    }

    public void mo1073c(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws Exception {
        if (!jsonGenerator.zG()) {
            jsonGenerator.aW(getName());
        }
    }

    public void mo1074d(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws Exception {
        if (this.aQx == null) {
            this._valueSerializer.serialize(obj, jsonGenerator, com_fossil_ahg);
        } else {
            this._valueSerializer.serializeWithType(obj, jsonGenerator, com_fossil_ahg, this.aQx);
        }
    }

    public void depositSchemaProperty(ajl com_fossil_ajl) throws JsonMappingException {
    }

    @Deprecated
    public void mo1071a(akv com_fossil_akv, ahg com_fossil_ahg) throws JsonMappingException {
    }
}
