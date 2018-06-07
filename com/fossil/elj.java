package com.fossil;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class elj implements Parcelable, ece<eld> {
    public static final Creator<elj> CREATOR = new C34481();
    private final String href;
    private final String id;

    static class C34481 implements Creator<elj> {
        C34481() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return br(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return oP(i);
        }

        public elj br(Parcel parcel) {
            return new elj(parcel);
        }

        public elj[] oP(int i) {
            return new elj[i];
        }
    }

    public static class C3449a extends eim {
        private String id;

        private C3449a() {
            super("/v7.0/user_profile_photo/{id}/");
        }

        public C3449a mf(String str) {
            this.id = str;
            bi("id", str);
            return this;
        }

        public elj aEO() {
            return new elj();
        }
    }

    private elj(C3449a c3449a) {
        this.id = c3449a.id;
        this.href = c3449a.getHref();
    }

    public static C3449a aEN() {
        return new C3449a();
    }

    public String getId() {
        return this.id;
    }

    public String getHref() {
        return this.href;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.href);
    }

    private elj(Parcel parcel) {
        this.id = parcel.readString();
        this.href = parcel.readString();
    }
}
