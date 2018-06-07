package com.portfolio.platform.ui.device.locate.map;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.fossil.ctj;
import com.fossil.czt.b;
import com.fossil.czu;
import com.fossil.czv;
import com.fossil.czw;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.PortfolioApp;

public class DeviceLocateMapActivity extends ctj {
    public czv cMP;

    public static void m15732E(Context context, String str) {
        Intent intent = new Intent(context, DeviceLocateMapActivity.class);
        intent.putExtra("EXTRA_DEVICE_ID", str);
        context.startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.base_activity);
        String stringExtra = getIntent().getStringExtra("EXTRA_DEVICE_ID");
        b bVar = (czu) getSupportFragmentManager().aF(R.id.content);
        if (bVar == null) {
            bVar = czu.cMX.in(stringExtra);
            a(bVar, czu.cMX.getTAG(), R.id.content);
        }
        PortfolioApp.ZQ().aam().a(new czw(bVar, stringExtra)).a(this);
    }
}
