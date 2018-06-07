package com.fossil;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

public final class etn implements etv {
    private final CRC32 crc = new CRC32();
    private int dTm = 0;
    private final Inflater dTn;
    private final eto dyM;
    private final etj dyk;

    public etn(etv com_fossil_etv) {
        if (com_fossil_etv == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.dTn = new Inflater(true);
        this.dyk = etp.m11180c(com_fossil_etv);
        this.dyM = new eto(this.dyk, this.dTn);
    }

    public long mo2733b(eth com_fossil_eth, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (j == 0) {
            return 0;
        } else {
            if (this.dTm == 0) {
                aHB();
                this.dTm = 1;
            }
            if (this.dTm == 1) {
                long j2 = com_fossil_eth.Fs;
                long b = this.dyM.mo2733b(com_fossil_eth, j);
                if (b != -1) {
                    m11169b(com_fossil_eth, j2, b);
                    return b;
                }
                this.dTm = 2;
            }
            if (this.dTm == 2) {
                aHC();
                this.dTm = 3;
                if (!this.dyk.aHi()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    private void aHB() throws IOException {
        Object obj;
        long g;
        this.dyk.bb(10);
        byte bc = this.dyk.aHe().bc(3);
        if (((bc >> 1) & 1) == 1) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            m11169b(this.dyk.aHe(), 0, 10);
        }
        m11168D("ID1ID2", 8075, this.dyk.readShort());
        this.dyk.bh(8);
        if (((bc >> 2) & 1) == 1) {
            this.dyk.bb(2);
            if (obj != null) {
                m11169b(this.dyk.aHe(), 0, 2);
            }
            short aHl = this.dyk.aHe().aHl();
            this.dyk.bb((long) aHl);
            if (obj != null) {
                m11169b(this.dyk.aHe(), 0, (long) aHl);
            }
            this.dyk.bh((long) aHl);
        }
        if (((bc >> 3) & 1) == 1) {
            g = this.dyk.mo3047g((byte) 0);
            if (g == -1) {
                throw new EOFException();
            }
            if (obj != null) {
                m11169b(this.dyk.aHe(), 0, 1 + g);
            }
            this.dyk.bh(1 + g);
        }
        if (((bc >> 4) & 1) == 1) {
            g = this.dyk.mo3047g((byte) 0);
            if (g == -1) {
                throw new EOFException();
            }
            if (obj != null) {
                m11169b(this.dyk.aHe(), 0, 1 + g);
            }
            this.dyk.bh(1 + g);
        }
        if (obj != null) {
            m11168D("FHCRC", this.dyk.aHl(), (short) ((int) this.crc.getValue()));
            this.crc.reset();
        }
    }

    private void aHC() throws IOException {
        m11168D("CRC", this.dyk.aHm(), (int) this.crc.getValue());
        m11168D("ISIZE", this.dyk.aHm(), this.dTn.getTotalOut());
    }

    public etw aAf() {
        return this.dyk.aAf();
    }

    public void close() throws IOException {
        this.dyM.close();
    }

    private void m11169b(eth com_fossil_eth, long j, long j2) {
        ets com_fossil_ets = com_fossil_eth.dTh;
        while (j >= ((long) (com_fossil_ets.limit - com_fossil_ets.pos))) {
            j -= (long) (com_fossil_ets.limit - com_fossil_ets.pos);
            com_fossil_ets = com_fossil_ets.dTA;
        }
        while (j2 > 0) {
            int i = (int) (((long) com_fossil_ets.pos) + j);
            int min = (int) Math.min((long) (com_fossil_ets.limit - i), j2);
            this.crc.update(com_fossil_ets.data, i, min);
            j2 -= (long) min;
            com_fossil_ets = com_fossil_ets.dTA;
            j = 0;
        }
    }

    private void m11168D(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i)}));
        }
    }
}
