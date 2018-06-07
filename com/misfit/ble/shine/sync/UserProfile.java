package com.misfit.ble.shine.sync;

import com.misfit.ble.shine.sync.result.UserProfileShine;

public class UserProfile {
    public static final int GENDER_FEMALE = 1;
    public static final int GENDER_MALE = 0;
    private UserProfileShine f1602p;

    public UserProfile(long j, float f, float f2, int i) {
        this.f1602p = new UserProfileShine(j, f, f2, i);
    }

    public long getAge() {
        return this.f1602p.age;
    }

    public float getHeightInMeter() {
        return this.f1602p.heightInMeter;
    }

    public float getWeightInKg() {
        return this.f1602p.weightInKg;
    }

    public int getGender() {
        return this.f1602p.gender;
    }

    public UserProfileShine convertToJNIProperty() {
        return this.f1602p;
    }
}
