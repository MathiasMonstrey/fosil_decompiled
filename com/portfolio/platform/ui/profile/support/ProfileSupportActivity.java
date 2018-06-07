package com.portfolio.platform.ui.profile.support;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.fossil.ctj;
import com.fossil.dgh.b;
import com.fossil.dgi;
import com.fossil.dgj;
import com.fossil.dgl;
import com.fossil.gn;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.PortfolioApp;

public class ProfileSupportActivity extends ctj {
    public dgl cTu;

    public static void bF(Context context) {
        context.startActivity(new Intent(context, ProfileSupportActivity.class));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.view_frame_holder_with_toolbar);
        j(R.drawable.ic_back_dark, -1, -1, -1, -1);
        findViewById(R.id.cl_toolbar).setBackgroundColor(gn.e(this, R.color.fossilBeige));
        b bVar = (dgi) getSupportFragmentManager().aF(R.id.container);
        if (bVar == null) {
            bVar = dgi.anW();
            a(bVar, R.id.container);
        }
        getIntent();
        PortfolioApp.ZQ().aam().a(new dgj(bVar)).a(this);
    }

    protected void onResume() {
        super.onResume();
        ck(false);
    }
}
