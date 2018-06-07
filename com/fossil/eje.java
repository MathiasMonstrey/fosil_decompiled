package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class eje implements ejd {
    public static Creator<eje> CREATOR = new C34211();
    @cga("address")
    String address;
    @cga("country")
    String country;
    @cga("region")
    String dJg;
    @cga("locality")
    String dJh;

    static class C34211 implements Creator<eje> {
        C34211() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return aX(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return ot(i);
        }

        public eje aX(Parcel parcel) {
            return new eje(parcel);
        }

        public eje[] ot(int i) {
            return new eje[i];
        }
    }

    public eje(String str, String str2, String str3, String str4) {
        this.country = str;
        this.dJg = str2;
        this.dJh = str3;
        this.address = str4;
    }

    public String getCountry() {
        return this.country;
    }

    public void lJ(String str) {
        this.country = str;
    }

    public String aDW() {
        return this.dJg;
    }

    public void lK(String str) {
        this.dJg = str;
    }

    public String getLocality() {
        return this.dJh;
    }

    public void setLocality(String str) {
        this.dJh = str;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.country);
        parcel.writeString(this.dJg);
        parcel.writeString(this.dJh);
        parcel.writeString(this.address);
    }

    private eje(Parcel parcel) {
        this.country = parcel.readString();
        this.dJg = parcel.readString();
        this.dJh = parcel.readString();
        this.address = parcel.readString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof eje)) {
            return false;
        }
        eje com_fossil_eje = (eje) obj;
        if (this.address == null ? com_fossil_eje.address != null : !this.address.equals(com_fossil_eje.address)) {
            return false;
        }
        if (this.country == null ? com_fossil_eje.country != null : !this.country.equals(com_fossil_eje.country)) {
            return false;
        }
        if (this.dJh == null ? com_fossil_eje.dJh != null : !this.dJh.equals(com_fossil_eje.dJh)) {
            return false;
        }
        if (this.dJg != null) {
            if (this.dJg.equals(com_fossil_eje.dJg)) {
                return true;
            }
        } else if (com_fossil_eje.dJg == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        if (this.country != null) {
            hashCode = this.country.hashCode();
        } else {
            hashCode = 0;
        }
        int i2 = hashCode * 31;
        if (this.dJg != null) {
            hashCode = this.dJg.hashCode();
        } else {
            hashCode = 0;
        }
        i2 = (hashCode + i2) * 31;
        if (this.dJh != null) {
            hashCode = this.dJh.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode = (hashCode + i2) * 31;
        if (this.address != null) {
            i = this.address.hashCode();
        }
        return hashCode + i;
    }
}
