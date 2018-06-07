package com.portfolio.platform.data.source;

import com.fossil.wearables.fsl.fitness.FitnessProviderImpl;
import com.fossil.wearables.fsl.fitness.SampleDay;
import java.util.Date;
import java.util.List;

public abstract class SummariesDataSource {
    public abstract void insert(SampleDay sampleDay);

    public abstract void updateLastStepGoal(Date date, int i, UpdateStepGoalCallback updateStepGoalCallback);

    public SampleDay getSummary(Date date) {
        return null;
    }

    public int getLastStepGoal(Date date) {
        return FitnessProviderImpl.DEFAULT_DAILY_STEP_GOAL;
    }

    public void getSummary(Date date, GetSummaryCallback getSummaryCallback) {
    }

    public List<SampleDay> loadSummaries(Date date, Date date2) {
        return null;
    }

    public void loadSummaries(Date date, Date date2, LoadSummariesCallback loadSummariesCallback) {
    }

    public void cleanUp() {
    }
}
