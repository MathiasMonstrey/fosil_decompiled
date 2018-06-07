package com.misfit.ble.setting.eventmapping;

import com.misfit.ble.setting.flashlink.EventMappingEnum.MemEventNumber;
import com.misfit.ble.setting.flashlink.EventMappingEnum.ModeDisplay;
import com.misfit.ble.setting.flashlink.EventMappingEnum.OperationType;
import java.nio.ByteBuffer;

public class ModeDisplayEventMapping extends EventMapping {
    private ModeDisplay at;
    private ModeDisplay au;

    public ModeDisplayEventMapping(MemEventNumber memEventNumber, ModeDisplay modeDisplay, ModeDisplay modeDisplay2) {
        super(OperationType.MODE_DISPLAY, memEventNumber);
        this.at = modeDisplay;
        this.au = modeDisplay2;
    }

    public ModeDisplay getMode() {
        return this.at;
    }

    public ModeDisplay getSubMode() {
        return this.au;
    }

    public byte[] payload() {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.put(0, getActionType().getId());
        allocate.put(1, getEventNumber().getId());
        allocate.put(2, getMode().getId());
        allocate.put(3, getSubMode().getId());
        return allocate.array();
    }

    public String toString() {
        return "ModeDisplayEventMapping{eventNumber=" + getEventNumber() + ", mode=" + this.at + ", subMode=" + this.au + '}';
    }
}
