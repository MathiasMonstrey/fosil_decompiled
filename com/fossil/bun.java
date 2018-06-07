package com.fossil;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class bun extends buk implements bum {
    public static bum m5691m(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        return queryLocalInterface instanceof bum ? (bum) queryLocalInterface : new buo(iBinder);
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (m4353a(i, parcel, parcel2, i2)) {
            return true;
        }
        String id;
        switch (i) {
            case 1:
                id = getId();
                parcel2.writeNoException();
                parcel2.writeString(id);
                return true;
            case 2:
                boolean bj = bj(bul.m5684B(parcel));
                parcel2.writeNoException();
                bul.m5688a(parcel2, bj);
                return true;
            case 3:
                id = eO(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(id);
                return true;
            case 4:
                mo1488m(parcel.readString(), bul.m5684B(parcel));
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
