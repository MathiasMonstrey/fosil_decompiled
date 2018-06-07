package com.fossil;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

public abstract class bub extends buk implements bua {
    public bub() {
        attachInterface(this, "com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (m4353a(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 3:
                bul.m5685a(parcel, atn.CREATOR);
                bul.m5685a(parcel, btx.CREATOR);
                break;
            case 4:
                bul.m5685a(parcel, Status.CREATOR);
                break;
            case 6:
                bul.m5685a(parcel, Status.CREATOR);
                break;
            case 7:
                bul.m5685a(parcel, Status.CREATOR);
                bul.m5685a(parcel, GoogleSignInAccount.CREATOR);
                break;
            case 8:
                mo1327b((buh) bul.m5685a(parcel, buh.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
