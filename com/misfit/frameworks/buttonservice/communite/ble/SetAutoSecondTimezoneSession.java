package com.misfit.frameworks.buttonservice.communite.ble;

import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.BleSessionCallback;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.SessionState;
import com.misfit.frameworks.buttonservice.enums.DeviceSettings;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.buttonservice.utils.ConversionUtils;
import com.misfit.frameworks.buttonservice.utils.DevicePreferenceUtils;
import com.misfit.frameworks.common.log.MFLogger;

public class SetAutoSecondTimezoneSession extends SetAutoSettingsSession {
    private String mOldSecondTimezoneId;
    private String mSecondTimezoneId;

    public class DoneSetAutoSecondTimezoneState extends BleState {
        public DoneSetAutoSecondTimezoneState() {
            super(SetAutoSecondTimezoneSession.this.TAG);
        }

        public boolean onEnter() {
            super.onEnter();
            MFLogger.d(SetAutoSecondTimezoneSession.this.TAG, "All done of " + SetAutoSecondTimezoneSession.this.TAG);
            SetAutoSecondTimezoneSession.this.stop(0);
            return true;
        }
    }

    public class SetSecondTimezoneState extends BleState {
        public SetSecondTimezoneState() {
            super(SetAutoSecondTimezoneSession.this.TAG);
            SetAutoSecondTimezoneSession.this.log("Set second timezone to device with serial " + SetAutoSecondTimezoneSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            if (SetAutoSecondTimezoneSession.this.bleAdapter.enableSecondTimezone(ConversionUtils.getTimezoneRawOffsetById(SetAutoSecondTimezoneSession.this.mSecondTimezoneId))) {
                return true;
            }
            stopTimeout();
            SetAutoSecondTimezoneSession.this.stop(FailureCode.FAILED_TO_SET_SECOND_TIMEZONE);
            return false;
        }

        public boolean handleOnSetConfigurationCompleted(boolean z) {
            int i = 0;
            stopTimeout();
            if (z) {
                SetAutoSecondTimezoneSession.this.storeSettings(SetAutoSecondTimezoneSession.this.mSecondTimezoneId, false);
            }
            SetAutoSecondTimezoneSession setAutoSecondTimezoneSession = SetAutoSecondTimezoneSession.this;
            if (!z) {
                i = FailureCode.FAILED_TO_SET_SECOND_TIMEZONE;
            }
            setAutoSecondTimezoneSession.stop(i);
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            SetAutoSecondTimezoneSession.this.log("Set second timezone to " + SetAutoSecondTimezoneSession.this.serial + " onTimeout");
            SetAutoSecondTimezoneSession.this.stop(FailureCode.FAILED_TO_SET_SECOND_TIMEZONE);
        }
    }

    public SetAutoSecondTimezoneSession(String str, BleAdapter bleAdapter, BleSessionCallback bleSessionCallback) {
        super(CommunicateMode.SET_AUTO_SECOND_TIMEZONE, bleAdapter, bleSessionCallback);
        this.mSecondTimezoneId = str;
    }

    public BleSession copyObject() {
        BleSession setAutoSecondTimezoneSession = new SetAutoSecondTimezoneSession(this.mSecondTimezoneId, this.bleAdapter, this.bleSessionCallback);
        setAutoSecondTimezoneSession.setDevice(this.device);
        return setAutoSecondTimezoneSession;
    }

    protected void initStateMap() {
        this.sessionStateMap.put(SessionState.SET_SECOND_TIMEZONE_STATE, SetSecondTimezoneState.class.getName());
        this.sessionStateMap.put(SessionState.SET_SETTING_DONE_STATE, DoneSetAutoSecondTimezoneState.class.getName());
    }

    protected void initSettings() {
        this.mOldSecondTimezoneId = DevicePreferenceUtils.getAutoSecondTimezoneId(this.context);
    }

    protected BleState getStartState() {
        if (!this.bleAdapter.isDeviceReady()) {
            storeSettings(this.mSecondTimezoneId, true);
            log("Device is not ready. Cannot set second timezone.");
            return createConcreteState(SessionState.SET_SETTING_DONE_STATE);
        } else if (this.mSecondTimezoneId.equals(this.mOldSecondTimezoneId)) {
            log("The second timezones are the same, no need to store again.");
            return createConcreteState(SessionState.SET_SETTING_DONE_STATE);
        } else {
            storeSettings(this.mSecondTimezoneId, true);
            return createConcreteState(SessionState.SET_SECOND_TIMEZONE_STATE);
        }
    }

    protected void buildExtraInfoReturned() {
    }

    private void storeSettings(String str, boolean z) {
        DevicePreferenceUtils.setAutoSecondTimezone(this.bleAdapter.getContext(), str);
        if (z) {
            DevicePreferenceUtils.setSettingFlag(this.bleAdapter.getContext(), DeviceSettings.SECOND_TIMEZONE);
        } else {
            DevicePreferenceUtils.removeSettingFlag(this.bleAdapter.getContext(), DeviceSettings.SECOND_TIMEZONE);
        }
    }
}
