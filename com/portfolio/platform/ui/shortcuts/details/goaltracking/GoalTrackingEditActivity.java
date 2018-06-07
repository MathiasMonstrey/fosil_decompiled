package com.portfolio.platform.ui.shortcuts.details.goaltracking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.fossil.ctj;
import com.fossil.dib.b;
import com.fossil.dic;
import com.fossil.did;
import com.fossil.die;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.constants.Constants;
import com.portfolio.platform.PortfolioApp;

public class GoalTrackingEditActivity extends ctj {
    private static final String TAG = GoalTrackingEditActivity.class.getSimpleName();
    public did cVY;
    private b cVZ;
    private String mMicroAppId;

    public static void m15747d(Fragment fragment, String str, int i) {
        Intent intent = new Intent(fragment.getContext(), GoalTrackingEditActivity.class);
        intent.putExtra(Constants.MICRO_APP_ID, str);
        fragment.startActivityForResult(intent, i);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.base_activity);
        Intent intent = getIntent();
        if (intent != null) {
            this.mMicroAppId = intent.getStringExtra(Constants.MICRO_APP_ID);
        } else if (bundle != null) {
            this.mMicroAppId = bundle.getString(Constants.MICRO_APP_ID);
        }
        this.mMicroAppId = !TextUtils.isEmpty(this.mMicroAppId) ? this.mMicroAppId : "";
        this.cVZ = (b) getSupportFragmentManager().W(dic.TAG);
        if (this.cVZ == null) {
            Object apJ = dic.apJ();
            b(apJ, dic.TAG);
            this.cVZ = apJ;
        }
        PortfolioApp.ZQ().aam().a(new die(this.cVZ, this.mMicroAppId)).a(this);
        this.cVZ.cK(this.cVY);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(Constants.MICRO_APP_ID, this.mMicroAppId);
    }
}
