package com.fossil;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;

public class ajy extends akg {
    protected final String _typePropertyName;

    public /* synthetic */ ajv mo1031c(agv com_fossil_agv) {
        return m3618g(com_fossil_agv);
    }

    public ajy(ajt com_fossil_ajt, agv com_fossil_agv, String str) {
        super(com_fossil_ajt, com_fossil_agv);
        this._typePropertyName = str;
    }

    public ajy m3618g(agv com_fossil_agv) {
        return this._property == com_fossil_agv ? this : new ajy(this._idResolver, com_fossil_agv, this._typePropertyName);
    }

    public String getPropertyName() {
        return this._typePropertyName;
    }

    public As getTypeInclusion() {
        return As.EXTERNAL_PROPERTY;
    }

    public void mo1029b(Object obj, JsonGenerator jsonGenerator) throws IOException {
        m3621h(obj, jsonGenerator);
    }

    public void mo1032c(Object obj, JsonGenerator jsonGenerator) throws IOException {
        m3622i(obj, jsonGenerator);
    }

    public void mo1026a(Object obj, JsonGenerator jsonGenerator) throws IOException {
        m3619g(obj, jsonGenerator);
    }

    public void mo1027a(Object obj, JsonGenerator jsonGenerator, Class<?> cls) throws IOException {
        m3619g(obj, jsonGenerator);
    }

    public void mo1036e(Object obj, JsonGenerator jsonGenerator) throws IOException {
        m3617f(obj, jsonGenerator, bA(obj));
    }

    public void mo1037f(Object obj, JsonGenerator jsonGenerator) throws IOException {
        m3620g(obj, jsonGenerator, bA(obj));
    }

    public void mo1034d(Object obj, JsonGenerator jsonGenerator) throws IOException {
        m3615e(obj, jsonGenerator, bA(obj));
    }

    public void mo1028a(Object obj, JsonGenerator jsonGenerator, String str) throws IOException {
        m3621h(obj, jsonGenerator);
    }

    public void mo1030b(Object obj, JsonGenerator jsonGenerator, String str) throws IOException {
        m3622i(obj, jsonGenerator);
    }

    public void mo1033c(Object obj, JsonGenerator jsonGenerator, String str) throws IOException {
        m3617f(obj, jsonGenerator, str);
    }

    public void mo1035d(Object obj, JsonGenerator jsonGenerator, String str) throws IOException {
        m3620g(obj, jsonGenerator, str);
    }

    protected final void m3619g(Object obj, JsonGenerator jsonGenerator) throws IOException {
    }

    protected final void m3621h(Object obj, JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.zJ();
    }

    protected final void m3622i(Object obj, JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.zH();
    }

    protected final void m3615e(Object obj, JsonGenerator jsonGenerator, String str) throws IOException {
        if (str != null) {
            jsonGenerator.mo924r(this._typePropertyName, str);
        }
    }

    protected final void m3617f(Object obj, JsonGenerator jsonGenerator, String str) throws IOException {
        jsonGenerator.zK();
        if (str != null) {
            jsonGenerator.mo924r(this._typePropertyName, str);
        }
    }

    protected final void m3620g(Object obj, JsonGenerator jsonGenerator, String str) throws IOException {
        jsonGenerator.zI();
        if (str != null) {
            jsonGenerator.mo924r(this._typePropertyName, str);
        }
    }
}
