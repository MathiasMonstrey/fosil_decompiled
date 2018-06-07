package com.misfit.frameworks.buttonservice.communite.ble.share;

import com.misfit.ble.setting.pluto.AlarmSettings;
import com.misfit.ble.shine.ShineProfile.ConnectActionResult;
import com.misfit.frameworks.buttonservice.communite.ble.BleAdapter;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession;
import com.misfit.frameworks.buttonservice.communite.ble.BleState;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;

public abstract class SetAlarmBaseState extends BleState {
    private AlarmSettings alarmSettings;
    private BleAdapter bleAdapter;
    private BleSession currentSession;

    public abstract BleState getStateOnCompleted(boolean z);

    public abstract BleState getStateOnTimeOut();

    public SetAlarmBaseState(AlarmSettings alarmSettings, BleAdapter bleAdapter, BleSession bleSession) {
        super(bleSession.getClass().getSimpleName());
        this.bleAdapter = bleAdapter;
        this.currentSession = bleSession;
        this.alarmSettings = alarmSettings;
    }

    public boolean onEnter() {
        boolean enableAlarm;
        super.onEnter();
        startTimeout();
        if (this.alarmSettings != null) {
            enableAlarm = this.bleAdapter.enableAlarm(this.alarmSettings);
        } else {
            enableAlarm = this.bleAdapter.disableAlarm();
        }
        if (enableAlarm) {
            return true;
        }
        stopTimeout();
        BleState stateOnCompleted = getStateOnCompleted(false);
        if (stateOnCompleted == null) {
            return false;
        }
        this.currentSession.enterStateWithDelayTime(stateOnCompleted, MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
        return false;
    }

    public boolean handleOnSettingSingleAlarmCompleted(boolean z) {
        stopTimeout();
        this.currentSession.enterState(getStateOnCompleted(z));
        return true;
    }

    public boolean handleOnClearAllAlarmsCompleted(boolean z) {
        stopTimeout();
        this.currentSession.enterState(getStateOnCompleted(z));
        return true;
    }

    public boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult) {
        stopTimeout();
        this.currentSession.stop(FailureCode.UNEXPECTED_DISCONNECT);
        return true;
    }

    protected void onTimeout() {
        super.onTimeout();
        this.currentSession.log("Set alarm timeout.");
        this.currentSession.enterState(getStateOnTimeOut());
    }
}
