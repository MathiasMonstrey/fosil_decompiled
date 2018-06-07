package com.fossil;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

final class avq implements avp {
    private final IBinder bhG;

    avq(IBinder iBinder) {
        this.bhG = iBinder;
    }

    public final void mo1199a(avn com_fossil_avn, axe com_fossil_axe) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            obtain.writeStrongBinder(com_fossil_avn.asBinder());
            obtain.writeInt(1);
            com_fossil_axe.writeToParcel(obtain, 0);
            this.bhG.transact(46, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final IBinder asBinder() {
        return this.bhG;
    }
}
