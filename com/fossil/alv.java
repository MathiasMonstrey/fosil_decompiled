package com.fossil;

import com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;

public final class alv extends ahb<Object> {
    protected final ahb<Object> _serializer;
    protected final ajv aQx;

    public alv(ajv com_fossil_ajv, ahb<?> com_fossil_ahb_) {
        this.aQx = com_fossil_ajv;
        this._serializer = com_fossil_ahb_;
    }

    public void serialize(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        this._serializer.serializeWithType(obj, jsonGenerator, com_fossil_ahg, this.aQx);
    }

    public void serializeWithType(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg, ajv com_fossil_ajv) throws IOException {
        this._serializer.serializeWithType(obj, jsonGenerator, com_fossil_ahg, com_fossil_ajv);
    }

    public Class<Object> handledType() {
        return Object.class;
    }

    public ajv GO() {
        return this.aQx;
    }
}
