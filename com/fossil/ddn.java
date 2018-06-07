package com.fossil;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.fossil.fj.C2426a;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.Explore;
import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.data.source.loader.ExploreLoader;
import com.portfolio.platform.ui.device.link.PairDeviceStartActivity;
import com.portfolio.platform.ui.user.CreateAccountActivity;
import com.portfolio.platform.view.FlexibleButton;
import com.portfolio.platform.view.recyclerview.RecyclerViewPager;
import com.sina.weibo.sdk.api.CmdObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ddn extends ctm implements C2426a<List<Explore>> {
    public static final String TAG = ddn.class.getSimpleName();
    private List<Explore> bWZ;
    private fj cFC;
    private RecyclerViewPager cQT;
    private cki cQU;
    private boolean cQV;
    private ExploreLoader cQW;
    private FlexibleButton cQX;
    private dqm cRc;
    public UserRepository mUserRepository;

    class C26891 implements OnClickListener {
        final /* synthetic */ ddn cRd;

        C26891(ddn com_fossil_ddn) {
            this.cRd = com_fossil_ddn;
        }

        public void onClick(View view) {
            Map hashMap = new HashMap();
            hashMap.put("Mode", "Explore_Pair");
            hashMap.put("Screen", "Home");
            this.cRd.m7518f("onboarding_continue", hashMap);
            if (this.cRd.cQV) {
                PairDeviceStartActivity.bF(this.cRd.getActivity());
            } else {
                CreateAccountActivity.bF(this.cRd.getActivity());
            }
        }
    }

    public static ddn amN() {
        ddn com_fossil_ddn = new ddn();
        com_fossil_ddn.setArguments(new Bundle());
        return com_fossil_ddn;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        PortfolioApp.ZQ().aam().mo1840a(this);
        this.bWZ = new ArrayList();
        this.cFC = getActivity().getSupportLoaderManager();
        this.cQW = new ExploreLoader(getActivity());
    }

    public void onResume() {
        super.onResume();
        this.cFC.mo3100a(15, null, this);
        this.cQV = this.mUserRepository.getCurrentUser() != null;
        if (this.cQV) {
            this.cQX.setText(arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Explore_Pair_CTA_PAIR_A_WATCH));
        } else {
            this.cQX.setText(arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Welcome_CTA_GET_STARTED));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_explore_home, viewGroup, false);
        this.cQT = (RecyclerViewPager) inflate.findViewById(R.id.pager);
        this.cQT.setLayoutManager(new LinearLayoutManager(getActivity(), 0, false));
        this.cQU = new cki(this.bWZ, tx.t(this));
        this.cQT.setAdapter(this.cQU);
        this.cQX = (FlexibleButton) inflate.findViewById(R.id.fb_get_started);
        this.cQX.setOnClickListener(new C26891(this));
        this.cRc = (dqm) getChildFragmentManager().aF(R.id.fl_widget);
        if (this.cRc == null) {
            this.cRc = dqm.lw(4);
        }
        fg hW = getChildFragmentManager().hW();
        hW.mo2965a((int) R.id.fl_widget, this.cRc);
        hW.mo2964T(null);
        hW.commitAllowingStateLoss();
        return inflate;
    }

    public gx<List<Explore>> mo2137b(int i, Bundle bundle) {
        MFLogger.m12670d(TAG, "Inside .onCreateLoader id=" + i);
        afT();
        return this.cQW;
    }

    public void m8390a(gx<List<Explore>> gxVar, List<Explore> list) {
        afU();
        MFLogger.m12670d(TAG, "Inside .onLoadFinished exploreList=" + list);
        this.bWZ.clear();
        if (list == null || list.isEmpty()) {
            this.bWZ = amL();
        } else {
            for (Explore explore : list) {
                if (explore.getType().equalsIgnoreCase(CmdObject.CMD_HOME)) {
                    this.bWZ.add(explore);
                }
            }
        }
        if (this.bWZ.isEmpty()) {
            this.bWZ = amL();
        }
        this.cQU.m6956N(this.bWZ);
        this.cQU.notifyDataSetChanged();
    }

    private List<Explore> amL() {
        List<Explore> arrayList = new ArrayList();
        if (this.cQV) {
            arrayList.add(new Explore(CmdObject.CMD_HOME, -1, arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Explore_Pair_Header_GET_CONNECTED), arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Explore_Pair_Text_Pair_a_Hybrid_Smartwatch_to)));
        } else {
            arrayList.add(new Explore(CmdObject.CMD_HOME, -1, arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Explore_Home_Title_JUST_ONE_STEP_AWAY), String.format(arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Explore_Home_Text_To_take_full_advantage_of), new Object[]{getString(R.string.brand_name)})));
        }
        return arrayList;
    }

    public void mo2129a(gx<List<Explore>> gxVar) {
    }

    public String getTAG() {
        return TAG;
    }
}
