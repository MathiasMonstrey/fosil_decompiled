package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class ehh extends eil implements ehg {
    public static final Creator<ehh> CREATOR = new C33951();
    @cga("gear_type_id")
    String dHu;
    @cga("popular")
    Boolean dHv;
    @cga("brand")
    String dHw;

    static class C33951 implements Creator<ehh> {
        C33951() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return aE(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return nW(i);
        }

        public ehh aE(Parcel parcel) {
            return new ehh(parcel);
        }

        public ehh[] nW(int i) {
            return new ehh[i];
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
        super.writeToParcel(parcel, i);
        parcel.writeString(this.dHu);
        parcel.writeValue(this.dHv);
        parcel.writeString(this.dHw);
    }

    private ehh(Parcel parcel) {
        super(parcel);
        this.dHu = parcel.readString();
        this.dHv = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.dHw = parcel.readString();
    }
}
