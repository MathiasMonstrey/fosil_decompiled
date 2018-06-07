package com.misfit.frameworks.buttonservice.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import org.parceler.IdentityCollection;

public final class WrapperTapEventSummary$$Parcelable$Creator$$6 implements Creator<WrapperTapEventSummary$$Parcelable> {
    public WrapperTapEventSummary$$Parcelable createFromParcel(Parcel parcel) {
        return new WrapperTapEventSummary$$Parcelable(WrapperTapEventSummary$$Parcelable.read(parcel, new IdentityCollection()));
    }

    public WrapperTapEventSummary$$Parcelable[] newArray(int i) {
        return new WrapperTapEventSummary$$Parcelable[i];
    }
}
