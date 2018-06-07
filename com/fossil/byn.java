package com.fossil;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class byn extends buj implements bxs {
    byn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IGoogleMapDelegate");
    }

    public final bxx Tp() throws RemoteException {
        bxx com_fossil_bxx;
        Parcel a = m4420a(25, SH());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            com_fossil_bxx = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            com_fossil_bxx = queryLocalInterface instanceof bxx ? (bxx) queryLocalInterface : new byi(readStrongBinder);
        }
        a.recycle();
        return com_fossil_bxx;
    }

    public final byy mo1517b(byt com_fossil_byt) throws RemoteException {
        Parcel SH = SH();
        bul.m5687a(SH, (Parcelable) com_fossil_byt);
        SH = m4420a(11, SH);
        byy q = byz.m5832q(SH.readStrongBinder());
        SH.recycle();
        return q;
    }

    public final void mo1518b(ayq com_fossil_ayq) throws RemoteException {
        Parcel SH = SH();
        bul.m5686a(SH, (IInterface) com_fossil_ayq);
        m4421b(4, SH);
    }

    public final void mo1519c(ayq com_fossil_ayq) throws RemoteException {
        Parcel SH = SH();
        bul.m5686a(SH, (IInterface) com_fossil_ayq);
        m4421b(5, SH);
    }

    public final void clear() throws RemoteException {
        m4421b(14, SH());
    }
}
