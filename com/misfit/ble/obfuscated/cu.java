package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public abstract class cu extends ew {
    private short f1537if;

    protected abstract byte ch();

    public String getRequestName() {
        return "fileAbort";
    }

    public void m15022c(short s) {
        this.f1537if = s;
        byte ch = ch();
        ByteBuffer allocate = ByteBuffer.allocate(3);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, ch);
        allocate.putShort(1, s);
        this.mRequestData = allocate.array();
    }

    public void onRequestSent(int i) {
        this.mIsCompleted = true;
    }

    public JSONObject getRequestDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fileHandle", hb.m15164d(this.f1537if));
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public Event getEventID() {
        return Event.FILE_ABORT;
    }
}
