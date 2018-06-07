package com.misfit.ble.obfuscated;

import com.misfit.ble.setting.eventmapping.EventMapping;
import com.misfit.ble.shine.error.ShineError.Event;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class fn extends ew {
    private List<EventMapping> nf;

    public String getRequestName() {
        return "setEventMappings";
    }

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    public byte bZ() {
        return (byte) 11;
    }

    private byte cb() {
        return (byte) 2;
    }

    public void m15097a(List<EventMapping> list, int i) {
        this.nf = list;
        ByteBuffer allocate = ByteBuffer.allocate(i + 2);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(cb());
        allocate.put(bZ());
        for (EventMapping payload : list) {
            allocate.put(payload.payload());
        }
        this.mRequestData = allocate.array();
    }

    public JSONObject getRequestDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            for (EventMapping eventMapping : this.nf) {
                jSONArray.put(eventMapping.toString());
            }
            jSONObject.put("eventMappings", jSONArray);
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public void onRequestSent(int i) {
        this.mIsCompleted = true;
    }

    public Event getEventID() {
        return Event.SET_EVENT_MAPPING;
    }
}
