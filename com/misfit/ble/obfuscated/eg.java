package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.frameworks.common.constants.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class eg extends ew {
    private C4554a mq;

    public static class C4554a extends ey {
        public boolean mr;
    }

    public /* synthetic */ ey getResponse() {
        return cQ();
    }

    public C4554a cQ() {
        return this.mq;
    }

    public String getRequestName() {
        return "getTripleTapEnable";
    }

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    public byte bZ() {
        return (byte) 7;
    }

    public byte cc() {
        return (byte) 3;
    }

    public void ca() {
        byte bZ = bZ();
        byte cc = cc();
        ByteBuffer allocate = ByteBuffer.allocate(3);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, (byte) 1);
        allocate.put(1, bZ);
        allocate.put(2, cc);
        this.mRequestData = allocate.array();
    }

    public byte validateResponse(String str, byte[] bArr) {
        return ew.validateResponse(bArr, (byte) 3, bZ());
    }

    public void handleResponse(String str, byte[] bArr) {
        boolean z = false;
        C4554a c4554a = new C4554a();
        c4554a.result = (byte) 0;
        if (bArr.length < 3) {
            c4554a.result = (byte) 1;
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            if (wrap.get(2) != (byte) 0) {
                z = true;
            }
            c4554a.mr = z;
        }
        this.mq = c4554a;
        this.mIsCompleted = true;
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.mq != null) {
                jSONObject.put(Constants.RESULT, this.mq.result);
                jSONObject.put("enable", this.mq.mr);
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public Event getEventID() {
        return Event.GET_TRIPLE_TAP_ENABLE;
    }
}
