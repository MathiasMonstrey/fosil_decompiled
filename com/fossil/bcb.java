package com.fossil;

import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class bcb extends buj implements bca {
    public bcb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.iid.IMessengerCompat");
    }

    public final void send(Message message) throws RemoteException {
        Parcel SH = SH();
        bul.m5687a(SH, (Parcelable) message);
        m4422c(1, SH);
    }
}
