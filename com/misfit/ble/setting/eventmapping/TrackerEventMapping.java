package com.misfit.ble.setting.eventmapping;

import com.misfit.ble.setting.flashlink.EventMappingEnum.MemEventNumber;
import com.misfit.ble.setting.flashlink.EventMappingEnum.OperationType;
import java.nio.ByteBuffer;

public class TrackerEventMapping extends EventMapping {
    public TrackerEventMapping(MemEventNumber memEventNumber) {
        super(OperationType.TRACKER, memEventNumber);
    }

    public byte[] payload() {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.put(0, getActionType().getId());
        allocate.put(1, getEventNumber().getId());
        return allocate.array();
    }
}
