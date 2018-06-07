package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class eho extends eil implements ehn {
    public static Creator<eho> CREATOR = new C33991();
    @cga("email")
    String email;

    static class C33991 implements Creator<eho> {
        C33991() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return aI(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return oa(i);
        }

        public eho aI(Parcel parcel) {
            return new eho(parcel);
        }

        public eho[] oa(int i) {
            return new eho[i];
        }
    }

    public /* synthetic */ ecj aCy() {
        return aCt();
    }

    private eho(Parcel parcel) {
        super(parcel);
        this.email = parcel.readString();
    }

    public ece<ehn> aCt() {
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
        parcel.writeString(this.email);
    }
}
