package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class ehj extends eil implements ehi {
    public static final Creator<ehj> CREATOR = new C33961();
    @cga("purchase_date")
    ech dHA;
    @cga("current_distance")
    Double dHB;
    @cga("retired")
    Boolean dHC;
    @cga("gear")
    ehe dHx;
    @cga("initial_distance")
    Double dHy;
    @cga("target_distance")
    Double dHz;
    @cga("name")
    String name;

    static class C33961 implements Creator<ehj> {
        C33961() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return aF(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return nX(i);
        }

        public ehj aF(Parcel parcel) {
            return new ehj(parcel);
        }

        public ehj[] nX(int i) {
            return new ehj[i];
        }
    }

    public /* synthetic */ ece aCt() {
        return aDh();
    }

    public /* synthetic */ ecj aCy() {
        return aDh();
    }

    public ehe aDf() {
        return this.dHx;
    }

    public List<ece<efn>> aDg() {
        List<eiu> lz = lz("default_activities");
        if (lz == null) {
            return null;
        }
        List<ece<efn>> arrayList = new ArrayList(lz.size());
        for (eiu com_fossil_eiu : lz) {
            arrayList.add(new eiv(com_fossil_eiu.getId(), com_fossil_eiu.getHref()));
        }
        return arrayList;
    }

    public ehk aDh() {
        eiu lA = lA("self");
        if (lA == null) {
            return null;
        }
        return new ehk(lA.getId(), lA.getHref());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.dHx, 0);
        parcel.writeString(this.name);
        parcel.writeValue(this.dHy);
        parcel.writeValue(this.dHz);
        parcel.writeParcelable(this.dHA, 0);
        parcel.writeValue(this.dHB);
        parcel.writeValue(this.dHC);
    }

    private ehj(Parcel parcel) {
        super(parcel);
        this.dHx = (ehe) parcel.readParcelable(ehe.class.getClassLoader());
        this.name = parcel.readString();
        this.dHy = (Double) parcel.readValue(Double.class.getClassLoader());
        this.dHz = (Double) parcel.readValue(Double.class.getClassLoader());
        this.dHA = (ech) parcel.readParcelable(ech.class.getClassLoader());
        this.dHB = (Double) parcel.readValue(Double.class.getClassLoader());
        this.dHC = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
    }
}
