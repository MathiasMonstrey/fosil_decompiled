package com.portfolio.platform.ui.device.calibration;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.fossil.ctj;
import com.fossil.cxu.b;
import com.fossil.cxv;
import com.fossil.cxw;
import com.fossil.cxy;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.PortfolioApp;

public class DeviceCalibrationActivity extends ctj {
    public cxy cKm;

    public static void bF(Context context) {
        context.startActivity(new Intent(context, DeviceCalibrationActivity.class));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.base_activity);
        b bVar = (cxv) getSupportFragmentManager().aF(R.id.content);
        if (bVar == null) {
            bVar = cxv.cKo.ajD();
            a(bVar, R.id.content);
        }
        PortfolioApp.ZQ().aam().a(new cxw(bVar)).a(this);
    }

    protected void onResume() {
        super.onResume();
        ck(false);
    }
}
