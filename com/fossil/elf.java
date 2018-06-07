package com.fossil;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class elf extends eil implements Parcelable, eld {
    public static Creator<elf> CREATOR = new C34471();
    private String dLC;
    private String dLD;
    private String dLE;
    private transient ece<eld> dLF;

    static class C34471 implements Creator<elf> {
        C34471() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return bq(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return oO(i);
        }

        public elf bq(Parcel parcel) {
            return new elf(parcel);
        }

        public elf[] oO(int i) {
            return new elf[i];
        }
    }

    public /* synthetic */ ecj aCy() {
        return aCt();
    }

    public ece<eld> aCt() {
        if (this.dLF == null) {
            List lz = lz("self");
            if (lz == null || lz.isEmpty()) {
                return null;
            }
            this.dLF = new eiv(((eiu) lz.get(0)).getId(), ((eiu) lz.get(0)).getHref());
        }
        return this.dLF;
    }

    public String aEJ() {
        if (this.dLC == null) {
            this.dLC = lz("small") != null ? ((eiu) lz("small").get(0)).getHref() : null;
        }
        return this.dLC;
    }

    public String aEK() {
        if (this.dLD == null) {
            this.dLD = lz("medium") != null ? ((eiu) lz("medium").get(0)).getHref() : null;
        }
        return this.dLD;
    }

    public String aEL() {
        if (this.dLE == null) {
            this.dLE = lz("large") != null ? ((eiu) lz("large").get(0)).getHref() : null;
        }
        return this.dLE;
    }

    public void m10861e(ece<eld> com_fossil_ece_com_fossil_eld) {
        this.dLF = com_fossil_ece_com_fossil_eld;
    }

    public void mc(String str) {
        this.dLC = str;
    }

    public void md(String str) {
        this.dLD = str;
    }

    public void me(String str) {
        this.dLE = str;
    }

    public eir aEM() {
        return eir.aDu().lE(aEJ()).lF(aEK()).lG(aEL()).aDv();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.dLC);
        parcel.writeString(this.dLD);
        parcel.writeString(this.dLE);
    }

    private elf(Parcel parcel) {
        super(parcel);
        this.dLC = parcel.readString();
        this.dLD = parcel.readString();
        this.dLE = parcel.readString();
    }
}
