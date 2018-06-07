package com.fossil;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class fd implements Parcelable {
    public static final Creator<fd> CREATOR = new C35631();
    ff[] JS;
    int[] JT;
    eo[] JU;
    int Je;

    static class C35631 implements Creator<fd> {
        C35631() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m11348g(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return aJ(i);
        }

        public fd m11348g(Parcel parcel) {
            return new fd(parcel);
        }

        public fd[] aJ(int i) {
            return new fd[i];
        }
    }

    public fd(Parcel parcel) {
        this.JS = (ff[]) parcel.createTypedArray(ff.CREATOR);
        this.JT = parcel.createIntArray();
        this.JU = (eo[]) parcel.createTypedArray(eo.CREATOR);
        this.Je = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.JS, i);
        parcel.writeIntArray(this.JT);
        parcel.writeTypedArray(this.JU, i);
        parcel.writeInt(this.Je);
    }
}
