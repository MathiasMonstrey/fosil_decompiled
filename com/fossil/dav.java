package com.fossil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.FossilSwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.C1175b;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import com.fossil.dau.C2613a;
import com.fossil.dau.C2614b;
import com.fossil.dbg.C2620b;
import com.fossil.dbn.C2624b;
import com.fossil.dbr.C2633b;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.view.indicator.CirclePageIndicator;
import com.portfolio.platform.view.recyclerview.RecyclerViewPager;
import com.portfolio.platform.view.recyclerview.RecyclerViewPager.a;
import java.util.ArrayList;
import java.util.List;

public class dav extends ctm implements OnAttachStateChangeListener, C2614b {
    public static final String TAG = dav.class.getSimpleName();
    protected CirclePageIndicator cNF;
    dbp cNG;
    dbt cNH;
    dbl cNI;
    private C2613a cNJ;
    private RecyclerViewPager cNK;
    private List<Fragment> cNL = new ArrayList();
    private FossilSwipeRefreshLayout cNM;

    class C26151 implements C1175b {
        final /* synthetic */ dav cNN;

        C26151(dav com_fossil_dav) {
            this.cNN = com_fossil_dav;
        }

        public void kA() {
            int fS = PortfolioApp.ZQ().fS(PortfolioApp.ZQ().aaa());
            MFLogger.m12670d(dav.TAG, "Inside .onRefresh currentDeviceSession=" + fS);
            if (fS == CommunicateMode.OTA.getValue()) {
                gy.m11536p(PortfolioApp.ZQ()).m11538b(new Intent("BROADCAST_DEVICE_BUSY_OTAING"));
                this.cNN.cNM.setRefreshing(false);
                return;
            }
            this.cNN.cNJ.sync();
        }
    }

    class C26162 implements a {
        final /* synthetic */ dav cNN;

        C26162(dav com_fossil_dav) {
            this.cNN = com_fossil_dav;
        }

        public void ar(int i) {
            this.cNN.hB("home_scroll");
        }
    }

    public /* synthetic */ void cK(Object obj) {
        m8108a((C2613a) obj);
    }

    public static dav akZ() {
        return new dav();
    }

    public void m8108a(C2613a c2613a) {
        this.cNJ = (C2613a) cco.ce(c2613a);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_home, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.cNK = (RecyclerViewPager) view.findViewById(R.id.vp_top_container);
        this.cNF = (CirclePageIndicator) view.findViewById(R.id.indicator);
        this.cNM = (FossilSwipeRefreshLayout) view.findViewById(R.id.srlPullToSync);
        this.cNM.setOnRefreshListener(new C26151(this));
        ala();
        view.addOnAttachStateChangeListener(this);
    }

    private void ala() {
        C2620b ali;
        fa childFragmentManager = getChildFragmentManager();
        dbh com_fossil_dbh = (dbh) childFragmentManager.mo3086W(dbh.TAG);
        C2624b c2624b = (dbo) childFragmentManager.mo3086W(dbo.TAG);
        C2633b c2633b = (dbs) childFragmentManager.mo3086W(dbs.TAG);
        if (com_fossil_dbh == null) {
            ali = dbh.ali();
        } else {
            Object obj = com_fossil_dbh;
        }
        if (c2624b == null) {
            c2624b = dbo.alo();
        }
        if (c2633b == null) {
            c2633b = dbs.alr();
        }
        this.cNL.clear();
        this.cNL.add(c2624b);
        this.cNL.add(c2633b);
        this.cNL.add(ali);
        Fragment fragment = (dqm) childFragmentManager.aF(R.id.fl_widget);
        if (fragment == null) {
            fragment = dqm.lw(4);
        }
        this.cNK.setAdapter(new dsc(childFragmentManager, this.cNL));
        this.cNK.setItemViewCacheSize(3);
        this.cNK.setOnPageChangeListener(new C26162(this));
        this.cNF.setVisibility(0);
        this.cNF.d(this.cNK, 0);
        fg hW = childFragmentManager.hW();
        hW.mo2965a((int) R.id.fl_widget, fragment);
        hW.mo2964T(null);
        hW.commitAllowingStateLoss();
        PortfolioApp.ZQ().aam().mo1805a(new dax(c2624b, c2633b, ali, getActivity().getSupportLoaderManager())).mo1779a(this);
    }

    public void onResume() {
        super.onResume();
        if (getView() != null && getView().isAttachedToWindow()) {
            this.cNJ.start();
        }
    }

    public void onPause() {
        super.onPause();
        if (getView() != null && getView().isAttachedToWindow()) {
            this.cNJ.stop();
        }
    }

    public void onViewAttachedToWindow(View view) {
        MFLogger.m12670d(TAG, "onViewAttachedToWindow");
        this.cNJ.start();
    }

    public void onViewDetachedFromWindow(View view) {
        MFLogger.m12670d(TAG, "onViewDetachedFromWindow");
        this.cNJ.stop();
    }

    public void cD(boolean z) {
        if (isActive()) {
            this.cNM.setRefreshing(z);
        }
    }

    public String getTAG() {
        return TAG;
    }
}
