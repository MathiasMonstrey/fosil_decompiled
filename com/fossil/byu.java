package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public class byu extends auq {
    public static final Creator<byu> CREATOR = new bzg();
    public final float bJi;
    public final float bJj;

    public static final class C1972a {
        public float bJi;
        public float bJj;

        public final byu TE() {
            return new byu(this.bJi, this.bJj);
        }

        public final C1972a af(float f) {
            this.bJi = f;
            return this;
        }

        public final C1972a ag(float f) {
            this.bJj = f;
            return this;
        }
    }

    public byu(float f, float f2) {
        boolean z = -90.0f <= f && f <= 90.0f;
        awa.m4637b(z, "Tilt needs to be between -90 and 90 inclusive: " + f);
        this.bJi = 0.0f + f;
        if (((double) f2) <= 0.0d) {
            f2 = (f2 % 360.0f) + 360.0f;
        }
        this.bJj = f2 % 360.0f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof byu)) {
            return false;
        }
        byu com_fossil_byu = (byu) obj;
        return Float.floatToIntBits(this.bJi) == Float.floatToIntBits(com_fossil_byu.bJi) && Float.floatToIntBits(this.bJj) == Float.floatToIntBits(com_fossil_byu.bJj);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.bJi), Float.valueOf(this.bJj)});
    }

    public String toString() {
        return avx.bN(this).m4608b("tilt", Float.valueOf(this.bJi)).m4608b("bearing", Float.valueOf(this.bJj)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4543a(parcel, 2, this.bJi);
        aus.m4543a(parcel, 3, this.bJj);
        aus.m4540G(parcel, A);
    }
}
