package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class eia extends eil implements ehz {
    public static Creator<eia> CREATOR = new C34071();
    @cga("purpose")
    String dHS;
    @cga("restrict_membership")
    Boolean dHT;

    static class C34071 implements Creator<eia> {
        C34071() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return aO(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return og(i);
        }

        public eia aO(Parcel parcel) {
            return new eia(parcel);
        }

        public eia[] og(int i) {
            return new eia[i];
        }
    }

    public /* synthetic */ ecj aCy() {
        return aCt();
    }

    private eia(Parcel parcel) {
        super(parcel);
        this.dHS = parcel.readString();
        this.dHT = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
    }

    public ece<ehz> aCt() {
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
        parcel.writeString(this.dHS);
        parcel.writeValue(this.dHT);
    }
}
