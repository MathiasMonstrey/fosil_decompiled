package com.fossil;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.fossil.ayq.C1901a;

public final class azp extends buj implements azo {
    public azp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    public final int mo1238a(ayq com_fossil_ayq, String str, boolean z) throws RemoteException {
        Parcel SH = SH();
        bul.m5686a(SH, (IInterface) com_fossil_ayq);
        SH.writeString(str);
        bul.m5688a(SH, z);
        SH = m4420a(3, SH);
        int readInt = SH.readInt();
        SH.recycle();
        return readInt;
    }

    public final ayq mo1239a(ayq com_fossil_ayq, String str, int i) throws RemoteException {
        Parcel SH = SH();
        bul.m5686a(SH, (IInterface) com_fossil_ayq);
        SH.writeString(str);
        SH.writeInt(i);
        SH = m4420a(2, SH);
        ayq k = C1901a.m4703k(SH.readStrongBinder());
        SH.recycle();
        return k;
    }
}
