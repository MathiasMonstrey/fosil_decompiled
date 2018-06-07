package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import com.fossil.brv;
import com.fossil.bry;

@TargetApi(24)
public final class AppMeasurementJobService extends JobService implements bry {
    private brv bJP;

    private final brv TL() {
        if (this.bJP == null) {
            this.bJP = new brv(this);
        }
        return this.bJP;
    }

    @TargetApi(24)
    public final void m14282a(JobParameters jobParameters, boolean z) {
        jobFinished(jobParameters, false);
    }

    public final Context getContext() {
        return this;
    }

    public final boolean ii(int i) {
        throw new UnsupportedOperationException();
    }

    public final void onCreate() {
        super.onCreate();
        TL().onCreate();
    }

    public final void onDestroy() {
        TL().onDestroy();
        super.onDestroy();
    }

    public final void onRebind(Intent intent) {
        TL().onRebind(intent);
    }

    public final boolean onStartJob(JobParameters jobParameters) {
        return TL().onStartJob(jobParameters);
    }

    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    public final boolean onUnbind(Intent intent) {
        return TL().onUnbind(intent);
    }
}
