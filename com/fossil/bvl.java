package com.fossil;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Collections;
import java.util.List;

public final class bvl extends auq {
    public static final Creator<bvl> CREATOR = new bvm();
    private final Uri bHd;
    private final float bHf;
    private final int bHg;
    private final List<Integer> bHi;
    private final String bHk;

    bvl(List<Integer> list, String str, Uri uri, float f, int i) {
        this.bHi = Collections.unmodifiableList(list);
        this.bHk = str;
        this.bHd = uri;
        this.bHf = f;
        this.bHg = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4555a(parcel, 1, this.bHi, false);
        aus.m4554a(parcel, 2, this.bHk, false);
        aus.m4548a(parcel, 3, this.bHd, i, false);
        aus.m4543a(parcel, 4, this.bHf);
        aus.m4565c(parcel, 5, this.bHg);
        aus.m4540G(parcel, A);
    }
}
