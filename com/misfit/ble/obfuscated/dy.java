package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.frameworks.common.constants.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class dy extends ew {
    private C4544a mc;

    public static class C4544a extends ey {
        public long mb;
    }

    public /* synthetic */ ey getResponse() {
        return cI();
    }

    public C4544a cI() {
        return this.mc;
    }

    public String getRequestName() {
        return "getGoal";
    }

    public byte bZ() {
        return (byte) 5;
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
        C4544a c4544a = new C4544a();
        c4544a.result = (byte) 0;
        if (bArr.length < 6) {
            c4544a.result = (byte) 1;
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            c4544a.mb = ((long) wrap.getInt(2)) >> 8;
        }
        this.mc = c4544a;
        this.mIsCompleted = true;
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.mc != null) {
                jSONObject.put(Constants.RESULT, this.mc.result);
                jSONObject.put("goal", this.mc.mb);
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public Event getEventID() {
        return Event.GET_GOAL;
    }
}
