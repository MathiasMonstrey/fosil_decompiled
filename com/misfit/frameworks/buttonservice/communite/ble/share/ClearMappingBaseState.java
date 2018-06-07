package com.misfit.frameworks.buttonservice.communite.ble.share;

import com.misfit.ble.shine.ShineProfile.ConnectActionResult;
import com.misfit.frameworks.buttonservice.communite.ble.BleAdapter;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession;
import com.misfit.frameworks.buttonservice.communite.ble.BleState;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;

public abstract class ClearMappingBaseState extends BleState {
    private BleAdapter bleAdapter;
    private BleSession currentSession;

    public abstract BleState getStateOnCompleted(boolean z);

    public abstract BleState getStateOnTimeOut();

    public ClearMappingBaseState(BleAdapter bleAdapter, BleSession bleSession) {
        super(bleSession.getClass().getSimpleName());
        this.bleAdapter = bleAdapter;
        this.currentSession = bleSession;
    }

    public boolean onEnter() {
        super.onEnter();
        return onEnterTask();
    }

    protected boolean onEnterTask() {
        startTimeout();
        if (this.bleAdapter.clearAllMappings()) {
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

    public boolean handleOnUnmapAllEventsCompleted(boolean z) {
        stopTimeout();
        this.currentSession.enterState(getStateOnCompleted(z));
        return true;
    }

    protected void onTimeout() {
        super.onTimeout();
        this.currentSession.log("Clear mapping timeout.");
        this.currentSession.enterState(getStateOnTimeOut());
    }

    public boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult) {
        stopTimeout();
        this.currentSession.stop(FailureCode.UNEXPECTED_DISCONNECT);
        return true;
    }
}
