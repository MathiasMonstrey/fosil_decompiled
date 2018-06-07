package com.fossil;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

public final class bkz extends buj implements bkx {
    bkz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fitness.internal.IStatusCallback");
    }

    public final void mo1380n(Status status) throws RemoteException {
        Parcel SH = SH();
        bul.m5687a(SH, (Parcelable) status);
        m4422c(1, SH);
    }
}
