package com.misfit.ble.setting.eventmapping;

import com.misfit.ble.setting.flashlink.EventMappingEnum.AnimNumber;
import com.misfit.ble.setting.flashlink.EventMappingEnum.MemEventNumber;
import com.misfit.ble.setting.flashlink.EventMappingEnum.OperationType;
import java.nio.ByteBuffer;

public class ButtonEventMappingTwo extends EventMapping {
    private AnimNumber ai;
    private AnimNumber ao;

    public ButtonEventMappingTwo(MemEventNumber memEventNumber, AnimNumber animNumber, AnimNumber animNumber2) {
        super(OperationType.APP_TYPE_2, memEventNumber);
        this.ai = animNumber;
        this.ao = animNumber2;
    }

    public AnimNumber getActiveAndConnectedAnim() {
        return this.ai;
    }

    public AnimNumber getUnconnectedAndTimeoutAnim() {
        return this.ao;
    }

    public byte[] payload() {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.put(0, getActionType().getId());
        allocate.put(1, getEventNumber().getId());
        allocate.put(2, getActiveAndConnectedAnim().getId());
        allocate.put(3, getUnconnectedAndTimeoutAnim().getId());
        return allocate.array();
    }

    public String toString() {
        return "ButtonEventMappingTwo{eventNumber=" + getEventNumber() + ", activeAndConnectedAnim=" + this.ai + ", unconnectedAndTimeoutAnim=" + this.ao + '}';
    }
}
