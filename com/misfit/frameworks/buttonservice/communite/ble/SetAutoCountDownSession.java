package com.misfit.frameworks.buttonservice.communite.ble;

import com.misfit.ble.setting.sam.CountdownSettings;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.BleSessionCallback;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.SessionState;
import com.misfit.frameworks.buttonservice.enums.DeviceSettings;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.buttonservice.utils.DevicePreferenceUtils;
import com.misfit.frameworks.buttonservice.utils.SettingsUtils;
import com.misfit.frameworks.common.log.MFLogger;
import java.util.TimeZone;

public class SetAutoCountDownSession extends SetAutoSettingsSession {
    private CountdownSettings mCountDownSettings;
    private long mEndTime;
    private CountdownSettings mOldCountDownSettings;
    private long mStartTime;

    public class DoneSetAutoCountDownState extends BleState {
        public DoneSetAutoCountDownState() {
            super(SetAutoCountDownSession.this.TAG);
        }

        public boolean onEnter() {
            super.onEnter();
            MFLogger.d(SetAutoCountDownSession.this.TAG, "All done of " + SetAutoCountDownSession.this.TAG);
            SetAutoCountDownSession.this.stop(0);
            return true;
        }
    }

    public class SetCountdownSettingState extends BleState {
        public SetCountdownSettingState() {
            super(SetAutoCountDownSession.this.TAG);
            SetAutoCountDownSession.this.log("Set count down setting of device with serial " + SetAutoCountDownSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            if (SetAutoCountDownSession.this.bleAdapter.enableCountdown(SetAutoCountDownSession.this.mCountDownSettings)) {
                return true;
            }
            stopTimeout();
            SetAutoCountDownSession.this.storeSettings(SetAutoCountDownSession.this.mCountDownSettings, true);
            SetAutoCountDownSession.this.stop(FailureCode.FAILED_TO_SET_COUNTDOWN);
            return false;
        }

        protected void onTimeout() {
            super.onTimeout();
            SetAutoCountDownSession.this.log("Set count down setting timeout.");
            SetAutoCountDownSession.this.storeSettings(SetAutoCountDownSession.this.mCountDownSettings, true);
            SetAutoCountDownSession.this.stop(FailureCode.FAILED_TO_SET_COUNTDOWN);
        }

        public boolean handleOnSetConfigurationCompleted(boolean z) {
            stopTimeout();
            if (z) {
                MFLogger.d(SetAutoCountDownSession.this.TAG, "All done of " + SetAutoCountDownSession.this.TAG);
                SetAutoCountDownSession.this.storeSettings(SetAutoCountDownSession.this.mCountDownSettings, false);
                SetAutoCountDownSession.this.stop(0);
            } else {
                SetAutoCountDownSession.this.storeSettings(SetAutoCountDownSession.this.mCountDownSettings, true);
                SetAutoCountDownSession.this.stop(FailureCode.FAILED_TO_SET_COUNTDOWN);
            }
            return true;
        }
    }

    public SetAutoCountDownSession(long j, long j2, BleAdapter bleAdapter, BleSessionCallback bleSessionCallback) {
        super(CommunicateMode.SET_AUTO_COUNT_DOWN, bleAdapter, bleSessionCallback);
        this.mStartTime = j;
        this.mEndTime = j2;
    }

    public BleSession copyObject() {
        BleSession setAutoCountDownSession = new SetAutoCountDownSession(this.mStartTime, this.mEndTime, this.bleAdapter, this.bleSessionCallback);
        setAutoCountDownSession.setDevice(this.device);
        return setAutoCountDownSession;
    }

    protected void initStateMap() {
        this.sessionStateMap.put(SessionState.SET_COUNT_DOWN_SETTING_STATE, SetCountdownSettingState.class.getName());
        this.sessionStateMap.put(SessionState.SET_SETTING_DONE_STATE, DoneSetAutoCountDownState.class.getName());
    }

    protected void initSettings() {
        this.mCountDownSettings = new CountdownSettings(this.mStartTime, this.mEndTime, (short) ((TimeZone.getDefault().getOffset(System.currentTimeMillis()) / 1000) / 60));
        this.mOldCountDownSettings = DevicePreferenceUtils.getAutoCountDownSetting(this.context);
    }

    protected BleState getStartState() {
        boolean isSupportCountDown = SettingsUtils.isSupportCountDown(this.bleAdapter.getSerial());
        boolean isDeviceReady = this.bleAdapter.isDeviceReady();
        if (!isDeviceReady || !isSupportCountDown) {
            if (!isDeviceReady) {
                log("Device is not ready. Cannot set countdown.");
            }
            if (!isSupportCountDown) {
                log("Countdown is not supported. Cannot set countdown.");
            }
            if (!isDeviceReady && isSupportCountDown) {
                storeSettings(this.mCountDownSettings, true);
            }
            return createConcreteState(SessionState.SET_SETTING_DONE_STATE);
        } else if (this.mCountDownSettings.equals(this.mOldCountDownSettings)) {
            log("The countdown settings are the same, no need to store again.");
            return createConcreteState(SessionState.SET_SETTING_DONE_STATE);
        } else {
            storeSettings(this.mCountDownSettings, true);
            return createConcreteState(SessionState.SET_COUNT_DOWN_SETTING_STATE);
        }
    }

    protected void buildExtraInfoReturned() {
    }

    private void storeSettings(CountdownSettings countdownSettings, boolean z) {
        DevicePreferenceUtils.setAutoCountdownSetting(this.bleAdapter.getContext(), countdownSettings);
        if (z) {
            DevicePreferenceUtils.setSettingFlag(this.bleAdapter.getContext(), DeviceSettings.COUNT_DOWN);
        } else {
            DevicePreferenceUtils.removeSettingFlag(this.bleAdapter.getContext(), DeviceSettings.COUNT_DOWN);
        }
    }
}
