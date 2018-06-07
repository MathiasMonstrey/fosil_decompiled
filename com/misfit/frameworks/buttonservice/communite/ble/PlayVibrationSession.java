package com.misfit.frameworks.buttonservice.communite.ble;

import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.communite.SessionType;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.BleSessionCallback;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.SessionState;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.buttonservice.model.animation.LightVibrationSetting;
import com.misfit.frameworks.common.log.MFLogger;

public class PlayVibrationSession extends BleSession {
    private static final String TAG = PlayVibrationSession.class.getSimpleName();
    private LightVibrationSetting lightVibrationSetting;

    public class PlayVibrationState extends BleState {
        public PlayVibrationState() {
            super(PlayVibrationSession.TAG);
            PlayVibrationSession.this.log("Play vibration of device with serial " + PlayVibrationSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            if (PlayVibrationSession.this.bleAdapter.playVibration(PlayVibrationSession.this.lightVibrationSetting)) {
                return true;
            }
            stopTimeout();
            PlayVibrationSession.this.stop(FailureCode.FAILED_TO_PLAY_VIBRATION);
            return false;
        }

        protected void onTimeout() {
            super.onTimeout();
            PlayVibrationSession.this.log("Play vibration timeout.");
            PlayVibrationSession.this.stop(FailureCode.FAILED_TO_PLAY_VIBRATION);
        }

        public boolean handleOnPlayVibrationCompleted(boolean z) {
            stopTimeout();
            if (z) {
                MFLogger.d(PlayVibrationSession.TAG, "All done of " + PlayVibrationSession.TAG);
                PlayVibrationSession.this.stop(0);
            } else {
                PlayVibrationSession.this.stop(FailureCode.FAILED_TO_PLAY_VIBRATION);
            }
            return true;
        }

        public boolean handleOnSendNotificationHandControlCompleted(boolean z) {
            stopTimeout();
            if (z) {
                MFLogger.d(PlayVibrationSession.TAG, "All done of " + PlayVibrationSession.TAG);
                PlayVibrationSession.this.stop(0);
            } else {
                PlayVibrationSession.this.stop(FailureCode.FAILED_TO_PLAY_VIBRATION);
            }
            return true;
        }

        public int getTimeout() {
            return 5000;
        }
    }

    public PlayVibrationSession(BleAdapter bleAdapter, BleSessionCallback bleSessionCallback, LightVibrationSetting lightVibrationSetting) {
        super(SessionType.UI, CommunicateMode.PLAY_VIBRATION, bleAdapter, bleSessionCallback);
        this.lightVibrationSetting = lightVibrationSetting;
    }

    public BleSession copyObject() {
        BleSession playVibrationSession = new PlayVibrationSession(this.bleAdapter, this.bleSessionCallback, this.lightVibrationSetting);
        playVibrationSession.setDevice(this.device);
        return playVibrationSession;
    }

    protected void initStateMap() {
        this.sessionStateMap.put(SessionState.PLAY_VIBRATION_STATE, PlayVibrationState.class.getName());
    }

    protected boolean onStart(Object... objArr) {
        if (this.bleAdapter.isDeviceReady()) {
            enterState(createConcreteState(SessionState.PLAY_VIBRATION_STATE));
        } else {
            stop(FailureCode.FAILED_TO_PLAY_VIBRATION);
        }
        return true;
    }

    protected void buildExtraInfoReturned() {
    }
}
