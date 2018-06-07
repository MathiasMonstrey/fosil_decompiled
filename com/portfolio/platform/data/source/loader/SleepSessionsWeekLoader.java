package com.portfolio.platform.data.source.loader;

import android.content.Context;
import android.util.LongSparseArray;
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
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;

public class SleepSessionsWeekLoader extends BaseLoader<jt<LongSparseArray<List<Float>>, Integer>> implements SleepSessionsRepositoryObserver {
    private static final String TAG = SleepSessionsWeekLoader.class.getSimpleName();
    private Date mEndDate;
    private final SleepSessionsRepository mRepository;
    private final SleepSummariesRepository mSleepSummariesRepository;
    private Date mStartDate;

    SleepSessionsWeekLoader(Context context, SleepSessionsRepository sleepSessionsRepository, SleepSummariesRepository sleepSummariesRepository) {
        super(context);
        this.mRepository = sleepSessionsRepository;
        this.mSleepSummariesRepository = sleepSummariesRepository;
    }

    public jt<LongSparseArray<List<Float>>, Integer> loadInBackground() {
        MFLogger.d(TAG, "loadInBackground");
        this.mRepository.getSleepSessionList(this.mStartDate, this.mEndDate);
        return new jt(handleResult(new TreeMap(this.mRepository.getCachedSleepSessionList(this.mStartDate, this.mEndDate))), Integer.valueOf(getLastSleepGoal()));
    }

    private int getLastSleepGoal() {
        MFLogger.d(TAG, "Inside getLastSleepGoal date=" + this.mStartDate);
        return this.mSleepSummariesRepository.getLastSleepGoal(this.mStartDate);
    }

    protected void onStartLoading() {
        MFLogger.d(TAG, "onStartLoading");
        SortedMap cachedSleepSessionList = this.mRepository.getCachedSleepSessionList(this.mStartDate, this.mEndDate);
        if (cachedSleepSessionList.size() == cmq.d(this.mStartDate, this.mEndDate) + 1) {
            MFLogger.d(TAG, "onStartLoading isCachedActivitiesAvailable");
            deliverResult(new jt(handleResult(new TreeMap(cachedSleepSessionList)), Integer.valueOf(getLastSleepGoal())));
        }
        this.mRepository.addContentObserver(this);
        if (takeContentChanged() || cachedSleepSessionList.size() < cmq.d(this.mStartDate, this.mEndDate) + 1) {
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

    private LongSparseArray<List<Float>> handleResult(SortedMap<Long, List<MFSleepSession>> sortedMap) {
        float f;
        LongSparseArray<List<Float>> longSparseArray = new LongSparseArray();
        for (Entry entry : sortedMap.entrySet()) {
            float f2 = 0.0f;
            float f3 = 0.0f;
            float f4 = 0.0f;
            List arrayList = new ArrayList();
            for (MFSleepSession realSleepStateDistInMinute : (List) entry.getValue()) {
                try {
                    JSONObject jSONObject = new JSONObject(realSleepStateDistInMinute.getRealSleepStateDistInMinute());
                    f2 += (float) jSONObject.getInt("light");
                    f3 += (float) jSONObject.getInt("deep");
                    f = ((float) jSONObject.getInt("awake")) + f4;
                    f4 = f3;
                    f3 = f2;
                } catch (JSONException e) {
                    f = f3;
                    f3 = f2;
                    float f5 = f4;
                    f4 = f;
                    f = f5;
                }
                f2 = f3;
                f3 = f4;
                f4 = f;
            }
            arrayList.add(Float.valueOf((float) this.mSleepSummariesRepository.getLastSleepGoal(new Date(((Long) entry.getKey()).longValue()))));
            arrayList.add(Float.valueOf(f2));
            arrayList.add(Float.valueOf(f3));
            arrayList.add(Float.valueOf(f4));
            longSparseArray.put(((Long) entry.getKey()).longValue(), arrayList);
        }
        return longSparseArray;
    }

    public void setDate(Date date, Date date2) {
        this.mStartDate = date;
        this.mEndDate = date2;
    }
}
