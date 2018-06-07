package com.fossil;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.fossil.ayq.C1901a;

public final class azr extends buj implements azq {
    public azr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    public final ayq mo1240a(ayq com_fossil_ayq, String str, int i, ayq com_fossil_ayq2) throws RemoteException {
        Parcel SH = SH();
        bul.m5686a(SH, (IInterface) com_fossil_ayq);
        SH.writeString(str);
        SH.writeInt(i);
        bul.m5686a(SH, (IInterface) com_fossil_ayq2);
        SH = m4420a(2, SH);
        ayq k = C1901a.m4703k(SH.readStrongBinder());
        SH.recycle();
        return k;
    }
}
