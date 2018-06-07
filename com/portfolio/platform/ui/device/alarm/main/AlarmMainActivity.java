package com.portfolio.platform.ui.device.alarm.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.fossil.ctj;
import com.fossil.cwj.b;
import com.fossil.cwk;
import com.fossil.cwl;
import com.fossil.cwm;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.PortfolioApp;
import java.util.ArrayList;

public class AlarmMainActivity extends ctj {
    public cwl cIU;

    public static void m15730c(Fragment fragment, String str) {
        Intent intent = new Intent(fragment.getContext(), AlarmMainActivity.class);
        intent.putExtra("EXTRA_DEVICE_ID", str);
        fragment.startActivity(intent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.base_activity);
        String stringExtra = getIntent().getStringExtra("EXTRA_DEVICE_ID");
        b bVar = (cwk) getSupportFragmentManager().aF(R.id.content);
        if (bVar == null) {
            bVar = cwk.cJt.aiV();
            a(bVar, cwk.cJt.getTAG(), R.id.content);
        }
        PortfolioApp.ZQ().aam().a(new cwm(bVar, stringExtra)).a(this);
        if (bundle != null) {
            this.cIU.Y(bundle.getParcelableArrayList("STATE_ALARMS"));
            this.cIU.setDeviceId(bundle.getString("STATE_DEVICE_ID"));
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putParcelableArrayList("STATE_ALARMS", (ArrayList) this.cIU.aiX());
        bundle.putString("STATE_DEVICE_ID", this.cIU.getDeviceId());
        super.onSaveInstanceState(bundle);
    }
}
