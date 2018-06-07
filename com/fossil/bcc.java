package com.fossil;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.iid.MessengerCompat;

public final class bcc implements Creator<MessengerCompat> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        IBinder readStrongBinder = parcel.readStrongBinder();
        return readStrongBinder != null ? new MessengerCompat(readStrongBinder) : null;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new MessengerCompat[i];
    }
}
