package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.frameworks.common.constants.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class el extends ew {
    private C4558a mz;

    public static class C4558a extends ey {
        public byte kT;
        public long mA;
    }

    public /* synthetic */ ey getResponse() {
        return cU();
    }

    public C4558a cU() {
        return this.mz;
    }

    public String getRequestName() {
        return "otaGetSizeWritten";
    }

    public String getCharacteristicUUID() {
        return "3dda0003-957f-7d4a-34a6-74696673696d";
    }

    public void ca() {
        ByteBuffer allocate = ByteBuffer.allocate(3);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, (byte) 20);
        allocate.putShort(1, (short) 23131);
        this.mRequestData = allocate.array();
    }

    public void handleResponse(String str, byte[] bArr) {
        this.mz = m15066t(bArr);
        this.mIsCompleted = true;
    }

    public byte validateResponse(String str, byte[] bArr) {
        return ew.validateResponse(bArr, (byte) 21);
    }

    protected C4558a m15066t(byte[] bArr) {
        C4558a c4558a = new C4558a();
        c4558a.result = (byte) 0;
        c4558a.kT = (byte) 0;
        if (bArr.length < 8) {
            c4558a.result = (byte) 1;
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            short s = wrap.getShort(1);
            c4558a.kT = wrap.get(3);
            c4558a.mA = (long) wrap.getInt(4);
            if (!((short) 23131 == s && c4558a.kT == (byte) 0)) {
                c4558a.result = (byte) 1;
            }
        }
        return c4558a;
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.mz != null) {
                jSONObject.put(Constants.RESULT, this.mz.result);
                jSONObject.put("status", this.mz.kT);
                jSONObject.put("sizeWritten", this.mz.mA);
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public Event getEventID() {
        return Event.OTA_GET_SIZE_WRITTEN;
    }
}
