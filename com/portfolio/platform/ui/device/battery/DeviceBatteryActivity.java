package com.portfolio.platform.ui.device.battery;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.fossil.ctj;
import com.fossil.cxl.b;
import com.fossil.cxm;
import com.fossil.cxn;
import com.fossil.cxp;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.PortfolioApp;

public class DeviceBatteryActivity extends ctj {
    public cxp cKg;

    public static void bF(Context context) {
        context.startActivity(new Intent(context, DeviceBatteryActivity.class));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.base_activity);
        b bVar = (cxm) getSupportFragmentManager().aF(R.id.content);
        if (bVar == null) {
            bVar = cxm.cKi.ajv();
            a(bVar, R.id.content);
        }
        PortfolioApp.ZQ().aam().a(new cxn(bVar)).a(this);
    }

    protected void onResume() {
        super.onResume();
        ck(false);
    }
}
