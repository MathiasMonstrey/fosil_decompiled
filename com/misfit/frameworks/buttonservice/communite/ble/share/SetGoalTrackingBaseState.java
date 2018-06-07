package com.misfit.frameworks.buttonservice.communite.ble.share;

import android.util.Log;
import com.misfit.ble.shine.ShineProfile.ConnectActionResult;
import com.misfit.frameworks.buttonservice.communite.ble.BleAdapter;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession;
import com.misfit.frameworks.buttonservice.communite.ble.BleState;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.LinkMapping;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import java.util.List;

public abstract class SetGoalTrackingBaseState extends BleState {
    private String TAG = SetGoalTrackingBaseState.class.getSimpleName();
    private BleAdapter bleAdapter;
    private BleSession currentSession;
    protected int goalId;

    public abstract BleState getStateOnCompleted(boolean z);

    public abstract BleState getStateOnTimeOut();

    public SetGoalTrackingBaseState(List<LinkMapping> list, BleAdapter bleAdapter, BleSession bleSession) {
        super(bleSession.getClass().getSimpleName());
        this.bleAdapter = bleAdapter;
        this.currentSession = bleSession;
        this.goalId = getGoalIdFromMapping(list);
    }

    public SetGoalTrackingBaseState(int i, BleAdapter bleAdapter, BleSession bleSession) {
        super(bleSession.getClass().getSimpleName());
        this.bleAdapter = bleAdapter;
        this.currentSession = bleSession;
        this.goalId = i;
    }

    private int getGoalIdFromMapping(List<LinkMapping> list) {
        try {
            return Integer.parseInt(((LinkMapping) list.get(0)).getExtraInfo());
        } catch (Exception e) {
            Log.d(this.TAG, "createGoalIdFromMapping - ex=" + e.toString());
            return 255;
        }
    }

    public boolean onEnter() {
        super.onEnter();
        startTimeout();
        if (this.bleAdapter.enableGoalTracking(this.goalId, true)) {
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

    public boolean handleOnSetConfigurationCompleted(boolean z) {
        stopTimeout();
        this.currentSession.enterState(getStateOnCompleted(z));
        return true;
    }

    public boolean handleOnSettingGoalTrackingCompleted(boolean z) {
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
        this.currentSession.log("Set goal tracking with goalId=" + this.goalId + " timeout.");
        this.currentSession.enterState(getStateOnTimeOut());
    }
}
