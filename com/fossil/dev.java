package com.fossil;

import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.C1234a;
import android.support.v7.widget.RecyclerView.C1264v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.fossil.deu.C2713a;
import com.fossil.deu.C2714b;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.PortfolioApp;
import java.util.ArrayList;
import java.util.List;

public class dev extends ctm implements OnClickListener, C2714b, dfd {
    private C2713a cSq;
    private AppCompatImageView cSr;
    private RecyclerView cSs;
    private tc cSt;

    public /* synthetic */ void cK(Object obj) {
        m8446a((C2713a) obj);
    }

    public static dev anA() {
        return new dev();
    }

    public void m8446a(C2713a c2713a) {
        this.cSq = (C2713a) cco.ce(c2713a);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_profile_home_config, viewGroup, false);
        this.cSr = (AppCompatImageView) inflate.findViewById(R.id.aciv_back);
        this.cSs = (RecyclerView) inflate.findViewById(R.id.config_list);
        this.cSr.setOnClickListener(this);
        this.cSs.setHasFixedSize(true);
        this.cSs.setLayoutManager(new LinearLayoutManager(getActivity()));
        List arrayList = new ArrayList();
        arrayList.add(PortfolioApp.ZQ().getResources().getString(R.string.Profile_Preferences_Home_Label_Shortcuts));
        arrayList.add(PortfolioApp.ZQ().getResources().getString(R.string.Profile_Preferences_Home_Label_Notifications));
        arrayList.add(PortfolioApp.ZQ().getResources().getString(R.string.Profile_Preferences_Home_Label_Stats));
        C1234a com_fossil_dfc = new dfc(getActivity(), arrayList, this);
        this.cSt = new tc(new dfb(com_fossil_dfc));
        this.cSt.o(this.cSs);
        this.cSs.setAdapter(com_fossil_dfc);
        return inflate;
    }

    public void onResume() {
        super.onResume();
        this.cSq.start();
    }

    public void onPause() {
        super.onPause();
        this.cSq.stop();
    }

    public void finish() {
        if (getActivity() != null && !getActivity().isFinishing() && !getActivity().isDestroyed()) {
            getActivity().finish();
        }
    }

    public void ae(C1264v c1264v) {
        this.cSt.aa(c1264v);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.aciv_back:
                finish();
                return;
            default:
                return;
        }
    }
}
