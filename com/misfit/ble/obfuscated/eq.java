package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class eq extends ew {
    private short mO;
    private short mP;

    public String getRequestName() {
        return "playButtonAnimation";
    }

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    public void m15073b(short s, short s2) {
        ByteBuffer allocate;
        this.mO = s;
        this.mP = s2;
        if (this.mP == (short) 1) {
            allocate = ByteBuffer.allocate(4);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.put(0, (byte) 2);
            allocate.put(1, (byte) 11);
            allocate.put(2, (byte) 1);
            allocate.put(3, hb.m15166e(this.mO));
        } else {
            allocate = ByteBuffer.allocate(5);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.put(0, (byte) 2);
            allocate.put(1, (byte) 11);
            allocate.put(2, (byte) 2);
            allocate.put(3, hb.m15166e(this.mO));
            allocate.put(4, hb.m15166e(this.mP));
        }
        this.mRequestData = allocate.array();
    }

    public JSONObject getRequestDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("animation", this.mO);
            jSONObject.put("numOfRepeats", this.mP);
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public void onRequestSent(int i) {
        this.mIsCompleted = true;
    }

    public Event getEventID() {
        return Event.PLAY_BUTTON_EVENT_ANIMATION;
    }
}
