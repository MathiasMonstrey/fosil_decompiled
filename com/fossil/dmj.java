package com.fossil;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.fossil.dmh.C2922a;
import com.fossil.dmh.C2958b;
import com.fossil.dmm.C2966a;
import com.fossil.dmt.C2974a;
import com.fossil.fj.C2426a;
import com.fossil.wearables.fsl.sleep.MFSleepSession;
import com.misfit.ble.shine.ShineProfile;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.MFUser;
import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.data.source.loader.SleepSessionsDayLoader;
import java.util.Date;
import java.util.List;

public class dmj implements C2922a {
    private static final String TAG = dmj.class.getSimpleName();
    private final gy cEa;
    private final fj cFC;
    private final BroadcastReceiver cFN = new C29642(this);
    private final PortfolioApp cIo;
    private final Runnable cIw = new C29631(this);
    private final C2958b dac;
    private final SleepSessionsDayLoader dad;
    private final dmt dae;
    private final dmm daf;
    private Date mDate;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final cnr mSharedPreferencesManager;
    private final ckc mUseCaseHandler;
    private final UserRepository mUserRepository;

    class C29631 implements Runnable {
        final /* synthetic */ dmj dag;

        C29631(dmj com_fossil_dmj) {
            this.dag = com_fossil_dmj;
        }

        public void run() {
            this.dag.aiI();
        }
    }

    class C29642 extends BroadcastReceiver {
        final /* synthetic */ dmj dag;

        C29642(dmj com_fossil_dmj) {
            this.dag = com_fossil_dmj;
        }

        public void onReceive(Context context, Intent intent) {
            String stringExtra = intent.getStringExtra("SERIAL");
            if (!TextUtils.isEmpty(stringExtra) && stringExtra.equalsIgnoreCase(this.dag.cIo.aaa())) {
                int intExtra = intent.getIntExtra("sync_result", 3);
                MFLogger.m12670d(dmj.TAG, "Inside .syncReceiver syncResult=" + intExtra + ",  serial=" + stringExtra);
                switch (intExtra) {
                    case 0:
                        this.dag.dac.aJ(-1);
                        break;
                    case 1:
                        this.dag.dac.aJ(this.dag.mSharedPreferencesManager.gC(PortfolioApp.ZQ().aaa()));
                        break;
                }
                this.dag.mHandler.removeCallbacksAndMessages(null);
                this.dag.aiI();
            }
        }
    }

    class C29653 implements C2426a<jt<List<MFSleepSession>, Integer>> {
        final /* synthetic */ dmj dag;

        C29653(dmj com_fossil_dmj) {
            this.dag = com_fossil_dmj;
        }

        public gx<jt<List<MFSleepSession>, Integer>> mo2137b(int i, Bundle bundle) {
            MFLogger.m12670d(dmj.TAG, "LOADER_SLEEP_SESSIONS_DAY onCreateLoader: mDate = " + this.dag.mDate);
            if (this.dag.mDate == null) {
                return null;
            }
            MFUser currentUser = this.dag.mUserRepository.getCurrentUser();
            if (currentUser == null || cmq.fZ(currentUser.getCreatedAt()).getTime() > this.dag.mDate.getTime()) {
                return null;
            }
            this.dag.mUseCaseHandler.m6886a(this.dag.daf, new C2966a(this.dag.mDate, false), null);
            this.dag.mUseCaseHandler.m6886a(this.dag.dae, new C2974a(this.dag.mDate, false), null);
            this.dag.dad.setDate(this.dag.mDate);
            return this.dag.dad;
        }

        public void m9078a(gx<jt<List<MFSleepSession>, Integer>> gxVar, jt<List<MFSleepSession>, Integer> jtVar) {
            MFLogger.m12670d(dmj.TAG, "LOADER_SLEEP_SESSIONS_DAY onLoadFinished: data = " + jtVar.first + ", sleepGoal=" + jtVar.second);
            this.dag.dac.mo2566h((List) jtVar.first, ((Integer) jtVar.second).intValue());
        }

        public void mo2129a(gx<jt<List<MFSleepSession>, Integer>> gxVar) {
            MFLogger.m12670d(dmj.TAG, "LOADER_SLEEP_SESSIONS_DAY onLoaderReset");
        }
    }

    dmj(PortfolioApp portfolioApp, C2958b c2958b, cnr com_fossil_cnr, gy gyVar, fj fjVar, SleepSessionsDayLoader sleepSessionsDayLoader, ckc com_fossil_ckc, dmm com_fossil_dmm, dmt com_fossil_dmt, UserRepository userRepository) {
        this.cIo = portfolioApp;
        this.dac = c2958b;
        this.mSharedPreferencesManager = com_fossil_cnr;
        this.cEa = gyVar;
        this.cFC = fjVar;
        this.dad = sleepSessionsDayLoader;
        this.mUseCaseHandler = com_fossil_ckc;
        this.daf = com_fossil_dmm;
        this.dae = com_fossil_dmt;
        this.mUserRepository = userRepository;
    }

    public void ahu() {
        this.dac.cK(this);
    }

    public void arI() {
        MFLogger.m12670d(TAG, "startStatsSleepDay");
        this.cEa.m11537a(this.cFN, new IntentFilter("BROADCAST_SYNC_COMPLETE"));
        this.dac.mo2567u(this.mDate == null ? new Date() : this.mDate);
        this.cFC.mo3100a(9, null, new C29653(this));
        aiI();
    }

    public void arJ() {
        MFLogger.m12670d(TAG, "stopStatsSleepDay");
        this.mHandler.removeCallbacks(this.cIw);
        this.cEa.unregisterReceiver(this.cFN);
    }

    public void arw() {
        MFLogger.m12670d(TAG, "editInfo");
    }

    public void ary() {
        MFLogger.m12670d(TAG, "doSleepOverview");
    }

    public void arA() {
        MFLogger.m12670d(TAG, "doStatsSleepMonth");
    }

    private void aiI() {
        String aaa = this.cIo.aaa();
        if (!TextUtils.isEmpty(aaa)) {
            if (this.cIo.isSyncing(aaa) || this.mSharedPreferencesManager.gU(aaa) == 0) {
                this.dac.aJ(-1);
            } else {
                this.dac.aJ(this.mSharedPreferencesManager.gC(aaa));
            }
            this.mHandler.postDelayed(this.cIw, ShineProfile.LOG_UPLOADING_DELAY);
        }
    }

    public void setDate(Date date) {
        this.mDate = date;
        if (this.cFC.aN(9) != null) {
            this.cFC.destroyLoader(9);
        }
    }
}
