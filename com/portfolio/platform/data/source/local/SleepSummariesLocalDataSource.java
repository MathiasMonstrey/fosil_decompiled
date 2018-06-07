package com.portfolio.platform.data.source.local;

import com.fossil.cmq;
import com.fossil.cnf;
import com.fossil.cnq;
import com.fossil.wearables.fsl.sleep.MFSleepDay;
import com.fossil.wearables.fsl.sleep.MFSleepGoal;
import com.fossil.wearables.fsl.sleep.SleepDistribution;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.source.SleepSummariesDataSource;
import com.portfolio.platform.data.source.SleepSummariesDataSource.UpdateSleepGoalCallback;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.joda.time.DateTime;

public class SleepSummariesLocalDataSource extends SleepSummariesDataSource {
    private static final String TAG = SleepSummariesLocalDataSource.class.getSimpleName();
    private final cnq mProviderManager;

    public SleepSummariesLocalDataSource(cnq com_fossil_cnq) {
        this.mProviderManager = com_fossil_cnq;
    }

    protected MFSleepDay getSleepSummary(Date date) {
        MFSleepDay sleepDay = this.mProviderManager.aco().getSleepDay(cmq.a(date));
        MFLogger.d(TAG, "getSleepSummary: date = " + date + ", result = " + sleepDay);
        return sleepDay;
    }

    protected int getLastSleepGoal(Date date) {
        return this.mProviderManager.aco().ho(cmq.a(date));
    }

    public void updateLastSleepGoal(int i, UpdateSleepGoalCallback updateSleepGoalCallback) {
        String stringCurrentTimeYYYYMMDD = cnf.getStringCurrentTimeYYYYMMDD();
        this.mProviderManager.aco().updateDailySleepGoal(new MFSleepGoal(stringCurrentTimeYYYYMMDD, i, cnf.getTimezoneOffset()));
        MFSleepDay sleepDay = this.mProviderManager.aco().getSleepDay(stringCurrentTimeYYYYMMDD);
        if (sleepDay == null) {
            SleepDistribution sleepDistribution = new SleepDistribution(0, 0, 0);
            sleepDay = new MFSleepDay(stringCurrentTimeYYYYMMDD, cnf.getTimezoneOffset(), i, 0, sleepDistribution.getSleepDistribution(), new DateTime(Calendar.getInstance().getTimeInMillis()));
        } else {
            sleepDay.setGoalMinutes(i);
        }
        this.mProviderManager.aco().addSleepDay(sleepDay);
        MFResponse mFResponse = new MFResponse();
        mFResponse.setHttpReturnCode(MFNetworkReturnCode.RESPONSE_OK);
        if (updateSleepGoalCallback != null) {
            updateSleepGoalCallback.onUpdateSleepGoalFinish(mFResponse, true);
        }
    }

    protected List<MFSleepDay> loadSleepSummaries(Date date, Date date2) {
        List<MFSleepDay> az = this.mProviderManager.aco().az(cmq.a(date), cmq.a(date2));
        MFLogger.d(TAG, "loadSleepSummaries: startDate = " + cmq.a(date) + ", endDate = " + cmq.a(date2) + ", result = " + az);
        return az;
    }

    public void insert(MFSleepDay mFSleepDay) {
        MFLogger.d(TAG, "insert: summary = " + mFSleepDay.getDate());
        MFSleepDay sleepDay = this.mProviderManager.aco().getSleepDay(mFSleepDay.getDate());
        if (!isMFSleepDayAlreadyHasTheSameValueInLocal(mFSleepDay)) {
            if (sleepDay == null) {
                this.mProviderManager.aco().addSleepDay(mFSleepDay);
            } else if (mFSleepDay.getUpdatedAt().getMillis() > sleepDay.getUpdatedAt().getMillis()) {
                mFSleepDay.setDbRowId(sleepDay.getDbRowId());
                this.mProviderManager.aco().updateSleepDay(mFSleepDay);
            }
            this.mProviderManager.aco().updateDailySleepGoal(new MFSleepGoal(mFSleepDay.getDate(), mFSleepDay.getGoalMinutes(), cnf.getTimezoneOffset()));
        }
    }

    private boolean isMFSleepDayAlreadyHasTheSameValueInLocal(MFSleepDay mFSleepDay) {
        MFSleepDay sleepDay = this.mProviderManager.aco().getSleepDay(mFSleepDay.getDate());
        if (sleepDay != null && mFSleepDay.getSleepStateDistInMinute().equals(sleepDay.getSleepStateDistInMinute()) && mFSleepDay.getSleepMinutes() == sleepDay.getSleepMinutes() && mFSleepDay.getGoalMinutes() == sleepDay.getGoalMinutes()) {
            return true;
        }
        return false;
    }

    protected void cleanUp() {
        this.mProviderManager.aco().aew();
    }
}
