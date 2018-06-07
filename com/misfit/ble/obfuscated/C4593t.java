package com.misfit.ble.obfuscated;

import com.misfit.ble.setting.eventmapping.EventMapping;
import com.misfit.ble.setting.flashlink.EventMappingEnum.C4601a;
import com.misfit.ble.setting.flashlink.EventMappingEnum.MemEventNumber;
import com.misfit.ble.setting.flashlink.EventMappingEnum.OperationType;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class C4593t extends EventMapping {
    private C4601a av;

    public C4593t(C4601a c4601a) {
        super(OperationType.UNMAP_ONE_BUTTON, MemEventNumber.NO_EVENT);
        this.av = c4601a;
    }

    public byte[] payload() {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, getActionType().getId());
        allocate.put(1, this.av.getId());
        return allocate.array();
    }

    public String toString() {
        return "EventMapping{actionType=" + getActionType() + ", buttonId=" + this.av.getId() + '}';
    }
}
