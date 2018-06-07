package com.fossil;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import okio.ByteString;

final class etr implements etj {
    private boolean closed;
    public final eth dTt;
    public final etv dTw;

    class C35461 extends InputStream {
        final /* synthetic */ etr dTx;

        C35461(etr com_fossil_etr) {
            this.dTx = com_fossil_etr;
        }

        public int read() throws IOException {
            if (this.dTx.closed) {
                throw new IOException("closed");
            } else if (this.dTx.dTt.Fs == 0 && this.dTx.dTw.mo2733b(this.dTx.dTt, 2048) == -1) {
                return -1;
            } else {
                return this.dTx.dTt.readByte() & 255;
            }
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            if (this.dTx.closed) {
                throw new IOException("closed");
            }
            etx.m11198b((long) bArr.length, (long) i, (long) i2);
            if (this.dTx.dTt.Fs == 0 && this.dTx.dTw.mo2733b(this.dTx.dTt, 2048) == -1) {
                return -1;
            }
            return this.dTx.dTt.read(bArr, i, i2);
        }

        public int available() throws IOException {
            if (!this.dTx.closed) {
                return (int) Math.min(this.dTx.dTt.Fs, 2147483647L);
            }
            throw new IOException("closed");
        }

        public void close() throws IOException {
            this.dTx.close();
        }

        public String toString() {
            return this.dTx + ".inputStream()";
        }
    }

    public etr(etv com_fossil_etv, eth com_fossil_eth) {
        if (com_fossil_etv == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.dTt = com_fossil_eth;
        this.dTw = com_fossil_etv;
    }

    public etr(etv com_fossil_etv) {
        this(com_fossil_etv, new eth());
    }

    public eth aHe() {
        return this.dTt;
    }

    public long mo2733b(eth com_fossil_eth, long j) throws IOException {
        if (com_fossil_eth == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.closed) {
            throw new IllegalStateException("closed");
        } else if (this.dTt.Fs == 0 && this.dTw.mo2733b(this.dTt, 2048) == -1) {
            return -1;
        } else {
            return this.dTt.mo2733b(com_fossil_eth, Math.min(j, this.dTt.Fs));
        }
    }

    public boolean aHi() throws IOException {
        if (!this.closed) {
            return this.dTt.aHi() && this.dTw.mo2733b(this.dTt, 2048) == -1;
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public void bb(long j) throws IOException {
        if (!bl(j)) {
            throw new EOFException();
        }
    }

    public boolean bl(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.closed) {
            throw new IllegalStateException("closed");
        } else {
            while (this.dTt.Fs < j) {
                if (this.dTw.mo2733b(this.dTt, 2048) == -1) {
                    return false;
                }
            }
            return true;
        }
    }

    public byte readByte() throws IOException {
        bb(1);
        return this.dTt.readByte();
    }

    public ByteString bd(long j) throws IOException {
        bb(j);
        return this.dTt.bd(j);
    }

    public byte[] bg(long j) throws IOException {
        bb(j);
        return this.dTt.bg(j);
    }

    public String aHp() throws IOException {
        long g = mo3047g((byte) 10);
        if (g != -1) {
            return this.dTt.bf(g);
        }
        eth com_fossil_eth = new eth();
        this.dTt.m11155a(com_fossil_eth, 0, Math.min(32, this.dTt.size()));
        throw new EOFException("\\n not found: size=" + this.dTt.size() + " content=" + com_fossil_eth.aAt().hex() + "...");
    }

    public short readShort() throws IOException {
        bb(2);
        return this.dTt.readShort();
    }

    public short aHl() throws IOException {
        bb(2);
        return this.dTt.aHl();
    }

    public int readInt() throws IOException {
        bb(4);
        return this.dTt.readInt();
    }

    public int aHm() throws IOException {
        bb(4);
        return this.dTt.aHm();
    }

    public long aHn() throws IOException {
        bb(1);
        for (int i = 0; bl((long) (i + 1)); i++) {
            byte bc = this.dTt.bc((long) i);
            if ((bc < (byte) 48 || bc > (byte) 57) && ((bc < (byte) 97 || bc > (byte) 102) && (bc < (byte) 65 || bc > (byte) 70))) {
                if (i == 0) {
                    throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[]{Byte.valueOf(bc)}));
                }
                return this.dTt.aHn();
            }
        }
        return this.dTt.aHn();
    }

    public void bh(long j) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            if (this.dTt.Fs == 0 && this.dTw.mo2733b(this.dTt, 2048) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j, this.dTt.size());
            this.dTt.bh(min);
            j -= min;
        }
    }

    public long mo3047g(byte b) throws IOException {
        return m11190a(b, 0);
    }

    public long m11190a(byte b, long j) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (j >= this.dTt.Fs) {
            if (this.dTw.mo2733b(this.dTt, 2048) == -1) {
                return -1;
            }
        }
        do {
            long a = this.dTt.m11154a(b, j);
            if (a != -1) {
                return a;
            }
            j = this.dTt.Fs;
        } while (this.dTw.mo2733b(this.dTt, 2048) != -1);
        return -1;
    }

    public InputStream aHj() {
        return new C35461(this);
    }

    public void close() throws IOException {
        if (!this.closed) {
            this.closed = true;
            this.dTw.close();
            this.dTt.clear();
        }
    }

    public etw aAf() {
        return this.dTw.aAf();
    }

    public String toString() {
        return "buffer(" + this.dTw + ")";
    }
}
