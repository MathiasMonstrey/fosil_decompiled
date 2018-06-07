package com.fossil;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class ecu implements Parcelable, ect {
    public static Creator<ecu> CREATOR = new C33191();
    private List<String> dDI;
    private List<String> dDJ;

    static class C33191 implements Creator<ecu> {
        C33191() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m10494H(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return mY(i);
        }

        public ecu m10494H(Parcel parcel) {
            return new ecu(parcel);
        }

        public ecu[] mY(int i) {
            return new ecu[i];
        }
    }

    public List<String> aCE() {
        return this.dDJ;
    }

    public List<String> aCF() {
        return this.dDI;
    }

    public void aE(List<String> list) {
        this.dDI = list;
    }

    public void aF(List<String> list) {
        this.dDJ = list;
    }

    public ecj aCy() {
        return null;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(this.dDI);
        parcel.writeStringList(this.dDJ);
    }

    private ecu(Parcel parcel) {
        parcel.readStringList(this.dDI);
        parcel.readStringList(this.dDJ);
    }
}
