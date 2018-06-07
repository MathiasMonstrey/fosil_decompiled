package com.fossil;

import android.os.Bundle;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.Explore;
import java.util.ArrayList;
import java.util.List;

public class ddr extends ddl {
    public static final String TAG = ddr.class.getSimpleName();

    public static ddr amQ() {
        ddr com_fossil_ddr = new ddr();
        Bundle bundle = new Bundle();
        bundle.putString("explore_type", "stats");
        com_fossil_ddr.setArguments(bundle);
        return com_fossil_ddr;
    }

    protected void amM() {
        super.amM();
        this.cFC.mo3100a(24, null, this);
    }

    public String getTAG() {
        return TAG;
    }

    protected List<Explore> amL() {
        List<Explore> arrayList = new ArrayList();
        arrayList.add(new Explore("stats", R.drawable.background_explore_stats, arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Explore_Stats_Title_Track_Your_Stats), arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Explore_Stats_Text_Set_your_goal_for_daily)));
        return arrayList;
    }
}
