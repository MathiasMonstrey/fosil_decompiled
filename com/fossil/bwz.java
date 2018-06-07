package com.fossil;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;

public final class bwz extends buj implements bwx {
    bwz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.ILocationCallback");
    }

    public final void mo1398a(LocationAvailability locationAvailability) throws RemoteException {
        Parcel SH = SH();
        bul.m5687a(SH, (Parcelable) locationAvailability);
        m4422c(2, SH);
    }

    public final void mo1399a(LocationResult locationResult) throws RemoteException {
        Parcel SH = SH();
        bul.m5687a(SH, (Parcelable) locationResult);
        m4422c(1, SH);
    }
}
