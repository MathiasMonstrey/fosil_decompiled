package com.fossil;

import com.flurry.sdk.jo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class apz<ReportInfo extends apy> {
    private static final String aWB = apz.class.getSimpleName();
    public static long aXv = 10000;
    public boolean aWM;
    private final apk<aot> aXf = new C17992(this);
    private int aXp;
    public long aYX;
    private final api<List<ReportInfo>> bav;
    private final List<ReportInfo> bbM = new ArrayList();
    private final Runnable bbN = new C17981(this);
    private final int f1392e = Integer.MAX_VALUE;

    class C17981 extends aqx {
        final /* synthetic */ apz bbO;

        C17981(apz com_fossil_apz) {
            this.bbO = com_fossil_apz;
        }

        public final void HJ() {
            this.bbO.HO();
        }
    }

    class C17992 implements apk<aot> {
        final /* synthetic */ apz bbO;

        C17992(apz com_fossil_apz) {
            this.bbO = com_fossil_apz;
        }

        public final /* bridge */ /* synthetic */ void mo759a(apj com_fossil_apj) {
            if (((aot) com_fossil_apj).aXk) {
                this.bbO.HO();
            }
        }
    }

    class C18003 extends aqx {
        final /* synthetic */ apz bbO;

        C18003(apz com_fossil_apz) {
            this.bbO = com_fossil_apz;
        }

        public final void HJ() {
            this.bbO.mo1111a(this.bbO.bbM);
            this.bbO.HO();
        }
    }

    class C18014 extends aqx {
        final /* synthetic */ apz bbO;

        C18014(apz com_fossil_apz) {
            this.bbO = com_fossil_apz;
        }

        public final void HJ() {
            this.bbO.HK();
        }
    }

    class C18025 extends aqx {
        final /* synthetic */ apz bbO;

        C18025(apz com_fossil_apz) {
            this.bbO = com_fossil_apz;
        }

        public final void HJ() {
            this.bbO.HO();
        }
    }

    class C18036 extends aqx {
        final /* synthetic */ apz bbO;

        C18036(apz com_fossil_apz) {
            this.bbO = com_fossil_apz;
        }

        public final void HJ() {
            this.bbO.HO();
        }
    }

    class C18047 extends aqx {
        final /* synthetic */ apz bbO;

        C18047(apz com_fossil_apz) {
            this.bbO = com_fossil_apz;
        }

        public final void HJ() {
            this.bbO.HK();
        }
    }

    class C18058 extends aqx {
        final /* synthetic */ apz bbO;

        C18058(apz com_fossil_apz) {
            this.bbO = com_fossil_apz;
        }

        public final void HJ() {
            this.bbO.HK();
        }
    }

    public abstract api<List<ReportInfo>> HU();

    public abstract void mo1110a(ReportInfo reportInfo);

    public apz() {
        apl.IW().m4169a("com.flurry.android.sdk.NetworkStateEvent", this.aXf);
        this.bav = HU();
        this.aYX = aXv;
        this.aXp = -1;
        apc.IO().m4160b(new C18003(this));
    }

    public synchronized void mo1111a(List<ReportInfo> list) {
        aqv.HO();
        List list2 = (List) this.bav.IV();
        if (list2 != null) {
            list.addAll(list2);
        }
    }

    private synchronized void HO() {
        if (!this.aWM) {
            if (this.aXp >= 0) {
                app.m4180g(3, aWB, "Transmit is in progress");
            } else {
                m4003d();
                if (this.bbM.isEmpty()) {
                    this.aYX = aXv;
                    this.aXp = -1;
                } else {
                    this.aXp = 0;
                    apc.IO().m4160b(new C18014(this));
                }
            }
        }
    }

    private synchronized void m4003d() {
        Iterator it = this.bbM.iterator();
        while (it.hasNext()) {
            apy com_fossil_apy = (apy) it.next();
            if (com_fossil_apy.f1393o) {
                app.m4180g(3, aWB, "Url transmitted - " + com_fossil_apy.bbK + " Attempts: " + com_fossil_apy.bbJ);
                it.remove();
            } else if (com_fossil_apy.bbJ > com_fossil_apy.m4019a()) {
                app.m4180g(3, aWB, "Exceeded max no of attempts - " + com_fossil_apy.bbK + " Attempts: " + com_fossil_apy.bbJ);
                it.remove();
            } else if (System.currentTimeMillis() > com_fossil_apy.aXW && com_fossil_apy.bbJ > 0) {
                app.m4180g(3, aWB, "Expired: Time expired - " + com_fossil_apy.bbK + " Attempts: " + com_fossil_apy.bbJ);
                it.remove();
            }
        }
    }

    private synchronized void HK() {
        apy com_fossil_apy;
        aqv.HO();
        if (jo.ID().aXI) {
            while (this.aXp < this.bbM.size()) {
                List list = this.bbM;
                int i = this.aXp;
                this.aXp = i + 1;
                com_fossil_apy = (apy) list.get(i);
                if (!com_fossil_apy.f1393o) {
                    break;
                }
            }
            com_fossil_apy = null;
        } else {
            app.m4180g(3, aWB, "Network is not available, aborting transmission");
            com_fossil_apy = null;
        }
        if (com_fossil_apy == null) {
            HW();
        } else {
            mo1110a(com_fossil_apy);
        }
    }

    private synchronized void HW() {
        m4003d();
        mo1112x(this.bbM);
        if (this.aWM) {
            app.m4180g(3, aWB, "Reporter paused");
            this.aYX = aXv;
        } else if (this.bbM.isEmpty()) {
            app.m4180g(3, aWB, "All reports sent successfully");
            this.aYX = aXv;
        } else {
            this.aYX <<= 1;
            app.m4180g(3, aWB, "One or more reports failed to send, backing off: " + this.aYX + "ms");
            apc.IO().m4159a(this.bbN, this.aYX);
        }
        this.aXp = -1;
    }

    public synchronized void mo1112x(List<ReportInfo> list) {
        aqv.HO();
        this.bav.bJ(new ArrayList(list));
    }

    public final void HH() {
        this.aWM = false;
        apc.IO().m4160b(new C18025(this));
    }

    public final synchronized void m4006b(ReportInfo reportInfo) {
        if (reportInfo != null) {
            this.bbM.add(reportInfo);
            apc.IO().m4160b(new C18036(this));
        }
    }

    public final synchronized void m4007c(ReportInfo reportInfo) {
        reportInfo.f1393o = true;
        apc.IO().m4160b(new C18047(this));
    }

    public final synchronized void m4008d(ReportInfo reportInfo) {
        reportInfo.HV();
        apc.IO().m4160b(new C18058(this));
    }
}
