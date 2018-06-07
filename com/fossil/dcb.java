package com.fossil;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.fossil.dbx.C2638a;
import com.fossil.dbx.C2639b;
import com.fossil.fj.C2426a;
import com.fossil.wearables.fsl.shared.BaseFeatureModel;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.source.loader.NotificationsLoader;
import java.util.List;

public class dcb implements C2638a, C2426a<SparseArray<List<BaseFeatureModel>>> {
    private final String TAG = getClass().getSimpleName();
    private final gy cEa;
    private fj cFC;
    private final BroadcastReceiver cFN = new C26451(this);
    private NotificationsLoader cOM;
    private final C2639b cOY;
    private final ddb cOZ;
    private final cnr mSharedPreferencesManager;
    private ckc mUseCaseHandler;

    class C26451 extends BroadcastReceiver {
        final /* synthetic */ dcb cPa;

        C26451(dcb com_fossil_dcb) {
            this.cPa = com_fossil_dcb;
        }

        public void onReceive(Context context, Intent intent) {
            String stringExtra = intent.getStringExtra("SERIAL");
            if (!TextUtils.isEmpty(stringExtra) && stringExtra.equalsIgnoreCase(PortfolioApp.ZQ().aaa())) {
                MFLogger.m12670d(this.cPa.TAG, "Inside .syncReceiver syncResult=" + intent.getIntExtra("sync_result", 3) + ",  serial=" + stringExtra);
                this.cPa.cOY.cD(false);
            }
        }
    }

    dcb(C2639b c2639b, gy gyVar, fj fjVar, cnr com_fossil_cnr, NotificationsLoader notificationsLoader, ddb com_fossil_ddb, ckc com_fossil_ckc) {
        this.cOY = (C2639b) cco.m5996s(c2639b, "view cannot be nulL!");
        this.cEa = (gy) emj.m10873f(gyVar, "localBroadcastManager cannot be null!");
        this.cOY.cK(this);
        this.mSharedPreferencesManager = com_fossil_cnr;
        this.cOM = notificationsLoader;
        this.cFC = fjVar;
        this.cOZ = (ddb) cco.m5996s(com_fossil_ddb, "mRemoveRedundantContact cannot be nulL!");
        this.mUseCaseHandler = com_fossil_ckc;
    }

    public void ahu() {
        this.cOY.cK(this);
    }

    public void start() {
        MFLogger.m12670d(this.TAG, ".Inside presenter start");
        if (this.cFC.aN(20) != null) {
            this.cFC.destroyLoader(20);
        }
        this.cFC.mo3100a(20, null, this);
        if (!this.mSharedPreferencesManager.acS()) {
            this.cOY.alu();
        }
        this.cEa.m11537a(this.cFN, new IntentFilter("BROADCAST_SYNC_COMPLETE"));
        this.cOY.cD(TextUtils.isEmpty(PortfolioApp.ZQ().aaa()));
    }

    public void stop() {
        MFLogger.m12670d(this.TAG, "stop");
        this.cEa.unregisterReceiver(this.cFN);
    }

    public void alt() {
        MFLogger.m12670d(this.TAG, "finishAddTooltip");
        this.mSharedPreferencesManager.bW(true);
        cmj.bs(PortfolioApp.ZQ()).m7086l("tooltip_dismiss", "Subject", "1st_Notifications_Tooltip");
    }

    public void sync() {
        MFLogger.m12670d(this.TAG, "sync");
        PortfolioApp.ZQ().m12698e(false, 12);
    }

    public gx<SparseArray<List<BaseFeatureModel>>> mo2137b(int i, Bundle bundle) {
        MFLogger.m12670d(this.TAG, "Inside .onCreateLoader id=" + i);
        return this.cOM;
    }

    public void m8202a(gx<SparseArray<List<BaseFeatureModel>>> gxVar, SparseArray<List<BaseFeatureModel>> sparseArray) {
        MFLogger.m12670d(this.TAG, "Inside .onLoadFinished allNotifications=" + sparseArray);
        this.cOY.mo2250b(sparseArray);
    }

    public void mo2129a(gx<SparseArray<List<BaseFeatureModel>>> gxVar) {
    }
}
