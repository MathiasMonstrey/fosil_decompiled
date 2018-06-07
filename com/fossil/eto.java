package com.fossil;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.Inflater;

public final class eto implements etv {
    private boolean closed;
    private final Inflater dTn;
    private int dTo;
    private final etj dyk;

    public eto(etv com_fossil_etv, Inflater inflater) {
        this(etp.m11180c(com_fossil_etv), inflater);
    }

    eto(etj com_fossil_etj, Inflater inflater) {
        if (com_fossil_etj == null) {
            throw new IllegalArgumentException("source == null");
        } else if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        } else {
            this.dyk = com_fossil_etj;
            this.dTn = inflater;
        }
    }

    public long mo2733b(eth com_fossil_eth, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.closed) {
            throw new IllegalStateException("closed");
        } else if (j == 0) {
            return 0;
        } else {
            boolean aHD;
            do {
                aHD = aHD();
                try {
                    ets pu = com_fossil_eth.pu(1);
                    int inflate = this.dTn.inflate(pu.data, pu.limit, 2048 - pu.limit);
                    if (inflate > 0) {
                        pu.limit += inflate;
                        com_fossil_eth.Fs += (long) inflate;
                        return (long) inflate;
                    } else if (this.dTn.finished() || this.dTn.needsDictionary()) {
                        aHE();
                        if (pu.pos == pu.limit) {
                            com_fossil_eth.dTh = pu.aHG();
                            ett.m11195b(pu);
                        }
                        return -1;
                    }
                } catch (Throwable e) {
                    throw new IOException(e);
                }
            } while (!aHD);
            throw new EOFException("source exhausted prematurely");
        }
    }

    public boolean aHD() throws IOException {
        if (!this.dTn.needsInput()) {
            return false;
        }
        aHE();
        if (this.dTn.getRemaining() != 0) {
            throw new IllegalStateException("?");
        } else if (this.dyk.aHi()) {
            return true;
        } else {
            ets com_fossil_ets = this.dyk.aHe().dTh;
            this.dTo = com_fossil_ets.limit - com_fossil_ets.pos;
            this.dTn.setInput(com_fossil_ets.data, com_fossil_ets.pos, this.dTo);
            return false;
        }
    }

    private void aHE() throws IOException {
        if (this.dTo != 0) {
            int remaining = this.dTo - this.dTn.getRemaining();
            this.dTo -= remaining;
            this.dyk.bh((long) remaining);
        }
    }

    public etw aAf() {
        return this.dyk.aAf();
    }

    public void close() throws IOException {
        if (!this.closed) {
            this.dTn.end();
            this.closed = true;
            this.dyk.close();
        }
    }
}
