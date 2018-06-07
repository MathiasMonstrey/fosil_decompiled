package com.fossil;

abstract class bfe implements Runnable {
    private /* synthetic */ beu bsV;

    private bfe(beu com_fossil_beu) {
        this.bsV = com_fossil_beu;
    }

    protected abstract void NB();

    public void run() {
        this.bsV.bsg.lock();
        try {
            if (!Thread.interrupted()) {
                NB();
                this.bsV.bsg.unlock();
            }
        } catch (RuntimeException e) {
            this.bsV.bsG.m5070b(e);
        } finally {
            this.bsV.bsg.unlock();
        }
    }
}
