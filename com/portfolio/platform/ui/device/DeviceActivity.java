package com.portfolio.platform.ui.device;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.fossil.ctj;
import com.fossil.cvr.b;
import com.fossil.cvs;
import com.fossil.cvu;
import com.fossil.cvx;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.PortfolioApp;

public class DeviceActivity extends ctj {
    public cvx cHY;

    public static void bF(Context context) {
        context.startActivity(new Intent(context, DeviceActivity.class));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.base_activity);
        b bVar = (cvs) getSupportFragmentManager().aF(R.id.content);
        if (bVar == null) {
            bVar = cvs.cIg.aiC();
            a(bVar, R.id.content);
        }
        PortfolioApp.ZQ().aam().a(new cvu(bVar, getSupportLoaderManager())).a(this);
    }

    protected void onResume() {
        super.onResume();
        ck(false);
    }
}
