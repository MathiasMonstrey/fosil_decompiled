package com.misfit.frameworks.buttonservice.communite.ble;

import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.communite.SessionType;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.BleSessionCallback;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.SessionState;
import com.misfit.frameworks.buttonservice.communite.ble.share.PlayAnimationBaseState;
import com.misfit.frameworks.common.log.MFLogger;

public class PlayAnimationSession extends BleSession {
    private static final String TAG = PlayAnimationSession.class.getSimpleName();

    public class PlayAnimationState extends PlayAnimationBaseState {
        public PlayAnimationState() {
            super(PlayAnimationSession.this.bleAdapter, PlayAnimationSession.this);
            PlayAnimationSession.this.log("Play animation of device with serial " + PlayAnimationSession.this.serial);
        }

        protected BleState getStateOnCompleted(boolean z) {
            if (z) {
                MFLogger.d(PlayAnimationSession.TAG, "All done of " + PlayAnimationSession.TAG);
                PlayAnimationSession.this.stop(0);
            } else {
                PlayAnimationSession.this.stop(201);
            }
            return null;
        }

        protected BleState getStateOnTimeOut() {
            PlayAnimationSession.this.stop(201);
            return null;
        }
    }

    public PlayAnimationSession(BleAdapter bleAdapter, BleSessionCallback bleSessionCallback) {
        super(SessionType.URGENT, CommunicateMode.PLAY_LED_ANIMATION, bleAdapter, bleSessionCallback);
    }

    public BleSession copyObject() {
        BleSession playAnimationSession = new PlayAnimationSession(this.bleAdapter, this.bleSessionCallback);
        playAnimationSession.setDevice(this.device);
        return playAnimationSession;
    }

    protected void initStateMap() {
        this.sessionStateMap.put(SessionState.PLAY_ANIMATION_STATE, PlayAnimationState.class.getName());
    }

    protected boolean onStart(Object... objArr) {
        if (this.bleAdapter.isDeviceReady()) {
            enterState(createConcreteState(SessionState.PLAY_ANIMATION_STATE));
        } else {
            stop(201);
        }
        return true;
    }

    protected void buildExtraInfoReturned() {
    }
}
