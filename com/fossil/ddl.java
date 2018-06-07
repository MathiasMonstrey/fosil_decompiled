package com.fossil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager.C1119e;
import android.support.v7.widget.LinearLayoutManager;
import android.util.SparseArray;
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
import com.portfolio.platform.view.indicator.CirclePageIndicator;
import com.portfolio.platform.view.recyclerview.RecyclerViewPager;
import com.portfolio.platform.view.recyclerview.RecyclerViewPager.a;
import com.sina.weibo.sdk.api.CmdObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ddl extends ctm implements OnClickListener, C2426a<List<Explore>> {
    public static final String TAG = ddl.class.getSimpleName();
    private int Bz = -1;
    private List<Explore> bWZ = new ArrayList();
    protected fj cFC;
    protected CirclePageIndicator cNF;
    private RecyclerViewPager cQT;
    protected cki cQU;
    private boolean cQV;
    private ExploreLoader cQW;
    private FlexibleButton cQX;
    protected String cQY = CmdObject.CMD_HOME;
    cnr cQZ;
    public UserRepository mUserRepository;

    class C26871 implements a {
        final /* synthetic */ ddl cRa;

        C26871(ddl com_fossil_ddl) {
            this.cRa = com_fossil_ddl;
        }

        public void ar(int i) {
            this.cRa.m7519n("home_swipe", "Swipe", String.valueOf(i));
        }
    }

    class C26882 implements C1119e {
        final /* synthetic */ ddl cRa;

        C26882(ddl com_fossil_ddl) {
            this.cRa = com_fossil_ddl;
        }

        public void mo74a(int i, float f, int i2) {
        }

        public void ar(int i) {
            if (i >= 0) {
                MFLogger.m12670d(ddl.TAG, "Inside .onPageSelected position=" + i);
                Intent intent = new Intent("BROADCAST_EXPLORE_OTHER_PAGED_CHANGED");
                intent.putExtra("EXPLORE_PAGE_POSITION", i);
                gy.m11536p(PortfolioApp.ZQ()).m11538b(intent);
                this.cRa.Bz = i;
            }
        }

        public void aq(int i) {
        }
    }

    protected List<Explore> amL() {
        return new ArrayList();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        PortfolioApp.ZQ().aam().mo1839a(this);
        this.bWZ = new ArrayList();
        this.cFC = getActivity().getSupportLoaderManager();
        this.cQW = new ExploreLoader(getActivity());
        if (getArguments() != null) {
            this.cQY = getArguments().getString("explore_type");
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    public void onResume() {
        super.onResume();
        amM();
    }

    protected void amM() {
        this.cQV = this.mUserRepository.getCurrentUser() != null;
        if (this.cQV) {
            this.cQX.setText(arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Explore_Pair_CTA_PAIR_A_WATCH));
        } else {
            this.cQX.setText(arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Welcome_CTA_GET_STARTED));
        }
    }

    public void onPause() {
        super.onPause();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_device_pager, viewGroup, false);
        this.cQT = (RecyclerViewPager) inflate.findViewById(R.id.pager);
        this.cNF = (CirclePageIndicator) inflate.findViewById(R.id.indicator);
        this.cQT.setLayoutManager(new LinearLayoutManager(getActivity(), 0, false));
        this.cQU = new cki(this.bWZ, tx.t(this));
        this.cQT.setAdapter(this.cQU);
        this.cQT.setOnPageChangeListener(new C26871(this));
        this.cQX = (FlexibleButton) inflate.findViewById(R.id.fb_get_started);
        this.cQX.setOnClickListener(this);
        this.cNF.setOnPageChangeListener(new C26882(this));
        this.cNF.setVisibility(0);
        this.cNF.d(this.cQT, 0);
        return inflate;
    }

    public gx<List<Explore>> mo2137b(int i, Bundle bundle) {
        MFLogger.m12670d(TAG, "Inside .onCreateLoader id=" + i);
        return this.cQW;
    }

    public void m8382a(gx<List<Explore>> gxVar, List<Explore> list) {
        this.bWZ.clear();
        if (list == null || list.isEmpty()) {
            this.bWZ = amL();
        } else {
            for (Explore explore : list) {
                if (explore.getType().equalsIgnoreCase(this.cQY)) {
                    this.bWZ.add(explore);
                }
            }
        }
        this.cQU.m6956N(ah(this.bWZ));
        this.cQU.notifyDataSetChanged();
    }

    private List<Explore> ah(List<Explore> list) {
        List<Explore> arrayList = new ArrayList();
        SparseArray sparseArray = new SparseArray();
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        for (Explore explore : list) {
            sparseArray.put(m8379c(explore), explore);
        }
        for (int i = 0; i < 5; i++) {
            if (sparseArray.get(i) != null) {
                arrayList.add(sparseArray.get(i));
            }
        }
        return arrayList;
    }

    private int m8379c(Explore explore) {
        String type = explore.getType();
        int i = -1;
        switch (type.hashCode()) {
            case -1177318867:
                if (type.equals("account")) {
                    i = 1;
                    break;
                }
                break;
            case -342500282:
                if (type.equals("shortcut")) {
                    i = 2;
                    break;
                }
                break;
            case 3208415:
                if (type.equals(CmdObject.CMD_HOME)) {
                    i = 0;
                    break;
                }
                break;
            case 109757599:
                if (type.equals("stats")) {
                    i = 4;
                    break;
                }
                break;
            case 595233003:
                if (type.equals("notification")) {
                    i = 3;
                    break;
                }
                break;
        }
        switch (i) {
            case 0:
                return 1;
            case 1:
                return 5;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            default:
                return 0;
        }
    }

    public void mo2129a(gx<List<Explore>> gxVar) {
    }

    public String getTAG() {
        return TAG;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fb_get_started:
                HashMap hashMap = new HashMap();
                hashMap.put("Mode", "Explore_Pair");
                switch (this.cQU.getItemViewType(this.Bz)) {
                    case 1:
                        hashMap.put("Screen", "Home");
                        break;
                    case 2:
                        hashMap.put("Screen", "Device");
                        break;
                    case 3:
                        hashMap.put("Screen", "Notifications");
                        break;
                    case 4:
                        hashMap.put("Screen", "Stats");
                        break;
                }
                m7518f("onboarding_continue", hashMap);
                if (this.cQV) {
                    PairDeviceStartActivity.bF(getActivity());
                    return;
                } else {
                    CreateAccountActivity.bF(getActivity());
                    return;
                }
            default:
                return;
        }
    }
}
