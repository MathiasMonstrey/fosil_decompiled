package com.fossil;

import java.io.File;
import java.util.List;

class abo implements eop {
    private final aby aHp;
    private final abv aHq;

    public static abo m2878a(aby com_fossil_aby) {
        return new abo(com_fossil_aby, new abv(new eoe(new abu(new eoc(1000, 8), 0.1d), new eob(5))));
    }

    abo(aby com_fossil_aby, abv com_fossil_abv) {
        this.aHp = com_fossil_aby;
        this.aHq = com_fossil_abv;
    }

    public boolean mo788u(List<File> list) {
        long nanoTime = System.nanoTime();
        if (!this.aHq.m2897A(nanoTime)) {
            return false;
        }
        if (this.aHp.mo788u(list)) {
            this.aHq.reset();
            return true;
        }
        this.aHq.m2898B(nanoTime);
        return false;
    }
}
