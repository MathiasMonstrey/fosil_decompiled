package com.misfit.frameworks.buttonservice.communite.ble.share;

import com.misfit.ble.shine.ShineProfile.ConnectActionResult;
import com.misfit.frameworks.buttonservice.communite.ble.BleAdapter;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession;
import com.misfit.frameworks.buttonservice.communite.ble.BleState;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.buttonservice.model.Device;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.LinkMapping;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import java.util.List;

public abstract class SetMappingBaseState extends BleState {
    private BleAdapter bleAdapter;
    private BleSession currentSession;
    private Device deviceType;
    private List<LinkMapping> mappings;

    public abstract BleState getStateOnCompleted(boolean z);

    public abstract BleState getStateOnTimeOut();

    public abstract boolean isClearAndUpdateEachButton();

    public SetMappingBaseState(List<LinkMapping> list, Device device, BleAdapter bleAdapter, BleSession bleSession) {
        super(bleSession.getClass().getSimpleName());
        this.bleAdapter = bleAdapter;
        this.currentSession = bleSession;
        this.mappings = list;
        this.deviceType = device;
    }

    public void setMappings(List<LinkMapping> list) {
        this.mappings = list;
    }

    public boolean onEnter() {
        super.onEnter();
        startTimeout();
        if (this.bleAdapter.setLinkMappings(this.mappings, isClearAndUpdateEachButton())) {
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

    public boolean handleOnSettingMappingCompleted(boolean z) {
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
        this.currentSession.log("Set mapping timeout.");
        this.currentSession.enterState(getStateOnTimeOut());
    }
}
