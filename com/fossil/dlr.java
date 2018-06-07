package com.fossil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.fossil.dlq.C2920a;
import com.fossil.dlq.C2939b;
import com.fossil.wearables.fossil.R;
import com.fossil.wearables.fsl.dial.ConfigItem;
import com.fossil.wearables.fsl.fitness.SampleDay;
import com.fossil.wearables.fsl.goaltracking.GoalPhase;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.view.FlexibleTextView;
import com.portfolio.platform.view.recyclerview.RecyclerViewCalendar;
import com.portfolio.platform.view.recyclerview.RecyclerViewCalendar.a;
import com.portfolio.platform.view.recyclerview.RecyclerViewCalendar.b;
import com.portfolio.platform.view.recyclerview.RecyclerViewCalendar.c;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;

public final class dlr extends ctl implements C2939b {
    private static final String TAG;
    public static final C2940a cZE = new C2940a();
    private dqo<clj> cEY;
    private C2920a cZD;

    public static final class C2940a {
        private C2940a() {
        }

        public final String getTAG() {
            return dlr.TAG;
        }

        public final dlr arV() {
            return new dlr();
        }
    }

    static final class C2941b implements OnClickListener {
        final /* synthetic */ dlr cZF;

        C2941b(dlr com_fossil_dlr) {
            this.cZF = com_fossil_dlr;
        }

        public final void onClick(View view) {
            this.cZF.dismiss();
        }
    }

    static final class C2942c implements a {
        final /* synthetic */ dlr cZF;

        C2942c(dlr com_fossil_dlr) {
            this.cZF = com_fossil_dlr;
        }

        public final void m9019a(int i, Calendar calendar) {
            this.cZF.m7513n("stats_date_select", "Action", ConfigItem.KEY_DATE);
            dlr.m9021a(this.cZF).mo2525a(i, calendar.getTime());
            this.cZF.dismiss();
        }
    }

    static final class C2943d implements b {
        final /* synthetic */ dlr cZF;

        C2943d(dlr com_fossil_dlr) {
            this.cZF = com_fossil_dlr;
        }

        public final void m9020h(Calendar calendar) {
            dlr.m9021a(this.cZF).mo2546s(calendar.getTime());
        }
    }

    public static final class C2944e implements c {
        final /* synthetic */ dlr cZF;

        C2944e(dlr com_fossil_dlr) {
            this.cZF = com_fossil_dlr;
        }

        public void ja() {
            this.cZF.m7513n("stats_date_select", "Action", "Next_Month");
        }

        public void arW() {
            this.cZF.m7513n("stats_date_select", "Action", "Previous_Month");
        }

        public void arX() {
            this.cZF.m7513n("stats_date_select", "Action", "Today");
        }
    }

    public static final /* synthetic */ C2920a m9021a(dlr com_fossil_dlr) {
        C2920a c2920a = com_fossil_dlr.cZD;
        if (c2920a == null) {
            esl.mF("mPresenter");
        }
        return c2920a;
    }

    public /* synthetic */ void cK(Object obj) {
        m9023a((C2920a) obj);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        clj com_fossil_clj = (clj) C3311e.m10386a(layoutInflater, R.layout.stats_activity_month_fragment, viewGroup, false, this.cEN);
        com_fossil_clj.cuX.setEndDate(Calendar.getInstance());
        com_fossil_clj.cuS.setOnClickListener(new C2941b(this));
        com_fossil_clj.cuX.setOnCalendarItemClickListener(new C2942c(this));
        com_fossil_clj.cuX.setNavigatingListener(new C2944e(this));
        com_fossil_clj.cuX.setOnCalendarMonthChanged(new C2943d(this));
        this.cEY = new dqo(this, com_fossil_clj);
        return com_fossil_clj.dz();
    }

    public void onResume() {
        super.onResume();
        C2920a c2920a = this.cZD;
        if (c2920a == null) {
            esl.mF("mPresenter");
        }
        c2920a.arG();
    }

    public void m9023a(C2920a c2920a) {
        esl.m11128j(c2920a, "presenter");
        MFLogger.m12670d(cZE.getTAG(), "setPresenter: " + c2920a.getClass());
        this.cZD = c2920a;
    }

    public void mo2559v(Date date) {
        esl.m11128j(date, GoalPhase.COLUMN_START_DATE);
        dqo com_fossil_dqo = this.cEY;
        clj com_fossil_clj = com_fossil_dqo != null ? (clj) com_fossil_dqo.get() : null;
        if (com_fossil_clj != null) {
            Calendar instance = Calendar.getInstance();
            Calendar instance2 = Calendar.getInstance();
            instance.setTime(cmq.getStartOfDay(date));
            instance2.setTime(cmq.getEndOfDay(instance2.getTime()));
            com_fossil_clj.cuX.setStartDate(instance);
            com_fossil_clj.cuX.setEndDate(instance2);
        }
    }

    public void mo2560w(Date date) {
        esl.m11128j(date, "date");
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo != null) {
            clj com_fossil_clj = (clj) com_fossil_dqo.get();
            if (com_fossil_clj != null) {
                CharSequence u;
                FlexibleTextView flexibleTextView = com_fossil_clj.cuS;
                Boolean c = cmq.m7114c(date);
                esl.m11127i(c, "DateHelper.isToday(date)");
                if (c.booleanValue()) {
                    u = arp.m4318u(getContext(), R.string.Stats_Activity_Start_Label_Today);
                } else {
                    u = new SimpleDateFormat("dd, MMM EEE", Locale.getDefault()).format(date);
                }
                flexibleTextView.setText(u);
                Calendar instance = Calendar.getInstance();
                instance.setTime(date);
                com_fossil_clj.cuX.setSelectDate(instance);
            }
        }
    }

    public void ll(int i) {
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo != null) {
            clj com_fossil_clj = (clj) com_fossil_dqo.get();
            if (com_fossil_clj != null) {
                RecyclerViewCalendar recyclerViewCalendar = com_fossil_clj.cuX;
                if (recyclerViewCalendar != null) {
                    recyclerViewCalendar.setSelectPosition(i);
                }
            }
        }
    }

    public void ao(List<SampleDay> list) {
        esl.m11128j(list, "data");
        TreeMap treeMap = new TreeMap();
        Calendar instance = Calendar.getInstance();
        for (SampleDay sampleDay : list) {
            if (sampleDay.getStepGoal() > 0) {
                instance.set(1, sampleDay.getYear());
                instance.set(2, sampleDay.getMonth() - 1);
                instance.set(5, sampleDay.getDay());
                treeMap.put(Long.valueOf(cmq.m7110b(instance).getTimeInMillis()), Float.valueOf(((float) sampleDay.getSteps()) / ((float) sampleDay.getStepGoal())));
            }
        }
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo != null) {
            clj com_fossil_clj = (clj) com_fossil_dqo.get();
            if (com_fossil_clj != null) {
                RecyclerViewCalendar recyclerViewCalendar = com_fossil_clj.cuX;
                if (recyclerViewCalendar != null) {
                    recyclerViewCalendar.setData(treeMap);
                }
            }
        }
    }

    static {
        String simpleName = dlr.class.getSimpleName();
        if (simpleName == null) {
            esl.aGW();
        }
        TAG = simpleName;
    }
}
