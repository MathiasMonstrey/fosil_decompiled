package com.misfit.ble.setting.pluto;

import com.misfit.ble.setting.pluto.PlutoSequence.LED;
import com.misfit.ble.setting.pluto.PlutoSequence.Sound;
import com.misfit.ble.setting.pluto.PlutoSequence.Vibe;

public class AlarmSettings {
    public static final byte ALL_DAYS = Byte.MIN_VALUE;
    public static final byte CLEAR_ALARM = (byte) 2;
    public static final byte FRIDAY = (byte) 16;
    public static final byte MONDAY = (byte) 1;
    public static final byte NON_SET_ALARM_DAY = (byte) 0;
    public static final byte ONE_SHOT = (byte) 1;
    public static final byte REPEATED = (byte) 2;
    public static final byte SATURDAY = (byte) 32;
    public static final byte SET_ALARM = (byte) 1;
    public static final byte SUNDAY = (byte) 64;
    public static final byte THURSDAY = (byte) 8;
    public static final byte TOGGLE_ALARM = (byte) 3;
    public static final byte TUESDAY = (byte) 2;
    public static final byte WEDNESDAY = (byte) 4;
    private byte aF = (byte) 0;
    private byte aG;
    private byte aH;
    private short aI;
    private short aJ;
    private LED aK;
    private Vibe aL;
    private Sound aM;
    private short aN;
    private short aO;
    private short aP;

    public AlarmSettings(byte b, byte b2, byte b3, short s, short s2, short s3, LED led, Vibe vibe, Sound sound, short s4, short s5) {
        this.aF = b;
        this.aG = b2;
        this.aH = b3;
        this.aI = s;
        this.aJ = s2;
        this.aN = s3;
        this.aK = led;
        this.aL = vibe;
        this.aM = sound;
        this.aO = s4;
        this.aP = s5;
    }

    public byte getAlarmDay() {
        return this.aF;
    }

    public void setAlarmDay(byte b) {
        this.aF = b;
    }

    public byte getAlarmOperation() {
        return this.aG;
    }

    public void setAlarmOperation(byte b) {
        this.aG = b;
    }

    public byte getAlarmType() {
        return this.aH;
    }

    public void setAlarmType(byte b) {
        this.aH = b;
    }

    public short getAlarmHour() {
        return this.aI;
    }

    public void setAlarmHour(short s) {
        this.aI = s;
    }

    public short getAlarmMinute() {
        return this.aJ;
    }

    public void setAlarmMinute(short s) {
        this.aJ = s;
    }

    public short getWindowInMinute() {
        return this.aN;
    }

    public void setWindowInMinute(short s) {
        this.aN = s;
    }

    public short getSnoozeTimeInMinute() {
        return this.aO;
    }

    public void setSnoozeTimeInMinute(short s) {
        this.aO = s;
    }

    public short getAlarmDuration() {
        return this.aP;
    }

    public void setAlarmDuration(short s) {
        this.aP = s;
    }

    public LED getLEDSequence() {
        return this.aK;
    }

    public void setLEDSequence(LED led) {
        this.aK = led;
    }

    public Vibe getVibeSequence() {
        return this.aL;
    }

    public void setVibeSequence(Vibe vibe) {
        this.aL = vibe;
    }

    public Sound getSoundSequence() {
        return this.aM;
    }

    public void setSoundSequence(Sound sound) {
        this.aM = sound;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.aF);
        stringBuilder.append(",");
        stringBuilder.append(this.aG);
        stringBuilder.append(",");
        stringBuilder.append(this.aH);
        stringBuilder.append(",");
        stringBuilder.append(this.aI);
        stringBuilder.append(",");
        stringBuilder.append(this.aJ);
        stringBuilder.append(",");
        stringBuilder.append(this.aN);
        stringBuilder.append(",");
        stringBuilder.append(this.aK.getValue());
        stringBuilder.append(",");
        stringBuilder.append(this.aL.getValue());
        stringBuilder.append(",");
        stringBuilder.append(this.aM.getValue());
        stringBuilder.append(",");
        stringBuilder.append(this.aO);
        stringBuilder.append(",");
        stringBuilder.append(this.aP);
        return stringBuilder.toString();
    }

    public boolean isDefaultValue() {
        return this.aF == ALL_DAYS && this.aG == (byte) 0 && this.aH == (byte) 0 && this.aI == (short) 0 && this.aJ == (short) 0 && this.aN == (short) 20 && this.aK.getValue() == (short) 0 && this.aL.getValue() == (short) 3 && this.aM.getValue() == (short) 0 && this.aO == (short) 8 && this.aP == (short) 60;
    }
}
