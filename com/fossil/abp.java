package com.fossil;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.util.concurrent.ScheduledExecutorService;

@TargetApi(14)
class abp extends abz {
    private final Application aHr;
    private final ActivityLifecycleCallbacks aHs = new C15601(this);

    class C15601 implements ActivityLifecycleCallbacks {
        final /* synthetic */ abp aHt;

        C15601(abp com_fossil_abp) {
            this.aHt = com_fossil_abp;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            this.aHt.m2882p(activity);
        }

        public void onActivityDestroyed(Activity activity) {
            this.aHt.m2883q(activity);
        }

        public void onActivityPaused(Activity activity) {
            this.aHt.m2884r(activity);
        }

        public void onActivityResumed(Activity activity) {
            this.aHt.m2885s(activity);
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            this.aHt.m2886t(activity);
        }

        public void onActivityStarted(Activity activity) {
            this.aHt.m2887u(activity);
        }

        public void onActivityStopped(Activity activity) {
            this.aHt.m2888v(activity);
        }
    }

    public static abp m2889a(Application application, acb com_fossil_acb, abx com_fossil_abx, eov com_fossil_eov) {
        ScheduledExecutorService ml = enl.ml("Crashlytics Trace Manager");
        return new abp(com_fossil_acb, new acd(application, new abr(application, ml, com_fossil_abx, com_fossil_eov), com_fossil_abx, ml), application);
    }

    abp(acb com_fossil_acb, acd com_fossil_acd, Application application) {
        super(com_fossil_acb, com_fossil_acd);
        this.aHr = application;
        CommonUtils.Z(abn.xg().getContext(), "Registering activity lifecycle callbacks for session analytics.");
        application.registerActivityLifecycleCallbacks(this.aHs);
    }

    public void disable() {
        CommonUtils.Z(abn.xg().getContext(), "Unregistering activity lifecycle callbacks for session analytics");
        this.aHr.unregisterActivityLifecycleCallbacks(this.aHs);
        super.disable();
    }
}
