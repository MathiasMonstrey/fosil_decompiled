package com.misfit.frameworks.buttonservice.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import org.parceler.IdentityCollection;

public final class WrapperSleepStateChange$$Parcelable$Creator$$4 implements Creator<WrapperSleepStateChange$$Parcelable> {
    public WrapperSleepStateChange$$Parcelable createFromParcel(Parcel parcel) {
        return new WrapperSleepStateChange$$Parcelable(WrapperSleepStateChange$$Parcelable.read(parcel, new IdentityCollection()));
    }

    public WrapperSleepStateChange$$Parcelable[] newArray(int i) {
        return new WrapperSleepStateChange$$Parcelable[i];
    }
}
