package com.fossil;

import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.source.ActivitiesDataSource.PushPendingActivitiesCallback;
import com.portfolio.platform.data.source.ActivitiesRepository;
import com.portfolio.platform.data.source.AlarmsDataSource.PushPendingAlarmsCallback;
import com.portfolio.platform.data.source.AlarmsRepository;
import com.portfolio.platform.data.source.DataVersioningRepository;
import com.portfolio.platform.data.source.MicroAppSettingDataSource.PushPendingMicroAppSettingsCallback;
import com.portfolio.platform.data.source.MicroAppSettingRepository;
import com.portfolio.platform.data.source.PresetDataSource.PushPendingActivePresetsCallback;
import com.portfolio.platform.data.source.PresetDataSource.PushPendingSavedPresetsCallback;
import com.portfolio.platform.data.source.PresetRepository;
import com.portfolio.platform.data.source.SleepSessionsDataSource.PushPendingSleepSessionsCallback;
import com.portfolio.platform.data.source.SleepSessionsRepository;
import java.util.concurrent.CountDownLatch;

public class ctf extends ckb<C2295a, C2133c, C2131a> {
    private static final String TAG = ctf.class.getSimpleName();
    private SleepSessionsRepository cEp;
    private ActivitiesRepository cxG;
    private AlarmsRepository cxw;
    private DataVersioningRepository czr;
    private MicroAppSettingRepository mMicroAppSettingRepository;
    private PresetRepository mPresetRepository;

    public static final class C2295a implements C2132b {
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m7499a((C2295a) c2132b);
    }

    ctf(ActivitiesRepository activitiesRepository, SleepSessionsRepository sleepSessionsRepository, PresetRepository presetRepository, MicroAppSettingRepository microAppSettingRepository, AlarmsRepository alarmsRepository, DataVersioningRepository dataVersioningRepository) {
        this.cxG = (ActivitiesRepository) cco.m5996s(activitiesRepository, "activitiesRepository cannot be null!");
        this.cEp = sleepSessionsRepository;
        this.mPresetRepository = presetRepository;
        this.cxw = alarmsRepository;
        this.mMicroAppSettingRepository = microAppSettingRepository;
        this.czr = dataVersioningRepository;
    }

    protected void m7499a(C2295a c2295a) {
        this.czr.checkDataVersioning(null);
        final CountDownLatch countDownLatch = new CountDownLatch(6);
        this.cxG.pushPendingActivities(new PushPendingActivitiesCallback(this) {
            final /* synthetic */ ctf cEq;

            public void onDone() {
                MFLogger.m12670d(ctf.TAG, "ActivitiesRepository.pushPendingActivities has done, go to next latch");
                countDownLatch.countDown();
            }
        });
        this.cEp.pushPendingSleepSessions(new PushPendingSleepSessionsCallback(this) {
            final /* synthetic */ ctf cEq;

            public void onDone() {
                MFLogger.m12670d(ctf.TAG, "SleepSessionRepository.pushPendingSleepSessions has done, go to next latch");
                countDownLatch.countDown();
            }
        });
        this.mPresetRepository.pushPendingSavedPresets(new PushPendingSavedPresetsCallback(this) {
            final /* synthetic */ ctf cEq;

            public void onDone() {
                MFLogger.m12670d(ctf.TAG, "PresetRepository.pushPendingSavedPresets has done, go to next latch");
                countDownLatch.countDown();
            }
        });
        this.mPresetRepository.pushPendingActivePresets(new PushPendingActivePresetsCallback(this) {
            final /* synthetic */ ctf cEq;

            public void onDone() {
                MFLogger.m12670d(ctf.TAG, "PresetRepository.pushPendingActivePresets has done, go to next latch");
                countDownLatch.countDown();
            }
        });
        this.mMicroAppSettingRepository.pushPendingMicroAppSettings(new PushPendingMicroAppSettingsCallback(this) {
            final /* synthetic */ ctf cEq;

            public void onDone() {
                MFLogger.m12670d(ctf.TAG, "MicroAppSettingRepository.pushPendingMicroAppSettings has done, go to next latch");
                countDownLatch.countDown();
            }
        });
        this.cxw.executePendingRequest(new PushPendingAlarmsCallback(this) {
            final /* synthetic */ ctf cEq;

            public void onDone() {
                MFLogger.m12670d(ctf.TAG, "AlarmsRepository.executePendingRequest has done, go to next latch");
                countDownLatch.countDown();
            }
        });
        try {
            MFLogger.m12670d(TAG, "Await on thread=" + Thread.currentThread().getName());
            countDownLatch.await();
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "Can not await thread=" + Thread.currentThread().getName());
            e.printStackTrace();
        }
        abr().onSuccess(null);
    }
}
