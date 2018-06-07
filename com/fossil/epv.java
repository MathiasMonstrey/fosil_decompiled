package com.fossil;

public class epv {
    public final epe aHE;
    public final epr aJz;
    public final eph dQE;
    public final eps dQF;
    public final epp dQG;
    public final epi dQH;
    public final long dQI;
    public final int dQJ;
    public final int dQK;

    public epv(long j, eph com_fossil_eph, eps com_fossil_eps, epr com_fossil_epr, epp com_fossil_epp, epe com_fossil_epe, epi com_fossil_epi, int i, int i2) {
        this.dQI = j;
        this.dQE = com_fossil_eph;
        this.dQF = com_fossil_eps;
        this.aJz = com_fossil_epr;
        this.dQG = com_fossil_epp;
        this.dQJ = i;
        this.dQK = i2;
        this.aHE = com_fossil_epe;
        this.dQH = com_fossil_epi;
    }

    public boolean aW(long j) {
        return this.dQI < j;
    }
}
