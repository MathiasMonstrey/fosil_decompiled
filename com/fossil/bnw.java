package com.fossil;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Iterator;

public final class bnw extends auq implements Iterable<String> {
    public static final Creator<bnw> CREATOR = new bny();
    private final Bundle byn;

    bnw(Bundle bundle) {
        this.byn = bundle;
    }

    public final Bundle QY() {
        return new Bundle(this.byn);
    }

    final Object get(String str) {
        return this.byn.get(str);
    }

    public final Iterator<String> iterator() {
        return new bnx(this);
    }

    public final int size() {
        return this.byn.size();
    }

    public final String toString() {
        return this.byn.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4545a(parcel, 2, QY(), false);
        aus.m4540G(parcel, A);
    }
}
