package com.portfolio.platform.ui.profile.homeconfig;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.fossil.ctj;
import com.fossil.deu.b;
import com.fossil.dev;
import com.fossil.dew;
import com.fossil.dey;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.PortfolioApp;

public class ProfileHomeConfigActivity extends ctj {
    public dey cSp;

    public static void bF(Context context) {
        context.startActivity(new Intent(context, ProfileHomeConfigActivity.class));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.base_activity);
        b bVar = (dev) getSupportFragmentManager().aF(R.id.content);
        if (bVar == null) {
            bVar = dev.anA();
            a(bVar, R.id.content);
        }
        getIntent();
        PortfolioApp.ZQ().aam().a(new dew(bVar)).a(this);
    }
}
