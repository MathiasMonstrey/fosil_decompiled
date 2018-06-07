package com.fossil;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class elv implements Parcelable {
    public static final Creator<elv> CREATOR = new C34551();
    static final int[] dMb = new int[0];
    int[] array;
    int size;

    static class C34551 implements Creator<elv> {
        C34551() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return bx(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return oW(i);
        }

        public elv bx(Parcel parcel) {
            return new elv(parcel);
        }

        public elv[] oW(int i) {
            return new elv[i];
        }
    }

    public elv() {
        this.array = dMb;
        this.size = 0;
    }

    public void oV(int i) {
        if (this.size == this.array.length) {
            Object obj = this.array;
            int length = obj.length;
            Object obj2 = new int[(length < 12 ? length + 12 : length * 2)];
            System.arraycopy(obj, 0, obj2, 0, this.size);
            this.array = obj2;
        }
        int[] iArr = this.array;
        int i2 = this.size;
        this.size = i2 + 1;
        iArr[i2] = i;
    }

    public void clear() {
        this.size = 0;
    }

    public int[] toArray() {
        Object obj = new int[this.size];
        System.arraycopy(this.array, 0, obj, 0, this.size);
        return obj;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.array);
        parcel.writeInt(this.size);
    }

    private elv(Parcel parcel) {
        this.array = parcel.createIntArray();
        this.size = parcel.readInt();
    }
}
