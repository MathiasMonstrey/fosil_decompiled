package com.fossil;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public abstract class jy implements Parcelable {
    public static final Creator<jy> CREATOR = ix.m11854a(new C37672());
    public static final jy QL = new C37661();
    private final Parcelable QM;

    static class C37661 extends jy {
        C37661() {
            super();
        }
    }

    static class C37672 implements iy<jy> {
        C37672() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return m11907i(parcel, classLoader);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return bn(i);
        }

        public jy m11907i(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return jy.QL;
            }
            throw new IllegalStateException("superState must be null");
        }

        public jy[] bn(int i) {
            return new jy[i];
        }
    }

    private jy() {
        this.QM = null;
    }

    protected jy(Parcelable parcelable) {
        if (parcelable == null) {
            throw new IllegalArgumentException("superState must not be null");
        }
        if (parcelable == QL) {
            parcelable = null;
        }
        this.QM = parcelable;
    }

    protected jy(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        if (readParcelable == null) {
            readParcelable = QL;
        }
        this.QM = readParcelable;
    }

    public final Parcelable getSuperState() {
        return this.QM;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.QM, i);
    }
}
