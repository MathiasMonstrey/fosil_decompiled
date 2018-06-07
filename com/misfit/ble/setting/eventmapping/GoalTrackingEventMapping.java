package com.misfit.ble.setting.eventmapping;

import com.misfit.ble.obfuscated.hb;
import com.misfit.ble.setting.flashlink.EventMappingEnum.MemEventNumber;
import com.misfit.ble.setting.flashlink.EventMappingEnum.OperationType;
import java.nio.ByteBuffer;

public class GoalTrackingEventMapping extends EventMapping {
    public static final short INVALID_GOAL_ID_NUMBER = (short) 255;
    private short mGoalIdNumber;

    public GoalTrackingEventMapping(MemEventNumber memEventNumber, short s) {
        super(OperationType.GOAL_TRACKING, memEventNumber);
        this.mGoalIdNumber = s;
    }

    public short getGoalIdNumber() {
        return this.mGoalIdNumber;
    }

    public byte[] payload() {
        ByteBuffer allocate = ByteBuffer.allocate(3);
        allocate.put(0, getActionType().getId());
        allocate.put(1, getEventNumber().getId());
        allocate.put(2, hb.m15166e(getGoalIdNumber()));
        return allocate.array();
    }

    public String toString() {
        return "GoalTrackingEventMapping{goalIdNumber=" + this.mGoalIdNumber + '}';
    }
}
