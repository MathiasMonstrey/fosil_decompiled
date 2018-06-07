package com.misfit.frameworks.buttonservice.model.animation;

import com.misfit.ble.setting.qmotion.QMotionEnum.LEDColor;

public class LightVibrationSetting {
    private LEDColor color;
    private int interval;
    private boolean isLong;
    private short numRepeat;
    private int restTime;

    public LightVibrationSetting(short s, int i, LEDColor lEDColor, boolean z, int i2) {
        this.numRepeat = s;
        this.interval = i;
        this.color = lEDColor;
        this.isLong = z;
        this.restTime = i2;
    }

    public short getNumRepeat() {
        return this.numRepeat;
    }

    public void setNumRepeat(short s) {
        this.numRepeat = s;
    }

    public int getInterval() {
        return this.interval;
    }

    public void setInterval(int i) {
        this.interval = i;
    }

    public LEDColor getColor() {
        return this.color;
    }

    public void setColor(LEDColor lEDColor) {
        this.color = lEDColor;
    }

    public boolean isLong() {
        return this.isLong;
    }

    public void setIsLong(boolean z) {
        this.isLong = z;
    }
}
