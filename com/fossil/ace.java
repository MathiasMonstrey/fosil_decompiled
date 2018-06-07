package com.fossil;

import android.annotation.SuppressLint;
import android.content.Context;
import io.fabric.sdk.android.services.common.IdManager;
import java.util.concurrent.atomic.AtomicBoolean;

abstract class ace implements acn {
    private acg aHi;
    private epb aHm;
    private eov aHu;
    private final AtomicBoolean aIb;
    private final AtomicBoolean aIc;
    private IdManager aId;
    private epi aIe;
    private ach aIf;
    private enj aIg;
    private long aIh;
    private Context context;

    public ace() {
        this(false);
    }

    public ace(boolean z) {
        this.aIb = new AtomicBoolean();
        this.aIh = 0;
        this.aIc = new AtomicBoolean(z);
    }

    public void mo809a(Context context, acg com_fossil_acg, IdManager idManager, epi com_fossil_epi, ach com_fossil_ach, epb com_fossil_epb, enj com_fossil_enj, eov com_fossil_eov) {
        this.context = context;
        this.aHi = com_fossil_acg;
        this.aId = idManager;
        this.aIe = com_fossil_epi;
        this.aIf = com_fossil_ach;
        this.aHm = com_fossil_epb;
        this.aIg = com_fossil_enj;
        this.aHu = com_fossil_eov;
        if (xu()) {
            xv();
        }
    }

    protected boolean xt() {
        this.aIc.set(true);
        return this.aIb.get();
    }

    boolean xu() {
        this.aIb.set(true);
        return this.aIc.get();
    }

    @SuppressLint({"CommitPrefEdits"})
    protected void xv() {
        synchronized (this.aHm) {
            if (this.aHm.aGu().contains("last_update_check")) {
                this.aHm.mo2992b(this.aHm.edit().remove("last_update_check"));
            }
        }
        long aFr = this.aIg.aFr();
        long j = ((long) this.aIe.dQe) * 1000;
        emm.aEU().mo2950d("Beta", "Check for updates delay: " + j);
        emm.aEU().mo2950d("Beta", "Check for updates last check time: " + xx());
        j += xx();
        emm.aEU().mo2950d("Beta", "Check for updates current time: " + aFr + ", next check time: " + j);
        if (aFr >= j) {
            try {
                xw();
            } finally {
                m2925C(aFr);
            }
        } else {
            emm.aEU().mo2950d("Beta", "Check for updates next check time was not passed");
        }
    }

    private void xw() {
        emm.aEU().mo2950d("Beta", "Performing update check");
        String er = new eng().er(this.context);
        new aci(this.aHi, this.aHi.xj(), this.aIe.dQd, this.aHu, new ack()).m2937a(er, this.aId.bl(er, this.aIf.packageName), this.aIf);
    }

    void m2925C(long j) {
        this.aIh = j;
    }

    long xx() {
        return this.aIh;
    }
}
