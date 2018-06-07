package com.misfit.frameworks.buttonservice.model;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

@Parcel
public class OtaEvent {
    protected float process;
    protected String serial;

    @ParcelConstructor
    public OtaEvent(String str, float f) {
        this.serial = str;
        this.process = f;
    }

    public String getSerial() {
        return this.serial;
    }

    public void setSerial(String str) {
        this.serial = str;
    }

    public float getProcess() {
        return this.process;
    }

    public void setProcess(float f) {
        this.process = f;
    }

    public String toString() {
        return this.serial + " ota at process " + this.process;
    }
}
