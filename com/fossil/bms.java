package com.fossil;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class bms extends auq {
    public static final Creator<bms> CREATOR = new bmt();
    private PendingIntent bfJ;
    private int bwB;
    private bmq bwC;
    private bxa bwD;
    private bwx bwE;
    private bme bwF;

    bms(int i, bmq com_fossil_bmq, IBinder iBinder, PendingIntent pendingIntent, IBinder iBinder2, IBinder iBinder3) {
        bme com_fossil_bme = null;
        this.bwB = i;
        this.bwC = com_fossil_bmq;
        this.bwD = iBinder == null ? null : bxb.m5301o(iBinder);
        this.bfJ = pendingIntent;
        this.bwE = iBinder2 == null ? null : bwy.m5298n(iBinder2);
        if (!(iBinder3 == null || iBinder3 == null)) {
            IInterface queryLocalInterface = iBinder3.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            com_fossil_bme = queryLocalInterface instanceof bme ? (bme) queryLocalInterface : new bmg(iBinder3);
        }
        this.bwF = com_fossil_bme;
    }

    public static bms m5305a(bwx com_fossil_bwx, bme com_fossil_bme) {
        return new bms(2, null, null, null, com_fossil_bwx.asBinder(), com_fossil_bme != null ? com_fossil_bme.asBinder() : null);
    }

    public static bms m5306a(bxa com_fossil_bxa, bme com_fossil_bme) {
        return new bms(2, null, com_fossil_bxa.asBinder(), null, null, com_fossil_bme != null ? com_fossil_bme.asBinder() : null);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        IBinder iBinder = null;
        int A = aus.m4537A(parcel);
        aus.m4565c(parcel, 1, this.bwB);
        aus.m4548a(parcel, 2, this.bwC, i, false);
        aus.m4546a(parcel, 3, this.bwD == null ? null : this.bwD.asBinder(), false);
        aus.m4548a(parcel, 4, this.bfJ, i, false);
        aus.m4546a(parcel, 5, this.bwE == null ? null : this.bwE.asBinder(), false);
        if (this.bwF != null) {
            iBinder = this.bwF.asBinder();
        }
        aus.m4546a(parcel, 6, iBinder, false);
        aus.m4540G(parcel, A);
    }
}
