package com.portfolio.platform.data.model.microapp.weather;

public enum WeatherSettings$TEMP_UNIT {
    CELSIUS("c"),
    FARIENHEIT("f");
    
    String mValue;

    private WeatherSettings$TEMP_UNIT(String str) {
        this.mValue = str;
    }

    public String getValue() {
        return this.mValue;
    }

    public static WeatherSettings$TEMP_UNIT getTempUnit(String str) {
        for (WeatherSettings$TEMP_UNIT weatherSettings$TEMP_UNIT : values()) {
            if (weatherSettings$TEMP_UNIT.getValue().equals(str)) {
                return weatherSettings$TEMP_UNIT;
            }
        }
        return CELSIUS;
    }
}
