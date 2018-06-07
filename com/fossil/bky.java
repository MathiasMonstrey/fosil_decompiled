package com.fossil;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

public abstract class bky extends buk implements bkx {
    public bky() {
        attachInterface(this, "com.google.android.gms.fitness.internal.IStatusCallback");
    }

    public static bkx m5260l(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IStatusCallback");
        return queryLocalInterface instanceof bkx ? (bkx) queryLocalInterface : new bkz(iBinder);
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (m4353a(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i != 1) {
            return false;
        }
        mo1380n((Status) bul.m5685a(parcel, Status.CREATOR));
        return true;
    }
}
