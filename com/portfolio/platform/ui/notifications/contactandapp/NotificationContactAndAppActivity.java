package com.portfolio.platform.ui.notifications.contactandapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.fossil.ctj;
import com.fossil.dcg.b;
import com.fossil.dch;
import com.fossil.dcj;
import com.fossil.dcn;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.PortfolioApp;

public class NotificationContactAndAppActivity extends ctj {
    public dcn cPb;

    public static void m15734a(Fragment fragment, int i, boolean z) {
        Intent intent = new Intent(fragment.getContext(), NotificationContactAndAppActivity.class);
        intent.putExtra("EXTRA_HAND_NUMBER", i);
        intent.putExtra("EXTRA_IS_ADD_FLOW", z);
        fragment.startActivityForResult(intent, 9876);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.base_activity);
        Intent intent = getIntent();
        b bVar = (dch) getSupportFragmentManager().aF(R.id.content);
        if (bVar == null) {
            bVar = dch.alQ();
            a(bVar, R.id.content);
        }
        PortfolioApp.ZQ().aam().a(new dcj(bVar, intent.getIntExtra("EXTRA_HAND_NUMBER", 0), intent.getBooleanExtra("EXTRA_IS_ADD_FLOW", false))).a(this);
        if (bundle != null) {
            this.cPb.kO(bundle.getInt("HAND_NUMBER", 0));
            this.cPb.cH(bundle.getBoolean("IS_ADD_FLOW"));
            this.cPb.kN(bundle.getInt("SELECTED_POSITION"));
        }
    }

    protected void onResume() {
        super.onResume();
        ck(false);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("HAND_NUMBER", this.cPb.amh());
        bundle.putBoolean("IS_ADD_FLOW", this.cPb.amf());
        bundle.putInt("SELECTED_POSITION", this.cPb.amg());
        super.onSaveInstanceState(bundle);
    }
}
