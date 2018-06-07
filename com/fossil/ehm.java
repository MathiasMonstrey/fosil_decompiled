package com.fossil;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ehm extends eil implements Parcelable, ehl {
    public static final Creator<ehm> CREATOR = new C33981();
    @cga("is_public")
    private Boolean dHD;
    @cga("invitation_required")
    private Boolean dHE;
    @cga("invitation_code")
    private String dHF;
    @cga("group_objective")
    private ehx dHG;
    @cga("max_users")
    private Integer dHH;
    @cga("description")
    private String description;
    @cga("name")
    private String name;

    static class C33981 implements Creator<ehm> {
        C33981() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return aH(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return nZ(i);
        }

        public ehm aH(Parcel parcel) {
            return new ehm(parcel);
        }

        public ehm[] nZ(int i) {
            return new ehm[i];
        }
    }

    public /* synthetic */ ecj aCy() {
        return aCt();
    }

    public ece<ehm> aCt() {
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
        parcel.writeValue(this.dHD);
        parcel.writeString(this.name);
        parcel.writeString(this.description);
        parcel.writeValue(this.dHE);
        parcel.writeString(this.dHF);
        parcel.writeValue(this.dHG);
        parcel.writeValue(this.dHH);
    }

    private ehm(Parcel parcel) {
        super(parcel);
        this.dHD = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.name = parcel.readString();
        this.description = parcel.readString();
        this.dHE = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.dHF = parcel.readString();
        this.dHG = (ehx) parcel.readValue(ehx.class.getClassLoader());
        this.dHH = (Integer) parcel.readValue(Integer.class.getClassLoader());
    }
}
