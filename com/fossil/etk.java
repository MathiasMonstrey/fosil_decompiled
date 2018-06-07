package com.fossil;

import java.io.IOException;
import java.util.zip.Deflater;

public final class etk implements etu {
    private boolean closed;
    private final Deflater dTj;
    private final eti dyA;

    public etk(etu com_fossil_etu, Deflater deflater) {
        this(etp.m11179c(com_fossil_etu), deflater);
    }

    etk(eti com_fossil_eti, Deflater deflater) {
        if (com_fossil_eti == null) {
            throw new IllegalArgumentException("source == null");
        } else if (deflater == null) {
            throw new IllegalArgumentException("inflater == null");
        } else {
            this.dyA = com_fossil_eti;
            this.dTj = deflater;
        }
    }

    public void mo2728a(eth com_fossil_eth, long j) throws IOException {
        etx.m11198b(com_fossil_eth.Fs, 0, j);
        while (j > 0) {
            ets com_fossil_ets = com_fossil_eth.dTh;
            int min = (int) Math.min(j, (long) (com_fossil_ets.limit - com_fossil_ets.pos));
            this.dTj.setInput(com_fossil_ets.data, com_fossil_ets.pos, min);
            dM(false);
            com_fossil_eth.Fs -= (long) min;
            com_fossil_ets.pos += min;
            if (com_fossil_ets.pos == com_fossil_ets.limit) {
                com_fossil_eth.dTh = com_fossil_ets.aHG();
                ett.m11195b(com_fossil_ets);
            }
            j -= (long) min;
        }
    }

    private void dM(boolean z) throws IOException {
        eth aHe = this.dyA.aHe();
        while (true) {
            int deflate;
            ets pu = aHe.pu(1);
            if (z) {
                deflate = this.dTj.deflate(pu.data, pu.limit, 2048 - pu.limit, 2);
            } else {
                deflate = this.dTj.deflate(pu.data, pu.limit, 2048 - pu.limit);
            }
            if (deflate > 0) {
                pu.limit += deflate;
                aHe.Fs += (long) deflate;
                this.dyA.aHs();
            } else if (this.dTj.needsInput()) {
                break;
            }
        }
        if (pu.pos == pu.limit) {
            aHe.dTh = pu.aHG();
            ett.m11195b(pu);
        }
    }

    public void flush() throws IOException {
        dM(true);
        this.dyA.flush();
    }

    void aHt() throws IOException {
        this.dTj.finish();
        dM(false);
    }

    public void close() throws IOException {
        Throwable th;
        if (!this.closed) {
            Throwable th2 = null;
            try {
                aHt();
            } catch (Throwable th3) {
                th2 = th3;
            }
            try {
                this.dTj.end();
                th = th2;
            } catch (Throwable th4) {
                th = th4;
                if (th2 != null) {
                    th = th2;
                }
            }
            try {
                this.dyA.close();
            } catch (Throwable th22) {
                if (th == null) {
                    th = th22;
                }
            }
            this.closed = true;
            if (th != null) {
                etx.m11200q(th);
            }
        }
    }

    public etw aAf() {
        return this.dyA.aAf();
    }

    public String toString() {
        return "DeflaterSink(" + this.dyA + ")";
    }
}
