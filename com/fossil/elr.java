package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class elr extends eil implements elq {
    public static Creator<elr> CREATOR = new C34521();
    @cga("distance")
    Double dLO;
    @cga("time_in_heart_rate_zones")
    elp dLP;
    @cga("avg_pace")
    Double dLQ;
    @cga("activity_count")
    Integer dLR;
    @cga("energy")
    Double dLS;
    @cga("aggregate_period")
    eln dLT;
    @cga("duration")
    Double dLU;
    @cga("avg_speed")
    Double dLV;

    static class C34521 implements Creator<elr> {
        C34521() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return bu(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return oS(i);
        }

        public elr bu(Parcel parcel) {
            return new elr(parcel);
        }

        public elr[] oS(int i) {
            return new elr[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeValue(this.dLO);
        parcel.writeParcelable(this.dLP, i);
        parcel.writeValue(this.dLQ);
        parcel.writeValue(this.dLR);
        parcel.writeValue(this.dLS);
        parcel.writeParcelable(this.dLT, i);
        parcel.writeValue(this.dLU);
        parcel.writeValue(this.dLV);
    }

    private elr(Parcel parcel) {
        super(parcel);
        this.dLO = (Double) parcel.readValue(Double.class.getClassLoader());
        this.dLP = (elp) parcel.readParcelable(elo.class.getClassLoader());
        this.dLQ = (Double) parcel.readValue(Double.class.getClassLoader());
        this.dLR = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.dLS = (Double) parcel.readValue(Double.class.getClassLoader());
        this.dLT = (eln) parcel.readParcelable(elm.class.getClassLoader());
        this.dLU = (Double) parcel.readValue(Double.class.getClassLoader());
        this.dLV = (Double) parcel.readValue(Double.class.getClassLoader());
    }
}
