package com.fossil;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class eua extends OutputStream {
    private static final byte[] dwU = new byte[0];
    private int count;
    private final List<byte[]> dTM;
    private int dTN;
    private int dTO;
    private byte[] dTP;

    public eua() {
        this(1024);
    }

    public eua(int i) {
        this.dTM = new ArrayList();
        if (i < 0) {
            throw new IllegalArgumentException("Negative initial size: " + i);
        }
        synchronized (this) {
            pA(i);
        }
    }

    private void pA(int i) {
        if (this.dTN < this.dTM.size() - 1) {
            this.dTO += this.dTP.length;
            this.dTN++;
            this.dTP = (byte[]) this.dTM.get(this.dTN);
            return;
        }
        if (this.dTP == null) {
            this.dTO = 0;
        } else {
            i = Math.max(this.dTP.length << 1, i - this.dTO);
            this.dTO += this.dTP.length;
        }
        this.dTN++;
        this.dTP = new byte[i];
        this.dTM.add(this.dTP);
    }

    public void write(byte[] bArr, int i, int i2) {
        if (i < 0 || i > bArr.length || i2 < 0 || i + i2 > bArr.length || i + i2 < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i2 != 0) {
            synchronized (this) {
                int i3 = this.count + i2;
                int i4 = this.count - this.dTO;
                int i5 = i2;
                while (i5 > 0) {
                    int min = Math.min(i5, this.dTP.length - i4);
                    System.arraycopy(bArr, (i + i2) - i5, this.dTP, i4, min);
                    i5 -= min;
                    if (i5 > 0) {
                        pA(i3);
                        i4 = 0;
                    }
                }
                this.count = i3;
            }
        }
    }

    public synchronized void write(int i) {
        int i2 = this.count - this.dTO;
        if (i2 == this.dTP.length) {
            pA(this.count + 1);
            i2 = 0;
        }
        this.dTP[i2] = (byte) i;
        this.count++;
    }

    public void close() throws IOException {
    }

    public synchronized byte[] toByteArray() {
        byte[] bArr;
        int i = this.count;
        if (i == 0) {
            bArr = dwU;
        } else {
            Object obj = new byte[i];
            int i2 = i;
            i = 0;
            for (byte[] bArr2 : this.dTM) {
                int min = Math.min(bArr2.length, i2);
                System.arraycopy(bArr2, 0, obj, i, min);
                int i3 = i + min;
                i = i2 - min;
                if (i == 0) {
                    break;
                }
                i2 = i;
                i = i3;
            }
            Object obj2 = obj;
        }
        return bArr2;
    }

    public String toString() {
        return new String(toByteArray());
    }
}
