package com.portfolio.platform.data.source.local;

import com.fossil.cco;
import com.fossil.cmq;
import com.fossil.cmt;
import com.fossil.cnq;
import com.fossil.wearables.fsl.fitness.DailyGoal;
import com.fossil.wearables.fsl.fitness.SampleRaw;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.source.ActivitiesDataSource;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class ActivitiesLocalDataSource extends ActivitiesDataSource {
    private static final String TAG = ActivitiesLocalDataSource.class.getSimpleName();
    private final cnq mProviderManager;

    public ActivitiesLocalDataSource(cnq com_fossil_cnq) {
        this.mProviderManager = com_fossil_cnq;
    }

    public List<SampleRaw> getActivityList(Date date, Date date2) {
        MFLogger.d(TAG, "getActivityList: start = " + date + ", end = " + date2);
        if (!cmq.c(date2).booleanValue()) {
            return this.mProviderManager.acs().getRawSamples(date, date2);
        }
        List<SampleRaw> rawSamples = this.mProviderManager.acs().getRawSamples(date, cmq.g(date2));
        if (rawSamples == null) {
            rawSamples = new ArrayList();
        }
        Collection a = cmt.abK().a(date2, true);
        if (a == null) {
            return rawSamples;
        }
        rawSamples.addAll(a);
        return rawSamples;
    }

    public void insertFromDevice(List<SampleRaw> list) {
        MFLogger.d(TAG, "insertFromDevice: activityList = " + list);
        Calendar instance = Calendar.getInstance();
        for (SampleRaw sampleRaw : list) {
            instance.setTime(sampleRaw.getEndTime());
            DailyGoal dailyGoal = this.mProviderManager.acr().getDailyGoal(instance);
            this.mProviderManager.acr().addSample(sampleRaw);
            if (dailyGoal != null) {
                this.mProviderManager.acr().updateDailyStepGoal(dailyGoal.getSteps(), instance);
            }
            MFLogger.d(TAG, "insertFromDevice: goal = " + dailyGoal);
        }
    }

    protected void insert(List<SampleRaw> list) {
        MFLogger.d(TAG, "insert: activityList = " + list);
        for (SampleRaw a : list) {
            this.mProviderManager.acs().a(a);
        }
    }

    public void updateActivityPinType(SampleRaw sampleRaw) {
        cco.ce(sampleRaw);
        MFLogger.d(TAG, "updateActivityPinType: pinType to " + sampleRaw.getPinType());
        this.mProviderManager.acr().updateSampleRawPinType(sampleRaw.getUri().toASCIIString(), sampleRaw.getPinType());
    }

    public List<SampleRaw> getPendingActivities() {
        MFLogger.d(TAG, "getPendingActivities");
        return this.mProviderManager.acr().getPendingSampleRaws();
    }

    protected void cleanUp() {
        MFLogger.d(TAG, "cleanUp");
        this.mProviderManager.acs().aet();
    }
}
