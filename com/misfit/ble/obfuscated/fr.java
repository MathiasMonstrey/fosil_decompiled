package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class fr extends ew {
    private long mGoalValue;

    public String getRequestName() {
        return "setGoalInSteps";
    }

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    public byte bZ() {
        return (byte) 16;
    }

    public void m15101f(long j) {
        this.mGoalValue = j;
        byte bZ = bZ();
        ByteBuffer allocate = ByteBuffer.allocate(6);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, (byte) 2);
        allocate.put(1, bZ);
        allocate.putInt(2, hb.m15168g(j));
        this.mRequestData = allocate.array();
    }

    public JSONObject getRequestDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("goalValueInSteps", this.mGoalValue);
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public void onRequestSent(int i) {
        this.mIsCompleted = true;
    }

    public Event getEventID() {
        return Event.SET_GOAL_IN_STEPS;
    }
}
