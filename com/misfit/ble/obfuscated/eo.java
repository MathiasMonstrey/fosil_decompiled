package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.frameworks.common.constants.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class eo extends ew {
    private C4560a mH;

    public static class C4560a extends ey {
        public byte kT;
    }

    public /* synthetic */ ey getResponse() {
        return cY();
    }

    public C4560a cY() {
        return this.mH;
    }

    public String getRequestName() {
        return "otaVerifyFile";
    }

    public String getCharacteristicUUID() {
        return "3dda0003-957f-7d4a-34a6-74696673696d";
    }

    public void ca() {
        ByteBuffer allocate = ByteBuffer.allocate(3);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, (byte) 13);
        allocate.putShort(1, (short) 23131);
        this.mRequestData = allocate.array();
    }

    public byte validateResponse(String str, byte[] bArr) {
        return ew.validateResponse(bArr, (byte) 14);
    }

    public void handleResponse(String str, byte[] bArr) {
        this.mH = m15070w(bArr);
        this.mIsCompleted = true;
    }

    protected C4560a m15070w(byte[] bArr) {
        C4560a c4560a = new C4560a();
        c4560a.result = (byte) 0;
        c4560a.kT = (byte) 0;
        if (bArr.length < 4) {
            c4560a.result = (byte) 1;
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            short s = wrap.getShort(1);
            c4560a.kT = wrap.get(3);
            if (!((short) 23131 == s && c4560a.kT == (byte) 0)) {
                c4560a.result = (byte) 1;
            }
        }
        return c4560a;
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.mH != null) {
                jSONObject.put(Constants.RESULT, this.mH.result);
                jSONObject.put("status", this.mH.kT);
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public Event getEventID() {
        return Event.OTA_VERIFY_FILE;
    }
}
