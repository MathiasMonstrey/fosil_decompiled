package com.fossil;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.appevents.AppEventsConstants;
import com.fossil.cuv.C2357a;
import com.fossil.cuv.C2358b;
import com.fossil.os.a;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.buddychallenge.BCChallenge.TYPE;
import com.portfolio.platform.data.model.buddychallenge.BCNotifications;
import com.portfolio.platform.view.FlexibleTextView;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.Ref.IntRef;

public final class cuw extends ctm implements C2358b {
    private static final String cGE = cGE;
    private static final String cGF = cGF;
    public static final C2359a cGG = new C2359a();
    private dqo<cky> cEY;
    private C2357a cGB;
    private boolean cGC;
    private int cGD;

    public static final class C2359a {
        private C2359a() {
        }

        public final String ahB() {
            return cuw.cGE;
        }

        public final String ahC() {
            return cuw.cGF;
        }

        public final cuw m7611w(int i, boolean z) {
            cuw com_fossil_cuw = new cuw();
            Bundle bundle = new Bundle();
            bundle.putInt(ahB(), i);
            bundle.putBoolean(ahC(), z);
            com_fossil_cuw.setArguments(bundle);
            return com_fossil_cuw;
        }
    }

    static final class C2360b implements OnClickListener {
        final /* synthetic */ cuw cGH;
        final /* synthetic */ IntRef cGI;

        C2360b(cuw com_fossil_cuw, IntRef intRef) {
            this.cGH = com_fossil_cuw;
            this.cGI = intRef;
        }

        public final void onClick(View view) {
            cuw.m7612a(this.cGH).jW(this.cGI.element);
            cmj.bs(this.cGH.getContext()).m7086l("stats_bc_opponent", "Step", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        }
    }

    static final class C2361c implements OnClickListener {
        final /* synthetic */ cuw cGH;

        C2361c(cuw com_fossil_cuw) {
            this.cGH = com_fossil_cuw;
        }

        public final void onClick(View view) {
            ew activity = this.cGH.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    static final class C2362d implements OnClickListener {
        final /* synthetic */ cuw cGH;
        final /* synthetic */ os cGJ;

        C2362d(cuw com_fossil_cuw, os osVar) {
            this.cGH = com_fossil_cuw;
            this.cGJ = osVar;
        }

        public final void onClick(View view) {
            cmj.bs(this.cGH.getContext()).m7086l("stats_bc_opponent", "Step", "2");
            this.cGJ.dismiss();
            this.cGH.getActivity().finish();
        }
    }

    public static final /* synthetic */ C2357a m7612a(cuw com_fossil_cuw) {
        C2357a c2357a = com_fossil_cuw.cGB;
        if (c2357a == null) {
            esl.mF("mPresenter");
        }
        return c2357a;
    }

    public /* synthetic */ void cK(Object obj) {
        m7613a((C2357a) obj);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cGD = getArguments().getInt(cGG.ahB());
        this.cGC = getArguments().getBoolean(cGG.ahC());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        cky com_fossil_cky = (cky) C3311e.m10386a(layoutInflater, R.layout.fragment_bc_find_opponent, viewGroup, false, this.cEN);
        IntRef intRef = new IntRef();
        intRef.element = 0;
        int i = this.cGD;
        FlexibleTextView flexibleTextView;
        esm com_fossil_esm;
        String u;
        Object[] objArr;
        if (i == TYPE.TYPE_CHALLENGE_ONE.getValue()) {
            flexibleTextView = com_fossil_cky.crr;
            com_fossil_esm = esm.dSO;
            u = arp.m4318u(getContext(), R.string.Stats_Activity_BC_Text_First_to__Steps);
            esl.m11127i(u, "LanguageHelper.getString…_BC_Text_First_to__Steps)");
            objArr = new Object[]{NumberFormat.getNumberInstance(Locale.US).format(Integer.valueOf(3500))};
            u = String.format(u, Arrays.copyOf(objArr, objArr.length));
            esl.m11127i(u, "java.lang.String.format(format, *args)");
            flexibleTextView.setText(u);
            intRef.element = TYPE.TYPE_CHALLENGE_ONE.getValue();
            com_fossil_cky.crq.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_First_To_Subtitle_24_Hours_Total_Domination));
            com_fossil_cky.crp.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_First_To_Text_You_have_one_day_to));
            flexibleTextView = com_fossil_cky.crk;
            com_fossil_esm = esm.dSO;
            u = arp.m4318u(getContext(), R.string.Stats_BC_Challenge_First_To_List_First_To);
            esl.m11127i(u, "LanguageHelper.getString…e_First_To_List_First_To)");
            objArr = new Object[]{NumberFormat.getNumberInstance(Locale.US).format(Integer.valueOf(3500))};
            u = String.format(u, Arrays.copyOf(objArr, objArr.length));
            esl.m11127i(u, "java.lang.String.format(format, *args)");
            flexibleTextView.setText(u);
            com_fossil_cky.crl.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_First_To_List_Start_Time_1200_AM_the));
            com_fossil_cky.crm.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_First_To_List_End_Time_1159_PM_the));
            com_fossil_cky.crn.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_First_To_List_Results_will_be_posted_at));
            com_fossil_cky.cru.setVisibility(8);
        } else if (i == TYPE.TYPE_CHALLENGE_THREE.getValue()) {
            flexibleTextView = com_fossil_cky.crr;
            com_fossil_esm = esm.dSO;
            u = arp.m4318u(getContext(), R.string.Stats_Activity_BC_Text_Best_of);
            esl.m11127i(u, "LanguageHelper.getString…Activity_BC_Text_Best_of)");
            objArr = new Object[]{Integer.valueOf(3)};
            u = String.format(u, Arrays.copyOf(objArr, objArr.length));
            esl.m11127i(u, "java.lang.String.format(format, *args)");
            flexibleTextView.setText(u);
            intRef.element = TYPE.TYPE_CHALLENGE_THREE.getValue();
            com_fossil_cky.crq.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Three_Subtitle_The_Final_Countdown));
            com_fossil_cky.crp.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Three_Text_Show_your_opponent_you_can));
            com_fossil_cky.crk.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Three_List_First_To));
            com_fossil_cky.crl.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Three_List_Tie_Breaker_Opponent_who_takes));
            com_fossil_cky.crm.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Three_List_Start_Time_1200_AM_the));
            com_fossil_cky.crn.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Three_List_End_Time_1159_PM_the));
            com_fossil_cky.cro.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Three_List_Results_will_be_posted_at));
        } else if (i == TYPE.TYPE_CHALLENGE_FIVE.getValue()) {
            flexibleTextView = com_fossil_cky.crr;
            com_fossil_esm = esm.dSO;
            u = arp.m4318u(getContext(), R.string.Stats_Activity_BC_Text_Best_of);
            esl.m11127i(u, "LanguageHelper.getString…Activity_BC_Text_Best_of)");
            objArr = new Object[]{Integer.valueOf(5)};
            u = String.format(u, Arrays.copyOf(objArr, objArr.length));
            esl.m11127i(u, "java.lang.String.format(format, *args)");
            flexibleTextView.setText(u);
            intRef.element = TYPE.TYPE_CHALLENGE_FIVE.getValue();
            com_fossil_cky.crq.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Five_Subtitle_Game_Steps_Match));
            com_fossil_cky.crp.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Five_Text_Step_to_and_show_your));
            com_fossil_cky.crk.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Five_List_First_To));
            com_fossil_cky.crl.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Five_List_Tie_Breaker_Opponent_who_takes));
            com_fossil_cky.crm.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Five_List_Start_Time_1200_AM_the));
            com_fossil_cky.crn.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Five_List_End_Time_1159_PM_the));
            com_fossil_cky.cro.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Five_List_Results_will_be_posted_at));
        } else if (i == TYPE.TYPE_CHALLENGE_ONE_DEBUG.getValue()) {
            flexibleTextView = com_fossil_cky.crr;
            com_fossil_esm = esm.dSO;
            objArr = new Object[]{NumberFormat.getNumberInstance(Locale.US).format(Integer.valueOf(3500))};
            u = String.format(arp.m4318u(getContext(), R.string.Stats_Activity_BC_Text_First_to__Steps) + " debug", Arrays.copyOf(objArr, objArr.length));
            esl.m11127i(u, "java.lang.String.format(format, *args)");
            flexibleTextView.setText(u);
            intRef.element = TYPE.TYPE_CHALLENGE_ONE_DEBUG.getValue();
            com_fossil_cky.crq.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_First_To_Subtitle_24_Hours_Total_Domination));
            com_fossil_cky.crp.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_First_To_Text_You_have_one_day_to));
            flexibleTextView = com_fossil_cky.crk;
            com_fossil_esm = esm.dSO;
            u = arp.m4318u(getContext(), R.string.Stats_BC_Challenge_First_To_List_First_To);
            esl.m11127i(u, "LanguageHelper.getString…e_First_To_List_First_To)");
            objArr = new Object[]{NumberFormat.getNumberInstance(Locale.US).format(Integer.valueOf(3500))};
            u = String.format(u, Arrays.copyOf(objArr, objArr.length));
            esl.m11127i(u, "java.lang.String.format(format, *args)");
            flexibleTextView.setText(u);
            com_fossil_cky.crl.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_First_To_List_Start_Time_1200_AM_the));
            com_fossil_cky.crm.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_First_To_List_End_Time_1159_PM_the));
            com_fossil_cky.crn.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_First_To_List_Results_will_be_posted_at));
            com_fossil_cky.cru.setVisibility(8);
        } else if (i == TYPE.TYPE_CHALLENGE_THREE_DEBUG.getValue()) {
            flexibleTextView = com_fossil_cky.crr;
            com_fossil_esm = esm.dSO;
            objArr = new Object[]{Integer.valueOf(3)};
            u = String.format(arp.m4318u(getContext(), R.string.Stats_Activity_BC_Text_Best_of) + " debug", Arrays.copyOf(objArr, objArr.length));
            esl.m11127i(u, "java.lang.String.format(format, *args)");
            flexibleTextView.setText(u);
            intRef.element = TYPE.TYPE_CHALLENGE_THREE_DEBUG.getValue();
            com_fossil_cky.crq.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Three_Subtitle_The_Final_Countdown));
            com_fossil_cky.crp.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Three_Text_Show_your_opponent_you_can));
            com_fossil_cky.crk.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Three_List_First_To));
            com_fossil_cky.crl.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Three_List_Tie_Breaker_Opponent_who_takes));
            com_fossil_cky.crm.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Three_List_Start_Time_1200_AM_the));
            com_fossil_cky.crn.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Three_List_End_Time_1159_PM_the));
            com_fossil_cky.cro.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Three_List_Results_will_be_posted_at));
        } else if (i == TYPE.TYPE_CHALLENGE_FIVE_DEBUG.getValue()) {
            flexibleTextView = com_fossil_cky.crr;
            com_fossil_esm = esm.dSO;
            objArr = new Object[]{Integer.valueOf(5)};
            u = String.format(arp.m4318u(getContext(), R.string.Stats_Activity_BC_Text_Best_of) + " debug", Arrays.copyOf(objArr, objArr.length));
            esl.m11127i(u, "java.lang.String.format(format, *args)");
            flexibleTextView.setText(u);
            intRef.element = TYPE.TYPE_CHALLENGE_FIVE_DEBUG.getValue();
            com_fossil_cky.crq.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Five_Subtitle_Game_Steps_Match));
            com_fossil_cky.crp.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Five_Text_Step_to_and_show_your));
            com_fossil_cky.crk.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Five_List_First_To));
            com_fossil_cky.crl.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Five_List_Tie_Breaker_Opponent_who_takes));
            com_fossil_cky.crm.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Five_List_Start_Time_1200_AM_the));
            com_fossil_cky.crn.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Five_List_End_Time_1159_PM_the));
            com_fossil_cky.cro.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Five_List_Results_will_be_posted_at));
        }
        if (!this.cGC) {
            com_fossil_cky.cri.setOnClickListener(new C2360b(this, intRef));
            com_fossil_cky.crs.setOnClickListener(new C2361c(this));
        }
        this.cEY = new dqo(this, com_fossil_cky);
        return com_fossil_cky.dz();
    }

    public void onResume() {
        super.onResume();
        if (this.cGC) {
            C2357a c2357a = this.cGB;
            if (c2357a == null) {
                esl.mF("mPresenter");
            }
            c2357a.jW(this.cGD);
        }
    }

    public void m7613a(C2357a c2357a) {
        esl.m11128j(c2357a, "presenter");
        this.cGB = c2357a;
    }

    public void ahx() {
        MFLogger.m12670d(cuo.class.getSimpleName(), "showSearchingOpponentDialog");
        a aVar = new a(getContext());
        View inflate = View.inflate(getContext(), R.layout.popup_bc_search_opponent, null);
        aVar.bm(inflate);
        aVar.R(false);
        os ln = aVar.ln();
        inflate.findViewById(R.id.fbtn_ok).setOnClickListener(new C2362d(this, ln));
        ln.show();
    }

    public void jV(int i) {
        dqw.m9419a(i, getChildFragmentManager());
    }

    public void ahy() {
        BCNotifications bCNotifications = new BCNotifications();
        bCNotifications.setType(11);
        bCNotifications.setMessage(arp.m4318u(PortfolioApp.ZQ(), R.string.Stats_BC_Failed_Text_Sorry_we_couldnt_find_an));
        Intent intent = new Intent();
        intent.putExtra("BC_SHOW_NOTIFICATION_NOTIFICATIONS", bCNotifications);
        intent.setAction("BC_SHOW_NOTIFICATION_ACTION");
        PortfolioApp.ZQ().sendBroadcast(intent);
    }
}
