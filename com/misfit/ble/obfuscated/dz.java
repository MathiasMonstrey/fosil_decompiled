package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.frameworks.common.constants.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class dz extends ew {
    private C4545a md;

    public static class C4545a extends ey {
        public short me;
        public boolean mf;
    }

    public /* synthetic */ ey getResponse() {
        return cJ();
    }

    public C4545a cJ() {
        return this.md;
    }

    public String getRequestName() {
        return "getGoalTracking";
    }

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    private byte cb() {
        return (byte) 1;
    }

    public byte bZ() {
        return (byte) 20;
    }

    public byte cc() {
        return (byte) 1;
    }

    public void ca() {
        byte cb = cb();
        byte bZ = bZ();
        byte cc = cc();
        ByteBuffer allocate = ByteBuffer.allocate(3);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, cb);
        allocate.put(1, bZ);
        allocate.put(2, cc);
        this.mRequestData = allocate.array();
    }

    public byte validateResponse(String str, byte[] bArr) {
        return ew.validateResponse(bArr, (byte) 3, bZ());
    }

    public void handleResponse(String str, byte[] bArr) {
        C4545a c4545a = new C4545a();
        c4545a.result = (byte) 0;
        if (bArr.length < 5) {
            c4545a.result = (byte) 1;
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            c4545a.me = hb.m15163c(wrap.get(3));
            c4545a.mf = hb.m15165d(wrap.get(4));
        }
        this.md = c4545a;
        this.mIsCompleted = true;
    }

    public JSONObject getResponseDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.md != null) {
                jSONObject.put(Constants.RESULT, this.md.result);
                jSONObject.put("goalIdNumber", this.md.me);
                jSONObject.put("goalTrackingState", this.md.mf);
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public Event getEventID() {
        return Event.GET_GOAL_TRACKING;
    }
}
