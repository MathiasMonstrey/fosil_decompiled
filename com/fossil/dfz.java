package com.fossil;

import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.fossil.dfy.C2737a;
import com.fossil.dfy.C2738b;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.ui.profile.connectedapps.ProfileConnectedAppsActivity;
import com.portfolio.platform.ui.profile.homeconfig.ProfileHomeConfigActivity;
import com.portfolio.platform.ui.profile.optin.ProfileOptInActivity;
import com.portfolio.platform.ui.profile.unit.ProfileUnitActivity;
import com.portfolio.platform.view.FlexibleTextView;
import java.util.HashMap;
import java.util.Map;

public class dfz extends ctm implements OnClickListener, C2738b {
    private AppCompatImageView cSr;
    private C2737a cTn;
    private FlexibleTextView cTo;
    private FlexibleTextView cTp;
    private FlexibleTextView cTq;
    private FlexibleTextView cTr;

    public /* synthetic */ void cK(Object obj) {
        m8496a((C2737a) obj);
    }

    public static dfz anR() {
        return new dfz();
    }

    public void m8496a(C2737a c2737a) {
        this.cTn = (C2737a) cco.ce(c2737a);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_pref_profile, viewGroup, false);
        this.cSr = (AppCompatImageView) inflate.findViewById(R.id.aciv_back);
        this.cTo = (FlexibleTextView) inflate.findViewById(R.id.ftvUnits);
        this.cTp = (FlexibleTextView) inflate.findViewById(R.id.ftvConnectedApps);
        this.cTq = (FlexibleTextView) inflate.findViewById(R.id.ftvOptIn);
        this.cTr = (FlexibleTextView) inflate.findViewById(R.id.home_config);
        this.cSr.setOnClickListener(this);
        this.cTo.setOnClickListener(this);
        this.cTp.setOnClickListener(this);
        this.cTq.setOnClickListener(this);
        this.cTr.setOnClickListener(this);
        return inflate;
    }

    public void onResume() {
        super.onResume();
        this.cTn.start();
    }

    public void onPause() {
        super.onPause();
        this.cTn.stop();
    }

    public void onClick(View view) {
        Map hashMap;
        switch (view.getId()) {
            case R.id.aciv_back:
                getActivity().onBackPressed();
                return;
            case R.id.ftvUnits:
                hashMap = new HashMap();
                hashMap.put("Item", "Units");
                cmj.bs(getContext()).m7085e("profile_preference", hashMap);
                ProfileUnitActivity.bF(getActivity());
                return;
            case R.id.ftvConnectedApps:
                hashMap = new HashMap();
                hashMap.put("Item", "Connected_Apps");
                cmj.bs(getContext()).m7085e("profile_preference", hashMap);
                ProfileConnectedAppsActivity.bF(getActivity());
                return;
            case R.id.ftvOptIn:
                hashMap = new HashMap();
                hashMap.put("Item", "Optin");
                cmj.bs(getContext()).m7085e("profile_preference", hashMap);
                ProfileOptInActivity.bF(getActivity());
                return;
            case R.id.home_config:
                hashMap = new HashMap();
                hashMap.put("Item", "Home_Configuration");
                cmj.bs(getContext()).m7085e("profile_preference", hashMap);
                ProfileHomeConfigActivity.bF(getActivity());
                return;
            default:
                return;
        }
    }
}
