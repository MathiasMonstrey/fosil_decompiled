package com.misfit.frameworks.buttonservice.communite.ble;

import com.misfit.ble.setting.eventmapping.GoalTrackingEventMapping;
import com.misfit.ble.setting.sam.CountdownSettings;
import com.misfit.frameworks.buttonservice.ButtonService;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.communite.SessionType;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.BleSessionCallback;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.SessionState;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.buttonservice.utils.DevicePreferenceUtils;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.log.MFLogger;
import java.util.TimeZone;

public class SetCountdownSettingSession extends ConnectableSession {
    private static final String TAG = SetCountdownSettingSession.class.getSimpleName();
    private boolean isEnable;
    private CountdownSettings mCountDownSettings;
    private long mEndTime;
    private CountdownSettings mOldCountDownSetting;
    private long mStartTime;

    public class DoneSetCountDownState extends BleState {
        public DoneSetCountDownState() {
            super(SetCountdownSettingSession.TAG);
        }

        public boolean onEnter() {
            super.onEnter();
            MFLogger.d(SetCountdownSettingSession.TAG, "All done of " + SetCountdownSettingSession.TAG);
            SetCountdownSettingSession.this.stop(0);
            return true;
        }
    }

    public class SetCountdownSettingState extends BleState {
        public SetCountdownSettingState() {
            super(SetCountdownSettingSession.TAG);
            SetCountdownSettingSession.this.log("Set count down setting of device with serial " + SetCountdownSettingSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            if (SetCountdownSettingSession.this.bleAdapter.enableCountdown(SetCountdownSettingSession.this.mCountDownSettings)) {
                return true;
            }
            stopTimeout();
            SetCountdownSettingSession.this.stop(FailureCode.FAILED_TO_SET_COUNTDOWN);
            return false;
        }

        protected void onTimeout() {
            super.onTimeout();
            SetCountdownSettingSession.this.log("Set count down setting timeout.");
            SetCountdownSettingSession.this.stop(FailureCode.FAILED_TO_SET_COUNTDOWN);
        }

        public boolean handleOnSetConfigurationCompleted(boolean z) {
            stopTimeout();
            if (z) {
                MFLogger.d(SetCountdownSettingSession.TAG, "All done of " + SetCountdownSettingSession.TAG);
                DevicePreferenceUtils.setAutoCountdownSetting(SetCountdownSettingSession.this.bleAdapter.getContext(), SetCountdownSettingSession.this.mCountDownSettings);
                SetCountdownSettingSession.this.stop(0);
            } else {
                SetCountdownSettingSession.this.stop(FailureCode.FAILED_TO_SET_COUNTDOWN);
            }
            return true;
        }
    }

    public SetCountdownSettingSession(BleAdapter bleAdapter, BleSessionCallback bleSessionCallback, SdkCallback sdkCallback, boolean z, long j, long j2) {
        super(SessionType.UI, CommunicateMode.SET_COUNTDOWN, bleAdapter, bleSessionCallback, sdkCallback);
        this.isEnable = z;
        this.mStartTime = j;
        this.mEndTime = j2;
    }

    public BleSession copyObject() {
        BleSession setCountdownSettingSession = new SetCountdownSettingSession(this.bleAdapter, this.bleSessionCallback, this.sdkCallback, this.isEnable, this.mStartTime, this.mEndTime);
        setCountdownSettingSession.setDevice(this.device);
        return setCountdownSettingSession;
    }

    public boolean accept(BleSession bleSession) {
        return (getCommunicateMode() == bleSession.getCommunicateMode() || bleSession.getCommunicateMode() == CommunicateMode.SET_AUTO_COUNT_DOWN) ? false : true;
    }

    protected boolean onStart(Object... objArr) {
        initSettings();
        if (!this.mCountDownSettings.equals(this.mOldCountDownSetting)) {
            return super.onStart(objArr);
        }
        log("The countdown settings are the same. No need to set again");
        enterStateWithDelayTime(createConcreteState(SessionState.SET_SETTING_DONE_STATE), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
        return true;
    }

    private void initSettings() {
        this.mOldCountDownSetting = DevicePreferenceUtils.getAutoCountDownSetting(this.context);
        if (this.isEnable) {
            this.mCountDownSettings = new CountdownSettings(this.mStartTime, this.mEndTime, (short) ((TimeZone.getDefault().getOffset(System.currentTimeMillis()) / 1000) / 60));
            return;
        }
        this.mCountDownSettings = new CountdownSettings(0, 0, GoalTrackingEventMapping.INVALID_GOAL_ID_NUMBER);
    }

    protected void initStateMap() {
        super.initStateMap();
        this.sessionStateMap.put(SessionState.SET_COUNT_DOWN_SETTING_STATE, SetCountdownSettingState.class.getName());
        this.sessionStateMap.put(SessionState.SET_SETTING_DONE_STATE, DoneSetCountDownState.class.getName());
    }

    protected BleState getStateAfterConnected() {
        return createConcreteState(SessionState.SET_COUNT_DOWN_SETTING_STATE);
    }

    protected void buildExtraInfoReturned() {
        this.extraInfoReturned.putBoolean(ButtonService.SET_COUNTDOWN_IS_ENABLE, this.isEnable);
    }
}
