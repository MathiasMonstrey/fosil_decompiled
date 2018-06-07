package com.misfit.frameworks.buttonservice.communite.ble;

import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.communite.SessionType;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.BleSessionCallback;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;

public abstract class SetAutoSettingsSession extends BleSession {
    public abstract BleState getStartState();

    public abstract void initSettings();

    protected SetAutoSettingsSession(CommunicateMode communicateMode, BleAdapter bleAdapter, BleSessionCallback bleSessionCallback) {
        super(SessionType.DEVICE_SETTING, communicateMode, bleAdapter, bleSessionCallback);
    }

    protected boolean onStart(Object... objArr) {
        initSettings();
        enterStateWithDelayTime(getStartState(), MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
        return true;
    }
}
