package com.misfit.ble.obfuscated;

import com.misfit.ble.setting.uapp.UAppSystemVersion;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public abstract class C4436x {
    protected UAppSystemVersion bM;
    protected byte bN;
    protected long bO;

    public abstract byte[] getData();

    protected void m14675a(UAppSystemVersion uAppSystemVersion, byte b) {
        this.bM = uAppSystemVersion;
        this.bN = b;
        this.bO = 0;
    }

    public byte[] m14674F() throws IllegalArgumentException {
        byte[] data = getData();
        int length = data.length + 7;
        if (length > 2048) {
            throw new IllegalArgumentException("uApp file data length exceeds 2048 bytes");
        }
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(hb.m15166e(this.bM.majorVersion));
        allocate.put(hb.m15166e(this.bM.minorVersion));
        allocate.put(this.bN);
        allocate.put(data);
        data = Arrays.copyOfRange(allocate.array(), 0, allocate.array().length - 4);
        this.bO = hd.m15176a(data.length, data);
        allocate.putInt(hb.m15168g(this.bO));
        return allocate.array();
    }
}
