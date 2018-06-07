package com.fossil;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class in implements Parcelable {
    public static final Creator<in> CREATOR = new C37291();
    public int Pa;
    public int Pb;
    public int Pc;
    public int Pd;
    public int Pe;

    static class C37291 implements Creator<in> {
        C37291() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m11832q(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return bb(i);
        }

        public in m11832q(Parcel parcel) {
            return new in(parcel);
        }

        public in[] bb(int i) {
            return new in[i];
        }
    }

    public in(Parcel parcel) {
        this.Pa = parcel.readInt();
        this.Pc = parcel.readInt();
        this.Pd = parcel.readInt();
        this.Pe = parcel.readInt();
        this.Pb = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.Pa);
        parcel.writeInt(this.Pc);
        parcel.writeInt(this.Pd);
        parcel.writeInt(this.Pe);
        parcel.writeInt(this.Pb);
    }
}
