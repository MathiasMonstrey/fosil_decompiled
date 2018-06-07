package com.fossil;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class eee implements Parcelable {
    public static final Creator<eee> CREATOR = new C33361();
    @cga("facebook")
    Boolean dED;
    @cga("twitter")
    Boolean dEE;

    static class C33361 implements Creator<eee> {
        C33361() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m10568R(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return nh(i);
        }

        public eee m10568R(Parcel parcel) {
            return new eee(parcel);
        }

        public eee[] nh(int i) {
            return new eee[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.dED);
        parcel.writeValue(this.dEE);
    }

    private eee(Parcel parcel) {
        this.dED = (Boolean) parcel.readValue(null);
        this.dEE = (Boolean) parcel.readValue(null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        eee com_fossil_eee = (eee) obj;
        if (this.dED == null ? com_fossil_eee.dED != null : !this.dED.equals(com_fossil_eee.dED)) {
            return false;
        }
        if (this.dEE != null) {
            if (this.dEE.equals(com_fossil_eee.dEE)) {
                return true;
            }
        } else if (com_fossil_eee.dEE == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        if (this.dED != null) {
            hashCode = this.dED.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode *= 31;
        if (this.dEE != null) {
            i = this.dEE.hashCode();
        }
        return hashCode + i;
    }
}
