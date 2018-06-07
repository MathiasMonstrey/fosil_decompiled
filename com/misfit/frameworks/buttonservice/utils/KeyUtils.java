package com.misfit.frameworks.buttonservice.utils;

import android.content.Context;

public class KeyUtils {
    private static final String BUTTON_PREFERENCE = "buttonservice";
    private static final String GOAL_TRACKING_TAG = "autoGoalTracking";
    private static final String KEY_ALARM_SETTING = "alarmSetting";
    private static final String KEY_ALL_ACTIVE_BUTTON = "activeButton";
    private static final String KEY_ALL_PAIRED_BUTTON = "pairedButton";
    private static final String KEY_COUNTDOWN_SETTING = "countdownSetting";
    private static final String KEY_CURRENT_SECOND_TIMEZONE_OFFSET = "currentSecondTimezoneOffset";
    private static final String KEY_DEVICE_PROFILE = "deviceProfile";
    private static final String KEY_DEVICE_SETTING_DATA = "keyDeviceSettingData";
    private static final String KEY_LIST_ALARM = "listAlarm";
    private static final String KEY_SECOND_TIMEZONE = "secondTimezone";
    private static final String MAPPING_TAG = "autoSetMapping";
    private static final String STREAMING_TAG = "autoStreaming";

    public static String getButtonPreferenceKey(Context context) {
        return context.getPackageName() + BUTTON_PREFERENCE;
    }

    public static String getKeyAllActiveButton(Context context) {
        return context.getPackageName() + KEY_ALL_ACTIVE_BUTTON;
    }

    public static String getKeyAllPairedButton(Context context) {
        return context.getPackageName() + KEY_ALL_PAIRED_BUTTON;
    }

    public static String getKeyDeviceProfile(Context context) {
        return context.getPackageName() + KEY_DEVICE_PROFILE;
    }

    public static String getKeyAutoSetMapping(Context context) {
        return context.getPackageName() + MAPPING_TAG;
    }

    public static String getKeySecondTimezone(Context context) {
        return context.getPackageName() + KEY_SECOND_TIMEZONE;
    }

    public static String getKeyCurrentSecondTimezoneOffset(Context context) {
        return context.getPackageName() + KEY_CURRENT_SECOND_TIMEZONE_OFFSET;
    }

    public static String getKeyAlarmSetting(Context context) {
        return context.getPackageName() + KEY_ALARM_SETTING;
    }

    public static String getKeyListAlarm(Context context) {
        return context.getPackageName() + KEY_LIST_ALARM;
    }

    public static String getKeyAutoCountdownSetting(Context context) {
        return context.getPackageName() + KEY_COUNTDOWN_SETTING;
    }

    public static String getKeyDeviceSettingData(Context context) {
        return context.getPackageName() + KEY_DEVICE_SETTING_DATA;
    }
}
