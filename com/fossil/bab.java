package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public final class bab extends auq {
    public static final Creator<bab> CREATOR = new bar();
    private final String bmb;
    private final String bmc;
    private final String bmd;
    private final int bme;
    private final int type;
    private final String version;
    private final int versionCode;

    bab(int i, String str, String str2, String str3, String str4, int i2, int i3) {
        this.versionCode = i;
        this.bmb = (String) awa.bO(str);
        this.bmc = (String) awa.bO(str2);
        this.version = "";
        if (str4 != null) {
            this.bmd = str4;
            this.type = i2;
            this.bme = i3;
            return;
        }
        throw new IllegalStateException("Device UID is null.");
    }

    public bab(String str, String str2, String str3, int i) {
        this(str, str2, "", str3, i, 0);
    }

    private bab(String str, String str2, String str3, String str4, int i, int i2) {
        this(1, str, str2, "", str4, i, i2);
    }

    final String Mg() {
        return String.format("%s:%s:%s", new Object[]{this.bmb, this.bmc, this.bmd});
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof bab)) {
                return false;
            }
            bab com_fossil_bab = (bab) obj;
            boolean z = avx.equal(this.bmb, com_fossil_bab.bmb) && avx.equal(this.bmc, com_fossil_bab.bmc) && avx.equal(this.version, com_fossil_bab.version) && avx.equal(this.bmd, com_fossil_bab.bmd) && this.type == com_fossil_bab.type && this.bme == com_fossil_bab.bme;
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public final String getManufacturer() {
        return this.bmb;
    }

    public final String getModel() {
        return this.bmc;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUid() {
        return this.bmd;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.bmb, this.bmc, this.version, this.bmd, Integer.valueOf(this.type)});
    }

    public final String toString() {
        return String.format("Device{%s:%s:%s:%s}", new Object[]{Mg(), this.version, Integer.valueOf(this.type), Integer.valueOf(this.bme)});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4554a(parcel, 1, getManufacturer(), false);
        aus.m4554a(parcel, 2, getModel(), false);
        aus.m4554a(parcel, 3, this.version, false);
        aus.m4554a(parcel, 4, this.bme == 1 ? this.bmd : bln.dN(this.bmd), false);
        aus.m4565c(parcel, 5, getType());
        aus.m4565c(parcel, 6, this.bme);
        aus.m4565c(parcel, 1000, this.versionCode);
        aus.m4540G(parcel, A);
    }
}
