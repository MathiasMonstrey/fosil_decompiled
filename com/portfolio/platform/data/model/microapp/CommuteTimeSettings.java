package com.portfolio.platform.data.model.microapp;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fossil.cga;

public class CommuteTimeSettings implements Parcelable {
    public static final Creator<CommuteTimeSettings> CREATOR = new 1();
    @cga("destinationAddress")
    private String mDestination;
    @cga("avoidTolls")
    private boolean mIsAvoidTolls;
    @cga("locationType")
    private LOCATION_TYPE mLocationType;
    @cga("formatType")
    private TIME_FORMAT mTimeFormat;

    public CommuteTimeSettings() {
        this.mDestination = "";
        this.mTimeFormat = TIME_FORMAT.ETA;
        this.mIsAvoidTolls = false;
        this.mLocationType = LOCATION_TYPE.WORK;
    }

    public CommuteTimeSettings(CommuteTimeSettings commuteTimeSettings) {
        this.mDestination = commuteTimeSettings.mDestination;
        this.mTimeFormat = commuteTimeSettings.mTimeFormat;
        this.mIsAvoidTolls = commuteTimeSettings.mIsAvoidTolls;
        this.mLocationType = commuteTimeSettings.mLocationType;
    }

    private CommuteTimeSettings(Parcel parcel) {
        this.mDestination = parcel.readString();
        this.mTimeFormat = TIME_FORMAT.getTimeFormat(parcel.readString());
        this.mIsAvoidTolls = Boolean.valueOf(parcel.readString()).booleanValue();
        this.mLocationType = LOCATION_TYPE.getLocationType(parcel.readInt());
    }

    public TIME_FORMAT getTimeFormat() {
        return this.mTimeFormat;
    }

    public String getDestination() {
        return this.mDestination;
    }

    public boolean isIsAvoidTolls() {
        return this.mIsAvoidTolls;
    }

    public void setDestination(String str) {
        this.mDestination = str;
    }

    public void setTimeFormat(TIME_FORMAT time_format) {
        this.mTimeFormat = time_format;
    }

    public void setIsAvoidTolls(boolean z) {
        this.mIsAvoidTolls = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mDestination);
        parcel.writeString(this.mTimeFormat.getValue());
        parcel.writeString(String.valueOf(this.mIsAvoidTolls));
        parcel.writeInt(this.mLocationType.getValue());
    }
}
