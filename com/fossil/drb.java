package com.fossil;

import com.misfit.frameworks.buttonservice.model.microapp.MicroAppInstruction.MicroAppID;
import com.misfit.frameworks.common.enums.Action.Apps;
import com.misfit.frameworks.common.enums.Action.DisplayMode;
import com.misfit.frameworks.common.enums.Action.MicroAppAction;
import com.misfit.frameworks.common.log.MFLogger;

public class drb {
    private static final String TAG = drb.class.getSimpleName();

    public static MicroAppID lz(int i) {
        MFLogger.m12670d(TAG, "convertToMicroAppId action=" + i);
        switch (i) {
            case 101:
                return MicroAppID.UAPP_HID_MEDIA_CONTROL_MUSIC;
            case 104:
                return MicroAppID.UAPP_HID_MEDIA_VOL_UP_ID;
            case 105:
                return MicroAppID.UAPP_HID_MEDIA_VOL_DOWN_ID;
            case 201:
                return MicroAppID.UAPP_SELFIE;
            case Apps.RING_MY_PHONE /*505*/:
                return MicroAppID.UAPP_RING_PHONE;
            case 1000:
                return MicroAppID.UAPP_GOAL_TRACKING_ID;
            case DisplayMode.ACTIVITY /*2001*/:
                return MicroAppID.UAPP_ACTIVITY_TAGGING_ID;
            case DisplayMode.NOTIFICATION /*2002*/:
                return MicroAppID.UAPP_ALERT_ID;
            case DisplayMode.DATE /*2003*/:
                return MicroAppID.UAPP_DATE_ID;
            case DisplayMode.SECOND_TIMEZONE /*2004*/:
                return MicroAppID.UAPP_TIME2_ID;
            case DisplayMode.ALARM /*2005*/:
                return MicroAppID.UAPP_ALARM_ID;
            case DisplayMode.TOGGLE_MODE /*2006*/:
                return MicroAppID.UAPP_TOGGLE_MODE;
            case DisplayMode.STOP_WATCH /*2007*/:
                return MicroAppID.UAPP_STOPWATCH;
            case 3001:
                return MicroAppID.UAPP_WEATHER_STANDARD;
            case MicroAppAction.SHOW_COMMUTE /*3002*/:
                return MicroAppID.UAPP_COMMUTE_TIME;
            default:
                return null;
        }
    }
}
