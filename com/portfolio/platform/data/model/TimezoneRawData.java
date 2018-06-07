package com.portfolio.platform.data.model;

public class TimezoneRawData {
    private String cityName;
    private String countryName;
    private String timeZoneId;
    private String timeZoneName;

    public TimezoneRawData(String str, String str2, String str3, String str4) {
        this.cityName = str;
        this.countryName = str2;
        this.timeZoneId = str3;
        this.timeZoneName = str4;
    }

    public String getCityName() {
        return this.cityName;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public String getTimeZoneId() {
        return this.timeZoneId;
    }

    public String getTimeZoneName() {
        return this.timeZoneName;
    }
}
