package com.misfit.ble.setting.pluto;

import com.misfit.ble.setting.pluto.PlutoSequence.LED;
import com.misfit.ble.setting.pluto.PlutoSequence.Sound;
import com.misfit.ble.setting.pluto.PlutoSequence.Vibe;

public class NotificationsSettings {
    private short aR;
    private short aS;
    private short aT;
    private short aU;
    private LED aW;
    private Vibe aX;
    private Sound aY;
    private LED aZ;
    private Vibe ba;
    private Sound bb;

    public NotificationsSettings(LED led, Vibe vibe, Sound sound, LED led2, Vibe vibe2, Sound sound2, short s, short s2, short s3, short s4) {
        this.aW = led;
        this.aX = vibe;
        this.aY = sound;
        this.aZ = led2;
        this.ba = vibe2;
        this.bb = sound2;
        this.aR = s;
        this.aS = s2;
        this.aT = s3;
        this.aU = s4;
    }

    public LED getCallLEDSequence() {
        return this.aW;
    }

    public Vibe getCallVibeSequence() {
        return this.aX;
    }

    public Sound getCallSoundSequence() {
        return this.aY;
    }

    public LED getTextLEDSequence() {
        return this.aZ;
    }

    public Vibe getTextVibeSequence() {
        return this.ba;
    }

    public Sound getTextSoundSequence() {
        return this.bb;
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

    public void setCallLEDSequence(LED led) {
        this.aW = led;
    }

    public void setCallVibeSequence(Vibe vibe) {
        this.aX = vibe;
    }

    public void setCallSoundSequence(Sound sound) {
        this.aY = sound;
    }

    public void setTextLEDSequence(LED led) {
        this.aZ = led;
    }

    public void setTextVibeSequence(Vibe vibe) {
        this.ba = vibe;
    }

    public void setTextSoundSequence(Sound sound) {
        this.bb = sound;
    }

    public void setStartHour(short s) {
        this.aR = s;
    }

    public void setStartMinute(short s) {
        this.aS = s;
    }

    public void setEndHour(short s) {
        this.aT = s;
    }

    public void setEndMinute(short s) {
        this.aU = s;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.aW.getValue());
        stringBuilder.append(",");
        stringBuilder.append(this.aX.getValue());
        stringBuilder.append(",");
        stringBuilder.append(this.aY.getValue());
        stringBuilder.append(",");
        stringBuilder.append(this.aZ.getValue());
        stringBuilder.append(",");
        stringBuilder.append(this.ba.getValue());
        stringBuilder.append(",");
        stringBuilder.append(this.bb.getValue());
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
