package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class fw extends ew {
    private byte[] nk;

    public String getRequestName() {
        return "setPassCode";
    }

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    private byte cb() {
        return (byte) 2;
    }

    public byte bZ() {
        return (byte) 13;
    }

    public byte cc() {
        return (byte) 7;
    }

    public byte ce() {
        return (byte) 2;
    }

    public void m15106y(byte[] bArr) {
        int i = 0;
        this.nk = bArr;
        byte cb = cb();
        byte bZ = bZ();
        byte cc = cc();
        byte ce = ce();
        ByteBuffer allocate = ByteBuffer.allocate(20);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, cb);
        allocate.put(1, bZ);
        allocate.put(2, cc);
        allocate.put(3, ce);
        while (i < 16) {
            allocate.put(i + 4, bArr[i]);
            i++;
        }
        this.mRequestData = allocate.array();
    }

    public JSONObject getRequestDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("passCode", hb.m15159E(this.nk));
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public void onRequestSent(int i) {
        this.mIsCompleted = true;
    }

    public Event getEventID() {
        return Event.BOLT_SET_PASSCODE;
    }
}
