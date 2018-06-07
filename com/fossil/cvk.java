package com.fossil;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.C1221h;
import android.support.v7.widget.RecyclerView.C1243g;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.fossil.cvd.C2367b;
import com.fossil.cvg.C2382a;
import com.fossil.cvg.C2383b;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.buddychallenge.BCChallenge;
import com.portfolio.platform.data.model.buddychallenge.BCChallenge.TYPE;
import com.portfolio.platform.data.model.buddychallenge.BCInvitation;
import com.portfolio.platform.data.model.buddychallenge.BCOpponent;
import com.portfolio.platform.data.model.buddychallenge.BCPlayer;
import com.portfolio.platform.ui.buddychallenge.StatsBuddyChallengeFragment.onCreateView.linearLayoutManager.1;
import com.portfolio.platform.ui.buddychallenge.activity.BCCreateAccountActivity;
import com.portfolio.platform.ui.buddychallenge.activity.BCFindOpponentActivity;
import com.portfolio.platform.ui.view.MyChallengeView;
import com.portfolio.platform.view.FlexibleTextView;
import com.portfolio.platform.view.SpaceItemDecoration;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import kotlin.TypeCastException;

public final class cvk extends ctm implements C2383b {
    public static final C2389a cHo = new C2389a();
    private dqo<clg> cEY;
    private C2382a cHi;
    private final int cHj = 123456789;
    private final int cHk = 987654321;
    private cvn cHl;
    private ArrayList<BCChallenge> cHm = new ArrayList();
    private final C2390b cHn = new C2390b(this);

    public static final class C2389a {
        private C2389a() {
        }

        public final cvk aif() {
            return new cvk();
        }
    }

    public static final class C2390b extends BroadcastReceiver {
        final /* synthetic */ cvk cHp;

        C2390b(cvk com_fossil_cvk) {
            this.cHp = com_fossil_cvk;
        }

        public void onReceive(Context context, Intent intent) {
            esl.m11128j(context, "context");
            if (intent != null) {
                BCChallenge bCChallenge = (BCChallenge) intent.getParcelableExtra("BC_HEARTBEAT_STEP_EXTRA");
                if (this.cHp.isActive()) {
                    this.cHp.m7674f(bCChallenge);
                }
            }
        }
    }

    static final class C2391c implements OnClickListener {
        final /* synthetic */ cvk cHp;

        C2391c(cvk com_fossil_cvk) {
            this.cHp = com_fossil_cvk;
        }

        public final void onClick(View view) {
            cvk.m7672a(this.cHp).jY(TYPE.TYPE_CHALLENGE_ONE.getValue());
            cmj.bs(this.cHp.getContext()).m7086l("stats_bc_start", "Challenge", String.valueOf(TYPE.TYPE_CHALLENGE_ONE.getValue()));
        }
    }

    static final class C2392d implements OnClickListener {
        final /* synthetic */ cvk cHp;

        C2392d(cvk com_fossil_cvk) {
            this.cHp = com_fossil_cvk;
        }

        public final void onClick(View view) {
            cvk.m7672a(this.cHp).jY(TYPE.TYPE_CHALLENGE_THREE.getValue());
            cmj.bs(this.cHp.getContext()).m7086l("stats_bc_start", "Challenge", String.valueOf(TYPE.TYPE_CHALLENGE_THREE.getValue()));
        }
    }

    static final class C2393e implements OnClickListener {
        final /* synthetic */ cvk cHp;

        C2393e(cvk com_fossil_cvk) {
            this.cHp = com_fossil_cvk;
        }

        public final void onClick(View view) {
            cvk.m7672a(this.cHp).jY(TYPE.TYPE_CHALLENGE_FIVE.getValue());
            cmj.bs(this.cHp.getContext()).m7086l("stats_bc_start", "Challenge", String.valueOf(TYPE.TYPE_CHALLENGE_FIVE.getValue()));
        }
    }

    static final class C2394f implements OnClickListener {
        final /* synthetic */ cvk cHp;

        C2394f(cvk com_fossil_cvk) {
            this.cHp = com_fossil_cvk;
        }

        public final void onClick(View view) {
            cvk.m7672a(this.cHp).jY(TYPE.TYPE_CHALLENGE_ONE_DEBUG.getValue());
            cmj.bs(this.cHp.getContext()).m7086l("stats_bc_start", "Challenge", String.valueOf(TYPE.TYPE_CHALLENGE_ONE_DEBUG.getValue()));
        }
    }

    static final class C2395g implements OnClickListener {
        final /* synthetic */ cvk cHp;

        C2395g(cvk com_fossil_cvk) {
            this.cHp = com_fossil_cvk;
        }

        public final void onClick(View view) {
            cvk.m7672a(this.cHp).jY(TYPE.TYPE_CHALLENGE_THREE_DEBUG.getValue());
            cmj.bs(this.cHp.getContext()).m7086l("stats_bc_start", "Challenge", String.valueOf(TYPE.TYPE_CHALLENGE_THREE_DEBUG.getValue()));
        }
    }

    static final class C2396h implements OnClickListener {
        final /* synthetic */ cvk cHp;

        C2396h(cvk com_fossil_cvk) {
            this.cHp = com_fossil_cvk;
        }

        public final void onClick(View view) {
            cvk.m7672a(this.cHp).jY(TYPE.TYPE_CHALLENGE_FIVE_DEBUG.getValue());
            cmj.bs(this.cHp.getContext()).m7086l("stats_bc_start", "Challenge", String.valueOf(TYPE.TYPE_CHALLENGE_FIVE_DEBUG.getValue()));
        }
    }

    static final class C2397i implements OnClickListener {
        final /* synthetic */ cvk cHp;

        C2397i(cvk com_fossil_cvk) {
            this.cHp = com_fossil_cvk;
        }

        public final void onClick(View view) {
            C2382a a = cvk.m7672a(this.cHp);
            if (view == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.portfolio.platform.ui.view.MyChallengeView");
            }
            a.mo2098a((MyChallengeView) view);
            cmj.bs(this.cHp.getContext()).logEvent("stats_bc_info");
        }
    }

    public static final class C2398j implements C2367b {
        final /* synthetic */ cvk cHp;

        C2398j(cvk com_fossil_cvk) {
            this.cHp = com_fossil_cvk;
        }

        public void mo2103v(int i, String str) {
            cvk.m7672a(this.cHp).aia();
        }
    }

    public static final class C2399k implements C2367b {
        final /* synthetic */ cvk cHp;

        C2399k(cvk com_fossil_cvk) {
            this.cHp = com_fossil_cvk;
        }

        public void mo2103v(int i, String str) {
            if (i > 0) {
                cvk.m7672a(this.cHp).aia();
            }
            if (i == 2) {
                cvk.m7672a(this.cHp).hO(str);
            }
        }
    }

    public static final /* synthetic */ C2382a m7672a(cvk com_fossil_cvk) {
        C2382a c2382a = com_fossil_cvk.cHi;
        if (c2382a == null) {
            esl.mF("mPresenter");
        }
        return c2382a;
    }

    public /* synthetic */ void cK(Object obj) {
        m7675a((C2382a) obj);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getContext().registerReceiver(this.cHn, new IntentFilter("BC_HEARTBEAT_STEP_ACTION"));
    }

    public void onDestroy() {
        super.onDestroy();
        getContext().unregisterReceiver(this.cHn);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        clg com_fossil_clg = (clg) C3311e.m10386a(layoutInflater, R.layout.fragment_stats_buddy_challenge, viewGroup, false, this.cEN);
        com_fossil_clg.cun.setOnClickListener(new C2391c(this));
        com_fossil_clg.cup.setOnClickListener(new C2392d(this));
        com_fossil_clg.cul.setOnClickListener(new C2393e(this));
        OnClickListener c2397i = new C2397i(this);
        Context context = getContext();
        esl.m11127i(context, "context");
        this.cHl = new cvn(context, this.cHm, c2397i);
        com_fossil_clg.ctY.setLayoutManager(new 1(this, getContext()));
        RecyclerView recyclerView = com_fossil_clg.ctY;
        cvn com_fossil_cvn = this.cHl;
        if (com_fossil_cvn == null) {
            esl.mF("mChallengeViewAdapter");
        }
        recyclerView.setAdapter(com_fossil_cvn);
        com_fossil_clg.ctY.m1710a((C1243g) new SpaceItemDecoration(getContext(), R.dimen.dp16, true, true));
        FlexibleTextView flexibleTextView = com_fossil_clg.cuf;
        esm com_fossil_esm = esm.dSO;
        String u = arp.m4318u(PortfolioApp.ZQ(), R.string.Stats_Activity_BC_Header_My_Challenges__of_3);
        esl.m11127i(u, "LanguageHelper.getString…ader_My_Challenges__of_3)");
        Object[] objArr = new Object[]{Integer.valueOf(0)};
        u = String.format(u, Arrays.copyOf(objArr, objArr.length));
        esl.m11127i(u, "java.lang.String.format(format, *args)");
        flexibleTextView.setText(u);
        flexibleTextView = com_fossil_clg.cui;
        com_fossil_esm = esm.dSO;
        u = arp.m4318u(PortfolioApp.ZQ(), R.string.Stats_Activity_BC_Empty_Text_First_to__Steps);
        esl.m11127i(u, "LanguageHelper.getString…pty_Text_First_to__Steps)");
        objArr = new Object[]{Integer.valueOf(3500)};
        u = String.format(u, Arrays.copyOf(objArr, objArr.length));
        esl.m11127i(u, "java.lang.String.format(format, *args)");
        flexibleTextView.setText(u);
        flexibleTextView = com_fossil_clg.cub;
        com_fossil_esm = esm.dSO;
        u = arp.m4318u(PortfolioApp.ZQ(), R.string.Stats_Activity_BC_Text_First_to__Steps);
        esl.m11127i(u, "LanguageHelper.getString…_BC_Text_First_to__Steps)");
        objArr = new Object[]{NumberFormat.getNumberInstance(Locale.US).format(Integer.valueOf(3500))};
        u = String.format(u, Arrays.copyOf(objArr, objArr.length));
        esl.m11127i(u, "java.lang.String.format(format, *args)");
        flexibleTextView.setText(u);
        flexibleTextView = com_fossil_clg.cud;
        com_fossil_esm = esm.dSO;
        u = arp.m4318u(PortfolioApp.ZQ(), R.string.Stats_Activity_BC_Text_Best_of);
        esl.m11127i(u, "LanguageHelper.getString…Activity_BC_Text_Best_of)");
        objArr = new Object[]{Integer.valueOf(3)};
        u = String.format(u, Arrays.copyOf(objArr, objArr.length));
        esl.m11127i(u, "java.lang.String.format(format, *args)");
        flexibleTextView.setText(u);
        flexibleTextView = com_fossil_clg.ctZ;
        com_fossil_esm = esm.dSO;
        u = arp.m4318u(PortfolioApp.ZQ(), R.string.Stats_Activity_BC_Text_Best_of);
        esl.m11127i(u, "LanguageHelper.getString…Activity_BC_Text_Best_of)");
        objArr = new Object[]{Integer.valueOf(5)};
        u = String.format(u, Arrays.copyOf(objArr, objArr.length));
        esl.m11127i(u, "java.lang.String.format(format, *args)");
        flexibleTextView.setText(u);
        com_fossil_clg.cuo.setOnClickListener(new C2394f(this));
        com_fossil_clg.cuq.setOnClickListener(new C2395g(this));
        com_fossil_clg.cum.setOnClickListener(new C2396h(this));
        flexibleTextView = com_fossil_clg.cuc;
        com_fossil_esm = esm.dSO;
        u = arp.m4318u(PortfolioApp.ZQ(), R.string.Stats_Activity_BC_Text_First_to__Steps);
        esl.m11127i(u, "LanguageHelper.getString…_BC_Text_First_to__Steps)");
        objArr = new Object[]{NumberFormat.getNumberInstance(Locale.US).format(Integer.valueOf(3500))};
        u = String.format(u, Arrays.copyOf(objArr, objArr.length));
        esl.m11127i(u, "java.lang.String.format(format, *args)");
        flexibleTextView.setText(u);
        flexibleTextView = com_fossil_clg.cue;
        com_fossil_esm = esm.dSO;
        u = arp.m4318u(PortfolioApp.ZQ(), R.string.Stats_Activity_BC_Text_Best_of);
        esl.m11127i(u, "LanguageHelper.getString…Activity_BC_Text_Best_of)");
        objArr = new Object[]{Integer.valueOf(3)};
        u = String.format(u, Arrays.copyOf(objArr, objArr.length));
        esl.m11127i(u, "java.lang.String.format(format, *args)");
        flexibleTextView.setText(u);
        flexibleTextView = com_fossil_clg.cua;
        com_fossil_esm = esm.dSO;
        u = arp.m4318u(PortfolioApp.ZQ(), R.string.Stats_Activity_BC_Text_Best_of);
        esl.m11127i(u, "LanguageHelper.getString…Activity_BC_Text_Best_of)");
        objArr = new Object[]{Integer.valueOf(5)};
        u = String.format(u, Arrays.copyOf(objArr, objArr.length));
        esl.m11127i(u, "java.lang.String.format(format, *args)");
        flexibleTextView.setText(u);
        this.cEY = new dqo(this, com_fossil_clg);
        return com_fossil_clg.dz();
    }

    public void onResume() {
        super.onResume();
        Boolean bool = clw.cwB;
        esl.m11127i(bool, "Constants.IS_ENABLE_BC");
        if (bool.booleanValue()) {
            C2382a c2382a = this.cHi;
            if (c2382a == null) {
                esl.mF("mPresenter");
            }
            c2382a.aia();
        }
        clg com_fossil_clg;
        LinearLayout linearLayout;
        if (PortfolioApp.ZQ().YV().adj()) {
            dqo com_fossil_dqo;
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_clg = (clg) com_fossil_dqo.get();
            if (com_fossil_clg != null) {
                linearLayout = com_fossil_clg.cuo;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
            }
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_clg = (clg) com_fossil_dqo.get();
            if (com_fossil_clg != null) {
                linearLayout = com_fossil_clg.cuq;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
            }
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_clg = (clg) com_fossil_dqo.get();
            if (com_fossil_clg != null) {
                linearLayout = com_fossil_clg.cum;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                    return;
                }
                return;
            }
            return;
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_clg = (clg) com_fossil_dqo.get();
        if (com_fossil_clg != null) {
            linearLayout = com_fossil_clg.cuo;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_clg = (clg) com_fossil_dqo.get();
        if (com_fossil_clg != null) {
            linearLayout = com_fossil_clg.cuq;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_clg = (clg) com_fossil_dqo.get();
        if (com_fossil_clg != null) {
            linearLayout = com_fossil_clg.cum;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
        }
    }

    public void m7675a(C2382a c2382a) {
        esl.m11128j(c2382a, "presenter");
        this.cHi = c2382a;
    }

    public void mo2111k(ArrayList<BCChallenge> arrayList) {
        esl.m11128j(arrayList, "challenges");
        int i = 0;
        for (BCChallenge bCChallenge : arrayList) {
            int i2 = (bCChallenge.getStatus() == 0 || bCChallenge.getStatus() == 1 || bCChallenge.getStatus() == 2) ? 1 : 0;
            if (i2 != 0) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        clg com_fossil_clg = (clg) com_fossil_dqo.get();
        if (com_fossil_clg != null) {
            FlexibleTextView flexibleTextView = com_fossil_clg.cuf;
            if (flexibleTextView != null) {
                esm com_fossil_esm = esm.dSO;
                String u = arp.m4318u(PortfolioApp.ZQ(), R.string.Stats_Activity_BC_Header_My_Challenges__of_3);
                esl.m11127i(u, "LanguageHelper.getString…ader_My_Challenges__of_3)");
                Object[] objArr = new Object[]{Integer.valueOf(i)};
                u = String.format(u, Arrays.copyOf(objArr, objArr.length));
                esl.m11127i(u, "java.lang.String.format(format, *args)");
                flexibleTextView.setText(u);
            }
        }
        aie();
        LinearLayout linearLayout;
        if (arrayList.size() <= 0) {
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_clg = (clg) com_fossil_dqo.get();
            if (com_fossil_clg != null) {
                linearLayout = com_fossil_clg.cuj;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
            }
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_clg = (clg) com_fossil_dqo.get();
            if (com_fossil_clg != null) {
                FlexibleTextView flexibleTextView2 = com_fossil_clg.cui;
                if (flexibleTextView2 != null) {
                    com_fossil_esm = esm.dSO;
                    u = arp.m4318u(PortfolioApp.ZQ(), R.string.Stats_Activity_BC_Empty_Text_First_to__Steps);
                    esl.m11127i(u, "LanguageHelper.getString…pty_Text_First_to__Steps)");
                    Object[] objArr2 = new Object[]{NumberFormat.getNumberInstance(Locale.US).format(Integer.valueOf(3500))};
                    u = String.format(u, Arrays.copyOf(objArr2, objArr2.length));
                    esl.m11127i(u, "java.lang.String.format(format, *args)");
                    flexibleTextView2.setText(u);
                }
            }
        } else {
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_clg = (clg) com_fossil_dqo.get();
            if (com_fossil_clg != null) {
                linearLayout = com_fossil_clg.cuj;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
            }
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_clg = (clg) com_fossil_dqo.get();
            if (com_fossil_clg != null) {
                RecyclerView recyclerView = com_fossil_clg.ctY;
                if (recyclerView != null) {
                    recyclerView.setVisibility(0);
                }
            }
        }
        this.cHm.clear();
        this.cHm.addAll(arrayList);
        cvn com_fossil_cvn = this.cHl;
        if (com_fossil_cvn == null) {
            esl.mF("mChallengeViewAdapter");
        }
        com_fossil_cvn.notifyDataSetChanged();
    }

    public void mo2106b(BCOpponent bCOpponent, String str) {
        if (bCOpponent != null) {
            Iterator it = this.cHm.iterator();
            while (it.hasNext()) {
                BCChallenge bCChallenge = (BCChallenge) it.next();
                if (esl.m11125C(bCChallenge.getChallengeId(), str)) {
                    View de;
                    MyChallengeView myChallengeView;
                    dqo com_fossil_dqo = this.cEY;
                    if (com_fossil_dqo == null) {
                        esl.mF("mBinding");
                    }
                    clg com_fossil_clg = (clg) com_fossil_dqo.get();
                    if (com_fossil_clg != null) {
                        RecyclerView recyclerView = com_fossil_clg.ctY;
                        if (recyclerView != null) {
                            C1221h layoutManager = recyclerView.getLayoutManager();
                            if (layoutManager != null) {
                                de = layoutManager.de(this.cHm.indexOf(bCChallenge));
                                myChallengeView = (MyChallengeView) de;
                                if (myChallengeView != null) {
                                    myChallengeView.aJ(bCOpponent.getProfilePicture(), bCOpponent.getUserName());
                                }
                                if (myChallengeView != null) {
                                    myChallengeView.setOpponentName(bCOpponent.getUserName());
                                }
                                if (myChallengeView != null) {
                                    myChallengeView.setTag(this.cHj, bCOpponent);
                                    return;
                                }
                                return;
                            }
                        }
                    }
                    de = null;
                    myChallengeView = (MyChallengeView) de;
                    if (myChallengeView != null) {
                        myChallengeView.aJ(bCOpponent.getProfilePicture(), bCOpponent.getUserName());
                    }
                    if (myChallengeView != null) {
                        myChallengeView.setOpponentName(bCOpponent.getUserName());
                    }
                    if (myChallengeView != null) {
                        myChallengeView.setTag(this.cHj, bCOpponent);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public void jZ(int i) {
        BCFindOpponentActivity.b(getContext(), i, false);
    }

    public void bW(int i, int i2) {
        MFLogger.m12670d("StatsBuddyChallenge", "showCreateAccount stepGoal=" + i2);
        Intent intent = new Intent(getContext(), BCCreateAccountActivity.class);
        intent.putExtra("CHALLENGE_TYPE", i);
        intent.putExtra("EXTRA_STEP_GOAL", i2);
        getActivity().startActivity(intent);
    }

    public void ka(int i) {
        C2382a c2382a = this.cHi;
        if (c2382a == null) {
            esl.mF("mPresenter");
        }
        c2382a.jX(i);
    }

    public void mo2107b(MyChallengeView myChallengeView) {
        Object senderId;
        Integer num = null;
        BCPlayer adI = cnq.acd().acw().adI();
        BCChallenge bCChallenge = (BCChallenge) (myChallengeView != null ? myChallengeView.getTag(this.cHk) : null);
        if (bCChallenge != null) {
            senderId = bCChallenge.getSenderId();
        } else {
            senderId = null;
        }
        String receiverId = esl.m11125C(senderId, adI.getUserId()) ? bCChallenge != null ? bCChallenge.getReceiverId() : null : bCChallenge != null ? bCChallenge.getSenderId() : null;
        BCOpponent hb = cnq.acd().acw().hb(receiverId);
        if (bCChallenge != null) {
            num = Integer.valueOf(bCChallenge.getType());
        }
        if (num == null) {
            esl.aGW();
        }
        mo2104a(bCChallenge, hb, num.intValue());
    }

    public void mo2104a(BCChallenge bCChallenge, BCOpponent bCOpponent, int i) {
        MFLogger.m12670d(dks.cYO.getTAG(), "showChallengeDetail screenType:" + i);
        afM();
        cvd a = cvd.cGW.m7624a(i, false, bCOpponent, bCChallenge, null);
        a.setCancelable(false);
        a.dp(true);
        a.lc(aid());
        a.dq(false);
        a.m7640a((C2367b) new C2398j(this));
        fa childFragmentManager = getChildFragmentManager();
        esl.m11127i(childFragmentManager, "childFragmentManager");
        String tag = cvd.cGW.getTAG();
        esl.m11127i(tag, "BCMainFragment.TAG");
        a.show(childFragmentManager, tag);
    }

    public void mo2109c(BCInvitation bCInvitation) {
        int i;
        MFLogger.m12670d(dks.cYO.getTAG(), "showInvitationScreen invitation:" + String.valueOf(bCInvitation));
        Object valueOf = bCInvitation != null ? Integer.valueOf(bCInvitation.getChallengeType()) : null;
        if (esl.m11125C(valueOf, Integer.valueOf(TYPE.TYPE_CHALLENGE_ONE.getValue())) || esl.m11125C(valueOf, Integer.valueOf(TYPE.TYPE_CHALLENGE_ONE_DEBUG.getValue()))) {
            i = 3;
        } else if (esl.m11125C(valueOf, Integer.valueOf(TYPE.TYPE_CHALLENGE_THREE.getValue())) || esl.m11125C(valueOf, Integer.valueOf(TYPE.TYPE_CHALLENGE_THREE_DEBUG.getValue()))) {
            i = 4;
        } else if (esl.m11125C(valueOf, Integer.valueOf(TYPE.TYPE_CHALLENGE_FIVE.getValue())) || esl.m11125C(valueOf, Integer.valueOf(TYPE.TYPE_CHALLENGE_FIVE_DEBUG.getValue()))) {
            i = 5;
        } else {
            i = 0;
        }
        cvd a = cvd.cGW.m7624a(i, false, null, null, bCInvitation);
        a.setCancelable(false);
        a.dp(true);
        a.lc(aid());
        a.dq(false);
        a.m7640a((C2367b) new C2399k(this));
        fa childFragmentManager = getChildFragmentManager();
        esl.m11127i(childFragmentManager, "childFragmentManager");
        String tag = cvd.cGW.getTAG();
        esl.m11127i(tag, "BCMainFragment.TAG");
        a.show(childFragmentManager, tag);
    }

    private final void m7674f(BCChallenge bCChallenge) {
        if (bCChallenge != null) {
            Iterator it = this.cHm.iterator();
            while (it.hasNext()) {
                BCChallenge bCChallenge2 = (BCChallenge) it.next();
                if (esl.m11125C(bCChallenge2.getChallengeId(), bCChallenge.getChallengeId())) {
                    View de;
                    MyChallengeView myChallengeView;
                    cvn com_fossil_cvn;
                    cvn com_fossil_cvn2;
                    dqo com_fossil_dqo = this.cEY;
                    if (com_fossil_dqo == null) {
                        esl.mF("mBinding");
                    }
                    clg com_fossil_clg = (clg) com_fossil_dqo.get();
                    if (com_fossil_clg != null) {
                        RecyclerView recyclerView = com_fossil_clg.ctY;
                        if (recyclerView != null) {
                            C1221h layoutManager = recyclerView.getLayoutManager();
                            if (layoutManager != null) {
                                de = layoutManager.de(this.cHm.indexOf(bCChallenge2));
                                myChallengeView = (MyChallengeView) de;
                                this.cHm.set(this.cHm.indexOf(bCChallenge2), bCChallenge);
                                com_fossil_cvn = this.cHl;
                                if (com_fossil_cvn == null) {
                                    esl.mF("mChallengeViewAdapter");
                                }
                                com_fossil_cvn.dr(this.cHm.indexOf(bCChallenge2));
                                com_fossil_cvn2 = this.cHl;
                                if (com_fossil_cvn2 == null) {
                                    esl.mF("mChallengeViewAdapter");
                                }
                                com_fossil_cvn2.m7687a(myChallengeView, bCChallenge);
                                return;
                            }
                        }
                    }
                    de = null;
                    myChallengeView = (MyChallengeView) de;
                    this.cHm.set(this.cHm.indexOf(bCChallenge2), bCChallenge);
                    com_fossil_cvn = this.cHl;
                    if (com_fossil_cvn == null) {
                        esl.mF("mChallengeViewAdapter");
                    }
                    com_fossil_cvn.dr(this.cHm.indexOf(bCChallenge2));
                    com_fossil_cvn2 = this.cHl;
                    if (com_fossil_cvn2 == null) {
                        esl.mF("mChallengeViewAdapter");
                    }
                    com_fossil_cvn2.m7687a(myChallengeView, bCChallenge);
                    return;
                }
            }
        }
    }

    private final int bG(Context context) {
        Resources resources = context.getResources();
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
        i = height - i;
        Context context = getContext();
        esl.m11127i(context, "context");
        return i - bG(context);
    }

    private final void aie() {
        BCPlayer adI = cnq.acd().acw().adI();
        clg com_fossil_clg;
        LinearLayout linearLayout;
        if (adI == null || adI.getInChallengeProcess() < 3) {
            dqo com_fossil_dqo;
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_clg = (clg) com_fossil_dqo.get();
            if (com_fossil_clg != null) {
                linearLayout = com_fossil_clg.cun;
                if (linearLayout != null) {
                    linearLayout.setEnabled(true);
                }
            }
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_clg = (clg) com_fossil_dqo.get();
            if (com_fossil_clg != null) {
                linearLayout = com_fossil_clg.cup;
                if (linearLayout != null) {
                    linearLayout.setEnabled(true);
                }
            }
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_clg = (clg) com_fossil_dqo.get();
            if (com_fossil_clg != null) {
                linearLayout = com_fossil_clg.cul;
                if (linearLayout != null) {
                    linearLayout.setEnabled(true);
                }
            }
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_clg = (clg) com_fossil_dqo.get();
            if (com_fossil_clg != null) {
                linearLayout = com_fossil_clg.cun;
                if (linearLayout != null) {
                    linearLayout.setAlpha(1.0f);
                }
            }
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_clg = (clg) com_fossil_dqo.get();
            if (com_fossil_clg != null) {
                linearLayout = com_fossil_clg.cup;
                if (linearLayout != null) {
                    linearLayout.setAlpha(1.0f);
                }
            }
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_clg = (clg) com_fossil_dqo.get();
            if (com_fossil_clg != null) {
                linearLayout = com_fossil_clg.cul;
                if (linearLayout != null) {
                    linearLayout.setAlpha(1.0f);
                }
            }
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_clg = (clg) com_fossil_dqo.get();
            if (com_fossil_clg != null) {
                linearLayout = com_fossil_clg.cuo;
                if (linearLayout != null) {
                    linearLayout.setEnabled(true);
                }
            }
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_clg = (clg) com_fossil_dqo.get();
            if (com_fossil_clg != null) {
                linearLayout = com_fossil_clg.cuq;
                if (linearLayout != null) {
                    linearLayout.setEnabled(true);
                }
            }
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_clg = (clg) com_fossil_dqo.get();
            if (com_fossil_clg != null) {
                linearLayout = com_fossil_clg.cum;
                if (linearLayout != null) {
                    linearLayout.setEnabled(true);
                }
            }
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_clg = (clg) com_fossil_dqo.get();
            if (com_fossil_clg != null) {
                linearLayout = com_fossil_clg.cuo;
                if (linearLayout != null) {
                    linearLayout.setAlpha(1.0f);
                }
            }
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_clg = (clg) com_fossil_dqo.get();
            if (com_fossil_clg != null) {
                linearLayout = com_fossil_clg.cuq;
                if (linearLayout != null) {
                    linearLayout.setAlpha(1.0f);
                }
            }
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_clg = (clg) com_fossil_dqo.get();
            if (com_fossil_clg != null) {
                linearLayout = com_fossil_clg.cum;
                if (linearLayout != null) {
                    linearLayout.setAlpha(1.0f);
                    return;
                }
                return;
            }
            return;
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_clg = (clg) com_fossil_dqo.get();
        if (com_fossil_clg != null) {
            linearLayout = com_fossil_clg.cun;
            if (linearLayout != null) {
                linearLayout.setEnabled(false);
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_clg = (clg) com_fossil_dqo.get();
        if (com_fossil_clg != null) {
            linearLayout = com_fossil_clg.cup;
            if (linearLayout != null) {
                linearLayout.setEnabled(false);
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_clg = (clg) com_fossil_dqo.get();
        if (com_fossil_clg != null) {
            linearLayout = com_fossil_clg.cul;
            if (linearLayout != null) {
                linearLayout.setEnabled(false);
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_clg = (clg) com_fossil_dqo.get();
        if (com_fossil_clg != null) {
            linearLayout = com_fossil_clg.cun;
            if (linearLayout != null) {
                linearLayout.setAlpha(0.6f);
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_clg = (clg) com_fossil_dqo.get();
        if (com_fossil_clg != null) {
            linearLayout = com_fossil_clg.cup;
            if (linearLayout != null) {
                linearLayout.setAlpha(0.6f);
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_clg = (clg) com_fossil_dqo.get();
        if (com_fossil_clg != null) {
            linearLayout = com_fossil_clg.cul;
            if (linearLayout != null) {
                linearLayout.setAlpha(0.6f);
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_clg = (clg) com_fossil_dqo.get();
        if (com_fossil_clg != null) {
            linearLayout = com_fossil_clg.cuo;
            if (linearLayout != null) {
                linearLayout.setEnabled(false);
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_clg = (clg) com_fossil_dqo.get();
        if (com_fossil_clg != null) {
            linearLayout = com_fossil_clg.cuq;
            if (linearLayout != null) {
                linearLayout.setEnabled(false);
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_clg = (clg) com_fossil_dqo.get();
        if (com_fossil_clg != null) {
            linearLayout = com_fossil_clg.cum;
            if (linearLayout != null) {
                linearLayout.setEnabled(false);
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_clg = (clg) com_fossil_dqo.get();
        if (com_fossil_clg != null) {
            linearLayout = com_fossil_clg.cuo;
            if (linearLayout != null) {
                linearLayout.setAlpha(0.6f);
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_clg = (clg) com_fossil_dqo.get();
        if (com_fossil_clg != null) {
            linearLayout = com_fossil_clg.cuq;
            if (linearLayout != null) {
                linearLayout.setAlpha(0.6f);
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_clg = (clg) com_fossil_dqo.get();
        if (com_fossil_clg != null) {
            linearLayout = com_fossil_clg.cum;
            if (linearLayout != null) {
                linearLayout.setAlpha(0.6f);
            }
        }
    }

    public void afM() {
        afU();
    }
}
