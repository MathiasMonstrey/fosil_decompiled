package com.portfolio.platform.ui.profile.connectedapps;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.fossil.ctj;
import com.fossil.ded;
import com.fossil.dee;
import com.fossil.deg;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.PortfolioApp;

public class ProfileConnectedAppsActivity extends ctj {
    public deg cRr;
    private ded cRs;

    public static void bF(Context context) {
        context.startActivity(new Intent(context, ProfileConnectedAppsActivity.class));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.base_activity);
        this.cRs = (ded) getSupportFragmentManager().aF(R.id.content);
        if (this.cRs == null) {
            this.cRs = ded.cRw.anj();
            a(this.cRs, R.id.content);
        }
        PortfolioApp.ZQ().aam().a(new dee(this.cRs)).a(this);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.cRs.onActivityResult(i, i2, intent);
    }

    protected void onResume() {
        super.onResume();
        ck(false);
    }
}
