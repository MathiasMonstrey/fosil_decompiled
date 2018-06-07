package com.fossil;

import java.io.IOException;

public abstract class etl implements etv {
    private final etv dTk;

    public etl(etv com_fossil_etv) {
        if (com_fossil_etv == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.dTk = com_fossil_etv;
    }

    public long mo2733b(eth com_fossil_eth, long j) throws IOException {
        return this.dTk.mo2733b(com_fossil_eth, j);
    }

    public etw aAf() {
        return this.dTk.aAf();
    }

    public void close() throws IOException {
        this.dTk.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.dTk.toString() + ")";
    }
}
