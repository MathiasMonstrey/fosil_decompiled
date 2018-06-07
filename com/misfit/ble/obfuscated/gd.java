package com.misfit.ble.obfuscated;

import com.misfit.ble.setting.flashlink.EventMappingEnum.MemEventNumber;
import com.misfit.ble.shine.error.ShineError.Event;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class gd extends ew {
    private MemEventNumber aq;

    public String getRequestName() {
        return "unmapButtonEvent";
    }

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    public void m15129b(MemEventNumber memEventNumber) {
        this.aq = memEventNumber;
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, (byte) 2);
        allocate.put(1, (byte) 11);
        allocate.put(2, (byte) 49);
        allocate.put(3, memEventNumber.getId());
        this.mRequestData = allocate.array();
    }

    public JSONObject getRequestDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("eventMember", this.aq);
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public void onRequestSent(int i) {
        this.mIsCompleted = true;
    }

    public Event getEventID() {
        return Event.UNMAP_EVENT_MAPPING;
    }
}
