package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Collections;
import java.util.List;

public final class bvs extends auq {
    public static final Creator<bvs> CREATOR = new bvv();
    private List<bvt> bHH;
    private List<bvu> bHI;

    bvs(List<bvt> list, List<bvu> list2) {
        this.bHH = Collections.unmodifiableList(list);
        this.bHI = Collections.unmodifiableList(list2);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4566c(parcel, 1, this.bHH, false);
        aus.m4566c(parcel, 2, this.bHI, false);
        aus.m4540G(parcel, A);
    }
}
