package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.frameworks.common.constants.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class ej extends ew {
    private C4556a mu;

    public static class C4556a extends ey {
    }

    public /* synthetic */ ey getResponse() {
        return cS();
    }

    public C4556a cS() {
        return this.mu;
    }

    public String getRequestName() {
        return "otaEnter";
    }

    public byte bZ() {
        return (byte) -15;
    }

    public byte cg() {
        return (byte) 8;
    }

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    public void ca() {
        byte bZ = bZ();
        byte cg = cg();
        ByteBuffer allocate = ByteBuffer.allocate(3);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, (byte) 2);
        allocate.put(1, bZ);
        allocate.put(2, cg);
        this.mRequestData = allocate.array();
    }

    public void handleResponse(String str, byte[] bArr) {
        this.mu = m15063r(bArr);
        this.mIsCompleted = true;
    }

    public byte validateResponse(String str, byte[] bArr) {
        return ew.validateResponse(bArr, (byte) 3, bZ());
    }

    protected C4556a m15063r(byte[] bArr) {
        C4556a c4556a = new C4556a();
        c4556a.result = (byte) 0;
        if (bArr.length < 3 || (byte) 9 != bArr[2]) {
            c4556a.result = (byte) 1;
        }
        return c4556a;
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.mu != null) {
                jSONObject.put(Constants.RESULT, this.mu.result);
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public Event getEventID() {
        return Event.OTA_ENTER;
    }
}
