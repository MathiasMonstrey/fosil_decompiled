package com.fossil;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public abstract class bwr extends buk implements bwq {
    public bwr() {
        attachInterface(this, "com.google.android.gms.location.places.internal.IPlacesCallbacks");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (m4353a(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                mo1494a((DataHolder) bul.m5685a(parcel, DataHolder.CREATOR));
                break;
            case 2:
                mo1495b((DataHolder) bul.m5685a(parcel, DataHolder.CREATOR));
                break;
            case 3:
                mo1496c((DataHolder) bul.m5685a(parcel, DataHolder.CREATOR));
                break;
            case 4:
                mo1498o((Status) bul.m5685a(parcel, Status.CREATOR));
                break;
            case 5:
                mo1497d((DataHolder) bul.m5685a(parcel, DataHolder.CREATOR));
                break;
            default:
                return false;
        }
        return true;
    }
}
