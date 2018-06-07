package com.fossil;

abstract class bfp {
    private final bfn btI;

    protected bfp(bfn com_fossil_bfn) {
        this.btI = com_fossil_bfn;
    }

    protected abstract void NB();

    public final void m5005c(bfo com_fossil_bfo) {
        com_fossil_bfo.bsg.lock();
        try {
            if (com_fossil_bfo.btE == this.btI) {
                NB();
                com_fossil_bfo.bsg.unlock();
            }
        } finally {
            com_fossil_bfo.bsg.unlock();
        }
    }
}
