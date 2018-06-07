package com.portfolio.platform.data.source;

import com.fossil.wearables.fsl.fitness.SampleDay;
import java.util.List;

public interface SummariesDataSource$LoadSummariesCallback {
    void onDataNotAvailable();

    void onSummariesLoaded(List<SampleDay> list);
}
