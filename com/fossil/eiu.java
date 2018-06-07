package com.fossil;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class eiu implements Parcelable {
    public static Creator<eiu> CREATOR = new C34181();
    @cga("href")
    String dIA;
    @cga("count")
    Integer dIB;
    @cga("iteration")
    Integer dIC;
    @cga("display_name")
    String mDisplayName;
    @cga("id")
    String mId;
    @cga("name")
    String mName;

    static class C34181 implements Creator<eiu> {
        C34181() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return aT(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return oo(i);
        }

        public eiu aT(Parcel parcel) {
            return new eiu(parcel);
        }

        public eiu[] oo(int i) {
            return new eiu[i];
        }
    }

    public eiu(String str, String str2, String str3) {
        this(str, str2, str3, null, null, null);
    }

    public eiu(String str, String str2, String str3, String str4, Integer num, Integer num2) {
        this.dIA = str;
        this.mId = str2;
        this.mName = str3;
        this.dIB = num;
        this.mDisplayName = str4;
        this.dIC = num2;
    }

    public String getHref() {
        return this.dIA;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.dIA);
        parcel.writeString(this.mId);
        parcel.writeString(this.mName);
        parcel.writeValue(this.dIB);
        parcel.writeValue(this.dIC);
    }

    private eiu(Parcel parcel) {
        this.dIA = parcel.readString();
        this.mId = parcel.readString();
        this.mName = parcel.readString();
        this.dIB = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.dIC = (Integer) parcel.readValue(Integer.class.getClassLoader());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        eiu com_fossil_eiu = (eiu) obj;
        if (this.dIB == null ? com_fossil_eiu.dIB != null : !this.dIB.equals(com_fossil_eiu.dIB)) {
            return false;
        }
        if (this.mDisplayName == null ? com_fossil_eiu.mDisplayName != null : !this.mDisplayName.equals(com_fossil_eiu.mDisplayName)) {
            return false;
        }
        if (this.dIA == null) {
            return false;
        }
        if (!this.dIA.equals(com_fossil_eiu.dIA)) {
            return false;
        }
        if (this.mId == null ? com_fossil_eiu.mId != null : !this.mId.equals(com_fossil_eiu.mId)) {
            return false;
        }
        if (this.mName == null ? com_fossil_eiu.mName != null : !this.mName.equals(com_fossil_eiu.mName)) {
            return false;
        }
        if (this.dIC != null) {
            if (this.dIC.equals(com_fossil_eiu.dIC)) {
                return true;
            }
        } else if (com_fossil_eiu.dIC == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        int hashCode2 = (this.dIA != null ? this.dIA.hashCode() : 0) * 31;
        if (this.mId != null) {
            hashCode = this.mId.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.mName != null) {
            hashCode = this.mName.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.dIB != null) {
            hashCode = this.dIB.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.mDisplayName != null) {
            hashCode = this.mDisplayName.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode = (hashCode + hashCode2) * 31;
        if (this.dIC != null) {
            i = this.dIC.hashCode();
        }
        return hashCode + i;
    }
}
