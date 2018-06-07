package com.portfolio.platform.data.source;

import com.fossil.wearables.fsl.fitness.SampleDay;
import com.portfolio.platform.manager.network.BestTimeService;
import java.util.Date;

class SummariesRepository$3 implements SummariesDataSource$GetSummaryCallback {
    final /* synthetic */ SummariesRepository this$0;
    final /* synthetic */ SummariesDataSource$GetSummaryCallback val$callback;
    final /* synthetic */ Date val$date;

    SummariesRepository$3(SummariesRepository summariesRepository, Date date, SummariesDataSource$GetSummaryCallback summariesDataSource$GetSummaryCallback) {
        this.this$0 = summariesRepository;
        this.val$date = date;
        this.val$callback = summariesDataSource$GetSummaryCallback;
    }

    public void onSummaryLoaded(final SampleDay sampleDay) {
        SummariesRepository.access$200(this.this$0).a("SUMMARY-" + this.val$date.getTime(), BestTimeService.class);
        SummariesRepository.access$400(this.this$0).YQ().execute(new Runnable() {
            public void run() {
                SummariesRepository.access$100(SummariesRepository$3.this.this$0).insert(sampleDay);
                SummariesRepository.access$300(SummariesRepository$3.this.this$0);
                if (SummariesRepository$3.this.val$callback != null) {
                    SummariesRepository$3.this.val$callback.onSummaryLoaded(sampleDay);
                }
            }
        });
    }

    public void onDataNotAvailable() {
    }
}
