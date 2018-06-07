package com.fossil;

import android.location.Location;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class bmi extends buj implements bmh {
    bmi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.internal.IGoogleLocationManagerService");
    }

    public final void mo1395a(bms com_fossil_bms) throws RemoteException {
        Parcel SH = SH();
        bul.m5687a(SH, (Parcelable) com_fossil_bms);
        m4421b(59, SH);
    }

    public final void bc(boolean z) throws RemoteException {
        Parcel SH = SH();
        bul.m5688a(SH, z);
        m4421b(12, SH);
    }

    public final Location dO(String str) throws RemoteException {
        Parcel SH = SH();
        SH.writeString(str);
        Parcel a = m4420a(21, SH);
        Location location = (Location) bul.m5685a(a, Location.CREATOR);
        a.recycle();
        return location;
    }
}
