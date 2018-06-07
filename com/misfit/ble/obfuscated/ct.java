package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class ct extends ew {
    private short kW;

    public String getRequestName() {
        return "eventMappingSystemControl";
    }

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    public void m15021b(byte b) {
        this.kW = hb.m15163c(b);
        ByteBuffer allocate = ByteBuffer.allocate(3);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, (byte) 2);
        allocate.put(1, (byte) 11);
        allocate.put(2, b);
        this.mRequestData = allocate.array();
    }

    public JSONObject getRequestDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("controlBits", this.kW);
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public void onRequestSent(int i) {
        this.mIsCompleted = true;
    }

    public Event getEventID() {
        return Event.MAPPING_SYSTEM_CONTROL;
    }
}
