package com.fossil;

import java.io.IOException;
import java.io.OutputStream;
import okio.ByteString;

final class etq implements eti {
    private boolean closed;
    public final eth dTt;
    public final etu dTu;

    class C35451 extends OutputStream {
        final /* synthetic */ etq dTv;

        C35451(etq com_fossil_etq) {
            this.dTv = com_fossil_etq;
        }

        public void write(int i) throws IOException {
            if (this.dTv.closed) {
                throw new IOException("closed");
            }
            this.dTv.dTt.pr((byte) i);
            this.dTv.aHs();
        }

        public void write(byte[] bArr, int i, int i2) throws IOException {
            if (this.dTv.closed) {
                throw new IOException("closed");
            }
            this.dTv.dTt.m11163m(bArr, i, i2);
            this.dTv.aHs();
        }

        public void flush() throws IOException {
            if (!this.dTv.closed) {
                this.dTv.flush();
            }
        }

        public void close() throws IOException {
            this.dTv.close();
        }

        public String toString() {
            return this.dTv + ".outputStream()";
        }
    }

    public etq(etu com_fossil_etu, eth com_fossil_eth) {
        if (com_fossil_etu == null) {
            throw new IllegalArgumentException("sink == null");
        }
        this.dTt = com_fossil_eth;
        this.dTu = com_fossil_etu;
    }

    public etq(etu com_fossil_etu) {
        this(com_fossil_etu, new eth());
    }

    public eth aHe() {
        return this.dTt;
    }

    public void mo2728a(eth com_fossil_eth, long j) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.dTt.mo2728a(com_fossil_eth, j);
        aHs();
    }

    public eti mo3046f(ByteString byteString) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.dTt.m11160e(byteString);
        return aHs();
    }

    public eti mI(String str) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.dTt.mH(str);
        return aHs();
    }

    public eti ay(byte[] bArr) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.dTt.ax(bArr);
        return aHs();
    }

    public eti mo3049n(byte[] bArr, int i, int i2) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.dTt.m11163m(bArr, i, i2);
        return aHs();
    }

    public long mo3040b(etv com_fossil_etv) throws IOException {
        if (com_fossil_etv == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long b = com_fossil_etv.mo2733b(this.dTt, 2048);
            if (b == -1) {
                return j;
            }
            j += b;
            aHs();
        }
    }

    public eti px(int i) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.dTt.pr(i);
        return aHs();
    }

    public eti pw(int i) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.dTt.ps(i);
        return aHs();
    }

    public eti pv(int i) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.dTt.pt(i);
        return aHs();
    }

    public eti bj(long j) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.dTt.bi(j);
        return aHs();
    }

    public eti aHs() throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        long aHk = this.dTt.aHk();
        if (aHk > 0) {
            this.dTu.mo2728a(this.dTt, aHk);
        }
        return this;
    }

    public eti aHh() throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        long size = this.dTt.size();
        if (size > 0) {
            this.dTu.mo2728a(this.dTt, size);
        }
        return this;
    }

    public OutputStream aHf() {
        return new C35451(this);
    }

    public void flush() throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (this.dTt.Fs > 0) {
            this.dTu.mo2728a(this.dTt, this.dTt.Fs);
        }
        this.dTu.flush();
    }

    public void close() throws IOException {
        if (!this.closed) {
            Throwable th = null;
            try {
                if (this.dTt.Fs > 0) {
                    this.dTu.mo2728a(this.dTt, this.dTt.Fs);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.dTu.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.closed = true;
            if (th != null) {
                etx.m11200q(th);
            }
        }
    }

    public etw aAf() {
        return this.dTu.aAf();
    }

    public String toString() {
        return "buffer(" + this.dTu + ")";
    }
}
