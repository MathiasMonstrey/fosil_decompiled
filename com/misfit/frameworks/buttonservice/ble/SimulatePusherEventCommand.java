package com.misfit.frameworks.buttonservice.ble;

import com.misfit.ble.shine.CustomRequest;
import com.misfit.frameworks.common.log.MFLogger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class SimulatePusherEventCommand extends CustomRequest {
    private int delay;
    private int delayBetweenRepeat;
    private int event;
    private int pusher;
    private int repeat;

    public SimulatePusherEventCommand(int i, int i2, int i3, int i4, int i5) {
        this.pusher = i;
        this.event = i2;
        this.delay = i3;
        this.repeat = i4;
        this.delayBetweenRepeat = i5;
    }

    public String getRequestName() {
        return "simulatePusherEvent";
    }

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    public int getTimeOut() {
        return 0;
    }

    public byte[] getRequestData() {
        int i = 4;
        this.isForced = false;
        MFLogger.d("SimulatePusherEventCommand", "SimulatePusherEventCommand - enable=" + isEnable());
        if (isEnable()) {
            i = 15;
        }
        ByteBuffer allocate = ByteBuffer.allocate(i);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        try {
            allocate.put(0, (byte) 2);
            allocate.put(1, (byte) -13);
            allocate.put(2, (byte) 2);
            allocate.put(3, (byte) this.pusher);
            if (isEnable()) {
                allocate.put(4, (byte) this.event);
                allocate.putInt(5, this.delay * 1000);
                allocate.putShort(9, (short) this.repeat);
                allocate.putInt(11, this.delayBetweenRepeat * 1000);
            }
            MFLogger.i("SimulatePusherEventCommand", "Sending command " + bytesToHex(allocate.array()));
        } catch (Exception e) {
            MFLogger.e("SimulatePusherEventCommand", "SimulatePusherEventCommand - e=" + e);
        }
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

    private boolean isEnable() {
        return this.pusher < 4;
    }
}
