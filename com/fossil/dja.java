package com.fossil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.fossil.diz.C2799a;
import com.fossil.diz.C2816b;
import com.fossil.drk.C2095b;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.microapp.SecondTimezone;
import com.portfolio.platform.ui.shortcuts.details.secondtimezone.SearchSecondTimezoneActivity;
import com.portfolio.platform.util.URLHelper;
import com.portfolio.platform.util.URLHelper.StaticPage;
import com.portfolio.platform.view.FlexibleTextView;
import java.util.ArrayList;
import java.util.List;

public class dja extends ctm implements OnClickListener, C2816b, C2095b {
    public static final String TAG = dja.class.getSimpleName();
    C2799a cWU;
    private FlexibleTextView cWV;

    public /* synthetic */ void cK(Object obj) {
        m8796a((C2799a) obj);
    }

    public void m8796a(C2799a c2799a) {
        this.cWU = c2799a;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_second_timezone, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        MFLogger.m12670d(TAG, "onViewCreated");
        super.onViewCreated(view, bundle);
        this.cWV = (FlexibleTextView) view.findViewById(R.id.timezone_name_tv);
        view.findViewById(R.id.second_timzone_name_layout).setOnClickListener(this);
    }

    public void onResume() {
        MFLogger.m12670d(TAG, "onResume");
        super.onResume();
        this.cWU.apm();
    }

    public void onPause() {
        MFLogger.m12670d(TAG, "onPause");
        super.onPause();
        this.cWU.apn();
    }

    public void onStop() {
        MFLogger.m12670d(TAG, "onStop");
        super.onStop();
    }

    public static dja aqf() {
        return new dja();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.second_timzone_name_layout:
                this.cWU.app();
                return;
            default:
                return;
        }
    }

    public void apc() {
        MFLogger.m12670d(TAG, "saveSettings");
        ((dhk) this.cWU).apc();
    }

    public void mo2513c(SecondTimezone secondTimezone) {
        MFLogger.m12670d(TAG, "showSecondTimeZone name=" + secondTimezone.getTimezoneCityName());
        this.cWV.setText(secondTimezone.getTimezoneCityName());
    }

    public void aou() {
        MFLogger.m12670d(TAG, "showErrorSetDeviceData");
        if (isActive()) {
            dqw.m9445u(getChildFragmentManager());
        }
    }

    public void mo2510a(List<SecondTimezone> list, SecondTimezone secondTimezone) {
        MFLogger.m12670d(TAG, "showSearchSecondTimezoneFragment secondTimezoneList=" + list.size());
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        SearchSecondTimezoneActivity.a(this, arrayList, 1000);
    }

    public void iK(String str) {
        MFLogger.m12670d(TAG, "setSettings settings=" + str);
        this.cWU.iH(str);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        MFLogger.m12670d(TAG, "onActivityResult requestCode=" + i);
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1000:
                if (i2 == -1) {
                    MFLogger.m12670d(TAG, "onActivityResult RESULT_OK requestCode=" + i);
                    if (intent != null) {
                        SecondTimezone secondTimezone = (SecondTimezone) intent.getParcelableExtra("SECOND_TIMEZONE");
                        if (secondTimezone != null) {
                            ((dhk) this.cWU).cR(false);
                            this.cWU.mo2479b(secondTimezone);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void mo1746a(String str, int i, Intent intent) {
        MFLogger.m12670d(TAG, "onDialogFragmentResult - tag" + str);
        Object obj = -1;
        switch (str.hashCode()) {
            case 1396757004:
                if (str.equals("DEVICE_SET_DATA_FAILED")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                if (i == R.id.fb_help) {
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse(URLHelper.a(StaticPage.SUPPORT, null))));
                    return;
                }
                return;
            default:
                return;
        }
    }
}
