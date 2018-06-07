package com.misfit.ble.setting.eventmapping;

import com.misfit.ble.setting.flashlink.EventMappingEnum.AnimNumber;
import com.misfit.ble.setting.flashlink.EventMappingEnum.MemEventNumber;
import com.misfit.ble.setting.flashlink.EventMappingEnum.OperationType;
import java.nio.ByteBuffer;

public class ButtonEventMappingOne extends EventMapping {
    private AnimNumber ai;
    private AnimNumber aj;

    public ButtonEventMappingOne(MemEventNumber memEventNumber, AnimNumber animNumber, AnimNumber animNumber2) {
        super(OperationType.APP_TYPE_1, memEventNumber);
        this.ai = animNumber;
        this.aj = animNumber2;
    }

    public AnimNumber getActiveAndConnectedAnim() {
        return this.ai;
    }

    public AnimNumber getUnconnectedAnim() {
        return this.aj;
    }

    public byte[] payload() {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.put(0, getActionType().getId());
        allocate.put(1, getEventNumber().getId());
        allocate.put(2, getActiveAndConnectedAnim().getId());
        allocate.put(3, getUnconnectedAnim().getId());
        return allocate.array();
    }

    public String toString() {
        return "ButtonEventMappingOne{eventNumber=" + getEventNumber() + ", activeAndConnectedAnim=" + this.ai + ", unconnectedAnim=" + this.aj + '}';
    }
}
