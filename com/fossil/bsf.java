package com.fossil;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.PersistableBundle;
import com.misfit.frameworks.buttonservice.model.Alarm;

public final class bsf extends bqi {
    private final AlarmManager bDq = ((AlarmManager) super.getContext().getSystemService(Alarm.TABLE_NAME));
    private final bnr bDr;
    private Integer bDs;

    protected bsf(bpk com_fossil_bpk) {
        super(com_fossil_bpk);
        this.bDr = new bsg(this, com_fossil_bpk);
    }

    @TargetApi(24)
    private final void Sf() {
        JobScheduler jobScheduler = (JobScheduler) super.getContext().getSystemService("jobscheduler");
        super.Pf().Ri().m5439d("Cancelling job. JobID", Integer.valueOf(getJobId()));
        jobScheduler.cancel(getJobId());
    }

    private final PendingIntent Sg() {
        Intent intent = new Intent();
        Context context = super.getContext();
        bnm.Qh();
        intent = intent.setClassName(context, "com.google.android.gms.measurement.AppMeasurementReceiver");
        intent.setAction("com.google.android.gms.measurement.UPLOAD");
        return PendingIntent.getBroadcast(super.getContext(), 0, intent, 0);
    }

    private final void Sh() {
        Intent intent = new Intent();
        Context context = super.getContext();
        bnm.Qh();
        intent = intent.setClassName(context, "com.google.android.gms.measurement.AppMeasurementReceiver");
        intent.setAction("com.google.android.gms.measurement.UPLOAD");
        super.getContext().sendBroadcast(intent);
    }

    private final int getJobId() {
        if (this.bDs == null) {
            String str = "measurement";
            String valueOf = String.valueOf(super.getContext().getPackageName());
            this.bDs = Integer.valueOf((valueOf.length() != 0 ? str.concat(valueOf) : new String(str)).hashCode());
        }
        return this.bDs.intValue();
    }

    public final /* bridge */ /* synthetic */ void OM() {
        super.OM();
    }

    public final /* bridge */ /* synthetic */ void ON() {
        super.ON();
    }

    public final /* bridge */ /* synthetic */ void OO() {
        super.OO();
    }

    public final /* bridge */ /* synthetic */ void OP() {
        super.OP();
    }

    public final /* bridge */ /* synthetic */ bnc OQ() {
        return super.OQ();
    }

    public final /* bridge */ /* synthetic */ bnj OR() {
        return super.OR();
    }

    public final /* bridge */ /* synthetic */ bqk OS() {
        return super.OS();
    }

    public final /* bridge */ /* synthetic */ bog OT() {
        return super.OT();
    }

    public final /* bridge */ /* synthetic */ bnt OU() {
        return super.OU();
    }

    public final /* bridge */ /* synthetic */ brc OV() {
        return super.OV();
    }

    public final /* bridge */ /* synthetic */ bqy OW() {
        return super.OW();
    }

    public final /* bridge */ /* synthetic */ axm OX() {
        return super.OX();
    }

    public final /* bridge */ /* synthetic */ boh OY() {
        return super.OY();
    }

    public final /* bridge */ /* synthetic */ bnn OZ() {
        return super.OZ();
    }

    protected final void PH() {
        this.bDq.cancel(Sg());
        if (VERSION.SDK_INT >= 24) {
            Sf();
        }
    }

    public final /* bridge */ /* synthetic */ boj Pa() {
        return super.Pa();
    }

    public final /* bridge */ /* synthetic */ bsk Pb() {
        return super.Pb();
    }

    public final /* bridge */ /* synthetic */ bpf Pc() {
        return super.Pc();
    }

    public final /* bridge */ /* synthetic */ brz Pd() {
        return super.Pd();
    }

    public final /* bridge */ /* synthetic */ bpg Pe() {
        return super.Pe();
    }

    public final /* bridge */ /* synthetic */ bol Pf() {
        return super.Pf();
    }

    public final /* bridge */ /* synthetic */ bow Pg() {
        return super.Pg();
    }

    public final /* bridge */ /* synthetic */ bnm Ph() {
        return super.Ph();
    }

    public final void ak(long j) {
        RA();
        bnm.Qh();
        if (!bpc.m5452f(super.getContext(), false)) {
            super.Pf().Rh().log("Receiver not registered/enabled");
        }
        bnm.Qh();
        if (!brv.m5573g(super.getContext(), false)) {
            super.Pf().Rh().log("Service not registered/enabled");
        }
        cancel();
        long elapsedRealtime = super.OX().elapsedRealtime() + j;
        if (j < bnm.Qz() && !this.bDr.QU()) {
            super.Pf().Ri().log("Scheduling upload with DelayedRunnable");
            this.bDr.ak(j);
        }
        bnm.Qh();
        if (VERSION.SDK_INT >= 24) {
            super.Pf().Ri().log("Scheduling upload with JobScheduler");
            JobScheduler jobScheduler = (JobScheduler) super.getContext().getSystemService("jobscheduler");
            Builder builder = new Builder(getJobId(), new ComponentName(super.getContext(), "com.google.android.gms.measurement.AppMeasurementJobService"));
            builder.setMinimumLatency(j);
            builder.setOverrideDeadline(j << 1);
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
            builder.setExtras(persistableBundle);
            JobInfo build = builder.build();
            super.Pf().Ri().m5439d("Scheduling job. JobID", Integer.valueOf(getJobId()));
            jobScheduler.schedule(build);
            return;
        }
        super.Pf().Ri().log("Scheduling upload with AlarmManager");
        this.bDq.setInexactRepeating(2, elapsedRealtime, Math.max(bnm.QA(), j), Sg());
    }

    public final void cancel() {
        RA();
        this.bDq.cancel(Sg());
        this.bDr.cancel();
        if (VERSION.SDK_INT >= 24) {
            Sf();
        }
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }
}
