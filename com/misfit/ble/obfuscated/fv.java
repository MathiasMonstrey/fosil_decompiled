package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class fv extends ew {
    private int mNumberOfMappedEventPackets;

    public String getRequestName() {
        return "setNumberOfMappedEventPackets";
    }

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    public void m15105i(int i) {
        this.mNumberOfMappedEventPackets = i;
        ByteBuffer allocate = ByteBuffer.allocate(5);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, (byte) 2);
        allocate.put(1, (byte) 12);
        allocate.put(2, (byte) -32);
        allocate.putShort(3, hb.m15170k(this.mNumberOfMappedEventPackets));
        this.mRequestData = allocate.array();
    }

    public JSONObject getRequestDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("numberOfMappedEventPackets", this.mNumberOfMappedEventPackets);
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public void onRequestSent(int i) {
        this.mIsCompleted = true;
    }

    public Event getEventID() {
        return Event.SET_FILE_STREAMING_NUMBER_OF_PACKET_EVENTS;
    }
}
