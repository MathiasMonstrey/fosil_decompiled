package com.fossil;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class abf extends FilterInputStream {
    private int aGV;
    private final long contentLength;

    public static InputStream m2856a(InputStream inputStream, long j) {
        return new abf(inputStream, j);
    }

    abf(InputStream inputStream, long j) {
        super(inputStream);
        this.contentLength = j;
    }

    public synchronized int available() throws IOException {
        return (int) Math.max(this.contentLength - ((long) this.aGV), (long) this.in.available());
    }

    public synchronized int read() throws IOException {
        return eP(super.read());
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        return eP(super.read(bArr, i, i2));
    }

    private int eP(int i) throws IOException {
        if (i >= 0) {
            this.aGV += i;
        } else if (this.contentLength - ((long) this.aGV) > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.contentLength + ", but read: " + this.aGV);
        }
        return i;
    }
}
