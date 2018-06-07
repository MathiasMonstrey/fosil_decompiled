package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.frameworks.common.constants.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class eh extends ew {
    private C4555a ms;

    public static class C4555a extends ey {
        public boolean mt;
    }

    public /* synthetic */ ey getResponse() {
        return cR();
    }

    public C4555a cR() {
        return this.ms;
    }

    public String getRequestName() {
        return "getWristFlickState";
    }

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    public byte bZ() {
        return (byte) 3;
    }

    public byte cw() {
        return (byte) 1;
    }

    public byte cc() {
        return (byte) 5;
    }

    public void ca() {
        byte cw = cw();
        byte bZ = bZ();
        byte cc = cc();
        ByteBuffer allocate = ByteBuffer.allocate(3);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, cw);
        allocate.put(1, bZ);
        allocate.put(2, cc);
        this.mRequestData = allocate.array();
    }

    public byte validateResponse(String str, byte[] bArr) {
        return ew.validateResponse(bArr, (byte) 3, bZ());
    }

    public void handleResponse(String str, byte[] bArr) {
        C4555a c4555a = new C4555a();
        c4555a.result = (byte) 0;
        if (bArr.length < 3) {
            c4555a.result = (byte) 1;
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            c4555a.mt = hb.m15165d(wrap.get(2));
        }
        this.ms = c4555a;
        this.mIsCompleted = true;
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.ms != null) {
                jSONObject.put(Constants.RESULT, this.ms.result);
                jSONObject.put("enable", this.ms.mt);
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public Event getEventID() {
        return Event.GET_WRIST_FLICK;
    }
}
