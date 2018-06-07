package com.misfit.frameworks.buttonservice.communite.ble.share;

import com.misfit.ble.setting.sam.MultipleAlarmSettings;
import com.misfit.frameworks.buttonservice.communite.ble.BleAdapter;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession;
import com.misfit.frameworks.buttonservice.communite.ble.BleState;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import java.util.List;

public abstract class SetMultipleAlarmsBaseState extends BleState {
    private BleAdapter bleAdapter;
    private BleSession currentSession;
    private List<MultipleAlarmSettings> multipleAlarmSettingsList;

    public abstract BleState getStateOnCompleted(boolean z);

    public abstract BleState getStateOnTimeOut();

    public SetMultipleAlarmsBaseState(List<MultipleAlarmSettings> list, BleAdapter bleAdapter, BleSession bleSession) {
        super(bleSession.getClass().getSimpleName());
        this.bleAdapter = bleAdapter;
        this.currentSession = bleSession;
        this.multipleAlarmSettingsList = list;
    }

    public boolean onEnter() {
        super.onEnter();
        startTimeout();
        if (this.bleAdapter.setMultipleAlarms(this.multipleAlarmSettingsList)) {
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

    public boolean handleOnSetMultipleAlarmsCompleted(boolean z) {
        stopTimeout();
        this.currentSession.enterState(getStateOnCompleted(z));
        return true;
    }

    protected void onTimeout() {
        super.onTimeout();
        this.currentSession.log("Set multiple alarms timeout.");
        this.currentSession.enterState(getStateOnTimeOut());
    }
}
