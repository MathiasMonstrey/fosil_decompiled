package com.fossil;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;

public class aka extends akg {
    public /* synthetic */ ajv mo1031c(agv com_fossil_agv) {
        return m3646h(com_fossil_agv);
    }

    public aka(ajt com_fossil_ajt, agv com_fossil_agv) {
        super(com_fossil_ajt, com_fossil_agv);
    }

    public aka m3646h(agv com_fossil_agv) {
        return this._property == com_fossil_agv ? this : new aka(this._idResolver, com_fossil_agv);
    }

    public As getTypeInclusion() {
        return As.WRAPPER_OBJECT;
    }

    public void mo1029b(Object obj, JsonGenerator jsonGenerator) throws IOException {
        String bA = bA(obj);
        if (jsonGenerator.zE()) {
            if (bA != null) {
                jsonGenerator.bp(bA);
            }
            jsonGenerator.zJ();
            return;
        }
        jsonGenerator.zJ();
        jsonGenerator.aV(bS(bA));
    }

    public void mo1032c(Object obj, JsonGenerator jsonGenerator) throws IOException {
        String bA = bA(obj);
        if (jsonGenerator.zE()) {
            if (bA != null) {
                jsonGenerator.bp(bA);
            }
            jsonGenerator.zH();
            return;
        }
        jsonGenerator.zJ();
        jsonGenerator.aU(bS(bA));
    }

    public void mo1026a(Object obj, JsonGenerator jsonGenerator) throws IOException {
        String bA = bA(obj);
        if (!jsonGenerator.zE()) {
            jsonGenerator.zJ();
            jsonGenerator.aQ(bS(bA));
        } else if (bA != null) {
            jsonGenerator.bp(bA);
        }
    }

    public void mo1027a(Object obj, JsonGenerator jsonGenerator, Class<?> cls) throws IOException {
        String a = m3577a(obj, cls);
        if (!jsonGenerator.zE()) {
            jsonGenerator.zJ();
            jsonGenerator.aQ(bS(a));
        } else if (a != null) {
            jsonGenerator.bp(a);
        }
    }

    public void mo1036e(Object obj, JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.zK();
        if (!jsonGenerator.zE()) {
            jsonGenerator.zK();
        }
    }

    public void mo1037f(Object obj, JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.zI();
        if (!jsonGenerator.zE()) {
            jsonGenerator.zK();
        }
    }

    public void mo1034d(Object obj, JsonGenerator jsonGenerator) throws IOException {
        if (!jsonGenerator.zE()) {
            jsonGenerator.zK();
        }
    }

    public void mo1028a(Object obj, JsonGenerator jsonGenerator, String str) throws IOException {
        if (jsonGenerator.zE()) {
            if (str != null) {
                jsonGenerator.bp(str);
            }
            jsonGenerator.zJ();
            return;
        }
        jsonGenerator.zJ();
        jsonGenerator.aV(bS(str));
    }

    public void mo1030b(Object obj, JsonGenerator jsonGenerator, String str) throws IOException {
        if (jsonGenerator.zE()) {
            if (str != null) {
                jsonGenerator.bp(str);
            }
            jsonGenerator.zH();
            return;
        }
        jsonGenerator.zJ();
        jsonGenerator.aU(bS(str));
    }

    public void mo1033c(Object obj, JsonGenerator jsonGenerator, String str) throws IOException {
        if (!jsonGenerator.zE()) {
            mo1036e(obj, jsonGenerator);
        }
    }

    public void mo1035d(Object obj, JsonGenerator jsonGenerator, String str) throws IOException {
        if (!jsonGenerator.zE()) {
            mo1037f(obj, jsonGenerator);
        }
    }

    protected String bS(String str) {
        return str == null ? "" : str;
    }
}
