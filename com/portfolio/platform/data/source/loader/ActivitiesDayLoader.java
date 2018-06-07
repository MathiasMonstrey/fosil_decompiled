package com.portfolio.platform.data.source.loader;

import android.content.Context;
import com.fossil.cmq;
import com.fossil.jt;
import com.fossil.wearables.fsl.fitness.SampleRaw;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.source.ActivitiesRepository;
import com.portfolio.platform.data.source.ActivitiesRepository.ActivitiesRepositoryObserver;
import com.portfolio.platform.data.source.SummariesRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActivitiesDayLoader extends BaseLoader<jt<List<SampleRaw>, Integer>> implements ActivitiesRepositoryObserver {
    private static final String TAG = ActivitiesDayLoader.class.getSimpleName();
    private Date mEndDate;
    private final ActivitiesRepository mRepository;
    private Date mStartDate;
    private final SummariesRepository mSummariesRepository;

    ActivitiesDayLoader(Context context, ActivitiesRepository activitiesRepository, SummariesRepository summariesRepository) {
        super(context);
        this.mRepository = activitiesRepository;
        this.mSummariesRepository = summariesRepository;
    }

    public jt<List<SampleRaw>, Integer> loadInBackground() {
        MFLogger.d(TAG, "loadInBackground: mStartDate = " + this.mStartDate + ", mEndDate = " + this.mEndDate);
        return new jt(this.mRepository.getActivityList(this.mStartDate, this.mEndDate), Integer.valueOf(getLastStepGoal()));
    }

    private int getLastStepGoal() {
        MFLogger.d(TAG, "Inside getLastStepGoal date=" + this.mEndDate);
        return this.mSummariesRepository.getLastStepGoal(this.mEndDate);
    }

    protected void onStartLoading() {
        MFLogger.d(TAG, "onStartLoading");
        List arrayList = new ArrayList();
        for (List addAll : this.mRepository.getCachedActivityList(this.mStartDate, this.mEndDate).values()) {
            arrayList.addAll(addAll);
        }
        if (!arrayList.isEmpty()) {
            MFLogger.d(TAG, "onStartLoading isCachedActivitiesAvailable: activityList = " + arrayList);
            deliverResult(new jt(arrayList, Integer.valueOf(getLastStepGoal())));
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

    public void onActivitiesChanged() {
        MFLogger.d(TAG, "onActivitiesChanged");
        if (isStarted()) {
            forceLoad();
        }
    }

    public void setDate(Date date) {
        this.mStartDate = cmq.getStartOfDay(date);
        this.mEndDate = cmq.getEndOfDay(date);
    }
}
