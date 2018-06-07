package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Arrays;
import java.util.List;

@Deprecated
public final class bvq extends auq {
    public static final Creator<bvq> CREATOR = new bvr();
    private String address;
    private String bHE;
    private String bHF;
    private List<String> bHG;
    private String name;

    public bvq(String str, String str2, String str3, String str4, List<String> list) {
        this.name = str;
        this.address = str2;
        this.bHE = str3;
        this.bHF = str4;
        this.bHG = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bvq)) {
            return false;
        }
        bvq com_fossil_bvq = (bvq) obj;
        return avx.equal(this.name, com_fossil_bvq.name) && avx.equal(this.address, com_fossil_bvq.address) && avx.equal(this.bHE, com_fossil_bvq.bHE) && avx.equal(this.bHF, com_fossil_bvq.bHF) && avx.equal(this.bHG, com_fossil_bvq.bHG);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.name, this.address, this.bHE, this.bHF});
    }

    public final String toString() {
        return avx.bN(this).m4608b("name", this.name).m4608b("address", this.address).m4608b("internationalPhoneNumber", this.bHE).m4608b("regularOpenHours", this.bHF).m4608b("attributions", this.bHG).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4554a(parcel, 1, this.name, false);
        aus.m4554a(parcel, 2, this.address, false);
        aus.m4554a(parcel, 3, this.bHE, false);
        aus.m4554a(parcel, 4, this.bHF, false);
        aus.m4564b(parcel, 5, this.bHG, false);
        aus.m4540G(parcel, A);
    }
}
