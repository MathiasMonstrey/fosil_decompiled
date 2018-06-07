package com.fossil;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.fossil.drk.C2095b;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.enums.PermissionCodes;
import com.portfolio.platform.ui.MainActivity;
import com.portfolio.platform.ui.device.link.PairDeviceActivity;
import com.portfolio.platform.view.FlexibleButton;
import com.portfolio.platform.view.UnderlinedTextView;
import kotlin.TypeCastException;

public final class czh extends ctn implements OnClickListener, C2095b {
    private static final String TAG;
    private static final String cMi = cMi;
    public static final C2568a cMj = new C2568a();
    private boolean cMh;

    public static final class C2568a {
        private C2568a() {
        }

        public final String getTAG() {
            return czh.TAG;
        }

        public final String akt() {
            return czh.cMi;
        }

        public final czh aku() {
            return new czh();
        }
    }

    static {
        String simpleName = czh.class.getSimpleName();
        esl.m11127i(simpleName, "PairDeviceStartFragment::class.java.simpleName");
        TAG = simpleName;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.cMh = bundle.getBoolean(cMj.akt());
        }
        if (getActivity().getIntent() != null) {
            this.cMh = getActivity().getIntent().getBooleanExtra(cMj.akt(), false);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        esl.m11128j(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.activity_pair_device_start, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        esl.m11128j(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R.id.fb_next);
        if (findViewById == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.portfolio.platform.view.FlexibleButton");
        }
        FlexibleButton flexibleButton = (FlexibleButton) findViewById;
        View findViewById2 = view.findViewById(R.id.ftv_continue_without_watch);
        if (findViewById2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.portfolio.platform.view.UnderlinedTextView");
        }
        UnderlinedTextView underlinedTextView = (UnderlinedTextView) findViewById2;
        flexibleButton.setOnClickListener(this);
        underlinedTextView.setOnClickListener(this);
        underlinedTextView.setVisibility(this.cMh ? 4 : 0);
    }

    public void onClick(View view) {
        esl.m11128j(view, "v");
        switch (view.getId()) {
            case R.id.iv_toolbar_left:
                getActivity().finish();
                return;
            case R.id.ftv_continue_without_watch:
                hB("pair_without_watch");
                MainActivity.bF(getActivity());
                return;
            case R.id.fb_next:
                m7523a(PermissionCodes.BLUETOOTH_OFF, PermissionCodes.LOCATION_PERMISSION_OFF, PermissionCodes.LOCATION_SERVICE_OFF);
                return;
            default:
                return;
        }
    }

    public void mo1746a(String str, int i, Intent intent) {
        esl.m11128j(str, "tag");
        super.mo1746a(str, i, intent);
        switch (str.hashCode()) {
            case 1008390942:
                if (str.equals("NO_INTERNET_CONNECTION")) {
                    switch (i) {
                        case R.id.ftv_go_to_setting:
                            if (isActive()) {
                                agi();
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
                return;
            default:
                return;
        }
    }

    public void agi() {
        MFLogger.m12670d(cMj.getTAG(), "onNavigatingToSetting()");
        try {
            startActivity(new Intent("android.settings.SETTINGS"));
        } catch (Exception e) {
            MFLogger.m12670d(cMj.getTAG(), "Exception when start intent setting.");
        }
    }

    public void age() {
    }

    public void agf() {
    }

    public void agg() {
    }

    public void agh() {
        if (PortfolioApp.ZQ().aak()) {
            PortfolioApp.ZQ().m12695b(CommunicateMode.LINK, "");
            PairDeviceActivity.bF(getActivity());
        } else if (isActive()) {
            dqw.m9419a(601, getChildFragmentManager());
        }
    }
}
