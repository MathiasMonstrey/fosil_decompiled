package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class edi implements edh {
    public static Creator<edi> CREATOR = new C33231();
    @cga("user_id")
    long dDR;
    @cga("rank")
    int dDS;
    @cga("value")
    Object value;

    static class C33231 implements Creator<edi> {
        C33231() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m10546I(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return mZ(i);
        }

        public edi m10546I(Parcel parcel) {
            return new edi(parcel);
        }

        public edi[] mZ(int i) {
            return new edi[i];
        }
    }

    private edi(Parcel parcel) {
        this.value = parcel.readValue(Object.class.getClassLoader());
        this.dDR = parcel.readLong();
        this.dDS = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.value);
        parcel.writeLong(this.dDR);
        parcel.writeInt(this.dDS);
    }
}
