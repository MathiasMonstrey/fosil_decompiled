package com.fossil;

import com.flurry.sdk.kw;
import java.util.Timer;
import java.util.TimerTask;

public class apw {
    private static final String aWB = apw.class.getSimpleName();
    private Timer bbr;
    private C1797a bbs;
    private kw bbt;

    class C1797a extends TimerTask {
        final /* synthetic */ apw bbu;

        private C1797a(apw com_fossil_apw) {
            this.bbu = com_fossil_apw;
        }

        public final void run() {
            app.m4180g(3, apw.aWB, "HttpRequest timed out. Cancelling.");
            kw a = this.bbu.bbt;
            app.m4180g(3, kw.aWX, "Timeout (" + (System.currentTimeMillis() - a.aXW) + "MS) for url: " + a.aYv);
            a.bbD = 629;
            a.bbG = true;
            a.HK();
            a.HW();
        }
    }

    public apw(kw kwVar) {
        this.bbt = kwVar;
    }

    public final synchronized void m4198a(long j) {
        Object obj = null;
        synchronized (this) {
            if (this.bbr != null) {
                obj = 1;
            }
            if (obj != null) {
                HJ();
            }
            this.bbr = new Timer("HttpRequestTimeoutTimer");
            this.bbs = new C1797a();
            this.bbr.schedule(this.bbs, j);
            app.m4180g(3, aWB, "HttpRequestTimeoutTimer started: " + j + "MS");
        }
    }

    public final synchronized void HJ() {
        if (this.bbr != null) {
            this.bbr.cancel();
            this.bbr = null;
            app.m4180g(3, aWB, "HttpRequestTimeoutTimer stopped.");
        }
        this.bbs = null;
    }
}
