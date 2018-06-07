package com.fossil;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public class amh extends OutputStream {
    protected final ByteBuffer aVE;

    public amh(ByteBuffer byteBuffer) {
        this.aVE = byteBuffer;
    }

    public void write(int i) throws IOException {
        this.aVE.put((byte) i);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.aVE.put(bArr, i, i2);
    }
}
