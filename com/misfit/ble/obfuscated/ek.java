package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.frameworks.common.constants.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class ek extends ew {
    private C4557a mv;
    private long mw;

    public static class C4557a extends ey {
        public byte kT;
        public int mx;
        public long my;
    }

    public /* synthetic */ ey getResponse() {
        return cT();
    }

    public C4557a cT() {
        return this.mv;
    }

    public String getRequestName() {
        return "otaErase";
    }

    public String getCharacteristicUUID() {
        return "3dda0003-957f-7d4a-34a6-74696673696d";
    }

    public void m15064f(long j) {
        this.mw = j;
        ByteBuffer allocate = ByteBuffer.allocate(7);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, (byte) 18);
        allocate.putShort(1, (short) 23131);
        allocate.putInt(3, hb.m15168g(j));
        this.mRequestData = allocate.array();
    }

    public void handleResponse(String str, byte[] bArr) {
        this.mv = m15065s(bArr);
        this.mIsCompleted = true;
    }

    public byte validateResponse(String str, byte[] bArr) {
        return ew.validateResponse(bArr, (byte) 19);
    }

    protected C4557a m15065s(byte[] bArr) {
        C4557a c4557a = new C4557a();
        c4557a.result = (byte) 0;
        c4557a.kT = (byte) 0;
        if (bArr.length < 8) {
            c4557a.result = (byte) 1;
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            c4557a.mx = wrap.getShort(1);
            c4557a.kT = wrap.get(3);
            c4557a.my = (long) wrap.getInt(4);
            if (!(23131 == c4557a.mx && c4557a.kT == (byte) 0)) {
                c4557a.result = (byte) 1;
            }
        }
        return c4557a;
    }

    public JSONObject getRequestDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pageOffset", this.mw);
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.mv != null) {
                jSONObject.put(Constants.RESULT, this.mv.result);
                jSONObject.put("status", this.mv.kT);
                jSONObject.put("fileHandle", this.mv.mx);
                jSONObject.put("newSizeWritten", this.mv.my);
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public Event getEventID() {
        return Event.OTA_ERASE;
    }
}
