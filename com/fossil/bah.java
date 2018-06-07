package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public final class bah extends auq {
    public static final Creator<bah> CREATOR = new bai();
    public static final bah boD = new bah("com.google.android.gms", null, null);
    private final String boE;
    private final String packageName;
    private final String version;
    private final int versionCode;

    bah(int i, String str, String str2, String str3) {
        this.versionCode = i;
        this.packageName = (String) awa.bO(str);
        this.version = "";
        this.boE = str3;
    }

    private bah(String str, String str2, String str3) {
        this(1, str, "", null);
    }

    public static bah dv(String str) {
        return "com.google.android.gms".equals(str) ? boD : new bah(str, null, null);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof bah)) {
                return false;
            }
            bah com_fossil_bah = (bah) obj;
            boolean z = this.packageName.equals(com_fossil_bah.packageName) && avx.equal(this.version, com_fossil_bah.version) && avx.equal(this.boE, com_fossil_bah.boE);
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.packageName, this.version, this.boE});
    }

    public final String toString() {
        return String.format("Application{%s:%s:%s}", new Object[]{this.packageName, this.version, this.boE});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4554a(parcel, 1, this.packageName, false);
        aus.m4554a(parcel, 2, this.version, false);
        aus.m4554a(parcel, 3, this.boE, false);
        aus.m4565c(parcel, 1000, this.versionCode);
        aus.m4540G(parcel, A);
    }
}
