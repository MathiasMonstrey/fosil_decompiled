package com.misfit.frameworks.buttonservice.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class UserProfile implements Parcelable {
    public static final Creator<UserProfile> CREATOR = new 1();
    public long age;
    public int currentSteps;
    public int displayUnit;
    public int gender;
    public int goalSteps;
    public float height;
    public boolean isNewDevice;
    public long syncId;
    public int syncMode;
    public float weight;

    public UserProfile(int i, long j, float f, float f2, int i2, int i3, int i4, boolean z, int i5, long j2) {
        this.displayUnit = i;
        this.age = j;
        this.height = f;
        this.weight = f2;
        this.gender = i2;
        this.goalSteps = i3;
        this.currentSteps = i4;
        this.isNewDevice = z;
        this.syncMode = i5;
        this.syncId = j2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.displayUnit);
        parcel.writeLong(this.age);
        parcel.writeFloat(this.height);
        parcel.writeFloat(this.weight);
        parcel.writeInt(this.gender);
        parcel.writeInt(this.goalSteps);
        parcel.writeInt(this.currentSteps);
        parcel.writeByte((byte) (this.isNewDevice ? 1 : 0));
        parcel.writeInt(this.syncMode);
        parcel.writeLong(this.syncId);
    }
}
