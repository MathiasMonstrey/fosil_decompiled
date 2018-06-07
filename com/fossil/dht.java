package com.fossil;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.fossil.dhs.C2796a;
import com.fossil.dhs.C2800b;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.microapp.CommuteTimeSettings;
import com.portfolio.platform.data.model.microapp.CommuteTimeSettings.TIME_FORMAT;
import com.portfolio.platform.ui.shortcuts.details.commute.AutoSuggestAddressActivity;
import com.portfolio.platform.ui.view.SwitchCompatCustom;
import com.portfolio.platform.view.FlexibleTextView;

public class dht extends ctm implements OnClickListener, C2800b {
    public static final String TAG = dht.class.getSimpleName();
    private C2796a cVM;
    protected FlexibleTextView cVN;
    private FlexibleTextView cVO;
    private FlexibleTextView cVP;
    private View cVQ;
    private View cVR;
    SwitchCompatCustom cVS;
    private String mMicroAppId;

    class C28011 implements OnClickListener {
        final /* synthetic */ dht cVT;

        C28011(dht com_fossil_dht) {
            this.cVT = com_fossil_dht;
        }

        public void onClick(View view) {
            this.cVT.cVS.dm(!this.cVT.cVS.isChecked());
            this.cVT.cVM.cW(this.cVT.cVS.isChecked());
            ((dhk) this.cVT.cVM).apc();
        }
    }

    static /* synthetic */ class C28022 {
        static final /* synthetic */ int[] cVU = new int[TIME_FORMAT.values().length];

        static {
            try {
                cVU[TIME_FORMAT.ETA.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                cVU[TIME_FORMAT.TRAVEL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public /* synthetic */ void cK(Object obj) {
        m8727a((C2796a) obj);
    }

    public static dht apB() {
        return new dht();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_commute_settings, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.cVN = (FlexibleTextView) view.findViewById(R.id.autocomplete_places);
        view.findViewById(R.id.destination_layout).setOnClickListener(this);
        this.cVS = (SwitchCompatCustom) view.findViewById(R.id.avoid_tolls_switch);
        this.cVS.dm(false);
        this.cVS.setOnClickListener(new C28011(this));
        this.cVO = (FlexibleTextView) view.findViewById(R.id.travel_time_tv);
        this.cVP = (FlexibleTextView) view.findViewById(R.id.arrival_time_tv);
        this.cVQ = view.findViewById(R.id.arrival_time_iv);
        this.cVR = view.findViewById(R.id.travel_time_iv);
        this.cVO.setOnClickListener(this);
        this.cVR.setOnClickListener(this);
        this.cVP.setOnClickListener(this);
        this.cVQ.setOnClickListener(this);
    }

    public void onResume() {
        super.onResume();
        this.cVM.apk();
    }

    public void onPause() {
        super.onPause();
        this.cVM.apl();
    }

    public void onStop() {
        super.onStop();
    }

    public void m8727a(C2796a c2796a) {
        this.cVM = c2796a;
    }

    public void onDetach() {
        super.onDetach();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.destination_layout:
                Bundle bundle = new Bundle();
                bundle.putString("COMMUTE_APP_ID", this.mMicroAppId);
                AutoSuggestAddressActivity.a(this, 1000, bundle);
                return;
            case R.id.arrival_time_iv:
            case R.id.arrival_time_tv:
                this.cVM.mo2463a(TIME_FORMAT.ETA);
                return;
            case R.id.travel_time_iv:
            case R.id.travel_time_tv:
                this.cVM.mo2463a(TIME_FORMAT.TRAVEL);
                return;
            default:
                return;
        }
    }

    public void mo2492b(CommuteTimeSettings commuteTimeSettings) {
        MFLogger.m12670d(TAG, "showCommuteTimeSettings");
        this.cVN.setText(commuteTimeSettings.getDestination(), null);
        this.cVS.setChecked(commuteTimeSettings.isIsAvoidTolls());
        switch (C28022.cVU[commuteTimeSettings.getTimeFormat().ordinal()]) {
            case 1:
                this.cVQ.setAlpha(1.0f);
                this.cVR.setAlpha(0.5f);
                this.cVP.setAlpha(1.0f);
                this.cVO.setAlpha(0.5f);
                return;
            case 2:
                this.cVR.setAlpha(1.0f);
                this.cVQ.setAlpha(0.5f);
                this.cVO.setAlpha(1.0f);
                this.cVP.setAlpha(0.5f);
                return;
            default:
                return;
        }
    }

    public void apc() {
        ((dhk) this.cVM).apc();
    }

    public void iK(String str) {
        this.cVM.iJ(str);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1000:
                if (i2 == -1 && intent != null) {
                    Object stringExtra = intent.getStringExtra("ADDRESS");
                    if (stringExtra != null && !stringExtra.isEmpty()) {
                        this.cVN.setText(stringExtra);
                        this.cVM.setDestination(stringExtra);
                        ((dhk) this.cVM).apc();
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.cVM.onSaveInstanceState(bundle);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.cVM.onActivityCreated(bundle);
    }

    protected boolean lM() {
        return this.cVM.lM();
    }

    public void setMicroAppId(String str) {
        this.mMicroAppId = str;
    }
}
