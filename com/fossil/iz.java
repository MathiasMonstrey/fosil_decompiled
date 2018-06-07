package com.fossil;

import android.annotation.TargetApi;
import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

@TargetApi(13)
class iz<T> implements ClassLoaderCreator<T> {
    private final iy<T> Pw;

    public iz(iy<T> iyVar) {
        this.Pw = iyVar;
    }

    public T createFromParcel(Parcel parcel) {
        return this.Pw.createFromParcel(parcel, null);
    }

    public T createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return this.Pw.createFromParcel(parcel, classLoader);
    }

    public T[] newArray(int i) {
        return this.Pw.newArray(i);
    }
}
