package com.misfit.frameworks.buttonservice.ble;

import com.misfit.ble.shine.CustomRequest;
import com.misfit.frameworks.common.log.MFLogger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class SimulateDisconnectionCommand extends CustomRequest {
    private int mDelayBeforeOff;
    private int mDelayEachTime;
    private int mDuration;
    private int mRepeatTimes;

    public SimulateDisconnectionCommand(int i, int i2, int i3, int i4) {
        this.mDelayBeforeOff = i;
        this.mDuration = i2;
        this.mRepeatTimes = i3;
        this.mDelayEachTime = i4;
    }

    public String getRequestName() {
        return "simulateDisconnection";
    }

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    public int getTimeOut() {
        return 0;
    }

    public byte[] getRequestData() {
        this.isForced = false;
        ByteBuffer allocate = ByteBuffer.allocate(13);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        try {
            allocate.put(0, (byte) 2);
            allocate.put(1, (byte) -13);
            allocate.put(2, (byte) 1);
            allocate.putShort(3, (short) this.mDelayBeforeOff);
            allocate.putShort(5, (short) this.mDuration);
            allocate.putShort(7, (short) this.mRepeatTimes);
            allocate.putShort(9, (short) this.mDelayEachTime);
        } catch (Exception e) {
            MFLogger.e("SimulateDisconnectionCommand", "SimulateDisconnectionCommand - e=" + e);
        }
        MFLogger.i("SimulateDisconnectionCommand", "Sending command " + bytesToHex(allocate.array()));
        return allocate.array();
    }

    public void onRequestSent(int i) {
        this.mIsCompleted = true;
    }

    public static String bytesToHex(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(String.format("%02x", new Object[]{Byte.valueOf(bArr[i])}));
        }
        return stringBuilder.toString();
    }
}
