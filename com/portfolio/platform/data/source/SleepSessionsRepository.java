package com.portfolio.platform.data.source;

import android.os.Bundle;
import com.fossil.bbm;
import com.fossil.ciw;
import com.fossil.cmq;
import com.fossil.wearables.fsl.sleep.MFSleepSession;
import com.google.android.gms.gcm.OneoffTask$a;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.source.SleepSessionsDataSource.LoadSleepSessionsCallback;
import com.portfolio.platform.data.source.SleepSessionsDataSource.PushPendingSleepSessionsCallback;
import com.portfolio.platform.data.source.SleepSessionsDataSource.SaveSleepSessionCallback;
import com.portfolio.platform.data.source.local.SleepSessionsLocalDataSource;
import com.portfolio.platform.data.source.remote.SleepSessionsRemoteDataSource;
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

public class SleepSessionsRepository extends SleepSessionsDataSource {
    private final String TAG = SleepSessionsRepository.class.getSimpleName();
    private final ciw mAppExecutors;
    private final NavigableMap<Long, List<MFSleepSession>> mCachedSleepSessions = new ConcurrentSkipListMap();
    private final bbm mGcmNetworkManager;
    private List<SleepSessionsRepositoryObserver> mObservers = new ArrayList();
    private final SleepSessionsDataSource mSleepSessionsLocalDataSource;
    private final SleepSessionsDataSource mSleepSessionsRemoteDataSource;

    class C48321 implements Runnable {
        C48321() {
        }

        public void run() {
            for (SleepSessionsRepositoryObserver onSleepSessionsChanged : SleepSessionsRepository.this.mObservers) {
                onSleepSessionsChanged.onSleepSessionsChanged();
            }
        }
    }

    public interface SleepSessionsRepositoryObserver {
        void onSleepSessionsChanged();
    }

    SleepSessionsRepository(@Remote SleepSessionsDataSource sleepSessionsDataSource, @Local SleepSessionsDataSource sleepSessionsDataSource2, bbm com_fossil_bbm, ciw com_fossil_ciw) {
        this.mSleepSessionsRemoteDataSource = sleepSessionsDataSource;
        this.mSleepSessionsLocalDataSource = sleepSessionsDataSource2;
        this.mGcmNetworkManager = com_fossil_bbm;
        this.mAppExecutors = com_fossil_ciw;
    }

    public void addContentObserver(SleepSessionsRepositoryObserver sleepSessionsRepositoryObserver) {
        MFLogger.d(this.TAG, "addSavedPresetObserver: observer = " + sleepSessionsRepositoryObserver);
        if (!this.mObservers.contains(sleepSessionsRepositoryObserver)) {
            this.mObservers.add(sleepSessionsRepositoryObserver);
        }
    }

    public void removeContentObserver(SleepSessionsRepositoryObserver sleepSessionsRepositoryObserver) {
        MFLogger.d(this.TAG, "removeSavedPresetObserver: observer = " + sleepSessionsRepositoryObserver);
        if (this.mObservers.contains(sleepSessionsRepositoryObserver)) {
            this.mObservers.remove(sleepSessionsRepositoryObserver);
        }
    }

    private void notifyContentObserver() {
        MFLogger.d(this.TAG, "notifyContentObserver");
        this.mAppExecutors.YS().execute(new C48321());
    }

    public void refresh() {
        notifyContentObserver();
    }

    public SortedMap<Long, List<MFSleepSession>> getCachedSleepSessionList(Date date, Date date2) {
        SortedMap<Long, List<MFSleepSession>> subMap;
        MFLogger.d(this.TAG, "getCachedSleepSessionList: startDate = " + date + ", endDate = " + date2);
        synchronized (this.mCachedSleepSessions) {
            subMap = this.mCachedSleepSessions.subMap(Long.valueOf(date.getTime()), Long.valueOf(date2.getTime()));
        }
        return subMap;
    }

    private void insertCachedSleepSessionList(Date date, Date date2, List<MFSleepSession> list) {
        MFLogger.d(this.TAG, "insertCachedSleepSessionList: sleepSessionList = " + list);
        synchronized (this.mCachedSleepSessions) {
            List arrayList;
            while (!cmq.a(date, date2)) {
                arrayList = new ArrayList();
                for (MFSleepSession mFSleepSession : list) {
                    if (cmq.e(mFSleepSession.getDate(), date.getTime())) {
                        arrayList.add(mFSleepSession);
                    }
                }
                this.mCachedSleepSessions.put(Long.valueOf(cmq.getStartOfDay(date).getTime()), arrayList);
                date = cmq.h(date);
            }
            arrayList = new ArrayList();
            for (MFSleepSession mFSleepSession2 : list) {
                if (cmq.e(mFSleepSession2.getDate(), date2.getTime())) {
                    arrayList.add(mFSleepSession2);
                }
            }
            this.mCachedSleepSessions.put(Long.valueOf(cmq.getStartOfDay(date2).getTime()), arrayList);
        }
    }

    public void cleanUp() {
        this.mSleepSessionsLocalDataSource.cleanUp();
        synchronized (this.mCachedSleepSessions) {
            this.mCachedSleepSessions.clear();
        }
    }

    public List<MFSleepSession> getSleepSessionList(Date date, Date date2) {
        MFLogger.d(this.TAG, "getSleepSessionList: start = " + date + ", end = " + date2);
        List<MFSleepSession> sleepSessionList = this.mSleepSessionsLocalDataSource.getSleepSessionList(date, date2);
        if (!(sleepSessionList == null || sleepSessionList.isEmpty())) {
            insertCachedSleepSessionList(date, date2, sleepSessionList);
        }
        ConcurrentSkipListMap concurrentSkipListMap = new ConcurrentSkipListMap(getCachedSleepSessionList(date, date2));
        if (concurrentSkipListMap.size() == cmq.d(date, date2) + 1) {
            List<MFSleepSession> arrayList = new ArrayList();
            for (List addAll : concurrentSkipListMap.values()) {
                arrayList.addAll(addAll);
            }
            return arrayList;
        }
        if (!cmq.a(date, date2)) {
            this.mGcmNetworkManager.a("SLEEP_SESSIONS-" + date.getTime(), BestTimeService.class);
        }
        getSleepSessionList(date, date2, null);
        return sleepSessionList;
    }

    public void getSleepSessionList(final Date date, final Date date2, final LoadSleepSessionsCallback loadSleepSessionsCallback) {
        this.mSleepSessionsRemoteDataSource.getSleepSessionList(date, date2, new LoadSleepSessionsCallback() {
            public void onSleepSessionsLoaded(final List<MFSleepSession> list) {
                SleepSessionsRepository.this.mAppExecutors.YQ().execute(new Runnable() {
                    public void run() {
                        SleepSessionsRepository.this.mSleepSessionsLocalDataSource.insert(list);
                        SleepSessionsRepository.this.insertCachedSleepSessionList(date, date2, SleepSessionsRepository.this.mSleepSessionsLocalDataSource.getSleepSessionList(date, date2));
                        SleepSessionsRepository.this.notifyContentObserver();
                        if (loadSleepSessionsCallback != null) {
                            loadSleepSessionsCallback.onSleepSessionsLoaded(list);
                        }
                    }
                });
            }

            public void onDataNotAvailable() {
                if (loadSleepSessionsCallback != null) {
                    loadSleepSessionsCallback.onDataNotAvailable();
                }
            }
        });
    }

    public void insertFromDevice(List<MFSleepSession> list) {
        MFLogger.d(this.TAG, "insertFromDevice: sleepSessionList = " + list);
        for (MFSleepSession pinType : list) {
            pinType.setPinType(1);
        }
        this.mSleepSessionsLocalDataSource.insertFromDevice(list);
        pushPendingSleepSessions(null);
        notifyContentObserver();
    }

    public void fetch(Date date, Date date2) {
        MFLogger.d(this.TAG, "fetch: startDate = " + date + ", endDate = " + date2);
        Bundle bundle = new Bundle();
        bundle.putString("taskId", "SLEEP_SESSIONS");
        bundle.putSerializable("START_DATE", date);
        bundle.putSerializable("END_DATE", date2);
        this.mGcmNetworkManager.a(new OneoffTask$a().m14246L(BestTimeService.class).dC("SLEEP_SESSIONS-" + date.getTime()).hJ(0).m14247c(0, 30).m14248p(bundle).Mx());
    }

    public void pushPendingSleepSessions(PushPendingSleepSessionsCallback pushPendingSleepSessionsCallback) {
        CountDownLatch countDownLatch;
        List pendingSleepSessions = ((SleepSessionsLocalDataSource) this.mSleepSessionsLocalDataSource).getPendingSleepSessions();
        if (pendingSleepSessions != null) {
            if (pushPendingSleepSessionsCallback == null || pendingSleepSessions.size() <= 0) {
                countDownLatch = null;
            } else {
                countDownLatch = new CountDownLatch(pendingSleepSessions.size());
            }
            saveSleepSessionsToServer(pendingSleepSessions, countDownLatch);
        } else {
            countDownLatch = null;
        }
        if (countDownLatch != null) {
            try {
                MFLogger.d(this.TAG, "Await on thread=" + Thread.currentThread().getName());
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
        if (pushPendingSleepSessionsCallback != null) {
            pushPendingSleepSessionsCallback.onDone();
        }
    }

    private void saveSleepSessionsToServer(List<MFSleepSession> list, final CountDownLatch countDownLatch) {
        for (MFSleepSession insertSleepSession : list) {
            ((SleepSessionsRemoteDataSource) this.mSleepSessionsRemoteDataSource).insertSleepSession(insertSleepSession, new SaveSleepSessionCallback() {
                public void saveSuccess(MFSleepSession mFSleepSession) {
                    MFLogger.d(SleepSessionsRepository.this.TAG, "saveSleepSessionsToServer success, bravo!!!");
                    ((SleepSessionsLocalDataSource) SleepSessionsRepository.this.mSleepSessionsLocalDataSource).updateSleepSessionPinType(mFSleepSession, 0);
                    if (countDownLatch != null) {
                        countDownLatch.countDown();
                    }
                }

                public void saveFailed(int i, MFSleepSession mFSleepSession) {
                    MFLogger.d(SleepSessionsRepository.this.TAG, "saveSleepSessionsToServer failed, errorCode=" + i);
                    if (i == MFNetworkReturnCode.BAD_REQUEST || i == MFNetworkReturnCode.ITEM_NAME_IN_USED) {
                        ((SleepSessionsLocalDataSource) SleepSessionsRepository.this.mSleepSessionsLocalDataSource).updateSleepSessionPinType(mFSleepSession, 0);
                    }
                    if (countDownLatch != null) {
                        countDownLatch.countDown();
                    }
                }
            });
        }
    }
}
