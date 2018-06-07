package com.misfit.frameworks.buttonservice.communite.ble.share;

import com.fossil.wearables.fsl.fitness.FitnessProviderImpl;
import com.misfit.frameworks.buttonservice.communite.ble.BleAdapter;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession;
import com.misfit.frameworks.buttonservice.communite.ble.BleState;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;

public abstract class HidConnectBaseState extends BleState {
    private BleAdapter bleAdapter;
    private BleSession currentSession;

    protected abstract BleState getStateOnCompleted(boolean z);

    protected abstract BleState getStateOnTimeOut();

    public HidConnectBaseState(BleAdapter bleAdapter, BleSession bleSession) {
        super(bleSession.getClass().getSimpleName());
        this.bleAdapter = bleAdapter;
        this.currentSession = bleSession;
    }

    public int getTimeout() {
        return FitnessProviderImpl.DEFAULT_DAILY_STEP_GOAL;
    }

    public boolean onEnter() {
        super.onEnter();
        startTimeout();
        if (this.bleAdapter.hidConnect()) {
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

    public boolean handleOnHidConnected() {
        stopTimeout();
        this.currentSession.enterState(getStateOnCompleted(true));
        return true;
    }

    public boolean handleOnHidDisconnected() {
        stopTimeout();
        this.currentSession.enterState(getStateOnCompleted(false));
        return true;
    }

    protected void onTimeout() {
        super.onTimeout();
        this.currentSession.log("HID connect timeout.");
        this.currentSession.enterState(getStateOnTimeOut());
    }
}
