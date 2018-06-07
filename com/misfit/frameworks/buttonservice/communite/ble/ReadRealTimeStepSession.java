package com.misfit.frameworks.buttonservice.communite.ble;

import android.os.Bundle;
import com.fossil.wearables.fsl.fitness.FitnessProviderImpl;
import com.misfit.ble.shine.ShineConfiguration;
import com.misfit.ble.shine.ShineProfile.ConnectActionResult;
import com.misfit.ble.shine.ShineProperty;
import com.misfit.ble.shine.controller.ConfigurationSession;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.communite.SessionType;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.BleSessionCallback;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.SessionState;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.common.log.MFLogger;
import java.util.Hashtable;

public class ReadRealTimeStepSession extends BleSession {
    public static final String STEPS = "STEPS";
    private static final String TAG = ReadRealTimeStepState.class.getSimpleName();
    private long realTimeSteps = -1;

    public class ReadRealTimeStepState extends BleState {
        public ReadRealTimeStepState() {
            super(ReadRealTimeStepSession.TAG);
            ReadRealTimeStepSession.this.log("Read real time steps of device with serial " + ReadRealTimeStepSession.this.serial);
        }

        public int getTimeout() {
            return FitnessProviderImpl.DEFAULT_DAILY_STEP_GOAL;
        }

        protected void onTimeout() {
            super.onTimeout();
            ReadRealTimeStepSession.this.log("Read real time steps timeout.");
            ReadRealTimeStepSession.this.stop(FailureCode.FAILED_TO_GET_REAL_TIME_STEP);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            ReadRealTimeStepSession.this.bleAdapter.getRealTimeStep();
            return true;
        }

        public boolean handleOnGetConfigurationCompleted(boolean z, Hashtable<ShineProperty, Object> hashtable) {
            stopTimeout();
            if (z) {
                ReadRealTimeStepSession.this.realTimeSteps = getRealTimeSteps(hashtable);
                ReadRealTimeStepSession.this.stop(0);
            } else {
                ReadRealTimeStepSession.this.stop(FailureCode.UNKNOWN_ERROR);
            }
            return true;
        }

        private long getRealTimeSteps(Hashtable<ShineProperty, Object> hashtable) {
            if (hashtable != null) {
                ShineConfiguration shineConfiguration;
                ConfigurationSession configurationSession = (ConfigurationSession) hashtable.get(ShineProperty.SHINE_CONFIGURATION_SESSION);
                if (configurationSession != null) {
                    shineConfiguration = configurationSession.mShineConfiguration;
                } else {
                    shineConfiguration = null;
                }
                if (shineConfiguration != null) {
                    return shineConfiguration.mCurrentSteps;
                }
                MFLogger.d(ReadRealTimeStepSession.TAG, "Inside " + ReadRealTimeStepSession.TAG + ", getVibrationStrength failed, shineConfiguration is null");
            }
            return 0;
        }

        public boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult) {
            stopTimeout();
            ReadRealTimeStepSession.this.stop(FailureCode.UNEXPECTED_DISCONNECT);
            return true;
        }
    }

    public ReadRealTimeStepSession(BleAdapter bleAdapter, BleSessionCallback bleSessionCallback) {
        super(SessionType.BACK_GROUND, CommunicateMode.READ_REAL_TIME_STEP, bleAdapter, bleSessionCallback);
    }

    public BleSession copyObject() {
        BleSession readRealTimeStepSession = new ReadRealTimeStepSession(this.bleAdapter, this.bleSessionCallback);
        readRealTimeStepSession.setDevice(this.device);
        return readRealTimeStepSession;
    }

    protected void initStateMap() {
        this.sessionStateMap.put(SessionState.READ_REAL_TIME_STEP_STATE, ReadRealTimeStepState.class.getName());
    }

    protected boolean onStart(Object... objArr) {
        return enterState(createConcreteState(SessionState.READ_REAL_TIME_STEP_STATE));
    }

    protected void buildExtraInfoReturned() {
        this.extraInfoReturned = new Bundle();
        this.extraInfoReturned.putLong(STEPS, this.realTimeSteps);
    }
}
