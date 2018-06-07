package com.fossil;

import java.io.IOException;
import java.net.ProtocolException;

public final class dxa implements etu {
    private boolean closed;
    private final eth dzU;
    private final int limit;

    public dxa(int i) {
        this.dzU = new eth();
        this.limit = i;
    }

    public dxa() {
        this(-1);
    }

    public void close() throws IOException {
        if (!this.closed) {
            this.closed = true;
            if (this.dzU.size() < ((long) this.limit)) {
                throw new ProtocolException("content-length promised " + this.limit + " bytes, but received " + this.dzU.size());
            }
        }
    }

    public void mo2728a(eth com_fossil_eth, long j) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        dvw.m9973b(com_fossil_eth.size(), 0, j);
        if (this.limit == -1 || this.dzU.size() <= ((long) this.limit) - j) {
            this.dzU.mo2728a(com_fossil_eth, j);
            return;
        }
        throw new ProtocolException("exceeded content-length limit of " + this.limit + " bytes");
    }

    public void flush() throws IOException {
    }

    public etw aAf() {
        return etw.dTD;
    }

    public long contentLength() throws IOException {
        return this.dzU.size();
    }

    public void m10249a(etu com_fossil_etu) throws IOException {
        eth com_fossil_eth = new eth();
        this.dzU.m11155a(com_fossil_eth, 0, this.dzU.size());
        com_fossil_etu.mo2728a(com_fossil_eth, com_fossil_eth.size());
    }
}
