package com.fossil;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class amg extends InputStream {
    protected final ByteBuffer aVE;

    public amg(ByteBuffer byteBuffer) {
        this.aVE = byteBuffer;
    }

    public int available() {
        return this.aVE.remaining();
    }

    public int read() throws IOException {
        return this.aVE.hasRemaining() ? this.aVE.get() & 255 : -1;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (!this.aVE.hasRemaining()) {
            return -1;
        }
        int min = Math.min(i2, this.aVE.remaining());
        this.aVE.get(bArr, i, min);
        return min;
    }
}
