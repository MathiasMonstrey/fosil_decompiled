package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class ft extends ew {
    private short mGoalIdNumber;
    private boolean mGoalTrackingState;

    public String getRequestName() {
        return "setGoalTracking";
    }

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    private byte cb() {
        return (byte) 2;
    }

    public byte bZ() {
        return (byte) 20;
    }

    public byte cc() {
        return (byte) 1;
    }

    public void m15103a(short s, boolean z) {
        this.mGoalIdNumber = s;
        this.mGoalTrackingState = z;
        byte cb = cb();
        byte bZ = bZ();
        byte cc = cc();
        ByteBuffer allocate = ByteBuffer.allocate(5);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, cb);
        allocate.put(1, bZ);
        allocate.put(2, cc);
        allocate.put(3, hb.m15166e(s));
        allocate.put(4, hb.m15167f(z));
        this.mRequestData = allocate.array();
    }

    public JSONObject getRequestDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("goalIdNumber", this.mGoalIdNumber);
            jSONObject.put("goalTrackingState", this.mGoalTrackingState);
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public void onRequestSent(int i) {
        this.mIsCompleted = true;
    }

    public Event getEventID() {
        return Event.SET_GOAL_TRACKING;
    }
}
