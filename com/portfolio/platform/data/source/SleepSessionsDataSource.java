package com.portfolio.platform.data.source;

import com.fossil.wearables.fsl.sleep.MFSleepSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class SleepSessionsDataSource {

    public interface LoadSleepSessionsCallback {
        void onDataNotAvailable();

        void onSleepSessionsLoaded(List<MFSleepSession> list);
    }

    public interface PushPendingSleepSessionsCallback {
        void onDone();
    }

    public interface SaveSleepSessionCallback {
        void saveFailed(int i, MFSleepSession mFSleepSession);

        void saveSuccess(MFSleepSession mFSleepSession);
    }

    public void insert(List<MFSleepSession> list) {
    }

    public List<MFSleepSession> getSleepSessionList(Date date, Date date2) {
        return new ArrayList();
    }

    public void getSleepSessionList(Date date, Date date2, LoadSleepSessionsCallback loadSleepSessionsCallback) {
    }

    public void insertFromDevice(List<MFSleepSession> list) {
    }

    public boolean isExistsSleepSession(MFSleepSession mFSleepSession) {
        return false;
    }

    public void cleanUp() {
    }
}
