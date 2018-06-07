package com.portfolio.platform.ui.profile.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.fossil.ctj;
import com.fossil.dfg.b;
import com.fossil.dfh;
import com.fossil.dfi;
import com.fossil.dfk;
import com.fossil.gn;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.ui.profile.editprofile.EditProfileActivity;

public class MainProfileActivity extends ctj {
    public dfk cSC;

    public static void bF(Context context) {
        context.startActivity(new Intent(context, MainProfileActivity.class));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.view_frame_holder_with_toolbar);
        j(R.drawable.ic_back_dark, -1, -1, -1, R.string.Profile_Profile_CTA_EDIT);
        findViewById(R.id.cl_toolbar).setBackgroundColor(gn.e(this, R.color.fossilBeige));
        b bVar = (dfh) getSupportFragmentManager().aF(R.id.container);
        if (bVar == null) {
            bVar = dfh.anH();
            a(bVar, R.id.container);
        }
        PortfolioApp.ZQ().aam().a(new dfi(bVar)).a(this);
    }

    protected void onResume() {
        super.onResume();
        ck(false);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_toolbar_right:
                EditProfileActivity.bF(this);
                break;
        }
        super.onClick(view);
    }
}
