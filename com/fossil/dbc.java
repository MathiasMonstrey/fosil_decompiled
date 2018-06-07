package com.fossil;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.fossil.dau.C2613a;
import com.fossil.dau.C2614b;
import com.fossil.fj.C2426a;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.Widget;
import com.portfolio.platform.data.source.loader.WidgetLoader;
import java.util.List;

public class dbc implements C2613a, C2426a<List<Widget>> {
    private static final String TAG = dbc.class.getSimpleName();
    private final gy cEa;
    private fj cFC;
    private final BroadcastReceiver cFN = new C26181(this);
    private C2614b cNS;
    private WidgetLoader cNT;

    class C26181 extends BroadcastReceiver {
        final /* synthetic */ dbc cNU;

        C26181(dbc com_fossil_dbc) {
            this.cNU = com_fossil_dbc;
        }

        public void onReceive(Context context, Intent intent) {
            String stringExtra = intent.getStringExtra("SERIAL");
            if (!TextUtils.isEmpty(stringExtra) && stringExtra.equalsIgnoreCase(PortfolioApp.ZQ().aaa())) {
                MFLogger.m12670d(dbc.TAG, "Inside .syncReceiver syncResult=" + intent.getIntExtra("sync_result", 3) + ",  serial=" + stringExtra);
                this.cNU.cNS.cD(false);
            }
        }
    }

    public dbc(PortfolioApp portfolioApp, C2614b c2614b, gy gyVar, fj fjVar) {
        this.cNS = (C2614b) cco.m5996s(c2614b, "HomeView cannot be null!");
        this.cEa = (gy) emj.m10873f(gyVar, "localBroadcastManager cannot be null!");
        this.cNT = new WidgetLoader(portfolioApp);
        this.cFC = fjVar;
        this.cNS.cK(this);
    }

    public void ahu() {
        this.cNS.cK(this);
    }

    public void start() {
        MFLogger.m12670d(TAG, "start");
        this.cEa.m11537a(this.cFN, new IntentFilter("BROADCAST_SYNC_COMPLETE"));
        this.cNS.cD(TextUtils.isEmpty(PortfolioApp.ZQ().aaa()));
    }

    public void stop() {
        Log.d(TAG, "stop");
        this.cEa.unregisterReceiver(this.cFN);
    }

    public gx<List<Widget>> mo2137b(int i, Bundle bundle) {
        return this.cNT;
    }

    public void m8118a(gx<List<Widget>> gxVar, List<Widget> list) {
    }

    public void mo2129a(gx<List<Widget>> gxVar) {
    }

    public void sync() {
        MFLogger.m12670d(TAG, "sync");
        PortfolioApp.ZQ().m12698e(false, 12);
    }
}
