package com.fossil;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class bbu extends buj implements bbt {
    bbu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gcm.INetworkTaskCallback");
    }

    public final void hK(int i) throws RemoteException {
        Parcel SH = SH();
        SH.writeInt(i);
        m4421b(2, SH);
    }
}
