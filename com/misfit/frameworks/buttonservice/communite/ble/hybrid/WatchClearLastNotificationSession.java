package com.misfit.frameworks.buttonservice.communite.ble.hybrid;

import com.fossil.wearables.fsl.fitness.FitnessProviderImpl;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.communite.SessionType;
import com.misfit.frameworks.buttonservice.communite.ble.BleAdapter;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.BleSessionCallback;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.SessionState;
import com.misfit.frameworks.buttonservice.communite.ble.BleState;
import com.misfit.frameworks.buttonservice.communite.ble.ConnectableSession;
import com.misfit.frameworks.buttonservice.communite.ble.SdkCallback;
import com.misfit.frameworks.buttonservice.log.FailureCode;

public class WatchClearLastNotificationSession extends ConnectableSession {

    public class ClearLastNotificationState extends BleState {
        public ClearLastNotificationState() {
            super(WatchClearLastNotificationSession.this.TAG);
            WatchClearLastNotificationSession.this.log("Clear last notification of device with serial " + WatchClearLastNotificationSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            if (WatchClearLastNotificationSession.this.bleAdapter.clearLastNotification()) {
                return true;
            }
            stopTimeout();
            WatchClearLastNotificationSession.this.stop(FailureCode.FAILED_TO_CLEAR_LAST_NOTIFICATION);
            return false;
        }

        public int getTimeout() {
            return FitnessProviderImpl.DEFAULT_DAILY_STEP_GOAL;
        }

        public boolean handleOnClearLastNotificationCompleted(boolean z) {
            stopTimeout();
            WatchClearLastNotificationSession.this.stop(z ? 0 : FailureCode.FAILED_TO_CLEAR_LAST_NOTIFICATION);
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            WatchClearLastNotificationSession.this.log("Clear last notification timeout.");
            WatchClearLastNotificationSession.this.stop(FailureCode.FAILED_TO_CLEAR_LAST_NOTIFICATION);
        }
    }

    public WatchClearLastNotificationSession(BleAdapter bleAdapter, BleSessionCallback bleSessionCallback, SdkCallback sdkCallback) {
        super(SessionType.URGENT, CommunicateMode.CLEAR_LAST_NOTIFICATION, bleAdapter, bleSessionCallback, sdkCallback);
    }

    public BleSession copyObject() {
        BleSession watchClearLastNotificationSession = new WatchClearLastNotificationSession(this.bleAdapter, this.bleSessionCallback, this.sdkCallback);
        watchClearLastNotificationSession.setDevice(this.device);
        return watchClearLastNotificationSession;
    }

    protected void initStateMap() {
        super.initStateMap();
        this.sessionStateMap.put(SessionState.CLEAR_LAST_NOTIFICATION_STATE, ClearLastNotificationState.class.getName());
    }

    protected BleState getStateAfterConnected() {
        return createConcreteState(SessionState.CLEAR_LAST_NOTIFICATION_STATE);
    }

    protected int getMaxRetries() {
        return 0;
    }

    protected void buildExtraInfoReturned() {
    }
}
