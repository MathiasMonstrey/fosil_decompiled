package com.misfit.ble.obfuscated;

import com.misfit.ble.shine.error.ShineError.Event;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ez extends ew {
    public String getRequestName() {
        return "sendCallNotification";
    }

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    private byte cb() {
        return (byte) 2;
    }

    public byte bZ() {
        return (byte) 7;
    }

    public byte cc() {
        return (byte) 15;
    }

    public byte ce() {
        return (byte) 4;
    }

    public void ca() {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(0, cb());
        allocate.put(1, bZ());
        allocate.put(2, cc());
        allocate.put(3, ce());
        this.mRequestData = allocate.array();
    }

    public void onRequestSent(int i) {
        this.mIsCompleted = true;
    }

    public Event getEventID() {
        return Event.SEND_CALL_NOTIFICATION;
    }
}
