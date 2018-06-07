package com.misfit.frameworks.buttonservice.communite.ble;

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

public class GetVibrationStrengthSession extends ConnectableSession {
    private static final String TAG = GetVibrationStrengthSession.class.getSimpleName();
    private short vibrationStrengthLevel;

    public class GetVibrationStrengthState extends BleState {
        public GetVibrationStrengthState() {
            super(GetVibrationStrengthSession.TAG);
            GetVibrationStrengthSession.this.log("Get vibration strength of device with serial " + GetVibrationStrengthSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            if (GetVibrationStrengthSession.this.device.isSupportDeviceState(CommunicateMode.GET_VIBRATION_STRENGTH)) {
                startTimeout();
                if (GetVibrationStrengthSession.this.bleAdapter.getVibrationStrength()) {
                    return true;
                }
                stopTimeout();
                GetVibrationStrengthSession.this.stop(FailureCode.FAILED_TO_GET_VIBRATION_STRENGTH);
                return false;
            }
            GetVibrationStrengthSession.this.log("Get vibration strength function is not supported");
            GetVibrationStrengthSession.this.stop(FailureCode.FAILED_TO_GET_VIBRATION_STRENGTH);
            return false;
        }

        protected void onTimeout() {
            super.onTimeout();
            GetVibrationStrengthSession.this.log("Get vibration strength timeout.");
            GetVibrationStrengthSession.this.stop(FailureCode.FAILED_TO_GET_VIBRATION_STRENGTH);
        }

        public boolean handleOnGetConfigurationCompleted(boolean z, Hashtable<ShineProperty, Object> hashtable) {
            stopTimeout();
            if (z) {
                MFLogger.d(GetVibrationStrengthSession.TAG, "All done of " + GetVibrationStrengthSession.TAG);
                GetVibrationStrengthSession.this.vibrationStrengthLevel = getVibrationStrength(hashtable);
                GetVibrationStrengthSession.this.stop(0);
            } else {
                GetVibrationStrengthSession.this.stop(FailureCode.FAILED_TO_GET_VIBRATION_STRENGTH);
            }
            return true;
        }

        private short getVibrationStrength(Hashtable<ShineProperty, Object> hashtable) {
            if (hashtable != null) {
                ShineConfiguration shineConfiguration;
                ConfigurationSession configurationSession = (ConfigurationSession) hashtable.get(ShineProperty.SHINE_CONFIGURATION_SESSION);
                if (configurationSession != null) {
                    shineConfiguration = configurationSession.mShineConfiguration;
                } else {
                    shineConfiguration = null;
                }
                if (shineConfiguration != null) {
                    return shineConfiguration.mVibeStrength;
                }
                MFLogger.d(GetVibrationStrengthSession.TAG, "Inside " + GetVibrationStrengthSession.TAG + ", getVibrationStrength failed, shineConfiguration is null");
            }
            return (short) 75;
        }
    }

    public GetVibrationStrengthSession(BleAdapter bleAdapter, BleSessionCallback bleSessionCallback, SdkCallback sdkCallback) {
        super(SessionType.BACK_GROUND, CommunicateMode.GET_VIBRATION_STRENGTH, bleAdapter, bleSessionCallback, sdkCallback);
    }

    public BleSession copyObject() {
        BleSession getVibrationStrengthSession = new GetVibrationStrengthSession(this.bleAdapter, this.bleSessionCallback, this.sdkCallback);
        getVibrationStrengthSession.setDevice(this.device);
        return getVibrationStrengthSession;
    }

    protected void initStateMap() {
        super.initStateMap();
        this.sessionStateMap.put(SessionState.GET_VIBRATION_STRENGTH_STATE, GetVibrationStrengthState.class.getName());
    }

    protected BleState getStateAfterConnected() {
        return createConcreteState(SessionState.GET_VIBRATION_STRENGTH_STATE);
    }

    protected void buildExtraInfoReturned() {
        this.extraInfoReturned.putInt(ButtonService.VIBRATION_STRENGTH_LEVEL, this.vibrationStrengthLevel);
    }
}
