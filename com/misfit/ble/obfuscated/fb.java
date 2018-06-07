package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import org.json.JSONObject;

public class fb extends ew {
    private String eK;

    public String getRequestName() {
        return "serialNumberChangeAndLock";
    }

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    public boolean m15086F(String str) {
        this.eK = str;
        if (str == null || str.length() != 10) {
            return false;
        }
        Object bytes = str.getBytes(Charset.forName("UTF-8"));
        if (bytes == null || bytes.length != 10) {
            return false;
        }
        Object obj = new byte[11];
        System.arraycopy(bytes, 0, obj, 0, bytes.length);
        obj[10] = null;
        ByteBuffer allocate = ByteBuffer.allocate(15);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, (byte) 2);
        allocate.put(1, (byte) 7);
        allocate.put(2, (byte) 7);
        allocate.put(3, (byte) -86);
        allocate.position(4);
        allocate.put(obj, 0, obj.length);
        this.mRequestData = allocate.array();
        return true;
    }

    public JSONObject getRequestDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("serialNumber", this.eK);
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public void onRequestSent(int i) {
        this.mIsCompleted = true;
    }

    public Event getEventID() {
        return Event.SERIAL_NUMBER_CHANGE_AND_LOCK;
    }
}
