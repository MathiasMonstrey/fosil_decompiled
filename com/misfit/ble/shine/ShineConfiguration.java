package com.misfit.ble.shine;

import com.misfit.ble.obfuscated.C4462b;
import com.misfit.ble.setting.flashlink.FlashButtonMode;
import com.misfit.ble.setting.rmm.GoalTrackingSettings;
import com.misfit.ble.setting.sam.CountdownSettings;
import com.misfit.frameworks.common.constants.Constants;
import org.json.JSONObject;

public class ShineConfiguration {
    public static final byte ACTIVITY_TAGGING_STATE_TAGGED_IN = (byte) 1;
    public static final byte ACTIVITY_TAGGING_STATE_TAGGED_OUT = (byte) 0;
    public static final byte CLOCK_STATE_DISABLE = (byte) 0;
    public static final byte CLOCK_STATE_ENABLE = (byte) 1;
    public static final byte CLOCK_STATE_SHOW_CLOCK_FIRST = (byte) 2;
    public static final long DEFAULT_ACTIVITY_POINT = -1;
    public static final int DEFAULT_ACTIVITY_TAGGING_STATE = -1;
    public static final short DEFAULT_BATTERY_LEVEL = (short) 200;
    public static final int DEFAULT_CLOCK_STATE = -1;
    public static final CountdownSettings DEFAULT_COUNTDOWN_SETTINGS = null;
    public static final long DEFAULT_CURRENT_STEPS = -1;
    public static final Boolean DEFAULT_EXTRA_ADVERTISING_DATA_STATE_ENABLE = null;
    public static final FlashButtonMode DEFAULT_FLASH_BUTTON_MODE = null;
    public static final long DEFAULT_GOAL_IN_STEPS = -1;
    public static final GoalTrackingSettings DEFAULT_GOAL_TRACKING_SETTINGS = null;
    public static final long DEFAULT_GOAL_VALUE = -1;
    public static final short DEFAULT_GROUP_ID = (short) -1;
    public static final byte[] DEFAULT_PASSCODE = null;
    public static final short DEFAULT_TIMEZONE_OFFSET = (short) -1;
    public static final int DEFAULT_TRIPLE_TAP_STATE = -1;
    public static final short DEFAULT_VIBE_STRENGTH = (short) -1;
    public static final Boolean DEFAULT_WRIST_FLICK_STATE_ENABLE = null;
    public static final byte TRIPLE_TAP_STATE_DISABLE = (byte) 0;
    public static final byte TRIPLE_TAP_STATE_ENABLE = (byte) 1;
    public long mActivityPoint = -1;
    public byte mActivityTaggingState = (byte) -1;
    public short mBatteryLevel = DEFAULT_BATTERY_LEVEL;
    public byte mClockState = (byte) -1;
    public CountdownSettings mCountdownSettings = DEFAULT_COUNTDOWN_SETTINGS;
    public long mCurrentSteps = -1;
    public Boolean mExtraAdvertisingDataStateEnable = DEFAULT_EXTRA_ADVERTISING_DATA_STATE_ENABLE;
    public FlashButtonMode mFlashButtonMode = DEFAULT_FLASH_BUTTON_MODE;
    public long mGoalInSteps = -1;
    public GoalTrackingSettings mGoalTrackingSettings = DEFAULT_GOAL_TRACKING_SETTINGS;
    public long mGoalValue = -1;
    public short mGroupId = (short) -1;
    public byte[] mPasscode = DEFAULT_PASSCODE;
    public short mTimezoneOffset = (short) -1;
    public byte mTripleTapState = (byte) -1;
    public short mVibeStrength = (short) -1;
    public Boolean mWristFlickStateEnable = DEFAULT_WRIST_FLICK_STATE_ENABLE;

    public ShineConfiguration clone() {
        ShineConfiguration shineConfiguration = new ShineConfiguration();
        shineConfiguration.mClockState = this.mClockState;
        shineConfiguration.mTripleTapState = this.mTripleTapState;
        shineConfiguration.mActivityTaggingState = this.mActivityTaggingState;
        shineConfiguration.mActivityPoint = this.mActivityPoint;
        shineConfiguration.mGoalValue = this.mGoalValue;
        shineConfiguration.mBatteryLevel = this.mBatteryLevel;
        shineConfiguration.mWristFlickStateEnable = this.mWristFlickStateEnable;
        shineConfiguration.mGroupId = this.mGroupId;
        shineConfiguration.mPasscode = this.mPasscode;
        shineConfiguration.mFlashButtonMode = this.mFlashButtonMode;
        shineConfiguration.mExtraAdvertisingDataStateEnable = this.mExtraAdvertisingDataStateEnable;
        shineConfiguration.mGoalTrackingSettings = this.mGoalTrackingSettings;
        shineConfiguration.mTimezoneOffset = this.mTimezoneOffset;
        shineConfiguration.mCountdownSettings = this.mCountdownSettings;
        shineConfiguration.mVibeStrength = this.mVibeStrength;
        shineConfiguration.mGoalInSteps = this.mGoalInSteps;
        shineConfiguration.mCurrentSteps = this.mCurrentSteps;
        return shineConfiguration;
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.mClockState != (byte) -1) {
                jSONObject.put("clockState", this.mClockState);
            }
            if (this.mTripleTapState != (byte) -1) {
                jSONObject.put("tripleTapState", this.mTripleTapState);
            }
            if (this.mActivityTaggingState != (byte) -1) {
                jSONObject.put("activityTaggingState", this.mActivityTaggingState);
            }
            if (this.mActivityPoint != -1) {
                jSONObject.put("activityPoint", this.mActivityPoint);
            }
            if (this.mGoalValue != -1) {
                jSONObject.put("goalValue", this.mGoalValue);
            }
            if (this.mBatteryLevel != DEFAULT_BATTERY_LEVEL) {
                jSONObject.put("batteryLevel", this.mBatteryLevel);
            }
            if (this.mWristFlickStateEnable != DEFAULT_WRIST_FLICK_STATE_ENABLE) {
                jSONObject.put("wristFlickStateEnable", this.mWristFlickStateEnable);
            }
            if (this.mGroupId != (short) -1) {
                jSONObject.put(Constants.GROUP_ID, this.mGroupId);
            }
            if (this.mPasscode != DEFAULT_PASSCODE) {
                jSONObject.put("passCode", this.mPasscode);
            }
            if (this.mFlashButtonMode != DEFAULT_FLASH_BUTTON_MODE) {
                jSONObject.put("flashButtonMode", this.mFlashButtonMode);
            }
            if (this.mExtraAdvertisingDataStateEnable != DEFAULT_EXTRA_ADVERTISING_DATA_STATE_ENABLE) {
                jSONObject.put("extraAdvertisingDataStateEnable", this.mExtraAdvertisingDataStateEnable);
            }
            if (this.mGoalTrackingSettings != DEFAULT_GOAL_TRACKING_SETTINGS) {
                jSONObject.put("goalTrackingSettings", this.mGoalTrackingSettings);
            }
            if (this.mTimezoneOffset != (short) -1) {
                jSONObject.put("timezoneOffset", this.mTimezoneOffset);
            }
            if (this.mCountdownSettings != DEFAULT_COUNTDOWN_SETTINGS) {
                jSONObject.put("countdownSettings", this.mCountdownSettings);
            }
            if (this.mVibeStrength != (short) -1) {
                jSONObject.put("vibeStrength", this.mVibeStrength);
            }
            if (this.mGoalInSteps != -1) {
                jSONObject.put("goalInSteps", this.mGoalInSteps);
            }
            if (this.mCurrentSteps != -1) {
                jSONObject.put("currentSteps", this.mCurrentSteps);
            }
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }
}
