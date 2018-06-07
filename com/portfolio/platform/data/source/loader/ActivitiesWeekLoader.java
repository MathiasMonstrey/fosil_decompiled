package com.portfolio.platform.data.source.loader;

import android.content.Context;
import android.util.LongSparseArray;
import com.fossil.cmq;
import com.fossil.cmt;
import com.fossil.jt;
import com.fossil.wearables.fsl.fitness.SampleRaw;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.source.ActivitiesRepository;
import com.portfolio.platform.data.source.ActivitiesRepository.ActivitiesRepositoryObserver;
import com.portfolio.platform.data.source.SummariesRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

public class ActivitiesWeekLoader extends BaseLoader<jt<LongSparseArray<List<Float>>, Integer>> implements ActivitiesRepositoryObserver {
    private static final String TAG = ActivitiesWeekLoader.class.getSimpleName();
    private Date mEndDate;
    private final ActivitiesRepository mRepository;
    private Date mStartDate;
    private final SummariesRepository mSummariesRepository;

    ActivitiesWeekLoader(Context context, ActivitiesRepository activitiesRepository, SummariesRepository summariesRepository) {
        super(context);
        this.mRepository = activitiesRepository;
        this.mSummariesRepository = summariesRepository;
    }

    public jt<LongSparseArray<List<Float>>, Integer> loadInBackground() {
        MFLogger.d(TAG, "loadInBackground");
        this.mRepository.getActivityList(this.mStartDate, this.mEndDate);
        return new jt(handleResult(new TreeMap(this.mRepository.getCachedActivityList(this.mStartDate, this.mEndDate))), Integer.valueOf(getLastStepGoal()));
    }

    private int getLastStepGoal() {
        MFLogger.d(TAG, "Inside getLastStepGoal date=" + this.mStartDate);
        return this.mSummariesRepository.getLastStepGoal(this.mStartDate);
    }

    protected void onStartLoading() {
        MFLogger.d(TAG, "onStartLoading");
        SortedMap cachedActivityList = this.mRepository.getCachedActivityList(this.mStartDate, this.mEndDate);
        if (cachedActivityList.size() == cmq.d(this.mStartDate, this.mEndDate) + 1) {
            MFLogger.d(TAG, "onStartLoading isCachedActivitiesAvailable");
            deliverResult(new jt(handleResult(new TreeMap(cachedActivityList)), Integer.valueOf(getLastStepGoal())));
        }
        this.mRepository.addContentObserver(this);
        if (takeContentChanged() || cachedActivityList.size() < cmq.d(this.mStartDate, this.mEndDate) + 1) {
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

    private LongSparseArray<List<Float>> handleResult(SortedMap<Long, List<SampleRaw>> sortedMap) {
        LongSparseArray<List<Float>> longSparseArray = new LongSparseArray();
        for (Entry entry : sortedMap.entrySet()) {
            List arrayList = new ArrayList();
            float f = 0.0f;
            float f2 = 0.0f;
            float f3 = 0.0f;
            for (SampleRaw sampleRaw : (List) entry.getValue()) {
                float f4;
                switch (cmt.aC((long) (sampleRaw.getSteps() / ((double) cmq.c(sampleRaw.getStartTime(), sampleRaw.getEndTime()))))) {
                    case 0:
                        f4 = f;
                        f = f2;
                        f2 = (float) (((double) f3) + sampleRaw.getSteps());
                        break;
                    case 1:
                        f4 = f;
                        f = (float) (((double) f2) + sampleRaw.getSteps());
                        f2 = f3;
                        break;
                    case 2:
                        f4 = (float) (((double) f) + sampleRaw.getSteps());
                        f = f2;
                        f2 = f3;
                        break;
                    default:
                        f4 = f;
                        f = f2;
                        f2 = f3;
                        break;
                }
                f3 = f2;
                f2 = f;
                f = f4;
            }
            arrayList.add(Float.valueOf((float) this.mSummariesRepository.getLastStepGoal(new Date(((Long) entry.getKey()).longValue()))));
            arrayList.add(Float.valueOf(f3));
            arrayList.add(Float.valueOf(f2));
            arrayList.add(Float.valueOf(f));
            longSparseArray.put(((Long) entry.getKey()).longValue(), arrayList);
        }
        return longSparseArray;
    }

    public void setDate(Date date, Date date2) {
        this.mStartDate = date;
        this.mEndDate = date2;
    }
}
