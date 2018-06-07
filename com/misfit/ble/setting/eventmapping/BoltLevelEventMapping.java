package com.misfit.ble.setting.eventmapping;

import com.misfit.ble.obfuscated.hb;
import com.misfit.ble.setting.flashlink.EventMappingEnum.AnimNumber;
import com.misfit.ble.setting.flashlink.EventMappingEnum.MemEventNumber;
import com.misfit.ble.setting.flashlink.EventMappingEnum.OperationType;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class BoltLevelEventMapping extends EventMapping {
    private AnimNumber ad;
    private boolean ae;
    private short ah;

    public BoltLevelEventMapping(MemEventNumber memEventNumber, AnimNumber animNumber, boolean z, short s) {
        super(OperationType.BOLT_LEVEL, memEventNumber);
        this.ad = animNumber;
        this.ae = z;
        this.ah = s;
    }

    public AnimNumber getAnimNumber() {
        return this.ad;
    }

    public boolean isGroup() {
        return this.ae;
    }

    public short getLevel() {
        return this.ah;
    }

    public byte[] payload() {
        ByteBuffer allocate = ByteBuffer.allocate(5);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, getActionType().getId());
        allocate.put(1, getEventNumber().getId());
        allocate.put(2, getAnimNumber().getId());
        allocate.put(3, hb.m15167f(isGroup()));
        allocate.put(4, hb.m15166e(getLevel()));
        return allocate.array();
    }

    public String toString() {
        return "BoltLevelEventMapping{animNumber=" + this.ad + ", isGroup=" + this.ae + ", level=" + this.ah + '}';
    }
}
