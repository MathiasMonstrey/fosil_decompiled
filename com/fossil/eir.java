package com.fossil;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class eir implements Parcelable, ecg {
    public static Creator<eir> CREATOR = new C34151();
    private String dEz;
    private String dIw;
    private String dIx;
    private String dIy;

    static class C34151 implements Creator<eir> {
        C34151() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return aS(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return ol(i);
        }

        public eir aS(Parcel parcel) {
            return new eir(parcel);
        }

        public eir[] ol(int i) {
            return new eir[i];
        }
    }

    public static class C3416a {
        private String dEz;
        private String dIw;
        private String dIx;
        private String dIy;

        public C3416a lE(String str) {
            this.dIw = str;
            return this;
        }

        public C3416a lF(String str) {
            this.dIx = str;
            return this;
        }

        public C3416a lG(String str) {
            this.dIy = str;
            return this;
        }

        public eir aDv() {
            eir com_fossil_eir = new eir();
            com_fossil_eir.dIw = this.dIw;
            com_fossil_eir.dIx = this.dIx;
            com_fossil_eir.dIy = this.dIy;
            com_fossil_eir.dEz = this.dEz;
            return com_fossil_eir;
        }
    }

    class C3417b extends eim {
        final /* synthetic */ eir dIz;

        public C3417b(eir com_fossil_eir, String str) {
            this.dIz = com_fossil_eir;
            super(str);
        }

        public C3417b om(int i) {
            m10614O("width_px", i);
            return this;
        }

        public C3417b on(int i) {
            m10614O("height_px", i);
            return this;
        }
    }

    public String aCu() {
        if (this.dIw == null) {
            this.dIw = cp(100, 100);
        }
        return this.dIw;
    }

    public String aCv() {
        if (this.dIx == null) {
            this.dIx = cp(250, 250);
        }
        return this.dIx;
    }

    public String aCw() {
        if (this.dIy == null) {
            this.dIy = cp(600, 600);
        }
        return this.dIy;
    }

    public String cp(int i, int i2) {
        if (this.dEz != null) {
            return new C3417b(this, this.dEz).om(i).on(i2).getHref();
        }
        if (this.dIy != null) {
            return this.dIy;
        }
        if (this.dIx != null) {
            return this.dIx;
        }
        if (this.dIw != null) {
            return this.dIw;
        }
        return null;
    }

    public static C3416a aDu() {
        return new C3416a();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.dIw);
        parcel.writeString(this.dIx);
        parcel.writeString(this.dIy);
        parcel.writeString(this.dEz);
    }

    private eir(Parcel parcel) {
        this.dIw = parcel.readString();
        this.dIx = parcel.readString();
        this.dIy = parcel.readString();
        this.dEz = parcel.readString();
    }
}
