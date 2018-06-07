package com.portfolio.platform.data.source;

import android.text.TextUtils;
import com.fossil.cmq;
import com.fossil.cnr;
import com.fossil.emj;
import com.misfit.frameworks.buttonservice.model.Alarm;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.source.AlarmsDataSource.DeleteAlarmCallback;
import com.portfolio.platform.data.source.AlarmsDataSource.LoadAlarmsCallback;
import com.portfolio.platform.data.source.AlarmsDataSource.PushPendingAlarmsCallback;
import com.portfolio.platform.data.source.AlarmsDataSource.PutAlarmCallback;
import com.portfolio.platform.data.source.AlarmsSettingDataSource.GetAlarmsSettingCallback;
import com.portfolio.platform.data.source.scope.Local;
import com.portfolio.platform.data.source.scope.Remote;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class AlarmsRepository implements AlarmsDataSource {
    private final String TAG = "AlarmsRepository";
    private final AlarmsDataSource mAlarmsLocalDataSource;
    private final AlarmsDataSource mAlarmsRemoteDataSource;
    private final AlarmsSettingRepository mAlarmsSettingRepository;
    private boolean mCacheIsDirty = true;
    private List<Alarm> mCachedAlarms;
    private final cnr mSharedPreferencesManager;

    class C47461 implements PutAlarmCallback {
        C47461() {
        }

        public void onPutAlarmSuccess(Alarm alarm) {
            MFLogger.d("AlarmsRepository", "setAlarm onPutAlarmSuccess");
            alarm.setPinType(0);
            alarm.setSynced(true);
            AlarmsRepository.this.mAlarmsLocalDataSource.setAlarm(alarm, null);
            AlarmsRepository.this.setCachedAlarm(alarm);
        }

        public void onPutAlarmError() {
        }
    }

    class C47472 implements DeleteAlarmCallback {
        C47472() {
        }

        public void onDeleteAlarmSuccess(Alarm alarm) {
            AlarmsRepository.this.mAlarmsLocalDataSource.deleteAlarm(alarm, null);
        }

        public void onDeleteAlarmError() {
        }
    }

    class C47524 implements LoadAlarmsCallback {
        C47524() {
        }

        public void onAlarmsLoaded(List<Alarm> list) {
            AlarmsRepository.this.mAlarmsSettingRepository.setAlarmsSetting(true, null);
        }

        public void onDataNotAvailable() {
        }
    }

    class C47546 implements LoadAlarmsCallback {
        C47546() {
        }

        public void onAlarmsLoaded(List<Alarm> list) {
            PortfolioApp.ZQ().H(list);
        }

        public void onDataNotAvailable() {
        }
    }

    public AlarmsRepository(@Remote AlarmsDataSource alarmsDataSource, @Local AlarmsDataSource alarmsDataSource2, AlarmsSettingRepository alarmsSettingRepository, cnr com_fossil_cnr) {
        this.mAlarmsRemoteDataSource = (AlarmsDataSource) emj.f(alarmsDataSource, "alarmsRemoteDataSource cannot be null!");
        this.mAlarmsLocalDataSource = (AlarmsDataSource) emj.f(alarmsDataSource2, "alarmsLocalDataSource cannot be null!");
        this.mAlarmsSettingRepository = (AlarmsSettingRepository) emj.f(alarmsSettingRepository, "alarmsSettingRepository cannot be null!");
        this.mSharedPreferencesManager = (cnr) emj.f(com_fossil_cnr, "sharedPreferencesManager cannot be null!");
    }

    public void getAlarms(LoadAlarmsCallback loadAlarmsCallback) {
        MFLogger.d("AlarmsRepository", "getAlarms");
        emj.ce(loadAlarmsCallback);
        if (this.mCachedAlarms == null || this.mCacheIsDirty) {
            if (this.mCacheIsDirty) {
                MFLogger.d("AlarmsRepository", "getAlarms - getAlarmsFromRemoteDataSource()");
                getAlarmsFromRemoteDataSource(loadAlarmsCallback);
            }
        } else if (this.mCachedAlarms.isEmpty()) {
            MFLogger.d("AlarmsRepository", "getAlarms - onDataNotAvailable");
            loadAlarmsCallback.onDataNotAvailable();
        } else {
            MFLogger.d("AlarmsRepository", "getAlarms - mCachedAlarms.size(): " + this.mCachedAlarms.size());
            loadAlarmsCallback.onAlarmsLoaded(this.mCachedAlarms);
        }
    }

    public void getAllAlarmIgnorePinType(LoadAlarmsCallback loadAlarmsCallback) {
        this.mAlarmsLocalDataSource.getAllAlarmIgnorePinType(loadAlarmsCallback);
    }

    public void setAlarm(Alarm alarm, PutAlarmCallback putAlarmCallback) {
        MFLogger.d("AlarmsRepository", "setAlarm - alarm: " + alarm.getAlarmTitle());
        Alarm findAlarm = findAlarm(alarm.getUri());
        if (findAlarm != null) {
            findAlarm.update(alarm);
            alarm = findAlarm;
        }
        alarm.setPinType(1);
        this.mAlarmsLocalDataSource.setAlarm(alarm, null);
        setCachedAlarm(alarm);
        updateAlarmsSetting();
        this.mAlarmsRemoteDataSource.setAlarm(alarm, new C47461());
    }

    public void deleteAlarm(Alarm alarm, DeleteAlarmCallback deleteAlarmCallback) {
        MFLogger.d("AlarmsRepository", "deleteAlarm - alarm: " + alarm.getAlarmTitle());
        Alarm findAlarm = findAlarm(alarm.getUri());
        if (findAlarm != null) {
            findAlarm.update(alarm);
            alarm = findAlarm;
        }
        alarm.setPinType(3);
        this.mAlarmsLocalDataSource.setAlarm(alarm, null);
        this.mCachedAlarms.remove(alarmsFindById(this.mCachedAlarms, alarm.getUri()));
        updateAlarmsSetting();
        if (TextUtils.isEmpty(alarm.getObjectId())) {
            this.mAlarmsLocalDataSource.deleteAlarm(alarm, deleteAlarmCallback);
        } else {
            this.mAlarmsRemoteDataSource.deleteAlarm(alarm, new C47472());
        }
    }

    public void cleanUp() {
        this.mAlarmsLocalDataSource.cleanUp();
        clearCache();
    }

    public Alarm findAlarm(String str) {
        if (this.mCacheIsDirty) {
            MFLogger.d("AlarmsRepository", "findAlarm mAlarmsLocalDataSource - id: " + str);
            return this.mAlarmsLocalDataSource.findAlarm(str);
        }
        MFLogger.d("AlarmsRepository", "findAlarm mCachedAlarms - id: " + str);
        return alarmsFindById(this.mCachedAlarms, str);
    }

    public void getActiveAlarms(LoadAlarmsCallback loadAlarmsCallback) {
        MFLogger.d("AlarmsRepository", "getActiveAlarms");
        emj.ce(loadAlarmsCallback);
        if (this.mCachedAlarms == null || this.mCacheIsDirty) {
            MFLogger.d("AlarmsRepository", "getAlarms - mAlarmsLocalDataSource");
            this.mAlarmsLocalDataSource.getActiveAlarms(loadAlarmsCallback);
            return;
        }
        getCachedAlarmsActive(loadAlarmsCallback);
    }

    private void setCachedAlarm(Alarm alarm) {
        if (this.mCachedAlarms == null) {
            this.mCachedAlarms = new ArrayList();
        } else {
            for (Alarm alarm2 : this.mCachedAlarms) {
                if (alarm2.is(alarm)) {
                    this.mCachedAlarms.set(this.mCachedAlarms.indexOf(alarm2), alarm);
                    return;
                }
            }
        }
        this.mCachedAlarms.add(alarm);
    }

    private void refreshCache(List<Alarm> list) {
        if (this.mCachedAlarms == null) {
            this.mCachedAlarms = new ArrayList();
        } else {
            this.mCachedAlarms.clear();
        }
        this.mCachedAlarms.addAll(list);
        this.mCacheIsDirty = false;
    }

    public void clearCache() {
        this.mCacheIsDirty = true;
        if (this.mCachedAlarms != null) {
            this.mCachedAlarms.clear();
        }
    }

    private void getAlarmsFromRemoteDataSource(final LoadAlarmsCallback loadAlarmsCallback) {
        MFLogger.d("AlarmsRepository", "getAlarmsFromRemoteDataSource - callback=" + loadAlarmsCallback);
        this.mAlarmsRemoteDataSource.getAlarms(new LoadAlarmsCallback() {

            class C47502 implements LoadAlarmsCallback {
                C47502() {
                }

                public void onAlarmsLoaded(final List<Alarm> list) {
                    AlarmsRepository.this.mAlarmsSettingRepository.getAlarmsSetting(new GetAlarmsSettingCallback() {
                        public void onGetAlarmsSettingSuccess(boolean z) {
                            if (!z) {
                                for (Alarm alarm : list) {
                                    alarm.setActive(false);
                                    AlarmsRepository.this.mAlarmsLocalDataSource.setAlarm(alarm, null);
                                }
                            }
                            AlarmsRepository.this.refreshCache(list);
                            loadAlarmsCallback.onAlarmsLoaded(list);
                        }

                        public void onGetAlarmsSettingError() {
                            loadAlarmsCallback.onAlarmsLoaded(list);
                        }
                    });
                }

                public void onDataNotAvailable() {
                    loadAlarmsCallback.onDataNotAvailable();
                }
            }

            public void onAlarmsLoaded(final List<Alarm> list) {
                if (AlarmsRepository.this.mSharedPreferencesManager.acZ()) {
                    AlarmsRepository.this.migrateServerAlarms(list, loadAlarmsCallback, false);
                    return;
                }
                AlarmsRepository.this.mAlarmsSettingRepository.refreshAlarmsSetting();
                AlarmsRepository.this.mAlarmsSettingRepository.getAlarmsSetting(new GetAlarmsSettingCallback() {
                    public void onGetAlarmsSettingSuccess(boolean z) {
                        AlarmsRepository.this.migrateServerAlarms(list, loadAlarmsCallback, !z);
                        AlarmsRepository.this.mSharedPreferencesManager.bZ(true);
                    }

                    public void onGetAlarmsSettingError() {
                        AlarmsRepository.this.migrateServerAlarms(list, loadAlarmsCallback, false);
                    }
                });
            }

            public void onDataNotAvailable() {
                AlarmsRepository.this.mAlarmsLocalDataSource.getAlarms(new C47502());
            }
        });
    }

    private Alarm alarmsFindById(List<Alarm> list, String str) {
        if (list != null) {
            for (Alarm alarm : list) {
                if (alarm.getUri().equals(str)) {
                    return alarm;
                }
            }
        }
        return null;
    }

    private void getCachedAlarmsActive(LoadAlarmsCallback loadAlarmsCallback) {
        List arrayList = new ArrayList();
        for (Alarm alarm : this.mCachedAlarms) {
            if (alarm.isActive()) {
                arrayList.add(alarm);
            }
        }
        if (arrayList.isEmpty()) {
            loadAlarmsCallback.onDataNotAvailable();
            return;
        }
        MFLogger.d("AlarmsRepository", "getActiveAlarms - activeAlarms.size(): " + arrayList.size());
        loadAlarmsCallback.onAlarmsLoaded(arrayList);
    }

    private void updateAlarmsSetting() {
        getActiveAlarms(new C47524());
    }

    private void migrateServerAlarms(final List<Alarm> list, final LoadAlarmsCallback loadAlarmsCallback, final boolean z) {
        MFLogger.d("AlarmsRepository", "migrateServerAlarms - serverAlarms=" + list + ", callback=" + loadAlarmsCallback + ", disableAlarmSetting=" + z);
        this.mAlarmsLocalDataSource.getAllAlarmIgnorePinType(new LoadAlarmsCallback() {
            public void onAlarmsLoaded(List<Alarm> list) {
                MFLogger.i("AlarmsRepository", "migrateServerAlarms - onAlarmsLoaded with alarms=" + list.size());
                List arrayList = new ArrayList();
                for (Alarm alarm : list) {
                    int i;
                    if (alarm.getPinType() == 0 && TextUtils.isEmpty(alarm.getObjectId())) {
                        alarm.setPinType(1);
                    }
                    for (Alarm alarm2 : list) {
                        if (alarm.is(alarm2)) {
                            if (cmq.fZ(alarm2.getUpdatedAt()).getTime() > cmq.fZ(alarm.getUpdatedAt()).getTime()) {
                                alarm2.setPinType(0);
                                arrayList.add(alarm2);
                            } else {
                                alarm2.setPinType(0);
                                arrayList.add(alarm);
                            }
                            i = 1;
                            if (i == 0 && alarm.getPinType() != 3) {
                                arrayList.add(alarm);
                            }
                        }
                    }
                    i = 0;
                    arrayList.add(alarm);
                }
                for (Alarm alarm3 : list) {
                    if (alarm3.getPinType() == -1) {
                        alarm3.setPinType(0);
                        arrayList.add(alarm3);
                    }
                }
                AlarmsRepository.this.updateLocalAlarms(list, arrayList, loadAlarmsCallback, z);
            }

            public void onDataNotAvailable() {
                MFLogger.i("AlarmsRepository", "migrateServerAlarms - onDataNotAvailable!!!");
                for (Alarm pinType : list) {
                    pinType.setPinType(0);
                }
                AlarmsRepository.this.updateLocalAlarms(null, list, loadAlarmsCallback, z);
            }
        });
    }

    private void updateLocalAlarms(List<Alarm> list, List<Alarm> list2, LoadAlarmsCallback loadAlarmsCallback, boolean z) {
        MFLogger.d("AlarmsRepository", "updateLocalAlarms - localAlarms=" + list + ", serverAlarms=" + list2);
        if (list != null) {
            for (Alarm deleteAlarm : list) {
                this.mAlarmsLocalDataSource.deleteAlarm(deleteAlarm, null);
            }
        }
        for (Alarm deleteAlarm2 : list2) {
            deleteAlarm2.setSynced(true);
            if (!z || deleteAlarm2.getPinType() == 3) {
                this.mAlarmsLocalDataSource.setAlarm(deleteAlarm2, null);
            } else {
                deleteAlarm2.setActive(false);
                setAlarm(deleteAlarm2, null);
            }
        }
        List arrayList = new ArrayList();
        for (Alarm deleteAlarm22 : list2) {
            if (deleteAlarm22.getPinType() != 3) {
                arrayList.add(deleteAlarm22);
            }
        }
        refreshCache(arrayList);
        loadAlarmsCallback.onAlarmsLoaded(arrayList);
        getActiveAlarms(new C47546());
    }

    public void executePendingRequest(final PushPendingAlarmsCallback pushPendingAlarmsCallback) {
        MFLogger.d("AlarmsRepository", "executePendingRequest");
        this.mAlarmsLocalDataSource.getAllAlarmIgnorePinType(new LoadAlarmsCallback() {
            public void onAlarmsLoaded(List<Alarm> list) {
                CountDownLatch countDownLatch;
                if (pushPendingAlarmsCallback == null || list.size() <= 0) {
                    countDownLatch = null;
                } else {
                    countDownLatch = new CountDownLatch(list.size());
                }
                for (Alarm alarm : list) {
                    switch (alarm.getPinType()) {
                        case 1:
                            MFLogger.d("AlarmsRepository", "executePendingRequest - TYPE_PIN_ADD with alarmId=" + alarm.getUri());
                            AlarmsRepository.this.mAlarmsRemoteDataSource.setAlarm(alarm, new PutAlarmCallback() {
                                public void onPutAlarmSuccess(Alarm alarm) {
                                    MFLogger.d("AlarmsRepository", "onPutAlarmSuccess, bravo!!!");
                                    alarm.setSynced(true);
                                    alarm.setPinType(0);
                                    AlarmsRepository.this.mAlarmsLocalDataSource.setAlarm(alarm, null);
                                    AlarmsRepository.this.setCachedAlarm(alarm);
                                    if (countDownLatch != null) {
                                        countDownLatch.countDown();
                                    }
                                }

                                public void onPutAlarmError() {
                                    MFLogger.d("AlarmsRepository", "onPutAlarmError!!!");
                                    if (countDownLatch != null) {
                                        countDownLatch.countDown();
                                    }
                                }
                            });
                            break;
                        case 3:
                            MFLogger.d("AlarmsRepository", "executePendingRequest - TYPE_PIN_DELETE with alarmId=" + alarm.getUri());
                            AlarmsRepository.this.mAlarmsRemoteDataSource.deleteAlarm(alarm, new DeleteAlarmCallback() {
                                public void onDeleteAlarmSuccess(Alarm alarm) {
                                    MFLogger.d("AlarmsRepository", "onDeleteAlarmSuccess!!!");
                                    AlarmsRepository.this.mAlarmsLocalDataSource.deleteAlarm(alarm, null);
                                    if (countDownLatch != null) {
                                        countDownLatch.countDown();
                                    }
                                }

                                public void onDeleteAlarmError() {
                                    MFLogger.d("AlarmsRepository", "onDeleteAlarmError!!!");
                                    if (countDownLatch != null) {
                                        countDownLatch.countDown();
                                    }
                                }
                            });
                            break;
                        default:
                            if (countDownLatch == null) {
                                break;
                            }
                            countDownLatch.countDown();
                            break;
                    }
                }
                if (countDownLatch != null) {
                    try {
                        MFLogger.d("AlarmsRepository", "Await on thread=" + Thread.currentThread().getName());
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return;
                    }
                }
                if (pushPendingAlarmsCallback != null) {
                    pushPendingAlarmsCallback.onDone();
                }
            }

            public void onDataNotAvailable() {
                if (pushPendingAlarmsCallback != null) {
                    pushPendingAlarmsCallback.onDone();
                }
            }
        });
        this.mAlarmsSettingRepository.executePendingRequest();
    }
}
