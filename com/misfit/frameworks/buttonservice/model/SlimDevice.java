package com.misfit.frameworks.buttonservice.model;

import com.misfit.frameworks.buttonservice.communite.CommunicateMode;

public class SlimDevice extends Device {
    public boolean isSupportDeviceState(CommunicateMode communicateMode) {
        return communicateMode == CommunicateMode.SET_LIST_ALARM || communicateMode == CommunicateMode.VERIFY_LIST_ALARM || communicateMode == CommunicateMode.GET_SECOND_TIMEZONE || communicateMode == CommunicateMode.SET_SECOND_TIMEZONE || communicateMode == CommunicateMode.GET_COUNTDOWN || communicateMode == CommunicateMode.SET_COUNTDOWN;
    }
}
