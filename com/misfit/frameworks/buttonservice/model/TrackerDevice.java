package com.misfit.frameworks.buttonservice.model;

import com.misfit.frameworks.buttonservice.communite.CommunicateMode;

public class TrackerDevice extends Device {
    public boolean isSupportDeviceState(CommunicateMode communicateMode) {
        return false;
    }
}
