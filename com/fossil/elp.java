package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class elp implements elo {
    public static Creator<elp> CREATOR = new C34511();
    @cga("zone_5")
    Double dLJ;
    @cga("zone_4")
    Double dLK;
    @cga("zone_3")
    Double dLL;
    @cga("zone_2")
    Double dLM;
    @cga("zone_1")
    Double dLN;

    static class C34511 implements Creator<elp> {
        C34511() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return bt(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return oR(i);
        }

        public elp bt(Parcel parcel) {
            return new elp(parcel);
        }

        public elp[] oR(int i) {
            return new elp[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.dLJ);
        parcel.writeValue(this.dLK);
        parcel.writeValue(this.dLL);
        parcel.writeValue(this.dLM);
        parcel.writeValue(this.dLN);
    }

    private elp(Parcel parcel) {
        this.dLJ = (Double) parcel.readValue(Double.class.getClassLoader());
        this.dLK = (Double) parcel.readValue(Double.class.getClassLoader());
        this.dLL = (Double) parcel.readValue(Double.class.getClassLoader());
        this.dLM = (Double) parcel.readValue(Double.class.getClassLoader());
        this.dLN = (Double) parcel.readValue(Double.class.getClassLoader());
    }
}
