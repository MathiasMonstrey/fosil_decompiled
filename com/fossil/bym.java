package com.fossil;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.StreetViewPanoramaOptions;

public final class bym extends buj implements byl {
    bym(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.ICreator");
    }

    public final bxr Tr() throws RemoteException {
        bxr com_fossil_bxr;
        Parcel a = m4420a(4, SH());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            com_fossil_bxr = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            com_fossil_bxr = queryLocalInterface instanceof bxr ? (bxr) queryLocalInterface : new byd(readStrongBinder);
        }
        a.recycle();
        return com_fossil_bxr;
    }

    public final byv Ts() throws RemoteException {
        Parcel a = m4420a(5, SH());
        byv p = byw.m5824p(a.readStrongBinder());
        a.recycle();
        return p;
    }

    public final bxu mo1512a(ayq com_fossil_ayq, GoogleMapOptions googleMapOptions) throws RemoteException {
        bxu com_fossil_bxu;
        Parcel SH = SH();
        bul.m5686a(SH, (IInterface) com_fossil_ayq);
        bul.m5687a(SH, (Parcelable) googleMapOptions);
        Parcel a = m4420a(3, SH);
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            com_fossil_bxu = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
            com_fossil_bxu = queryLocalInterface instanceof bxu ? (bxu) queryLocalInterface : new byp(readStrongBinder);
        }
        a.recycle();
        return com_fossil_bxu;
    }

    public final bxw mo1513a(ayq com_fossil_ayq, StreetViewPanoramaOptions streetViewPanoramaOptions) throws RemoteException {
        bxw com_fossil_bxw;
        Parcel SH = SH();
        bul.m5686a(SH, (IInterface) com_fossil_ayq);
        bul.m5687a(SH, (Parcelable) streetViewPanoramaOptions);
        Parcel a = m4420a(7, SH);
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            com_fossil_bxw = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
            com_fossil_bxw = queryLocalInterface instanceof bxw ? (bxw) queryLocalInterface : new byh(readStrongBinder);
        }
        a.recycle();
        return com_fossil_bxw;
    }

    public final void mo1514a(ayq com_fossil_ayq, int i) throws RemoteException {
        Parcel SH = SH();
        bul.m5686a(SH, (IInterface) com_fossil_ayq);
        SH.writeInt(i);
        m4421b(6, SH);
    }

    public final bxt mo1515d(ayq com_fossil_ayq) throws RemoteException {
        bxt com_fossil_bxt;
        Parcel SH = SH();
        bul.m5686a(SH, (IInterface) com_fossil_ayq);
        Parcel a = m4420a(2, SH);
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            com_fossil_bxt = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            com_fossil_bxt = queryLocalInterface instanceof bxt ? (bxt) queryLocalInterface : new byo(readStrongBinder);
        }
        a.recycle();
        return com_fossil_bxt;
    }
}
