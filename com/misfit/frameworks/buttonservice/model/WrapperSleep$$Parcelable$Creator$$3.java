package com.misfit.frameworks.buttonservice.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import org.parceler.IdentityCollection;

public final class WrapperSleep$$Parcelable$Creator$$3 implements Creator<WrapperSleep$$Parcelable> {
    public WrapperSleep$$Parcelable createFromParcel(Parcel parcel) {
        return new WrapperSleep$$Parcelable(WrapperSleep$$Parcelable.read(parcel, new IdentityCollection()));
    }

    public WrapperSleep$$Parcelable[] newArray(int i) {
        return new WrapperSleep$$Parcelable[i];
    }
}
