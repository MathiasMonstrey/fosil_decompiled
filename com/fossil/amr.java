package com.fossil;

import com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;

public class amr implements aha {
    protected Object _value;

    public amr(String str) {
        this._value = str;
    }

    public void serialize(JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        if (this._value instanceof aha) {
            ((aha) this._value).serialize(jsonGenerator, com_fossil_ahg);
        } else {
            m3894c(jsonGenerator);
        }
    }

    public void serializeWithType(JsonGenerator jsonGenerator, ahg com_fossil_ahg, ajv com_fossil_ajv) throws IOException {
        if (this._value instanceof aha) {
            ((aha) this._value).serializeWithType(jsonGenerator, com_fossil_ahg, com_fossil_ajv);
        } else if (this._value instanceof afc) {
            serialize(jsonGenerator, com_fossil_ahg);
        }
    }

    public void m3893b(JsonGenerator jsonGenerator) throws IOException {
        if (this._value instanceof aha) {
            jsonGenerator.writeObject(this._value);
        } else {
            m3894c(jsonGenerator);
        }
    }

    protected void m3894c(JsonGenerator jsonGenerator) throws IOException {
        if (this._value instanceof afc) {
            jsonGenerator.mo854e((afc) this._value);
        } else {
            jsonGenerator.aS(String.valueOf(this._value));
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof amr)) {
            return false;
        }
        amr com_fossil_amr = (amr) obj;
        if (this._value == com_fossil_amr._value) {
            return true;
        }
        if (this._value == null || !this._value.equals(com_fossil_amr._value)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this._value == null ? 0 : this._value.hashCode();
    }

    public String toString() {
        String str = "[RawValue of type %s]";
        Object[] objArr = new Object[1];
        objArr[0] = this._value == null ? "NULL" : this._value.getClass().getName();
        return String.format(str, objArr);
    }
}
