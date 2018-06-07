package com.fossil;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class ast extends buk implements ass {
    public ast() {
        attachInterface(this, "com.google.android.gms.auth.api.signin.internal.IRevocationService");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (m4353a(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i != 1) {
            return false;
        }
        Kn();
        return true;
    }
}
