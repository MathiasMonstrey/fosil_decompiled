package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.frameworks.common.constants.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class cz extends ew {
    private short f1538if;
    private C4517a kX;

    public static class C4517a extends ey {
        public byte kT;
    }

    public /* synthetic */ ey getResponse() {
        return ci();
    }

    public C4517a ci() {
        return this.kX;
    }

    public String getRequestName() {
        return "fileErase";
    }

    public String getCharacteristicUUID() {
        return "3dda0003-957f-7d4a-34a6-74696673696d";
    }

    public void m15024c(short s) {
        this.f1538if = s;
        ByteBuffer allocate = ByteBuffer.allocate(3);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, (byte) 3);
        allocate.putShort(1, s);
        this.mRequestData = allocate.array();
    }

    public byte validateResponse(String str, byte[] bArr) {
        return ew.validateResponse(bArr, (byte) 4);
    }

    public void handleResponse(String str, byte[] bArr) {
        this.kX = m15023j(bArr);
        this.mIsCompleted = true;
    }

    private C4517a m15023j(byte[] bArr) {
        C4517a c4517a = new C4517a();
        c4517a.result = (byte) 0;
        c4517a.kT = (byte) 0;
        if (bArr.length < 4) {
            c4517a.result = (byte) 1;
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            short s = wrap.getShort(1);
            c4517a.kT = wrap.get(3);
            if (!(s == this.f1538if && c4517a.kT == (byte) 0)) {
                c4517a.result = (byte) 1;
            }
        }
        return c4517a;
    }

    public JSONObject getRequestDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fileHandle", hb.m15164d(this.f1538if));
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.kX != null) {
                jSONObject.put(Constants.RESULT, this.kX.result);
                jSONObject.put("status", this.kX.kT);
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public Event getEventID() {
        return Event.FILE_ERASE;
    }
}
