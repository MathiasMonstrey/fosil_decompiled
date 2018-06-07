package com.portfolio.platform.data.source;

import android.os.Bundle;
import com.fossil.bbm;
import com.fossil.ciw;
import com.fossil.cmq;
import com.fossil.wearables.fsl.fitness.SampleRaw;
import com.google.android.gms.gcm.OneoffTask$a;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.source.ActivitiesDataSource.LoadActivitiesCallback;
import com.portfolio.platform.data.source.ActivitiesDataSource.PushPendingActivitiesCallback;
import com.portfolio.platform.data.source.ActivitiesDataSource.SaveSampleRawCallback;
import com.portfolio.platform.data.source.scope.Local;
import com.portfolio.platform.data.source.scope.Remote;
import com.portfolio.platform.manager.network.BestTimeService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CountDownLatch;

public class ActivitiesRepository extends ActivitiesDataSource {
    private static final String TAG = ActivitiesRepository.class.getSimpleName();
    private final ActivitiesDataSource mActivitiesLocalDataSource;
    private final ActivitiesDataSource mActivitiesRemoteDataSource;
    private final ciw mAppExecutors;
    private NavigableMap<Long, List<SampleRaw>> mCachedActivities = new ConcurrentSkipListMap();
    private final bbm mGcmNetworkManager;
    private List<ActivitiesRepositoryObserver> mObservers = new ArrayList();

    class C47421 implements Runnable {
        C47421() {
        }

        public void run() {
            for (ActivitiesRepositoryObserver onActivitiesChanged : ActivitiesRepository.this.mObservers) {
                onActivitiesChanged.onActivitiesChanged();
            }
        }
    }

    public interface ActivitiesRepositoryObserver {
        void onActivitiesChanged();
    }

    ActivitiesRepository(@Remote ActivitiesDataSource activitiesDataSource, @Local ActivitiesDataSource activitiesDataSource2, bbm com_fossil_bbm, ciw com_fossil_ciw) {
        this.mActivitiesRemoteDataSource = activitiesDataSource;
        this.mActivitiesLocalDataSource = activitiesDataSource2;
        this.mGcmNetworkManager = com_fossil_bbm;
        this.mAppExecutors = com_fossil_ciw;
    }

    public void addContentObserver(ActivitiesRepositoryObserver activitiesRepositoryObserver) {
        MFLogger.d(TAG, "addSavedPresetObserver: observer = " + activitiesRepositoryObserver);
        if (!this.mObservers.contains(activitiesRepositoryObserver)) {
            this.mObservers.add(activitiesRepositoryObserver);
        }
    }

    public void removeContentObserver(ActivitiesRepositoryObserver activitiesRepositoryObserver) {
        MFLogger.d(TAG, "removeSavedPresetObserver: observer = " + activitiesRepositoryObserver);
        if (this.mObservers.contains(activitiesRepositoryObserver)) {
            this.mObservers.remove(activitiesRepositoryObserver);
        }
    }

    private void notifyContentObserver() {
        MFLogger.d(TAG, "notifyContentObserver");
        this.mAppExecutors.YS().execute(new C47421());
    }

    public void refresh() {
        notifyContentObserver();
    }

    public SortedMap<Long, List<SampleRaw>> getCachedActivityList(Date date, Date date2) {
        SortedMap<Long, List<SampleRaw>> subMap;
        MFLogger.d(TAG, "getCachedActivityList: startDate = " + date + ", endDate = " + date2);
        synchronized (this) {
            subMap = this.mCachedActivities.subMap(Long.valueOf(date.getTime()), Long.valueOf(date2.getTime()));
        }
        return subMap;
    }

    private void insertCachedActivityList(Date date, Date date2, List<SampleRaw> list) {
        MFLogger.d(TAG, "insertCachedActivityList: startDate = " + date + ", endDate = " + date2 + ", activityList = " + list.size());
        synchronized (this) {
            List arrayList;
            while (!cmq.a(date, date2)) {
                arrayList = new ArrayList();
                for (SampleRaw sampleRaw : list) {
                    if (cmq.a(sampleRaw.getStartTime(), date)) {
                        arrayList.add(sampleRaw);
                    }
                }
                this.mCachedActivities.put(Long.valueOf(cmq.getStartOfDay(date).getTime()), arrayList);
                date = cmq.h(date);
            }
            arrayList = new ArrayList();
            for (SampleRaw sampleRaw2 : list) {
                if (cmq.a(sampleRaw2.getStartTime(), date2)) {
                    arrayList.add(sampleRaw2);
                }
            }
            this.mCachedActivities.put(Long.valueOf(cmq.getStartOfDay(date2).getTime()), arrayList);
        }
    }

    private void clearCached() {
        synchronized (this) {
            this.mCachedActivities.clear();
        }
    }

    public void cleanUp() {
        this.mActivitiesLocalDataSource.cleanUp();
        clearCached();
    }

    public List<SampleRaw> getActivityList(Date date, Date date2) {
        MFLogger.d(TAG, "getActivityList: start = " + date + ", end = " + date2);
        List<SampleRaw> activityList = this.mActivitiesLocalDataSource.getActivityList(date, date2);
        if (!(activityList == null || activityList.isEmpty())) {
            insertCachedActivityList(date, date2, activityList);
        }
        ConcurrentSkipListMap concurrentSkipListMap = new ConcurrentSkipListMap(getCachedActivityList(date, date2));
        if (concurrentSkipListMap.size() == cmq.d(date, date2) + 1) {
            List<SampleRaw> arrayList = new ArrayList();
            for (List addAll : concurrentSkipListMap.values()) {
                arrayList.addAll(addAll);
            }
            return arrayList;
        }
        if (!cmq.a(date, date2)) {
            this.mGcmNetworkManager.a("ACTIVITIES-" + date.getTime(), BestTimeService.class);
        }
        getActivityList(date, date2, null);
        return activityList;
    }

    public void getActivityList(final Date date, final Date date2, final LoadActivitiesCallback loadActivitiesCallback) {
        this.mActivitiesRemoteDataSource.getActivityList(date, date2, new LoadActivitiesCallback() {
            public void onActivitiesLoaded(final List<SampleRaw> list) {
                ActivitiesRepository.this.mAppExecutors.YQ().execute(new Runnable() {
                    public void run() {
                        ActivitiesRepository.this.mActivitiesLocalDataSource.insert(list);
                        ActivitiesRepository.this.insertCachedActivityList(date, date2, ActivitiesRepository.this.mActivitiesLocalDataSource.getActivityList(date, date2));
                        ActivitiesRepository.this.notifyContentObserver();
                        if (loadActivitiesCallback != null) {
                            loadActivitiesCallback.onActivitiesLoaded(list);
                        }
                    }
                });
            }

            public void onDataNotAvailable() {
                if (loadActivitiesCallback != null) {
                    loadActivitiesCallback.onDataNotAvailable();
                }
            }
        });
    }

    public void insertFromDevice(List<SampleRaw> list) {
        MFLogger.d(TAG, "insertFromDevice: activityList = " + list.size());
        for (SampleRaw pinType : list) {
            pinType.setPinType(1);
        }
        this.mActivitiesLocalDataSource.insertFromDevice(list);
        clearCached();
        pushPendingActivities(null);
        notifyContentObserver();
    }

    public void updateActivityPinType(SampleRaw sampleRaw) {
        this.mActivitiesLocalDataSource.updateActivityPinType(sampleRaw);
    }

    public void fetch(Date date, Date date2) {
        MFLogger.d(TAG, "fetch: startDate = " + date + ", endDate = " + date2);
        Bundle bundle = new Bundle();
        bundle.putString("taskId", "ACTIVITIES");
        bundle.putSerializable("START_DATE", date);
        bundle.putSerializable("END_DATE", date2);
        this.mGcmNetworkManager.a(new OneoffTask$a().m14246L(BestTimeService.class).dC("ACTIVITIES-" + date.getTime()).hJ(0).m14247c(0, 30).m14248p(bundle).Mx());
    }

    public void pushPendingActivities(PushPendingActivitiesCallback pushPendingActivitiesCallback) {
        CountDownLatch countDownLatch = null;
        List pendingActivities = this.mActivitiesLocalDataSource.getPendingActivities();
        if (pendingActivities != null) {
            if (pushPendingActivitiesCallback != null && pendingActivities.size() > 0) {
                countDownLatch = new CountDownLatch(pendingActivities.size());
            }
            saveActivitiesToServer(pendingActivities, countDownLatch);
        }
        if (countDownLatch != null) {
            try {
                MFLogger.d(TAG, "Await on thread=" + Thread.currentThread().getName());
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
        if (pushPendingActivitiesCallback != null) {
            pushPendingActivitiesCallback.onDone();
        }
    }

    private void saveActivitiesToServer(List<SampleRaw> list, final CountDownLatch countDownLatch) {
        for (SampleRaw insertActivity : list) {
            this.mActivitiesRemoteDataSource.insertActivity(insertActivity, new SaveSampleRawCallback() {
                public void saveSuccess(SampleRaw sampleRaw) {
                    MFLogger.d(ActivitiesRepository.TAG, "saveActivitiesToServer success, bravo!!!");
                    sampleRaw.setPinType(0);
                    ActivitiesRepository.this.mActivitiesLocalDataSource.updateActivityPinType(sampleRaw);
                    if (countDownLatch != null) {
                        countDownLatch.countDown();
                    }
                }

                public void saveFailed(int i, SampleRaw sampleRaw) {
                    MFLogger.d(ActivitiesRepository.TAG, "saveActivitiesToServer failed, errorCode=" + i);
                    if (i == MFNetworkReturnCode.BAD_REQUEST || i == MFNetworkReturnCode.ITEM_NAME_IN_USED) {
                        sampleRaw.setPinType(0);
                        ActivitiesRepository.this.mActivitiesLocalDataSource.updateActivityPinType(sampleRaw);
                    }
                    if (countDownLatch != null) {
                        countDownLatch.countDown();
                    }
                }
            });
        }
    }
}
