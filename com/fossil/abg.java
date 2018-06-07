package com.fossil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

public class abg extends InputStream {
    private static final Queue<abg> aGW = abl.eR(0);
    private InputStream aGX;
    private IOException aGY;

    public static abg m2857g(InputStream inputStream) {
        abg com_fossil_abg;
        synchronized (aGW) {
            com_fossil_abg = (abg) aGW.poll();
        }
        if (com_fossil_abg == null) {
            com_fossil_abg = new abg();
        }
        com_fossil_abg.setInputStream(inputStream);
        return com_fossil_abg;
    }

    abg() {
    }

    void setInputStream(InputStream inputStream) {
        this.aGX = inputStream;
    }

    public int available() throws IOException {
        return this.aGX.available();
    }

    public void close() throws IOException {
        this.aGX.close();
    }

    public void mark(int i) {
        this.aGX.mark(i);
    }

    public boolean markSupported() {
        return this.aGX.markSupported();
    }

    public int read(byte[] bArr) throws IOException {
        try {
            return this.aGX.read(bArr);
        } catch (IOException e) {
            this.aGY = e;
            return -1;
        }
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        try {
            return this.aGX.read(bArr, i, i2);
        } catch (IOException e) {
            this.aGY = e;
            return -1;
        }
    }

    public synchronized void reset() throws IOException {
        this.aGX.reset();
    }

    public long skip(long j) throws IOException {
        try {
            return this.aGX.skip(j);
        } catch (IOException e) {
            this.aGY = e;
            return 0;
        }
    }

    public int read() throws IOException {
        try {
            return this.aGX.read();
        } catch (IOException e) {
            this.aGY = e;
            return -1;
        }
    }

    public IOException wU() {
        return this.aGY;
    }

    public void release() {
        this.aGY = null;
        this.aGX = null;
        synchronized (aGW) {
            aGW.offer(this);
        }
    }
}
