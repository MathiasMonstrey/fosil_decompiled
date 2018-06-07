package com.misfit.frameworks.buttonservice.communite.ble.share;

import com.misfit.ble.shine.ShineProfile.ConnectActionResult;
import com.misfit.frameworks.buttonservice.communite.ble.BleAdapter;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession;
import com.misfit.frameworks.buttonservice.communite.ble.BleState;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;

public abstract class StopStreamingBaseState extends BleState {
    private BleAdapter bleAdapter;
    private BleSession currentSession;

    public abstract BleState getStateOnCompleted(boolean z);

    public abstract BleState getStateOnTimeOut();

    public abstract boolean isSkipStopStreaming();

    public StopStreamingBaseState(BleAdapter bleAdapter, BleSession bleSession) {
        super(bleSession.getClass().getSimpleName());
        this.bleAdapter = bleAdapter;
        this.currentSession = bleSession;
    }

    public boolean onEnter() {
        super.onEnter();
        if (isSkipStopStreaming()) {
            this.currentSession.log("Don't need to stop streaming.");
            BleState stateOnCompleted = getStateOnCompleted(true);
            if (stateOnCompleted != null) {
                this.currentSession.enterStateWithDelayTime(stateOnCompleted, MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
            }
        } else {
            startTimeout();
            if (!this.bleAdapter.stopStreaming()) {
                stopTimeout();
                BleState stateOnCompleted2 = getStateOnCompleted(false);
                if (stateOnCompleted2 == null) {
                    return false;
                }
                this.currentSession.enterStateWithDelayTime(stateOnCompleted2, MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                return false;
            }
        }
        return true;
    }

    protected void onTimeout() {
        super.onTimeout();
        this.currentSession.log("Stop streaming timeout.");
        this.currentSession.enterState(getStateOnTimeOut());
    }

    public boolean handleOnStopStreamingCompleted(boolean z) {
        stopTimeout();
        this.currentSession.enterState(getStateOnCompleted(z));
        return true;
    }

    public int getTimeout() {
        return 2000;
    }

    public boolean handleOnDeviceDisconnected(ConnectActionResult connectActionResult) {
        stopTimeout();
        this.currentSession.stop(FailureCode.UNEXPECTED_DISCONNECT);
        return true;
    }
}
