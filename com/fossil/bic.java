package com.fossil;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class bic extends buk implements bib {
    public bic() {
        attachInterface(this, "com.google.android.gms.common.internal.service.ICommonCallbacks");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (m4353a(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i != 1) {
            return false;
        }
        mo1350if(parcel.readInt());
        parcel2.writeNoException();
        return true;
    }
}
