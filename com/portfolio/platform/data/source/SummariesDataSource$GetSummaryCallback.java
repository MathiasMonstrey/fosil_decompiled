package com.portfolio.platform.data.source;

import com.fossil.wearables.fsl.fitness.SampleDay;

public interface SummariesDataSource$GetSummaryCallback {
    void onDataNotAvailable();

    void onSummaryLoaded(SampleDay sampleDay);
}
