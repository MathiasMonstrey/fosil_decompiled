package com.misfit.ble.obfuscated;

import com.misfit.ble.setting.uapp.UAppNotification;
import com.misfit.ble.setting.uapp.UAppSystemVersion;
import com.misfit.ble.setting.uapp.instruction.UAppInstruction;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;

public class C4599z extends C4436x {
    private List<UAppInstruction> bP;
    private UAppNotification bQ;

    public C4599z(UAppSystemVersion uAppSystemVersion, UAppNotification uAppNotification, List<UAppInstruction> list) throws IllegalArgumentException {
        if (uAppSystemVersion == null) {
            throw new IllegalArgumentException("uAppSystemVersion must not be null.");
        } else if (uAppNotification == null) {
            throw new IllegalArgumentException("uAppNotification must not be null.");
        } else if (list == null) {
            throw new IllegalArgumentException("instructions must not be null.");
        } else {
            m14675a(uAppSystemVersion, (byte) 8);
            this.bQ = uAppNotification;
            this.bP = list;
        }
    }

    public byte[] getData() throws IllegalArgumentException {
        ByteBuffer allocate = ByteBuffer.allocate(2048);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        try {
            allocate.put(this.bQ.m15243D());
            allocate.put(new C4598y((byte) -1, this.bP).getData());
            int position = allocate.position();
            allocate.rewind();
            byte[] bArr = new byte[position];
            allocate.get(bArr, 0, position);
            return bArr;
        } catch (Exception e) {
            throw new IllegalArgumentException("Remote Activity data length exceeds 2048 bytes");
        }
    }
}
