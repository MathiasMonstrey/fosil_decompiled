package com.portfolio.platform.ui.device.alarm.set;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.fossil.ctj;
import com.fossil.cwx.b;
import com.fossil.cwy;
import com.fossil.cwz;
import com.fossil.cxa;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.buttonservice.model.Alarm;
import com.portfolio.platform.PortfolioApp;
import java.util.ArrayList;
import java.util.List;

public class AlarmSetActivity extends ctj {
    public cwz cJO;

    public static void m15731a(Fragment fragment, int i, String str, List<Alarm> list, Alarm alarm) {
        Intent intent = new Intent(fragment.getContext(), AlarmSetActivity.class);
        intent.putExtra("EXTRA_DEVICE_ID", str);
        intent.putExtra("EXTRA_ALARM", alarm);
        intent.putParcelableArrayListExtra("EXTRA_ALARMS", (ArrayList) list);
        fragment.startActivityForResult(intent, i);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.base_activity);
        String stringExtra = getIntent().getStringExtra("EXTRA_DEVICE_ID");
        Alarm alarm = (Alarm) getIntent().getParcelableExtra("EXTRA_ALARM");
        List parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("EXTRA_ALARMS");
        b bVar = (cwy) getSupportFragmentManager().aF(R.id.content);
        if (bVar == null) {
            bVar = cwy.cJS.ajm();
            a(bVar, cwy.cJS.getTAG(), R.id.content);
        }
        PortfolioApp.ZQ().aam().a(new cxa(bVar, stringExtra, parcelableArrayListExtra, alarm)).a(this);
        if (bundle != null) {
            this.cJO.setName(bundle.getString("ALARM_SET_NAME"));
            this.cJO.setMinutes(bundle.getInt("ALARM_SET_MINUTES"));
            this.cJO.cu(bundle.getBoolean("ALARM_SET_IS_ACTIVE"));
            this.cJO.cv(bundle.getBoolean("ALARM_SET_IS_REPEAT"));
            this.cJO.c(cwz.h(bundle.getIntArray("ALARM_SET_DAYS_REPEAT")));
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("ALARM_SET_NAME", this.cJO.getName());
        bundle.putInt("ALARM_SET_MINUTES", this.cJO.getMinutes());
        bundle.putBoolean("ALARM_SET_IS_REPEAT", this.cJO.isRepeat());
        bundle.putBoolean("ALARM_SET_IS_ACTIVE", this.cJO.isActive());
        bundle.putIntArray("ALARM_SET_DAYS_REPEAT", cwz.d(this.cJO.ajn()));
        super.onSaveInstanceState(bundle);
    }
}
