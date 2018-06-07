package com.fossil;

import android.os.Parcel;

public interface iy<T> {
    T createFromParcel(Parcel parcel, ClassLoader classLoader);

    T[] newArray(int i);
}
