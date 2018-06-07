package com.misfit.ble.obfuscated;

import com.misfit.ble.setting.pluto.AlarmSettings;
import com.misfit.ble.shine.error.ShineError.Event;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class fg extends ew {
    private AlarmSettings na;

    public String getRequestName() {
        return "setAlarmParameters";
    }

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
        return (byte) 14;
    }

    public byte ce() {
        return (byte) 5;
    }

    public void m15090a(AlarmSettings alarmSettings) {
        this.na = alarmSettings;
        ByteBuffer allocate = ByteBuffer.allocate(10);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, cb());
        allocate.put(1, bZ());
        allocate.put(2, cc());
        allocate.put(3, ce());
        allocate.put(4, hb.m15166e(this.na.getWindowInMinute()));
        allocate.put(5, hb.m15166e(this.na.getLEDSequence().getValue()));
        allocate.put(6, hb.m15166e(this.na.getVibeSequence().getValue()));
        allocate.put(7, hb.m15166e(this.na.getSoundSequence().getValue()));
        allocate.put(8, hb.m15166e(this.na.getSnoozeTimeInMinute()));
        allocate.put(9, hb.m15166e(this.na.getAlarmDuration()));
        this.mRequestData = allocate.array();
    }

    public JSONObject getRequestDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("windowInMinute", this.na.getWindowInMinute());
            jSONObject.put("ledSequence", this.na.getLEDSequence().getValue());
            jSONObject.put("vibeSequence", this.na.getVibeSequence().getValue());
            jSONObject.put("soundSequence", this.na.getSoundSequence().getValue());
            jSONObject.put("snoozeTimeInMinute", this.na.getSnoozeTimeInMinute());
            jSONObject.put("alarmDurationMinutes", this.na.getAlarmDuration());
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public void onRequestSent(int i) {
        this.mIsCompleted = true;
    }

    public Event getEventID() {
        return Event.SET_ALARM_PARAMETERS;
    }
}
