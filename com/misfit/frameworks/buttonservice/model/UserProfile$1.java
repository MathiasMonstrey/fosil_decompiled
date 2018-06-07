package com.misfit.frameworks.buttonservice.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class UserProfile$1 implements Creator<UserProfile> {
    UserProfile$1() {
    }

    public UserProfile createFromParcel(Parcel parcel) {
        return new UserProfile(parcel.readInt(), parcel.readLong(), parcel.readFloat(), parcel.readFloat(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readByte() != (byte) 0, parcel.readInt(), parcel.readLong());
    }

    public UserProfile[] newArray(int i) {
        return new UserProfile[i];
    }
}
