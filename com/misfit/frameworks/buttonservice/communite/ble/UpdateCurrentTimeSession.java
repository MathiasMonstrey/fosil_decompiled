package com.misfit.frameworks.buttonservice.communite.ble;

import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.BleSessionCallback;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.SessionState;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.common.log.MFLogger;

public class UpdateCurrentTimeSession extends BleSession {
    private static final String TAG = UpdateCurrentTimeSession.class.getSimpleName();

    public class UpdateCurrentTimeState extends BleState {
        public UpdateCurrentTimeState() {
            super(UpdateCurrentTimeSession.TAG);
            UpdateCurrentTimeSession.this.log("Update current time of device with serial " + UpdateCurrentTimeSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            if (UpdateCurrentTimeSession.this.bleAdapter.setCurrentTime()) {
                return true;
            }
            stopTimeout();
            UpdateCurrentTimeSession.this.stop(FailureCode.FAILED_TO_SET_TIME);
            return false;
        }

        protected void onTimeout() {
            super.onTimeout();
            UpdateCurrentTimeSession.this.log("Update current time timeout.");
            UpdateCurrentTimeSession.this.stop(FailureCode.FAILED_TO_SET_TIME);
        }

        public boolean handleOnSetConfigurationCompleted(boolean z) {
            stopTimeout();
            if (z) {
                MFLogger.d(UpdateCurrentTimeSession.TAG, "All done of " + UpdateCurrentTimeSession.TAG);
                UpdateCurrentTimeSession.this.stop(0);
            } else {
                UpdateCurrentTimeSession.this.stop(FailureCode.FAILED_TO_SET_TIME);
            }
            return true;
        }
    }

    public UpdateCurrentTimeSession(BleAdapter bleAdapter, BleSessionCallback bleSessionCallback) {
        super(CommunicateMode.UPDATE_CURRENT_TIME, bleAdapter, bleSessionCallback);
    }

    public BleSession copyObject() {
        BleSession updateCurrentTimeSession = new UpdateCurrentTimeSession(this.bleAdapter, this.bleSessionCallback);
        updateCurrentTimeSession.setDevice(this.device);
        return updateCurrentTimeSession;
    }

    protected void initStateMap() {
        this.sessionStateMap.put(SessionState.UPDATE_CURRENT_TIME_STATE, UpdateCurrentTimeState.class.getName());
    }

    protected boolean onStart(Object... objArr) {
        if (this.bleAdapter.isDeviceReady()) {
            enterState(createConcreteState(SessionState.UPDATE_CURRENT_TIME_STATE));
        } else {
            stop(FailureCode.FAILED_TO_SET_TIME);
        }
        return true;
    }

    protected void buildExtraInfoReturned() {
    }
}
