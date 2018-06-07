package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.gcm.PendingCallback;

public final class bbw implements Creator<PendingCallback> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new PendingCallback(parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new PendingCallback[i];
    }
}
