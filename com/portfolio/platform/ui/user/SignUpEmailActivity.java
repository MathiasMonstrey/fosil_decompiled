package com.portfolio.platform.ui.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.fossil.ctj;
import com.fossil.dok.b;
import com.fossil.dol;
import com.fossil.dom;
import com.fossil.doo;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;

public class SignUpEmailActivity extends ctj {
    public doo dbL;

    public static void bF(Context context) {
        context.startActivity(new Intent(context, SignUpEmailActivity.class));
    }

    public static void m15754d(Context context, Bundle bundle) {
        Intent intent = new Intent(context, SignUpEmailActivity.class);
        intent.addFlags(268468224);
        intent.putExtra("EXTRA_INFO", bundle);
        context.startActivity(intent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.base_activity);
        b bVar = (dol) getSupportFragmentManager().aF(R.id.content);
        if (bVar == null) {
            bVar = dol.J(getIntent().getBundleExtra("EXTRA_INFO"));
            a(bVar, R.id.content);
        }
        PortfolioApp.ZQ().aam().a(new dom(bVar)).a(this);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        MFLogger.d(this.TAG, "onActivityResult");
        super.onActivityResult(i, i2, intent);
    }
}
