package com.fossil;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.fossil.ayq.C1901a;

public final class avt extends buj implements avr {
    avt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    public final ayq La() throws RemoteException {
        Parcel a = m4420a(1, SH());
        ayq k = C1901a.m4703k(a.readStrongBinder());
        a.recycle();
        return k;
    }

    public final ayq Lb() throws RemoteException {
        Parcel a = m4420a(2, SH());
        ayq k = C1901a.m4703k(a.readStrongBinder());
        a.recycle();
        return k;
    }

    public final boolean mo1202a(aym com_fossil_aym, ayq com_fossil_ayq) throws RemoteException {
        Parcel SH = SH();
        bul.m5687a(SH, (Parcelable) com_fossil_aym);
        bul.m5686a(SH, (IInterface) com_fossil_ayq);
        SH = m4420a(5, SH);
        boolean B = bul.m5684B(SH);
        SH.recycle();
        return B;
    }

    public final boolean mo1203a(String str, ayq com_fossil_ayq) throws RemoteException {
        Parcel SH = SH();
        SH.writeString(str);
        bul.m5686a(SH, (IInterface) com_fossil_ayq);
        SH = m4420a(3, SH);
        boolean B = bul.m5684B(SH);
        SH.recycle();
        return B;
    }

    public final boolean mo1204b(String str, ayq com_fossil_ayq) throws RemoteException {
        Parcel SH = SH();
        SH.writeString(str);
        bul.m5686a(SH, (IInterface) com_fossil_ayq);
        SH = m4420a(4, SH);
        boolean B = bul.m5684B(SH);
        SH.recycle();
        return B;
    }
}
