package com.fossil;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class akh extends akm<akh> {
    private final List<agz> aTr = new ArrayList();

    public akh(JsonNodeFactory jsonNodeFactory) {
        super(jsonNodeFactory);
    }

    public boolean mo1055a(ahg com_fossil_ahg) {
        return this.aTr.isEmpty();
    }

    public JsonNodeType DG() {
        return JsonNodeType.ARRAY;
    }

    public JsonToken AE() {
        return JsonToken.START_ARRAY;
    }

    public int size() {
        return this.aTr.size();
    }

    public Iterator<agz> DQ() {
        return this.aTr.iterator();
    }

    public agz bF(String str) {
        return null;
    }

    public void serialize(JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        List list = this.aTr;
        int size = list.size();
        jsonGenerator.fk(size);
        for (int i = 0; i < size; i++) {
            agz com_fossil_agz = (agz) list.get(i);
            if (com_fossil_agz instanceof aki) {
                ((aki) com_fossil_agz).serialize(jsonGenerator, com_fossil_ahg);
            } else {
                com_fossil_agz.serialize(jsonGenerator, com_fossil_ahg);
            }
        }
        jsonGenerator.zI();
    }

    public void serializeWithType(JsonGenerator jsonGenerator, ahg com_fossil_ahg, ajv com_fossil_ajv) throws IOException {
        com_fossil_ajv.mo1032c(this, jsonGenerator);
        for (agz com_fossil_agz : this.aTr) {
            ((aki) com_fossil_agz).serialize(jsonGenerator, com_fossil_ahg);
        }
        com_fossil_ajv.mo1037f(this, jsonGenerator);
    }

    public akh m3659a(agz com_fossil_agz) {
        if (com_fossil_agz == null) {
            com_fossil_agz = nullNode();
        }
        m3661b(com_fossil_agz);
        return this;
    }

    public akh Gk() {
        m3661b(nullNode());
        return this;
    }

    public akh bV(String str) {
        if (str == null) {
            return Gk();
        }
        return m3661b(textNode(str));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof akh)) {
            return false;
        }
        return this.aTr.equals(((akh) obj).aTr);
    }

    public int hashCode() {
        return this.aTr.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder((size() << 4) + 16);
        stringBuilder.append('[');
        int size = this.aTr.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuilder.append(',');
            }
            stringBuilder.append(((agz) this.aTr.get(i)).toString());
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    protected akh m3661b(agz com_fossil_agz) {
        this.aTr.add(com_fossil_agz);
        return this;
    }
}
