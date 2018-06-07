package com.fossil;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import java.util.List;

public final class bof extends buj implements bod {
    bof(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    public final List<bsh> mo1428a(bnh com_fossil_bnh, boolean z) throws RemoteException {
        Parcel SH = SH();
        bul.m5687a(SH, (Parcelable) com_fossil_bnh);
        bul.m5688a(SH, z);
        SH = m4420a(7, SH);
        List createTypedArrayList = SH.createTypedArrayList(bsh.CREATOR);
        SH.recycle();
        return createTypedArrayList;
    }

    public final List<bnk> mo1429a(String str, String str2, bnh com_fossil_bnh) throws RemoteException {
        Parcel SH = SH();
        SH.writeString(str);
        SH.writeString(str2);
        bul.m5687a(SH, (Parcelable) com_fossil_bnh);
        SH = m4420a(16, SH);
        List createTypedArrayList = SH.createTypedArrayList(bnk.CREATOR);
        SH.recycle();
        return createTypedArrayList;
    }

    public final List<bsh> mo1430a(String str, String str2, String str3, boolean z) throws RemoteException {
        Parcel SH = SH();
        SH.writeString(str);
        SH.writeString(str2);
        SH.writeString(str3);
        bul.m5688a(SH, z);
        SH = m4420a(15, SH);
        List createTypedArrayList = SH.createTypedArrayList(bsh.CREATOR);
        SH.recycle();
        return createTypedArrayList;
    }

    public final List<bsh> mo1431a(String str, String str2, boolean z, bnh com_fossil_bnh) throws RemoteException {
        Parcel SH = SH();
        SH.writeString(str);
        SH.writeString(str2);
        bul.m5688a(SH, z);
        bul.m5687a(SH, (Parcelable) com_fossil_bnh);
        SH = m4420a(14, SH);
        List createTypedArrayList = SH.createTypedArrayList(bsh.CREATOR);
        SH.recycle();
        return createTypedArrayList;
    }

    public final void mo1432a(long j, String str, String str2, String str3) throws RemoteException {
        Parcel SH = SH();
        SH.writeLong(j);
        SH.writeString(str);
        SH.writeString(str2);
        SH.writeString(str3);
        m4421b(10, SH);
    }

    public final void mo1433a(bnh com_fossil_bnh) throws RemoteException {
        Parcel SH = SH();
        bul.m5687a(SH, (Parcelable) com_fossil_bnh);
        m4421b(4, SH);
    }

    public final void mo1434a(bnk com_fossil_bnk, bnh com_fossil_bnh) throws RemoteException {
        Parcel SH = SH();
        bul.m5687a(SH, (Parcelable) com_fossil_bnk);
        bul.m5687a(SH, (Parcelable) com_fossil_bnh);
        m4421b(12, SH);
    }

    public final void mo1435a(bnz com_fossil_bnz, bnh com_fossil_bnh) throws RemoteException {
        Parcel SH = SH();
        bul.m5687a(SH, (Parcelable) com_fossil_bnz);
        bul.m5687a(SH, (Parcelable) com_fossil_bnh);
        m4421b(1, SH);
    }

    public final void mo1436a(bnz com_fossil_bnz, String str, String str2) throws RemoteException {
        Parcel SH = SH();
        bul.m5687a(SH, (Parcelable) com_fossil_bnz);
        SH.writeString(str);
        SH.writeString(str2);
        m4421b(5, SH);
    }

    public final void mo1437a(bsh com_fossil_bsh, bnh com_fossil_bnh) throws RemoteException {
        Parcel SH = SH();
        bul.m5687a(SH, (Parcelable) com_fossil_bsh);
        bul.m5687a(SH, (Parcelable) com_fossil_bnh);
        m4421b(2, SH);
    }

    public final byte[] mo1438a(bnz com_fossil_bnz, String str) throws RemoteException {
        Parcel SH = SH();
        bul.m5687a(SH, (Parcelable) com_fossil_bnz);
        SH.writeString(str);
        SH = m4420a(9, SH);
        byte[] createByteArray = SH.createByteArray();
        SH.recycle();
        return createByteArray;
    }

    public final void mo1439b(bnh com_fossil_bnh) throws RemoteException {
        Parcel SH = SH();
        bul.m5687a(SH, (Parcelable) com_fossil_bnh);
        m4421b(6, SH);
    }

    public final void mo1440b(bnk com_fossil_bnk) throws RemoteException {
        Parcel SH = SH();
        bul.m5687a(SH, (Parcelable) com_fossil_bnk);
        m4421b(13, SH);
    }

    public final String mo1441c(bnh com_fossil_bnh) throws RemoteException {
        Parcel SH = SH();
        bul.m5687a(SH, (Parcelable) com_fossil_bnh);
        SH = m4420a(11, SH);
        String readString = SH.readString();
        SH.recycle();
        return readString;
    }

    public final List<bnk> mo1442g(String str, String str2, String str3) throws RemoteException {
        Parcel SH = SH();
        SH.writeString(str);
        SH.writeString(str2);
        SH.writeString(str3);
        SH = m4420a(17, SH);
        List createTypedArrayList = SH.createTypedArrayList(bnk.CREATOR);
        SH.recycle();
        return createTypedArrayList;
    }
}
