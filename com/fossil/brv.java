package com.fossil;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;

public final class brv {
    private final bry bDh;
    private final Context mContext;

    public brv(bry com_fossil_bry) {
        this.mContext = com_fossil_bry.getContext();
        awa.bO(this.mContext);
        this.bDh = com_fossil_bry;
    }

    private final bol Pf() {
        return bpk.aR(this.mContext).Pf();
    }

    private final void m5572a(Integer num, JobParameters jobParameters) {
        bpk aR = bpk.aR(this.mContext);
        aR.Pe().m5469h(new brw(this, aR, num, aR.Pf(), jobParameters));
    }

    public static boolean m5573g(Context context, boolean z) {
        awa.bO(context);
        return VERSION.SDK_INT >= 24 ? bsk.m5594t(context, "com.google.android.gms.measurement.AppMeasurementJobService") : bsk.m5594t(context, "com.google.android.gms.measurement.AppMeasurementService");
    }

    public final IBinder onBind(Intent intent) {
        if (intent == null) {
            Pf().Rc().log("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new bpp(bpk.aR(this.mContext));
        }
        Pf().Re().m5439d("onBind received unknown action", action);
        return null;
    }

    public final void onCreate() {
        bol Pf = bpk.aR(this.mContext).Pf();
        bnm.Qh();
        Pf.Ri().log("Local AppMeasurementService is starting up");
    }

    public final void onDestroy() {
        bol Pf = bpk.aR(this.mContext).Pf();
        bnm.Qh();
        Pf.Ri().log("Local AppMeasurementService is shutting down");
    }

    public final void onRebind(Intent intent) {
        if (intent == null) {
            Pf().Rc().log("onRebind called with null intent");
            return;
        }
        Pf().Ri().m5439d("onRebind called. action", intent.getAction());
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        bol Pf = bpk.aR(this.mContext).Pf();
        if (intent == null) {
            Pf.Re().log("AppMeasurementService started with null intent");
        } else {
            String action = intent.getAction();
            bnm.Qh();
            Pf.Ri().m5437a("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
            if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
                m5572a(Integer.valueOf(i2), null);
            }
        }
        return 2;
    }

    @TargetApi(24)
    public final boolean onStartJob(JobParameters jobParameters) {
        bol Pf = bpk.aR(this.mContext).Pf();
        String string = jobParameters.getExtras().getString("action");
        bnm.Qh();
        Pf.Ri().m5439d("Local AppMeasurementJobService called. action", string);
        if ("com.google.android.gms.measurement.UPLOAD".equals(string)) {
            m5572a(null, jobParameters);
        }
        return true;
    }

    public final boolean onUnbind(Intent intent) {
        if (intent == null) {
            Pf().Rc().log("onUnbind called with null intent");
        } else {
            Pf().Ri().m5439d("onUnbind called for intent. action", intent.getAction());
        }
        return true;
    }
}
