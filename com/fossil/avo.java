package com.fossil;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class avo extends buk implements avn {
    public avo() {
        attachInterface(this, "com.google.android.gms.common.internal.IGmsCallbacks");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (m4353a(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                mo1208a(parcel.readInt(), parcel.readStrongBinder(), (Bundle) bul.m5685a(parcel, Bundle.CREATOR));
                break;
            case 2:
                mo1209d(parcel.readInt(), (Bundle) bul.m5685a(parcel, Bundle.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
