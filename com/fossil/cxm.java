package com.fossil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.fossil.cxl.C2478a;
import com.fossil.cxl.C2479b;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.util.URLHelper;
import com.portfolio.platform.util.URLHelper.Feature;
import com.portfolio.platform.util.URLHelper.StaticPage;

public final class cxm extends ctm implements C2479b {
    private static final String TAG = cxm.class.getSimpleName();
    public static final C2480a cKi = new C2480a();
    private dqo<ckt> cEY;
    private C2478a cKh;

    public static final class C2480a {
        private C2480a() {
        }

        private final String getTAG() {
            return cxm.TAG;
        }

        public final cxm ajv() {
            return new cxm();
        }
    }

    static final class C2481b implements OnClickListener {
        final /* synthetic */ cxm cKj;

        C2481b(cxm com_fossil_cxm) {
            this.cKj = com_fossil_cxm;
        }

        public final void onClick(View view) {
            this.cKj.getActivity().finish();
        }
    }

    static final class C2482c implements OnClickListener {
        final /* synthetic */ cxm cKj;

        C2482c(cxm com_fossil_cxm) {
            this.cKj = com_fossil_cxm;
        }

        public final void onClick(View view) {
            this.cKj.m7519n("device_battery_action", "Action", "Shop");
            cxm com_fossil_cxm = this.cKj;
            String a = URLHelper.a(StaticPage.FEATURES, Feature.SHOP_BATTERY, PortfolioApp.ZQ().aaa());
            esl.m11127i(a, "URLHelper.buildStaticPag…nce().activeDeviceSerial)");
            com_fossil_cxm.hY(a);
        }
    }

    static final class C2483d implements OnClickListener {
        final /* synthetic */ cxm cKj;

        C2483d(cxm com_fossil_cxm) {
            this.cKj = com_fossil_cxm;
        }

        public final void onClick(View view) {
            this.cKj.m7519n("device_battery_action", "Action", "Instruction");
            cxm com_fossil_cxm = this.cKj;
            String a = URLHelper.a(StaticPage.FEATURES, Feature.LOW_BATTERY, PortfolioApp.ZQ().aaa());
            esl.m11127i(a, "URLHelper.buildStaticPag…nce().activeDeviceSerial)");
            com_fossil_cxm.hY(a);
        }
    }

    public /* synthetic */ void cK(Object obj) {
        m7858a((C2478a) obj);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        esl.m11128j(layoutInflater, "inflater");
        ckt com_fossil_ckt = (ckt) C3311e.m10386a(layoutInflater, R.layout.device_battery_fragment, viewGroup, false, this.cEN);
        com_fossil_ckt.cqc.setOnClickListener(new C2481b(this));
        com_fossil_ckt.cql.setOnClickListener(new C2482c(this));
        com_fossil_ckt.cqk.setOnClickListener(new C2483d(this));
        this.cEY = new dqo(this, com_fossil_ckt);
        return com_fossil_ckt.dz();
    }

    public void onResume() {
        super.onResume();
        C2478a c2478a = this.cKh;
        if (c2478a == null) {
            esl.mF("mPresenter");
        }
        c2478a.start();
    }

    public void onPause() {
        super.onPause();
        C2478a c2478a = this.cKh;
        if (c2478a == null) {
            esl.mF("mPresenter");
        }
        c2478a.stop();
    }

    public void m7858a(C2478a c2478a) {
        esl.m11128j(c2478a, "presenter");
        this.cKh = c2478a;
    }

    private final void hY(String str) {
        MFLogger.m12670d(cKi.getTAG(), "startWebView: url = " + str);
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }
}
