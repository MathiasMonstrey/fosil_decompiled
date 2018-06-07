package com.fossil;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class avl extends buk implements avk {
    public avl() {
        attachInterface(this, "com.google.android.gms.common.internal.ICertData");
    }

    public static avk m4594g(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
        return queryLocalInterface instanceof avk ? (avk) queryLocalInterface : new avm(iBinder);
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (m4353a(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                IInterface KY = KY();
                parcel2.writeNoException();
                bul.m5686a(parcel2, KY);
                return true;
            case 2:
                int KZ = KZ();
                parcel2.writeNoException();
                parcel2.writeInt(KZ);
                return true;
            default:
                return false;
        }
    }
}
