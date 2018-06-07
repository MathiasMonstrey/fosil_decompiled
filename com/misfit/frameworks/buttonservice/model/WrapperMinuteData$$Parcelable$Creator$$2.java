package com.misfit.frameworks.buttonservice.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import org.parceler.IdentityCollection;

public final class WrapperMinuteData$$Parcelable$Creator$$2 implements Creator<WrapperMinuteData$$Parcelable> {
    public WrapperMinuteData$$Parcelable createFromParcel(Parcel parcel) {
        return new WrapperMinuteData$$Parcelable(WrapperMinuteData$$Parcelable.read(parcel, new IdentityCollection()));
    }

    public WrapperMinuteData$$Parcelable[] newArray(int i) {
        return new WrapperMinuteData$$Parcelable[i];
    }
}
