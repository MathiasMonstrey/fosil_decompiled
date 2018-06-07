package com.misfit.ble.setting.eventmapping;

import com.misfit.ble.setting.flashlink.EventMappingEnum.MemEventNumber;
import com.misfit.ble.setting.flashlink.EventMappingEnum.OperationType;

public abstract class EventMapping {
    private OperationType ap;
    private MemEventNumber aq;

    public EventMapping(OperationType operationType, MemEventNumber memEventNumber) {
        this.ap = operationType;
        this.aq = memEventNumber;
    }

    public OperationType getActionType() {
        return this.ap;
    }

    public MemEventNumber getEventNumber() {
        return this.aq;
    }

    public static EventMapping valueOf(String str) {
        return null;
    }

    public byte[] payload() {
        return null;
    }

    public String toString() {
        return "EventMapping{actionType=" + this.ap + ", eventNumber=" + this.aq + '}';
    }
}
