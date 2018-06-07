package com.misfit.frameworks.buttonservice.model.microapp;

import com.misfit.frameworks.buttonservice.model.Alarm;
import com.misfit.frameworks.common.constants.Constants;

public enum MicroAppInstruction$MicroAppID {
    UAPP_HID_MEDIA_CONTROL_MUSIC("music-control", true, false),
    UAPP_HID_MEDIA_VOL_UP_ID("music-volumn-up", true, false),
    UAPP_HID_MEDIA_VOL_DOWN_ID("music-volumn-down", true, false),
    UAPP_ACTIVITY_TAGGING_ID(Constants.ACTIVITY, false, false),
    UAPP_GOAL_TRACKING_ID("goal-tracking", false, false),
    UAPP_DATE_ID("date", false, false),
    UAPP_TIME2_ID("second-time-zone", false, false),
    UAPP_ALERT_ID("alert", false, false),
    UAPP_ALARM_ID(Alarm.TABLE_NAME, false, false),
    UAPP_PROGRESS_ID(Constants.ACTIVITY, false, false),
    UAPP_WEATHER_STANDARD("weather", false, true),
    UAPP_COMMUTE_TIME("commute-time", false, true),
    UAPP_TOGGLE_MODE("sequence", false, false),
    UAPP_RING_PHONE("ring-my-phone", false, true),
    UAPP_SELFIE(Constants.SELFIE, true, false),
    UAPP_STOPWATCH("stopwatch", false, false),
    UAPP_UNKNOWN("unknown", false, false);
    
    private boolean needHID;
    private boolean needStreaming;
    private String value;

    private MicroAppInstruction$MicroAppID(String str, boolean z, boolean z2) {
        this.value = str;
        this.needHID = z;
        this.needStreaming = z2;
    }

    public String getValue() {
        return this.value;
    }

    public boolean isNeedHID() {
        return this.needHID;
    }

    public boolean isNeedStreaming() {
        return this.needStreaming;
    }

    public static MicroAppInstruction$MicroAppID getMicroAppId(String str) {
        MicroAppInstruction$MicroAppID[] values = values();
        for (int i = 0; i < values.length; i++) {
            if (values[i].getValue().equals(str)) {
                return values[i];
            }
        }
        return UAPP_TOGGLE_MODE;
    }
}
