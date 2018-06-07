package com.fossil;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.fossil.ayq.C1901a;
import com.google.android.gms.maps.model.LatLng;

public final class byd extends buj implements bxr {
    byd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
    }

    public final ayq ab(float f) throws RemoteException {
        Parcel SH = SH();
        SH.writeFloat(f);
        SH = m4420a(4, SH);
        ayq k = C1901a.m4703k(SH.readStrongBinder());
        SH.recycle();
        return k;
    }

    public final ayq mo1500b(LatLng latLng, float f) throws RemoteException {
        Parcel SH = SH();
        bul.m5687a(SH, (Parcelable) latLng);
        SH.writeFloat(f);
        SH = m4420a(9, SH);
        ayq k = C1901a.m4703k(SH.readStrongBinder());
        SH.recycle();
        return k;
    }
}
