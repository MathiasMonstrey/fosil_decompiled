package com.misfit.frameworks.buttonservice.ble;

import com.misfit.ble.shine.CustomRequest;
import com.misfit.frameworks.common.log.MFLogger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ResetSettingDefaultCommand extends CustomRequest {
    public String getRequestName() {
        return "ResetSettingDefaultCommand";
    }

    public String getCharacteristicUUID() {
        return "3dda0002-957f-7d4a-34a6-74696673696d";
    }

    public int getTimeOut() {
        return 0;
    }

    public byte[] getRequestData() {
        this.isForced = false;
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        try {
            allocate.put(0, (byte) 2);
            allocate.put(1, (byte) -15);
            allocate.put(2, (byte) 35);
            allocate.put(3, (byte) 0);
            allocate.put(4, (byte) 15);
            allocate.put(5, (byte) 0);
            allocate.put(6, (byte) 0);
            allocate.put(7, (byte) 0);
        } catch (Exception e) {
            MFLogger.e("ResetSettingDefaultCommand", "ResetSettingDefaultCommand - e=" + e);
        }
        MFLogger.i("ResetSettingDefaultCommand", "Sending command " + bytesToHex(allocate.array()));
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
