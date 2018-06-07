package com.misfit.frameworks.buttonservice.communite.ble;

import com.fossil.cfj;
import com.misfit.ble.setting.sam.CountdownSettings;
import com.misfit.ble.shine.ShineConfiguration;
import com.misfit.ble.shine.ShineProperty;
import com.misfit.ble.shine.controller.ConfigurationSession;
import com.misfit.frameworks.buttonservice.ButtonService;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.communite.SessionType;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.BleSessionCallback;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.SessionState;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.common.log.MFLogger;
import java.util.Hashtable;

public class GetCountdownSettingSession extends ConnectableSession {
    private static final String TAG = GetCountdownSettingSession.class.getSimpleName();
    private CountdownSettings countdownSetting;

    public class GetCountdownSettingState extends BleState {
        public GetCountdownSettingState() {
            super(GetCountdownSettingSession.TAG);
            GetCountdownSettingSession.this.log("Get countdown setting of device with serial " + GetCountdownSettingSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            if (GetCountdownSettingSession.this.bleAdapter.getCountdown()) {
                return true;
            }
            stopTimeout();
            GetCountdownSettingSession.this.stop(FailureCode.FAILED_TO_GET_COUNTDOWN);
            return false;
        }

        protected void onTimeout() {
            super.onTimeout();
            GetCountdownSettingSession.this.log("Get countdown timeout.");
            GetCountdownSettingSession.this.stop(FailureCode.FAILED_TO_GET_COUNTDOWN);
        }

        public boolean handleOnGetConfigurationCompleted(boolean z, Hashtable<ShineProperty, Object> hashtable) {
            stopTimeout();
            if (z) {
                MFLogger.d(GetCountdownSettingSession.TAG, "All done of " + GetCountdownSettingSession.TAG);
                GetCountdownSettingSession.this.countdownSetting = getCountDownSettings(hashtable);
                GetCountdownSettingSession.this.stop(0);
            } else {
                GetCountdownSettingSession.this.stop(FailureCode.FAILED_TO_GET_COUNTDOWN);
            }
            return true;
        }

        private CountdownSettings getCountDownSettings(Hashtable<ShineProperty, Object> hashtable) {
            if (hashtable != null) {
                ShineConfiguration shineConfiguration;
                ConfigurationSession configurationSession = (ConfigurationSession) hashtable.get(ShineProperty.SHINE_CONFIGURATION_SESSION);
                if (configurationSession != null) {
                    shineConfiguration = configurationSession.mShineConfiguration;
                } else {
                    shineConfiguration = null;
                }
                if (shineConfiguration != null) {
                    return shineConfiguration.mCountdownSettings;
                }
                MFLogger.d(GetCountdownSettingSession.TAG, "Inside " + GetCountdownSettingSession.TAG + ", getVibrationStrength failed, shineConfiguration is null");
            }
            return null;
        }
    }

    public GetCountdownSettingSession(BleAdapter bleAdapter, BleSessionCallback bleSessionCallback, SdkCallback sdkCallback) {
        super(SessionType.BACK_GROUND, CommunicateMode.GET_COUNTDOWN, bleAdapter, bleSessionCallback, sdkCallback);
    }

    public BleSession copyObject() {
        BleSession getCountdownSettingSession = new GetCountdownSettingSession(this.bleAdapter, this.bleSessionCallback, this.sdkCallback);
        getCountdownSettingSession.setDevice(this.device);
        return getCountdownSettingSession;
    }

    protected void initStateMap() {
        super.initStateMap();
        this.sessionStateMap.put(SessionState.GET_COUNT_DOWN_SETTING_STATE, GetCountdownSettingState.class.getName());
    }

    protected BleState getStateAfterConnected() {
        return createConcreteState(SessionState.GET_COUNT_DOWN_SETTING_STATE);
    }

    protected void buildExtraInfoReturned() {
        if (this.countdownSetting != null) {
            this.extraInfoReturned.putString(ButtonService.GET_COUNTDOWN_SETTING, new cfj().b(this.countdownSetting, CountdownSettings.class));
        }
    }
}
