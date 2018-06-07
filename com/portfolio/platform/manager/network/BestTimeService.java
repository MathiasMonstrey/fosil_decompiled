package com.portfolio.platform.manager.network;

import android.os.Bundle;
import com.fossil.bbo;
import com.fossil.bbq;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.source.ActivitiesRepository;
import com.portfolio.platform.data.source.SleepSessionsRepository;
import com.portfolio.platform.data.source.SleepSummariesRepository;
import com.portfolio.platform.data.source.SummariesRepository;
import java.util.Date;

public class BestTimeService extends bbo {
    static final /* synthetic */ boolean $assertionsDisabled = (!BestTimeService.class.desiredAssertionStatus());
    private static final String TAG = BestTimeService.class.getSimpleName();
    public SleepSessionsRepository cBa;
    public ActivitiesRepository cxG;
    public SleepSummariesRepository mSleepSummariesRepository;
    public SummariesRepository mSummariesRepository;

    public void onCreate() {
        super.onCreate();
        PortfolioApp.ZQ().aam().a(this);
    }

    public int m15632a(bbq com_fossil_bbq) {
        Bundle extras = com_fossil_bbq.getExtras();
        String string = extras.getString("taskId");
        MFLogger.d(TAG, "onRunTask: id = " + string);
        if ($assertionsDisabled || string != null) {
            int i = -1;
            switch (string.hashCode()) {
                case -1761269779:
                    if (string.equals("ACTIVITIES")) {
                        i = 0;
                        break;
                    }
                    break;
                case -1153847524:
                    if (string.equals("SLEEP_SUMMARIES")) {
                        i = 5;
                        break;
                    }
                    break;
                case -1139657850:
                    if (string.equals("SUMMARY")) {
                        i = 1;
                        break;
                    }
                    break;
                case 5453476:
                    if (string.equals("SUMMARIES")) {
                        i = 2;
                        break;
                    }
                    break;
                case 487741733:
                    if (string.equals("SLEEP_SESSIONS")) {
                        i = 3;
                        break;
                    }
                    break;
                case 883714558:
                    if (string.equals("SLEEP_SUMMARY")) {
                        i = 4;
                        break;
                    }
                    break;
            }
            switch (i) {
                case 0:
                    this.cxG.getActivityList((Date) extras.getSerializable("START_DATE"), (Date) extras.getSerializable("END_DATE"), null);
                    break;
                case 1:
                    this.mSummariesRepository.getSummary((Date) extras.getSerializable("START_DATE"), null);
                    break;
                case 2:
                    this.mSummariesRepository.loadSummaries((Date) extras.getSerializable("START_DATE"), (Date) extras.getSerializable("END_DATE"), null);
                    break;
                case 3:
                    this.cBa.getSleepSessionList((Date) extras.getSerializable("START_DATE"), (Date) extras.getSerializable("END_DATE"), null);
                    break;
                case 4:
                    this.mSleepSummariesRepository.getSleepSummary((Date) extras.getSerializable("START_DATE"), null);
                    break;
                case 5:
                    this.mSleepSummariesRepository.loadSleepSummaries((Date) extras.getSerializable("START_DATE"), (Date) extras.getSerializable("END_DATE"), null);
                    break;
            }
            return 0;
        }
        throw new AssertionError();
    }
}
