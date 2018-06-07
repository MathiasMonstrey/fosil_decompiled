package com.fossil;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class egc implements Parcelable, egb {
    public static final Creator<egc> CREATOR = new C33851();
    private String accessToken;
    private Long dGx;
    private String refreshToken;

    static class C33851 implements Creator<egc> {
        C33851() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return ay(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return nO(i);
        }

        public egc ay(Parcel parcel) {
            return new egc(parcel);
        }

        public egc[] nO(int i) {
            return new egc[i];
        }
    }

    public ecj aCy() {
        return null;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public Long aDa() {
        return this.dGx;
    }

    public void mo2855e(Long l) {
        this.dGx = l;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    public void setRefreshToken(String str) {
        this.refreshToken = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.accessToken);
        parcel.writeValue(this.dGx);
        parcel.writeString(this.refreshToken);
    }

    private egc(Parcel parcel) {
        this.accessToken = parcel.readString();
        this.dGx = (Long) parcel.readValue(Long.class.getClassLoader());
        this.refreshToken = parcel.readString();
    }
}
