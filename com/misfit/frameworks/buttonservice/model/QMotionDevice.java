package com.misfit.frameworks.buttonservice.model;

import com.misfit.frameworks.buttonservice.communite.CommunicateMode;

public class QMotionDevice extends Device {
    public boolean isSupportDeviceState(CommunicateMode communicateMode) {
        return communicateMode == CommunicateMode.SET_ALARM || communicateMode == CommunicateMode.GET_ALARM || communicateMode == CommunicateMode.CLEAR_ALARM;
    }
}
