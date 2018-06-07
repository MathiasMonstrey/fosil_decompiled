package com.portfolio.platform.ui.profile.changepassword;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.fossil.ctj;
import com.fossil.ddu.b;
import com.fossil.ddv;
import com.fossil.ddx;
import com.fossil.drk.c;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.PortfolioApp;

public class ChangePasswordActivity extends ctj implements c {
    public ddx cRe;

    public static void bF(Context context) {
        context.startActivity(new Intent(context, ChangePasswordActivity.class));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.base_activity);
        b bVar = (ChangePasswordFragment) getSupportFragmentManager().aF(R.id.content);
        if (bVar == null) {
            bVar = ChangePasswordFragment.amV();
            a(bVar, R.id.content);
        }
        getIntent();
        PortfolioApp.ZQ().aam().a(new ddv(bVar)).a(this);
    }

    protected void onResume() {
        super.onResume();
        ck(false);
    }

    public void hJ(String str) {
        if (str.equals("PROFILE_CHANGE_PASS_SUCCESS")) {
            finish();
        }
    }
}
