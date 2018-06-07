package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.fossil.auq;
import com.fossil.aus;
import com.fossil.avx;
import com.fossil.bzw;
import com.google.android.gms.common.annotation.KeepName;
import java.util.Arrays;

@KeepName
public class PlusCommonExtras extends auq {
    public static final Creator<PlusCommonExtras> CREATOR = new bzw();
    private String bKd;
    private String bKe;
    private final int ber;

    public PlusCommonExtras() {
        this.ber = 1;
        this.bKd = "";
        this.bKe = "";
    }

    public PlusCommonExtras(int i, String str, String str2) {
        this.ber = i;
        this.bKd = str;
        this.bKe = str2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlusCommonExtras)) {
            return false;
        }
        PlusCommonExtras plusCommonExtras = (PlusCommonExtras) obj;
        return this.ber == plusCommonExtras.ber && avx.equal(this.bKd, plusCommonExtras.bKd) && avx.equal(this.bKe, plusCommonExtras.bKe);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.ber), this.bKd, this.bKe});
    }

    public String toString() {
        return avx.bN(this).b("versionCode", Integer.valueOf(this.ber)).b("Gpsrc", this.bKd).b("ClientCallingPackage", this.bKe).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int A = aus.A(parcel);
        aus.a(parcel, 1, this.bKd, false);
        aus.a(parcel, 2, this.bKe, false);
        aus.c(parcel, 1000, this.ber);
        aus.G(parcel, A);
    }
}
