package com.portfolio.platform.data.source.loader;

import android.content.Context;
import com.fossil.cmq;
import com.fossil.jt;
import com.fossil.wearables.fsl.sleep.MFSleepSession;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.source.SleepSessionsRepository;
import com.portfolio.platform.data.source.SleepSessionsRepository.SleepSessionsRepositoryObserver;
import com.portfolio.platform.data.source.SleepSummariesRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SleepSessionsDayLoader extends BaseLoader<jt<List<MFSleepSession>, Integer>> implements SleepSessionsRepositoryObserver {
    private static final String TAG = SleepSessionsDayLoader.class.getSimpleName();
    private Date mEndDate;
    private final SleepSessionsRepository mRepository;
    private Date mStartDate;
    private final SleepSummariesRepository mSummariesRepository;

    SleepSessionsDayLoader(Context context, SleepSessionsRepository sleepSessionsRepository, SleepSummariesRepository sleepSummariesRepository) {
        super(context);
        this.mRepository = sleepSessionsRepository;
        this.mSummariesRepository = sleepSummariesRepository;
    }

    public jt<List<MFSleepSession>, Integer> loadInBackground() {
        MFLogger.d(TAG, "loadInBackground: mStartDate = " + this.mStartDate + ", mEndDate = " + this.mEndDate);
        return new jt(this.mRepository.getSleepSessionList(this.mStartDate, this.mEndDate), Integer.valueOf(getLastSleepGoal()));
    }

    private int getLastSleepGoal() {
        MFLogger.d(TAG, "Inside getLastSleepGoal date=" + this.mEndDate);
        return this.mSummariesRepository.getLastSleepGoal(this.mEndDate);
    }

    protected void onStartLoading() {
        MFLogger.d(TAG, "onStartLoading");
        List arrayList = new ArrayList();
        for (List addAll : this.mRepository.getCachedSleepSessionList(this.mStartDate, this.mEndDate).values()) {
            arrayList.addAll(addAll);
        }
        if (!arrayList.isEmpty()) {
            MFLogger.d(TAG, "onStartLoading isCachedSleepSessionsAvailable: sleepSessionList = " + arrayList);
            deliverResult(new jt(arrayList, Integer.valueOf(getLastSleepGoal())));
        }
        this.mRepository.addContentObserver(this);
        if (takeContentChanged() || arrayList.isEmpty()) {
            MFLogger.d(TAG, "onStartLoading forceLoad");
            forceLoad();
        }
    }

    protected void onReset() {
        this.mRepository.removeContentObserver(this);
        super.onReset();
    }

    public void onSleepSessionsChanged() {
        MFLogger.d(TAG, "onSleepSessionsChanged");
        if (isStarted()) {
            forceLoad();
        }
    }

    public void setDate(Date date) {
        this.mStartDate = cmq.getStartOfDay(date);
        this.mEndDate = cmq.getEndOfDay(date);
    }
}
