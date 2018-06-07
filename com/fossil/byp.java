package com.fossil;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.fossil.ayq.C1901a;

public final class byp extends buj implements bxu {
    byp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IMapViewDelegate");
    }

    public final ayq Tq() throws RemoteException {
        Parcel a = m4420a(8, SH());
        ayq k = C1901a.m4703k(a.readStrongBinder());
        a.recycle();
        return k;
    }

    public final void mo1534a(byb com_fossil_byb) throws RemoteException {
        Parcel SH = SH();
        bul.m5686a(SH, (IInterface) com_fossil_byb);
        m4421b(9, SH);
    }

    public final void onCreate(Bundle bundle) throws RemoteException {
        Parcel SH = SH();
        bul.m5687a(SH, (Parcelable) bundle);
        m4421b(2, SH);
    }

    public final void onDestroy() throws RemoteException {
        m4421b(5, SH());
    }

    public final void onLowMemory() throws RemoteException {
        m4421b(6, SH());
    }

    public final void onPause() throws RemoteException {
        m4421b(4, SH());
    }

    public final void onResume() throws RemoteException {
        m4421b(3, SH());
    }

    public final void onSaveInstanceState(Bundle bundle) throws RemoteException {
        Parcel SH = SH();
        bul.m5687a(SH, (Parcelable) bundle);
        SH = m4420a(7, SH);
        if (SH.readInt() != 0) {
            bundle.readFromParcel(SH);
        }
        SH.recycle();
    }

    public final void onStart() throws RemoteException {
        m4421b(12, SH());
    }

    public final void onStop() throws RemoteException {
        m4421b(13, SH());
    }
}
