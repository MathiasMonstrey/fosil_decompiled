package com.fossil;

final class bef implements Runnable {
    private /* synthetic */ bee bsi;

    bef(bee com_fossil_bee) {
        this.bsi = com_fossil_bee;
    }

    public final void run() {
        this.bsi.bsg.lock();
        try {
            this.bsi.Nm();
        } finally {
            this.bsi.bsg.unlock();
        }
    }
}
