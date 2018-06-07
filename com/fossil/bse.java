package com.fossil;

final class bse {
    private final axm bBq;
    private long mStartTime;

    public bse(axm com_fossil_axm) {
        awa.bO(com_fossil_axm);
        this.bBq = com_fossil_axm;
    }

    public final boolean aq(long j) {
        return this.mStartTime == 0 || this.bBq.elapsedRealtime() - this.mStartTime >= j;
    }

    public final void clear() {
        this.mStartTime = 0;
    }

    public final void start() {
        this.mStartTime = this.bBq.elapsedRealtime();
    }
}
