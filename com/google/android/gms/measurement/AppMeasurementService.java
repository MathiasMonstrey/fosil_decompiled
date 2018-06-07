package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.fossil.brv;
import com.fossil.bry;

public final class AppMeasurementService extends Service implements bry {
    private brv bJP;

    private final brv TL() {
        if (this.bJP == null) {
            this.bJP = new brv(this);
        }
        return this.bJP;
    }

    public final void m14284a(JobParameters jobParameters, boolean z) {
        throw new UnsupportedOperationException();
    }

    public final Context getContext() {
        return this;
    }

    public final boolean ii(int i) {
        return stopSelfResult(i);
    }

    public final IBinder onBind(Intent intent) {
        return TL().onBind(intent);
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

    public final int onStartCommand(Intent intent, int i, int i2) {
        TL().onStartCommand(intent, i, i2);
        AppMeasurementReceiver.c(intent);
        return 2;
    }

    public final boolean onUnbind(Intent intent) {
        return TL().onUnbind(intent);
    }
}
