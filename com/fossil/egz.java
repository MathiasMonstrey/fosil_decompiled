package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class egz extends eil implements egy {
    public static final Creator<egz> CREATOR = new C33901();
    @cga("device")
    eha dHc;
    @cga("name")
    String name;

    static class C33901 implements Creator<egz> {
        C33901() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return aA(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return nS(i);
        }

        public egz aA(Parcel parcel) {
            return new egz(parcel);
        }

        public egz[] nS(int i) {
            return new egz[i];
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

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        egz com_fossil_egz = (egz) obj;
        if (this.name != null) {
            if (this.name.equals(com_fossil_egz.name)) {
                return true;
            }
        } else if (com_fossil_egz.name == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.name != null ? this.name.hashCode() : 0;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.dHc, i);
        parcel.writeString(this.name);
    }

    private egz(Parcel parcel) {
        this.dHc = (eha) parcel.readParcelable(eha.class.getClassLoader());
        this.name = parcel.readString();
    }
}
