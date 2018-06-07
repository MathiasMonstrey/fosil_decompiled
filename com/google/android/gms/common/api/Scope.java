package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.fossil.aue;
import com.fossil.auq;
import com.fossil.aus;
import com.fossil.awa;
import com.google.android.gms.common.internal.ReflectedParcelable;

public final class Scope extends auq implements ReflectedParcelable {
    public static final Creator<Scope> CREATOR = new aue();
    private int ber;
    private final String bgv;

    public Scope(int i, String str) {
        awa.c(str, "scopeUri must not be null or empty");
        this.ber = i;
        this.bgv = str;
    }

    public Scope(String str) {
        this(1, str);
    }

    public final String KK() {
        return this.bgv;
    }

    public final boolean equals(Object obj) {
        return this == obj ? true : !(obj instanceof Scope) ? false : this.bgv.equals(((Scope) obj).bgv);
    }

    public final int hashCode() {
        return this.bgv.hashCode();
    }

    public final String toString() {
        return this.bgv;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.A(parcel);
        aus.c(parcel, 1, this.ber);
        aus.a(parcel, 2, this.bgv, false);
        aus.G(parcel, A);
    }
}
