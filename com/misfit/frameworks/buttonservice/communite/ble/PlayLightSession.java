package com.misfit.frameworks.buttonservice.communite.ble;

import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.communite.SessionType;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.BleSessionCallback;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.SessionState;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.buttonservice.model.animation.LightVibrationSetting;
import com.misfit.frameworks.common.log.MFLogger;

public class PlayLightSession extends BleSession {
    private static final String TAG = PlayLightSession.class.getSimpleName();
    private LightVibrationSetting lightVibrationSetting;

    public class PlayLightState extends BleState {
        public PlayLightState() {
            super(PlayLightSession.TAG);
            PlayLightSession.this.log("Play light of device with serial " + PlayLightSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            if (PlayLightSession.this.bleAdapter.playLight(PlayLightSession.this.lightVibrationSetting)) {
                return true;
            }
            stopTimeout();
            PlayLightSession.this.stop(FailureCode.FAILED_TO_PLAY_LIGHT_VIBRATION);
            return false;
        }

        protected void onTimeout() {
            super.onTimeout();
            PlayLightSession.this.log("Play light timeout.");
            PlayLightSession.this.stop(FailureCode.FAILED_TO_PLAY_LIGHT_VIBRATION);
        }

        public boolean handleOnPlayLightCompleted(boolean z) {
            stopTimeout();
            if (z) {
                MFLogger.d(PlayLightSession.TAG, "All done of " + PlayLightSession.TAG);
                PlayLightSession.this.stop(0);
            } else {
                PlayLightSession.this.stop(FailureCode.FAILED_TO_PLAY_LIGHT_VIBRATION);
            }
            return true;
        }

        public int getTimeout() {
            return 5000;
        }
    }

    public PlayLightSession(BleAdapter bleAdapter, BleSessionCallback bleSessionCallback, LightVibrationSetting lightVibrationSetting) {
        super(SessionType.URGENT, CommunicateMode.PLAY_LIGHT, bleAdapter, bleSessionCallback);
        this.lightVibrationSetting = lightVibrationSetting;
    }

    public BleSession copyObject() {
        BleSession playLightSession = new PlayLightSession(this.bleAdapter, this.bleSessionCallback, this.lightVibrationSetting);
        playLightSession.setDevice(this.device);
        return playLightSession;
    }

    protected void initStateMap() {
        this.sessionStateMap.put(SessionState.PLAY_LIGHT_STATE, PlayLightState.class.getName());
    }

    protected boolean onStart(Object... objArr) {
        if (this.bleAdapter.isDeviceReady()) {
            enterState(createConcreteState(SessionState.PLAY_LIGHT_STATE));
        } else {
            stop(FailureCode.FAILED_TO_PLAY_LIGHT_VIBRATION);
        }
        return true;
    }

    protected void buildExtraInfoReturned() {
    }
}
