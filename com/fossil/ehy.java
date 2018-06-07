package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.ua.sdk.internal.Period;
import com.ua.sdk.net.json.Iso8601PeriodFormat;
import java.util.Date;

public class ehy extends eil implements ehx {
    public static Creator<ehy> CREATOR = new C34031();
    @cga("period")
    Period dEM;
    @cga("criteria")
    ehs dEO;
    @cga("data_type_field")
    String dFh;
    @cga("start_datetime")
    Date dHM;
    @cga("end_datetime")
    Date dHN;
    @cga("iteration_start_datetime")
    Date dHO;
    @cga("iteration_end_datetime")
    Date dHP;
    @cga("iteration")
    Integer dHQ;
    @cga("name")
    String name;

    static class C34031 implements Creator<ehy> {
        C34031() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return aM(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return oe(i);
        }

        public ehy aM(Parcel parcel) {
            return new ehy(parcel);
        }

        public ehy[] oe(int i) {
            return new ehy[i];
        }
    }

    public /* synthetic */ ecj aCy() {
        return aCt();
    }

    private ehy(Parcel parcel) {
        super(parcel);
        this.dEM = (Period) parcel.readValue(Iso8601PeriodFormat.class.getClassLoader());
        this.dHM = (Date) parcel.readValue(Date.class.getClassLoader());
        this.dHN = (Date) parcel.readValue(Date.class.getClassLoader());
        this.dHO = (Date) parcel.readValue(Date.class.getClassLoader());
        this.dHP = (Date) parcel.readValue(Date.class.getClassLoader());
        this.dHQ = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.dFh = parcel.readString();
        this.name = parcel.readString();
        this.dEO = (ehs) parcel.readParcelable(ehs.class.getClassLoader());
    }

    public ece<ehx> aCt() {
        eiu lA = lA("self");
        if (lA == null) {
            return null;
        }
        return new eiv(lA.getId(), lA.getHref());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeValue(this.dEM);
        parcel.writeValue(this.dHM);
        parcel.writeValue(this.dHN);
        parcel.writeValue(this.dHO);
        parcel.writeValue(this.dHP);
        parcel.writeValue(this.dHQ);
        parcel.writeString(this.dFh);
        parcel.writeString(this.name);
        parcel.writeParcelable(this.dEO, i);
    }
}
