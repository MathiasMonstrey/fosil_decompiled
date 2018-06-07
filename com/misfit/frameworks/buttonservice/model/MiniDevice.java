package com.misfit.frameworks.buttonservice.model;

import com.misfit.frameworks.buttonservice.communite.CommunicateMode;

public class MiniDevice extends Device {
    public boolean isSupportDeviceState(CommunicateMode communicateMode) {
        return communicateMode == CommunicateMode.SET_LIST_ALARM || communicateMode == CommunicateMode.VERIFY_LIST_ALARM || communicateMode == CommunicateMode.GET_SECOND_TIMEZONE || communicateMode == CommunicateMode.SET_SECOND_TIMEZONE || communicateMode == CommunicateMode.GET_COUNTDOWN || communicateMode == CommunicateMode.SET_COUNTDOWN || communicateMode == CommunicateMode.GET_VIBRATION_STRENGTH || communicateMode == CommunicateMode.SET_VIBRATION_STRENGTH;
    }
}
