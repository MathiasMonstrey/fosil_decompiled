package com.portfolio.platform.data.source.loader;

import android.content.Context;
import com.fossil.cmq;
import com.fossil.wearables.fsl.sleep.MFSleepDay;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.source.SleepSummariesRepository;
import com.portfolio.platform.data.source.SleepSummariesRepository.SleepSummariesRepositoryObserver;
import java.util.Date;
import java.util.List;

public class SleepSummariesLoader extends BaseLoader<List<MFSleepDay>> implements SleepSummariesRepositoryObserver {
    private static final String TAG = SleepSummariesLoader.class.getSimpleName();
    private Date mEndDate;
    private final SleepSummariesRepository mRepository;
    private Date mStartDate;

    SleepSummariesLoader(Context context, SleepSummariesRepository sleepSummariesRepository) {
        super(context);
        this.mRepository = sleepSummariesRepository;
    }

    public List<MFSleepDay> loadInBackground() {
        List<MFSleepDay> loadSleepSummaries = this.mRepository.loadSleepSummaries(this.mStartDate, this.mEndDate);
        MFLogger.d(TAG, "loadInBackground: mStartDate = " + this.mStartDate + ", result = " + loadSleepSummaries);
        if (loadSleepSummaries == null || loadSleepSummaries.size() < cmq.d(this.mStartDate, this.mEndDate) + 1) {
            this.mRepository.loadSleepSummaries(this.mStartDate, this.mEndDate, null);
        }
        return loadSleepSummaries;
    }

    protected void onStartLoading() {
        MFLogger.d(TAG, "onStartLoading");
        this.mRepository.addContentObserver(this);
        forceLoad();
    }

    protected void onReset() {
        this.mRepository.removeContentObserver(this);
        super.onReset();
    }

    public void onSleepSummariesChanged() {
        MFLogger.d(TAG, "onSleepSummariesChanged");
        if (isStarted()) {
            forceLoad();
        }
    }

    public void setCalendar(Date date, Date date2) {
        this.mStartDate = date;
        this.mEndDate = date2;
    }
}
