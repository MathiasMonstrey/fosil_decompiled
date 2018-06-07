package com.misfit.frameworks.buttonservice.communite.ble.hybrid;

import com.fossil.wearables.fsl.fitness.FitnessProviderImpl;
import com.misfit.ble.setting.sam.SAMEnum.VibeEnum;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.communite.SessionType;
import com.misfit.frameworks.buttonservice.communite.ble.BleAdapter;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.BleSessionCallback;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.SessionState;
import com.misfit.frameworks.buttonservice.communite.ble.BleState;
import com.misfit.frameworks.buttonservice.model.CalibrationEnums.HandId;
import java.util.List;

public class WatchSendNotificationSession extends BleSession {
    private int[] degree;
    private int duration;
    private List<HandId> handIdList;
    private boolean isUIAction;
    private VibeEnum vibeEnum;

    public class PlayHandAnimationState extends BleState {
        public PlayHandAnimationState() {
            super(WatchSendNotificationSession.this.TAG);
            WatchSendNotificationSession.this.log("Play hand animation of device with serial " + WatchSendNotificationSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            if (WatchSendNotificationSession.this.bleAdapter.sendHandNotification(WatchSendNotificationSession.this.handIdList, WatchSendNotificationSession.this.vibeEnum, WatchSendNotificationSession.this.duration, WatchSendNotificationSession.this.degree)) {
                return true;
            }
            stopTimeout();
            WatchSendNotificationSession.this.stop(0);
            return false;
        }

        public int getTimeout() {
            return FitnessProviderImpl.DEFAULT_DAILY_STEP_GOAL;
        }

        public boolean handleOnSendNotificationHandControlCompleted(boolean z) {
            stopTimeout();
            WatchSendNotificationSession.this.stop(0);
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            WatchSendNotificationSession.this.log("Play hand animation timeout.");
            WatchSendNotificationSession.this.stop(0);
        }
    }

    public WatchSendNotificationSession(List<HandId> list, VibeEnum vibeEnum, int[] iArr, int i, BleAdapter bleAdapter, BleSessionCallback bleSessionCallback, boolean z) {
        super(z ? SessionType.UI : SessionType.URGENT, CommunicateMode.SEND_NOTIFICATION, bleAdapter, bleSessionCallback);
        this.handIdList = list;
        this.vibeEnum = vibeEnum;
        this.degree = iArr;
        this.duration = i;
        this.isUIAction = z;
    }

    public BleSession copyObject() {
        BleSession watchSendNotificationSession = new WatchSendNotificationSession(this.handIdList, this.vibeEnum, this.degree, this.duration, this.bleAdapter, this.bleSessionCallback, this.isUIAction);
        watchSendNotificationSession.setDevice(this.device);
        return watchSendNotificationSession;
    }

    protected void initStateMap() {
        this.sessionStateMap.put(SessionState.PLAY_HAND_ANIMATION_STATE, PlayHandAnimationState.class.getName());
    }

    protected boolean onStart(Object... objArr) {
        return enterState(createConcreteState(SessionState.PLAY_HAND_ANIMATION_STATE));
    }

    protected void buildExtraInfoReturned() {
    }
}
