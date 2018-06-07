package com.fossil;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.io.IOException;

public class akw extends ala {
    protected final Object _value;

    public akw(Object obj) {
        this._value = obj;
    }

    public JsonNodeType DG() {
        return JsonNodeType.POJO;
    }

    public JsonToken AE() {
        return JsonToken.VALUE_EMBEDDED_OBJECT;
    }

    public byte[] DL() throws IOException {
        if (this._value instanceof byte[]) {
            return (byte[]) this._value;
        }
        return super.DL();
    }

    public String DP() {
        return this._value == null ? "null" : this._value.toString();
    }

    public final void serialize(JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        if (this._value == null) {
            com_fossil_ahg.defaultSerializeNull(jsonGenerator);
        } else if (this._value instanceof aha) {
            ((aha) this._value).serialize(jsonGenerator, com_fossil_ahg);
        } else {
            jsonGenerator.writeObject(this._value);
        }
    }

    public Object Gt() {
        return this._value;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof akw)) {
            return false;
        }
        return m3676a((akw) obj);
    }

    protected boolean m3676a(akw com_fossil_akw) {
        if (this._value == null) {
            return com_fossil_akw._value == null;
        } else {
            return this._value.equals(com_fossil_akw._value);
        }
    }

    public int hashCode() {
        return this._value.hashCode();
    }

    public String toString() {
        if (this._value instanceof byte[]) {
            return String.format("(binary value of %d bytes)", new Object[]{Integer.valueOf(((byte[]) this._value).length)});
        } else if (!(this._value instanceof amr)) {
            return String.valueOf(this._value);
        } else {
            return String.format("(raw value '%s')", new Object[]{((amr) this._value).toString()});
        }
    }
}
