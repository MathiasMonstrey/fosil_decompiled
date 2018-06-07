package com.fossil;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.fossil.ayq.C1901a;

public final class avm extends buj implements avk {
    avm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    public final ayq KY() throws RemoteException {
        Parcel a = m4420a(1, SH());
        ayq k = C1901a.m4703k(a.readStrongBinder());
        a.recycle();
        return k;
    }

    public final int KZ() throws RemoteException {
        Parcel a = m4420a(2, SH());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }
}
