package com.portfolio.platform.data.model.microapp;

public enum CommuteTimeSettings$LOCATION_TYPE {
    HOME(0),
    WORK(1);
    
    int mValue;

    private CommuteTimeSettings$LOCATION_TYPE(int i) {
        this.mValue = i;
    }

    public int getValue() {
        return this.mValue;
    }

    public static CommuteTimeSettings$LOCATION_TYPE getLocationType(int i) {
        for (CommuteTimeSettings$LOCATION_TYPE commuteTimeSettings$LOCATION_TYPE : values()) {
            if (commuteTimeSettings$LOCATION_TYPE.getValue() == i) {
                return commuteTimeSettings$LOCATION_TYPE;
            }
        }
        return WORK;
    }
}
