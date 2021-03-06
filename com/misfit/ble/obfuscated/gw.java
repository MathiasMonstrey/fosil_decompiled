package com.misfit.ble.obfuscated;

import com.misfit.ble.setting.flashlink.EventMappingEnum.StopWatchSecondHand;
import com.misfit.ble.shine.error.ShineError.Event;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class gw extends ew {
    private StopWatchSecondHand nS;

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    private byte cb() {
        return (byte) 2;
    }

    public byte bZ() {
        return (byte) 7;
    }

    public byte cc() {
        return (byte) 16;
    }

    public String getRequestName() {
        return "setStopWatchSetting";
    }

    public void m15144a(StopWatchSecondHand stopWatchSecondHand) {
        this.nS = stopWatchSecondHand;
        ByteBuffer allocate = ByteBuffer.allocate(6);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, cb());
        allocate.put(1, bZ());
        allocate.put(2, cc());
        allocate.put(3, (byte) 9);
        allocate.put(4, (byte) 0);
        allocate.put(5, this.nS.getId());
        this.mRequestData = allocate.array();
    }

    public JSONObject getRequestDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stopWatchHand", this.nS);
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public void onRequestSent(int i) {
        this.mIsCompleted = true;
    }

    public Event getEventID() {
        return Event.SET_STOP_WATCH_SETTING;
    }
}
