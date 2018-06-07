package com.misfit.ble.obfuscated;

import com.misfit.ble.setting.sam.CountdownSettings;
import com.misfit.ble.shine.error.ShineError.Event;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class gq extends ew {
    private CountdownSettings mCountdownSettings;

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    private byte cb() {
        return (byte) 2;
    }

    public byte bZ() {
        return (byte) 19;
    }

    public byte cc() {
        return (byte) 1;
    }

    public String getRequestName() {
        return "setCountDownSettings";
    }

    public void m15137a(CountdownSettings countdownSettings) {
        this.mCountdownSettings = countdownSettings;
        ByteBuffer allocate = ByteBuffer.allocate(13);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, cb());
        allocate.put(1, bZ());
        allocate.put(2, cc());
        allocate.putInt(3, hb.m15168g(countdownSettings.getStartTimeInUTCSeconds()));
        allocate.putInt(7, hb.m15168g(countdownSettings.getEndTimeInUTCSeconds()));
        allocate.putShort(11, countdownSettings.getTimezoneOffset());
        this.mRequestData = allocate.array();
    }

    public JSONObject getRequestDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("startTimeInUTCSecond", this.mCountdownSettings.getStartTimeInUTCSeconds());
            jSONObject.put("endTimeInUTCSecond", this.mCountdownSettings.getEndTimeInUTCSeconds());
            jSONObject.put("timezoneOffset", this.mCountdownSettings.getTimezoneOffset());
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public void onRequestSent(int i) {
        this.mIsCompleted = true;
    }

    public Event getEventID() {
        return Event.SET_COUNTDOWN_SETTINGS;
    }
}
