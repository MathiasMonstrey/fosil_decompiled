package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.misfit.frameworks.common.constants.Constants;
import java.util.Arrays;

public final class bwb extends auq {
    public static final Creator<bwb> CREATOR = new bwa();
    final int Qz;
    final int mLength;

    public bwb(int i, int i2) {
        this.Qz = i;
        this.mLength = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bwb)) {
            return false;
        }
        bwb com_fossil_bwb = (bwb) obj;
        return avx.equal(Integer.valueOf(this.Qz), Integer.valueOf(com_fossil_bwb.Qz)) && avx.equal(Integer.valueOf(this.mLength), Integer.valueOf(com_fossil_bwb.mLength));
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.Qz), Integer.valueOf(this.mLength)});
    }

    public final String toString() {
        return avx.bN(this).m4608b(Constants.JSON_KEY_OFFSET, Integer.valueOf(this.Qz)).m4608b("length", Integer.valueOf(this.mLength)).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4565c(parcel, 1, this.Qz);
        aus.m4565c(parcel, 2, this.mLength);
        aus.m4540G(parcel, A);
    }
}
