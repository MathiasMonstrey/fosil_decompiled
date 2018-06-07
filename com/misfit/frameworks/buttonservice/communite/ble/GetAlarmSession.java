package com.misfit.frameworks.buttonservice.communite.ble;

import com.fossil.cfj;
import com.misfit.ble.setting.pluto.AlarmSettings;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.communite.SessionType;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.BleSessionCallback;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.SessionState;
import com.misfit.frameworks.buttonservice.log.FailureCode;

public class GetAlarmSession extends ConnectableSession {
    private static final String ALARM_SETTINGS = "alarmSettings";
    private AlarmSettings alarmSettings;

    public class GetAlarmState extends BleState {
        public GetAlarmState() {
            super(GetAlarmSession.this.TAG);
            GetAlarmSession.this.log("Get alarm of device with serial " + GetAlarmSession.this.serial);
        }

        public boolean onEnter() {
            super.onEnter();
            startTimeout();
            if (GetAlarmSession.this.bleAdapter.getAlarm()) {
                return true;
            }
            stopTimeout();
            GetAlarmSession.this.stop(FailureCode.FAILED_TO_GET_ALARM);
            return false;
        }

        protected void onTimeout() {
            super.onTimeout();
            GetAlarmSession.this.log("Get alarm timeout.");
            GetAlarmSession.this.stop(FailureCode.FAILED_TO_GET_ALARM);
        }

        public boolean handleOnGettingAlarmCompleted(boolean z, AlarmSettings alarmSettings) {
            stopTimeout();
            if (z) {
                GetAlarmSession.this.alarmSettings = alarmSettings;
                GetAlarmSession.this.stop(0);
            } else {
                GetAlarmSession.this.stop(FailureCode.FAILED_TO_GET_ALARM);
            }
            return true;
        }
    }

    public GetAlarmSession(BleAdapter bleAdapter, BleSessionCallback bleSessionCallback, SdkCallback sdkCallback) {
        super(SessionType.UI, CommunicateMode.GET_ALARM, bleAdapter, bleSessionCallback, sdkCallback);
    }

    public BleSession copyObject() {
        BleSession getAlarmSession = new GetAlarmSession(this.bleAdapter, this.bleSessionCallback, this.sdkCallback);
        getAlarmSession.setDevice(this.device);
        return getAlarmSession;
    }

    protected void initStateMap() {
        super.initStateMap();
        this.sessionStateMap.put(SessionState.GET_ALARM_STATE, GetAlarmState.class.getName());
    }

    protected BleState getStateAfterConnected() {
        return createConcreteState(SessionState.GET_ALARM_STATE);
    }

    protected void buildExtraInfoReturned() {
        if (this.alarmSettings != null) {
            this.extraInfoReturned.putString(ALARM_SETTINGS, new cfj().toJson(this.alarmSettings));
        }
    }
}
