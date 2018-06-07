package com.fossil;

import android.os.Parcelable;

public interface ehu<T> extends Parcelable {
    String getName();

    T getValue();

    void setValue(T t);
}
