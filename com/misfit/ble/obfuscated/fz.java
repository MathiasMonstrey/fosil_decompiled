package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class fz extends ew {
    private boolean nn;

    public String getRequestName() {
        return "setTripleTapEnable";
    }

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    public byte bZ() {
        return (byte) 7;
    }

    public byte cc() {
        return (byte) 3;
    }

    public void m15109e(boolean z) {
        int i = 1;
        this.nn = z;
        byte bZ = bZ();
        byte cc = cc();
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, (byte) 2);
        allocate.put(1, bZ);
        allocate.put(2, cc);
        if (!z) {
            i = 0;
        }
        allocate.put(3, (byte) i);
        this.mRequestData = allocate.array();
    }

    public JSONObject getRequestDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tripleTapEnable", this.nn);
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public void onRequestSent(int i) {
        this.mIsCompleted = true;
    }

    public Event getEventID() {
        return Event.SET_TRIPLE_TAP_ENABLE;
    }
}
