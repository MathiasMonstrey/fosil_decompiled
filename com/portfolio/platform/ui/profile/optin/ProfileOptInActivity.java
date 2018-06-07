package com.portfolio.platform.ui.profile.optin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.fossil.ctj;
import com.fossil.dfp.b;
import com.fossil.dfq;
import com.fossil.dfr;
import com.fossil.dft;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.PortfolioApp;

public class ProfileOptInActivity extends ctj {
    public dft cTb;

    public static void bF(Context context) {
        context.startActivity(new Intent(context, ProfileOptInActivity.class));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.base_activity);
        b bVar = (dfq) getSupportFragmentManager().aF(R.id.content);
        if (bVar == null) {
            bVar = dfq.cTd.anN();
            a(bVar, R.id.content);
        }
        getIntent();
        PortfolioApp.ZQ().aam().a(new dfr(bVar)).a(this);
    }

    protected void onResume() {
        super.onResume();
        ck(false);
    }
}
