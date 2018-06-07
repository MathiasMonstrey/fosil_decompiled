package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class gu extends ew {
    private byte nP;
    private boolean nQ;
    private boolean nR;

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    private byte cb() {
        return (byte) 2;
    }

    public byte bZ() {
        return (byte) 21;
    }

    public byte cc() {
        return (byte) 1;
    }

    public String getRequestName() {
        return "setRequestHandsControl";
    }

    public void m15142a(byte b, boolean z, boolean z2) {
        this.nP = b;
        this.nQ = z;
        this.nR = z2;
        ByteBuffer allocate = ByteBuffer.allocate(6);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, cb());
        allocate.put(1, bZ());
        allocate.put(2, cc());
        allocate.put(3, b);
        allocate.put(4, hb.m15167f(z));
        allocate.put(5, hb.m15167f(z2));
        this.mRequestData = allocate.array();
    }

    public JSONObject getRequestDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("priority", this.nP);
            jSONObject.put("enableResponseMessageWhenMoveIsComplete", this.nQ);
            jSONObject.put("enableResponseMessageWhenControlIsLost", this.nR);
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public void onRequestSent(int i) {
        this.mIsCompleted = true;
    }

    public Event getEventID() {
        return Event.SET_REQUEST_HANDS_CONTROL;
    }
}
