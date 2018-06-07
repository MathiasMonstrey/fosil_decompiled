package com.misfit.frameworks.buttonservice.communite.ble;

import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.communite.SessionType;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.BleSessionCallback;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.SessionState;
import com.misfit.frameworks.buttonservice.log.FailureCode;

public class ClearAllAlarmsSession extends ConnectableSession {

    public class ClearAlarmState extends BleState {
        public ClearAlarmState() {
            super(ClearAllAlarmsSession.this.TAG);
            ClearAllAlarmsSession.this.log("Clear alarms of device with serial " + ClearAllAlarmsSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            if (ClearAllAlarmsSession.this.bleAdapter.disableAlarm()) {
                return true;
            }
            stopTimeout();
            ClearAllAlarmsSession.this.stop(FailureCode.FAILED_TO_CLEAR_ALARM);
            return false;
        }

        public boolean handleOnClearAllAlarmsCompleted(boolean z) {
            stopTimeout();
            if (z) {
                ClearAllAlarmsSession.this.stop(0);
            } else {
                ClearAllAlarmsSession.this.stop(FailureCode.FAILED_TO_CLEAR_ALARM);
            }
            return true;
        }

        protected void onTimeout() {
            super.onTimeout();
            ClearAllAlarmsSession.this.log("Clear alarms timeout.");
            ClearAllAlarmsSession.this.stop(FailureCode.FAILED_TO_CLEAR_ALARM);
        }
    }

    public ClearAllAlarmsSession(BleAdapter bleAdapter, BleSessionCallback bleSessionCallback, SdkCallback sdkCallback) {
        super(SessionType.URGENT, CommunicateMode.CLEAR_ALARM, bleAdapter, bleSessionCallback, sdkCallback);
    }

    public BleSession copyObject() {
        BleSession clearAllAlarmsSession = new ClearAllAlarmsSession(this.bleAdapter, this.bleSessionCallback, this.sdkCallback);
        clearAllAlarmsSession.setDevice(this.device);
        return clearAllAlarmsSession;
    }

    protected void initStateMap() {
        super.initStateMap();
        this.sessionStateMap.put(SessionState.CLEAR_ALARM_STATE, ClearAlarmState.class.getName());
    }

    protected BleState getStateAfterConnected() {
        return createConcreteState(SessionState.CLEAR_ALARM_STATE);
    }

    protected void buildExtraInfoReturned() {
    }
}
