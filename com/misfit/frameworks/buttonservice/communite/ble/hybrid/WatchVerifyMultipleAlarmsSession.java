package com.misfit.frameworks.buttonservice.communite.ble.hybrid;

import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.communite.SessionType;
import com.misfit.frameworks.buttonservice.communite.ble.BleAdapter;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.BleSessionCallback;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.SessionState;
import com.misfit.frameworks.buttonservice.communite.ble.BleState;
import com.misfit.frameworks.buttonservice.communite.ble.ConnectableSession;
import com.misfit.frameworks.buttonservice.communite.ble.SdkCallback;

public class WatchVerifyMultipleAlarmsSession extends ConnectableSession {
    private int alarmFrameLength;

    public class SetMultipleAlarmsState extends BleState {
        public SetMultipleAlarmsState() {
            super(WatchVerifyMultipleAlarmsSession.this.TAG);
            WatchVerifyMultipleAlarmsSession.this.log("Set multiple alarms to device with serial " + WatchVerifyMultipleAlarmsSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            if (WatchVerifyMultipleAlarmsSession.this.bleAdapter.verifyMultipleAlarms(WatchVerifyMultipleAlarmsSession.this.alarmFrameLength)) {
                return true;
            }
            stopTimeout();
            WatchVerifyMultipleAlarmsSession.this.stop(101);
            return false;
        }

        public boolean handleOnVerifyMultipleAlarmsCompleted(boolean z) {
            stopTimeout();
            if (z) {
                WatchVerifyMultipleAlarmsSession.this.stop(0);
            }
            WatchVerifyMultipleAlarmsSession.this.stop(101);
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            WatchVerifyMultipleAlarmsSession.this.log("Set multiple alarms timeout.");
            WatchVerifyMultipleAlarmsSession.this.stop(101);
        }
    }

    public WatchVerifyMultipleAlarmsSession(int i, BleAdapter bleAdapter, BleSessionCallback bleSessionCallback, SdkCallback sdkCallback) {
        super(SessionType.UI, CommunicateMode.VERIFY_LIST_ALARM, bleAdapter, bleSessionCallback, sdkCallback);
        this.alarmFrameLength = i;
    }

    public BleSession copyObject() {
        BleSession watchVerifyMultipleAlarmsSession = new WatchVerifyMultipleAlarmsSession(this.alarmFrameLength, this.bleAdapter, this.bleSessionCallback, this.sdkCallback);
        watchVerifyMultipleAlarmsSession.setDevice(this.device);
        return watchVerifyMultipleAlarmsSession;
    }

    protected void initStateMap() {
        super.initStateMap();
        this.sessionStateMap.put(SessionState.SET_MULTIPLE_ALARMS_STATE, SetMultipleAlarmsState.class.getName());
    }

    protected BleState getStateAfterConnected() {
        return createConcreteState(SessionState.SET_MULTIPLE_ALARMS_STATE);
    }

    protected void buildExtraInfoReturned() {
    }
}
