package com.fossil;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ekc implements Parcelable, ece<eju> {
    public static final Creator<ekc> CREATOR = new C34281();
    private final String dDM;
    private final String href;
    private final String id;

    static class C34281 implements Creator<ekc> {
        C34281() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return bf(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return oD(i);
        }

        public ekc bf(Parcel parcel) {
            return new ekc(parcel);
        }

        public ekc[] oD(int i) {
            return new ekc[i];
        }
    }

    public static class C3429a extends eim {
        String dDM;
        String id;

        private C3429a() {
            super("/v7.0/remoteconnectiontype/{id}/");
        }

        public C3429a lV(String str) {
            this.id = str;
            bi("id", str);
            return this;
        }

        public C3429a lW(String str) {
            this.dDM = str;
            return this;
        }

        public ekc aEd() {
            ekc com_fossil_ekc;
            synchronized (ekc.class) {
                com_fossil_ekc = new ekc();
            }
            return com_fossil_ekc;
        }
    }

    private ekc(C3429a c3429a) {
        this.id = c3429a.id;
        this.href = c3429a.getHref();
        this.dDM = c3429a.dDM;
    }

    public static C3429a aEc() {
        return new C3429a();
    }

    public String getId() {
        return this.id;
    }

    public String getHref() {
        return this.href;
    }

    public String aCM() {
        return this.dDM;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.href);
        parcel.writeString(this.dDM);
    }

    private ekc(Parcel parcel) {
        this.id = parcel.readString();
        this.href = parcel.readString();
        this.dDM = parcel.readString();
    }
}
