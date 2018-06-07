package com.portfolio.platform.data.model.microapp.weather;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class WeatherSettings$1 implements Creator<WeatherSettings> {
    WeatherSettings$1() {
    }

    public WeatherSettings createFromParcel(Parcel parcel) {
        return new WeatherSettings(parcel);
    }

    public WeatherSettings[] newArray(int i) {
        return new WeatherSettings[i];
    }
}
