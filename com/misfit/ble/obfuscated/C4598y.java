package com.misfit.ble.obfuscated;

import com.misfit.ble.setting.uapp.instruction.UAppInstruction;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;

public class C4598y {
    private List<UAppInstruction> bP;
    private byte bz;

    public C4598y(byte b, List<UAppInstruction> list) {
        if (list == null) {
            throw new IllegalArgumentException("instructions must not be null.");
        }
        this.bz = b;
        this.bP = list;
    }

    public byte[] getData() throws IllegalArgumentException {
        ByteBuffer allocate = ByteBuffer.allocate(2048);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        try {
            allocate.put(this.bz);
            allocate.putShort((short) 0);
            for (UAppInstruction M : this.bP) {
                allocate.put(M.m14681M());
            }
            int position = allocate.position();
            allocate.putShort(1, (short) position);
            allocate.rewind();
            byte[] bArr = new byte[position];
            allocate.get(bArr, 0, position);
            return bArr;
        } catch (Exception e) {
            throw new IllegalArgumentException("Activity Definition data length exceeds 2048 bytes");
        }
    }
}
