package com.portfolio.platform.ui.device.link;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.fossil.ctj;
import com.fossil.czg;
import com.fossil.czj.b;
import com.fossil.czl;
import com.fossil.czn;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.PortfolioApp;

public class PairDeviceActivity extends ctj {
    public czn cLY;

    public static void bF(Context context) {
        context.startActivity(new Intent(context, PairDeviceActivity.class));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.base_activity);
        b bVar = (czg) getSupportFragmentManager().aF(R.id.content);
        if (bVar == null) {
            bVar = czg.cMg.akr();
            a(bVar, R.id.content);
        }
        PortfolioApp.ZQ().aam().a(new czl(this, bVar)).a(this);
        if (bundle != null) {
            this.cLY.cB(bundle.getBoolean("KEY_IS_PAIR_DEVICE_FAIL_POPUP"));
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("KEY_IS_PAIR_DEVICE_FAIL_POPUP", this.cLY.akD());
        super.onSaveInstanceState(bundle);
    }
}
