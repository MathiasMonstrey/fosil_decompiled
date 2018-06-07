package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Date;

public class egg extends eil implements egf {
    public static Creator<egg> CREATOR = new C33861();
    @cga("datetime_timezone")
    String dGA;
    @cga("created_datetime")
    Date dGB;
    @cga("updated_datetime")
    Date dGC;
    @cga("recorder_type_key")
    String dGD;
    @cga("reference_key")
    String dGE;
    @cga("mass")
    String dGF;
    @cga("bmi")
    String dGG;
    @cga("fat_percent")
    String dGH;
    @cga("lean_mass")
    String dGI;
    @cga("fat_mass")
    String dGJ;
    @cga("datetime_utc")
    Date dGz;

    static class C33861 implements Creator<egg> {
        C33861() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return az(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return nP(i);
        }

        public egg az(Parcel parcel) {
            return new egg(parcel);
        }

        public egg[] nP(int i) {
            return new egg[i];
        }
    }

    public /* synthetic */ ecj aCy() {
        return aCt();
    }

    private egg(Parcel parcel) {
        super(parcel);
        this.dGz = (Date) parcel.readValue(Date.class.getClassLoader());
        this.dGA = parcel.readString();
        this.dGB = (Date) parcel.readValue(Date.class.getClassLoader());
        this.dGC = (Date) parcel.readValue(Date.class.getClassLoader());
        this.dGD = parcel.readString();
        this.dGE = parcel.readString();
        this.dGF = parcel.readString();
        this.dGG = parcel.readString();
        this.dGH = parcel.readString();
        this.dGI = parcel.readString();
        this.dGJ = parcel.readString();
    }

    public ece<egf> aCt() {
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
        parcel.writeValue(this.dGz);
        parcel.writeString(this.dGA);
        parcel.writeValue(this.dGB);
        parcel.writeValue(this.dGC);
        parcel.writeString(this.dGD);
        parcel.writeString(this.dGE);
        parcel.writeString(this.dGF);
        parcel.writeString(this.dGG);
        parcel.writeString(this.dGH);
        parcel.writeString(this.dGI);
        parcel.writeString(this.dGJ);
    }
}
