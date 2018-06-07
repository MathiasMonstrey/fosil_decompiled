package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class cl extends ew {
    private byte gF;

    public String getRequestName() {
        return "acknowledgeNewHeartbeat";
    }

    public String getCharacteristicUUID() {
        return "3dda0006-957f-7d4a-34a6-74696673696d";
    }

    public void m15018b(byte b) {
        this.gF = b;
        ByteBuffer allocate = ByteBuffer.allocate(3);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, (byte) 24);
        allocate.put(1, (byte) -3);
        allocate.put(2, this.gF);
        this.mRequestData = allocate.array();
    }

    public void onRequestSent(int i) {
        this.mIsCompleted = true;
    }

    public Event getEventID() {
        return Event.ACK_HEARTBEAT;
    }

    public JSONObject getRequestDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sequenceNumber", this.gF);
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }
}
