package com.portfolio.platform.data.source.loader;

import android.content.Context;
import com.fossil.cmq;
import com.fossil.wearables.fsl.fitness.SampleDay;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.source.SummariesRepository;
import com.portfolio.platform.data.source.SummariesRepository$SummariesRepositoryObserver;
import java.util.Date;
import java.util.List;

public class SummariesLoader extends BaseLoader<List<SampleDay>> implements SummariesRepository$SummariesRepositoryObserver {
    private static final String TAG = SummariesLoader.class.getSimpleName();
    private Date mEndDate;
    private final SummariesRepository mRepository;
    private Date mStartDate;

    SummariesLoader(Context context, SummariesRepository summariesRepository) {
        super(context);
        this.mRepository = summariesRepository;
    }

    public List<SampleDay> loadInBackground() {
        List<SampleDay> loadSummaries = this.mRepository.loadSummaries(this.mStartDate, this.mEndDate);
        if (loadSummaries == null || loadSummaries.size() < cmq.d(this.mStartDate, this.mEndDate) + 1) {
            this.mRepository.loadSummaries(this.mStartDate, this.mEndDate, null);
        }
        return loadSummaries;
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

    public void onSummariesChanged() {
        MFLogger.d(TAG, "onSummariesChanged");
        if (isStarted()) {
            forceLoad();
        }
    }

    public void setCalendar(Date date, Date date2) {
        this.mStartDate = date;
        this.mEndDate = date2;
    }
}
