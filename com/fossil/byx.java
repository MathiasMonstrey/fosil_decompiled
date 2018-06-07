package com.fossil;

import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.fossil.ayq.C1901a;

public final class byx extends buj implements byv {
    byx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
    }

    public final ayq TF() throws RemoteException {
        Parcel a = m4420a(4, SH());
        ayq k = C1901a.m4703k(a.readStrongBinder());
        a.recycle();
        return k;
    }

    public final ayq ah(float f) throws RemoteException {
        Parcel SH = SH();
        SH.writeFloat(f);
        SH = m4420a(5, SH);
        ayq k = C1901a.m4703k(SH.readStrongBinder());
        SH.recycle();
        return k;
    }

    public final ayq eU(String str) throws RemoteException {
        Parcel SH = SH();
        SH.writeString(str);
        SH = m4420a(2, SH);
        ayq k = C1901a.m4703k(SH.readStrongBinder());
        SH.recycle();
        return k;
    }

    public final ayq eV(String str) throws RemoteException {
        Parcel SH = SH();
        SH.writeString(str);
        SH = m4420a(3, SH);
        ayq k = C1901a.m4703k(SH.readStrongBinder());
        SH.recycle();
        return k;
    }

    public final ayq eW(String str) throws RemoteException {
        Parcel SH = SH();
        SH.writeString(str);
        SH = m4420a(7, SH);
        ayq k = C1901a.m4703k(SH.readStrongBinder());
        SH.recycle();
        return k;
    }

    public final ayq ir(int i) throws RemoteException {
        Parcel SH = SH();
        SH.writeInt(i);
        SH = m4420a(1, SH);
        ayq k = C1901a.m4703k(SH.readStrongBinder());
        SH.recycle();
        return k;
    }

    public final ayq mo1549r(Bitmap bitmap) throws RemoteException {
        Parcel SH = SH();
        bul.m5687a(SH, (Parcelable) bitmap);
        SH = m4420a(6, SH);
        ayq k = C1901a.m4703k(SH.readStrongBinder());
        SH.recycle();
        return k;
    }
}
