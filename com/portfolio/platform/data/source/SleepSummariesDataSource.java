package com.portfolio.platform.data.source;

import com.fossil.wearables.fsl.sleep.MFSleepDay;
import com.misfit.frameworks.network.responses.MFResponse;
import java.util.Date;
import java.util.List;

public abstract class SleepSummariesDataSource {

    public interface GetSleepSummaryCallback {
        void onDataNotAvailable();

        void onSleepSummaryLoaded(MFSleepDay mFSleepDay);
    }

    public interface LoadSleepSummariesCallback {
        void onDataNotAvailable();

        void onSleepSummariesLoaded(List<MFSleepDay> list);
    }

    public interface UpdateSleepGoalCallback {
        void onUpdateSleepGoalFinish(MFResponse mFResponse, boolean z);
    }

    public abstract void insert(MFSleepDay mFSleepDay);

    public abstract void updateLastSleepGoal(int i, UpdateSleepGoalCallback updateSleepGoalCallback);

    public MFSleepDay getSleepSummary(Date date) {
        return null;
    }

    public int getLastSleepGoal(Date date) {
        return 0;
    }

    public void getSleepSummary(Date date, GetSleepSummaryCallback getSleepSummaryCallback) {
    }

    public List<MFSleepDay> loadSleepSummaries(Date date, Date date2) {
        return null;
    }

    public void loadSleepSummaries(Date date, Date date2, LoadSleepSummariesCallback loadSleepSummariesCallback) {
    }

    public void cleanUp() {
    }
}
