package com.portfolio.platform.data.source;

import com.fossil.cmq;
import com.fossil.wearables.fsl.fitness.SampleDay;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.manager.network.BestTimeService;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

class SummariesRepository$4 implements SummariesDataSource$LoadSummariesCallback {
    final /* synthetic */ SummariesRepository this$0;
    final /* synthetic */ Date val$endDate;
    final /* synthetic */ Date val$startDate;

    SummariesRepository$4(SummariesRepository summariesRepository, Date date, Date date2) {
        this.this$0 = summariesRepository;
        this.val$startDate = date;
        this.val$endDate = date2;
    }

    public void onSummariesLoaded(final List<SampleDay> list) {
        SummariesRepository.access$200(this.this$0).a("SUMMARIES-" + this.val$startDate.getTime(), BestTimeService.class);
        SummariesRepository.access$400(this.this$0).YQ().execute(new Runnable() {

            class C48461 implements SummariesDataSource$GetSummaryCallback {
                C48461() {
                }

                public void onSummaryLoaded(final SampleDay sampleDay) {
                    SummariesRepository.access$200(SummariesRepository$4.this.this$0).a("SUMMARY-" + SummariesRepository$4.this.val$startDate.getTime(), BestTimeService.class);
                    SummariesRepository.access$400(SummariesRepository$4.this.this$0).YQ().execute(new Runnable() {
                        public void run() {
                            SummariesRepository.access$100(SummariesRepository$4.this.this$0).insert(sampleDay);
                            C48471.this.handleSummaries(sampleDay);
                        }
                    });
                }

                public void onDataNotAvailable() {
                }
            }

            public void run() {
                SampleDay summary = SummariesRepository.access$100(SummariesRepository$4.this.this$0).getSummary(SummariesRepository$4.this.val$startDate);
                if (summary == null) {
                    SummariesRepository.access$600(SummariesRepository$4.this.this$0).getSummary(SummariesRepository$4.this.val$startDate, new C48461());
                } else {
                    handleSummaries(summary);
                }
            }

            private void handleSummaries(SampleDay sampleDay) {
                Date time;
                Date date = SummariesRepository$4.this.val$startDate;
                if (!list.isEmpty()) {
                    Collections.reverse(list);
                    SampleDay sampleDay2 = (SampleDay) list.get(0);
                    Calendar instance = Calendar.getInstance();
                    instance.set(1, sampleDay2.getYear());
                    instance.set(2, sampleDay2.getMonth() - 1);
                    instance.set(5, sampleDay2.getDay());
                    time = instance.getTime();
                    if (sampleDay != null && cmq.d(SummariesRepository$4.this.val$startDate, time) > 1) {
                        SummariesRepository$4.this.fillSummary(sampleDay, SummariesRepository$4.this.val$startDate, time);
                    }
                    date = time;
                    for (SampleDay sampleDay22 : list) {
                        SummariesRepository.access$100(SummariesRepository$4.this.this$0).insert(sampleDay22);
                        instance.set(1, sampleDay22.getYear());
                        instance.set(2, sampleDay22.getMonth() - 1);
                        instance.set(5, sampleDay22.getDay());
                        Date time2 = instance.getTime();
                        if (cmq.d(date, time2) > 1) {
                            SummariesRepository$4.this.fillSummary(sampleDay22, date, time2);
                        }
                        date = time2;
                        sampleDay = sampleDay22;
                    }
                }
                time = cmq.e(new Date(), SummariesRepository$4.this.val$endDate) ? SummariesRepository$4.this.val$endDate : new Date();
                if (!(sampleDay == null || cmq.a(date, time))) {
                    SummariesRepository$4.this.fillSummary(sampleDay, date, time);
                    SummariesRepository$4.this.dummySummary(sampleDay, time);
                }
                SummariesRepository.access$300(SummariesRepository$4.this.this$0);
            }
        });
    }

    public void onDataNotAvailable() {
    }

    private void fillSummary(SampleDay sampleDay, Date date, Date date2) {
        MFLogger.d(SummariesRepository.access$900(this.this$0), "fillSummary: start = " + date + ", end = " + date2);
        for (Date h = cmq.h(date); !cmq.a(h, date2); h = cmq.h(h)) {
            dummySummary(sampleDay, h);
        }
    }

    private void dummySummary(SampleDay sampleDay, Date date) {
        if (sampleDay.getStepGoal() != 0) {
            Calendar instance = Calendar.getInstance();
            instance.setTime(date);
            SampleDay sampleDay2 = new SampleDay(instance.get(1), instance.get(2) + 1, instance.get(5), sampleDay.getTimezoneName(), sampleDay.getDstOffset(), 0.0d, 0.0d, 0.0d);
            sampleDay2.setGoal(sampleDay.getGoal());
            long currentTimeMillis = System.currentTimeMillis();
            sampleDay2.setCreatedAt(currentTimeMillis);
            sampleDay2.setUpdatedAt(currentTimeMillis);
            SummariesRepository.access$100(this.this$0).insert(sampleDay2);
        }
    }
}
