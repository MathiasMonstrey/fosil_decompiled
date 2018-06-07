package com.misfit.frameworks.buttonservice.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import org.parceler.IdentityCollection;

public final class OtaEvent$$Parcelable$Creator$$0 implements Creator<OtaEvent$$Parcelable> {
    public OtaEvent$$Parcelable createFromParcel(Parcel parcel) {
        return new OtaEvent$$Parcelable(OtaEvent$$Parcelable.read(parcel, new IdentityCollection()));
    }

    public OtaEvent$$Parcelable[] newArray(int i) {
        return new OtaEvent$$Parcelable[i];
    }
}
