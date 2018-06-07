package com.portfolio.platform.data.model.microapp;

public enum CommuteTimeSettings$TIME_FORMAT {
    TRAVEL("travel"),
    ETA("eta");
    
    String mValue;

    private CommuteTimeSettings$TIME_FORMAT(String str) {
        this.mValue = str;
    }

    public String getValue() {
        return this.mValue;
    }

    public static CommuteTimeSettings$TIME_FORMAT getTimeFormat(String str) {
        for (CommuteTimeSettings$TIME_FORMAT commuteTimeSettings$TIME_FORMAT : values()) {
            if (commuteTimeSettings$TIME_FORMAT.getValue().equals(str)) {
                return commuteTimeSettings$TIME_FORMAT;
            }
        }
        return ETA;
    }
}
