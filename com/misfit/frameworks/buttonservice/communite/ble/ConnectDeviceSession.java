package com.misfit.frameworks.buttonservice.communite.ble;

import com.misfit.ble.setting.pluto.AlarmSettings;
import com.misfit.ble.setting.sam.CountdownSettings;
import com.misfit.ble.setting.sam.MultipleAlarmSettings;
import com.misfit.ble.shine.ShineConfiguration;
import com.misfit.ble.shine.ShineProfile.ConnectActionResult;
import com.misfit.ble.shine.ShineProperty;
import com.misfit.ble.shine.controller.ConfigurationSession;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.communite.SessionType;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.BleSessionCallback;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.SessionState;
import com.misfit.frameworks.buttonservice.communite.ble.share.SetAlarmBaseState;
import com.misfit.frameworks.buttonservice.communite.ble.share.SetMultipleAlarmsBaseState;
import com.misfit.frameworks.buttonservice.enums.DeviceSettings;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.buttonservice.model.MisfitDeviceProfile;
import com.misfit.frameworks.buttonservice.utils.DevicePreferenceUtils;
import com.misfit.frameworks.buttonservice.utils.SettingsUtils;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import java.util.Hashtable;
import java.util.List;

public abstract class ConnectDeviceSession extends ConnectableSession {
    protected boolean hasHID = false;
    protected boolean hasStreaming = false;
    protected AlarmSettings mAlarmSettings;
    protected CountdownSettings mCountDownSettings;
    protected List<MultipleAlarmSettings> mMultipleAlarmSettings;
    protected int mSecondTimezoneOffset;

    public class GetDeviceConfigurationState extends BleState {
        public GetDeviceConfigurationState() {
            super(ConnectDeviceSession.this.TAG);
            ConnectDeviceSession.this.log("Get configuration of device with serial " + ConnectDeviceSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            if (ConnectDeviceSession.this.bleAdapter.getDeviceConfiguration(ConnectDeviceSession.this.device)) {
                return true;
            }
            stopTimeout();
            ConnectDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_GET_CONFIG);
            ConnectDeviceSession.this.enterStateWithDelayTime(ConnectDeviceSession.this.createConcreteState(SessionState.SET_DEVICE_CONFIGURATION_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return false;
        }

        public boolean handleOnGetConfigurationCompleted(boolean z, Hashtable<ShineProperty, Object> hashtable) {
            stopTimeout();
            if (z) {
                storeValue(hashtable);
                logConfiguration(hashtable);
            } else {
                ConnectDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_GET_CONFIG);
            }
            ConnectDeviceSession.this.enterState(ConnectDeviceSession.this.createConcreteState(SessionState.SET_DEVICE_CONFIGURATION_STATE));
            return true;
        }

        public boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult) {
            stopTimeout();
            ConnectDeviceSession.this.stop(FailureCode.UNEXPECTED_DISCONNECT);
            return true;
        }

        protected void onTimeout() {
            ConnectDeviceSession.this.log("Get config params timeout.");
            ConnectDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_GET_CONFIG);
            ConnectDeviceSession.this.enterState(ConnectDeviceSession.this.createConcreteState(SessionState.SET_DEVICE_CONFIGURATION_STATE));
        }

        protected void storeValue(Hashtable<ShineProperty, Object> hashtable) {
        }

        protected void logConfiguration(Hashtable<ShineProperty, Object> hashtable) {
            if (hashtable != null) {
                ConfigurationSession configurationSession = (ConfigurationSession) hashtable.get(ShineProperty.SHINE_CONFIGURATION_SESSION);
                ShineConfiguration shineConfiguration = null;
                if (configurationSession != null) {
                    shineConfiguration = configurationSession.mShineConfiguration;
                }
                if (shineConfiguration != null) {
                    ConnectDeviceSession.this.log(String.format("Get configuration connect of " + ConnectDeviceSession.this.serial + "[timeConfiguration: {milliseconds = %d;\ntimeZoneOffsetInMinutes = %d;\ntimestamp = %d;}, goalValue: %d, activityTaggingState: %d, activityPoint: %d, batteryLevel: %d]", new Object[]{Integer.valueOf(configurationSession.mPartialSecond), Short.valueOf(configurationSession.mTimeZoneOffset), Long.valueOf(configurationSession.mTimestamp), Long.valueOf(shineConfiguration.mGoalInSteps), Byte.valueOf(shineConfiguration.mActivityTaggingState), Long.valueOf(shineConfiguration.mActivityPoint), Short.valueOf(shineConfiguration.mBatteryLevel)}));
                }
            }
        }
    }

    public class SetDeviceConfigState extends BleState {
        public SetDeviceConfigState() {
            super(ConnectDeviceSession.this.TAG);
            ConnectDeviceSession.this.log("Set device config (second timezone & countdown) to device with serial " + ConnectDeviceSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            if (DevicePreferenceUtils.getCurrentSecondTimezoneOffset(ConnectDeviceSession.this.context) != ConnectDeviceSession.this.mSecondTimezoneOffset) {
                DevicePreferenceUtils.setSettingFlag(ConnectDeviceSession.this.context, DeviceSettings.SECOND_TIMEZONE);
            }
            boolean z = ConnectDeviceSession.this.device != null && ConnectDeviceSession.this.device.isSupportDeviceState(CommunicateMode.SET_SECOND_TIMEZONE);
            boolean isSupportCountDown = SettingsUtils.isSupportCountDown(ConnectDeviceSession.this.bleAdapter.getSerial());
            boolean isNeedToSetSetting = DevicePreferenceUtils.isNeedToSetSetting(ConnectDeviceSession.this.bleAdapter.getContext(), DeviceSettings.SECOND_TIMEZONE);
            boolean isNeedToSetSetting2 = DevicePreferenceUtils.isNeedToSetSetting(ConnectDeviceSession.this.bleAdapter.getContext(), DeviceSettings.COUNT_DOWN);
            if ((z && isNeedToSetSetting) || (isSupportCountDown && isNeedToSetSetting2)) {
                startTimeout();
                ShineConfiguration shineConfiguration = new ShineConfiguration();
                if (isNeedToSetSetting) {
                    ConnectDeviceSession.this.log("Set second timezone=" + ConnectDeviceSession.this.mSecondTimezoneOffset);
                    shineConfiguration.mTimezoneOffset = (short) ConnectDeviceSession.this.mSecondTimezoneOffset;
                }
                if (isNeedToSetSetting2) {
                    ConnectDeviceSession.this.log("Set count down=" + ConnectDeviceSession.this.mCountDownSettings);
                    shineConfiguration.mCountdownSettings = ConnectDeviceSession.this.mCountDownSettings;
                }
                if (!ConnectDeviceSession.this.bleAdapter.setDeviceConfiguration(shineConfiguration)) {
                    stopTimeout();
                    ConnectDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_SET_CONFIG);
                    ConnectDeviceSession.this.enterStateWithDelayTime(ConnectDeviceSession.this.createConcreteState(SessionState.SET_SING_ALARM_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                    return false;
                }
            }
            ConnectDeviceSession.this.log("No need to set config (Second Timezone or Count Down). Move on.");
            DevicePreferenceUtils.removeSettingFlag(ConnectDeviceSession.this.bleAdapter.getContext(), DeviceSettings.COUNT_DOWN);
            DevicePreferenceUtils.removeSettingFlag(ConnectDeviceSession.this.bleAdapter.getContext(), DeviceSettings.SECOND_TIMEZONE);
            ConnectDeviceSession.this.enterStateWithDelayTime(ConnectDeviceSession.this.createConcreteState(SessionState.SET_SING_ALARM_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        public boolean handleOnSetConfigurationCompleted(boolean z) {
            stopTimeout();
            if (z) {
                DevicePreferenceUtils.removeSettingFlag(ConnectDeviceSession.this.bleAdapter.getContext(), DeviceSettings.SECOND_TIMEZONE);
                DevicePreferenceUtils.removeSettingFlag(ConnectDeviceSession.this.bleAdapter.getContext(), DeviceSettings.COUNT_DOWN);
            } else {
                ConnectDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_SET_SECOND_TIMEZONE);
            }
            ConnectDeviceSession.this.enterState(ConnectDeviceSession.this.createConcreteState(SessionState.SET_SING_ALARM_STATE));
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            ConnectDeviceSession.this.log("Set second timezone to " + ConnectDeviceSession.this.serial + " onTimeout");
            ConnectDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_SET_SECOND_TIMEZONE);
            ConnectDeviceSession.this.enterState(ConnectDeviceSession.this.createConcreteState(SessionState.SET_SING_ALARM_STATE));
        }
    }

    public class SetMultipleAlarmsState extends SetMultipleAlarmsBaseState {
        public SetMultipleAlarmsState() {
            super(ConnectDeviceSession.this.mMultipleAlarmSettings, ConnectDeviceSession.this.bleAdapter, ConnectDeviceSession.this);
            ConnectDeviceSession.this.log("Set multiple alarms to device with serial " + ConnectDeviceSession.this.serial);
        }

        public boolean onEnter() {
            if (DevicePreferenceUtils.isNeedToSetSetting(ConnectDeviceSession.this.bleAdapter.getContext(), DeviceSettings.MULTI_ALARM)) {
                boolean z = ConnectDeviceSession.this.device != null && ConnectDeviceSession.this.device.isSupportDeviceState(CommunicateMode.SET_LIST_ALARM);
                if (z) {
                    return super.onEnter();
                }
                ConnectDeviceSession.this.log("Multi alarm function is not supported");
                DevicePreferenceUtils.removeSettingFlag(ConnectDeviceSession.this.bleAdapter.getContext(), DeviceSettings.MULTI_ALARM);
                ConnectDeviceSession.this.enterStateWithDelayTime(ConnectDeviceSession.this.getStateAfterSetMultipleAlarm(), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                return true;
            }
            ConnectDeviceSession.this.log("No need to set multi alarms. Move on.");
            DevicePreferenceUtils.removeSettingFlag(ConnectDeviceSession.this.bleAdapter.getContext(), DeviceSettings.MULTI_ALARM);
            ConnectDeviceSession.this.enterStateWithDelayTime(ConnectDeviceSession.this.getStateAfterSetMultipleAlarm(), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        protected BleState getStateOnCompleted(boolean z) {
            if (z) {
                DevicePreferenceUtils.removeSettingFlag(ConnectDeviceSession.this.bleAdapter.getContext(), DeviceSettings.MULTI_ALARM);
            } else {
                ConnectDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_SET_ALARM);
            }
            return ConnectDeviceSession.this.getStateAfterSetMultipleAlarm();
        }

        protected BleState getStateOnTimeOut() {
            ConnectDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_SET_ALARM);
            return ConnectDeviceSession.this.getStateAfterSetMultipleAlarm();
        }
    }

    public class SetSingleAlarmState extends SetAlarmBaseState {
        public SetSingleAlarmState() {
            super(ConnectDeviceSession.this.mAlarmSettings, ConnectDeviceSession.this.bleAdapter, ConnectDeviceSession.this);
            ConnectDeviceSession.this.log("Set alarm to device with serial " + ConnectDeviceSession.this.serial);
        }

        public boolean onEnter() {
            if (DevicePreferenceUtils.isNeedToSetSetting(ConnectDeviceSession.this.bleAdapter.getContext(), DeviceSettings.SINGLE_ALARM)) {
                boolean z = ConnectDeviceSession.this.device != null && ConnectDeviceSession.this.device.isSupportDeviceState(CommunicateMode.SET_ALARM);
                if (z) {
                    return super.onEnter();
                }
                ConnectDeviceSession.this.log("Alarm function is not supported");
                DevicePreferenceUtils.removeSettingFlag(ConnectDeviceSession.this.bleAdapter.getContext(), DeviceSettings.SINGLE_ALARM);
                ConnectDeviceSession.this.enterStateWithDelayTime(ConnectDeviceSession.this.createConcreteState(SessionState.SET_MULTIPLE_ALARMS_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                return true;
            }
            ConnectDeviceSession.this.log("No need to set single alarm. Move on.");
            DevicePreferenceUtils.removeSettingFlag(ConnectDeviceSession.this.bleAdapter.getContext(), DeviceSettings.SINGLE_ALARM);
            ConnectDeviceSession.this.enterStateWithDelayTime(ConnectDeviceSession.this.createConcreteState(SessionState.SET_MULTIPLE_ALARMS_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            return true;
        }

        protected BleState getStateOnCompleted(boolean z) {
            if (z) {
                DevicePreferenceUtils.removeSettingFlag(ConnectDeviceSession.this.bleAdapter.getContext(), DeviceSettings.SINGLE_ALARM);
            } else {
                ConnectDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_SET_ALARM);
            }
            return ConnectDeviceSession.this.createConcreteState(SessionState.SET_MULTIPLE_ALARMS_STATE);
        }

        protected BleState getStateOnTimeOut() {
            ConnectDeviceSession.this.addFailureCode(FailureCode.FAILED_TO_SET_ALARM);
            return ConnectDeviceSession.this.createConcreteState(SessionState.SET_MULTIPLE_ALARMS_STATE);
        }

        public boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult) {
            stopTimeout();
            ConnectDeviceSession.this.stop(FailureCode.UNEXPECTED_DISCONNECT);
            return true;
        }
    }

    public abstract BleState getStateAfterSetMultipleAlarm();

    public ConnectDeviceSession(BleAdapter bleAdapter, BleSessionCallback bleSessionCallback, SdkCallback sdkCallback) {
        super(SessionType.CONNECT, CommunicateMode.RECONNECT, bleAdapter, bleSessionCallback, sdkCallback);
    }

    protected boolean onStart(Object... objArr) {
        initSettings();
        return super.onStart(objArr);
    }

    public void initSettings() {
        this.mSecondTimezoneOffset = DevicePreferenceUtils.getAutoSecondTimezone(this.context);
        this.mCountDownSettings = DevicePreferenceUtils.getAutoCountDownSetting(this.context);
        this.mAlarmSettings = DevicePreferenceUtils.getAutoAlarmSetting(this.context);
        this.mMultipleAlarmSettings = DevicePreferenceUtils.getAutoListAlarm(this.context);
    }

    public void initStateMap() {
        super.initStateMap();
        this.sessionStateMap.put(SessionState.GET_DEVICE_CONFIGURATION_STATE, GetDeviceConfigurationState.class.getName());
        this.sessionStateMap.put(SessionState.SET_DEVICE_CONFIGURATION_STATE, SetDeviceConfigState.class.getName());
        this.sessionStateMap.put(SessionState.SET_SING_ALARM_STATE, SetSingleAlarmState.class.getName());
        this.sessionStateMap.put(SessionState.SET_MULTIPLE_ALARMS_STATE, SetMultipleAlarmsState.class.getName());
    }

    protected void buildExtraInfoReturned() {
        this.extraInfoReturned.putParcelable(Constants.DEVICE, MisfitDeviceProfile.cloneFrom(this.bleAdapter));
    }

    protected BleState getStateAfterConnected() {
        return createConcreteState(SessionState.GET_DEVICE_CONFIGURATION_STATE);
    }
}
