package com.fossil;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public final class bie extends buj implements bid {
    bie(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.service.ICommonService");
    }

    public final void mo1352a(bib com_fossil_bib) throws RemoteException {
        Parcel SH = SH();
        bul.m5686a(SH, (IInterface) com_fossil_bib);
        m4422c(1, SH);
    }
}
