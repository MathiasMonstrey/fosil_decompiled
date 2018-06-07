package com.fossil;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.FossilSwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.C1175b;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import com.fossil.cvg.C2382a;
import com.fossil.dkr.C2907a;
import com.fossil.dkr.C2908b;
import com.fossil.dlj.C2919a;
import com.fossil.dlq.C2920a;
import com.fossil.dmh.C2922a;
import com.fossil.dmo.C2923a;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import java.util.Calendar;
import kotlin.TypeCastException;

public final class dks extends ctm implements OnDismissListener, OnAttachStateChangeListener, C2908b {
    private static final String TAG;
    public static final C2909a cYO = new C2909a();
    private dqo<clm> cEY;
    public doy cOb;
    private dow cOc;
    public dmq cYA;
    public dnc cYB;
    public dmx cYC;
    public cvh cYE;
    private dlk cYF;
    private dlr cYG;
    private dmd cYH;
    private dly cYI;
    private dmi cYJ;
    private dmp cYK;
    private dnb cYL;
    private dmw cYM;
    private cvk cYN;
    private C2907a cYu;
    public dll cYv;
    public dls cYw;
    public dme cYx;
    public dlz cYy;
    public dmj cYz;

    public static final class C2909a {
        private C2909a() {
        }

        public final String getTAG() {
            return dks.TAG;
        }

        public final dks ard() {
            return new dks();
        }
    }

    static final class C2910b implements OnClickListener {
        final /* synthetic */ dks cYP;
        final /* synthetic */ clm cYQ;

        C2910b(dks com_fossil_dks, clm com_fossil_clm) {
            this.cYP = com_fossil_dks;
            this.cYQ = com_fossil_clm;
        }

        public final void onClick(View view) {
            this.cYP.hB("stats_activity");
            Boolean bool = clw.cwB;
            esl.m11127i(bool, "Constants.IS_ENABLE_BC");
            if (bool.booleanValue()) {
                FrameLayout frameLayout = this.cYQ.cvl;
                if (frameLayout != null) {
                    frameLayout.setVisibility(0);
                }
            }
            dks.m8942b(this.cYP).lk(0);
        }
    }

    static final class C2911c implements OnClickListener {
        final /* synthetic */ dks cYP;
        final /* synthetic */ clm cYQ;

        C2911c(dks com_fossil_dks, clm com_fossil_clm) {
            this.cYP = com_fossil_dks;
            this.cYQ = com_fossil_clm;
        }

        public final void onClick(View view) {
            this.cYP.hB("stats_sleep");
            Boolean bool = clw.cwB;
            esl.m11127i(bool, "Constants.IS_ENABLE_BC");
            if (bool.booleanValue()) {
                FrameLayout frameLayout = this.cYQ.cvl;
                if (frameLayout != null) {
                    frameLayout.setVisibility(8);
                }
            }
            dks.m8942b(this.cYP).lk(1);
        }
    }

    static final class C2912d implements C1175b {
        final /* synthetic */ dks cYP;
        final /* synthetic */ clm cYQ;

        C2912d(dks com_fossil_dks, clm com_fossil_clm) {
            this.cYP = com_fossil_dks;
            this.cYQ = com_fossil_clm;
        }

        public final void kA() {
            int fS = PortfolioApp.ZQ().fS(PortfolioApp.ZQ().aaa());
            MFLogger.m12670d(dks.cYO.getTAG(), "Inside .onRefresh currentDeviceSession=" + fS);
            if (fS == CommunicateMode.OTA.getValue()) {
                gy.m11536p(PortfolioApp.ZQ()).m11538b(new Intent("BROADCAST_DEVICE_BUSY_OTAING"));
                this.cYQ.ctp.setRefreshing(false);
                return;
            }
            dks.m8942b(this.cYP).sync();
        }
    }

    static final class C2913e implements OnClickListener {
        final /* synthetic */ dks cYP;

        C2913e(dks com_fossil_dks) {
            this.cYP = com_fossil_dks;
        }

        public final void onClick(View view) {
            this.cYP.hB("stats_this_week_tapped");
        }
    }

    public void jT(int r1) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.fossil.dks.jT(int):void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.addJump(MethodNode.java:370)
	at jadx.core.dex.nodes.MethodNode.initJumps(MethodNode.java:360)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:106)
	... 7 more
*/
        /*
        r0 = this;
        r3 = 2131755923; // 0x7f100393 float:1.9142739E38 double:1.053227367E-314;
        r7 = 2131624038; // 0x7f0e0066 float:1.8875244E38 double:1.053162207E-314;
        r6 = 2131624037; // 0x7f0e0065 float:1.8875242E38 double:1.0531622065E-314;
        r5 = 8;
        r4 = 0;
        r0 = r8.cEY;
        if (r0 != 0) goto L_0x0015;
    L_0x0010:
        r1 = "mBinding";
        com.fossil.esl.mF(r1);
    L_0x0015:
        r0 = r0.get();
        r0 = (com.fossil.clm) r0;
        if (r0 == 0) goto L_0x0021;
    L_0x001d:
        switch(r9) {
            case 0: goto L_0x0022;
            case 1: goto L_0x0066;
            default: goto L_0x0020;
        };
    L_0x0021:
        return;
    L_0x0022:
        r1 = r8.cYF;
        if (r1 != 0) goto L_0x0029;
    L_0x0026:
        com.fossil.esl.aGW();
    L_0x0029:
        r1 = (android.support.v4.app.Fragment) r1;
        r2 = "";
        r8.m7517c(r1, r2, r3);
        r1 = r8.cYH;
        if (r1 != 0) goto L_0x0037;
    L_0x0034:
        com.fossil.esl.aGW();
    L_0x0037:
        r1 = (android.support.v4.app.Fragment) r1;
        r2 = "";
        r3 = 2131755929; // 0x7f100399 float:1.9142751E38 double:1.05322737E-314;
        r8.m7517c(r1, r2, r3);
        r1 = r0.cvq;
        r1.setVisibility(r5);
        r1 = r0.cvp;
        r1.setVisibility(r4);
        r1 = r0.cvj;
        r2 = r8.getContext();
        r2 = com.fossil.gn.m10634e(r2, r6);
        r1.setTextColor(r2);
        r0 = r0.cvk;
        r1 = r8.getContext();
        r1 = com.fossil.gn.m10634e(r1, r7);
        r0.setTextColor(r1);
        goto L_0x0020;
    L_0x0066:
        r1 = r8.cYJ;
        if (r1 != 0) goto L_0x006d;
        com.fossil.esl.aGW();
        r1 = (android.support.v4.app.Fragment) r1;
        r2 = "";
        r8.m7517c(r1, r2, r3);
        r1 = r8.cYL;
        if (r1 != 0) goto L_0x007b;
        com.fossil.esl.aGW();
        r1 = (android.support.v4.app.Fragment) r1;
        r2 = "";
        r3 = 2131755929; // 0x7f100399 float:1.9142751E38 double:1.05322737E-314;
        r8.m7517c(r1, r2, r3);
        r1 = r0.cvp;
        r1.setVisibility(r5);
        r1 = r0.cvq;
        r1.setVisibility(r4);
        r1 = r0.cvk;
        r2 = r8.getContext();
        r2 = com.fossil.gn.m10634e(r2, r6);
        r1.setTextColor(r2);
        r0 = r0.cvj;
        r1 = r8.getContext();
        r1 = com.fossil.gn.m10634e(r1, r7);
        r0.setTextColor(r1);
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.dks.jT(int):void");
    }

    public static final /* synthetic */ C2907a m8942b(dks com_fossil_dks) {
        C2907a c2907a = com_fossil_dks.cYu;
        if (c2907a == null) {
            esl.mF("mPresenter");
        }
        return c2907a;
    }

    public /* synthetic */ void cK(Object obj) {
        m8943a((C2907a) obj);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        clm com_fossil_clm = (clm) C3311e.m10386a(layoutInflater, R.layout.stats_fragment, viewGroup, false, new ckn(this));
        com_fossil_clm.cvj.setOnClickListener(new C2910b(this, com_fossil_clm));
        com_fossil_clm.cvk.setOnClickListener(new C2911c(this, com_fossil_clm));
        com_fossil_clm.ctp.setOnRefreshListener(new C2912d(this, com_fossil_clm));
        this.cEY = new dqo(this, com_fossil_clm);
        com_fossil_clm.dz().addOnAttachStateChangeListener(this);
        return com_fossil_clm.dz();
    }

    public void onViewCreated(View view, Bundle bundle) {
        esl.m11128j(view, "view");
        super.onViewCreated(view, bundle);
        fa childFragmentManager = getChildFragmentManager();
        Fragment aF = childFragmentManager.aF(R.id.stats_day);
        Fragment aF2 = childFragmentManager.aF(R.id.stats_week);
        Fragment aF3 = childFragmentManager.aF(R.id.stats_buddy_challenge);
        if (esl.m11125C(aF, null)) {
            this.cYF = dlk.cZs.arR();
            dlk com_fossil_dlk = this.cYF;
            if (com_fossil_dlk == null) {
                esl.aGW();
            }
            m7516b(com_fossil_dlk, "", R.id.stats_day);
        } else if (aF instanceof dlk) {
            this.cYF = (dlk) aF;
        } else if (aF == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.portfolio.platform.ui.stats.sleep.day.StatsSleepDayFragment");
        } else {
            this.cYJ = (dmi) aF;
        }
        aF = getChildFragmentManager().mo3086W(dlr.cZE.getTAG());
        if (!(aF instanceof dlr)) {
            aF = null;
        }
        this.cYG = (dlr) aF;
        aF = getChildFragmentManager().mo3086W(dly.cZN.getTAG());
        if (!(aF instanceof dly)) {
            aF = null;
        }
        this.cYI = (dly) aF;
        aF = getChildFragmentManager().mo3086W(dmp.dak.getTAG());
        if (!(aF instanceof dmp)) {
            aF = null;
        }
        this.cYK = (dmp) aF;
        aF = getChildFragmentManager().mo3086W(dmw.das.getTAG());
        if (!(aF instanceof dmw)) {
            aF = null;
        }
        this.cYM = (dmw) aF;
        aF = getChildFragmentManager().mo3086W(dow.dcC.getTAG());
        if (!(aF instanceof dow)) {
            aF = null;
        }
        this.cOc = (dow) aF;
        if (esl.m11125C(aF2, null)) {
            this.cYH = dmd.cZT.asd();
            dmd com_fossil_dmd = this.cYH;
            if (com_fossil_dmd == null) {
                esl.aGW();
            }
            m7516b(com_fossil_dmd, "", R.id.stats_week);
        } else if (aF2 instanceof dmd) {
            this.cYH = (dmd) aF2;
        } else if (aF2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.portfolio.platform.ui.stats.sleep.week.StatsSleepWeekFragment");
        } else {
            this.cYL = (dnb) aF2;
        }
        View findViewById = view.findViewById(R.id.stats_week);
        if (findViewById != null) {
            findViewById.setOnClickListener(new C2913e(this));
        }
        if (aF3 == null) {
            this.cYN = cvk.cHo.aif();
            cvk com_fossil_cvk = this.cYN;
            if (com_fossil_cvk == null) {
                esl.aGW();
            }
            m7516b(com_fossil_cvk, "", R.id.stats_buddy_challenge);
        } else {
            this.cYN = (cvk) aF3;
        }
        if (!clw.cwB.booleanValue()) {
            View findViewById2 = view.findViewById(R.id.stats_buddy_challenge);
            if (findViewById2 != null) {
                findViewById2.setVisibility(8);
            }
        }
        if (this.cYF == null) {
            this.cYF = dlk.cZs.arR();
        }
        if (this.cYG == null) {
            this.cYG = dlr.cZE.arV();
        }
        if (this.cYH == null) {
            this.cYH = dmd.cZT.asd();
        }
        if (this.cYI == null) {
            this.cYI = dly.cZN.asa();
        }
        if (this.cYJ == null) {
            this.cYJ = dmi.daa.asf();
        }
        if (this.cYK == null) {
            this.cYK = dmp.dak.asi();
        }
        if (this.cYL == null) {
            this.cYL = dnb.daz.aso();
        }
        if (this.cYM == null) {
            this.cYM = dmw.das.asl();
        }
        if (this.cOc == null) {
            this.cOc = dow.dcC.aty();
        }
        PortfolioApp.ZQ().aam().mo1821a(new dku(this.cYF, this.cYG, this.cYH, this.cYI, this.cYJ, this.cYK, this.cYL, this.cYM, this.cOc, this.cYN, getLoaderManager(), Calendar.getInstance().getTime())).mo1764a(this);
        C2907a c2907a = this.cYu;
        if (c2907a == null) {
            esl.mF("mPresenter");
        }
        dll com_fossil_dll = this.cYv;
        if (com_fossil_dll == null) {
            esl.mF("mStatsActivityDayPresenter");
        }
        dls com_fossil_dls = this.cYw;
        if (com_fossil_dls == null) {
            esl.mF("mStatsActivityMonthPresenter");
        }
        dme com_fossil_dme = this.cYx;
        if (com_fossil_dme == null) {
            esl.mF("mStatsActivityWeekPresenter");
        }
        dlz com_fossil_dlz = this.cYy;
        if (com_fossil_dlz == null) {
            esl.mF("mStatsActivityOverviewPresenter");
        }
        dmj com_fossil_dmj = this.cYz;
        if (com_fossil_dmj == null) {
            esl.mF("mStatsSleepDayPresenter");
        }
        dmq com_fossil_dmq = this.cYA;
        if (com_fossil_dmq == null) {
            esl.mF("mStatsSleepMonthPresenter");
        }
        dnc com_fossil_dnc = this.cYB;
        if (com_fossil_dnc == null) {
            esl.mF("mStatsSleepWeekPresenter");
        }
        dmx com_fossil_dmx = this.cYC;
        if (com_fossil_dmx == null) {
            esl.mF("mStatsSleepOverviewPresenter");
        }
        cvh com_fossil_cvh = this.cYE;
        if (com_fossil_cvh == null) {
            esl.mF("mStatsBCPresenter");
        }
        c2907a.mo2526a(com_fossil_dll, com_fossil_dls, com_fossil_dme, com_fossil_dlz, com_fossil_dmj, com_fossil_dmq, com_fossil_dnc, com_fossil_dmx, com_fossil_cvh);
        dlk com_fossil_dlk2 = this.cYF;
        if (com_fossil_dlk2 == null) {
            esl.aGW();
        }
        c2907a = this.cYu;
        if (c2907a == null) {
            esl.mF("mPresenter");
        }
        if (c2907a == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.portfolio.platform.ui.stats.activity.day.StatsActivityDayContract.Presenter");
        }
        com_fossil_dlk2.m8983a((C2919a) c2907a);
        dlr com_fossil_dlr = this.cYG;
        if (com_fossil_dlr == null) {
            esl.aGW();
        }
        c2907a = this.cYu;
        if (c2907a == null) {
            esl.mF("mPresenter");
        }
        if (c2907a == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.portfolio.platform.ui.stats.activity.month.StatsActivityMonthContract.Presenter");
        }
        com_fossil_dlr.m9023a((C2920a) c2907a);
        dmi com_fossil_dmi = this.cYJ;
        if (com_fossil_dmi == null) {
            esl.aGW();
        }
        c2907a = this.cYu;
        if (c2907a == null) {
            esl.mF("mPresenter");
        }
        if (c2907a == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.portfolio.platform.ui.stats.sleep.day.StatsSleepDayContract.Presenter");
        }
        com_fossil_dmi.m9073a((C2922a) c2907a);
        dmp com_fossil_dmp = this.cYK;
        if (com_fossil_dmp == null) {
            esl.aGW();
        }
        c2907a = this.cYu;
        if (c2907a == null) {
            esl.mF("mPresenter");
        }
        if (c2907a == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.portfolio.platform.ui.stats.sleep.month.StatsSleepMonthContract.Presenter");
        }
        com_fossil_dmp.m9102a((C2923a) c2907a);
        Boolean bool = clw.cwB;
        esl.m11127i(bool, "Constants.IS_ENABLE_BC");
        if (bool.booleanValue()) {
            cvk com_fossil_cvk2 = this.cYN;
            if (com_fossil_cvk2 == null) {
                esl.aGW();
            }
            c2907a = this.cYu;
            if (c2907a == null) {
                esl.mF("mPresenter");
            }
            if (c2907a == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.portfolio.platform.ui.buddychallenge.StatsBCContract.Presenter");
            }
            com_fossil_cvk2.m7675a((C2382a) c2907a);
        }
    }

    public void onResume() {
        super.onResume();
        MFLogger.m12670d(cYO.getTAG(), "onResume");
        View view = getView();
        if (view == null) {
            esl.aGW();
        }
        if (view.isAttachedToWindow()) {
            C2907a c2907a = this.cYu;
            if (c2907a == null) {
                esl.mF("mPresenter");
            }
            c2907a.start();
        }
    }

    public void onPause() {
        super.onPause();
        MFLogger.m12670d(cYO.getTAG(), "onPause");
        View view = getView();
        if (view == null) {
            esl.aGW();
        }
        if (view.isAttachedToWindow()) {
            C2907a c2907a = this.cYu;
            if (c2907a == null) {
                esl.mF("mPresenter");
            }
            c2907a.stop();
        }
    }

    public void onViewAttachedToWindow(View view) {
        esl.m11128j(view, "v");
        MFLogger.m12670d(cYO.getTAG(), "onViewAttachedToWindow");
        C2907a c2907a = this.cYu;
        if (c2907a == null) {
            esl.mF("mPresenter");
        }
        c2907a.start();
    }

    public void onViewDetachedFromWindow(View view) {
        esl.m11128j(view, "v");
        MFLogger.m12670d(cYO.getTAG(), "onViewDetachedFromWindow");
        C2907a c2907a = this.cYu;
        if (c2907a == null) {
            esl.mF("mPresenter");
        }
        c2907a.stop();
    }

    public void m8943a(C2907a c2907a) {
        esl.m11128j(c2907a, "presenter");
        MFLogger.m12670d(cYO.getTAG(), "setPresenter: " + c2907a.getClass().getSimpleName());
        this.cYu = c2907a;
    }

    public void aqW() {
        dow com_fossil_dow = this.cOc;
        if (com_fossil_dow != null) {
            com_fossil_dow.setCancelable(false);
        }
        com_fossil_dow = this.cOc;
        if (com_fossil_dow != null) {
            com_fossil_dow.setDimAmount(0.0f);
        }
        com_fossil_dow = this.cOc;
        if (com_fossil_dow != null) {
            com_fossil_dow.lc(aid());
        }
        com_fossil_dow = this.cOc;
        if (com_fossil_dow != null) {
            fa childFragmentManager = getChildFragmentManager();
            esl.m11127i(childFragmentManager, "childFragmentManager");
            com_fossil_dow.show(childFragmentManager, dow.dcC.getTAG());
        }
    }

    public void aqX() {
        dly com_fossil_dly = this.cYI;
        if (com_fossil_dly != null) {
            com_fossil_dly.setCancelable(false);
        }
        com_fossil_dly = this.cYI;
        if (com_fossil_dly != null) {
            fa childFragmentManager = getChildFragmentManager();
            esl.m11127i(childFragmentManager, "childFragmentManager");
            com_fossil_dly.show(childFragmentManager, dly.cZN.getTAG());
        }
    }

    public void aqZ() {
        dlr com_fossil_dlr = this.cYG;
        if (com_fossil_dlr == null) {
            esl.aGW();
        }
        if (!com_fossil_dlr.isAdded()) {
            arb();
            com_fossil_dlr = this.cYG;
            if (com_fossil_dlr == null) {
                esl.aGW();
            }
            com_fossil_dlr.show(getChildFragmentManager(), dlr.cZE.getTAG());
        }
    }

    public void ara() {
        arb();
        dmp com_fossil_dmp = this.cYK;
        if (com_fossil_dmp == null) {
            esl.aGW();
        }
        com_fossil_dmp.show(getChildFragmentManager(), dlr.cZE.getTAG());
    }

    public void aqY() {
        dmw com_fossil_dmw = this.cYM;
        if (com_fossil_dmw != null) {
            com_fossil_dmw.setCancelable(false);
        }
        com_fossil_dmw = this.cYM;
        if (com_fossil_dmw != null) {
            fa childFragmentManager = getChildFragmentManager();
            esl.m11127i(childFragmentManager, "childFragmentManager");
            com_fossil_dmw.show(childFragmentManager, dmw.das.getTAG());
        }
    }

    public void arb() {
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        clm com_fossil_clm = (clm) com_fossil_dqo.get();
        if (com_fossil_clm != null) {
            ScrollView scrollView = com_fossil_clm.cqW;
            if (scrollView != null) {
                scrollView.setScrollY(0);
            }
        }
    }

    public void arc() {
        dse.hide();
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        clm com_fossil_clm = (clm) com_fossil_dqo.get();
        if (com_fossil_clm != null) {
            ScrollView scrollView = com_fossil_clm.cqW;
            if (scrollView != null) {
                scrollView.fullScroll(130);
            }
        }
    }

    public void cD(boolean z) {
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        clm com_fossil_clm = (clm) com_fossil_dqo.get();
        if (com_fossil_clm != null) {
            FossilSwipeRefreshLayout fossilSwipeRefreshLayout = com_fossil_clm.ctp;
            if (fossilSwipeRefreshLayout != null) {
                fossilSwipeRefreshLayout.setRefreshing(z);
            }
        }
    }

    public void afM() {
        afU();
    }

    public void onDismiss(DialogInterface dialogInterface) {
        C2907a c2907a = this.cYu;
        if (c2907a == null) {
            esl.mF("mPresenter");
        }
        c2907a.aqU();
    }

    public void aqV() {
        if (isActive()) {
            dqw.m9410B(getChildFragmentManager());
        }
    }

    private final int alj() {
        Resources resources = PortfolioApp.ZQ().getResources();
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        return identifier > 0 ? resources.getDimensionPixelSize(identifier) : 0;
    }

    private final int aid() {
        int height = getActivity().getWindow().findViewById(16908290).getHeight();
        TypedValue typedValue = new TypedValue();
        int i = 0;
        if (getContext().getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true)) {
            i = TypedValue.complexToDimensionPixelSize(typedValue.data, getResources().getDisplayMetrics());
        }
        return (height - i) - alj();
    }

    public String getTAG() {
        return cYO.getTAG();
    }

    static {
        String simpleName = dks.class.getSimpleName();
        if (simpleName == null) {
            esl.aGW();
        }
        TAG = simpleName;
    }
}
