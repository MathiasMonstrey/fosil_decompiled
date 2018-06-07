package com.portfolio.platform.ui.buddychallenge.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.fossil.ctj;
import com.fossil.cuv.b;
import com.fossil.cuw;
import com.fossil.cux;
import com.fossil.cuz;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.PortfolioApp;

public class BCFindOpponentActivity extends ctj {
    public cuz cHr;

    public static void m15713b(Context context, int i, boolean z) {
        Intent intent = new Intent(context, BCFindOpponentActivity.class);
        intent.putExtra("CHALLENGE_TYPE", i);
        intent.putExtra("SHOW_POPUP", z);
        context.startActivity(intent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.base_activity);
        Intent intent = getIntent();
        b bVar = (cuw) getSupportFragmentManager().aF(R.id.content);
        int intExtra = intent.getIntExtra("CHALLENGE_TYPE", -1);
        boolean booleanExtra = intent.getBooleanExtra("SHOW_POPUP", false);
        if (bVar == null) {
            bVar = cuw.cGG.w(intExtra, booleanExtra);
            a(bVar, R.id.content);
        }
        PortfolioApp.ZQ().aam().a(new cux(bVar)).a(this);
    }
}
