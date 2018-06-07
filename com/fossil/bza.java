package com.fossil;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.fossil.ayq.C1901a;
import com.google.android.gms.maps.model.LatLng;

public final class bza extends buj implements byy {
    bza(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IMarkerDelegate");
    }

    public final boolean TA() throws RemoteException {
        Parcel a = m4420a(21, SH());
        boolean B = bul.m5684B(a);
        a.recycle();
        return B;
    }

    public final float TD() throws RemoteException {
        Parcel a = m4420a(28, SH());
        float readFloat = a.readFloat();
        a.recycle();
        return readFloat;
    }

    public final void TG() throws RemoteException {
        m4421b(11, SH());
    }

    public final void TH() throws RemoteException {
        m4421b(12, SH());
    }

    public final boolean TI() throws RemoteException {
        Parcel a = m4420a(13, SH());
        boolean B = bul.m5684B(a);
        a.recycle();
        return B;
    }

    public final int TJ() throws RemoteException {
        Parcel a = m4420a(17, SH());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }

    public final ayq TK() throws RemoteException {
        Parcel a = m4420a(30, SH());
        ayq k = C1901a.m4703k(a.readStrongBinder());
        a.recycle();
        return k;
    }

    public final LatLng Tl() throws RemoteException {
        Parcel a = m4420a(4, SH());
        LatLng latLng = (LatLng) bul.m5685a(a, LatLng.CREATOR);
        a.recycle();
        return latLng;
    }

    public final String Tw() throws RemoteException {
        Parcel a = m4420a(8, SH());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final boolean Tz() throws RemoteException {
        Parcel a = m4420a(10, SH());
        boolean B = bul.m5684B(a);
        a.recycle();
        return B;
    }

    public final boolean mo1560a(byy com_fossil_byy) throws RemoteException {
        Parcel SH = SH();
        bul.m5686a(SH, (IInterface) com_fossil_byy);
        SH = m4420a(16, SH);
        boolean B = bul.m5684B(SH);
        SH.recycle();
        return B;
    }

    public final void ai(float f) throws RemoteException {
        Parcel SH = SH();
        SH.writeFloat(f);
        m4421b(27, SH);
    }

    public final void bx(boolean z) throws RemoteException {
        Parcel SH = SH();
        bul.m5688a(SH, z);
        m4421b(9, SH);
    }

    public final void by(boolean z) throws RemoteException {
        Parcel SH = SH();
        bul.m5688a(SH, z);
        m4421b(20, SH);
    }

    public final void mo1564d(LatLng latLng) throws RemoteException {
        Parcel SH = SH();
        bul.m5687a(SH, (Parcelable) latLng);
        m4421b(3, SH);
    }

    public final void mo1565e(ayq com_fossil_ayq) throws RemoteException {
        Parcel SH = SH();
        bul.m5686a(SH, (IInterface) com_fossil_ayq);
        m4421b(18, SH);
    }

    public final void eX(String str) throws RemoteException {
        Parcel SH = SH();
        SH.writeString(str);
        m4421b(7, SH);
    }

    public final void mo1567f(ayq com_fossil_ayq) throws RemoteException {
        Parcel SH = SH();
        bul.m5686a(SH, (IInterface) com_fossil_ayq);
        m4421b(29, SH);
    }

    public final float getAlpha() throws RemoteException {
        Parcel a = m4420a(26, SH());
        float readFloat = a.readFloat();
        a.recycle();
        return readFloat;
    }

    public final String getId() throws RemoteException {
        Parcel a = m4420a(2, SH());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final float getRotation() throws RemoteException {
        Parcel a = m4420a(23, SH());
        float readFloat = a.readFloat();
        a.recycle();
        return readFloat;
    }

    public final String getTitle() throws RemoteException {
        Parcel a = m4420a(6, SH());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final boolean isVisible() throws RemoteException {
        Parcel a = m4420a(15, SH());
        boolean B = bul.m5684B(a);
        a.recycle();
        return B;
    }

    public final void remove() throws RemoteException {
        m4421b(1, SH());
    }

    public final void setAlpha(float f) throws RemoteException {
        Parcel SH = SH();
        SH.writeFloat(f);
        m4421b(25, SH);
    }

    public final void setRotation(float f) throws RemoteException {
        Parcel SH = SH();
        SH.writeFloat(f);
        m4421b(22, SH);
    }

    public final void setTitle(String str) throws RemoteException {
        Parcel SH = SH();
        SH.writeString(str);
        m4421b(5, SH);
    }

    public final void setVisible(boolean z) throws RemoteException {
        Parcel SH = SH();
        bul.m5688a(SH, z);
        m4421b(14, SH);
    }

    public final void mo1578u(float f, float f2) throws RemoteException {
        Parcel SH = SH();
        SH.writeFloat(f);
        SH.writeFloat(f2);
        m4421b(19, SH);
    }

    public final void mo1579v(float f, float f2) throws RemoteException {
        Parcel SH = SH();
        SH.writeFloat(f);
        SH.writeFloat(f2);
        m4421b(24, SH);
    }
}
