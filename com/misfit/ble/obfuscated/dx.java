package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.frameworks.common.constants.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class dx extends ew {
    private C4543a ma;

    public static class C4543a extends ey {
        public long mb;
    }

    public /* synthetic */ ey getResponse() {
        return cH();
    }

    public C4543a cH() {
        return this.ma;
    }

    public String getRequestName() {
        return "getGoalInSteps";
    }

    public byte bZ() {
        return (byte) 16;
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
        C4543a c4543a = new C4543a();
        c4543a.result = (byte) 0;
        if (bArr.length < 6) {
            c4543a.result = (byte) 1;
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            c4543a.mb = hb.m15169j(wrap.getInt(2));
        }
        this.ma = c4543a;
        this.mIsCompleted = true;
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.ma != null) {
                jSONObject.put(Constants.RESULT, this.ma.result);
                jSONObject.put("goalInSteps", this.ma.mb);
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public Event getEventID() {
        return Event.GET_GOAL_IN_STEPS;
    }
}
