package com.fossil;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;

public abstract class bwy extends buk implements bwx {
    public static bwx m5298n(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
        return queryLocalInterface instanceof bwx ? (bwx) queryLocalInterface : new bwz(iBinder);
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (m4353a(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                mo1399a((LocationResult) bul.m5685a(parcel, LocationResult.CREATOR));
                break;
            case 2:
                mo1398a((LocationAvailability) bul.m5685a(parcel, LocationAvailability.CREATOR));
                break;
            default:
                return false;
        }
        return true;
    }
}
