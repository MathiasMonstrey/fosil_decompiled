package com.misfit.frameworks.buttonservice.communite.ble;

import com.misfit.ble.setting.pluto.AlarmSettings;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.communite.SessionType;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.BleSessionCallback;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.SessionState;
import com.misfit.frameworks.buttonservice.enums.DeviceSettings;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.buttonservice.utils.DevicePreferenceUtils;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.log.MFLogger;

public class SetSingleAlarmSession extends ConnectableSession {
    private AlarmSettings mAlarmSettings;
    private AlarmSettings mOldAlarmSettings;

    public class DoneSetSingleAlarmState extends BleState {
        public DoneSetSingleAlarmState() {
            super(SetSingleAlarmSession.this.TAG);
        }

        public boolean onEnter() {
            super.onEnter();
            MFLogger.d(SetSingleAlarmSession.this.TAG, "All done of " + SetSingleAlarmSession.this.TAG);
            SetSingleAlarmSession.this.stop(0);
            return true;
        }
    }

    public class SetSingleAlarmState extends BleState {
        public SetSingleAlarmState() {
            super(SetSingleAlarmSession.this.TAG);
            SetSingleAlarmSession.this.log("Set alarm of device with serial " + SetSingleAlarmSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            if (SetSingleAlarmSession.this.bleAdapter.enableAlarm(SetSingleAlarmSession.this.mAlarmSettings)) {
                return true;
            }
            stopTimeout();
            SetSingleAlarmSession.this.stop(FailureCode.FAILED_TO_SET_ALARM);
            return false;
        }

        public boolean handleOnSettingSingleAlarmCompleted(boolean z) {
            stopTimeout();
            if (z) {
                DevicePreferenceUtils.setAutoAlarmSetting(SetSingleAlarmSession.this.bleAdapter.getContext(), SetSingleAlarmSession.this.mAlarmSettings);
                DevicePreferenceUtils.removeSettingFlag(SetSingleAlarmSession.this.bleAdapter.getContext(), DeviceSettings.SINGLE_ALARM);
                SetSingleAlarmSession.this.stop(0);
            } else {
                SetSingleAlarmSession.this.stop(FailureCode.FAILED_TO_SET_ALARM);
            }
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            SetSingleAlarmSession.this.log("Set alarm timeout.");
            SetSingleAlarmSession.this.stop(FailureCode.FAILED_TO_SET_ALARM);
        }
    }

    public SetSingleAlarmSession(AlarmSettings alarmSettings, BleAdapter bleAdapter, BleSessionCallback bleSessionCallback, SdkCallback sdkCallback) {
        super(SessionType.UI, CommunicateMode.SET_ALARM, bleAdapter, bleSessionCallback, sdkCallback);
        this.mAlarmSettings = alarmSettings;
    }

    public BleSession copyObject() {
        BleSession setSingleAlarmSession = new SetSingleAlarmSession(this.mAlarmSettings, this.bleAdapter, this.bleSessionCallback, this.sdkCallback);
        setSingleAlarmSession.setDevice(this.device);
        return setSingleAlarmSession;
    }

    public boolean accept(BleSession bleSession) {
        return (getCommunicateMode() == bleSession.getCommunicateMode() || bleSession.getCommunicateMode() == CommunicateMode.SET_AUTO_SINGLE_ALARM) ? false : true;
    }

    protected boolean onStart(Object... objArr) {
        initSettings();
        if (this.mAlarmSettings != null && !this.mAlarmSettings.equals(this.mOldAlarmSettings)) {
            return super.onStart(objArr);
        }
        log("The single alarms are the same. No need to set again");
        enterStateWithDelayTime(createConcreteState(SessionState.SET_SETTING_DONE_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
        return true;
    }

    private void initSettings() {
        this.mOldAlarmSettings = DevicePreferenceUtils.getAutoAlarmSetting(this.context);
    }

    protected void initStateMap() {
        super.initStateMap();
        this.sessionStateMap.put(SessionState.SET_SING_ALARM_STATE, SetSingleAlarmState.class.getName());
        this.sessionStateMap.put(SessionState.SET_SETTING_DONE_STATE, DoneSetSingleAlarmState.class.getName());
    }

    protected BleState getStateAfterConnected() {
        return createConcreteState(SessionState.SET_SING_ALARM_STATE);
    }

    protected void buildExtraInfoReturned() {
    }
}
