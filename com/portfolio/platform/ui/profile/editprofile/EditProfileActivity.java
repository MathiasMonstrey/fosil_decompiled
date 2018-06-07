package com.portfolio.platform.ui.profile.editprofile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.fossil.ctj;
import com.fossil.del.b;
import com.fossil.dem;
import com.fossil.den;
import com.fossil.dep;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.PortfolioApp;

public class EditProfileActivity extends ctj {
    public dep cRP;

    public static void bF(Context context) {
        context.startActivity(new Intent(context, EditProfileActivity.class));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.base_activity);
        b bVar = (dem) getSupportFragmentManager().aF(R.id.content);
        if (bVar == null) {
            bVar = dem.ant();
            a(bVar, R.id.content);
        }
        getIntent();
        PortfolioApp.ZQ().aam().a(new den(bVar)).a(this);
    }

    protected void onResume() {
        super.onResume();
        ck(false);
    }
}
