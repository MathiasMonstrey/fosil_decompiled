package com.fossil;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.fossil.ac.C1562a;

public interface ae extends IInterface {

    public static abstract class C1616a extends Binder implements ae {
        public C1616a() {
            attachInterface(this, "android.support.customtabs.IPostMessageService");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            Bundle bundle = null;
            ac a;
            switch (i) {
                case 2:
                    parcel.enforceInterface("android.support.customtabs.IPostMessageService");
                    a = C1562a.m2916a(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    mo845b(a, bundle);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("android.support.customtabs.IPostMessageService");
                    a = C1562a.m2916a(parcel.readStrongBinder());
                    String readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    mo846b(a, readString, bundle);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("android.support.customtabs.IPostMessageService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void mo845b(ac acVar, Bundle bundle) throws RemoteException;

    void mo846b(ac acVar, String str, Bundle bundle) throws RemoteException;
}
