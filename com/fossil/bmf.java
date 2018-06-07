package com.fossil;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class bmf extends buk implements bme {
    public bmf() {
        attachInterface(this, "com.google.android.gms.location.internal.IFusedLocationProviderCallback");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (m4353a(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i != 1) {
            return false;
        }
        mo1394a((bmb) bul.m5685a(parcel, bmb.CREATOR));
        return true;
    }
}
