package com.fossil;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class akv extends akm<akv> {
    protected final Map<String, agz> aTY = new LinkedHashMap();

    public akv(JsonNodeFactory jsonNodeFactory) {
        super(jsonNodeFactory);
    }

    public boolean mo1055a(ahg com_fossil_ahg) {
        return this.aTY.isEmpty();
    }

    public JsonNodeType DG() {
        return JsonNodeType.OBJECT;
    }

    public JsonToken AE() {
        return JsonToken.START_OBJECT;
    }

    public int size() {
        return this.aTY.size();
    }

    public Iterator<agz> DQ() {
        return this.aTY.values().iterator();
    }

    public agz bF(String str) {
        return (agz) this.aTY.get(str);
    }

    public Iterator<Entry<String, agz>> DR() {
        return this.aTY.entrySet().iterator();
    }

    public void serialize(JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException, JsonProcessingException {
        jsonGenerator.zJ();
        for (Entry entry : this.aTY.entrySet()) {
            jsonGenerator.aQ((String) entry.getKey());
            ((aki) entry.getValue()).serialize(jsonGenerator, com_fossil_ahg);
        }
        jsonGenerator.zK();
    }

    public void serializeWithType(JsonGenerator jsonGenerator, ahg com_fossil_ahg, ajv com_fossil_ajv) throws IOException, JsonProcessingException {
        com_fossil_ajv.mo1029b(this, jsonGenerator);
        for (Entry entry : this.aTY.entrySet()) {
            jsonGenerator.aQ((String) entry.getKey());
            ((aki) entry.getValue()).serialize(jsonGenerator, com_fossil_ahg);
        }
        com_fossil_ajv.mo1036e(this, jsonGenerator);
    }

    public agz m3669a(String str, agz com_fossil_agz) {
        if (com_fossil_agz == null) {
            com_fossil_agz = nullNode();
        }
        this.aTY.put(str, com_fossil_agz);
        return this;
    }

    public agz m3672b(String str, agz com_fossil_agz) {
        if (com_fossil_agz == null) {
            com_fossil_agz = nullNode();
        }
        return (agz) this.aTY.put(str, com_fossil_agz);
    }

    public akh bW(String str) {
        agz arrayNode = arrayNode();
        m3673c(str, arrayNode);
        return arrayNode;
    }

    public akv m3675t(String str, String str2) {
        return m3673c(str, str2 == null ? nullNode() : textNode(str2));
    }

    public akv m3674f(String str, boolean z) {
        return m3673c(str, booleanNode(z));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof akv)) {
            return false;
        }
        return m3671a((akv) obj);
    }

    protected boolean m3671a(akv com_fossil_akv) {
        return this.aTY.equals(com_fossil_akv.aTY);
    }

    public int hashCode() {
        return this.aTY.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder((size() << 4) + 32);
        stringBuilder.append("{");
        int i = 0;
        for (Entry entry : this.aTY.entrySet()) {
            if (i > 0) {
                stringBuilder.append(",");
            }
            int i2 = i + 1;
            aky.m3678a(stringBuilder, (String) entry.getKey());
            stringBuilder.append(':');
            stringBuilder.append(((agz) entry.getValue()).toString());
            i = i2;
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    protected akv m3673c(String str, agz com_fossil_agz) {
        this.aTY.put(str, com_fossil_agz);
        return this;
    }
}
