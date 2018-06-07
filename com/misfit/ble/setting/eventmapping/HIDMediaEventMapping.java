package com.misfit.ble.setting.eventmapping;

import com.misfit.ble.obfuscated.hb;
import com.misfit.ble.setting.flashlink.EventMappingEnum.AnimNumber;
import com.misfit.ble.setting.flashlink.EventMappingEnum.KeyCode;
import com.misfit.ble.setting.flashlink.EventMappingEnum.MemEventNumber;
import com.misfit.ble.setting.flashlink.EventMappingEnum.OperationType;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class HIDMediaEventMapping extends EventMapping {
    private AnimNumber ad;
    private KeyCode ar;
    private boolean as;

    public HIDMediaEventMapping(MemEventNumber memEventNumber, AnimNumber animNumber, KeyCode keyCode, boolean z) {
        super(OperationType.HID_MEDIA, memEventNumber);
        this.ad = animNumber;
        this.ar = keyCode;
        this.as = z;
    }

    public AnimNumber getAnimNumber() {
        return this.ad;
    }

    public KeyCode getKeyCode() {
        return this.ar;
    }

    public boolean isReleaseEnable() {
        return this.as;
    }

    public void setReleaseEnable(boolean z) {
        this.as = z;
    }

    public byte[] payload() {
        ByteBuffer allocate = ByteBuffer.allocate(6);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, getActionType().getId());
        allocate.put(1, getEventNumber().getId());
        allocate.put(2, getAnimNumber().getId());
        allocate.put(3, getKeyCode().getId());
        allocate.put(4, (byte) 0);
        allocate.put(5, hb.m15167f(isReleaseEnable()));
        return allocate.array();
    }

    public String toString() {
        return "HIDMediaEventMapping{EventNumber=" + getEventNumber() + ", animNumber=" + this.ad + ", keyCode=" + this.ar + ", releaseEnable=" + this.as + '}';
    }
}
