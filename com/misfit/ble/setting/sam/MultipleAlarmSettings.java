package com.misfit.ble.setting.sam;

import com.misfit.ble.obfuscated.C4462b;
import com.misfit.frameworks.buttonservice.model.Alarm;
import org.json.JSONObject;

public class MultipleAlarmSettings {
    public static final byte FRIDAY = (byte) 32;
    public static final byte MONDAY = (byte) 2;
    public static final byte SATURDAY = (byte) 64;
    public static final byte SUNDAY = (byte) 1;
    public static final byte THURSDAY = (byte) 16;
    public static final byte TUESDAY = (byte) 4;
    public static final byte WEDNESDAY = (byte) 8;
    private byte aF;
    private byte bq;
    private byte br;
    private boolean bs;

    public MultipleAlarmSettings(byte b, boolean z, byte b2, byte b3) {
        this.bq = b2;
        this.br = b3;
        this.aF = b;
        this.bs = z;
    }

    public byte getAlarmHour() {
        return this.bq;
    }

    public byte getAlarmMinute() {
        return this.br;
    }

    public byte getAlarmDay() {
        return this.aF;
    }

    public boolean isAlarmRepeat() {
        return this.bs;
    }

    public String toString() {
        return "MultipleAlarmSettings{alarmHour=" + this.bq + ", alarmMinute=" + this.br + ", alarmDay=" + this.aF + ", alarmRepeat=" + this.bs + '}';
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("alarmHour", this.bq);
            jSONObject.put(Alarm.COLUMN_ALARM_MINUTE, this.br);
            jSONObject.put("alarmDay", this.aF);
            jSONObject.put("alarmRepeat", this.bs);
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }
}
