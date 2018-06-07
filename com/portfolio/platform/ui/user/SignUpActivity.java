package com.portfolio.platform.ui.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.fossil.cnu;
import com.fossil.cnw;
import com.fossil.cny;
import com.fossil.coa;
import com.fossil.ctj;
import com.fossil.dnf.b;
import com.fossil.dng;
import com.fossil.dor;
import com.fossil.dos;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.PortfolioApp;
import java.lang.ref.WeakReference;

public class SignUpActivity extends ctj {
    public dng dbh;

    public static void bF(Context context) {
        context.startActivity(new Intent(context, SignUpActivity.class));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.view_frame_holder_with_toolbar);
        j(R.drawable.ic_back_dark, -1, -1, -1, -1);
        b bVar = (dor) getSupportFragmentManager().aF(R.id.container);
        if (bVar == null) {
            bVar = dor.ato();
            a(bVar, R.id.container);
        }
        PortfolioApp.ZQ().aam().a(new dos(this, bVar)).a(this);
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        cny.adz().onNewIntent(getIntent());
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null) {
            cnu.adu().onActivityResult(i, i2, intent);
            cnw.a(new WeakReference(this)).onActivityResult(i, i2, intent);
            coa.adD().a(i, i2, intent);
        }
    }
}
