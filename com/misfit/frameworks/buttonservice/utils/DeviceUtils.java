package com.misfit.frameworks.buttonservice.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.misfit.ble.setting.flashlink.EventMappingEnum.KeyCode;
import com.misfit.ble.setting.flashlink.EventMappingEnum.ModeDisplay;
import com.misfit.frameworks.common.enums.Action.ActivityTracker;
import com.misfit.frameworks.common.enums.Action.Apps;
import com.misfit.frameworks.common.enums.Action.Bolt;
import com.misfit.frameworks.common.enums.Action.DisplayMode;
import com.misfit.frameworks.common.enums.Action.Music;
import com.misfit.frameworks.common.enums.Action.Presenter;
import com.misfit.frameworks.common.enums.Action.Selfie;
import com.misfit.frameworks.common.enums.ButtonType;

public class DeviceUtils {
    public static final String PREFERENCE_NAME = "com.misfit.frameworks.buttonservice.cacheddevices";
    private static DeviceUtils sInstance;
    private Context context;

    private DeviceUtils(Context context) {
        this.context = context.getApplicationContext();
    }

    public static synchronized DeviceUtils getInstance(Context context) {
        DeviceUtils deviceUtils;
        synchronized (DeviceUtils.class) {
            if (sInstance == null) {
                sInstance = new DeviceUtils(context);
            }
            deviceUtils = sInstance;
        }
        return deviceUtils;
    }

    public int buttonTypeToBleCommand(ButtonType buttonType) {
        switch (buttonType) {
            case SELFIE:
                return 1;
            case MUSIC:
                return 2;
            case PRESENTATION:
                return 3;
            case ACTIVITY:
                return 5;
            case BOLT_CONTROL:
                return 6;
            case CUSTOM:
            case PLUTO_TRACKER:
            case SILVRETTA_TRACKER:
            case BMW_TRACKER:
            case SWAROVSKI_TRACKER:
            case ThirdPartyApp:
                return 7;
            default:
                return 0;
        }
    }

    public ButtonType bleCommandToButtonType(int i) {
        switch (i) {
            case 1:
                return ButtonType.SELFIE;
            case 2:
                return ButtonType.MUSIC;
            case 3:
                return ButtonType.PRESENTATION;
            case 5:
                return ButtonType.ACTIVITY;
            case 6:
                return ButtonType.BOLT_CONTROL;
            case 7:
                return ButtonType.CUSTOM;
            case 50:
                return ButtonType.PLUTO_TRACKER;
            default:
                return ButtonType.NONE;
        }
    }

    public ButtonType getButtonTypeByAction(int i) {
        if (Music.isActionBelongToThisType(i)) {
            return ButtonType.MUSIC;
        }
        if (Selfie.isActionBelongToThisType(i)) {
            return ButtonType.SELFIE;
        }
        if (Presenter.isActionBelongToThisType(i)) {
            return ButtonType.PRESENTATION;
        }
        if (ActivityTracker.isActionBelongToThisType(i)) {
            return ButtonType.ACTIVITY;
        }
        if (DisplayMode.isActionBelongToThisType(i)) {
            return ButtonType.DISPLAY_MODE;
        }
        if (i == Apps.RING_MY_PHONE) {
            return ButtonType.RING_MY_PHONE;
        }
        if (i == 1000) {
            return ButtonType.GOAL_TRACKING;
        }
        if (i <= 600 || i >= Bolt.BOLT_END_ACTION) {
            return ButtonType.NONE;
        }
        return ButtonType.BOLT_CONTROL;
    }

    public ModeDisplay getDisplayMode(int i) {
        ModeDisplay modeDisplay = ModeDisplay.NO_MODE;
        switch (i) {
            case DisplayMode.ACTIVITY /*2001*/:
                return ModeDisplay.PROGRESS;
            case DisplayMode.NOTIFICATION /*2002*/:
                return ModeDisplay.ALERT;
            case DisplayMode.DATE /*2003*/:
                return ModeDisplay.DATE;
            case DisplayMode.SECOND_TIMEZONE /*2004*/:
                return ModeDisplay.TIME_TWO;
            case DisplayMode.ALARM /*2005*/:
                return ModeDisplay.ALARM;
            case DisplayMode.TOGGLE_MODE /*2006*/:
                return ModeDisplay.SEQUENCED_MODES;
            case DisplayMode.STOP_WATCH /*2007*/:
                return ModeDisplay.STOP_WATCH;
            case DisplayMode.COUNT_DOWN /*2008*/:
                return ModeDisplay.COUNTDOWN;
            default:
                return ModeDisplay.NO_MODE;
        }
    }

    public KeyCode getCustomModeKeyCodeByAction(int i) {
        switch (i) {
            case 101:
                return KeyCode.MEDIA_PLAY_PAUSE;
            case 102:
                return KeyCode.MEDIA_NEXT_SONG;
            case 103:
                return KeyCode.MEDIA_PREVIOUS_SONG;
            case 104:
            case 201:
                return KeyCode.MEDIA_VOLUME_UP_OR_SELFIE;
            case 105:
                return KeyCode.MEDIA_VOLUME_DOWN;
            case Selfie.TAKE_BURST /*202*/:
                return KeyCode.MEDIA_VOLUME_UP_OR_SELFIE;
            case Presenter.NEXT /*301*/:
                return KeyCode.KB_KEY_RIGHT;
            case Presenter.PREVIOUS /*302*/:
                return KeyCode.KB_KEY_LEFT;
            case 401:
                return null;
            case Apps.RING_MY_PHONE /*505*/:
                return KeyCode.MEDIA_VOLUME_UP_OR_SELFIE;
            case 601:
                return KeyCode.MEDIA_VOLUME_UP_OR_SELFIE;
            default:
                return KeyCode.MEDIA_VOLUME_UP_OR_SELFIE;
        }
    }

    public SharedPreferences getPreferences(Context context) {
        return context.getSharedPreferences(PREFERENCE_NAME, 0);
    }

    public String getString(Context context, String str) {
        SharedPreferences preferences = getPreferences(context);
        if (preferences != null) {
            return preferences.getString(str, "");
        }
        return "";
    }

    public void setString(Context context, String str, String str2) {
        SharedPreferences preferences = getPreferences(context);
        if (preferences != null) {
            Editor edit = preferences.edit();
            edit.putString(str, str2);
            edit.apply();
        }
    }

    public void saveMacAddress(Context context, String str, String str2) {
        setString(context, str, str2);
        setString(context, str2, str);
    }

    public String getSerial(Context context, String str) {
        return getString(context, str);
    }

    public String getMacAddress(Context context, String str) {
        return getString(context, str);
    }

    public void clearMacAddress(Context context, String str) {
        setString(context, str, "");
    }
}
