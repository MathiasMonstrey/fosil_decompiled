package com.misfit.ble.setting.eventmapping;

import com.misfit.ble.obfuscated.hb;
import com.misfit.ble.setting.flashlink.EventMappingEnum.AnimNumber;
import com.misfit.ble.setting.flashlink.EventMappingEnum.MemEventNumber;
import com.misfit.ble.setting.flashlink.EventMappingEnum.OperationType;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class BoltAutoEventMapping extends EventMapping {
    private AnimNumber ad;
    private boolean ae;

    public BoltAutoEventMapping(MemEventNumber memEventNumber, AnimNumber animNumber, boolean z) {
        super(OperationType.BOLT_AUTO, memEventNumber);
        this.ad = animNumber;
        this.ae = z;
    }

    public AnimNumber getAnimNumber() {
        return this.ad;
    }

    public boolean isGroup() {
        return this.ae;
    }

    public byte[] payload() {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, getActionType().getId());
        allocate.put(1, getEventNumber().getId());
        allocate.put(2, getAnimNumber().getId());
        allocate.put(3, hb.m15167f(isGroup()));
        return allocate.array();
    }

    public String toString() {
        return "BoltAutoEventMapping{animNumber=" + this.ad + ", isGroup=" + this.ae + '}';
    }
}
