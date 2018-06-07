package com.portfolio.platform.data.source;

import com.fossil.wearables.fsl.fitness.SampleRaw;
import java.util.Date;
import java.util.List;

public abstract class ActivitiesDataSource {

    public interface LoadActivitiesCallback {
        void onActivitiesLoaded(List<SampleRaw> list);

        void onDataNotAvailable();
    }

    public interface PushPendingActivitiesCallback {
        void onDone();
    }

    public interface SaveSampleRawCallback {
        void saveFailed(int i, SampleRaw sampleRaw);

        void saveSuccess(SampleRaw sampleRaw);
    }

    public List<SampleRaw> getActivityList(Date date, Date date2) {
        return null;
    }

    public void getActivityList(Date date, Date date2, LoadActivitiesCallback loadActivitiesCallback) {
    }

    public void insertFromDevice(List<SampleRaw> list) {
    }

    public void insert(List<SampleRaw> list) {
    }

    public List<SampleRaw> getPendingActivities() {
        return null;
    }

    public void updateActivityPinType(SampleRaw sampleRaw) {
    }

    public void insertActivity(SampleRaw sampleRaw, SaveSampleRawCallback saveSampleRawCallback) {
    }

    public void cleanUp() {
    }
}
