package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class fj extends ew {
    public byte mClockState;

    public String getRequestName() {
        return "setClockState";
    }

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    public byte bZ() {
        return (byte) 7;
    }

    public byte cc() {
        return (byte) 2;
    }

    public void m15093b(byte b) {
        this.mClockState = b;
        byte bZ = bZ();
        byte cc = cc();
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, (byte) 2);
        allocate.put(1, bZ);
        allocate.put(2, cc);
        allocate.put(3, b);
        this.mRequestData = allocate.array();
    }

    public JSONObject getRequestDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("clockState", this.mClockState);
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public void onRequestSent(int i) {
        this.mIsCompleted = true;
    }

    public Event getEventID() {
        return Event.SET_CLOCK_STATE;
    }
}
