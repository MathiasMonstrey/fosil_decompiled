package com.fossil;

import android.text.TextUtils;
import com.fossil.ckb.C2126d;
import com.fossil.ckb.C2133c;
import com.fossil.dnl.C2996a;
import com.fossil.dnl.C2997b;
import com.fossil.dqf.C3097a;
import com.fossil.dqf.C3098b;
import com.portfolio.platform.PortfolioApp;

public class dnp implements C2996a {
    private C2997b dbc;
    private dqf dbe;
    private ckc mUseCaseHandler;

    class C29981 implements C2126d<C2133c, C3098b> {
        final /* synthetic */ dnp dbf;

        C29981(dnp com_fossil_dnp) {
            this.dbf = com_fossil_dnp;
        }

        public /* synthetic */ void onError(Object obj) {
            m9185a((C3098b) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m9184a((C2133c) obj);
        }

        public void m9184a(C2133c c2133c) {
            this.dbf.dbc.afM();
            this.dbf.dbc.asB();
        }

        public void m9185a(C3098b c3098b) {
            this.dbf.dbc.afM();
            this.dbf.dbc.jV(c3098b.getErrorCode());
        }
    }

    public dnp(C2997b c2997b, ckc com_fossil_ckc, dqf com_fossil_dqf) {
        this.dbc = (C2997b) cco.m5996s(c2997b, "forgotPasswordView cannot be null!");
        this.dbe = (dqf) cco.m5996s(com_fossil_dqf, "resetPasswordUseCase cannot be null");
        this.dbc.cK(this);
        this.mUseCaseHandler = (ckc) cco.m5996s(com_fossil_ckc, "useCaseHandler cannot be nulL!");
    }

    public void start() {
    }

    public void stop() {
    }

    public void iU(String str) {
        String trim = str.trim();
        switch (dqp.ji(trim)) {
            case 1:
                PortfolioApp.ZQ().YV().jJ(1);
                PortfolioApp.ZQ().aan();
                this.dbc.dc(true);
                return;
            case 2:
                PortfolioApp.ZQ().YV().jJ(2);
                PortfolioApp.ZQ().aan();
                this.dbc.dc(false);
                return;
            default:
                if (iV(trim)) {
                    this.dbc.afL();
                    this.mUseCaseHandler.m6886a(this.dbe, new C3097a(trim), new C29981(this));
                    return;
                }
                return;
        }
    }

    private boolean iV(String str) {
        boolean z = !TextUtils.isEmpty(str) && dra.m9453v(str);
        this.dbc.dd(z);
        return z;
    }
}
