package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class ehb extends eil implements eha {
    public static final Creator<ehb> CREATOR = new C33921();
    @cga("description")
    String description;
    @cga("manufacturer")
    String manufacturer;
    @cga("model")
    String model;
    @cga("name")
    String name;

    static class C33921 implements Creator<ehb> {
        C33921() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return aB(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return nT(i);
        }

        public ehb aB(Parcel parcel) {
            return new ehb(parcel);
        }

        public ehb[] nT(int i) {
            return new ehb[i];
        }
    }

    public /* synthetic */ ecj aCy() {
        return aCt();
    }

    public ece aCt() {
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
        parcel.writeString(this.name);
        parcel.writeString(this.manufacturer);
        parcel.writeString(this.description);
        parcel.writeString(this.model);
    }

    private ehb(Parcel parcel) {
        this.name = parcel.readString();
        this.manufacturer = parcel.readString();
        this.description = parcel.readString();
        this.model = parcel.readString();
    }
}
