package com.portfolio.platform.data.source.loader;

import android.content.Context;
import com.fossil.wearables.fsl.sleep.MFSleepDay;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.source.SleepSummariesRepository;
import com.portfolio.platform.data.source.SleepSummariesRepository.SleepSummariesRepositoryObserver;
import java.util.Date;

public class SleepSummaryLoader extends BaseLoader<MFSleepDay> implements SleepSummariesRepositoryObserver {
    private static final String TAG = SleepSummaryLoader.class.getSimpleName();
    private Date mCalendar;
    private final SleepSummariesRepository mRepository;

    SleepSummaryLoader(Context context, SleepSummariesRepository sleepSummariesRepository) {
        super(context);
        this.mRepository = sleepSummariesRepository;
    }

    public MFSleepDay loadInBackground() {
        MFLogger.d(TAG, "loadInBackground: mCalendar = " + this.mCalendar);
        return this.mRepository.getSleepSummary(this.mCalendar);
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

    public void setDate(Date date) {
        this.mCalendar = date;
    }
}
