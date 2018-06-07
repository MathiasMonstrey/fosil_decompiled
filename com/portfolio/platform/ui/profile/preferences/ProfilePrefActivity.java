package com.portfolio.platform.ui.profile.preferences;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.fossil.ctj;
import com.fossil.dfy.b;
import com.fossil.dfz;
import com.fossil.dga;
import com.fossil.dgc;
import com.fossil.gn;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.PortfolioApp;

public class ProfilePrefActivity extends ctj {
    public dgc cTm;

    public static void bF(Context context) {
        context.startActivity(new Intent(context, ProfilePrefActivity.class));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.view_frame_holder_with_toolbar);
        findViewById(R.id.cl_toolbar).setBackgroundColor(gn.e(this, R.color.fossilBeige));
        b bVar = (dfz) getSupportFragmentManager().aF(R.id.container);
        if (bVar == null) {
            bVar = dfz.anR();
            a(bVar, R.id.container);
        }
        PortfolioApp.ZQ().aam().a(new dga(bVar)).a(this);
    }

    protected void onResume() {
        super.onResume();
        ck(false);
    }
}
