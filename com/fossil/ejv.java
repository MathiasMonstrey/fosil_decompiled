package com.fossil;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class ejv extends eil implements Parcelable, eju {
    public static Creator<ejv> CREATOR = new C34261();
    private String dDM;
    private String dJA;
    private String dJB;
    private String dJu;
    private String dJv;
    private String dJw;
    private String dJx;
    private String dJy;
    private String dJz;
    private String name;
    private String type;

    static class C34261 implements Creator<ejv> {
        C34261() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return bd(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return oB(i);
        }

        public ejv bd(Parcel parcel) {
            return new ejv(parcel);
        }

        public ejv[] oB(int i) {
            return new ejv[i];
        }
    }

    public /* synthetic */ ecj aCy() {
        return aCt();
    }

    protected ejv() {
    }

    public ece<eju> aCt() {
        List lz = lz("self");
        if (lz == null || lz.isEmpty()) {
            return null;
        }
        return new eiv(((eiu) lz.get(0)).getId(), ((eiu) lz.get(0)).getHref());
    }

    public int describeContents() {
        return 0;
    }

    public String aCM() {
        return this.dDM;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void lM(String str) {
        this.dDM = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void lN(String str) {
        this.dJu = str;
    }

    public void lO(String str) {
        this.dJv = str;
    }

    public void lP(String str) {
        this.dJw = str;
    }

    public void lQ(String str) {
        this.dJx = str;
    }

    public void lR(String str) {
        this.dJy = str;
    }

    public void lS(String str) {
        this.dJz = str;
    }

    public void lT(String str) {
        this.dJA = str;
    }

    public void lU(String str) {
        this.dJB = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.type);
        parcel.writeString(this.dDM);
        parcel.writeString(this.name);
        parcel.writeString(this.dJu);
        parcel.writeString(this.dJv);
        parcel.writeString(this.dJw);
        parcel.writeString(this.dJx);
        parcel.writeString(this.dJy);
        parcel.writeString(this.dJz);
        parcel.writeString(this.dJA);
        parcel.writeString(this.dJB);
    }

    private ejv(Parcel parcel) {
        super(parcel);
        this.type = parcel.readString();
        this.dDM = parcel.readString();
        this.name = parcel.readString();
        this.dJu = parcel.readString();
        this.dJv = parcel.readString();
        this.dJw = parcel.readString();
        this.dJx = parcel.readString();
        this.dJy = parcel.readString();
        this.dJz = parcel.readString();
        this.dJA = parcel.readString();
        this.dJB = parcel.readString();
    }
}
