package com.fossil;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;

public class ajx extends ajz {
    public /* synthetic */ ajv mo1031c(agv com_fossil_agv) {
        return m3602e(com_fossil_agv);
    }

    public /* synthetic */ ajw mo1039d(agv com_fossil_agv) {
        return m3602e(com_fossil_agv);
    }

    public /* synthetic */ ajz mo1040f(agv com_fossil_agv) {
        return m3602e(com_fossil_agv);
    }

    public ajx(ajt com_fossil_ajt, agv com_fossil_agv, String str) {
        super(com_fossil_ajt, com_fossil_agv, str);
    }

    public ajx m3602e(agv com_fossil_agv) {
        return this._property == com_fossil_agv ? this : new ajx(this._idResolver, com_fossil_agv, this._typePropertyName);
    }

    public As getTypeInclusion() {
        return As.EXISTING_PROPERTY;
    }

    public void mo1029b(Object obj, JsonGenerator jsonGenerator) throws IOException {
        String bA = bA(obj);
        if (bA != null && jsonGenerator.zE()) {
            jsonGenerator.bp(bA);
        }
        jsonGenerator.zJ();
    }

    public void mo1028a(Object obj, JsonGenerator jsonGenerator, String str) throws IOException {
        if (str != null && jsonGenerator.zE()) {
            jsonGenerator.bp(str);
        }
        jsonGenerator.zJ();
    }
}
