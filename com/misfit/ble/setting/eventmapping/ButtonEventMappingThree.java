package com.misfit.ble.setting.eventmapping;

import com.misfit.ble.obfuscated.hb;
import com.misfit.ble.setting.flashlink.EventMappingEnum.AnimNumber;
import com.misfit.ble.setting.flashlink.EventMappingEnum.MemEventNumber;
import com.misfit.ble.setting.flashlink.EventMappingEnum.OperationType;
import java.nio.ByteBuffer;

public class ButtonEventMappingThree extends EventMapping {
    private AnimNumber ai;
    private AnimNumber aj;
    private short ak;
    private short al;
    private AnimNumber am;
    private short an;

    public ButtonEventMappingThree(MemEventNumber memEventNumber, AnimNumber animNumber, short s, AnimNumber animNumber2, short s2, AnimNumber animNumber3, short s3) {
        super(OperationType.APP_TYPE_3, memEventNumber);
        this.ai = animNumber;
        this.ak = s;
        this.aj = animNumber2;
        this.al = s2;
        this.am = animNumber3;
        this.an = s3;
    }

    public AnimNumber getActiveAndConnectedAnim() {
        return this.ai;
    }

    public short getActiveAndConnectedAnimRepeat() {
        return this.ak;
    }

    public AnimNumber getUnconnectedAnim() {
        return this.aj;
    }

    public short getUnconnectedAnimRepeat() {
        return this.al;
    }

    public AnimNumber getTimeoutAnim() {
        return this.am;
    }

    public short getTimeoutAnimRepeat() {
        return this.an;
    }

    public byte[] payload() {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.put(0, getActionType().getId());
        allocate.put(1, getEventNumber().getId());
        allocate.put(2, getActiveAndConnectedAnim().getId());
        allocate.put(3, hb.m15166e(getActiveAndConnectedAnimRepeat()));
        allocate.put(4, getUnconnectedAnim().getId());
        allocate.put(5, hb.m15166e(getUnconnectedAnimRepeat()));
        allocate.put(6, getTimeoutAnim().getId());
        allocate.put(7, hb.m15166e(getTimeoutAnimRepeat()));
        return allocate.array();
    }

    public String toString() {
        return "ButtonEventMappingThree{eventNumber=" + getEventNumber() + ", activeAndConnectedAnim=" + this.ai + ", activeAndConnectedAnimRepeat=" + this.ak + ", unconnectedAnim=" + this.aj + ", unconnectedAnimRepeat=" + this.al + ", timeoutAnim=" + this.am + ", timeoutAnimRepeat=" + this.an + '}';
    }
}
