package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class fy extends ew {
    private long mTimestamp;
    private int nl;
    private short nm;

    public String getRequestName() {
        return "setTime";
    }

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    public byte bZ() {
        return (byte) 4;
    }

    public void m15108a(long j, int i, short s) {
        this.mTimestamp = j;
        this.nl = i;
        this.nm = s;
        byte bZ = bZ();
        ByteBuffer allocate = ByteBuffer.allocate(10);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, (byte) 2);
        allocate.put(1, bZ);
        allocate.putInt(2, hb.m15168g(j));
        allocate.putShort(6, hb.m15170k(i));
        allocate.putShort(8, s);
        this.mRequestData = allocate.array();
    }

    public JSONObject getRequestDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("timestamp", this.mTimestamp);
            jSONObject.put("partialSeconds", this.nl);
            jSONObject.put("timezoneOffsetInMinutes", this.nm);
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public void onRequestSent(int i) {
        this.mIsCompleted = true;
    }

    public Event getEventID() {
        return Event.SET_TIME;
    }
}
