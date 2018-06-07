package com.misfit.ble.obfuscated;

import com.misfit.ble.setting.sam.HandSettings;
import com.misfit.ble.setting.sam.SAMEnum$HandMovingType;
import com.misfit.ble.shine.error.ShineError.Event;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class gs extends ew {
    private List<HandSettings> nM;
    private SAMEnum$HandMovingType nN;

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
        return (byte) 3;
    }

    public String getRequestName() {
        return "setMovingHands";
    }

    public void m15140a(SAMEnum$HandMovingType sAMEnum$HandMovingType, List<HandSettings> list) {
        this.nN = sAMEnum$HandMovingType;
        this.nM = list;
        byte size = (byte) list.size();
        ByteBuffer allocate = ByteBuffer.allocate((size * 5) + 5);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(cb());
        allocate.put(bZ());
        allocate.put(cc());
        allocate.put(sAMEnum$HandMovingType.getId());
        allocate.put(size);
        for (HandSettings handSettings : list) {
            r3 = new byte[5];
            byte[] l = hb.m15171l(handSettings.getDegrees());
            r3[1] = l[0];
            r3[2] = l[1];
            r3[3] = handSettings.getDirection().getId();
            r3[4] = handSettings.getSpeed().getId();
            allocate.put(r3);
        }
        this.mRequestData = allocate.array();
    }

    public JSONObject getRequestDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("movingType", this.nN);
            JSONArray jSONArray = new JSONArray();
            for (HandSettings toJSON : this.nM) {
                jSONArray.put(toJSON.toJSON());
            }
            jSONObject.put("hands", jSONArray);
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public void onRequestSent(int i) {
        this.mIsCompleted = true;
    }

    public Event getEventID() {
        return Event.SET_MOVING_HANDS;
    }
}
