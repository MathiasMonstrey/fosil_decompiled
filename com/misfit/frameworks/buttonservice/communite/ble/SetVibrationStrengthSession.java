package com.misfit.frameworks.buttonservice.communite.ble;

import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.communite.SessionType;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.BleSessionCallback;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.SessionState;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.common.log.MFLogger;

public class SetVibrationStrengthSession extends ConnectableSession {
    private static final String TAG = SetVibrationStrengthSession.class.getSimpleName();
    private short vibrationStrengthLevel;

    public class SetVibrationStrengthState extends BleState {
        public SetVibrationStrengthState() {
            super(SetVibrationStrengthSession.TAG);
            SetVibrationStrengthSession.this.log("Set vibration strength to device with serial " + SetVibrationStrengthSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            if (SetVibrationStrengthSession.this.device.isSupportDeviceState(CommunicateMode.SET_VIBRATION_STRENGTH)) {
                startTimeout();
                if (!SetVibrationStrengthSession.this.device.isSupportDeviceState(CommunicateMode.SET_VIBRATION_STRENGTH) || SetVibrationStrengthSession.this.bleAdapter.setVibrationStrength(SetVibrationStrengthSession.this.vibrationStrengthLevel)) {
                    return true;
                }
                stopTimeout();
                SetVibrationStrengthSession.this.stop(FailureCode.FAILED_TO_SET_VIBRATION_STRENGTH);
                return false;
            }
            SetVibrationStrengthSession.this.log("Set vibration strength function is not supported");
            SetVibrationStrengthSession.this.stop(FailureCode.FAILED_TO_SET_VIBRATION_STRENGTH);
            return false;
        }

        protected void onTimeout() {
            super.onTimeout();
            SetVibrationStrengthSession.this.log("Set vibration strength timeout.");
            SetVibrationStrengthSession.this.stop(FailureCode.FAILED_TO_SET_VIBRATION_STRENGTH);
        }

        public boolean handleOnSetConfigurationCompleted(boolean z) {
            stopTimeout();
            if (z) {
                MFLogger.d(SetVibrationStrengthSession.TAG, "All done of " + SetVibrationStrengthSession.TAG);
                SetVibrationStrengthSession.this.stop(0);
            } else {
                SetVibrationStrengthSession.this.stop(FailureCode.FAILED_TO_SET_VIBRATION_STRENGTH);
            }
            return true;
        }
    }

    public SetVibrationStrengthSession(BleAdapter bleAdapter, BleSessionCallback bleSessionCallback, SdkCallback sdkCallback, short s) {
        super(SessionType.UI, CommunicateMode.SET_VIBRATION_STRENGTH, bleAdapter, bleSessionCallback, sdkCallback);
        this.vibrationStrengthLevel = s;
    }

    public BleSession copyObject() {
        BleSession setVibrationStrengthSession = new SetVibrationStrengthSession(this.bleAdapter, this.bleSessionCallback, this.sdkCallback, this.vibrationStrengthLevel);
        setVibrationStrengthSession.setDevice(this.device);
        return setVibrationStrengthSession;
    }

    protected void initStateMap() {
        super.initStateMap();
        this.sessionStateMap.put(SessionState.SET_VIBRATION_STRENGTH_STATE, SetVibrationStrengthState.class.getName());
    }

    protected BleState getStateAfterConnected() {
        return createConcreteState(SessionState.SET_VIBRATION_STRENGTH_STATE);
    }

    protected void buildExtraInfoReturned() {
    }
}
