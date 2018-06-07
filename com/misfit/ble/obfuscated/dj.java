package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.frameworks.common.constants.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class dj extends ew {
    private C4528a lq;

    public static class C4528a extends ey {
        public boolean lr;
    }

    public /* synthetic */ ey getResponse() {
        return cs();
    }

    public C4528a cs() {
        return this.lq;
    }

    public String getRequestName() {
        return "getActivationState";
    }

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    public byte bZ() {
        return (byte) -15;
    }

    public void ca() {
        byte bZ = bZ();
        ByteBuffer allocate = ByteBuffer.allocate(3);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, (byte) 1);
        allocate.put(1, bZ);
        allocate.put(2, (byte) 11);
        this.mRequestData = allocate.array();
    }

    public byte validateResponse(String str, byte[] bArr) {
        return ew.validateResponse(bArr, (byte) 3, bZ());
    }

    public void handleResponse(String str, byte[] bArr) {
        boolean z = false;
        C4528a c4528a = new C4528a();
        c4528a.result = (byte) 0;
        if (bArr.length < 3) {
            c4528a.result = (byte) 1;
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            if ((byte) 1 == wrap.get(2)) {
                z = true;
            }
            c4528a.lr = z;
        }
        this.lq = c4528a;
        this.mIsCompleted = true;
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.lq != null) {
                jSONObject.put(Constants.RESULT, this.lq.result);
                jSONObject.put("activated", this.lq.lr);
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public Event getEventID() {
        return Event.GET_ACTIVATION_STATE;
    }
}
