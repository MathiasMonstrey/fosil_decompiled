package com.fossil;

import java.util.Timer;
import java.util.TimerTask;

final class aqn {
    private Timer bcq;
    private C1840a bcr;

    class C1840a extends TimerTask {
        final /* synthetic */ aqn bcs;

        C1840a(aqn com_fossil_aqn) {
            this.bcs = com_fossil_aqn;
        }

        public final void run() {
            this.bcs.HO();
            apl.IW().m4167a(new aqo());
        }
    }

    aqn() {
    }

    public final synchronized void m4240a(long j) {
        if (Ja()) {
            HO();
        }
        this.bcq = new Timer("FlurrySessionTimer");
        this.bcr = new C1840a(this);
        this.bcq.schedule(this.bcr, j);
    }

    public final boolean Ja() {
        return this.bcq != null;
    }

    public final synchronized void HO() {
        if (this.bcq != null) {
            this.bcq.cancel();
            this.bcq = null;
        }
        this.bcr = null;
    }
}
