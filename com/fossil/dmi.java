package com.fossil;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.fossil.dmh.C2922a;
import com.fossil.dmh.C2958b;
import com.fossil.drk.C2095b;
import com.fossil.wearables.fossil.R;
import com.fossil.wearables.fsl.sleep.MFSleepSession;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.view.FlexibleTextView;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.TypeCastException;
import org.json.JSONObject;

public final class dmi extends ctm implements OnAttachStateChangeListener, C2958b, C2095b {
    private static final String TAG;
    public static final C2959a daa = new C2959a();
    private dqo<cln> cEY;
    private C2922a cZZ;

    public static final class C2959a {
        private C2959a() {
        }

        public final String getTAG() {
            return dmi.TAG;
        }

        public final dmi asf() {
            return new dmi();
        }
    }

    static final class C2960b implements OnClickListener {
        final /* synthetic */ dmi dab;

        C2960b(dmi com_fossil_dmi) {
            this.dab = com_fossil_dmi;
        }

        public final void onClick(View view) {
            this.dab.hB("stats_sleep_date_selector");
            dmi.m9071a(this.dab).arA();
        }
    }

    static final class C2961c implements OnClickListener {
        final /* synthetic */ dmi dab;

        C2961c(dmi com_fossil_dmi) {
            this.dab = com_fossil_dmi;
        }

        public final void onClick(View view) {
            this.dab.hB("stats_info");
            dmi.m9071a(this.dab).arw();
        }
    }

    static final class C2962d implements OnClickListener {
        final /* synthetic */ dmi dab;

        C2962d(dmi com_fossil_dmi) {
            this.dab = com_fossil_dmi;
        }

        public final void onClick(View view) {
            this.dab.hB("stats_sleep_graph");
            dmi.m9071a(this.dab).ary();
        }
    }

    public void aJ(long r1) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.fossil.dmi.aJ(long):void
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
        r0 = daa;
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
        r0 = (com.fossil.cln) r0;
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
        r1 = 2131296822; // 0x7f090236 float:1.8211572E38 double:1.053000541E-314;
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
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.dmi.aJ(long):void");
    }

    public static final /* synthetic */ C2922a m9071a(dmi com_fossil_dmi) {
        C2922a c2922a = com_fossil_dmi.cZZ;
        if (c2922a == null) {
            esl.mF("mPresenter");
        }
        return c2922a;
    }

    public /* synthetic */ void cK(Object obj) {
        m9073a((C2922a) obj);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        cln com_fossil_cln = (cln) C3311e.m10386a(layoutInflater, R.layout.stats_sleep_day_fragment, viewGroup, false, new ckn(this));
        com_fossil_cln.cuS.setOnClickListener(new C2960b(this));
        com_fossil_cln.cuN.setOnClickListener(new C2961c(this));
        com_fossil_cln.cuO.setOnRingClickListener(new C2962d(this));
        com_fossil_cln.dz().addOnAttachStateChangeListener(this);
        this.cEY = new dqo(this, com_fossil_cln);
        return com_fossil_cln.dz();
    }

    public void onResume() {
        super.onResume();
        MFLogger.m12670d(daa.getTAG(), "onResume");
        View view = getView();
        if (view == null) {
            esl.aGW();
        }
        if (view.isAttachedToWindow()) {
            C2922a c2922a = this.cZZ;
            if (c2922a == null) {
                esl.mF("mPresenter");
            }
            c2922a.arI();
        }
    }

    public void onPause() {
        super.onPause();
        MFLogger.m12670d(daa.getTAG(), "onPause");
        View view = getView();
        if (view == null) {
            esl.aGW();
        }
        if (view.isAttachedToWindow()) {
            C2922a c2922a = this.cZZ;
            if (c2922a == null) {
                esl.mF("mPresenter");
            }
            c2922a.arJ();
        }
    }

    public void onViewAttachedToWindow(View view) {
        esl.m11128j(view, "v");
        MFLogger.m12670d(daa.getTAG(), "onViewAttachedToWindow");
        C2922a c2922a = this.cZZ;
        if (c2922a == null) {
            esl.mF("mPresenter");
        }
        c2922a.arI();
    }

    public void onViewDetachedFromWindow(View view) {
        esl.m11128j(view, "v");
        MFLogger.m12670d(daa.getTAG(), "onViewDetachedFromWindow");
        C2922a c2922a = this.cZZ;
        if (c2922a == null) {
            esl.mF("mPresenter");
        }
        c2922a.arJ();
    }

    public void m9073a(C2922a c2922a) {
        esl.m11128j(c2922a, "presenter");
        MFLogger.m12670d(daa.getTAG(), "setPresenter: " + c2922a.getClass());
        this.cZZ = c2922a;
    }

    public void mo2567u(Date date) {
        esl.m11128j(date, "date");
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo != null) {
            cln com_fossil_cln = (cln) com_fossil_dqo.get();
            if (com_fossil_cln != null) {
                FlexibleTextView flexibleTextView = com_fossil_cln.cuS;
                if (flexibleTextView != null) {
                    CharSequence u;
                    Boolean c = cmq.m7114c(date);
                    esl.m11127i(c, "DateHelper.isToday(date)");
                    if (c.booleanValue()) {
                        u = arp.m4318u(getContext(), R.string.Stats_Sleep_Label_Today);
                    } else {
                        u = new SimpleDateFormat("dd, MMM EEE", Locale.getDefault()).format(date);
                    }
                    flexibleTextView.setText(u);
                }
            }
        }
    }

    public void mo2566h(List<MFSleepSession> list, int i) {
        float f = 0.0f;
        MFLogger.m12670d(daa.getTAG(), "showSleepSessions: data = " + (list != null ? Integer.valueOf(list.size()) : null) + ", sleepGoal = " + i);
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo != null) {
            cln com_fossil_cln = (cln) com_fossil_dqo.get();
            if (com_fossil_cln != null) {
                com_fossil_cln.cuO.clearData();
                if (i > 0) {
                    com_fossil_cln.cuO.setGoal(i);
                    FlexibleTextView flexibleTextView = com_fossil_cln.cuV;
                    esm com_fossil_esm = esm.dSO;
                    String u = arp.m4318u(getContext(), R.string.General_Singular_Plurals_Label_of_hours);
                    esl.m11127i(u, "LanguageHelper.getString…r_Plurals_Label_of_hours)");
                    Object[] objArr = new Object[]{Float.valueOf(((float) i) / ((float) 60))};
                    u = String.format(u, Arrays.copyOf(objArr, objArr.length));
                    esl.m11127i(u, "java.lang.String.format(format, *args)");
                    flexibleTextView.setText(u);
                }
                if (list == null) {
                    esl.aGW();
                }
                float f2 = 0.0f;
                float f3 = 0.0f;
                for (MFSleepSession realSleepStateDistInMinute : list) {
                    JSONObject jSONObject = new JSONObject(realSleepStateDistInMinute.getRealSleepStateDistInMinute());
                    f3 += (float) jSONObject.getInt("awake");
                    f2 = ((float) jSONObject.getInt("deep")) + f2;
                    f = ((float) jSONObject.getInt("light")) + f;
                }
                com_fossil_cln.ctN.setText(cmq.jx((int) f3));
                com_fossil_cln.cuQ.setText(cmq.jx((int) (f + f2)));
                com_fossil_cln.cuW.setText(cmq.jx((int) ((f3 + f) + f2)));
                com_fossil_cln.cuO.f(f, gn.m10634e(getContext(), R.color.hexFF9F84));
                com_fossil_cln.cuO.f(f2, gn.m10634e(getContext(), R.color.fossilOrange));
                com_fossil_cln.cuO.f(f3, gn.m10634e(getContext(), R.color.hexCD2D00));
                com_fossil_cln.cuO.XT();
                FlexibleTextView flexibleTextView2 = com_fossil_cln.cuV;
                esm com_fossil_esm2 = esm.dSO;
                String u2 = arp.m4318u(getContext(), R.string.General_Singular_Plurals_Label_of_hours);
                esl.m11127i(u2, "LanguageHelper.getString…r_Plurals_Label_of_hours)");
                Object[] objArr2 = new Object[]{Float.valueOf(((float) i) / ((float) 60))};
                u2 = String.format(u2, Arrays.copyOf(objArr2, objArr2.length));
                esl.m11127i(u2, "java.lang.String.format(format, *args)");
                flexibleTextView2.setText(u2);
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
                        MFLogger.m12670d(daa.getTAG(), "onDialogFragmentResult, try again, call pull-sync");
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

    static {
        String simpleName = dmi.class.getSimpleName();
        if (simpleName == null) {
            esl.aGW();
        }
        TAG = simpleName;
    }
}
