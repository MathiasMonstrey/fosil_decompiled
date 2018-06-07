package com.misfit.ble.obfuscated;

import com.misfit.ble.obfuscated.dd.C4520b;
import com.misfit.ble.shine.error.ShineError.Event;
import org.json.JSONObject;

public class db extends dd {
    private C4522a kZ;

    public static class C4522a extends C4520b {
        public byte[] ju;

        public C4522a(C4520b c4520b) {
            if (c4520b != null) {
                this.result = c4520b.result;
                this.kT = c4520b.kT;
                this.kU = c4520b.kU;
            }
        }
    }

    public /* synthetic */ C4520b cl() {
        return cm();
    }

    public /* synthetic */ ey getResponse() {
        return cm();
    }

    protected /* synthetic */ C4520b mo4865m(byte[] bArr) {
        return m15045n(bArr);
    }

    public db(ba baVar) {
        super(baVar);
    }

    public C4522a cm() {
        return this.kZ;
    }

    public String getRequestName() {
        return "fileGetHardwareLog";
    }

    public void ca() {
        super.m15035a((short) 16, 0, 65535);
    }

    public void mo4864k(byte[] bArr) {
        super.mo4864k(bArr);
        this.kZ.ju = bArr;
    }

    protected C4522a m15045n(byte[] bArr) {
        this.kZ = new C4522a(super.mo4865m(bArr));
        return this.kZ;
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject;
        JSONObject responseDescriptionJSON = super.getResponseDescriptionJSON();
        if (responseDescriptionJSON == null) {
            jSONObject = new JSONObject();
        } else {
            jSONObject = responseDescriptionJSON;
        }
        try {
            if (this.kZ != null) {
                jSONObject.put("data", hb.m15159E(this.kZ.ju));
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public Event getEventID() {
        return Event.FILE_GET_HARDWARE_LOG;
    }
}
