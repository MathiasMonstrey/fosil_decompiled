package com.fossil;

import android.os.Bundle;
import android.util.LongSparseArray;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.fossil.dna.C2980a;
import com.fossil.dna.C2981b;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.view.FlexibleTextView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public final class dnb extends ctm implements OnAttachStateChangeListener, C2981b {
    private static final String TAG = dnb.class.getSimpleName();
    public static final C2982a daz = new C2982a();
    private dqo<clq> cEY;
    private final int cZR = 7;
    private C2980a dax;

    public static final class C2982a {
        private C2982a() {
        }

        private final String getTAG() {
            return dnb.TAG;
        }

        public final dnb aso() {
            return new dnb();
        }
    }

    static final class C2983b implements OnClickListener {
        final /* synthetic */ dnb daA;

        C2983b(dnb com_fossil_dnb) {
            this.daA = com_fossil_dnb;
        }

        public final void onClick(View view) {
            this.daA.hB("stats_this_week_tapped");
        }
    }

    public /* synthetic */ void cK(Object obj) {
        m9135a((C2980a) obj);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        clq com_fossil_clq = (clq) C3311e.m10386a(layoutInflater, R.layout.stats_sleep_week_fragment, viewGroup, false, this.cEN);
        com_fossil_clq.dz().addOnAttachStateChangeListener(this);
        com_fossil_clq.dz().setOnClickListener(new C2983b(this));
        this.cEY = new dqo(this, com_fossil_clq);
        return com_fossil_clq.dz();
    }

    public void onResume() {
        super.onResume();
        View view = getView();
        if (view == null) {
            esl.aGW();
        }
        if (view.isAttachedToWindow()) {
            C2980a c2980a = this.dax;
            if (c2980a == null) {
                esl.mF("mPresenter");
            }
            c2980a.asn();
        }
    }

    public void onViewAttachedToWindow(View view) {
        esl.m11128j(view, "v");
        MFLogger.m12670d(daz.getTAG(), "onViewAttachedToWindow");
        C2980a c2980a = this.dax;
        if (c2980a == null) {
            esl.mF("mPresenter");
        }
        c2980a.asn();
    }

    public void onViewDetachedFromWindow(View view) {
        esl.m11128j(view, "v");
        MFLogger.m12670d(daz.getTAG(), "onViewDetachedFromWindow");
    }

    public void m9135a(C2980a c2980a) {
        esl.m11128j(c2980a, "presenter");
        this.dax = c2980a;
    }

    public void mo2574y(Date date) {
        esl.m11128j(date, "currentWeek");
        MFLogger.m12670d(daz.getTAG(), "showCurrentWeek: currentWeek = " + date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd, MMM EEE", Locale.getDefault());
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo != null) {
            clq com_fossil_clq = (clq) com_fossil_dqo.get();
            if (com_fossil_clq != null) {
                FlexibleTextView flexibleTextView = com_fossil_clq.cpC;
                if (flexibleTextView != null) {
                    CharSequence u;
                    if (cmq.m7111b(new Date(), date)) {
                        u = arp.m4318u(getContext(), R.string.Stats_Activity_Accuracy_Text_This_Week);
                    } else {
                        u = simpleDateFormat.format(cmq.m7134l(date).getTime()) + " - " + simpleDateFormat.format(cmq.m7135m(date).getTime());
                    }
                    flexibleTextView.setText(u);
                }
            }
        }
    }

    public void mo2573b(Date date, LongSparseArray<List<Float>> longSparseArray, int i) {
        esl.m11128j(date, "selectDate");
        esl.m11128j(longSparseArray, "data");
        MFLogger.m12670d(daz.getTAG(), "showSleepSessions() - selectDate = " + date + ", data = " + longSparseArray.size() + ", lastSleepGoal = " + i);
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo != null) {
            clq com_fossil_clq = (clq) com_fossil_dqo.get();
            if (com_fossil_clq != null) {
                int e = gn.m10634e(getContext(), R.color.hexFF9F84);
                int e2 = gn.m10634e(getContext(), R.color.fossilOrange);
                int e3 = gn.m10634e(getContext(), R.color.hexCD2D00);
                int e4 = gn.m10634e(getContext(), R.color.hex4CFF9F84);
                int e5 = gn.m10634e(getContext(), R.color.hex4CFF4611);
                int e6 = gn.m10634e(getContext(), R.color.hex4CCD2D00);
                Calendar instance = Calendar.getInstance();
                float f = (float) i;
                ArrayList arrayList = new ArrayList();
                com_fossil_clq.cvh.clearData();
                int i2 = this.cZR;
                if (1 <= i2) {
                    int i3 = 1;
                    while (true) {
                        String u;
                        switch (i3) {
                            case 2:
                                u = arp.m4318u(getContext(), R.string.Stats_Activity_Accuracy_Label_M);
                                break;
                            case 3:
                                u = arp.m4318u(getContext(), R.string.Stats_Activity_Accuracy_Label_T);
                                break;
                            case 4:
                                u = arp.m4318u(getContext(), R.string.Stats_Activity_Accuracy_Label_W);
                                break;
                            case 5:
                                u = arp.m4318u(getContext(), R.string.Stats_Activity_Accuracy_Label_T_1);
                                break;
                            case 6:
                                u = arp.m4318u(getContext(), R.string.Stats_Activity_Accuracy_Label_F);
                                break;
                            case 7:
                                u = arp.m4318u(getContext(), R.string.Stats_Activity_Accuracy_Label_S_1);
                                break;
                            default:
                                u = arp.m4318u(getContext(), R.string.Stats_Activity_Accuracy_Label_S);
                                break;
                        }
                        arrayList.clear();
                        int i4 = 0;
                        int size = longSparseArray.size();
                        while (i4 < size) {
                            instance.setTimeInMillis(longSparseArray.keyAt(i4));
                            if (instance.get(7) == i3) {
                                int i5;
                                boolean a = cmq.m7108a(date, instance.getTime());
                                List list = (List) longSparseArray.valueAt(i4);
                                float floatValue = ((Number) list.get(0)).floatValue();
                                Object obj = list.get(3);
                                if (a) {
                                    i5 = e3;
                                } else {
                                    i5 = e6;
                                }
                                arrayList.add(new Pair(obj, Integer.valueOf(i5)));
                                obj = list.get(2);
                                if (a) {
                                    i5 = e2;
                                } else {
                                    i5 = e5;
                                }
                                arrayList.add(new Pair(obj, Integer.valueOf(i5)));
                                Object obj2 = list.get(1);
                                if (a) {
                                    i4 = e;
                                } else {
                                    i4 = e4;
                                }
                                arrayList.add(new Pair(obj2, Integer.valueOf(i4)));
                                f = floatValue;
                                com_fossil_clq.cvh.a(u, f, arrayList);
                                if (i3 != i2) {
                                    i3++;
                                }
                            } else {
                                i4++;
                            }
                        }
                        com_fossil_clq.cvh.a(u, f, arrayList);
                        if (i3 != i2) {
                            i3++;
                        }
                    }
                }
                com_fossil_clq.cvh.XT();
            }
        }
    }
}
