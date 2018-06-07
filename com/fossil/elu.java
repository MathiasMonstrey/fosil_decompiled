package com.fossil;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class elu implements Parcelable {
    public static final Creator<elu> CREATOR = new C34541();
    static final double[] dMa = new double[0];
    double[] dLZ;
    int size;

    static class C34541 implements Creator<elu> {
        C34541() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return bw(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return oU(i);
        }

        public elu bw(Parcel parcel) {
            return new elu(parcel);
        }

        public elu[] oU(int i) {
            return new elu[i];
        }
    }

    public elu() {
        this.dLZ = dMa;
        this.size = 0;
    }

    public void add(double d) {
        if (this.size == this.dLZ.length) {
            Object obj = this.dLZ;
            int length = obj.length;
            Object obj2 = new double[(length < 12 ? length + 12 : length * 2)];
            System.arraycopy(obj, 0, obj2, 0, this.size);
            this.dLZ = obj2;
        }
        double[] dArr = this.dLZ;
        int i = this.size;
        this.size = i + 1;
        dArr[i] = d;
    }

    public void clear() {
        this.size = 0;
    }

    public double[] toArray() {
        Object obj = new double[this.size];
        System.arraycopy(this.dLZ, 0, obj, 0, this.size);
        return obj;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDoubleArray(this.dLZ);
        parcel.writeInt(this.size);
    }

    private elu(Parcel parcel) {
        this.dLZ = parcel.createDoubleArray();
        this.size = parcel.readInt();
    }
}
