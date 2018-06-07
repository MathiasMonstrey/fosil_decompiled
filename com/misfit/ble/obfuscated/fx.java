package com.misfit.ble.obfuscated;

import com.misfit.ble.setting.pluto.AlarmSettings;
import com.misfit.ble.shine.error.ShineError.Event;
import com.misfit.frameworks.buttonservice.model.Alarm;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public class fx extends ew {
    private AlarmSettings na;

    public String getRequestName() {
        return "setSingleAlarmTime";
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
        return (byte) 2;
    }

    public void m15107a(AlarmSettings alarmSettings) {
        this.na = alarmSettings;
        ByteBuffer allocate = ByteBuffer.allocate(9);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, cb());
        allocate.put(1, bZ());
        allocate.put(2, cc());
        allocate.put(3, ce());
        allocate.put(4, this.na.getAlarmDay());
        allocate.put(5, this.na.getAlarmOperation());
        allocate.put(6, this.na.getAlarmType());
        allocate.put(7, hb.m15166e(this.na.getAlarmHour()));
        allocate.put(8, hb.m15166e(this.na.getAlarmMinute()));
        this.mRequestData = allocate.array();
    }

    public JSONObject getRequestDescriptionJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("alarmDay", this.na.getAlarmDay());
            jSONObject.put("alarmOperation", this.na.getAlarmOperation());
            jSONObject.put("alarmType", this.na.getAlarmType());
            jSONObject.put("alarmHour", this.na.getAlarmHour());
            jSONObject.put(Alarm.COLUMN_ALARM_MINUTE, this.na.getAlarmMinute());
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    public void onRequestSent(int i) {
        this.mIsCompleted = true;
    }

    public Event getEventID() {
        return Event.SETUP_SINGLE_ALARM;
    }
}
