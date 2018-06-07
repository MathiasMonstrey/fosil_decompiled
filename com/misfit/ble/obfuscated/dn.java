package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.frameworks.common.constants.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class dn extends ew {
    private C4532a lx;

    public static class C4532a extends ey {
        public short ly;
    }

    public /* synthetic */ ey getResponse() {
        return cx();
    }

    public C4532a cx() {
        return this.lx;
    }

    public String getRequestName() {
        return "getBattery";
    }

    public byte bZ() {
        return (byte) 8;
    }

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    public void ca() {
        byte bZ = bZ();
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, (byte) 1);
        allocate.put(1, bZ);
        this.mRequestData = allocate.array();
    }

    public byte validateResponse(String str, byte[] bArr) {
        return ew.validateResponse(bArr, (byte) 3, bZ());
    }

    public void handleResponse(String str, byte[] bArr) {
        C4532a c4532a = new C4532a();
        c4532a.result = (byte) 0;
        if (bArr.length < 3) {
            c4532a.result = (byte) 1;
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            c4532a.ly = hb.m15163c(wrap.get(2));
        }
        this.lx = c4532a;
        this.mIsCompleted = true;
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.lx != null) {
                jSONObject.put(Constants.RESULT, this.lx.result);
                jSONObject.put("batteryLevel", this.lx.ly);
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public Event getEventID() {
        return Event.GET_BATTERY;
    }
}
