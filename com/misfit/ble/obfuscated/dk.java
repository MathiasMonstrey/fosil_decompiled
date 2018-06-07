package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.frameworks.common.constants.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class dk extends ew {
    private C4529a ls;

    public static class C4529a extends ey {
        public long lt;
    }

    public /* synthetic */ ey getResponse() {
        return ct();
    }

    public C4529a ct() {
        return this.ls;
    }

    public String getRequestName() {
        return "getActivityPoint";
    }

    public byte bZ() {
        return (byte) 6;
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
        C4529a c4529a = new C4529a();
        c4529a.result = (byte) 0;
        if (bArr.length < 6) {
            c4529a.result = (byte) 1;
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            c4529a.lt = ((long) wrap.getInt(2)) >> 8;
        }
        this.ls = c4529a;
        this.mIsCompleted = true;
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.ls != null) {
                jSONObject.put(Constants.RESULT, this.ls.result);
                jSONObject.put("activityPoint", this.ls.lt);
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public Event getEventID() {
        return Event.GET_ACTIVITY_POINT;
    }
}
