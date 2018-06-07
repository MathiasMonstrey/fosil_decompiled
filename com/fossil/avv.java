package com.fossil;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.fossil.ayq.C1901a;

public final class avv extends buj implements avu {
    avv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ISignInButtonCreator");
    }

    public final ayq mo1205a(ayq com_fossil_ayq, awf com_fossil_awf) throws RemoteException {
        Parcel SH = SH();
        bul.m5686a(SH, (IInterface) com_fossil_ayq);
        bul.m5687a(SH, (Parcelable) com_fossil_awf);
        SH = m4420a(2, SH);
        ayq k = C1901a.m4703k(SH.readStrongBinder());
        SH.recycle();
        return k;
    }
}
