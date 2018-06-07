package com.fossil;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

@TargetApi(14)
final class bqx implements ActivityLifecycleCallbacks {
    private /* synthetic */ bqk bCm;

    private bqx(bqk com_fossil_bqk) {
        this.bCm = com_fossil_bqk;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        try {
            this.bCm.Pf().Ri().log("onActivityCreated");
            Intent intent = activity.getIntent();
            if (intent != null) {
                Uri data = intent.getData();
                if (data != null && data.isHierarchical()) {
                    if (bundle == null) {
                        Bundle j = this.bCm.Pb().m5609j(data);
                        this.bCm.Pb();
                        String str = bsk.m5593j(intent) ? "gs" : "auto";
                        if (j != null) {
                            this.bCm.m5539a(str, "_cmp", j);
                        }
                    }
                    Object queryParameter = data.getQueryParameter("referrer");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        Object obj = (queryParameter.contains("gclid") && (queryParameter.contains("utm_campaign") || queryParameter.contains("utm_source") || queryParameter.contains("utm_medium") || queryParameter.contains("utm_term") || queryParameter.contains("utm_content"))) ? 1 : null;
                        if (obj == null) {
                            this.bCm.Pf().Rh().log("Activity created with data 'referrer' param without gclid and at least one utm field");
                            return;
                        }
                        this.bCm.Pf().Rh().m5439d("Activity created with referrer", queryParameter);
                        if (!TextUtils.isEmpty(queryParameter)) {
                            this.bCm.m5542a("auto", "_ldl", queryParameter);
                        }
                    } else {
                        return;
                    }
                }
            }
        } catch (Throwable th) {
            this.bCm.Pf().Rc().m5439d("Throwable caught in onActivityCreated", th);
        }
        bqy OW = this.bCm.OW();
        if (bundle != null) {
            Bundle bundle2 = bundle.getBundle("com.google.firebase.analytics.screen_service");
            if (bundle2 != null) {
                brb y = OW.m5548y(activity);
                y.bJN = bundle2.getLong("id");
                y.bJL = bundle2.getString("name");
                y.bJM = bundle2.getString("referrer_name");
            }
        }
    }

    public final void onActivityDestroyed(Activity activity) {
        this.bCm.OW().onActivityDestroyed(activity);
    }

    public final void onActivityPaused(Activity activity) {
        this.bCm.OW().onActivityPaused(activity);
        brz Pd = this.bCm.Pd();
        Pd.Pe().m5469h(new bsd(Pd, Pd.OX().elapsedRealtime()));
    }

    public final void onActivityResumed(Activity activity) {
        this.bCm.OW().onActivityResumed(activity);
        brz Pd = this.bCm.Pd();
        Pd.Pe().m5469h(new bsc(Pd, Pd.OX().elapsedRealtime()));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.bCm.OW().onActivitySaveInstanceState(activity, bundle);
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }
}
