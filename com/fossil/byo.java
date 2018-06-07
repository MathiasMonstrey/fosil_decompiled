package com.fossil;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.fossil.ayq.C1901a;
import com.google.android.gms.maps.GoogleMapOptions;

public final class byo extends buj implements bxt {
    byo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IMapFragmentDelegate");
    }

    public final ayq mo1521a(ayq com_fossil_ayq, ayq com_fossil_ayq2, Bundle bundle) throws RemoteException {
        Parcel SH = SH();
        bul.m5686a(SH, (IInterface) com_fossil_ayq);
        bul.m5686a(SH, (IInterface) com_fossil_ayq2);
        bul.m5687a(SH, (Parcelable) bundle);
        SH = m4420a(4, SH);
        ayq k = C1901a.m4703k(SH.readStrongBinder());
        SH.recycle();
        return k;
    }

    public final void mo1522a(ayq com_fossil_ayq, GoogleMapOptions googleMapOptions, Bundle bundle) throws RemoteException {
        Parcel SH = SH();
        bul.m5686a(SH, (IInterface) com_fossil_ayq);
        bul.m5687a(SH, (Parcelable) googleMapOptions);
        bul.m5687a(SH, (Parcelable) bundle);
        m4421b(2, SH);
    }

    public final void mo1523a(byb com_fossil_byb) throws RemoteException {
        Parcel SH = SH();
        bul.m5686a(SH, (IInterface) com_fossil_byb);
        m4421b(12, SH);
    }

    public final void onCreate(Bundle bundle) throws RemoteException {
        Parcel SH = SH();
        bul.m5687a(SH, (Parcelable) bundle);
        m4421b(3, SH);
    }

    public final void onDestroy() throws RemoteException {
        m4421b(8, SH());
    }

    public final void onDestroyView() throws RemoteException {
        m4421b(7, SH());
    }

    public final void onLowMemory() throws RemoteException {
        m4421b(9, SH());
    }

    public final void onPause() throws RemoteException {
        m4421b(6, SH());
    }

    public final void onResume() throws RemoteException {
        m4421b(5, SH());
    }

    public final void onSaveInstanceState(Bundle bundle) throws RemoteException {
        Parcel SH = SH();
        bul.m5687a(SH, (Parcelable) bundle);
        SH = m4420a(10, SH);
        if (SH.readInt() != 0) {
            bundle.readFromParcel(SH);
        }
        SH.recycle();
    }

    public final void onStart() throws RemoteException {
        m4421b(15, SH());
    }

    public final void onStop() throws RemoteException {
        m4421b(16, SH());
    }
}
