package com.portfolio.platform.data.source.loader;

import android.content.Context;
import com.fossil.gk;
import com.fossil.wearables.fsl.fitness.SampleDay;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.source.SummariesRepository;
import com.portfolio.platform.data.source.SummariesRepository$SummariesRepositoryObserver;
import java.util.Date;

public class SummaryLoader extends gk<SampleDay> implements SummariesRepository$SummariesRepositoryObserver {
    private static final String TAG = SummaryLoader.class.getSimpleName();
    private Date mDate;
    private final SummariesRepository mRepository;

    SummaryLoader(Context context, SummariesRepository summariesRepository) {
        super(context);
        this.mRepository = summariesRepository;
    }

    public SampleDay loadInBackground() {
        MFLogger.d(TAG, "loadInBackground: mDate = " + this.mDate);
        return this.mRepository.getSummary(this.mDate);
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

    public void setDate(Date date) {
        this.mDate = date;
    }
}
