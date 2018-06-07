package com.fossil;

import android.location.Location;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class bxb extends buk implements bxa {
    public bxb() {
        attachInterface(this, "com.google.android.gms.location.ILocationListener");
    }

    public static bxa m5301o(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationListener");
        return queryLocalInterface instanceof bxa ? (bxa) queryLocalInterface : new bxc(iBinder);
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (m4353a(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i != 1) {
            return false;
        }
        onLocationChanged((Location) bul.m5685a(parcel, Location.CREATOR));
        return true;
    }
}
