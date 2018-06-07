package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class eef extends eil implements eco {
    public static Creator<eef> CREATOR = new C33371();
    @cga("site_name")
    String dEF;
    @cga("id")
    String id;
    @cga("site_url")
    String url;

    static class C33371 implements Creator<eef> {
        C33371() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m10569S(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return ni(i);
        }

        public eef m10569S(Parcel parcel) {
            return new eef(parcel);
        }

        public eef[] ni(int i) {
            return new eef[i];
        }
    }

    public /* synthetic */ ecj aCy() {
        return aCt();
    }

    public ece<eco> aCt() {
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
        parcel.writeString(this.id);
        parcel.writeString(this.url);
        parcel.writeString(this.dEF);
    }

    private eef(Parcel parcel) {
        super(parcel);
        this.id = parcel.readString();
        this.url = parcel.readString();
        this.dEF = parcel.readString();
    }
}
