package com.misfit.ble.obfuscated;

import com.misfit.ble.setting.pluto.PlutoSequence.LED;
import com.misfit.ble.shine.error.ShineError.Event;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class er extends ew {
    private short mP;
    private LED mQ;
    private int mR;

    public String getRequestName() {
        return "playLEDAnimation";
    }

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    private byte cb() {
        return (byte) 2;
    }

    public byte bZ() {
        return (byte) -15;
    }

    public byte cc() {
        return (byte) 18;
    }

    public void m15074a(LED led, short s, int i) {
        this.mQ = led;
        this.mP = s;
        this.mR = i;
        ByteBuffer allocate = ByteBuffer.allocate(7);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, cb());
        allocate.put(1, bZ());
        allocate.put(2, cc());
        allocate.put(3, hb.m15166e(this.mQ.getValue()));
        allocate.put(4, hb.m15166e(this.mP));
        byte[] l = hb.m15171l(this.mR);
        allocate.put(5, l[0]);
        allocate.put(6, l[1]);
        this.mRequestData = allocate.array();
    }

    public JSONObject getRequestDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("animationID", this.mQ.getValue());
            jSONObject.put("numOfRepeats", this.mP);
            jSONObject.put("millisecondsBetweenRepeats", this.mR);
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public void onRequestSent(int i) {
        this.mIsCompleted = true;
    }

    public Event getEventID() {
        return Event.PLAY_LED;
    }
}
