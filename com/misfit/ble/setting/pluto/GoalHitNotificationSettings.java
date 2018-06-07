package com.misfit.ble.setting.pluto;

import com.misfit.ble.setting.pluto.PlutoSequence.LED;
import com.misfit.ble.setting.pluto.PlutoSequence.Sound;
import com.misfit.ble.setting.pluto.PlutoSequence.Vibe;

public class GoalHitNotificationSettings {
    private LED aK;
    private Vibe aL;
    private Sound aM;
    private boolean aQ;
    private short aR;
    private short aS;
    private short aT;
    private short aU;

    public GoalHitNotificationSettings(boolean z, LED led, Vibe vibe, Sound sound, short s, short s2, short s3, short s4) {
        this.aQ = z;
        this.aK = led;
        this.aL = vibe;
        this.aM = sound;
        this.aR = s;
        this.aS = s2;
        this.aT = s3;
        this.aU = s4;
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
        return stringBuilder.toString();
    }
}
