package com.misfit.frameworks.buttonservice.communite.ble;

import com.misfit.ble.setting.qmotion.QMotionEnum.LEDColor;
import com.misfit.ble.setting.sam.SAMEnum.VibeEnum;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.communite.SessionType;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.BleSessionCallback;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.SessionState;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.common.log.MFLogger;

public class PlayLightAndVibrationSession extends BleSession {
    private static final String TAG = PlayLightAndVibrationSession.class.getSimpleName();
    private byte blinkNum;
    private LEDColor color;
    private int duration;
    private VibeEnum vibeEnum;

    public class PlayLightAndVibrationState extends BleState {
        public PlayLightAndVibrationState() {
            super(PlayLightAndVibrationSession.TAG);
            PlayLightAndVibrationSession.this.log("Play light and vibration of device with serial " + PlayLightAndVibrationSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            if (PlayLightAndVibrationSession.this.bleAdapter.sendLedAndVibeNotification(PlayLightAndVibrationSession.this.color, PlayLightAndVibrationSession.this.blinkNum, PlayLightAndVibrationSession.this.vibeEnum, PlayLightAndVibrationSession.this.duration)) {
                return true;
            }
            stopTimeout();
            PlayLightAndVibrationSession.this.stop(FailureCode.FAILED_TO_SEND_NOTIFICATION);
            return false;
        }

        protected void onTimeout() {
            super.onTimeout();
            PlayLightAndVibrationSession.this.log("Play light and vibration timeout.");
            PlayLightAndVibrationSession.this.stop(FailureCode.FAILED_TO_SEND_NOTIFICATION);
        }

        public boolean handleOnSendNotificationHandControlCompleted(boolean z) {
            stopTimeout();
            if (z) {
                MFLogger.d(PlayLightAndVibrationSession.TAG, "All done of " + PlayLightAndVibrationSession.TAG);
                PlayLightAndVibrationSession.this.stop(0);
            } else {
                PlayLightAndVibrationSession.this.stop(FailureCode.FAILED_TO_SEND_NOTIFICATION);
            }
            return true;
        }

        public int getTimeout() {
            return 5000;
        }
    }

    public PlayLightAndVibrationSession(BleAdapter bleAdapter, BleSessionCallback bleSessionCallback, LEDColor lEDColor, VibeEnum vibeEnum, byte b, int i) {
        super(SessionType.URGENT, CommunicateMode.PLAY_LIGHT_AND_VIBRATION, bleAdapter, bleSessionCallback);
        this.color = lEDColor;
        this.vibeEnum = vibeEnum;
        this.blinkNum = b;
        this.duration = i;
    }

    public BleSession copyObject() {
        BleSession playLightAndVibrationSession = new PlayLightAndVibrationSession(this.bleAdapter, this.bleSessionCallback, this.color, this.vibeEnum, this.blinkNum, this.duration);
        playLightAndVibrationSession.setDevice(this.device);
        return playLightAndVibrationSession;
    }

    protected void initStateMap() {
        this.sessionStateMap.put(SessionState.PLAY_LIGHT_AND_VIBRATION_STATE, PlayLightAndVibrationState.class.getName());
    }

    protected boolean onStart(Object... objArr) {
        if (this.bleAdapter.isDeviceReady()) {
            return enterState(createConcreteState(SessionState.PLAY_LIGHT_AND_VIBRATION_STATE));
        }
        stop(FailureCode.FAILED_TO_SEND_NOTIFICATION);
        return true;
    }

    protected void buildExtraInfoReturned() {
    }
}
