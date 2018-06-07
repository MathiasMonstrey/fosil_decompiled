package com.misfit.frameworks.buttonservice.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import org.parceler.IdentityCollection;

public final class WrapperSyncResult$$Parcelable$Creator$$5 implements Creator<WrapperSyncResult$$Parcelable> {
    public WrapperSyncResult$$Parcelable createFromParcel(Parcel parcel) {
        return new WrapperSyncResult$$Parcelable(WrapperSyncResult$$Parcelable.read(parcel, new IdentityCollection()));
    }

    public WrapperSyncResult$$Parcelable[] newArray(int i) {
        return new WrapperSyncResult$$Parcelable[i];
    }
}
