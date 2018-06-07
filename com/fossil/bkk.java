package com.fossil;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class bkk extends buj implements bkj {
    bkk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
    }

    public final void mo1378a(bay com_fossil_bay) throws RemoteException {
        Parcel SH = SH();
        bul.m5687a(SH, (Parcelable) com_fossil_bay);
        m4421b(22, SH);
    }
}
