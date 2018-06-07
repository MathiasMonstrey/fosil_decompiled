package com.fossil;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class byi extends buj implements bxx {
    byi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IUiSettingsDelegate");
    }

    public final void bw(boolean z) throws RemoteException {
        Parcel SH = SH();
        bul.m5688a(SH, z);
        m4421b(18, SH);
    }
}
