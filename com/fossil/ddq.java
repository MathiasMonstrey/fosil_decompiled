package com.fossil;

import android.os.Bundle;
import android.view.View;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.Explore;
import java.util.ArrayList;
import java.util.List;

public class ddq extends ddl {
    public static final String TAG = ddq.class.getSimpleName();

    public static ddq amP() {
        ddq com_fossil_ddq = new ddq();
        Bundle bundle = new Bundle();
        bundle.putString("explore_type", "shortcut");
        com_fossil_ddq.setArguments(bundle);
        return com_fossil_ddq;
    }

    protected void amM() {
        super.amM();
        this.cFC.mo3100a(22, null, this);
    }

    public String getTAG() {
        return TAG;
    }

    protected List<Explore> amL() {
        List<Explore> arrayList = new ArrayList();
        arrayList.add(new Explore("shortcut", R.drawable.background_explore_shortcut, arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Explore_Shortcuts_Title_10_Shortcuts), arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Explore_Shortcuts_Text_Customize_your_watch_to_perform)));
        return arrayList;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fb_get_started:
                hB("device_onboard");
                break;
        }
        super.onClick(view);
    }
}
