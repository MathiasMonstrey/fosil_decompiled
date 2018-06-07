package com.fossil;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.fossil.dlj.C2919a;
import com.fossil.dlj.C2925b;
import com.fossil.drk.C2095b;
import com.fossil.dse.C3168a;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.enums.Unit;
import com.portfolio.platform.view.FlexibleTextView;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import kotlin.TypeCastException;

public final class dlk extends ctm implements OnAttachStateChangeListener, C2925b, C2095b {
    private static final String TAG;
    public static final C2926a cZs = new C2926a();
    private dqo<cli> cEY;
    private C2919a cZr;

    public static final class C2926a {
        private C2926a() {
        }

        public final String getTAG() {
            return dlk.TAG;
        }

        public final dlk arR() {
            return new dlk();
        }
    }

    static final class C2927b implements OnClickListener {
        final /* synthetic */ dlk cZt;

        C2927b(dlk com_fossil_dlk) {
            this.cZt = com_fossil_dlk;
        }

        public final void onClick(View view) {
            this.cZt.hB("stats_activity_date_selector");
            dlk.m8979a(this.cZt).arz();
        }
    }

    static final class C2928c implements OnClickListener {
        final /* synthetic */ dlk cZt;

        C2928c(dlk com_fossil_dlk) {
            this.cZt = com_fossil_dlk;
        }

        public final void onClick(View view) {
            this.cZt.hB("stats_info");
            dlk.m8979a(this.cZt).arw();
        }
    }

    static final class C2929d implements OnClickListener {
        final /* synthetic */ dlk cZt;

        C2929d(dlk com_fossil_dlk) {
            this.cZt = com_fossil_dlk;
        }

        public final void onClick(View view) {
            dlk.m8979a(this.cZt).arw();
        }
    }

    static final class C2930e implements OnClickListener {
        final /* synthetic */ dlk cZt;

        C2930e(dlk com_fossil_dlk) {
            this.cZt = com_fossil_dlk;
        }

        public final void onClick(View view) {
            dlk.m8979a(this.cZt).arx();
        }
    }

    static final class C2931f implements OnClickListener {
        final /* synthetic */ dlk cZt;

        C2931f(dlk com_fossil_dlk) {
            this.cZt = com_fossil_dlk;
        }

        public final void onClick(View view) {
            this.cZt.iR("2nd_Stats_Tooltip");
            dlk.m8979a(this.cZt).arF();
        }
    }

    static final class C2932g implements OnClickListener {
        final /* synthetic */ dlk cZt;

        C2932g(dlk com_fossil_dlk) {
            this.cZt = com_fossil_dlk;
        }

        public final void onClick(View view) {
            this.cZt.iR("3rd_Stats_Tooltip");
            dlk.m8979a(this.cZt).arD();
        }
    }

    static final class C2933h implements OnClickListener {
        final /* synthetic */ dlk cZt;

        C2933h(dlk com_fossil_dlk) {
            this.cZt = com_fossil_dlk;
        }

        public final void onClick(View view) {
            this.cZt.iR("1st_Stats_Tooltip");
            dlk.m8979a(this.cZt).arE();
        }
    }

    public void aJ(long r1) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.fossil.dlk.aJ(long):void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: java.lang.NullPointerException
*/
        /*
        r0 = this;
        r0 = cZs;
        r0 = r0.getTAG();
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "showSyncTime: lastSyncTimeSuccess = ";
        r1 = r1.append(r2);
        r1 = r1.append(r8);
        r1 = r1.toString();
        com.misfit.frameworks.common.log.MFLogger.m12670d(r0, r1);
        r0 = r7.cEY;
        if (r0 == 0) goto L_0x0032;
    L_0x0020:
        r0 = r0.get();
        r0 = (com.fossil.cli) r0;
        if (r0 == 0) goto L_0x0032;
    L_0x0028:
        r1 = (int) r8;
        if (r1 != 0) goto L_0x0033;
    L_0x002b:
        r0 = r0.cqQ;
        r1 = 4;
        r0.setVisibility(r1);
    L_0x0032:
        return;
    L_0x0033:
        r1 = r0.cqQ;
        r2 = 0;
        r1.setVisibility(r2);
        r6 = r0.cqQ;
        r0 = (int) r8;
        r1 = -1;
        if (r0 != r1) goto L_0x0050;
    L_0x003f:
        r0 = r7.getContext();
        r1 = 2131296748; // 0x7f0901ec float:1.8211421E38 double:1.0530005043E-314;
        r0 = com.fossil.arp.m4318u(r0, r1);
        r0 = (java.lang.CharSequence) r0;
        r6.setText(r0);
        goto L_0x0031;
    L_0x0050:
        r0 = java.lang.System.currentTimeMillis();
        r0 = r0 - r8;
        r2 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r2 = (long) r2;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 >= 0) goto L_0x006a;
        r0 = r7.getContext();
        r1 = 2131296741; // 0x7f0901e5 float:1.8211407E38 double:1.053000501E-314;
        r0 = com.fossil.arp.m4318u(r0, r1);
        r0 = (java.lang.CharSequence) r0;
        goto L_0x004c;
        r2 = java.lang.System.currentTimeMillis();
        r0 = java.util.concurrent.TimeUnit.SECONDS;
        r4 = 1;
        r4 = r0.toMillis(r4);
        r0 = r8;
        r0 = android.text.format.DateUtils.getRelativeTimeSpanString(r0, r2, r4);
        goto L_0x004c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.dlk.aJ(long):void");
    }

    public static final /* synthetic */ C2919a m8979a(dlk com_fossil_dlk) {
        C2919a c2919a = com_fossil_dlk.cZr;
        if (c2919a == null) {
            esl.mF("mPresenter");
        }
        return c2919a;
    }

    public /* synthetic */ void cK(Object obj) {
        m8983a((C2919a) obj);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        cli com_fossil_cli = (cli) C3311e.m10386a(layoutInflater, R.layout.stats_activity_day_fragment, viewGroup, false, new ckn(this));
        com_fossil_cli.cuS.setOnClickListener(new C2927b(this));
        com_fossil_cli.cuN.setOnClickListener(new C2928c(this));
        com_fossil_cli.cuU.setOnClickListener(new C2929d(this));
        com_fossil_cli.cuO.setOnRingClickListener(new C2930e(this));
        com_fossil_cli.dz().addOnAttachStateChangeListener(this);
        this.cEY = new dqo(this, com_fossil_cli);
        return com_fossil_cli.dz();
    }

    public void onResume() {
        super.onResume();
        MFLogger.m12670d(cZs.getTAG(), "onResume");
        View view = getView();
        if (view == null) {
            esl.aGW();
        }
        if (view.isAttachedToWindow()) {
            C2919a c2919a = this.cZr;
            if (c2919a == null) {
                esl.mF("mPresenter");
            }
            c2919a.arB();
        }
    }

    public void onPause() {
        super.onPause();
        MFLogger.m12670d(cZs.getTAG(), "onPause");
        View view = getView();
        if (view == null) {
            esl.aGW();
        }
        if (view.isAttachedToWindow()) {
            C2919a c2919a = this.cZr;
            if (c2919a == null) {
                esl.mF("mPresenter");
            }
            c2919a.arC();
        }
    }

    public void onViewAttachedToWindow(View view) {
        esl.m11128j(view, "v");
        MFLogger.m12670d(cZs.getTAG(), "onViewAttachedToWindow");
        C2919a c2919a = this.cZr;
        if (c2919a == null) {
            esl.mF("mPresenter");
        }
        c2919a.arB();
    }

    public void onViewDetachedFromWindow(View view) {
        esl.m11128j(view, "v");
        MFLogger.m12670d(cZs.getTAG(), "onViewDetachedFromWindow");
        C2919a c2919a = this.cZr;
        if (c2919a == null) {
            esl.mF("mPresenter");
        }
        c2919a.arC();
    }

    public void m8983a(C2919a c2919a) {
        esl.m11128j(c2919a, "presenter");
        MFLogger.m12670d(cZs.getTAG(), "setPresenter: " + c2919a.getClass());
        this.cZr = c2919a;
    }

    public void arO() {
        MFLogger.m12670d(cZs.getTAG(), "showDateTooltip");
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo != null) {
            cli com_fossil_cli = (cli) com_fossil_dqo.get();
            if (com_fossil_cli != null) {
                new C3168a(com_fossil_cli.cuS).mi(R.string.Stats_Activity_Onboarding_Calendar_Text_Tap_to_see_a_monthly).m9610a(R.string.Stats_Activity_Onboarding_Calendar_CTA_OK, new C2932g(this)).show();
            }
        }
    }

    public void arP() {
        MFLogger.m12670d(cZs.getTAG(), "showInfoTooltip");
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo != null) {
            cli com_fossil_cli = (cli) com_fossil_dqo.get();
            if (com_fossil_cli != null) {
                new C3168a(com_fossil_cli.cuN).mi(R.string.Stats_Activity_Onboarding_Edit_Text_Tap_here_to_edit_your).m9610a(R.string.Stats_Activity_Onboarding_Edit_CTA_OK, new C2933h(this)).show();
            }
        }
    }

    public void arQ() {
        MFLogger.m12670d(cZs.getTAG(), "showChartTooltip");
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo != null) {
            cli com_fossil_cli = (cli) com_fossil_dqo.get();
            if (com_fossil_cli != null) {
                new C3168a(com_fossil_cli.cuO).mi(R.string.Stats_Activity_Onboarding_Detail_Text_Tap_to_view_detailed_activity).m9610a(R.string.Stats_Activity_Onboarding_Detail_CTA_OK, new C2931f(this)).mj(8388613).mk(48).show();
            }
        }
    }

    public void mo2556u(Date date) {
        esl.m11128j(date, "date");
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo != null) {
            cli com_fossil_cli = (cli) com_fossil_dqo.get();
            if (com_fossil_cli != null) {
                FlexibleTextView flexibleTextView = com_fossil_cli.cuS;
                if (flexibleTextView != null) {
                    CharSequence u;
                    Boolean c = cmq.m7114c(date);
                    esl.m11127i(c, "DateHelper.isToday(date)");
                    if (c.booleanValue()) {
                        u = arp.m4318u(getContext(), R.string.Stats_Activity_Label_Today);
                    } else {
                        u = new SimpleDateFormat("dd, MMM EEE", Locale.getDefault()).format(date);
                    }
                    flexibleTextView.setText(u);
                }
            }
        }
    }

    public void mo2549a(float f, float f2, float f3, float f4, float f5, int i) {
        MFLogger.m12670d(cZs.getTAG(), "showActivities: light = " + f + ", moderate = " + f2 + ", intense = " + f3 + ", distance = " + f4 + ", calories = " + f5 + ", stepGoal = " + i);
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo != null) {
            cli com_fossil_cli = (cli) com_fossil_dqo.get();
            if (com_fossil_cli != null) {
                String u;
                com_fossil_cli.cuO.clearData();
                if (i > 0) {
                    com_fossil_cli.cuO.setGoal(i);
                    FlexibleTextView flexibleTextView = com_fossil_cli.cuV;
                    esm com_fossil_esm = esm.dSO;
                    u = arp.m4318u(getContext(), R.string.Stats_Activity_Text_OF__STEPS);
                    esl.m11127i(u, "LanguageHelper.getString…_Activity_Text_OF__STEPS)");
                    Object[] objArr = new Object[]{NumberFormat.getNumberInstance(Locale.US).format(Integer.valueOf(i))};
                    u = String.format(u, Arrays.copyOf(objArr, objArr.length));
                    esl.m11127i(u, "java.lang.String.format(format, *args)");
                    flexibleTextView.setText(u);
                }
                FlexibleTextView flexibleTextView2 = com_fossil_cli.ctN;
                u = arp.m4318u(getContext(), R.string.Stats_Activity_Label_Kilometers);
                if (u == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                u = u.toLowerCase();
                esl.m11127i(u, "(this as java.lang.String).toLowerCase()");
                CharSequence charSequence = u;
                String obj = com_fossil_cli.cuT.getText().toString();
                if (obj == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                obj = obj.toLowerCase();
                esl.m11127i(obj, "(this as java.lang.String).toLowerCase()");
                flexibleTextView2.setText(cnb.m7184e(TextUtils.equals(charSequence, (CharSequence) obj) ? cmo.ay(f4) : cmo.ax(f4), 1));
                com_fossil_cli.cuQ.setText(cnb.m7184e(f5, 0));
                com_fossil_cli.cuW.setText(NumberFormat.getNumberInstance(Locale.US).format(Integer.valueOf((int) ((f + f2) + f3))));
                com_fossil_cli.cuO.f(f, gn.m10634e(getContext(), R.color.hexFF9F84));
                com_fossil_cli.cuO.f(f2, gn.m10634e(getContext(), R.color.fossilOrange));
                com_fossil_cli.cuO.f(f3, gn.m10634e(getContext(), R.color.hexCD2D00));
                com_fossil_cli.cuO.XT();
            }
        }
    }

    public void da(boolean z) {
        MFLogger.m12670d(cZs.getTAG(), "showMissingInfo");
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo != null) {
            cli com_fossil_cli = (cli) com_fossil_dqo.get();
            if (com_fossil_cli != null) {
                LinearLayout linearLayout = com_fossil_cli.cuP;
                if (linearLayout != null) {
                    linearLayout.setVisibility(z ? 0 : 8);
                }
            }
        }
    }

    public void mo2550a(Unit unit, float f) {
        esl.m11128j(unit, Constants.PROFILE_KEY_UNIT);
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo != null) {
            cli com_fossil_cli = (cli) com_fossil_dqo.get();
            if (com_fossil_cli != null) {
                FlexibleTextView flexibleTextView = com_fossil_cli.cuT;
                if (flexibleTextView != null) {
                    flexibleTextView.setText(arp.m4318u(getContext(), esl.m11125C(unit, Unit.METRIC) ? R.string.Stats_Activity_Label_Kilometers : R.string.Stats_Activity_Label_Miles));
                }
                com_fossil_cli.ctN.setText(cnb.m7184e(esl.m11125C(unit, Unit.METRIC) ? cmo.ay(f) : cmo.ax(f), 1));
            }
        }
    }

    public void mo1746a(String str, int i, Intent intent) {
        esl.m11128j(str, "tag");
        switch (str.hashCode()) {
            case -1391436191:
                if (str.equals("SYNC_FAILED")) {
                    if (i == R.id.fb_help && isActive()) {
                        dqw.bS(getContext());
                    }
                    if (i == R.id.fb_tryagain) {
                        MFLogger.m12670d(cZs.getTAG(), "onDialogFragmentResult, try again, call pull-sync");
                        PortfolioApp.ZQ().m12698e(false, 12);
                        return;
                    }
                    return;
                }
                break;
        }
        ew activity = getActivity();
        if (activity == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.portfolio.platform.ui.BaseActivity");
        }
        ((ctj) activity).mo1746a(str, i, intent);
    }

    private final void iR(String str) {
        m7519n("tooltip_dismiss", "Subject", str);
    }

    static {
        String simpleName = dlk.class.getSimpleName();
        if (simpleName == null) {
            esl.aGW();
        }
        TAG = simpleName;
    }
}
