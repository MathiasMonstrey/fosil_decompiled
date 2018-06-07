package com.fossil;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.fitness.data.DataSet;
import java.util.Arrays;

public final class baw extends auq {
    public static final Creator<baw> CREATOR = new bax();
    private final int ber;
    private final DataSet boJ;
    private final bkx boK;
    private final boolean boL;

    baw(int i, DataSet dataSet, IBinder iBinder, boolean z) {
        this.ber = i;
        this.boJ = dataSet;
        this.boK = bky.m5260l(iBinder);
        this.boL = z;
    }

    public baw(DataSet dataSet, bkx com_fossil_bkx, boolean z) {
        this.ber = 4;
        this.boJ = dataSet;
        this.boK = com_fossil_bkx;
        this.boL = z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r3 == r2) goto L_0x0012;
    L_0x0002:
        r0 = r3 instanceof com.fossil.baw;
        if (r0 == 0) goto L_0x0014;
    L_0x0006:
        r3 = (com.fossil.baw) r3;
        r0 = r2.boJ;
        r1 = r3.boJ;
        r0 = com.fossil.avx.equal(r0, r1);
        if (r0 == 0) goto L_0x0014;
    L_0x0012:
        r0 = 1;
    L_0x0013:
        return r0;
    L_0x0014:
        r0 = 0;
        goto L_0x0013;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.baw.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.boJ});
    }

    public final String toString() {
        return avx.bN(this).m4608b("dataSet", this.boJ).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4548a(parcel, 1, this.boJ, i, false);
        aus.m4546a(parcel, 2, this.boK == null ? null : this.boK.asBinder(), false);
        aus.m4556a(parcel, 4, this.boL);
        aus.m4565c(parcel, 1000, this.ber);
        aus.m4540G(parcel, A);
    }
}
