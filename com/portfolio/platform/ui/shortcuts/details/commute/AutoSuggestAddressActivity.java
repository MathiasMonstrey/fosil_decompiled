package com.portfolio.platform.ui.shortcuts.details.commute;

import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;
import com.fossil.arp;
import com.fossil.atn;
import com.fossil.atv;
import com.fossil.atv.a;
import com.fossil.atv.b;
import com.fossil.atv.c;
import com.fossil.but;
import com.fossil.buv;
import com.fossil.bvd;
import com.fossil.ckj;
import com.fossil.cmj;
import com.fossil.ew;
import com.fossil.wearables.fossil.R;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import java.util.HashMap;
import java.util.Map;

public class AutoSuggestAddressActivity extends ew implements OnClickListener, OnItemClickListener, b, c {
    public static final String TAG = AutoSuggestAddressActivity.class.getSimpleName();
    private static final LatLngBounds cVK = new LatLngBounds(new LatLng(-34.041458d, 150.7901d), new LatLng(-33.682247d, 151.383362d));
    private String cLm;
    protected AutoCompleteTextView cVH;
    private ckj cVI;
    private String cVJ;
    private atv cph;

    class C49521 extends DataSetObserver {
        final /* synthetic */ AutoSuggestAddressActivity cVL;

        C49521(AutoSuggestAddressActivity autoSuggestAddressActivity) {
            this.cVL = autoSuggestAddressActivity;
        }

        public void onChanged() {
            super.onChanged();
            this.cVL.lf(3);
        }
    }

    public static void m15742a(Fragment fragment, int i, Bundle bundle) {
        Intent intent = new Intent(fragment.getContext(), AutoSuggestAddressActivity.class);
        if (!(bundle == null || bundle.isEmpty())) {
            intent.putExtra("MICRO_APP_DATA", bundle);
        }
        fragment.startActivityForResult(intent, i);
    }

    public void onCreate(Bundle bundle) {
        MFLogger.d(TAG, "onCreate");
        super.onCreate(bundle);
        setContentView(R.layout.suggest_text_layout);
        this.cVH = (AutoCompleteTextView) findViewById(R.id.autocomplete_places);
        this.cVH.setHint(arp.u(this, R.string.Shortcuts_Search_Text_Enter_Address));
        findViewById(R.id.close_iv).setOnClickListener(this);
        findViewById(R.id.back_iv).setOnClickListener(this);
        if (this.cph == null) {
            this.cph = new a(this).a(this, 0, this).b(this).c(this).c(bvd.bGP).c(but.bfF).KI();
            this.cph.connect();
        } else if (!(this.cph.isConnecting() || this.cph.isConnected())) {
            this.cph.reconnect();
        }
        Bundle bundleExtra = getIntent().getBundleExtra("MICRO_APP_DATA");
        if (!(bundleExtra == null || bundleExtra.isEmpty())) {
            this.cVJ = bundleExtra.getString("COMMUTE_APP_ID", "");
            if (!TextUtils.isEmpty(this.cVJ)) {
                lf(2);
            }
        }
        this.cVH.setOnItemClickListener(this);
        this.cVH.setDropDownBackgroundDrawable(getResources().getDrawable(R.drawable.autocomplete_dropdown));
    }

    public void onStart() {
        super.onStart();
    }

    public void onResume() {
        super.onResume();
        if (this.cph != null && !this.cph.isConnected() && !this.cph.isConnecting()) {
            this.cph.connect();
        }
    }

    public void onPause() {
        super.onPause();
    }

    public void onStop() {
        super.onStop();
        this.cph.c(this);
        this.cph.disconnect();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.close_iv:
                this.cLm = "";
                this.cVH.setText("");
                return;
            case R.id.back_iv:
                finish();
                return;
            default:
                return;
        }
    }

    public void finish() {
        if (this.cLm == null || this.cLm.isEmpty()) {
            setResult(0);
        } else {
            Intent intent = new Intent();
            intent.putExtra("ADDRESS", this.cLm);
            setResult(-1, intent);
        }
        super.finish();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.cVI != null) {
            buv jw = this.cVI.jw(i);
            if (jw != null) {
                CharSequence a = jw.a(null);
                this.cLm = a.toString();
                finish();
                MFLogger.i(TAG, "Autocomplete item selected: " + a);
            }
        }
    }

    public void m15746l(Bundle bundle) {
        MFLogger.d(TAG, "onConnected");
        this.cVI = new ckj(this, this.cph, cVK, null);
        this.cVH.setAdapter(this.cVI);
        this.cVI.registerDataSetObserver(new C49521(this));
    }

    public void hr(int i) {
        MFLogger.d(TAG, "onConnectionSuspended error=" + i);
    }

    public void m15744a(atn com_fossil_atn) {
        MFLogger.d(TAG, "onConnectionFailed");
    }

    private void lf(int i) {
        if (i >= 1 && i <= 3 && !TextUtils.isEmpty(this.cVJ)) {
            Map hashMap = new HashMap();
            hashMap.put("Step", String.valueOf(i));
            hashMap.put("App", this.cVJ);
            m15745f("microapp_configure", hashMap);
        }
    }

    protected void m15745f(String str, Map<String, String> map) {
        cmj.bs(PortfolioApp.ZQ()).e(str, map);
    }
}
