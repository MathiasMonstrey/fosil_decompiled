package com.misfit.ble.setting.pluto;

import com.misfit.ble.setting.pluto.PlutoSequence.LED;
import com.misfit.ble.setting.pluto.PlutoSequence.Sound;
import com.misfit.ble.setting.pluto.PlutoSequence.Vibe;

public class InactivityNudgeSettings {
    private LED aK;
    private Vibe aL;
    private Sound aM;
    private boolean aQ = false;
    private short aR;
    private short aS;
    private short aT = (short) 0;
    private short aU = (short) 0;
    private short aV = (short) 0;

    public InactivityNudgeSettings(boolean z, LED led, Vibe vibe, Sound sound, short s, short s2, short s3, short s4, short s5) {
        this.aQ = z;
        this.aK = led;
        this.aL = vibe;
        this.aM = sound;
        this.aR = s;
        this.aS = s2;
        this.aT = s3;
        this.aU = s4;
        this.aV = s5;
    }

    public boolean getEnabled() {
        return this.aQ;
    }

    public LED getLEDSequence() {
        return this.aK;
    }

    public Vibe getVibeSequence() {
        return this.aL;
    }

    public Sound getSoundSequence() {
        return this.aM;
    }

    public short getStartHour() {
        return this.aR;
    }

    public short getStartMinute() {
        return this.aS;
    }

    public short getEndHour() {
        return this.aT;
    }

    public short getEndMinute() {
        return this.aU;
    }

    public short getRepeatIntervalInMinute() {
        return this.aV;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.aQ);
        stringBuilder.append(",");
        stringBuilder.append(this.aK.getValue());
        stringBuilder.append(",");
        stringBuilder.append(this.aL.getValue());
        stringBuilder.append(",");
        stringBuilder.append(this.aM.getValue());
        stringBuilder.append(",");
        stringBuilder.append(this.aR);
        stringBuilder.append(",");
        stringBuilder.append(this.aS);
        stringBuilder.append(",");
        stringBuilder.append(this.aT);
        stringBuilder.append(",");
        stringBuilder.append(this.aU);
        stringBuilder.append(",");
        stringBuilder.append(this.aV);
        return stringBuilder.toString();
    }
}
