package com.misfit.frameworks.buttonservice.communite.ble;

import com.misfit.ble.setting.pluto.AlarmSettings;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.BleSessionCallback;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.SessionState;
import com.misfit.frameworks.buttonservice.enums.DeviceSettings;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.buttonservice.utils.DevicePreferenceUtils;
import com.misfit.frameworks.common.log.MFLogger;

public class SetAutoSingleAlarmSession extends SetAutoSettingsSession {
    private AlarmSettings mAlarmSetting;
    private AlarmSettings mOldAlarmSettings;

    public class DoneSetAutoSingleAlarmState extends BleState {
        public DoneSetAutoSingleAlarmState() {
            super(SetAutoSingleAlarmSession.this.TAG);
        }

        public boolean onEnter() {
            super.onEnter();
            MFLogger.d(SetAutoSingleAlarmSession.this.TAG, "All done of " + SetAutoSingleAlarmSession.this.TAG);
            SetAutoSingleAlarmSession.this.stop(0);
            return true;
        }
    }

    public class SetSingleAlarmState extends BleState {
        public SetSingleAlarmState() {
            super(SetAutoSingleAlarmSession.this.TAG);
            SetAutoSingleAlarmSession.this.log("Set alarm of device with serial " + SetAutoSingleAlarmSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            if (SetAutoSingleAlarmSession.this.bleAdapter.enableAlarm(SetAutoSingleAlarmSession.this.mAlarmSetting)) {
                return true;
            }
            stopTimeout();
            SetAutoSingleAlarmSession.this.stop(FailureCode.FAILED_TO_SET_ALARM);
            return false;
        }

        public boolean handleOnSettingSingleAlarmCompleted(boolean z) {
            stopTimeout();
            if (z) {
                SetAutoSingleAlarmSession.this.storeSettings(SetAutoSingleAlarmSession.this.mAlarmSetting, false);
                SetAutoSingleAlarmSession.this.stop(0);
            } else {
                SetAutoSingleAlarmSession.this.storeSettings(SetAutoSingleAlarmSession.this.mAlarmSetting, true);
                SetAutoSingleAlarmSession.this.stop(FailureCode.FAILED_TO_SET_ALARM);
            }
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            SetAutoSingleAlarmSession.this.log("Set alarm timeout.");
            SetAutoSingleAlarmSession.this.storeSettings(SetAutoSingleAlarmSession.this.mAlarmSetting, true);
            SetAutoSingleAlarmSession.this.stop(FailureCode.FAILED_TO_SET_ALARM);
        }
    }

    public SetAutoSingleAlarmSession(AlarmSettings alarmSettings, BleAdapter bleAdapter, BleSessionCallback bleSessionCallback) {
        super(CommunicateMode.SET_AUTO_SINGLE_ALARM, bleAdapter, bleSessionCallback);
        this.mAlarmSetting = alarmSettings;
    }

    protected void initSettings() {
        this.mOldAlarmSettings = DevicePreferenceUtils.getAutoAlarmSetting(this.context);
    }

    private void storeSettings(AlarmSettings alarmSettings, boolean z) {
        DevicePreferenceUtils.setAutoAlarmSetting(this.bleAdapter.getContext(), alarmSettings);
        if (z) {
            DevicePreferenceUtils.setSettingFlag(this.bleAdapter.getContext(), DeviceSettings.SINGLE_ALARM);
        } else {
            DevicePreferenceUtils.removeSettingFlag(this.bleAdapter.getContext(), DeviceSettings.SINGLE_ALARM);
        }
    }

    protected BleState getStartState() {
        if (!this.device.isSupportDeviceState(CommunicateMode.SET_ALARM)) {
            log("This device does not support set single alarm.");
            return createConcreteState(SessionState.SET_SETTING_DONE_STATE);
        } else if (!this.bleAdapter.isDeviceReady()) {
            storeSettings(this.mAlarmSetting, true);
            log("Device is not ready. Cannot single alarm.");
            return createConcreteState(SessionState.SET_SETTING_DONE_STATE);
        } else if (this.mAlarmSetting.equals(this.mOldAlarmSettings)) {
            log("The single alarms are the same, no need to store again.");
            return createConcreteState(SessionState.SET_SETTING_DONE_STATE);
        } else {
            storeSettings(this.mAlarmSetting, true);
            return createConcreteState(SessionState.SET_SING_ALARM_STATE);
        }
    }

    public BleSession copyObject() {
        BleSession setAutoSingleAlarmSession = new SetAutoSingleAlarmSession(this.mAlarmSetting, this.bleAdapter, this.bleSessionCallback);
        setAutoSingleAlarmSession.setDevice(this.device);
        return setAutoSingleAlarmSession;
    }

    protected void initStateMap() {
        this.sessionStateMap.put(SessionState.SET_SING_ALARM_STATE, SetSingleAlarmState.class.getName());
        this.sessionStateMap.put(SessionState.SET_SETTING_DONE_STATE, DoneSetAutoSingleAlarmState.class.getName());
    }

    protected void buildExtraInfoReturned() {
    }
}
