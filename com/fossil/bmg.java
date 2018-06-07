package com.fossil;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class bmg extends buj implements bme {
    bmg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.internal.IFusedLocationProviderCallback");
    }

    public final void mo1394a(bmb com_fossil_bmb) throws RemoteException {
        Parcel SH = SH();
        bul.m5687a(SH, (Parcelable) com_fossil_bmb);
        m4422c(1, SH);
    }
}
