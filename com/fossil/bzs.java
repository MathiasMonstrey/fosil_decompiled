package com.fossil;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.fossil.ayq.C1901a;

public final class bzs extends buj implements bzr {
    bzs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.plus.internal.IPlusOneButtonCreator");
    }

    public final ayq mo1584a(ayq com_fossil_ayq, int i, int i2, String str, int i3) throws RemoteException {
        Parcel SH = SH();
        bul.m5686a(SH, (IInterface) com_fossil_ayq);
        SH.writeInt(i);
        SH.writeInt(i2);
        SH.writeString(str);
        SH.writeInt(i3);
        SH = m4420a(1, SH);
        ayq k = C1901a.m4703k(SH.readStrongBinder());
        SH.recycle();
        return k;
    }
}
