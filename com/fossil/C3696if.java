package com.fossil;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class C3696if implements Parcelable {
    public static final Creator<C3696if> CREATOR = new C36951();
    private final int Oq;
    private final float Or;

    static class C36951 implements Creator<C3696if> {
        C36951() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m11745m(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return aV(i);
        }

        public C3696if m11745m(Parcel parcel) {
            return new C3696if(parcel.readInt(), parcel.readFloat());
        }

        public C3696if[] aV(int i) {
            return new C3696if[i];
        }
    }

    C3696if(int i, float f) {
        this.Oq = i;
        this.Or = f;
    }

    public String toString() {
        String str;
        StringBuilder append = new StringBuilder().append("Rating:style=").append(this.Oq).append(" rating=");
        if (this.Or < 0.0f) {
            str = "unrated";
        } else {
            str = String.valueOf(this.Or);
        }
        return append.append(str).toString();
    }

    public int describeContents() {
        return this.Oq;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.Oq);
        parcel.writeFloat(this.Or);
    }
}
