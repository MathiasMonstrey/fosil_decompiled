package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class fk extends ew {
    private long mConnectionHeartbeatInterval;

    public String getRequestName() {
        return "setConnectionHeartbeatInterval";
    }

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    public void m15094f(long j) {
        this.mConnectionHeartbeatInterval = j;
        ByteBuffer allocate = ByteBuffer.allocate(7);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, (byte) 2);
        allocate.put(1, (byte) 12);
        allocate.put(2, (byte) -16);
        allocate.putInt(3, hb.m15168g(this.mConnectionHeartbeatInterval));
        this.mRequestData = allocate.array();
    }

    public JSONObject getRequestDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("connectionHeartbeatInterval", this.mConnectionHeartbeatInterval);
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public void onRequestSent(int i) {
        this.mIsCompleted = true;
    }

    public Event getEventID() {
        return Event.SET_FILE_STREAMING_HEARTBEAT_INTERVAL;
    }
}
