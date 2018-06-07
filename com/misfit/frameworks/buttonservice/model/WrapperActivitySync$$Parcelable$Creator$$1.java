package com.misfit.frameworks.buttonservice.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import org.parceler.IdentityCollection;

public final class WrapperActivitySync$$Parcelable$Creator$$1 implements Creator<WrapperActivitySync$$Parcelable> {
    public WrapperActivitySync$$Parcelable createFromParcel(Parcel parcel) {
        return new WrapperActivitySync$$Parcelable(WrapperActivitySync$$Parcelable.read(parcel, new IdentityCollection()));
    }

    public WrapperActivitySync$$Parcelable[] newArray(int i) {
        return new WrapperActivitySync$$Parcelable[i];
    }
}
