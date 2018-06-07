package com.fossil;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public interface afm {

    public static class C1619a implements afm {
        protected final InputStream aMQ;
        protected final byte[] aMR;
        protected final int aMS;
        protected int aMT;
        protected int aMU;

        public C1619a(InputStream inputStream, byte[] bArr) {
            this.aMQ = inputStream;
            this.aMR = bArr;
            this.aMS = 0;
            this.aMU = 0;
            this.aMT = 0;
        }

        public C1619a(byte[] bArr, int i, int i2) {
            this.aMQ = null;
            this.aMR = bArr;
            this.aMU = i;
            this.aMS = i;
            this.aMT = i + i2;
        }

        public boolean Bo() throws IOException {
            if (this.aMU < this.aMT) {
                return true;
            }
            if (this.aMQ == null) {
                return false;
            }
            int length = this.aMR.length - this.aMU;
            if (length < 1) {
                return false;
            }
            length = this.aMQ.read(this.aMR, this.aMU, length);
            if (length <= 0) {
                return false;
            }
            this.aMT += length;
            return true;
        }

        public byte nextByte() throws IOException {
            if (this.aMU < this.aMT || Bo()) {
                byte[] bArr = this.aMR;
                int i = this.aMU;
                this.aMU = i + 1;
                return bArr[i];
            }
            throw new EOFException("Failed auto-detect: could not read more than " + this.aMU + " bytes (max buffer size: " + this.aMR.length + ")");
        }

        public void reset() {
            this.aMU = this.aMS;
        }
    }

    boolean Bo() throws IOException;

    byte nextByte() throws IOException;
}
