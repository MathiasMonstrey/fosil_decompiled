package com.portfolio.platform.ui.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.fossil.ctj;
import com.fossil.dnl.b;
import com.fossil.dnm;
import com.fossil.dnn;
import com.fossil.dnp;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.PortfolioApp;

public class ForgotPasswordActivity extends ctj {
    public dnp daX;

    public static void bF(Context context) {
        context.startActivity(new Intent(context, ForgotPasswordActivity.class));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.view_frame_holder_with_toolbar);
        b bVar = (dnm) getSupportFragmentManager().aF(R.id.container);
        j(R.drawable.ic_back_dark, -1, -1, -1, -1);
        if (bVar == null) {
            bVar = dnm.asC();
            a(bVar, R.id.container);
        }
        PortfolioApp.ZQ().aam().a(new dnn(this, bVar)).a(this);
    }
}
