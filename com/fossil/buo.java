package com.fossil;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class buo extends buj implements bum {
    buo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
    }

    public final boolean bj(boolean z) throws RemoteException {
        Parcel SH = SH();
        bul.m5688a(SH, z);
        SH = m4420a(2, SH);
        boolean B = bul.m5684B(SH);
        SH.recycle();
        return B;
    }

    public final String eO(String str) throws RemoteException {
        Parcel SH = SH();
        SH.writeString(str);
        SH = m4420a(3, SH);
        String readString = SH.readString();
        SH.recycle();
        return readString;
    }

    public final String getId() throws RemoteException {
        Parcel a = m4420a(1, SH());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final void mo1488m(String str, boolean z) throws RemoteException {
        Parcel SH = SH();
        SH.writeString(str);
        bul.m5688a(SH, z);
        m4421b(4, SH);
    }
}
