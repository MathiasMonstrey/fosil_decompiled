package com.fossil;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public abstract class avh extends buk implements avg {
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (m4353a(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i != 2) {
            return false;
        }
        Parcelable KQ = KQ();
        parcel2.writeNoException();
        bul.m5689b(parcel2, KQ);
        return true;
    }
}
