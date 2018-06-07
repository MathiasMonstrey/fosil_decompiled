package com.misfit.frameworks.buttonservice.communite.ble;

import com.fossil.wearables.fsl.fitness.FitnessProviderImpl;
import com.misfit.ble.shine.ShineProfile.ConnectActionResult;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.communite.SessionType;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.BleSessionCallback;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.SessionState;
import com.misfit.frameworks.buttonservice.log.FailureCode;

public class SetStepGoalSession extends ConnectableSession {
    private static final String TAG = SetStepGoalSession.class.getSimpleName();
    private int stepGoal;

    public class SetStepGoalState extends BleState {
        public SetStepGoalState() {
            super(SetStepGoalSession.TAG);
            SetStepGoalSession.this.log("Set step goal to device with serial " + SetStepGoalSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            if (SetStepGoalSession.this.bleAdapter.setGoalInStep((long) SetStepGoalSession.this.stepGoal)) {
                return true;
            }
            stopTimeout();
            SetStepGoalSession.this.stop(FailureCode.FAILED_TO_SET_STEP_GOAL);
            return false;
        }

        public int getTimeout() {
            return FitnessProviderImpl.DEFAULT_DAILY_STEP_GOAL;
        }

        protected void onTimeout() {
            super.onTimeout();
            SetStepGoalSession.this.log("Set step goal timeout.");
            SetStepGoalSession.this.stop(FailureCode.FAILED_TO_SET_STEP_GOAL);
        }

        public boolean handleOnSetConfigurationCompleted(boolean z) {
            stopTimeout();
            if (z) {
                SetStepGoalSession.this.stop(0);
            } else {
                SetStepGoalSession.this.stop(FailureCode.FAILED_TO_SET_STEP_GOAL);
            }
            return true;
        }

        public boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult) {
            stopTimeout();
            SetStepGoalSession.this.stop(FailureCode.UNEXPECTED_DISCONNECT);
            return true;
        }
    }

    public SetStepGoalSession(int i, BleAdapter bleAdapter, BleSessionCallback bleSessionCallback, SdkCallback sdkCallback) {
        super(SessionType.URGENT, CommunicateMode.SET_STEP_GOAL, bleAdapter, bleSessionCallback, sdkCallback);
        this.stepGoal = i;
    }

    public BleSession copyObject() {
        BleSession setStepGoalSession = new SetStepGoalSession(this.stepGoal, this.bleAdapter, this.bleSessionCallback, this.sdkCallback);
        setStepGoalSession.setDevice(this.device);
        return setStepGoalSession;
    }

    protected void initStateMap() {
        super.initStateMap();
        this.sessionStateMap.put(SessionState.SET_STEP_GOAL_STATE, SetStepGoalState.class.getName());
    }

    protected BleState getStateAfterConnected() {
        return createConcreteState(SessionState.SET_STEP_GOAL_STATE);
    }

    protected void buildExtraInfoReturned() {
    }
}
