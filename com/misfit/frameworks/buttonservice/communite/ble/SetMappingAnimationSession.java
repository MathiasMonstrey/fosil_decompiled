package com.misfit.frameworks.buttonservice.communite.ble;

import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.communite.SessionType;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.BleSessionCallback;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.SessionState;
import com.misfit.frameworks.buttonservice.communite.ble.share.SetMappingAnimationBaseState;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.common.log.MFLogger;

public class SetMappingAnimationSession extends ConnectableSession {

    public class SetMappingAnimationState extends SetMappingAnimationBaseState {
        public SetMappingAnimationState() {
            super(SetMappingAnimationSession.this.bleAdapter, SetMappingAnimationSession.this);
            SetMappingAnimationSession.this.log("Set mapping animation to device with serial " + SetMappingAnimationSession.this.serial);
        }

        protected BleState getStateOnTimeOut() {
            SetMappingAnimationSession.this.stop(FailureCode.FAILED_TO_SET_MAPPING_ANIMATION);
            return null;
        }

        protected BleState getStateOnCompleted(boolean z) {
            if (z) {
                MFLogger.d(SetMappingAnimationSession.this.TAG, "All done of " + SetMappingAnimationSession.this.TAG);
                SetMappingAnimationSession.this.stop(0);
            } else {
                SetMappingAnimationSession.this.stop(FailureCode.FAILED_TO_SET_MAPPING_ANIMATION);
            }
            return null;
        }
    }

    public SetMappingAnimationSession(BleAdapter bleAdapter, BleSessionCallback bleSessionCallback, SdkCallback sdkCallback) {
        super(SessionType.BACK_GROUND, CommunicateMode.SET_MAPPING_ANIMATION, bleAdapter, bleSessionCallback, sdkCallback);
    }

    public BleSession copyObject() {
        BleSession setMappingAnimationSession = new SetMappingAnimationSession(this.bleAdapter, this.bleSessionCallback, this.sdkCallback);
        setMappingAnimationSession.setDevice(this.device);
        return setMappingAnimationSession;
    }

    protected void initStateMap() {
        super.initStateMap();
        this.sessionStateMap.put(SessionState.SET_MAPPING_ANIMATIONS_STATE, SetMappingAnimationState.class.getName());
    }

    protected BleState getStateAfterConnected() {
        return createConcreteState(SessionState.SET_MAPPING_ANIMATIONS_STATE);
    }

    protected void buildExtraInfoReturned() {
    }
}
