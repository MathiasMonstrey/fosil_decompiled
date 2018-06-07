package com.misfit.ble.setting.eventmapping;

import com.misfit.ble.obfuscated.hb;
import com.misfit.ble.setting.flashlink.EventMappingEnum.AnimNumber;
import com.misfit.ble.setting.flashlink.EventMappingEnum.MemEventNumber;
import com.misfit.ble.setting.flashlink.EventMappingEnum.OperationType;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class BoltIterateEventMapping extends EventMapping {
    private AnimNumber ad;
    private boolean ae;
    private short af;
    private short ag;

    public BoltIterateEventMapping(MemEventNumber memEventNumber, AnimNumber animNumber, boolean z, short s, short s2) {
        super(OperationType.BOLT_ITERATE, memEventNumber);
        this.ad = animNumber;
        this.ae = z;
        this.af = s;
        this.ag = s2;
    }

    public AnimNumber getAnimNumber() {
        return this.ad;
    }

    public boolean isGroup() {
        return this.ae;
    }

    public short getLevel0() {
        return this.af;
    }

    public short getLevel1() {
        return this.ag;
    }

    public byte[] payload() {
        ByteBuffer allocate = ByteBuffer.allocate(6);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, getActionType().getId());
        allocate.put(1, getEventNumber().getId());
        allocate.put(2, getAnimNumber().getId());
        allocate.put(3, hb.m15167f(isGroup()));
        allocate.put(4, hb.m15166e(getLevel0()));
        allocate.put(5, hb.m15166e(getLevel1()));
        return allocate.array();
    }

    public String toString() {
        return "BoltIterateEventMapping{animNumber=" + this.ad + ", isGroup=" + this.ae + ", level0=" + this.af + ", level1=" + this.ag + '}';
    }
}
