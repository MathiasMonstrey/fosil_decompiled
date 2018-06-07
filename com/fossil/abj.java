package com.fossil;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class abj extends FilterInputStream {
    private int aHb = Integer.MIN_VALUE;

    public abj(InputStream inputStream) {
        super(inputStream);
    }

    public void mark(int i) {
        super.mark(i);
        this.aHb = i;
    }

    public int read() throws IOException {
        if (m2860w(1) == -1) {
            return -1;
        }
        int read = super.read();
        m2861x(1);
        return read;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int w = (int) m2860w((long) i2);
        if (w == -1) {
            return -1;
        }
        int read = super.read(bArr, i, w);
        m2861x((long) read);
        return read;
    }

    public void reset() throws IOException {
        super.reset();
        this.aHb = Integer.MIN_VALUE;
    }

    public long skip(long j) throws IOException {
        long w = m2860w(j);
        if (w == -1) {
            return -1;
        }
        long skip = super.skip(w);
        m2861x(skip);
        return skip;
    }

    public int available() throws IOException {
        return this.aHb == Integer.MIN_VALUE ? super.available() : Math.min(this.aHb, super.available());
    }

    private long m2860w(long j) {
        if (this.aHb == 0) {
            return -1;
        }
        if (this.aHb == Integer.MIN_VALUE || j <= ((long) this.aHb)) {
            return j;
        }
        return (long) this.aHb;
    }

    private void m2861x(long j) {
        if (this.aHb != Integer.MIN_VALUE && j != -1) {
            this.aHb = (int) (((long) this.aHb) - j);
        }
    }
}
