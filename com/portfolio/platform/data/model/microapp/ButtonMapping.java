package com.portfolio.platform.data.model.microapp;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ButtonMapping implements Parcelable, Comparable {
    public static final String APP_ID = "appId";
    public static final String BUTTON = "button";
    public static final Creator<ButtonMapping> CREATOR = new C47401();
    private String button;
    private String microAppId;

    static class C47401 implements Creator<ButtonMapping> {
        C47401() {
        }

        public ButtonMapping createFromParcel(Parcel parcel) {
            return new ButtonMapping(parcel);
        }

        public ButtonMapping[] newArray(int i) {
            return new ButtonMapping[i];
        }
    }

    public ButtonMapping(String str, String str2) {
        this.button = str;
        this.microAppId = str2;
    }

    public ButtonMapping(ButtonMapping buttonMapping) {
        this.button = buttonMapping.getButton();
        this.microAppId = buttonMapping.getMicroAppId();
    }

    protected ButtonMapping(Parcel parcel) {
        this.button = parcel.readString();
        this.microAppId = parcel.readString();
    }

    public String getButton() {
        return this.button;
    }

    public void setButton(String str) {
        this.button = str;
    }

    public String getMicroAppId() {
        return this.microAppId;
    }

    public void setMicroAppId(String str) {
        this.microAppId = str;
    }

    public int describeContents() {
        return 0;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return 1;
        }
        if (obj instanceof ButtonMapping) {
            return ((ButtonMapping) obj).button.equals(((ButtonMapping) obj).button) ? 0 : 1;
        } else {
            return 1;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.button);
        parcel.writeString(this.microAppId);
    }
}
