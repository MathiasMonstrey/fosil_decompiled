package com.portfolio.platform.data.source;

import android.os.Bundle;
import com.fossil.bbm;
import com.fossil.ciw;
import com.fossil.wearables.fsl.fitness.SampleDay;
import com.google.android.gms.gcm.OneoffTask.a;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.source.SummariesDataSource.GetSummaryCallback;
import com.portfolio.platform.data.source.SummariesDataSource.LoadSummariesCallback;
import com.portfolio.platform.data.source.SummariesDataSource.UpdateStepGoalCallback;
import com.portfolio.platform.data.source.scope.Local;
import com.portfolio.platform.data.source.scope.Remote;
import com.portfolio.platform.manager.network.BestTimeService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SummariesRepository extends SummariesDataSource {
    private final String TAG = SummariesRepository.class.getSimpleName();
    private final ciw mAppExecutors;
    private final bbm mGcmNetworkManager;
    private List<SummariesRepositoryObserver> mObservers = new ArrayList();
    private final SummariesDataSource mSummariesLocalDataSource;
    private final SummariesDataSource mSummariesRemoteDataSource;

    SummariesRepository(@Remote SummariesDataSource summariesDataSource, @Local SummariesDataSource summariesDataSource2, bbm com_fossil_bbm, ciw com_fossil_ciw) {
        this.mSummariesRemoteDataSource = summariesDataSource;
        this.mSummariesLocalDataSource = summariesDataSource2;
        this.mGcmNetworkManager = com_fossil_bbm;
        this.mAppExecutors = com_fossil_ciw;
    }

    public void addContentObserver(SummariesRepositoryObserver summariesRepositoryObserver) {
        MFLogger.m12670d(this.TAG, "addSavedPresetObserver: observer = " + summariesRepositoryObserver);
        if (!this.mObservers.contains(summariesRepositoryObserver)) {
            this.mObservers.add(summariesRepositoryObserver);
        }
    }

    public void removeContentObserver(SummariesRepositoryObserver summariesRepositoryObserver) {
        MFLogger.m12670d(this.TAG, "removeSavedPresetObserver: observer = " + summariesRepositoryObserver);
        if (this.mObservers.contains(summariesRepositoryObserver)) {
            this.mObservers.remove(summariesRepositoryObserver);
        }
    }

    private void notifyContentObserver() {
        MFLogger.m12670d(this.TAG, "notifyContentObserver");
        this.mAppExecutors.YS().execute(new 1(this));
    }

    public void refresh() {
        notifyContentObserver();
    }

    public SampleDay getSummary(Date date) {
        MFLogger.m12670d(this.TAG, "getSummary: date = " + date);
        SampleDay summary = this.mSummariesLocalDataSource.getSummary(date);
        if (summary == null) {
            getSummary(date, null);
        }
        return summary;
    }

    public int getLastStepGoal(Date date) {
        return this.mSummariesLocalDataSource.getLastStepGoal(date);
    }

    public void updateLastStepGoal(Date date, int i, UpdateStepGoalCallback updateStepGoalCallback) {
        this.mSummariesRemoteDataSource.updateLastStepGoal(date, i, new 2(this, date, i, updateStepGoalCallback));
    }

    public void getSummary(Date date, GetSummaryCallback getSummaryCallback) {
        SampleDay summary = this.mSummariesLocalDataSource.getSummary(date);
        if (summary == null) {
            this.mSummariesRemoteDataSource.getSummary(date, new 3(this, date, getSummaryCallback));
        } else if (getSummaryCallback != null) {
            getSummaryCallback.onSummaryLoaded(summary);
        }
    }

    public List<SampleDay> loadSummaries(Date date, Date date2) {
        MFLogger.m12670d(this.TAG, "loadSummaries: startDate = " + date + ", endDate = " + date2);
        return this.mSummariesLocalDataSource.loadSummaries(date, date2);
    }

    public void loadSummaries(Date date, Date date2, LoadSummariesCallback loadSummariesCallback) {
        this.mSummariesRemoteDataSource.loadSummaries(date, date2, new 4(this, date, date2));
    }

    public void insert(SampleDay sampleDay) {
    }

    public void cleanUp() {
        this.mSummariesLocalDataSource.cleanUp();
    }

    public void fetch(Date date) {
        MFLogger.m12670d(this.TAG, "fetch: date = " + date);
        Bundle bundle = new Bundle();
        bundle.putString("taskId", "SUMMARY");
        bundle.putSerializable("START_DATE", date);
        this.mGcmNetworkManager.m4804a(new a().L(BestTimeService.class).dC("SUMMARY-" + date.getTime()).hJ(0).c(0, 30).p(bundle).Mx());
    }

    public void fetch(Date date, Date date2) {
        MFLogger.m12670d(this.TAG, "fetch: startDate = " + date + ", endDate = " + date2);
        Bundle bundle = new Bundle();
        bundle.putString("taskId", "SUMMARIES");
        bundle.putSerializable("START_DATE", date);
        bundle.putSerializable("END_DATE", date2);
        this.mGcmNetworkManager.m4804a(new a().L(BestTimeService.class).dC("SUMMARIES-" + date.getTime()).hJ(0).c(0, 30).p(bundle).Mx());
    }
}
