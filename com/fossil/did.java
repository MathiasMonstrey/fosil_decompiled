package com.fossil;

import com.fossil.ckb.C2126d;
import com.fossil.ckb.C2131a;
import com.fossil.dib.C2803a;
import com.fossil.dib.C2804b;
import com.fossil.djo.C2846a;
import com.fossil.djo.C2847b;
import com.fossil.dkc.C2872a;
import com.fossil.dkc.C2873b;
import com.google.gson.JsonSyntaxException;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.microapp.MicroAppSetting;
import com.portfolio.platform.data.model.microapp.goaltracking.GoalTrackingSettings;

public class did implements C2803a {
    private static final String TAG = did.class.getSimpleName();
    private djo cCL;
    private dkc cCM;
    private GoalTrackingSettings cWe;
    private C2804b cWf;
    private MicroAppSetting cWg;
    private ckc mUseCaseHandler;

    public did(C2804b c2804b, String str, djo com_fossil_djo, dkc com_fossil_dkc, ckc com_fossil_ckc) {
        this.cWf = (C2804b) emj.ce(c2804b);
        this.cCL = (djo) emj.m10873f(com_fossil_djo, "getMicroAppSetting can not be null");
        this.cCM = (dkc) emj.m10873f(com_fossil_dkc, "saveMicroAppSetting can not be null");
        this.mUseCaseHandler = (ckc) emj.m10873f(com_fossil_ckc, "useCaseHandler can not be null");
        iL(str);
    }

    public void mo2496a(GoalTrackingSettings goalTrackingSettings) {
        final String toJson = new cfj().toJson(goalTrackingSettings);
        this.cWg.setSetting(toJson);
        this.mUseCaseHandler.m6886a(this.cCM, new C2872a(this.cWg), new C2126d<C2873b, C2131a>(this) {
            final /* synthetic */ did cWh;

            public /* synthetic */ void onError(Object obj) {
                m8740a((C2131a) obj);
            }

            public /* synthetic */ void onSuccess(Object obj) {
                m8741a((C2873b) obj);
            }

            public void m8741a(C2873b c2873b) {
                MFLogger.m12670d(did.TAG, "saveSettings onSuccess settingJson=" + toJson);
                this.cWh.cWf.cY(true);
            }

            public void m8740a(C2131a c2131a) {
                MFLogger.m12670d(did.TAG, "saveSettings onError settingJson=" + toJson);
                this.cWh.cWf.cY(true);
            }
        });
    }

    public void apG() {
        this.cWf.apI();
    }

    public void apH() {
        this.cWf.mo2494b(this.cWe);
    }

    private void iL(final String str) {
        MFLogger.m12670d(TAG, "loadGoalSettings, microAppId: " + str);
        this.mUseCaseHandler.m6886a(this.cCL, new C2846a(str), new C2126d<C2847b, C2131a>(this) {
            final /* synthetic */ did cWh;

            public /* synthetic */ void onError(Object obj) {
                m8742a((C2131a) obj);
            }

            public /* synthetic */ void onSuccess(Object obj) {
                m8743a((C2847b) obj);
            }

            public void m8743a(C2847b c2847b) {
                MFLogger.m12670d(did.TAG, "loadGoalSettings onSuccess");
                if (c2847b.aqu().getSetting() != null) {
                    this.cWh.cWg = c2847b.aqu();
                } else {
                    this.cWh.cWg = new MicroAppSetting(str, "");
                }
                this.cWh.cWe = this.cWh.m8750g(this.cWh.cWg);
                this.cWh.cWf.mo2494b(this.cWh.cWe);
            }

            public void m8742a(C2131a c2131a) {
                MFLogger.m12670d(did.TAG, "loadGoalSettings onError");
                this.cWh.cWg = new MicroAppSetting(str, "");
                this.cWh.cWe = this.cWh.m8750g(this.cWh.cWg);
                this.cWh.cWf.mo2494b(this.cWh.cWe);
            }
        });
    }

    private GoalTrackingSettings m8750g(MicroAppSetting microAppSetting) {
        MFLogger.m12670d(TAG, "load goal tracking setting");
        String setting = microAppSetting != null ? microAppSetting.getSetting() : "";
        if (setting == null || setting.isEmpty()) {
            return new GoalTrackingSettings();
        }
        GoalTrackingSettings goalTrackingSettings;
        try {
            goalTrackingSettings = (GoalTrackingSettings) new cfj().m6205c(setting, GoalTrackingSettings.class);
        } catch (JsonSyntaxException e) {
            goalTrackingSettings = new GoalTrackingSettings();
        }
        if (goalTrackingSettings == null) {
            return new GoalTrackingSettings();
        }
        return goalTrackingSettings;
    }
}
