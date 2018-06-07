package com.fossil;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.zip.CRC32;

public final class aph extends MessageDigest {
    private CRC32 baO = new CRC32();

    public aph() {
        super("CRC");
    }

    protected final void engineUpdate(byte b) {
        this.baO.update(b);
    }

    protected final void engineUpdate(byte[] bArr, int i, int i2) {
        this.baO.update(bArr, i, i2);
    }

    protected final byte[] engineDigest() {
        long value = this.baO.getValue();
        return new byte[]{(byte) ((int) ((-16777216 & value) >> 24)), (byte) ((int) ((16711680 & value) >> 16)), (byte) ((int) ((65280 & value) >> 8)), (byte) ((int) ((value & 255) >> 0))};
    }

    protected final void engineReset() {
        this.baO.reset();
    }

    public final byte[] Ii() {
        return engineDigest();
    }

    public final int Iz() {
        return ByteBuffer.wrap(engineDigest()).getInt();
    }
}
