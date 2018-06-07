package com.misfit.ble.obfuscated;

import com.misfit.ble.obfuscated.dd.C4520b;
import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.frameworks.common.constants.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class da extends dd {
    private short kQ;
    private C4521a kY;

    public static class C4521a extends C4520b {
        public byte[] kV;

        public C4521a(C4520b c4520b) {
            if (c4520b != null) {
                this.result = c4520b.result;
                this.kT = c4520b.kT;
                this.kU = c4520b.kU;
            }
        }
    }

    public /* synthetic */ C4520b cl() {
        return cj();
    }

    public /* synthetic */ ey getResponse() {
        return cj();
    }

    protected /* synthetic */ C4520b mo4865m(byte[] bArr) {
        return m15041l(bArr);
    }

    public da(ba baVar) {
        super(baVar);
    }

    public C4521a cj() {
        return this.kY;
    }

    public String getRequestName() {
        return "fileGetActivity";
    }

    public void m15039c(short s) {
        super.m15035a(s, 0, 65535);
    }

    public void mo4864k(byte[] bArr) {
        super.mo4864k(bArr);
        this.kY.kV = bArr;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        this.kQ = wrap.getShort();
        if (!m15038a(bArr, hb.m15169j(wrap.getInt(bArr.length - 4)))) {
            this.kY.result = (byte) 3;
        }
    }

    protected C4521a m15041l(byte[] bArr) {
        this.kY = new C4521a(super.mo4865m(bArr));
        return this.kY;
    }

    private boolean m15038a(byte[] bArr, long j) {
        return hd.m15176a(bArr.length + -4, bArr) == j;
    }

    public boolean ck() {
        return this.kY.result == (byte) 3 && this.kQ != this.kY.kU;
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.kY != null) {
                jSONObject.put(Constants.RESULT, this.kY.result);
                jSONObject.put("status", this.kY.kT);
                jSONObject.put("handle", this.kQ);
                jSONObject.put("rawData", hb.m15159E(this.kY.kV));
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public Event getEventID() {
        return Event.FILE_GET_ACTIVITY;
    }
}
