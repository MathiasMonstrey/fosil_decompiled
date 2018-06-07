package com.portfolio.platform.ui.buddychallenge.activity;

import android.content.Intent;
import android.os.Bundle;
import com.fossil.ctj;
import com.fossil.cun.b;
import com.fossil.cuo;
import com.fossil.cup;
import com.fossil.cur;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.PortfolioApp;

public class BCCreateAccountActivity extends ctj {
    public cur cHq;

    protected void onCreate(Bundle bundle) {
        int i;
        int i2;
        super.onCreate(bundle);
        setContentView(R.layout.base_activity);
        Intent intent = getIntent();
        if (intent == null || !intent.hasExtra("EXTRA_STEP_GOAL")) {
            i = 0;
        } else {
            i = intent.getIntExtra("EXTRA_STEP_GOAL", 0);
        }
        if (intent == null || !intent.hasExtra("CHALLENGE_TYPE")) {
            i2 = -1;
        } else {
            i2 = intent.getIntExtra("CHALLENGE_TYPE", -1);
        }
        b bVar = (cuo) getSupportFragmentManager().aF(R.id.content);
        if (bVar == null) {
            bVar = cuo.cGp.bV(i, i2);
            a(bVar, R.id.content);
        }
        PortfolioApp.ZQ().aam().a(new cup(bVar)).a(this);
    }
}
