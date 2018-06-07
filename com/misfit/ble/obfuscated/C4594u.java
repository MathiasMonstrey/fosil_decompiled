package com.misfit.ble.obfuscated;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONException;
import org.json.JSONObject;

public class C4594u {
    private short bv;
    private byte bw;
    private byte bx;

    public C4594u(short s, byte b, byte b2) {
        this.bv = s;
        this.bw = b;
        this.bx = b2;
    }

    public byte[] getData() {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(this.bw);
        allocate.putShort(this.bv);
        allocate.put(this.bx);
        return allocate.array();
    }

    public boolean equals(Object obj) {
        if (obj instanceof C4594u) {
            C4594u c4594u = (C4594u) obj;
            if (this.bv == c4594u.bv && this.bw == c4594u.bw && this.bx == c4594u.bx) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        ByteBuffer wrap = ByteBuffer.wrap(getData());
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        return wrap.getInt(0);
    }

    public JSONObject m15231C() {
        JSONObject jSONObject;
        Throwable e;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("uAppDeclarationID", this.bv);
                jSONObject.put("uAppVersion", this.bw);
                jSONObject.put("uAppVariation", this.bx);
            } catch (JSONException e2) {
                e = e2;
                C4462b.m14831a(e, "");
                return jSONObject;
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            jSONObject = jSONObject2;
            e = th;
            C4462b.m14831a(e, "");
            return jSONObject;
        }
        return jSONObject;
    }

    public String toString() {
        return m15231C().toString();
    }
}
