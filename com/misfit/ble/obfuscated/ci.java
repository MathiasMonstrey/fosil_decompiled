package com.misfit.ble.obfuscated;

import java.nio.ByteBuffer;
import java.util.Arrays;

public abstract class ci {
    protected byte[] cc;
    protected String er;
    protected int kM;
    protected ByteBuffer kN = null;

    public abstract int bV();

    protected abstract byte[] bY();

    public ci(byte[] bArr, String str) {
        this.cc = bArr;
        this.er = str;
        this.kN = ByteBuffer.wrap(this.cc);
        this.kM = -1;
    }

    public int bS() {
        return this.cc.length;
    }

    public int bT() {
        return Math.min((this.kM + 1) * bU(), this.cc.length);
    }

    public int bU() {
        return 20 - bV();
    }

    public String getCharacteristicUUID() {
        return this.er;
    }

    public boolean bW() {
        return this.kN.remaining() > 0;
    }

    public byte[] bX() {
        int remaining = this.kN.remaining();
        if (remaining <= 0) {
            return null;
        }
        this.kM++;
        byte[] bY = bY();
        int min = Math.min(remaining + bY.length, 20);
        byte[] copyOfRange = Arrays.copyOfRange(bY, 0, min);
        this.kN.get(copyOfRange, bY.length, min - bY.length);
        return copyOfRange;
    }
}
