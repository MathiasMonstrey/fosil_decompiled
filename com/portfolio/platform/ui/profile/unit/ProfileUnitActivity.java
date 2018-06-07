package com.portfolio.platform.ui.profile.unit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.fossil.ctj;
import com.fossil.dgq.b;
import com.fossil.dgr;
import com.fossil.dgt;
import com.fossil.dgv;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.PortfolioApp;

public class ProfileUnitActivity extends ctj {
    public dgv cTF;

    public static void bF(Context context) {
        context.startActivity(new Intent(context, ProfileUnitActivity.class));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.base_activity);
        b bVar = (dgr) getSupportFragmentManager().aF(R.id.content);
        if (bVar == null) {
            bVar = dgr.cTJ.aob();
            a(bVar, R.id.content);
        }
        getIntent();
        PortfolioApp.ZQ().aam().a(new dgt(bVar)).a(this);
    }

    protected void onResume() {
        super.onResume();
        ck(false);
    }
}
