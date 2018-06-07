package com.fossil;

abstract class bqi extends bqh {
    private boolean bru;

    bqi(bpk com_fossil_bpk) {
        super(com_fossil_bpk);
        this.zzboe.m5490b(this);
    }

    protected abstract void PH();

    protected final void RA() {
        if (!isInitialized()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void initialize() {
        if (this.bru) {
            throw new IllegalStateException("Can't initialize twice");
        }
        PH();
        this.zzboe.RP();
        this.bru = true;
    }

    final boolean isInitialized() {
        return this.bru;
    }
}
