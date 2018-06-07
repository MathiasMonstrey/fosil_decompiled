package com.portfolio.platform.ui.device.locate.proximity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.fossil.ctj;
import com.fossil.daj.b;
import com.fossil.dak;
import com.fossil.dal;
import com.fossil.dam;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.PortfolioApp;

public class DeviceLocateProximityActivity extends ctj {
    public dal cNq;

    public static void m15733E(Context context, String str) {
        Intent intent = new Intent(context, DeviceLocateProximityActivity.class);
        intent.putExtra("EXTRA_DEVICE_ID", str);
        context.startActivity(intent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.base_activity);
        String stringExtra = getIntent().getStringExtra("EXTRA_DEVICE_ID");
        b bVar = (dak) getSupportFragmentManager().aF(R.id.content);
        if (bVar == null) {
            bVar = dak.cNt.io(stringExtra);
            a(bVar, dak.cNt.getTAG(), R.id.content);
        }
        PortfolioApp.ZQ().aam().a(new dam(bVar, stringExtra)).a(this);
    }
}
