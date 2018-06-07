package com.fossil;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeoutException;

final class bqv implements Callable<String> {
    private /* synthetic */ bqk bCm;

    bqv(bqk com_fossil_bqk) {
        this.bCm = com_fossil_bqk;
    }

    public final /* synthetic */ Object call() throws Exception {
        Object Ro = this.bCm.Pg().Ro();
        if (Ro == null) {
            Ro = this.bCm.OS().am(120000);
            if (Ro == null) {
                throw new TimeoutException();
            }
            this.bCm.Pg().en(Ro);
        }
        return Ro;
    }
}
