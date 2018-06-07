package com.fossil;

final class bhe implements Runnable {
    private /* synthetic */ atz buV;
    private /* synthetic */ bhd buW;

    bhe(bhd com_fossil_bhd, atz com_fossil_atz) {
        this.buW = com_fossil_bhd;
        this.buV = com_fossil_atz;
    }

    public final void run() {
        atv com_fossil_atv;
        try {
            bdy.brD.set(Boolean.valueOf(true));
            this.buW.buT.sendMessage(this.buW.buT.obtainMessage(0, this.buW.buO.m4497c(this.buV)));
            bdy.brD.set(Boolean.valueOf(false));
            bhd.m5168f(this.buV);
            com_fossil_atv = (atv) this.buW.brG.get();
            if (com_fossil_atv != null) {
                com_fossil_atv.mo1333b(this.buW);
            }
        } catch (RuntimeException e) {
            this.buW.buT.sendMessage(this.buW.buT.obtainMessage(1, e));
            bdy.brD.set(Boolean.valueOf(false));
            bhd.m5168f(this.buV);
            com_fossil_atv = (atv) this.buW.brG.get();
            if (com_fossil_atv != null) {
                com_fossil_atv.mo1333b(this.buW);
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            bdy.brD.set(Boolean.valueOf(false));
            bhd.m5168f(this.buV);
            com_fossil_atv = (atv) this.buW.brG.get();
            if (com_fossil_atv != null) {
                com_fossil_atv.mo1333b(this.buW);
            }
        }
    }
}
