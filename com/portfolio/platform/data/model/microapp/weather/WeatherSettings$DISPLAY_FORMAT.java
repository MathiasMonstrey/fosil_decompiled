package com.portfolio.platform.data.model.microapp.weather;

public enum WeatherSettings$DISPLAY_FORMAT {
    MIN(2),
    MAX(1),
    RANGE(3),
    CURRENT_TEMP(0);
    
    private int mValue;

    private WeatherSettings$DISPLAY_FORMAT(int i) {
        this.mValue = i;
    }

    public int getValue() {
        return this.mValue;
    }

    public static WeatherSettings$DISPLAY_FORMAT getDisplayFormat(int i) {
        for (WeatherSettings$DISPLAY_FORMAT weatherSettings$DISPLAY_FORMAT : values()) {
            if (weatherSettings$DISPLAY_FORMAT.getValue() == i) {
                return weatherSettings$DISPLAY_FORMAT;
            }
        }
        return CURRENT_TEMP;
    }
}
