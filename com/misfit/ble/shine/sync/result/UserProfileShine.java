package com.misfit.ble.shine.sync.result;

public class UserProfileShine {
    public long age;
    public int gender;
    public float heightInMeter;
    public float weightInKg;

    public UserProfileShine(long j, float f, float f2, int i) {
        this.age = j;
        this.heightInMeter = f;
        this.weightInKg = f2;
        this.gender = i;
    }
}
