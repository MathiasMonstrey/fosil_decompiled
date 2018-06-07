package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.frameworks.common.constants.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class dl extends ew {
    private C4530a lu;

    public static class C4530a extends ey {
        public boolean lv;
    }

    public /* synthetic */ ey getResponse() {
        return cu();
    }

    public C4530a cu() {
        return this.lu;
    }

    public String getRequestName() {
        return "getActivityTaggingState";
    }

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    public byte bZ() {
        return (byte) 7;
    }

    public byte cc() {
        return (byte) 9;
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
        C4530a c4530a = new C4530a();
        c4530a.result = (byte) 0;
        if (bArr.length < 3) {
            c4530a.result = (byte) 1;
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            if (wrap.get(2) != (byte) 0) {
                z = true;
            }
            c4530a.lv = z;
        }
        this.lu = c4530a;
        this.mIsCompleted = true;
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.lu != null) {
                jSONObject.put(Constants.RESULT, this.lu.result);
                jSONObject.put("activityTaggingState", this.lu.lv);
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public Event getEventID() {
        return Event.GET_ACTIVITY_TAGGING_STATE;
    }
}
