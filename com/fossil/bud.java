package com.fossil;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class bud extends buj implements buc {
    bud(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    public final void mo1478a(avg com_fossil_avg, int i, boolean z) throws RemoteException {
        Parcel SH = SH();
        bul.m5686a(SH, (IInterface) com_fossil_avg);
        SH.writeInt(i);
        bul.m5688a(SH, z);
        m4421b(9, SH);
    }

    public final void mo1479a(buf com_fossil_buf, bua com_fossil_bua) throws RemoteException {
        Parcel SH = SH();
        bul.m5687a(SH, (Parcelable) com_fossil_buf);
        bul.m5686a(SH, (IInterface) com_fossil_bua);
        m4421b(12, SH);
    }

    public final void ij(int i) throws RemoteException {
        Parcel SH = SH();
        SH.writeInt(i);
        m4421b(7, SH);
    }
}
