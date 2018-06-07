package com.portfolio.platform.ui.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.fossil.ctj;
import com.fossil.dnv.b;
import com.fossil.dnw;
import com.fossil.dnx;
import com.fossil.dnz;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.PortfolioApp;

public class LoginEmailActivity extends ctj {
    public dnz dbj;

    public static void bF(Context context) {
        context.startActivity(new Intent(context, LoginEmailActivity.class));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.view_frame_holder_with_toolbar);
        j(R.drawable.ic_back_dark, -1, -1, -1, -1);
        b bVar = (dnw) getSupportFragmentManager().aF(R.id.container);
        if (bVar == null) {
            bVar = dnw.asN();
            a(bVar, R.id.container);
        }
        PortfolioApp.ZQ().aam().a(new dnx(this, bVar)).a(this);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }
}
