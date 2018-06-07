package com.fossil;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class byc extends buk implements byb {
    public byc() {
        attachInterface(this, "com.google.android.gms.maps.internal.IOnMapReadyCallback");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (m4353a(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i != 1) {
            return false;
        }
        bxs com_fossil_bxs;
        IBinder readStrongBinder = parcel.readStrongBinder();
        if (readStrongBinder == null) {
            com_fossil_bxs = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            com_fossil_bxs = queryLocalInterface instanceof bxs ? (bxs) queryLocalInterface : new byn(readStrongBinder);
        }
        mo1580a(com_fossil_bxs);
        parcel2.writeNoException();
        return true;
    }
}
