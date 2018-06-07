package com.portfolio.platform.data.source.local;

import com.fossil.cmq;
import com.fossil.cnq;
import com.fossil.wearables.fsl.sleep.MFSleepSession;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.source.SleepSessionsDataSource;
import java.util.Date;
import java.util.List;

public class SleepSessionsLocalDataSource extends SleepSessionsDataSource {
    private static final String TAG = SleepSessionsLocalDataSource.class.getSimpleName();
    private final cnq mProviderManager;

    public SleepSessionsLocalDataSource(cnq com_fossil_cnq) {
        this.mProviderManager = com_fossil_cnq;
    }

    public List<MFSleepSession> getSleepSessionList(Date date, Date date2) {
        MFLogger.d(TAG, "getActivityList: start = " + date + ", end = " + date2);
        return this.mProviderManager.aco().getSleepSessions(date.getTime(), date2.getTime());
    }

    protected void insertFromDevice(List<MFSleepSession> list) {
        MFLogger.d(TAG, "insertFromDevice: sleepSessionList = " + list);
        for (MFSleepSession mFSleepSession : list) {
            if (isExistsSleepSession(mFSleepSession)) {
                MFLogger.d(TAG, ".saveSyncResult - Sleep session already existed");
            } else if (this.mProviderManager.acn().getSleepSession((long) mFSleepSession.getRealEndTime()) == null) {
                MFLogger.d(TAG, ".saveSyncResult - Saving sleep session to local database");
                this.mProviderManager.acn().addSleepSession(mFSleepSession);
            } else {
                MFLogger.d(TAG, ".saveSyncResult - Sleep session already existed");
            }
        }
    }

    public void insert(List<MFSleepSession> list) {
        MFLogger.d(TAG, "insertFromDevice: sleepSessionList = " + list);
        for (MFSleepSession mFSleepSession : list) {
            if (mFSleepSession.getDate() >= 0) {
                MFSleepSession sleepSession = this.mProviderManager.acn().getSleepSession((long) mFSleepSession.getRealEndTime());
                if (sleepSession == null || sleepSession.getUpdatedAt() == null) {
                    mFSleepSession.setEditedSleepMinutes(mFSleepSession.getRealSleepMinutes());
                    mFSleepSession.setEditedStartTime(mFSleepSession.getRealStartTime());
                    mFSleepSession.setEditedEndTime(mFSleepSession.getRealEndTime());
                    mFSleepSession.setEditedSleepStateDistInMinute(mFSleepSession.getRealSleepStateDistInMinute());
                    MFLogger.i(TAG, "Insert sleep session - date=" + cmq.a(new Date(mFSleepSession.getDate())) + ", sleepDistribution=" + mFSleepSession.getEditedSleepStateDistInMinute());
                    this.mProviderManager.aco().a(mFSleepSession);
                } else if (sleepSession.getUpdatedAt().getMillis() < mFSleepSession.getUpdatedAt().getMillis()) {
                    mFSleepSession.setEditedSleepMinutes(mFSleepSession.getRealSleepMinutes());
                    mFSleepSession.setEditedStartTime(mFSleepSession.getRealStartTime());
                    mFSleepSession.setEditedEndTime(mFSleepSession.getRealEndTime());
                    mFSleepSession.setEditedSleepStateDistInMinute(mFSleepSession.getRealSleepStateDistInMinute());
                    MFLogger.i(TAG, "Edit sleep session - date=" + cmq.a(new Date(mFSleepSession.getDate())) + ", sleepDistribution=" + mFSleepSession.getEditedSleepStateDistInMinute());
                    this.mProviderManager.aco().a(mFSleepSession);
                }
            }
        }
    }

    protected boolean isExistsSleepSession(MFSleepSession mFSleepSession) {
        List<MFSleepSession> sleepSessions = this.mProviderManager.acn().getSleepSessions(mFSleepSession.getDay());
        long editedStartTime = (long) mFSleepSession.getEditedStartTime();
        long editedEndTime = (long) mFSleepSession.getEditedEndTime();
        if (sleepSessions != null) {
            for (MFSleepSession mFSleepSession2 : sleepSessions) {
                long editedStartTime2 = (long) mFSleepSession2.getEditedStartTime();
                long editedEndTime2 = (long) mFSleepSession2.getEditedEndTime();
                if ((editedStartTime2 <= editedStartTime && editedStartTime <= editedEndTime2) || ((editedStartTime2 <= editedEndTime && editedEndTime <= editedEndTime2) || ((editedStartTime <= editedStartTime2 && editedEndTime2 <= editedEndTime) || (editedStartTime <= editedEndTime2 && editedEndTime2 <= editedEndTime)))) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<MFSleepSession> getPendingSleepSessions() {
        return this.mProviderManager.acn().getPendingSleepSessions();
    }

    public void updateSleepSessionPinType(MFSleepSession mFSleepSession, int i) {
        if (mFSleepSession != null) {
            MFLogger.d(TAG, "updateSleepSessionPinType: pinType to " + i);
            this.mProviderManager.acn().updateSleepSessionPinType(mFSleepSession, i);
        }
    }

    protected void cleanUp() {
        this.mProviderManager.aco().aev();
    }
}
