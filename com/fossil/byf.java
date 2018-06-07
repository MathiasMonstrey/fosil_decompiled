package com.fossil;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class byf extends buk implements bye {
    public byf() {
        attachInterface(this, "com.google.android.gms.maps.internal.IOnStreetViewPanoramaReadyCallback");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (m4353a(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i != 1) {
            return false;
        }
        bxv com_fossil_bxv;
        IBinder readStrongBinder = parcel.readStrongBinder();
        if (readStrongBinder == null) {
            com_fossil_bxv = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            com_fossil_bxv = queryLocalInterface instanceof bxv ? (bxv) queryLocalInterface : new byg(readStrongBinder);
        }
        mo1581a(com_fossil_bxv);
        parcel2.writeNoException();
        return true;
    }
}
