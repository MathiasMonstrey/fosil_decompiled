package com.fossil;

import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class ix {

    static class C3737a<T> implements Creator<T> {
        final iy<T> Pw;

        public C3737a(iy<T> iyVar) {
            this.Pw = iyVar;
        }

        public T createFromParcel(Parcel parcel) {
            return this.Pw.createFromParcel(parcel, null);
        }

        public T[] newArray(int i) {
            return this.Pw.newArray(i);
        }
    }

    public static <T> Creator<T> m11854a(iy<T> iyVar) {
        if (VERSION.SDK_INT >= 13) {
            return ja.m11861b(iyVar);
        }
        return new C3737a(iyVar);
    }
}
