package com.fossil;

import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.widget.Toast;
import com.flurry.sdk.in;
import com.fossil.anz.C1751a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class any {
    public static final String aWB = any.class.getSimpleName();
    public static AtomicInteger aYC;
    static api<List<anz>> aYD;
    private static any aYE;
    private static Map<Integer, anz> aYF;
    public static int f1400b;
    public static int f1401c;
    private apk<aot> aXf = new C17431(this);
    private final AtomicInteger aYG;
    private long aYw;

    class C17431 implements apk<aot> {
        final /* synthetic */ any aYH;

        class C17421 implements Runnable {
            final /* synthetic */ C17431 aYI;

            C17421(C17431 c17431) {
                this.aYI = c17431;
            }

            public final void run() {
                aoa.Ig().HO();
            }
        }

        C17431(any com_fossil_any) {
            this.aYH = com_fossil_any;
        }

        public final /* synthetic */ void mo759a(apj com_fossil_apj) {
            aot com_fossil_aot = (aot) com_fossil_apj;
            app.m4180g(4, any.aWB, "onNetworkStateChanged : isNetworkEnable = " + com_fossil_aot.aXk);
            if (com_fossil_aot.aXk) {
                apc.IO().m4160b(new C17421(this));
            }
        }
    }

    class C17442 implements aqk<List<anz>> {
        C17442() {
        }

        public final aqi<List<anz>> hi(int i) {
            return new aqh(new C1751a());
        }
    }

    class C17453 implements Runnable {
        final /* synthetic */ any aYH;

        C17453(any com_fossil_any) {
            this.aYH = com_fossil_any;
        }

        public final void run() {
            this.aYH.HM();
        }
    }

    class C17464 implements Runnable {
        final /* synthetic */ any aYH;

        C17464(any com_fossil_any) {
            this.aYH = com_fossil_any;
        }

        public final void run() {
            this.aYH.HM();
        }
    }

    class C17486 implements Runnable {
        final /* synthetic */ any aYH;

        C17486(any com_fossil_any) {
            this.aYH = com_fossil_any;
        }

        public final void run() {
            any.HZ();
            List HY = any.HY();
            if (any.aYD == null) {
                any.HW();
            }
            any.aYD.bJ(HY);
        }
    }

    private any() {
        aYF = new HashMap();
        this.aYG = new AtomicInteger(0);
        aYC = new AtomicInteger(0);
        if (f1401c == 0) {
            f1401c = 600000;
        }
        if (f1400b == 0) {
            f1400b = 15;
        }
        this.aYw = apc.IO().baD.getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).getLong("timeToSendNextPulseReport", 0);
        if (aYD == null) {
            HW();
        }
        apl.IW().m4169a("com.flurry.android.sdk.NetworkStateEvent", this.aXf);
    }

    private static void HW() {
        aYD = new api(apc.IO().baD.getFileStreamPath(".yflurryanongoingpulsecallbackreporter"), ".yflurryanongoingpulsecallbackreporter", 2, new C17442());
    }

    public static void m4037a(int i) {
        f1400b = i;
    }

    public static void hj(int i) {
        f1401c = i;
    }

    public final synchronized void m4041a(anz com_fossil_anz) {
        if (com_fossil_anz == null) {
            app.m4180g(3, aWB, "Must add valid PulseCallbackAsyncReportInfo");
        } else {
            app.m4180g(3, aWB, "Adding and sending " + com_fossil_anz.f1404d + " report to PulseCallbackManager.");
            if (com_fossil_anz.Id().size() != 0) {
                if (this.aYw == 0) {
                    this.aYw = System.currentTimeMillis() + ((long) f1401c);
                    apc.IO().m4160b(new C17453(this));
                }
                int HX = HX();
                com_fossil_anz.f1403c = HX;
                aYF.put(Integer.valueOf(HX), com_fossil_anz);
                for (anw b : com_fossil_anz.Id()) {
                    ana.HD().aXa.m4006b((apy) b);
                }
            }
        }
    }

    private void HM() {
        Editor edit = apc.IO().baD.getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).edit();
        edit.putLong("timeToSendNextPulseReport", this.aYw);
        edit.apply();
    }

    private synchronized int HX() {
        return this.aYG.incrementAndGet();
    }

    public final synchronized void m4043b(anz com_fossil_anz) {
        if (com_fossil_anz == null) {
            app.m4180g(3, aWB, "Must add valid PulseCallbackAsyncReportInfo");
        } else {
            if (this.aYw == 0) {
                this.aYw = System.currentTimeMillis() + ((long) f1401c);
                apc.IO().m4160b(new C17464(this));
            }
            int HX = HX();
            com_fossil_anz.f1403c = HX;
            aYF.put(Integer.valueOf(HX), com_fossil_anz);
            for (anw com_fossil_anw : com_fossil_anz.Id()) {
                Iterator it = com_fossil_anw.aYm.iterator();
                while (it.hasNext()) {
                    it.next();
                    aYC.incrementAndGet();
                    if (Ia()) {
                        app.m4180g(3, aWB, "Max Callback Attempts threshold reached. Sending callback logging reports");
                        HS();
                    }
                }
            }
            if (Ib()) {
                app.m4180g(3, aWB, "Time threshold reached. Sending callback logging reports");
                HS();
            }
            app.m4180g(3, aWB, "Restoring " + com_fossil_anz.f1404d + " report to PulseCallbackManager. Number of stored completed callbacks: " + aYC.get());
        }
    }

    public final synchronized void m4040a(final anx com_fossil_anx) {
        app.m4180g(3, aWB, com_fossil_anx.aYz.aYn.f1404d + " report sent successfully to " + com_fossil_anx.aYz.aYp);
        com_fossil_anx.aYu = in.COMPLETE;
        com_fossil_anx.aYv = "";
        m4039b(com_fossil_anx);
        if (app.HF() <= 3 && app.IY()) {
            apc.IO().m4158a(new Runnable(this) {
                final /* synthetic */ any aYK;

                public final void run() {
                    Toast.makeText(apc.IO().baD, "PulseCallbackReportInfo HTTP Response Code: " + com_fossil_anx.f1399e + " for url: " + com_fossil_anx.aYz.bbL, 1).show();
                }
            });
        }
    }

    private void m4039b(anx com_fossil_anx) {
        com_fossil_anx.aWE = true;
        com_fossil_anx.HJ();
        aYC.incrementAndGet();
        com_fossil_anx.aYz.HH();
        app.m4180g(3, aWB, com_fossil_anx.aYz.aYn.f1404d + " report to " + com_fossil_anx.aYz.aYp + " finalized.");
        HJ();
        HP();
    }

    public final void HJ() {
        apc.IO().m4160b(new C17486(this));
    }

    private void HP() {
        if (Ia() || Ib()) {
            app.m4180g(3, aWB, "Threshold reached. Sending callback logging reports");
            HS();
        }
    }

    public static List<anz> HY() {
        return new ArrayList(aYF.values());
    }

    public static synchronized any HZ() {
        any com_fossil_any;
        synchronized (any.class) {
            if (aYE == null) {
                aYE = new any();
            }
            com_fossil_any = aYE;
        }
        return com_fossil_any;
    }

    private static boolean Ia() {
        return aYC.intValue() >= f1400b;
    }

    private boolean Ib() {
        return System.currentTimeMillis() > this.aYw;
    }

    private void HS() {
        Iterator it;
        for (anz com_fossil_anz : HY()) {
            int i = 0;
            for (anw com_fossil_anw : com_fossil_anz.Id()) {
                Iterator it2 = com_fossil_anw.aYm.iterator();
                while (it2.hasNext()) {
                    anx com_fossil_anx = (anx) it2.next();
                    if (com_fossil_anx.aYx) {
                        it2.remove();
                    } else if (!com_fossil_anx.aYu.equals(in.PENDING_COMPLETION)) {
                        com_fossil_anx.aYx = true;
                        i = true;
                    }
                }
            }
            if (i != 0) {
                aoa.Ig().m4069a(com_fossil_anz);
            }
        }
        aoa.Ig().HO();
        this.aYw = System.currentTimeMillis() + ((long) f1401c);
        HM();
        for (anz com_fossil_anz2 : HY()) {
            if (com_fossil_anz2.Ie()) {
                hk(com_fossil_anz2.f1403c);
            } else {
                for (anw com_fossil_anw2 : com_fossil_anz2.Id()) {
                    if (com_fossil_anw2.aYq) {
                        com_fossil_anz2.aWU.remove(Long.valueOf(com_fossil_anw2.aXm));
                    } else {
                        it = com_fossil_anw2.aYm.iterator();
                        while (it.hasNext()) {
                            if (((anx) it.next()).aYx) {
                                it.remove();
                            }
                        }
                    }
                }
            }
        }
        aYC = new AtomicInteger(0);
        HJ();
    }

    private synchronized void hk(int i) {
        app.m4180g(3, aWB, "Removing report " + i + " from PulseCallbackManager");
        aYF.remove(Integer.valueOf(i));
    }

    public final synchronized boolean m4042a(anx com_fossil_anx, String str) {
        boolean z = true;
        synchronized (this) {
            boolean z2;
            com_fossil_anx.aXp++;
            com_fossil_anx.aYw = System.currentTimeMillis();
            if (com_fossil_anx.aXp > com_fossil_anx.aYz.f1395c) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2 || TextUtils.isEmpty(str)) {
                app.m4180g(3, aWB, "Maximum number of redirects attempted. Aborting: " + com_fossil_anx.aYz.aYn.f1404d + " report to " + com_fossil_anx.aYz.aYp);
                com_fossil_anx.aYu = in.INVALID_RESPONSE;
                com_fossil_anx.aYv = "";
                m4039b(com_fossil_anx);
                z = false;
            } else {
                app.m4180g(3, aWB, "Report to " + com_fossil_anx.aYz.aYp + " redirecting to url: " + str);
                com_fossil_anx.aYz.bbL = str;
                HJ();
            }
        }
        return z;
    }

    public final synchronized void m4045c(anx com_fossil_anx) {
        app.m4180g(3, aWB, "Maximum number of attempts reached. Aborting: " + com_fossil_anx.aYz.aYn.f1404d);
        com_fossil_anx.aYu = in.TIMEOUT;
        com_fossil_anx.aYw = System.currentTimeMillis();
        com_fossil_anx.aYv = "";
        m4039b(com_fossil_anx);
    }

    public final synchronized boolean m4044b(anx com_fossil_anx, String str) {
        boolean z = false;
        synchronized (this) {
            boolean z2;
            com_fossil_anx.aYu = in.INVALID_RESPONSE;
            com_fossil_anx.aYw = System.currentTimeMillis();
            if (str == null) {
                str = "";
            }
            com_fossil_anx.aYv = str;
            apy com_fossil_apy = com_fossil_anx.aYz;
            if (com_fossil_apy.bbJ >= com_fossil_apy.f1394b) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                app.m4180g(3, aWB, "Maximum number of attempts reached. Aborting: " + com_fossil_anx.aYz.aYn.f1404d + " report to " + com_fossil_anx.aYz.aYp);
                m4039b(com_fossil_anx);
            } else if (aqz.cE(com_fossil_anx.aYz.bbL)) {
                app.m4180g(3, aWB, "Retrying callback to " + com_fossil_anx.aYz.aYn.f1404d + " in: " + (com_fossil_anx.aYz.aYo / 1000) + " seconds.");
                com_fossil_anx.HJ();
                aYC.incrementAndGet();
                HJ();
                HP();
                z = true;
            } else {
                app.m4180g(3, aWB, "Url: " + com_fossil_anx.aYz.bbL + " is invalid.");
                m4039b(com_fossil_anx);
            }
        }
        return z;
    }

    public static List<anz> Ic() {
        if (aYD == null) {
            HW();
        }
        return (List) aYD.IV();
    }
}
