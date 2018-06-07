package com.fossil;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;

public class ajz extends ajw {
    protected final String _typePropertyName;

    public /* synthetic */ ajv mo1031c(agv com_fossil_agv) {
        return mo1040f(com_fossil_agv);
    }

    public /* synthetic */ ajw mo1039d(agv com_fossil_agv) {
        return mo1040f(com_fossil_agv);
    }

    public ajz(ajt com_fossil_ajt, agv com_fossil_agv, String str) {
        super(com_fossil_ajt, com_fossil_agv);
        this._typePropertyName = str;
    }

    public ajz mo1040f(agv com_fossil_agv) {
        return this._property == com_fossil_agv ? this : new ajz(this._idResolver, com_fossil_agv, this._typePropertyName);
    }

    public String getPropertyName() {
        return this._typePropertyName;
    }

    public As getTypeInclusion() {
        return As.PROPERTY;
    }

    public void mo1029b(Object obj, JsonGenerator jsonGenerator) throws IOException {
        String bA = bA(obj);
        if (bA == null) {
            jsonGenerator.zJ();
        } else if (jsonGenerator.zE()) {
            jsonGenerator.bp(bA);
            jsonGenerator.zJ();
        } else {
            jsonGenerator.zJ();
            jsonGenerator.mo924r(this._typePropertyName, bA);
        }
    }

    public void mo1036e(Object obj, JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.zK();
    }

    public void mo1028a(Object obj, JsonGenerator jsonGenerator, String str) throws IOException {
        if (str == null) {
            jsonGenerator.zJ();
        } else if (jsonGenerator.zE()) {
            jsonGenerator.bp(str);
            jsonGenerator.zJ();
        } else {
            jsonGenerator.zJ();
            jsonGenerator.mo924r(this._typePropertyName, str);
        }
    }

    public void mo1033c(Object obj, JsonGenerator jsonGenerator, String str) throws IOException {
        jsonGenerator.zK();
    }
}
