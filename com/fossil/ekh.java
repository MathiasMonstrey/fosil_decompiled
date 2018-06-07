package com.fossil;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.ua.sdk.sleep.SleepMetric.State;

public class ekh implements Parcelable, Comparable<ekh> {
    public static final Creator<ekh> CREATOR = new C34351();
    public final long dJZ;
    public final State dKa;

    static class C34351 implements Creator<ekh> {
        C34351() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return bj(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return oH(i);
        }

        public ekh bj(Parcel parcel) {
            return new ekh(parcel);
        }

        public ekh[] oH(int i) {
            return new ekh[i];
        }
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m10803a((ekh) obj);
    }

    public int m10803a(ekh com_fossil_ekh) {
        if (this.dJZ < com_fossil_ekh.dJZ) {
            return -1;
        }
        return this.dJZ == com_fossil_ekh.dJZ ? 0 : 1;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.dJZ);
        parcel.writeInt(this.dKa == null ? -1 : this.dKa.ordinal());
    }

    private ekh(Parcel parcel) {
        this.dJZ = parcel.readLong();
        int readInt = parcel.readInt();
        this.dKa = readInt == -1 ? null : State.values()[readInt];
    }
}
