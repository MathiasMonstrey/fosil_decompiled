package com.fossil;

import android.location.Location;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class bxc extends buj implements bxa {
    bxc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.ILocationListener");
    }

    public final void onLocationChanged(Location location) throws RemoteException {
        Parcel SH = SH();
        bul.m5687a(SH, (Parcelable) location);
        m4422c(1, SH);
    }
}
