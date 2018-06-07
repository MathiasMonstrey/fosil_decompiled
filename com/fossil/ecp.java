package com.fossil;

import android.content.Context;
import com.ua.sdk.UaException;

public class ecp {
    private final Context context;
    private final String dDv;
    private final String dDw;
    private final eiz dDx;

    public interface C2701c {
        void mo2338a(UaException uaException);
    }

    public interface C2703b {
        void mo2339a(ekn com_fossil_ekn, UaException uaException);
    }

    public static class C3316a {
        protected Context context;
        protected eiz dDC;
        protected boolean dDD = false;
        protected String dDv;
        protected String dDw;

        protected C3316a() {
        }

        public C3316a ej(Context context) {
            this.context = context;
            return this;
        }

        public C3316a lp(String str) {
            this.dDv = str;
            return this;
        }

        public C3316a lq(String str) {
            this.dDw = str;
            return this;
        }

        public C3316a m10477a(eiz com_fossil_eiz) {
            this.dDC = com_fossil_eiz;
            return this;
        }

        public C3316a dH(boolean z) {
            this.dDD = z;
            return this;
        }

        public ecp aCD() {
            ecp com_fossil_ecp;
            synchronized (ecp.class) {
                if (this.dDC == null) {
                    this.dDC = new eja(this.dDv, this.dDw, this.context, this.dDD);
                }
                com_fossil_ecp = new ecp(this);
            }
            return com_fossil_ecp;
        }
    }

    protected ecp(C3316a c3316a) {
        this.context = (Context) eiy.m10771e(c3316a.context, "context");
        this.dDv = (String) eiy.m10771e(c3316a.dDv, "clientId");
        this.dDw = (String) eiy.m10771e(c3316a.dDw, "clientSecret");
        this.dDx = (eiz) eiy.m10771e(c3316a.dDC, "uaProvider");
        ecq.debug("Ua created %s", this);
    }

    public ejy aCz() {
        return this.dDx.aCz();
    }

    public efj aCA() {
        return this.dDx.aCA();
    }

    public String lo(String str) {
        return this.dDx.aDz().lo(str);
    }

    public eck m10479a(final String str, C2703b c2703b) {
        final eck com_fossil_egx = new egx(c2703b);
        com_fossil_egx.setFuture(this.dDx.aDy().submit(new Runnable(this) {
            final /* synthetic */ ecp dDA;

            public void run() {
                try {
                    this.dDA.dDx.aDz().lx(str);
                    com_fossil_egx.m10739b(this.dDA.dDx.aDx().mo2938d(new ekm()), null);
                } catch (Throwable e) {
                    this.dDA.aCB();
                    ecq.m10489d("Failed to log in with authorization code.", e);
                    com_fossil_egx.m10739b(null, e);
                }
            }
        }));
        return com_fossil_egx;
    }

    public void m10480a(final C2701c c2701c) {
        this.dDx.aDy().submit(new Runnable(this) {
            final /* synthetic */ ecp dDA;

            public void run() {
                UaException uaException = null;
                try {
                    this.dDA.aCB();
                } catch (Throwable e) {
                    uaException = new UaException("Error logging out.", e);
                }
                egw.m10741a(uaException, c2701c);
            }
        });
    }

    protected void aCB() {
        this.dDx.aDz().aCB();
        this.dDx.aDx().aCB();
    }

    public boolean abM() {
        return this.dDx.aDz().abM();
    }

    public static C3316a aCC() {
        return new C3316a();
    }
}
