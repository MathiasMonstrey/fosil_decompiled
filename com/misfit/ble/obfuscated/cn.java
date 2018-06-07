package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.frameworks.common.constants.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class cn extends ew {
    private short kO;

    public String getRequestName() {
        return "addGroupID";
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

    public byte cd() {
        return (byte) 1;
    }

    public void m15019c(short s) {
        this.kO = s;
        byte cb = cb();
        byte bZ = bZ();
        byte cc = cc();
        byte cd = cd();
        ByteBuffer allocate = ByteBuffer.allocate(5);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, cb);
        allocate.put(1, bZ);
        allocate.put(2, cc);
        allocate.put(3, cd);
        allocate.put(4, hb.m15166e(s));
        this.mRequestData = allocate.array();
    }

    public JSONObject getRequestDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constants.GROUP_ID, this.kO);
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public void onRequestSent(int i) {
        this.mIsCompleted = true;
    }

    public Event getEventID() {
        return Event.BOLT_ADD_GROUP_ID;
    }
}
