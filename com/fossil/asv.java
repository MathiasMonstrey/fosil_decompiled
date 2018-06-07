package com.fossil;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

public abstract class asv extends buk implements asu {
    public asv() {
        attachInterface(this, "com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (m4353a(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 101:
                mo1145a((GoogleSignInAccount) bul.m5685a(parcel, GoogleSignInAccount.CREATOR), (Status) bul.m5685a(parcel, Status.CREATOR));
                break;
            case 102:
                mo1146a((Status) bul.m5685a(parcel, Status.CREATOR));
                break;
            case 103:
                mo1147b((Status) bul.m5685a(parcel, Status.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
