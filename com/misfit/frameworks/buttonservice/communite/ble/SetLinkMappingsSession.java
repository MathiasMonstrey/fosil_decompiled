package com.misfit.frameworks.buttonservice.communite.ble;

import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.communite.SessionType;
import com.misfit.frameworks.buttonservice.communite.ble.BleSession.BleSessionCallback;

public abstract class SetLinkMappingsSession extends ConnectableSession {
    protected SdkCallback sdkCallback;

    public SetLinkMappingsSession(SdkCallback sdkCallback, BleAdapter bleAdapter, BleSessionCallback bleSessionCallback) {
        super(SessionType.UI, CommunicateMode.SET_LINK_MAPPING, bleAdapter, bleSessionCallback, sdkCallback);
        this.sdkCallback = sdkCallback;
    }

    public boolean accept(BleSession bleSession) {
        return (getCommunicateMode() == bleSession.getCommunicateMode() || bleSession.getCommunicateMode() == CommunicateMode.SET_AUTO_MAPPING) ? false : true;
    }
}
