package com.fossil;

import java.io.IOException;
import java.io.InputStream;

public final class afq extends InputStream {
    private final InputStream aMQ;
    private int aMU;
    private final afo aNs;
    private byte[] aNt;
    private final int aNu;

    public afq(afo com_fossil_afo, InputStream inputStream, byte[] bArr, int i, int i2) {
        this.aNs = com_fossil_afo;
        this.aMQ = inputStream;
        this.aNt = bArr;
        this.aMU = i;
        this.aNu = i2;
    }

    public int available() throws IOException {
        if (this.aNt != null) {
            return this.aNu - this.aMU;
        }
        return this.aMQ.available();
    }

    public void close() throws IOException {
        BI();
        this.aMQ.close();
    }

    public void mark(int i) {
        if (this.aNt == null) {
            this.aMQ.mark(i);
        }
    }

    public boolean markSupported() {
        return this.aNt == null && this.aMQ.markSupported();
    }

    public int read() throws IOException {
        if (this.aNt == null) {
            return this.aMQ.read();
        }
        byte[] bArr = this.aNt;
        int i = this.aMU;
        this.aMU = i + 1;
        int i2 = bArr[i] & 255;
        if (this.aMU < this.aNu) {
            return i2;
        }
        BI();
        return i2;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.aNt == null) {
            return this.aMQ.read(bArr, i, i2);
        }
        int i3 = this.aNu - this.aMU;
        if (i2 > i3) {
            i2 = i3;
        }
        System.arraycopy(this.aNt, this.aMU, bArr, i, i2);
        this.aMU += i2;
        if (this.aMU < this.aNu) {
            return i2;
        }
        BI();
        return i2;
    }

    public void reset() throws IOException {
        if (this.aNt == null) {
            this.aMQ.reset();
        }
    }

    public long skip(long j) throws IOException {
        long j2;
        if (this.aNt != null) {
            int i = this.aNu - this.aMU;
            if (((long) i) > j) {
                this.aMU += (int) j;
                return j;
            }
            BI();
            j2 = ((long) i) + 0;
            j -= (long) i;
        } else {
            j2 = 0;
        }
        if (j > 0) {
            j2 += this.aMQ.skip(j);
        }
        return j2;
    }

    private void BI() {
        byte[] bArr = this.aNt;
        if (bArr != null) {
            this.aNt = null;
            if (this.aNs != null) {
                this.aNs.m3145S(bArr);
            }
        }
    }
}
