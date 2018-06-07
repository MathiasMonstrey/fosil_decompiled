package com.portfolio.platform.data.model.microapp.weather;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fossil.cga;
import com.google.android.gms.maps.model.LatLng;

public class WeatherSettings implements Parcelable {
    public static final Creator<WeatherSettings> CREATOR = new 1();
    @cga("forecastType")
    private DISPLAY_FORMAT mDisplayFormat;
    @cga("useCurrentLocation")
    private boolean mIsUseCurrentLocation;
    private LatLng mLatLng;
    @cga("area")
    private String mLocation;
    @cga("unit")
    private TEMP_UNIT mTempUnit;

    public WeatherSettings(String str, TEMP_UNIT temp_unit, DISPLAY_FORMAT display_format) {
        this.mLocation = str;
        this.mTempUnit = temp_unit;
        this.mDisplayFormat = display_format;
    }

    public WeatherSettings() {
        this.mLocation = "";
        this.mTempUnit = TEMP_UNIT.CELSIUS;
        this.mDisplayFormat = DISPLAY_FORMAT.CURRENT_TEMP;
    }

    protected WeatherSettings(Parcel parcel) {
        this.mLocation = parcel.readString();
        this.mTempUnit = TEMP_UNIT.getTempUnit(parcel.readString());
        this.mDisplayFormat = DISPLAY_FORMAT.getDisplayFormat(parcel.readInt());
        this.mIsUseCurrentLocation = Boolean.valueOf(parcel.readString()).booleanValue();
        this.mLatLng = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
    }

    public String getLocation() {
        return this.mLocation;
    }

    public TEMP_UNIT getTempUnit() {
        return this.mTempUnit;
    }

    public DISPLAY_FORMAT getDisplayFormat() {
        return this.mDisplayFormat;
    }

    public void setLocation(String str) {
        this.mLocation = str;
    }

    public void setTempUnit(TEMP_UNIT temp_unit) {
        this.mTempUnit = temp_unit;
    }

    public void setDisplayFormat(DISPLAY_FORMAT display_format) {
        this.mDisplayFormat = display_format;
    }

    public boolean isUseCurrentLocation() {
        return this.mIsUseCurrentLocation;
    }

    public void setIsUseCurrentLocation(boolean z) {
        this.mIsUseCurrentLocation = z;
    }

    public LatLng getLatLng() {
        return this.mLatLng;
    }

    public void setLatLng(LatLng latLng) {
        this.mLatLng = latLng;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mLocation);
        parcel.writeString(this.mTempUnit.getValue());
        parcel.writeInt(this.mDisplayFormat.getValue());
        parcel.writeString(String.valueOf(this.mIsUseCurrentLocation));
        parcel.writeParcelable(this.mLatLng, 0);
    }
}
