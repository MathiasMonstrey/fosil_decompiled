package com.fossil;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public final class blq extends buj implements blo {
    blq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.flags.IFlagProvider");
    }

    public final boolean getBooleanFlagValue(String str, boolean z, int i) throws RemoteException {
        Parcel SH = SH();
        SH.writeString(str);
        bul.m5688a(SH, z);
        SH.writeInt(i);
        SH = m4420a(2, SH);
        boolean B = bul.m5684B(SH);
        SH.recycle();
        return B;
    }

    public final int getIntFlagValue(String str, int i, int i2) throws RemoteException {
        Parcel SH = SH();
        SH.writeString(str);
        SH.writeInt(i);
        SH.writeInt(i2);
        SH = m4420a(3, SH);
        int readInt = SH.readInt();
        SH.recycle();
        return readInt;
    }

    public final long getLongFlagValue(String str, long j, int i) throws RemoteException {
        Parcel SH = SH();
        SH.writeString(str);
        SH.writeLong(j);
        SH.writeInt(i);
        SH = m4420a(4, SH);
        long readLong = SH.readLong();
        SH.recycle();
        return readLong;
    }

    public final String getStringFlagValue(String str, String str2, int i) throws RemoteException {
        Parcel SH = SH();
        SH.writeString(str);
        SH.writeString(str2);
        SH.writeInt(i);
        SH = m4420a(5, SH);
        String readString = SH.readString();
        SH.recycle();
        return readString;
    }

    public final void init(ayq com_fossil_ayq) throws RemoteException {
        Parcel SH = SH();
        bul.m5686a(SH, (IInterface) com_fossil_ayq);
        m4421b(1, SH);
    }
}
