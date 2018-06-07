package com.portfolio.platform.service;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Handler;
import com.fossil.ckb;
import com.fossil.ckb.c;
import com.fossil.ckb.d;
import com.fossil.ckc;
import com.fossil.cnm;
import com.fossil.ctf;
import com.fossil.ctf.a;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.source.UserRepository;
import java.util.concurrent.TimeUnit;

public class ExecutePendingDataService extends JobService {
    private static final String TAG = ExecutePendingDataService.class.getSimpleName();
    private boolean art = false;
    public ctf cBE;
    public ckc mUseCaseHandler;
    public UserRepository mUserRepository;

    public void onCreate() {
        super.onCreate();
        MFLogger.d(TAG, "onCreate " + this);
        PortfolioApp.ZQ().aam().a(this);
    }

    public void onDestroy() {
        super.onDestroy();
        MFLogger.d(TAG, "onDestroy " + this);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return 2;
    }

    public boolean onStartJob(final JobParameters jobParameters) {
        MFLogger.d(TAG, "onStartJob " + this);
        if (this.mUserRepository.getCurrentUser() == null || this.art) {
            MFLogger.d(TAG, "onStartJob, finishing service in next 30 seconds");
            new Handler().postDelayed(new Runnable(this) {
                final /* synthetic */ ExecutePendingDataService cCC;

                public void run() {
                    MFLogger.d(ExecutePendingDataService.TAG, "jobFinished after 30 seconds");
                    this.cCC.jobFinished(jobParameters, true);
                }
            }, TimeUnit.SECONDS.toMillis(30));
        } else {
            this.art = true;
            m15659a(jobParameters);
            cnm.abX().abY();
        }
        return true;
    }

    private void m15659a(final JobParameters jobParameters) {
        MFLogger.d(TAG, "pushPendingData");
        this.mUseCaseHandler.a(this.cBE, new a(), new d<c, ckb.a>(this) {
            final /* synthetic */ ExecutePendingDataService cCC;

            public /* synthetic */ void onError(Object obj) {
                m15657a((ckb.a) obj);
            }

            public /* synthetic */ void onSuccess(Object obj) {
                m15658a((c) obj);
            }

            public void m15658a(c cVar) {
                MFLogger.d(ExecutePendingDataService.TAG, "pushPendingData onSuccess");
                this.cCC.jobFinished(jobParameters, true);
                this.cCC.art = false;
            }

            public void m15657a(ckb.a aVar) {
                MFLogger.d(ExecutePendingDataService.TAG, "pushPendingData onError");
                this.cCC.jobFinished(jobParameters, true);
                this.cCC.art = false;
            }
        });
    }

    public boolean onStopJob(JobParameters jobParameters) {
        MFLogger.d(TAG, "onStopJob -> Somethings went wrong. Reschedule job again!");
        return true;
    }
}
