package com.fossil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.fossil.dmo.C2923a;
import com.fossil.dmo.C2967b;
import com.fossil.wearables.fossil.R;
import com.fossil.wearables.fsl.dial.ConfigItem;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.view.FlexibleTextView;
import com.portfolio.platform.view.recyclerview.RecyclerViewCalendar;
import com.portfolio.platform.view.recyclerview.RecyclerViewCalendar.a;
import com.portfolio.platform.view.recyclerview.RecyclerViewCalendar.b;
import com.portfolio.platform.view.recyclerview.RecyclerViewCalendar.c;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public final class dmp extends ctl implements C2967b {
    private static final String TAG;
    public static final C2968a dak = new C2968a();
    private dqo<clo> cEY;
    private C2923a daj;

    public static final class C2968a {
        private C2968a() {
        }

        public final String getTAG() {
            return dmp.TAG;
        }

        public final dmp asi() {
            return new dmp();
        }
    }

    static final class C2969b implements OnClickListener {
        final /* synthetic */ dmp dal;

        C2969b(dmp com_fossil_dmp) {
            this.dal = com_fossil_dmp;
        }

        public final void onClick(View view) {
            this.dal.dismiss();
        }
    }

    static final class C2970c implements a {
        final /* synthetic */ dmp dal;

        C2970c(dmp com_fossil_dmp) {
            this.dal = com_fossil_dmp;
        }

        public final void m9098a(int i, Calendar calendar) {
            this.dal.m7513n("stats_date_select", "Action", ConfigItem.KEY_DATE);
            dmp.m9100a(this.dal).mo2544b(i, calendar.getTime());
            this.dal.dismiss();
        }
    }

    static final class C2971d implements b {
        final /* synthetic */ dmp dal;

        C2971d(dmp com_fossil_dmp) {
            this.dal = com_fossil_dmp;
        }

        public final void m9099h(Calendar calendar) {
            dmp.m9100a(this.dal).mo2548t(calendar.getTime());
        }
    }

    public static final class C2972e implements c {
        final /* synthetic */ dmp dal;

        C2972e(dmp com_fossil_dmp) {
            this.dal = com_fossil_dmp;
        }

        public void ja() {
            this.dal.m7513n("stats_date_select", "Action", "Next_Month");
        }

        public void arW() {
            this.dal.m7513n("stats_date_select", "Action", "Previous_Month");
        }

        public void arX() {
            this.dal.m7513n("stats_date_select", "Action", "Today");
        }
    }

    public void ao(java.util.List<? extends com.fossil.wearables.fsl.sleep.MFSleepDay> r1) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.fossil.dmp.ao(java.util.List):void
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
        r0 = "data";
        com.fossil.esl.m11128j(r7, r0);
        r3 = new java.util.TreeMap;
        r3.<init>();
        r7 = (java.lang.Iterable) r7;
        r0 = new java.util.ArrayList;
        r0.<init>();
        r0 = (java.util.Collection) r0;
        r4 = r7.iterator();
    L_0x0017:
        r1 = r4.hasNext();
        if (r1 == 0) goto L_0x0033;
    L_0x001d:
        r2 = r4.next();
        r1 = r2;
        r1 = (com.fossil.wearables.fsl.sleep.MFSleepDay) r1;
        r1 = r1.getGoalMinutes();
        if (r1 <= 0) goto L_0x0031;
    L_0x002a:
        r1 = 1;
    L_0x002b:
        if (r1 == 0) goto L_0x0017;
    L_0x002d:
        r0.add(r2);
        goto L_0x0017;
    L_0x0031:
        r1 = 0;
        goto L_0x002b;
    L_0x0033:
        r0 = (java.util.List) r0;
        r0 = (java.lang.Iterable) r0;
        r1 = r0.iterator();
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x0071;
    L_0x0042:
        r0 = r1.next();
        r0 = (com.fossil.wearables.fsl.sleep.MFSleepDay) r0;
        r2 = r0.getDate();
        r2 = com.fossil.cmq.fY(r2);
        r2 = com.fossil.cmq.getStartOfDay(r2);
        r4 = r2.getTime();
        r2 = java.lang.Long.valueOf(r4);
        r4 = r0.getSleepMinutes();
        r4 = (float) r4;
        r0 = r0.getGoalMinutes();
        r0 = (float) r0;
        r0 = r4 / r0;
        r0 = java.lang.Float.valueOf(r0);
        r3.put(r2, r0);
        goto L_0x003c;
        r0 = r6.cEY;
        if (r0 == 0) goto L_0x0088;
        r0 = r0.get();
        r0 = (com.fossil.clo) r0;
        if (r0 == 0) goto L_0x0088;
        r1 = r0.cuX;
        if (r1 == 0) goto L_0x0088;
        r0 = r3;
        r0 = (java.util.Map) r0;
        r1.setData(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.dmp.ao(java.util.List):void");
    }

    public static final /* synthetic */ C2923a m9100a(dmp com_fossil_dmp) {
        C2923a c2923a = com_fossil_dmp.daj;
        if (c2923a == null) {
            esl.mF("mPresenter");
        }
        return c2923a;
    }

    public /* synthetic */ void cK(Object obj) {
        m9102a((C2923a) obj);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        clo com_fossil_clo = (clo) C3311e.m10386a(layoutInflater, R.layout.stats_sleep_month_fragment, viewGroup, false, this.cEN);
        com_fossil_clo.cuX.setEndDate(Calendar.getInstance());
        com_fossil_clo.cuS.setOnClickListener(new C2969b(this));
        com_fossil_clo.cuX.setOnCalendarItemClickListener(new C2970c(this));
        com_fossil_clo.cuX.setNavigatingListener(new C2972e(this));
        com_fossil_clo.cuX.setOnCalendarMonthChanged(new C2971d(this));
        this.cEY = new dqo(this, com_fossil_clo);
        return com_fossil_clo.dz();
    }

    public void onResume() {
        super.onResume();
        C2923a c2923a = this.daj;
        if (c2923a == null) {
            esl.mF("mPresenter");
        }
        c2923a.arK();
    }

    public void m9102a(C2923a c2923a) {
        esl.m11128j(c2923a, "presenter");
        MFLogger.m12670d(dak.getTAG(), "setPresenter: " + c2923a.getClass());
        this.daj = c2923a;
    }

    public void mo2570v(Date date) {
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo != null) {
            clo com_fossil_clo = (clo) com_fossil_dqo.get();
            if (com_fossil_clo != null) {
                Calendar instance = Calendar.getInstance();
                Calendar instance2 = Calendar.getInstance();
                instance.setTime(cmq.getStartOfDay(date));
                instance2.setTime(cmq.getEndOfDay(instance2.getTime()));
                com_fossil_clo.cuX.setStartDate(instance);
                com_fossil_clo.cuX.setEndDate(instance2);
            }
        }
    }

    public void mo2571w(Date date) {
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo != null) {
            clo com_fossil_clo = (clo) com_fossil_dqo.get();
            if (com_fossil_clo != null) {
                CharSequence u;
                FlexibleTextView flexibleTextView = com_fossil_clo.cuS;
                Boolean c = cmq.m7114c(date);
                esl.m11127i(c, "DateHelper.isToday(date)");
                if (c.booleanValue()) {
                    u = arp.m4318u(getContext(), R.string.Stats_Sleep_Label_Today);
                } else {
                    u = new SimpleDateFormat("dd, MMM EEE", Locale.getDefault()).format(date);
                }
                flexibleTextView.setText(u);
                Calendar instance = Calendar.getInstance();
                instance.setTime(date);
                com_fossil_clo.cuX.setSelectDate(instance);
            }
        }
    }

    public void ll(int i) {
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo != null) {
            clo com_fossil_clo = (clo) com_fossil_dqo.get();
            if (com_fossil_clo != null) {
                RecyclerViewCalendar recyclerViewCalendar = com_fossil_clo.cuX;
                if (recyclerViewCalendar != null) {
                    recyclerViewCalendar.setSelectPosition(i);
                }
            }
        }
    }

    static {
        String simpleName = dmp.class.getSimpleName();
        if (simpleName == null) {
            esl.aGW();
        }
        TAG = simpleName;
    }
}
