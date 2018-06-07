package com.fossil;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class elw implements Parcelable {
    public static final Creator<elw> CREATOR = new C34561();
    static final long[] dMd = new long[0];
    long[] dMc;
    int size;

    static class C34561 implements Creator<elw> {
        C34561() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return by(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return oX(i);
        }

        public elw by(Parcel parcel) {
            return new elw(parcel);
        }

        public elw[] oX(int i) {
            return new elw[i];
        }
    }

    public elw() {
        this.dMc = dMd;
        this.size = 0;
    }

    public void add(long j) {
        if (this.size == this.dMc.length) {
            Object obj = this.dMc;
            int length = obj.length;
            Object obj2 = new long[(length < 12 ? length + 12 : length * 2)];
            System.arraycopy(obj, 0, obj2, 0, this.size);
            this.dMc = obj2;
        }
        long[] jArr = this.dMc;
        int i = this.size;
        this.size = i + 1;
        jArr[i] = j;
    }

    public void clear() {
        this.size = 0;
    }

    public long[] toArray() {
        Object obj = new long[this.size];
        System.arraycopy(this.dMc, 0, obj, 0, this.size);
        return obj;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLongArray(this.dMc);
        parcel.writeInt(this.size);
    }

    private elw(Parcel parcel) {
        this.dMc = parcel.createLongArray();
        this.size = parcel.readInt();
    }
}
