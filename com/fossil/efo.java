package com.fossil;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Date;

public class efo extends eil implements Parcelable, efn {
    public static Creator<efo> CREATOR = new C33701();
    private String dFS;
    private String dFT;
    private Date dFU;
    private String dFV;
    private Double dFW;
    private String dFX;
    private Boolean dFY;
    private String mName;

    static class C33701 implements Creator<efo> {
        C33701() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return at(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return nJ(i);
        }

        public efo at(Parcel parcel) {
            return new efo(parcel);
        }

        public efo[] nJ(int i) {
            return new efo[i];
        }
    }

    public /* synthetic */ ece aCt() {
        return aCS();
    }

    public /* synthetic */ ecj aCy() {
        return aCS();
    }

    protected efo() {
    }

    protected efo(String str, String str2, String str3, String str4, Double d, String str5, Boolean bool, Date date) {
        Double valueOf;
        Date date2 = null;
        this.dFS = str;
        this.dFT = str2;
        this.mName = str3;
        this.dFV = str4;
        if (d != null) {
            valueOf = Double.valueOf(d.doubleValue());
        } else {
            valueOf = null;
        }
        this.dFW = valueOf;
        this.dFX = str5;
        this.dFY = bool;
        if (date != null) {
            date2 = new Date(date.getTime());
        }
        this.dFU = date2;
    }

    public efp aCS() {
        String id;
        eiu lA = lA("self");
        if (lA != null) {
            id = lA.getId();
        } else {
            id = null;
        }
        if (id == null) {
            return null;
        }
        return efp.aCT().lv(id).aT(this.dIl).aCU();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.dFS);
        parcel.writeString(this.dFT);
        parcel.writeLong(this.dFU != null ? this.dFU.getTime() : -1);
        parcel.writeString(this.mName);
        parcel.writeString(this.dFV);
        parcel.writeValue(this.dFW);
        parcel.writeString(this.dFX);
        parcel.writeValue(this.dFY);
    }

    private efo(Parcel parcel) {
        super(parcel);
        this.dFS = parcel.readString();
        this.dFT = parcel.readString();
        long readLong = parcel.readLong();
        this.dFU = readLong == -1 ? null : new Date(readLong);
        this.mName = parcel.readString();
        this.dFV = parcel.readString();
        this.dFW = (Double) parcel.readValue(Double.class.getClassLoader());
        this.dFX = parcel.readString();
        this.dFY = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
    }
}
