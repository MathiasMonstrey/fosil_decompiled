package com.fossil;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.fossil.ckb.C2126d;
import com.fossil.ckb.C2131a;
import com.fossil.dlj.C2919a;
import com.fossil.dlj.C2925b;
import com.fossil.dlo.C2938a;
import com.fossil.dlv.C2946a;
import com.fossil.dpf.C3051a;
import com.fossil.fj.C2426a;
import com.fossil.wearables.fsl.fitness.SampleRaw;
import com.misfit.ble.shine.ShineProfile;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.MFUser;
import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.data.source.loader.ActivitiesDayLoader;
import java.util.Date;
import java.util.List;

public class dll implements C2919a {
    private static final String TAG = dll.class.getSimpleName();
    private final gy cEa;
    private final fj cFC;
    private final BroadcastReceiver cFN = new C29352(this);
    private final PortfolioApp cIo;
    private final Runnable cIw = new C29341(this);
    private final ActivitiesDayLoader cOi;
    private final dpf cSm;
    private final C2925b cZu;
    private final dlo cZv;
    private final dlv cZw;
    private float cZx;
    private float cZy;
    private float cZz;
    private float mCalories;
    private Date mDate;
    private float mDistance;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final cnr mSharedPreferencesManager;
    private final ckc mUseCaseHandler;
    private final UserRepository mUserRepository;

    class C29341 implements Runnable {
        final /* synthetic */ dll cZA;

        C29341(dll com_fossil_dll) {
            this.cZA = com_fossil_dll;
        }

        public void run() {
            this.cZA.aiI();
        }
    }

    class C29352 extends BroadcastReceiver {
        final /* synthetic */ dll cZA;

        C29352(dll com_fossil_dll) {
            this.cZA = com_fossil_dll;
        }

        public void onReceive(Context context, Intent intent) {
            String stringExtra = intent.getStringExtra("SERIAL");
            if (!TextUtils.isEmpty(stringExtra) && stringExtra.equalsIgnoreCase(PortfolioApp.ZQ().aaa())) {
                int intExtra = intent.getIntExtra("sync_result", 3);
                MFLogger.m12670d(dll.TAG, "Inside .syncReceiver syncResult=" + intExtra + ",  serial=" + stringExtra);
                switch (intExtra) {
                    case 0:
                        this.cZA.cZu.aJ(-1);
                        break;
                    case 1:
                        this.cZA.cZu.aJ(this.cZA.mSharedPreferencesManager.gC(PortfolioApp.ZQ().aaa()));
                        break;
                }
                this.cZA.mHandler.removeCallbacksAndMessages(null);
                this.cZA.aiI();
            }
        }
    }

    class C29363 implements C2426a<jt<List<SampleRaw>, Integer>> {
        final /* synthetic */ dll cZA;

        C29363(dll com_fossil_dll) {
            this.cZA = com_fossil_dll;
        }

        public gx<jt<List<SampleRaw>, Integer>> mo2137b(int i, Bundle bundle) {
            MFLogger.m12670d(dll.TAG, "LOADER_ACTIVITIES_DAY onCreateLoader: mDate = " + this.cZA.mDate);
            if (this.cZA.mDate == null) {
                return null;
            }
            MFUser currentUser = this.cZA.mUserRepository.getCurrentUser();
            if (currentUser == null || cmq.fZ(currentUser.getCreatedAt()).getTime() > this.cZA.mDate.getTime()) {
                return null;
            }
            this.cZA.mUseCaseHandler.m6886a(this.cZA.cZw, new C2946a(this.cZA.mDate, false), null);
            this.cZA.mUseCaseHandler.m6886a(this.cZA.cZv, new C2938a(this.cZA.mDate, false), null);
            this.cZA.cOi.setDate(this.cZA.mDate);
            return this.cZA.cOi;
        }

        public void m8988a(gx<jt<List<SampleRaw>, Integer>> gxVar, jt<List<SampleRaw>, Integer> jtVar) {
            int i;
            String access$100 = dll.TAG;
            StringBuilder append = new StringBuilder().append("LOADER_ACTIVITIES_DAY onLoadFinished: data = ");
            if (jtVar.first == null) {
                i = 0;
            } else {
                i = ((List) jtVar.first).size();
            }
            MFLogger.m12670d(access$100, append.append(i).append(", stepGoal=").append(jtVar.second).toString());
            if (jtVar.first != null) {
                this.cZA.cZx = 0.0f;
                this.cZA.cZy = 0.0f;
                this.cZA.cZz = 0.0f;
                this.cZA.mDistance = 0.0f;
                this.cZA.mCalories = 0.0f;
                for (SampleRaw sampleRaw : (List) jtVar.first) {
                    switch (cmt.aC((long) (sampleRaw.getSteps() / ((double) cmq.m7113c(sampleRaw.getStartTime(), sampleRaw.getEndTime()))))) {
                        case 0:
                            this.cZA.cZz = (float) (((double) this.cZA.cZz) + sampleRaw.getSteps());
                            break;
                        case 1:
                            this.cZA.cZy = (float) (((double) this.cZA.cZy) + sampleRaw.getSteps());
                            break;
                        case 2:
                            this.cZA.cZx = (float) (((double) this.cZA.cZx) + sampleRaw.getSteps());
                            break;
                        default:
                            break;
                    }
                    this.cZA.mDistance = (float) (((double) this.cZA.mDistance) + sampleRaw.getDistance());
                    this.cZA.mCalories = (float) (((double) this.cZA.mCalories) + sampleRaw.getCalories());
                }
                this.cZA.cZu.mo2549a(this.cZA.cZz, this.cZA.cZy, this.cZA.cZx, this.cZA.mDistance, this.cZA.mCalories, ((Integer) jtVar.second).intValue());
            }
        }

        public void mo2129a(gx<jt<List<SampleRaw>, Integer>> gxVar) {
            MFLogger.m12670d(dll.TAG, "LOADER_ACTIVITIES_DAY onLoaderReset");
        }
    }

    class C29374 implements C2126d<C3051a, C2131a> {
        final /* synthetic */ dll cZA;

        C29374(dll com_fossil_dll) {
            this.cZA = com_fossil_dll;
        }

        public /* synthetic */ void onError(Object obj) {
            m8991a((C2131a) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m8992a((C3051a) obj);
        }

        public void m8992a(C3051a c3051a) {
            MFLogger.m12670d(dll.TAG, "startStatsActivityDay GetUser onSuccess");
            MFUser atE = c3051a.atE();
            C2925b b = this.cZA.cZu;
            boolean z = atE.getHeightInCentimeters() == 0 || atE.getWeightInGrams() == 0;
            b.da(z);
            this.cZA.cZu.mo2550a(atE.getDistanceUnit(), this.cZA.mDistance);
        }

        public void m8991a(C2131a c2131a) {
            MFLogger.m12670d(dll.TAG, "startStatsActivityDay GetUser onError");
        }
    }

    private void aiI() {
        String aaa = this.cIo.aaa();
        if (!TextUtils.isEmpty(aaa)) {
            if (this.cIo.isSyncing(aaa) || this.mSharedPreferencesManager.gU(aaa) == 0) {
                this.cZu.aJ(-1);
            } else {
                this.cZu.aJ(this.mSharedPreferencesManager.gC(aaa));
            }
            this.mHandler.postDelayed(this.cIw, ShineProfile.LOG_UPLOADING_DELAY);
        }
    }

    dll(C2925b c2925b, cnr com_fossil_cnr, gy gyVar, fj fjVar, ActivitiesDayLoader activitiesDayLoader, ckc com_fossil_ckc, dpf com_fossil_dpf, dlo com_fossil_dlo, dlv com_fossil_dlv, PortfolioApp portfolioApp, UserRepository userRepository) {
        this.cZu = c2925b;
        this.mSharedPreferencesManager = com_fossil_cnr;
        this.cEa = gyVar;
        this.cFC = fjVar;
        this.cOi = activitiesDayLoader;
        this.mUseCaseHandler = com_fossil_ckc;
        this.cSm = com_fossil_dpf;
        this.cZv = com_fossil_dlo;
        this.cZw = com_fossil_dlv;
        this.cIo = portfolioApp;
        this.mUserRepository = userRepository;
    }

    public void ahu() {
        this.cZu.cK(this);
    }

    public void arB() {
        MFLogger.m12670d(TAG, "startStatsActivityDay");
        this.cEa.m11537a(this.cFN, new IntentFilter("BROADCAST_SYNC_COMPLETE"));
        switch (this.mSharedPreferencesManager.acR()) {
            case 0:
                this.cZu.arP();
                break;
            case 1:
                this.cZu.arQ();
                break;
            case 2:
                this.cZu.arO();
                break;
        }
        this.cZu.mo2556u(this.mDate == null ? new Date() : this.mDate);
        this.cFC.mo3100a(6, null, new C29363(this));
        MFLogger.m12670d(TAG, "startStatsActivityDay GetUser");
        this.mUseCaseHandler.m6886a(this.cSm, null, new C29374(this));
        aiI();
    }

    public void arC() {
        MFLogger.m12670d(TAG, "stopStatsActivityDay");
        this.cEa.unregisterReceiver(this.cFN);
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void arD() {
        MFLogger.m12670d(TAG, "finishDateTooltip");
        this.mSharedPreferencesManager.jF(3);
    }

    public void arE() {
        MFLogger.m12670d(TAG, "finishInfoTooltip");
        this.mSharedPreferencesManager.jF(1);
        this.cZu.arQ();
    }

    public void arF() {
        MFLogger.m12670d(TAG, "finishChartTooltip");
        this.mSharedPreferencesManager.jF(2);
        this.cZu.arO();
    }

    public void arw() {
        MFLogger.m12670d(TAG, "editInfo");
    }

    public void arx() {
        MFLogger.m12670d(TAG, "doActivityOverview");
    }

    public void arz() {
        MFLogger.m12670d(TAG, "doStatsActivityMonth");
    }

    public void setDate(Date date) {
        this.mDate = date;
        if (this.cFC.aN(6) != null) {
            this.cFC.destroyLoader(6);
        }
    }
}
