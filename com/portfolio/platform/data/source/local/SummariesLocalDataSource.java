package com.portfolio.platform.data.source.local;

import com.fossil.cmq;
import com.fossil.cnq;
import com.fossil.wearables.fsl.fitness.SampleDay;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.source.SummariesDataSource;
import com.portfolio.platform.data.source.SummariesDataSource$UpdateStepGoalCallback;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import org.joda.time.DateTime;

public class SummariesLocalDataSource extends SummariesDataSource {
    private static final String TAG = SummariesLocalDataSource.class.getSimpleName();
    private final cnq mProviderManager;

    public SummariesLocalDataSource(cnq com_fossil_cnq) {
        this.mProviderManager = com_fossil_cnq;
    }

    protected SampleDay getSummary(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        SampleDay sampleDayByDate = this.mProviderManager.acs().getSampleDayByDate(instance.get(1), instance.get(2) + 1, instance.get(5));
        if (sampleDayByDate != null) {
            sampleDayByDate.setGoal(this.mProviderManager.acs().getDailyGoal(instance));
        }
        MFLogger.d(TAG, "getSummary: date = " + date + ", result = " + sampleDayByDate);
        return sampleDayByDate;
    }

    protected int getLastStepGoal(Date date) {
        int lastDailyGoalFromDate = this.mProviderManager.acs().getLastDailyGoalFromDate(date);
        MFLogger.d(TAG, "getLastStepGoal: stepGoal = " + lastDailyGoalFromDate);
        return lastDailyGoalFromDate;
    }

    public void updateLastStepGoal(Date date, int i, SummariesDataSource$UpdateStepGoalCallback summariesDataSource$UpdateStepGoalCallback) {
        MFLogger.d(TAG, "updateLastStepGoal: date = " + date + ", stepGoal = " + i);
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        SampleDay samplesForDay = this.mProviderManager.acs().getSamplesForDay(instance);
        if (samplesForDay == null) {
            DateTime dateTime = new DateTime();
            TimeZone toTimeZone = dateTime.getZone().toTimeZone();
            samplesForDay = new SampleDay(dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(), toTimeZone.getID(), toTimeZone.inDaylightTime(dateTime.toDate()) ? toTimeZone.getDSTSavings() : 0, 0.0d, 0.0d, 0.0d);
        }
        samplesForDay.setGoal(this.mProviderManager.acs().updateDailyStepGoal(i, instance));
        this.mProviderManager.acs().saveSampleDay(samplesForDay);
        MFResponse mFResponse = new MFResponse();
        mFResponse.setHttpReturnCode(MFNetworkReturnCode.RESPONSE_OK);
        if (summariesDataSource$UpdateStepGoalCallback != null) {
            summariesDataSource$UpdateStepGoalCallback.onUpdateStepGoalFinish(mFResponse, true);
        }
    }

    protected List<SampleDay> loadSummaries(Date date, Date date2) {
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance.setTime(date);
        instance2.setTime(cmq.h(date2));
        List<SampleDay> sampleDays = this.mProviderManager.acs().getSampleDays(instance, instance2);
        MFLogger.d(TAG, "loadSummaries: startDate = " + date + ", endDate = " + date2 + ", result = " + sampleDays);
        return sampleDays;
    }

    public void insert(SampleDay sampleDay) {
        MFLogger.d(TAG, "insert: summary = " + sampleDay);
        this.mProviderManager.acs().saveSampleDay(sampleDay);
    }

    protected void cleanUp() {
        this.mProviderManager.acs().aeu();
    }
}
