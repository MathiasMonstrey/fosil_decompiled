package com.fossil;

import com.fossil.ckb.C2126d;
import com.fossil.ckb.C2131a;
import com.fossil.dii.C2797a;
import com.fossil.dii.C2807b;
import com.fossil.djo.C2846a;
import com.fossil.djo.C2847b;
import com.fossil.dkc.C2872a;
import com.fossil.dkc.C2873b;
import com.google.gson.JsonSyntaxException;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.microapp.MicroAppSetting;
import com.portfolio.platform.data.model.microapp.goaltracking.GoalTrackingSettings;
import java.util.Calendar;
import java.util.Date;

public class dik implements C2797a {
    private static final String TAG = dik.class.getSimpleName();
    private djo cCL;
    private dkc cCM;
    private fj cFC;
    private GoalTrackingSettings cWe;
    private C2807b cWs;
    private MicroAppSetting cWt;
    private boolean cWu = false;
    private cnr mSharedPreferencesManager;
    private ckc mUseCaseHandler;

    public dik(C2807b c2807b, djo com_fossil_djo, dkc com_fossil_dkc, ckc com_fossil_ckc, cnr com_fossil_cnr, fj fjVar) {
        this.cWs = (C2807b) emj.ce(c2807b);
        this.cCL = (djo) emj.m10873f(com_fossil_djo, "getMicroAppSetting can not be null");
        this.cCM = (dkc) emj.m10873f(com_fossil_dkc, "saveMicroAppSetting can not be null");
        this.mUseCaseHandler = (ckc) emj.m10873f(com_fossil_ckc, "useCaseHandler can not be null");
        this.mSharedPreferencesManager = (cnr) emj.m10873f(com_fossil_cnr, "sharedPreferencesManager can not be null");
        this.cFC = (fj) emj.ce(fjVar);
    }

    public boolean apo() {
        return this.cWe != null;
    }

    public void apv() {
        if (this.cWt != null) {
            this.cWs.iM(this.cWt.getMicroAppId());
        }
    }

    public void cZ(boolean z) {
        this.cWu = z;
    }

    public void mo2481e(MicroAppSetting microAppSetting) {
        MFLogger.m12670d(TAG, "load goal tracking setting");
        this.cWt = microAppSetting;
        m8767i(this.cWt);
    }

    public void apf() {
    }

    public void apg() {
        MFLogger.m12670d(TAG, "startRefreshGoalTrackingRingChart");
        if (this.cWe != null) {
            this.cWs.mo2499a(this.cWu, this.cWe);
        }
    }

    public void aph() {
        lg(1);
    }

    public void api() {
        lg(-1);
    }

    public void apj() {
        iN(this.cWt.getMicroAppId());
    }

    private void m8767i(MicroAppSetting microAppSetting) {
        int i;
        int i2 = 1;
        String setting = microAppSetting.getSetting() != null ? microAppSetting.getSetting() : "";
        this.cWe = new GoalTrackingSettings();
        if (!(setting == null || setting.isEmpty())) {
            try {
                this.cWe = (GoalTrackingSettings) new cfj().m6205c(setting, GoalTrackingSettings.class);
                i = 0;
            } catch (JsonSyntaxException e) {
                MFLogger.m12670d(TAG, "Error get goal tracking from extraInfo");
            }
            if (cmq.m7108a(this.cWe.getUpdatedDate(), Calendar.getInstance().getTime())) {
                this.cWe.setValue(0);
                this.cWe.setUpdatedDate(Calendar.getInstance().getTime());
            } else {
                i2 = 0;
            }
            if (!(i == 0 && r2 == 0)) {
                apQ();
            }
            m8765c(this.cWe);
        }
        i = 1;
        if (cmq.m7108a(this.cWe.getUpdatedDate(), Calendar.getInstance().getTime())) {
            i2 = 0;
        } else {
            this.cWe.setValue(0);
            this.cWe.setUpdatedDate(Calendar.getInstance().getTime());
        }
        apQ();
        m8765c(this.cWe);
    }

    private void iN(final String str) {
        MFLogger.m12670d(TAG, "loadGoalSettings, microAppId: " + str);
        this.mUseCaseHandler.m6886a(this.cCL, new C2846a(str), new C2126d<C2847b, C2131a>(this) {
            final /* synthetic */ dik cWv;

            public /* synthetic */ void onError(Object obj) {
                m8759a((C2131a) obj);
            }

            public /* synthetic */ void onSuccess(Object obj) {
                m8760a((C2847b) obj);
            }

            public void m8760a(C2847b c2847b) {
                MFLogger.m12670d(dik.TAG, "loadGoalSettings onSuccess");
                this.cWv.m8764a(c2847b.aqu(), str);
            }

            public void m8759a(C2131a c2131a) {
                MFLogger.m12670d(dik.TAG, "loadGoalSettings onError");
                this.cWv.m8764a(null, str);
            }
        });
    }

    private void lg(int i) {
        if (this.cWe != null) {
            this.cWe.setValue(this.cWe.getValue() + i);
            this.cWe.setUpdatedDate(Calendar.getInstance().getTime());
            apQ();
            this.cWs.mo2499a(this.cWu, this.cWe);
            m8765c(this.cWe);
        }
    }

    private void m8764a(MicroAppSetting microAppSetting, String str) {
        if (microAppSetting != null) {
            this.cWt = microAppSetting;
        } else {
            this.cWt = new MicroAppSetting(str, "");
        }
        mo2481e(this.cWt);
        this.cWs.mo2499a(this.cWu, this.cWe);
    }

    private void apQ() {
        final String toJson = new cfj().toJson(this.cWe);
        this.cWt.setSetting(toJson);
        this.mUseCaseHandler.m6886a(this.cCM, new C2872a(this.cWt), new C2126d<C2873b, C2131a>(this) {
            final /* synthetic */ dik cWv;

            public /* synthetic */ void onError(Object obj) {
                m8761a((C2131a) obj);
            }

            public /* synthetic */ void onSuccess(Object obj) {
                m8762a((C2873b) obj);
            }

            public void m8762a(C2873b c2873b) {
                MFLogger.m12670d(dik.TAG, "saveSettings onSuccess settingJson=" + toJson);
            }

            public void m8761a(C2131a c2131a) {
                MFLogger.m12670d(dik.TAG, "saveSettings onError settingJson=" + toJson);
            }
        });
    }

    private void m8765c(GoalTrackingSettings goalTrackingSettings) {
        if (m8766d(goalTrackingSettings)) {
            this.mSharedPreferencesManager.m7240a(PortfolioApp.ZQ().aaa(), this.cWe.getGoalId(), new Date());
            this.cWs.apO();
        }
    }

    private boolean m8766d(GoalTrackingSettings goalTrackingSettings) {
        if (goalTrackingSettings.getValue() < goalTrackingSettings.getTarget() || cmq.m7114c(this.mSharedPreferencesManager.m7239B(PortfolioApp.ZQ().aaa(), goalTrackingSettings.getGoalId())).booleanValue()) {
            return false;
        }
        return true;
    }
}
